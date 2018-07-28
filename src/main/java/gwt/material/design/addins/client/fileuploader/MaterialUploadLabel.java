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
package gwt.material.design.addins.client.fileuploader;

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.base.HasTitle;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.TitleMixin;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;

public class MaterialUploadLabel extends MaterialWidget implements HasTitle {

    private MaterialIcon icon = new MaterialIcon(IconType.CLOUD_UPLOAD);
    private TitleMixin<MaterialUploadLabel> titleMixin;

    public MaterialUploadLabel() {
        super(Document.get().createDivElement(), AddinsCssName.UPLOAD_LABEL);

        add(icon);
    }

    public MaterialUploadLabel(String title, String description) {
        this();
        setTitle(title);
        setDescription(description);
    }

    @Override
    public void setTitle(String title) {
        getTitleMixin().setTitle(title);
    }

    @Override
    public void setDescription(String description) {
        getTitleMixin().setDescription(description);
    }

    @Override
    public String getDescription() {
        return getTitleMixin().getDescription();
    }

    public MaterialIcon getIcon() {
        return icon;
    }

    public TitleMixin<MaterialUploadLabel> getTitleMixin() {
        if (titleMixin == null) {
            titleMixin = new TitleMixin<>(this);
        }
        return titleMixin;
    }
}