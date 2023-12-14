/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2023 GwtMaterialDesign
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
package gwt.material.design.addins.client;

import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.dark.AddinsDarkThemeReloader;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.client.base.mixin.DependencyCallback;
import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.client.ui.MaterialToast;

public abstract class AbstractAddinsValueWidget<T> extends AbstractValueWidget<T> implements HasDependency {

    protected DependencyMixin<HasDependency> dependencyMixin;

    public AbstractAddinsValueWidget(Element element) {
        super(element);
    }

    public AbstractAddinsValueWidget(Element element, String... initialClass) {
        super(element, initialClass);
    }

    @Override
    protected void onLoad() {
        getDependencyMixin().install(() -> {
            internalLoad();
            super.onLoad();
        });
    }

    protected abstract void internalLoad();

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    public void unload() {
    }

    public void reload() {
    }

    public DependencyMixin<HasDependency> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
