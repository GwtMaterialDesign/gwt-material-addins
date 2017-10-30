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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

import java.util.ArrayList;
import java.util.List;

/**
 * A widget that provides a selection of {@link LanguageSelectorItem} for the site Internationalization (i18n)
 *
 * @author kevzlou7979
 */
public class LanguageSelector extends MaterialWidget implements HasValue<Language> {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(LanguageSelectorDebugClientBundle.INSTANCE.languageSelectorDebugCss());
        } else {
            MaterialDesignBase.injectCss(LanguageSelectorClientBundle.INSTANCE.languageSelectorCss());
        }
    }

    private MaterialImage image = new MaterialImage();
    private MaterialDropDown dropdown = new MaterialDropDown();
    private List<Language> _languages = new ArrayList<>();
    private Language _language;

    public LanguageSelector() {
        super(Document.get().createDivElement(), IncubatorCssName.LANGUAGE_SELECTOR);
        image.addStyleName(IncubatorCssName.LANGUAGE_ACTIVATOR);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        dropdown.clear();
        _languages.forEach(language -> dropdown.add(new LanguageSelectorItem(language)));
        dropdown.setConstrainWidth(false);

        registerHandler(dropdown.addSelectionHandler(selectionEvent -> {
            if (selectionEvent.getSelectedItem() instanceof LanguageSelectorItem) {
                Language language = ((LanguageSelectorItem) selectionEvent.getSelectedItem()).getLanguage();

                if (_language != language) {
                    setValue(language, true);

                    // Navigate to selected language value / locale and reload the browser
                    String param = Window.Location.createUrlBuilder().setParameter("locale", language.getValue()).buildString();
                    Window.Location.replace(param);
                }
            }
        }));

        image.add(dropdown);
        add(image);

        // Get the current locale inside the browser url
        String currentLocale = Window.Location.getParameter("locale");
        if (_languages.size() != 0) {
            Language currentLanguage = _languages.stream().filter(language -> language.getValue().equals(currentLocale)).findFirst().orElse(_languages.get(0));
            setValue(currentLanguage);
        } else {
            GWT.log("Please add at least one language for this selector.");
        }
    }

    /**
     * Ability to add language item {@link Language}
     * contains name, value and image url
     */
    public void addLanguage(Language language) {
        _languages.add(language);
    }

    /**
     * Set lists of languages and repopulate inside the Language Selector Dropdown component
     */
    public void setLanguages(List<Language> languages) {
        _languages = languages;
    }

    /**
     * Get the lists of registered languages of this selector component
     */
    public List<Language> getLanguages() {
        return _languages;
    }

    @Override
    public Language getValue() {
        return _language;
    }

    @Override
    public void setValue(Language language) {
        setValue(language, false);
    }

    @Override
    public void setValue(Language language, boolean fireEvents) {
        _language = language;
        image.setUrl(language.getImage());

        if (fireEvents) {
            ValueChangeEvent.fire(this, language);
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Language> valueChangeHandler) {
        return addHandler(valueChangeHandler, ValueChangeEvent.getType());
    }
}
