package gwt.material.design.addins.client.autocomplete;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.addins.client.autocomplete.constants.AutocompleteType;
import gwt.material.design.client.base.*;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.client.base.mixin.ErrorMixin;
import gwt.material.design.client.base.mixin.ProgressMixin;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.ProgressType;
import gwt.material.design.client.ui.MaterialChip;
import gwt.material.design.client.ui.MaterialLabel;
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
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 *  <ma:autocomplete.MaterialAutoComplete ui:field="autocomplete" placeholder="States" />}
 * </pre>
 *
 * <h3>Java Usage:</h3>
 *
 * <p>
 * To use your domain object inside the MaterialAutoComplete, for example, an object
 * "User", you can subclass the {@link gwt.material.design.addins.client.autocomplete.base.MaterialSuggestionOracle} and {@link Suggestion}, like this:
 * </p>
 * <p><pre>
 * public class UserOracle extends MaterialSuggestionOracle {
 *     private List&lt;User&gt; contacts = new LinkedList&lt;&gt;();
 *
 *     public void addContacts(List&lt;User&gt; users){
 *         contacts.addAll(users);
 *     }
 *
 *     {@literal @}Override
 *     public void requestSuggestions(final Request request, final Callback callback) {
 *         Response resp = new Response();
 *         if (contacts.isEmpty()){
 *             callback.onSuggestionsReady(request, resp);
 *             return;
 *         }
 *         String text = request.getQuery();
 *         text = text.toLowerCase();
 *
 *         List&lt;UserSuggestion&gt; list = new ArrayList&lt;&gt;();
 *
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
 *
 * public class UserSuggestion implements SuggestOracle.Suggestion {
 *
 *     private User user;
 *
 *     public UserSuggestion(User user){
 *         this.user = user;
 *     }
 *
 *     {@literal @}Override
 *     public String getDisplayString() {
 *         return getReplacementString();
 *     }
 *
 *     {@literal @}Override
 *     public String getReplacementString() {
 *         return user.getName();
 *     }
 *
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
 *
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
public class MaterialAutoComplete extends MaterialWidget implements HasError, HasPlaceholder,
        HasValue<List<? extends Suggestion>>, HasProgress, HasKeyUpHandlers, HasType<AutocompleteType>, HasSelectionHandlers<Suggestion> {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectCss(MaterialAutocompleteDebugClientBundle.INSTANCE.autocompleteCssDebug());
        } else {
            MaterialResourceInjector.injectCss(MaterialAutocompleteClientBundle.INSTANCE.autocompleteCss());
        }
    }

    private Map<Suggestion, Widget> suggestionMap = new LinkedHashMap<>();

    private List<ListItem> itemsHighlighted = new ArrayList<>();
    private FlowPanel panel = new FlowPanel();
    private UnorderedList list = new UnorderedList();
    private SuggestOracle suggestions;
    private TextBox itemBox = new TextBox();
    private SuggestBox box;
    private int limit = 0;
    private MaterialLabel lblError = new MaterialLabel();
    private final ProgressMixin<MaterialAutoComplete> progressMixin = new ProgressMixin<>(this);
    
    private String selectedChipStyle = "blue white-text";
    private boolean directInputAllowed = true;
    private MaterialChipProvider chipProvider = new DefaultMaterialChipProvider();

    private final ErrorMixin<MaterialAutoComplete, MaterialLabel> errorMixin = new ErrorMixin<>(this,
            lblError, list);
    public final CssTypeMixin<AutocompleteType, MaterialAutoComplete> typeMixin = new CssTypeMixin<>(this);

    /**
     * Use MaterialAutocomplete to search for matches from local or remote data
     * sources.
     */
    public MaterialAutoComplete() {
        super(Document.get().createDivElement());
        add(panel);
    }

    public MaterialAutoComplete(AutocompleteType type) {
        this();
        setType(type);
    }

    /**
     * Use MaterialAutocomplete to search for matches from local or remote data
     * sources.
     *
     * @see #setSuggestions(SuggestOracle)
     */
    public MaterialAutoComplete(SuggestOracle suggestions) {
        this();
        generateAutoComplete(suggestions);
    }

    /**
     * Generate and build the List Items to be set on Auto Complete box.
     */
    private void generateAutoComplete(SuggestOracle suggestions) {
        list.setStyleName("multiValueSuggestBox-list");
        this.suggestions = suggestions;
        final ListItem item = new ListItem();

        item.setStyleName("multiValueSuggestBox-input-token");
        box = new SuggestBox(suggestions, itemBox);
        setLimit(this.limit);
        String autocompleteId = DOM.createUniqueId();
        itemBox.getElement().setId(autocompleteId);

        item.add(box);
        list.add(item);

        list.addDomHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                box.showSuggestionList();
            }
        }, ClickEvent.getType());

        itemBox.addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                boolean itemsChanged = false;

                switch (event.getNativeKeyCode()) {
                    case KeyCodes.KEY_ENTER:
                        if (directInputAllowed) {
                            String value = itemBox.getValue();
                            if (value != null && !(value = value.trim()).isEmpty()) {
                                gwt.material.design.client.base.Suggestion directInput = new gwt.material.design.client.base.Suggestion();
                                directInput.setDisplay(value);
                                directInput.setSuggestion(value);
                                itemsChanged = addItem(directInput);
                                itemBox.setValue("");
                                itemBox.setFocus(true);
                            }
                        }
                        break;

                    case KeyCodes.KEY_BACKSPACE:
                        if (itemBox.getValue().trim().isEmpty()) {
                            if (itemsHighlighted.isEmpty()) {
                                if (suggestionMap.size() > 0) {

                                    ListItem li = (ListItem) list.getWidget(list.getWidgetCount() - 2);
                                    MaterialChip p = (MaterialChip) li.getWidget(0);
                                    
                                    boolean removable = true;
                                    
                                    Set<Entry<Suggestion, Widget>> entrySet = suggestionMap.entrySet();
                                    for (Entry<Suggestion, Widget> entry : entrySet) {
                                        if (p.equals(entry.getValue())) {
                                            if (chipProvider.isChipRemovable(entry.getKey())){
                                                suggestionMap.remove(entry.getKey());
                                                itemsChanged = true;                                                
                                            }
                                            else {
                                                removable = false;
                                            }
                                            break;
                                        }
                                    }

                                    if (removable){
                                        list.remove(li);                                        
                                    }
                                }
                            }
                        }

                    case KeyCodes.KEY_DELETE:
                        if (itemBox.getValue().trim().isEmpty()) {
                            for (ListItem li : itemsHighlighted) {
                                MaterialChip p = (MaterialChip) li.getWidget(0);
                                
                                boolean removable = true;
                                
                                Set<Entry<Suggestion, Widget>> entrySet = suggestionMap.entrySet();
                                for (Entry<Suggestion, Widget> entry : entrySet) {
                                    if (p.equals(entry.getValue())) {
                                        if (chipProvider.isChipRemovable(entry.getKey())){
                                            suggestionMap.remove(entry.getKey());
                                            itemsChanged = true;                                            
                                        }
                                        else {
                                            removable = false;
                                        }
                                        break;
                                    }
                                }
                                
                                if (removable){
                                    li.removeFromParent();                                   
                                }
                            }
                            itemsHighlighted.clear();
                        }
                        itemBox.setFocus(true);
                        break;
                }

                if (itemsChanged) {
                    ValueChangeEvent.fire(MaterialAutoComplete.this, getValue());
                }
            }
        });

        itemBox.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                box.showSuggestionList();
            }
        });

        box.addSelectionHandler(new SelectionHandler<Suggestion>() {
            public void onSelection(SelectionEvent<Suggestion> selectionEvent) {
                Suggestion selectedItem = selectionEvent.getSelectedItem();
                itemBox.setValue("");
                if (addItem(selectedItem)) {
                    ValueChangeEvent.fire(MaterialAutoComplete.this, getValue());
                }
                itemBox.setFocus(true);
            }
        });

        panel.add(list);
        panel.getElement().setAttribute("onclick",
                "document.getElementById('" + autocompleteId + "').focus()");
        panel.add(lblError);
        box.setFocus(true);
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
        displayItem.setStyleName("multiValueSuggestBox-token");

        if (getType() == AutocompleteType.TEXT){
            suggestionMap.clear();
            itemBox.setText(suggestion.getDisplayString());
            displayItem.add(itemBox);
        }
        else {
            final MaterialChip chip = chipProvider.getChip(suggestion);
            if (chip == null) {
                return false;
            }

            chip.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent clickEvent) {
                    if (chipProvider.isChipSelectable(suggestion)){
                        if (itemsHighlighted.contains(displayItem)) {
                            chip.removeStyleName(selectedChipStyle);
                            itemsHighlighted.remove(displayItem);
                        } else {
                            chip.addStyleName(selectedChipStyle);
                            itemsHighlighted.add(displayItem);
                        }
                    }
                }
            });                
            
            if (chip.getIcon() != null){
                chip.getIcon().addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent clickEvent) {
                        if (chipProvider.isChipRemovable(suggestion)){
                            suggestionMap.remove(suggestion);
                            list.remove(displayItem);
                            itemsHighlighted.remove(displayItem);
                            ValueChangeEvent.fire(MaterialAutoComplete.this, getValue());
                            box.showSuggestionList();
                        }
                    }
                });                
            }

            suggestionMap.put(suggestion, chip);
            displayItem.add(chip);
        }

        list.insert(displayItem, list.getWidgetCount() - 1);
        return true;
    }

    /**
     * Clear the chip items on the autocomplete box
     */
    public void clear() {
        itemBox.setValue("");

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
     * @param itemValues
     *            the itemsSelected to set
     * @see #setValue(List)
     */
    public void setItemValues(List<String> itemValues) {
        if (itemValues == null) {
            clear();
            return;
        }
        List<Suggestion> list = new ArrayList<>(itemValues.size());
        for (String value : itemValues) {
            Suggestion suggestion = new gwt.material.design.client.base.Suggestion(value, value);
            list.add(suggestion);
        }
        setValue(list);
    }

    /**
     * @return the itemsHighlighted
     */
    public List<ListItem> getItemsHighlighted() {
        return itemsHighlighted;
    }

    /**
     * @param itemsHighlighted
     *            the itemsHighlighted to set
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
     * @param suggestions
     *            the suggestion oracle to set
     */
    public void setSuggestions(SuggestOracle suggestions) {
        this.suggestions = suggestions;
        generateAutoComplete(suggestions);
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
        if (this.box != null) {
            this.box.setLimit(limit);
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

    @Override
    public void setError(String error) {
        errorMixin.setError(error);
    }

    @Override
    public void setSuccess(String success) {
        errorMixin.setSuccess(success);
    }

    @Override
    public void clearErrorOrSuccess() {
        errorMixin.clearErrorOrSuccess();
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
     *         should be allowed. By default directInputAllowed is
     *         <code>true</code>.
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
     * @param selectedChipStyle
     *          The class or classes to be applied to selected chips
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
    public void showProgress(ProgressType type) {
        progressMixin.showProgress(ProgressType.INDETERMINATE);
    }

    @Override
    public void setPercent(double percent) {
        progressMixin.setPercent(percent);
    }

    @Override
    public void hideProgress() {
        progressMixin.hideProgress();
    }

    @Override
    public HandlerRegistration addKeyUpHandler(final KeyUpHandler handler) {
        return itemBox.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                if(isEnabled()){
                    handler.onKeyUp(event);
                }
            }
        });
    }

    @Override
    public void setType(AutocompleteType type) {
        typeMixin.setType(type);
    }

    @Override
    public AutocompleteType getType() {
        return typeMixin.getType();
    }

    @Override
    public HandlerRegistration addSelectionHandler(final SelectionHandler<Suggestion> handler) {
        return addHandler(new SelectionHandler<Suggestion>() {
            @Override
            public void onSelection(SelectionEvent<Suggestion> event) {
                if(isEnabled()){
                    handler.onSelection(event);
                }
            }
        }, SelectionEvent.getType());
    }

    /**
     * Interface that defines how a {@link MaterialChip} is created, given a
     * {@link Suggestion}.
     *
     * @see gwt.material.design.addins.client.autocomplete.MaterialAutoComplete#setChipProvider(MaterialChipProvider)
     */
    public static interface MaterialChipProvider {

        /**
         * Creates and returns a {@link MaterialChip} based on the selected
         * {@link Suggestion}.
         *
         * @param suggestion
         *            the selected {@link Suggestion}
         *
         * @return the created MaterialChip, or <code>null</code> if the
         *         suggestion should be ignored.
         */
        MaterialChip getChip(Suggestion suggestion);
        
        /**
         * Returns whether the chip defined by the suggestion should be selected when the user clicks on it.
         * 
         * <p>
         * Selecion of chips is used to batch remove suggestions, for example.
         * </p>
         * 
         * @param suggestion
         *            the selected {@link Suggestion}
         *            
         * @see MaterialAutoComplete#setSelectedChipStyle(String) 
         */
        boolean isChipSelectable(Suggestion suggestion);
        
        /**
         * Returns whether the chip defined by the suggestion should be removed from the autocomplete when clicked on its icon.
         * 
         * <p>
         * Override this method returning <code>false</code> to implement your own logic when the user clicks on the chip icon.
         * </p>
         * 
         * @param suggestion
         *            the selected {@link Suggestion}
         */
        boolean isChipRemovable(Suggestion suggestion);
    }

    /**
     * Default implementation of the {@link MaterialChipProvider} interface,
     * used by the {@link gwt.material.design.addins.client.autocomplete.MaterialAutoComplete}.
     * 
     * <p>
     * By default all chips are selectable and removable. The default {@link IconType} used by the chips provided is the {@link IconType#CLOSE}.
     * </p> 
     *
     * @see gwt.material.design.addins.client.autocomplete.MaterialAutoComplete#setChipProvider(MaterialChipProvider)
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

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<List<? extends Suggestion>> handler) {
        return addHandler(new ValueChangeHandler<List<? extends Suggestion>>() {
            @Override
            public void onValueChange(ValueChangeEvent<List<? extends Suggestion>> event) {
                if(isEnabled()){
                    handler.onValueChange(event);
                }
            }
        }, ValueChangeEvent.getType());
    }

    /**
     * Returns the selected {@link Suggestion}s. Modifications to the list are
     * not propagated to the component.
     *
     * @return the list of selected {@link Suggestion}s, or empty if none was
     *         selected (never <code>null</code>).
     */
    @Override
    public List<? extends Suggestion> getValue() {
        return new ArrayList<>(suggestionMap.keySet());
    }

    @Override
    public void setValue(List<? extends Suggestion> value) {
        setValue(value, false);
    }

    @Override
    public void setValue(List<? extends Suggestion> value, boolean fireEvents) {
        clear();
        if (value != null) {
            for (Suggestion suggestion : value) {
                addItem(suggestion);
            }
        }
        if (fireEvents) {
            ValueChangeEvent.fire(this, getValue());
        }
    }
}
