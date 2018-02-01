/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.addins.client.autocomplete;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.autocomplete.constants.AutocompleteType;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.*;
import gwt.material.design.client.base.mixin.*;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.ProgressType;
import gwt.material.design.client.ui.MaterialChip;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialProgress;
import gwt.material.design.client.ui.html.Label;
import gwt.material.design.client.ui.html.ListItem;
import gwt.material.design.client.ui.html.UnorderedList;

import java.util.*;
import java.util.Map.Entry;

//@formatter:off

/**
 * <p>
 * Use GWT Autocomplete to search for matches from local or remote data sources.
 * We used MultiWordSuggestOracle to populate the list to be added on the
 * autocomplete values.
 * </p>
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 *  <ma:autocomplete.MaterialAutoComplete ui:field="autocomplete" placeholder="States" />}
 * </pre>
 * <p>
 * <h3>Java Usage:</h3>
 * <p>
 * <p>
 * To use your domain object inside the MaterialAutoComplete, for example, an object
 * "User", you can subclass the {@link gwt.material.design.addins.client.autocomplete.base.MaterialSuggestionOracle} and {@link Suggestion}, like this:
 * </p>
 * <p><pre>
 * public class UserOracle extends MaterialSuggestionOracle {
 *     private List&lt;User&gt; contacts = new LinkedList&lt;&gt;();
 * <p>
 *     public void addContacts(List&lt;User&gt; users){
 *         contacts.addAll(users);
 *     }
 * <p>
 *     {@literal @}Override
 *     public void requestSuggestions(final Request request, final Callback callback) {
 *         Response resp = new Response();
 *         if (contacts.isEmpty()){
 *             callback.onSuggestionsReady(request, resp);
 *             return;
 *         }
 *         String text = request.getQuery();
 *         text = text.toLowerCase();
 * <p>
 *         List&lt;UserSuggestion&gt; list = new ArrayList&lt;&gt;();
 * <p>
 *         /{@literal *}
 *         {@literal *}  Finds the contacts that meets the criteria. Note that since the
 *         {@literal *}  requestSuggestions method is asynchronous, you can fetch the
 *         {@literal *}  results from the server instead of using a local contacts List.
 *         {@literal *}/
 *         for (User contact : contacts){
 *             if (contact.getName().toLowerCase().contains(text)){
 *                 list.add(new UserSuggestion(contact));
 *             }
 *          }
 *          resp.setSuggestions(list);
 *          callback.onSuggestionsReady(request, resp);
 *     }
 * }
 * <p>
 * public class UserSuggestion implements SuggestOracle.Suggestion {
 * <p>
 *     private User user;
 * <p>
 *     public UserSuggestion(User user){
 *         this.user = user;
 *     }
 * <p>
 *     {@literal @}Override
 *     public String getDisplayString() {
 *         return getReplacementString();
 *     }
 * <p>
 *     {@literal @}Override
 *     public String getReplacementString() {
 *         return user.getName();
 *     }
 * <p>
 *     public User getUser() {
 *         return user;
 *     }
 * }
 * </pre></p>
 * <p>
 * And then use the UserOracle like this:
 * </p>
 * <p><pre>
 * //Constructor
 * MaterialAutoComplete userAutoComplete = new MaterialAutoComplete(new UserOracle());
 * <p>
 * //How to get the selected User objects
 * public List&lt;User&gt; getSelectedUsers(){
 *     List&lt;? extends Suggestion&gt; values = userAutoComplete.getValue();
 *     List&lt;User&gt; users = new ArrayList&lt;&gt;(values.size());
 *     for (Suggestion value : values) {
 *         if (value instanceof UserSuggestion){
 *             UserSuggestion us = (UserSuggestion) value;
 *             User user = us.getUser();
 *             users.add(user);
 *         }
 *     }
 *     return users;
 * }
 * </pre></p>
 *
 * @author kevzlou7979
 * @author gilberto-torrezan
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#!autocomplete">Material AutoComplete</a>
 */
