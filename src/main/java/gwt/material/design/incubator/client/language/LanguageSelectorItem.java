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

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

/**
 * A child widget of {@link LanguageSelector} component which updates the ui
 * for the name and image url.
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
public class LanguageSelectorItem extends MaterialWidget {

    protected MaterialImage image = new MaterialImage();
    protected MaterialLink label = new MaterialLink();
    private Language language;

    public LanguageSelectorItem() {
        super(Document.get().createDivElement(), IncubatorCssName.LANGUAGE_SELECTOR_ITEM, CssName.ROW);
    }

    public LanguageSelectorItem(Language language) {
        this();
        setLanguage(language);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        MaterialColumn imageColumn = new MaterialColumn(4,4,4);
        imageColumn.add(image);

        MaterialColumn nameColumn = new MaterialColumn(8,8,8);
        label.setTextColor(Color.BLACK);
        nameColumn.setPadding(0);
        nameColumn.setTextAlign(TextAlign.LEFT);
        nameColumn.add(label);

        if (language.getImage() != null) {
            add(imageColumn);
        }

        if (language.getName() != null) {
            add(nameColumn);
        }
    }

    public MaterialImage getImage() {
        return image;
    }

    public MaterialLink getLabel() {
        return label;
    }

    /**
     * Update the ui for the name and image components.
     */
    public void setLanguage(Language language) {
        this.language = language;
        this.label.setText(language.getName());
        this.image.setUrl(language.getImage());
    }

    /**
     *  Gets the language object
     */
    public Language getLanguage() {
        return language;
    }
}
