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

import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.client.base.HasSize;
import gwt.material.design.client.base.mixin.StyleMixin;
import gwt.material.design.client.constants.Size;
import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.client.ui.MaterialLabel;

import java.util.Collections;
import java.util.List;

public class TagLabel extends MaterialLabel implements HasDependency, HasSize {

    private DependencyMixin<TagLabel> dependencyMixin;
    private StyleMixin<TagLabel> sizeMixin;
    private StyleMixin<TagLabel> positionMixin;

    public TagLabel() {
        super();

        addStyleName("tag-label");
        setPosition(TagPosition.LEFT);
    }

    @Override
    protected void onLoad() {
        getDependencyMixin().install(super::onLoad);
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

    @Override
    public Class<? extends DarkThemeLoader> getDarkTheme() {
        return TagLabelDarkTheme.class;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(TagClientBundle.INSTANCE.tagCss(), TagDebugClientBundle.INSTANCE.tagDebugCss()));
    }

    public DependencyMixin<TagLabel> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