// @formatter:on
public class MaterialAutoComplete extends AbstractValueWidget<List<? extends Suggestion>> implements HasPlaceholder,
        HasProgress, HasType<AutocompleteType>, HasSelectionHandlers<Suggestion>, HasReadOnly {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialAutocompleteDebugClientBundle.INSTANCE.autocompleteCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialAutocompleteClientBundle.INSTANCE.autocompleteCss());
        }
    }

    private int limit = 0;
    private boolean directInputAllowed = true;
    private String selectedChipStyle = "blue white-text";
    private Map<Suggestion, Widget> suggestionMap = new LinkedHashMap<>();
    private Label label = new Label();
    private List<ListItem> itemsHighlighted = new ArrayList<>();
    private FlowPanel panel = new FlowPanel();
    private UnorderedList list = new UnorderedList();
    private SuggestOracle suggestions;
    private TextBox itemBox = new TextBox();
    private SuggestBox suggestBox = new SuggestBox();
    private MaterialLabel errorLabel = new MaterialLabel();
    private MaterialChipProvider chipProvider = new DefaultMaterialChipProvider();

    private ErrorMixin<AbstractValueWidget, MaterialLabel> errorMixin;
    private ProgressMixin<MaterialAutoComplete> progressMixin;
    private FocusableMixin<MaterialWidget> focusableMixin;
    private ReadOnlyMixin<MaterialAutoComplete, TextBox> readOnlyMixin;
    private CssTypeMixin<AutocompleteType, MaterialAutoComplete> typeMixin;

    /**
     * Use MaterialAutocomplete to search for matches from local or remote data
     * sources.
     */
    public MaterialAutoComplete() {
        super(Document.get().createDivElement(), AddinsCssName.AUTOCOMPLETE, CssName.INPUT_FIELD);
        add(panel);
    }

    public MaterialAutoComplete(AutocompleteType type) {
        this();
        setType(type);
    }

    public MaterialAutoComplete(String placeholder) {
        this();
        setPlaceholder(placeholder);
    }

    /**
     * Use MaterialAutocomplete to search for matches from local or remote data
     * sources.
     *
     * @see #setSuggestions(SuggestOracle)
     */
    public MaterialAutoComplete(SuggestOracle suggestions) {
        this();
        setup(suggestions);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        registerHandler(list.addDomHandler(event -> suggestBox.showSuggestionList(), ClickEvent.getType()));

        registerHandler(itemBox.addBlurHandler(blurEvent -> {
            if (getValue().size() > 0) {
                label.addStyleName(CssName.ACTIVE);
            }
        }));

        registerHandler(itemBox.addKeyDownHandler(event -> {
            boolean changed = false;

            switch (event.getNativeKeyCode()) {
                case KeyCodes.KEY_ENTER:
                    if (directInputAllowed) {
                        String value = itemBox.getValue();
                        if (value != null && !(value = value.trim()).isEmpty()) {
                            gwt.material.design.client.base.Suggestion directInput = new gwt.material.design.client.base.Suggestion();
                            directInput.setDisplay(value);
                            directInput.setSuggestion(value);
                            changed = addItem(directInput);
                            if (getType() == AutocompleteType.TEXT) {
                                itemBox.setText(value);
                            } else {
                                itemBox.setValue("");
                            }
                            itemBox.setFocus(true);
                        }
                    }
                    break;
                case KeyCodes.KEY_BACKSPACE:
                    if (itemBox.getValue().trim().isEmpty()) {
                        if (itemsHighlighted.isEmpty()) {
                            if (suggestionMap.size() > 0) {
                                ListItem li = (ListItem) list.getWidget(list.getWidgetCount() - 2);

                                if (tryRemoveSuggestion(li.getWidget(0))) {
                                    li.removeFromParent();
                                    changed = true;
                                }
                            }
                        }
                    }
                case KeyCodes.KEY_DELETE:
                    if (itemBox.getValue().trim().isEmpty()) {
                        for (ListItem li : itemsHighlighted) {
                            if (tryRemoveSuggestion(li.getWidget(0))) {
                                li.removeFromParent();
                                changed = true;
                            }
                        }
                        itemsHighlighted.clear();
                    }
                    itemBox.setFocus(true);
                    break;
            }

            if (changed) {
                ValueChangeEvent.fire(MaterialAutoComplete.this, getValue());
            }
        }));

        registerHandler(itemBox.addClickHandler(event -> suggestBox.showSuggestionList()));

        registerHandler(suggestBox.addSelectionHandler(selectionEvent -> {
            Suggestion selectedItem = selectionEvent.getSelectedItem();
            itemBox.setValue("");
            if (addItem(selectedItem)) {
                ValueChangeEvent.fire(MaterialAutoComplete.this, getValue());
            }
            itemBox.setFocus(true);
        }));
    }

    /**
     * Generate and build the List Items to be set on Auto Complete box.
     */
    protected void setup(SuggestOracle suggestions) {
        list.setStyleName(AddinsCssName.MULTIVALUESUGGESTBOX_LIST);
        this.suggestions = suggestions;
        final ListItem item = new ListItem();

        item.setStyleName(AddinsCssName.MULTIVALUESUGGESTBOX_INPUT_TOKEN);
        suggestBox = new SuggestBox(suggestions, itemBox);
        setLimit(this.limit);
        String autocompleteId = DOM.createUniqueId();
        itemBox.getElement().setId(autocompleteId);

        item.add(suggestBox);
        item.add(label);
        list.add(item);

        panel.add(list);
        panel.getElement().setAttribute("onclick",
            "document.getElementById('" + autocompleteId + "').focus()");
        panel.add(errorLabel);
        suggestBox.setFocus(true);
    }

    protected boolean tryRemoveSuggestion(Widget widget) {
        Set<Entry<Suggestion, Widget>> entrySet = suggestionMap.entrySet();
        for (Entry<Suggestion, Widget> entry : entrySet) {
            if (widget.equals(entry.getValue())) {
                if (chipProvider.isChipRemovable(entry.getKey())) {
                    suggestionMap.remove(entry.getKey());
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * Adding the item value using Material Chips added on auto complete box
     */
    protected boolean addItem(final Suggestion suggestion) {
        SelectionEvent.fire(MaterialAutoComplete.this, suggestion);
        if (getLimit() > 0) {
            if (suggestionMap.size() >= getLimit()) {
                return false;
            }
        }

        if (suggestionMap.containsKey(suggestion)) {
            return false;
        }

        final ListItem displayItem = new ListItem();
        displayItem.setStyleName(AddinsCssName.MULTIVALUESUGGESTBOX_TOKEN);

        if (getType() == AutocompleteType.TEXT) {
            suggestionMap.clear();
            itemBox.setText(suggestion.getReplacementString());
        } else {
            final MaterialChip chip = chipProvider.getChip(suggestion);
            if (chip == null) {
                return false;
            }

            registerHandler(chip.addClickHandler(event -> {
                if (chipProvider.isChipSelectable(suggestion)) {
                    if (itemsHighlighted.contains(displayItem)) {
                        chip.removeStyleName(selectedChipStyle);
                        itemsHighlighted.remove(displayItem);
                    } else {
                        chip.addStyleName(selectedChipStyle);
                        itemsHighlighted.add(displayItem);
                    }
                }
            }));

            if (chip.getIcon() != null) {
                registerHandler(chip.getIcon().addClickHandler(event -> {
                    if (chipProvider.isChipRemovable(suggestion)) {
                        suggestionMap.remove(suggestion);
                        list.remove(displayItem);
                        itemsHighlighted.remove(displayItem);
                        ValueChangeEvent.fire(MaterialAutoComplete.this, getValue());
                        suggestBox.showSuggestionList();
                    }
                }));
            }

            suggestionMap.put(suggestion, chip);
            displayItem.add(chip);
            list.insert(displayItem, list.getWidgetCount() - 1);
        }
        return true;
    }

    /**
     * Clear the chip items on the autocomplete box
     */
    public void clear() {
        itemBox.setValue("");
        label.removeStyleName(CssName.ACTIVE);

        Collection<Widget> values = suggestionMap.values();
        for (Widget widget : values) {
            Widget parent = widget.getParent();
            if (parent instanceof ListItem) {
                parent.removeFromParent();
            }
        }
        suggestionMap.clear();

        clearErrorOrSuccess();
    }

    @Override
    public void showProgress(ProgressType type) {
        getProgressMixin().showProgress(ProgressType.INDETERMINATE);
    }

    @Override
    public void setPercent(double percent) {
        getProgressMixin().setPercent(percent);
    }

    @Override
    public void hideProgress() {
        getProgressMixin().hideProgress();
    }

    @Override
    public MaterialProgress getProgress() {
        return getProgressMixin().getProgress();
    }

    /**
     * @return the item values on autocomplete
     * @see #getValue()
     */
    public List<String> getItemValues() {
        Set<Suggestion> keySet = suggestionMap.keySet();
        List<String> values = new ArrayList<>(keySet.size());
        for (Suggestion suggestion : keySet) {
            values.add(suggestion.getReplacementString());
        }
        return values;
    }

    /**
     * @param itemValues the itemsSelected to set
     * @see #setValue(Object)
     */
    public void setItemValues(List<String> itemValues) {
        setItemValues(itemValues, false);
    }

    /**
     * @param itemValues the itemsSelected to set
     * @param fireEvents will fire value change event if true
     * @see #setValue(Object)
     */
    public void setItemValues(List<String> itemValues, boolean fireEvents) {
        if (itemValues == null) {
            clear();
            return;
        }
        List<Suggestion> list = new ArrayList<>(itemValues.size());
        for (String value : itemValues) {
            Suggestion suggestion = new gwt.material.design.client.base.Suggestion(value, value);
            list.add(suggestion);
        }
        setValue(list, fireEvents);
        if (itemValues.size() > 0) {
            label.addStyleName(CssName.ACTIVE);
        }
    }

    /**
     * @return the itemsHighlighted
     */
    public List<ListItem> getItemsHighlighted() {
        return itemsHighlighted;
    }

    /**
     * @param itemsHighlighted the itemsHighlighted to set
     */
    public void setItemsHighlighted(List<ListItem> itemsHighlighted) {
        this.itemsHighlighted = itemsHighlighted;
    }

    /**
     * @return the suggestion oracle
     */
    public SuggestOracle getSuggestions() {
        return suggestions;
    }

    /**
     * Sets the SuggestOracle to be used to provide suggestions. Also setups the
     * component with the needed event handlers and UI elements.
     *
     * @param suggestions the suggestion oracle to set
     */
    public void setSuggestions(SuggestOracle suggestions) {
        this.suggestions = suggestions;
        setup(suggestions);
    }

    public void setSuggestions(SuggestOracle suggestions, AutocompleteType type) {
        setType(type);
        setSuggestions(suggestions);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
        if (this.suggestBox != null) {
            this.suggestBox.setLimit(limit);
        }
    }

    /**
     * Set the number of suggestions to be displayed to the user. This differs from
     * setLimit() which set both the suggestions displayed AND the limit of values
     * allowed within the autocomplete.
     * @param limit
     */
    public void setAutoSuggestLimit(int limit) {
        if (this.suggestBox != null) {
            this.suggestBox.setLimit(limit);
        }
    }

    @Override
    public String getPlaceholder() {
        return itemBox.getElement().getAttribute("placeholder");
    }

    @Override
    public void setPlaceholder(String placeholder) {
        itemBox.getElement().setAttribute("placeholder", placeholder);
    }

    /**
     * @see gwt.material.design.client.ui.MaterialValueBox#setLabel(String)
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label.setText(label);
        if (!getPlaceholder().isEmpty()) {
            this.label.setStyleName(CssName.ACTIVE);
        }
    }

    /**
     * Gets the current {@link MaterialChipProvider}. By default, the class uses
     * an instance of {@link DefaultMaterialChipProvider}.
     */
    public MaterialChipProvider getChipProvider() {
        return chipProvider;
    }

    /**
     * Sets a {@link MaterialChipProvider} that can customize how the
     * {@link MaterialChip} is created for each selected {@link Suggestion}.
     */
    public void setChipProvider(MaterialChipProvider chipProvider) {
        this.chipProvider = chipProvider;
    }

    /**
     * When set to <code>false</code>, only {@link Suggestion}s from the
     * SuggestionOracle are accepted. Direct input create by the user is
     * ignored. By default, direct input is allowed.
     */
    public void setDirectInputAllowed(boolean directInputAllowed) {
        this.directInputAllowed = directInputAllowed;
    }

    /**
     * @return if {@link Suggestion}s created by direct input from the user
     * should be allowed. By default directInputAllowed is
     * <code>true</code>.
     */
    public boolean isDirectInputAllowed() {
        return directInputAllowed;
    }

    /**
     * Sets the style class applied to chips when they are selected.
     * <p>
     * Defaults to "blue white-text".
     * </p>
     *
     * @param selectedChipStyle The class or classes to be applied to selected chips
     */
    public void setSelectedChipStyle(String selectedChipStyle) {
        this.selectedChipStyle = selectedChipStyle;
    }

    /**
     * Returns the style class applied to chips when they are selected.
     * <p>
     * Defaults to "blue white-text".
     * </p>
     */
    public String getSelectedChipStyle() {
        return selectedChipStyle;
    }

    @Override
    public void setType(AutocompleteType type) {
        getTypeMixin().setType(type);
    }

    @Override
    public AutocompleteType getType() {
        return getTypeMixin().getType();
    }

    @Override
    public void setReadOnly(boolean value) {
        getReadOnlyMixin().setReadOnly(value);
        if (value) {
            setEnabled(false);
        }
    }

    @Override
    public boolean isReadOnly() {
        return getReadOnlyMixin().isReadOnly();
    }

    @Override
    public void setToggleReadOnly(boolean toggle) {
        getReadOnlyMixin().setToggleReadOnly(toggle);
    }

    @Override
    public boolean isToggleReadOnly() {
        return getReadOnlyMixin().isToggleReadOnly();
    }

    /**
     * Interface that defines how a {@link MaterialChip} is created, given a
     * {@link Suggestion}.
     *
     * @see MaterialAutoComplete#setChipProvider(MaterialChipProvider)
     */
    public interface MaterialChipProvider {

        /**
         * Creates and returns a {@link MaterialChip} based on the selected
         * {@link Suggestion}.
         *
         * @param suggestion the selected {@link Suggestion}
         * @return the created MaterialChip, or <code>null</code> if the
         * suggestion should be ignored.
         */
        MaterialChip getChip(Suggestion suggestion);

        /**
         * Returns whether the chip defined by the suggestion should be selected when the user clicks on it.
         * <p>
         * <p>
         * Selecion of chips is used to batch remove suggestions, for example.
         * </p>
         *
         * @param suggestion the selected {@link Suggestion}
         * @see MaterialAutoComplete#setSelectedChipStyle(String)
         */
        boolean isChipSelectable(Suggestion suggestion);

        /**
         * Returns whether the chip defined by the suggestion should be removed from the autocomplete when clicked on its icon.
         * <p>
         * <p>
         * Override this method returning <code>false</code> to implement your own logic when the user clicks on the chip icon.
         * </p>
         *
         * @param suggestion the selected {@link Suggestion}
         */
        boolean isChipRemovable(Suggestion suggestion);
    }

    /**
     * Default implementation of the {@link MaterialChipProvider} interface,
     * used by the {@link MaterialAutoComplete}.
     * <p>
     * <p>
     * By default all chips are selectable and removable. The default {@link IconType} used by the chips provided is the {@link IconType#CLOSE}.
     * </p>
     *
     * @see MaterialAutoComplete#setChipProvider(MaterialChipProvider)
     */
    public static class DefaultMaterialChipProvider implements MaterialChipProvider {

        @Override
        public MaterialChip getChip(Suggestion suggestion) {
            final MaterialChip chip = new MaterialChip();

            String imageChip = suggestion.getDisplayString();
            String textChip = imageChip;

            String s = "<img src=\"";
            if (imageChip.contains(s)) {
                int ix = imageChip.indexOf(s) + s.length();
                imageChip = imageChip.substring(ix, imageChip.indexOf("\"", ix + 1));
                chip.setUrl(imageChip);
                textChip = textChip.replaceAll("[<](/)?img[^>]*[>]", "");
            }
            chip.setText(textChip);
            chip.setIconType(IconType.CLOSE);

            return chip;
        }

        @Override
        public boolean isChipRemovable(Suggestion suggestion) {
            return true;
        }

        @Override
        public boolean isChipSelectable(Suggestion suggestion) {
            return true;
        }
    }

    /**
     * Returns the selected {@link Suggestion}s. Modifications to the list are
     * not propagated to the component.
     *
     * @return the list of selected {@link Suggestion}s, or empty if none was
     * selected (never <code>null</code>).
     */
    @Override
    public List<? extends Suggestion> getValue() {
        return new ArrayList<>(suggestionMap.keySet());
    }

    @Override
    public void setValue(List<? extends Suggestion> value, boolean fireEvents) {
        clear();
        if (value != null) {
            label.addStyleName(CssName.ACTIVE);
            for (Suggestion suggestion : value) {
                addItem(suggestion);
            }
        }
        super.setValue(value, fireEvents);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        itemBox.setEnabled(enabled);
    }

    public Label getLabel() {
        return label;
    }

    public TextBox getItemBox() {
        return itemBox;
    }

    public MaterialLabel getErrorLabel() {
        return errorLabel;
    }

    public SuggestBox getSuggestBox() {
        return suggestBox;
    }

    @Override
    public HandlerRegistration addKeyUpHandler(final KeyUpHandler handler) {
        return itemBox.addKeyUpHandler(event -> {
            if (isEnabled()) {
                handler.onKeyUp(event);
            }
        });
    }

    @Override
    public HandlerRegistration addSelectionHandler(final SelectionHandler<Suggestion> handler) {
        return addHandler(new SelectionHandler<Suggestion>() {
            @Override
            public void onSelection(SelectionEvent<Suggestion> event) {
                if (isEnabled()) {
                    handler.onSelection(event);
                }
            }
        }, SelectionEvent.getType());
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<List<? extends Suggestion>> handler) {
        return addHandler(new ValueChangeHandler<List<? extends Suggestion>>() {
            @Override
            public void onValueChange(ValueChangeEvent<List<? extends Suggestion>> event) {
                if (isEnabled()) {
                    handler.onValueChange(event);
                }
            }
        }, ValueChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addBlurHandler(BlurHandler handler) {
        return itemBox.addHandler(blurEvent -> {
            if (isEnabled()) {
                handler.onBlur(blurEvent);
            }
        }, BlurEvent.getType());
    }

    @Override
    public HandlerRegistration addFocusHandler(FocusHandler handler) {
        return itemBox.addHandler(focusEvent -> {
            if (isEnabled()) {
                handler.onFocus(focusEvent);
            }
        }, FocusEvent.getType());
    }

    protected ProgressMixin<MaterialAutoComplete> getProgressMixin() {
        if (progressMixin == null) {
            progressMixin = new ProgressMixin<>(this);
        }
        return progressMixin;
    }

    protected CssTypeMixin<AutocompleteType, MaterialAutoComplete> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin<>(this, this);
        }
        return typeMixin;
    }

    @Override
    public ErrorMixin<AbstractValueWidget, MaterialLabel> getErrorMixin() {
        if (errorMixin == null) {
            errorMixin = new ErrorMixin<>(this, errorLabel, list, label);
        }
        return errorMixin;
    }

    protected ReadOnlyMixin<MaterialAutoComplete, TextBox> getReadOnlyMixin() {
        if (readOnlyMixin == null) {
            readOnlyMixin = new ReadOnlyMixin<>(this, itemBox);
        }
        return readOnlyMixin;
    }

    @Override
    protected FocusableMixin<MaterialWidget> getFocusableMixin() {
        if (focusableMixin == null) {
            focusableMixin = new FocusableMixin<>(new MaterialWidget(itemBox.getElement()));
        }
        return focusableMixin;
    }
}