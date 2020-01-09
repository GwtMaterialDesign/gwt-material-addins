/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.incubator.client.tag;

import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasSize;
import gwt.material.design.client.base.mixin.StyleMixin;
import gwt.material.design.client.constants.Size;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.dark.IncubatorDarkThemeReloader;

public class TagLabel extends MaterialLabel implements HasSize {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(TagDebugClientBundle.INSTANCE.tagDebugCss());
        } else {
            MaterialDesignBase.injectCss(TagClientBundle.INSTANCE.tagCss());
        }
    }

    private StyleMixin<TagLabel> sizeMixin;
    private StyleMixin<TagLabel> positionMixin;

    public TagLabel() {
        super();

        addStyleName("tag-label");
        setPosition(TagPosition.LEFT);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        IncubatorDarkThemeReloader.get().reload(TagLabelDarkTheme.class);
    }

    @Override
    public void setSize(Size size) {
        getSizeMixin().setStyle(size.getCssName());
    }

    @Override
    public Size getSize() {
        return Size.fromStyleName(getSizeMixin().getStyle());
    }

    public void setPosition(TagPosition position) {
        getPositionMixin().setStyle(position.getCssName());
    }

    public TagPosition getPosition() {
        return TagPosition.fromStyleName(getPositionMixin().getStyle());
    }

    public StyleMixin<TagLabel> getSizeMixin() {
        if (sizeMixin == null) {
            sizeMixin = new StyleMixin<>(this);
        }
        return sizeMixin;
    }

    public StyleMixin<TagLabel> getPositionMixin() {
        if (positionMixin == null) {
            positionMixin = new StyleMixin<>(this);
        }
        return positionMixin;
    }
}
