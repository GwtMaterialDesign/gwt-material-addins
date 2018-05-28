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
package gwt.material.design.incubator.client.ui;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.incubator.client.MaterialWidgetTest;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.html.ListItem;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.language.Language;
import gwt.material.design.incubator.client.language.LanguageSelector;
import gwt.material.design.incubator.client.language.LanguageSelectorItem;
import gwt.material.design.incubator.client.language.LanguageSelectorType;

import java.util.ArrayList;
import java.util.List;

/**
 * Test Case for Language Selector
 *
 * @author kevzlou7979
 */
public class LanguageSelectorTest extends MaterialWidgetTest<LanguageSelector> {

    @Override
    protected LanguageSelector createWidget() {
        LanguageSelector selector = new LanguageSelector();
        selector.setLanguages(getLanguages());
        return selector;
    }

    public void testLanguageItems() {
        LanguageSelector selector = getWidget();

        assertEquals(getLanguages().size(), 2);
    }

    public void testStructure() {
        LanguageSelector selector = getWidget();

        // Check component structure
        RootPanel.get().add(selector);
        selector.getElement().hasClassName(IncubatorCssName.LANGUAGE_SELECTOR);

        // Check image activator structure
        assertEquals(selector.getWidgetCount(), 2);
        assertTrue(selector.getWidget(1) instanceof MaterialDropDown);
        MaterialDropDown dropDown = (MaterialDropDown) selector.getWidget(1);

        //TODO Apply the recent changes on activator widgets
        /*selector.setType(LanguageSelectorType.IMAGE);
        assertTrue(selector.getWidget(0) instanceof MaterialImage);
        MaterialImage image = (MaterialImage) selector.getWidget(0);
        assertEquals(image.getUrl(), getLanguages().get(0).getImage());
        assertTrue(image.getElement().hasClassName(IncubatorCssName.LANGUAGE_ACTIVATOR));*/

        // Check Language Item's structure
        assertEquals(dropDown.getWidgetCount(), getLanguages().size());
        for (Widget widget : dropDown) {
            assertTrue(widget instanceof ListItem);
            ListItem item = (ListItem) widget;
            LanguageSelectorItem selectorItem = (LanguageSelectorItem) item.getWidget(0);
            assertTrue(selectorItem.getElement().hasClassName(IncubatorCssName.LANGUAGE_SELECTOR_ITEM));
            assertEquals(selectorItem.getLanguage().getName(), getLanguages().get(dropDown.getWidgetIndex(widget)).getName());
        }
    }

    public void testSelection() {
        LanguageSelector selector = getWidget();

        boolean[] fireValueChange = {false};
        Language toBeFired = getLanguages().get(1);
        selector.addValueChangeHandler(valueChangeEvent -> {
            assertEquals(toBeFired, valueChangeEvent.getValue());
            fireValueChange[0] = true;
        });
        ValueChangeEvent.fire(selector, toBeFired);
        assertTrue(fireValueChange[0]);
    }

    protected List<Language> getLanguages() {
        List<Language> languages = new ArrayList<>();
        languages.add(new Language("English", "en", "english.png"));
        languages.add(new Language("French", "fr", "french.png"));
        return languages;
    }
}
