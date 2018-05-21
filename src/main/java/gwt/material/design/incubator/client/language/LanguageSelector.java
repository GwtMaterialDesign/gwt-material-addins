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
package gwt.material.design.incubator.client.language;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasActivates;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

import java.util.ArrayList;
import java.util.List;

/**
 * A widget that provides a selection of {@link LanguageSelectorItem} for the site Internationalization (i18n)
 * <p>
 * <p><i>
 * Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
public class LanguageSelector extends MaterialWidget
        implements HasValue<Language>, HasType<LanguageSelectorType> {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(LanguageSelectorDebugClientBundle.INSTANCE.languageSelectorDebugCss());
        } else {
            MaterialDesignBase.injectCss(LanguageSelectorClientBundle.INSTANCE.languageSelectorCss());
        }
    }

    private MaterialImage imageActivator = new MaterialImage();
    private MaterialLink textActivator = new MaterialLink();
    private MaterialDropDown dropdown = new MaterialDropDown();
    private List<Language> languages = new ArrayList<>();
    private Language language;
    private CssTypeMixin<LanguageSelectorType, LanguageSelector> typeMixin;

    public LanguageSelector() {
        super(Document.get().createDivElement(), IncubatorCssName.LANGUAGE_SELECTOR);
        setType(LanguageSelectorType.TEXT);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        IncubatorWidget.showWarning(this);
        dropdown.clear();
        languages.forEach(language -> dropdown.add(new LanguageSelectorItem(language)));
        dropdown.setConstrainWidth(false);
        add(dropdown);
        registerHandler(dropdown.addSelectionHandler(selectionEvent -> {
            if (selectionEvent.getSelectedItem() instanceof LanguageSelectorItem) {
                Language language = ((LanguageSelectorItem) selectionEvent.getSelectedItem()).getLanguage();

                if (this.language != language) {
                    setValue(language, true);

                    // Navigate to selected language value / locale and reload the browser
                    String param = Window.Location.createUrlBuilder().setParameter("locale", language.getValue()).buildString();
                    Window.Location.replace(param);
                }
            }
        }));

        // Get the current locale inside the browser url
        String currentLocale = Window.Location.getParameter("locale");
        if (languages.size() != 0) {
            Language currentLanguage = languages.stream().filter(language -> language.getValue().equals(currentLocale)).findFirst().orElse(languages.get(0));
            setValue(currentLanguage, true);
            if (languages.size() == 1) {
                addStyleName(IncubatorCssName.SINGLE_LANGUAGE);
            } else {
                removeStyleName(IncubatorCssName.SINGLE_LANGUAGE);
            }
        } else {
            GWT.log("Please add at least one language for this selector.");
        }
    }

    /**
     * Ability to add language item {@link Language}
     * contains name, value and imageActivator url
     */
    public void addLanguage(Language language) {
        languages.add(language);
    }

    /**
     * Set lists of languages and repopulate inside the Language Selector Dropdown component
     */
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    /**
     * Get the lists of registered languages of this selector component
     */
    public List<Language> getLanguages() {
        return languages;
    }

    @Override
    public Language getValue() {
        return language;
    }

    @Override
    public void setValue(Language language) {
        setValue(language, false);
    }

    @Override
    public void setValue(Language language, boolean fireEvents) {
        this.language = language;

        if (getType() == LanguageSelectorType.TEXT) {
            textActivator.setText(language.getName());
        } else {
            imageActivator.setUrl(language.getImage());
        }

        if (fireEvents) {
            ValueChangeEvent.fire(this, language);
        }
    }

    @Override
    public void setType(LanguageSelectorType type) {
        getTypeMixin().setType(type);

        if (isAttached()) {
            applyType(type);
        } else {
            registerHandler(addAttachHandler(attachEvent -> applyType(type)));
        }
    }

    protected void applyType(LanguageSelectorType type) {
        if (type == LanguageSelectorType.TEXT) {
            textActivator.setIconPosition(IconPosition.RIGHT);
            setActivator(textActivator);
        } else {
            setActivator(imageActivator);
        }
    }

    protected <T extends MaterialWidget & HasActivates> void setActivator(T widget) {
        String activator = DOM.createUniqueId();
        widget.setActivates(activator);
        widget.addStyleName(IncubatorCssName.LANGUAGE_ACTIVATOR);
        add(widget);
        dropdown.setActivator(activator);
        dropdown.reload();
    }

    @Override
    public LanguageSelectorType getType() {
        return getTypeMixin().getType();
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Language> valueChangeHandler) {
        return addHandler(valueChangeHandler, ValueChangeEvent.getType());
    }

    public CssTypeMixin<LanguageSelectorType, LanguageSelector> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin<>(this);
        }
        return typeMixin;
    }
}
