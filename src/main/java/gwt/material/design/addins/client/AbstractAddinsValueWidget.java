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
import com.google.gwt.resources.client.TextResource;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.HasDependency;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.mixin.DependencyCallback;
import gwt.material.design.client.base.mixin.DependencyMixin;

public abstract class AbstractAddinsValueWidget<T> extends AbstractValueWidget<T> implements HasDependency, JsLoader {

    protected DependencyMixin dependencyMixin;

    public AbstractAddinsValueWidget(Element element) {
        super(element);
    }

    public AbstractAddinsValueWidget(Element element, String... initialClass) {
        super(element, initialClass);
        getDependencyMixin().setDebug(MaterialAddins.isDebug());
    }

    public boolean isDependencyLoaded() {
        return getDependencyMixin().isDependencyLoaded(getClass());
    }

    @Override
    public void install(TextResource minifiedJs, TextResource debugJs, TextResource minifiedCss, TextResource debugCss) {
        getDependencyMixin().install(minifiedJs, debugJs, minifiedCss, debugCss);
    }

    @Override
    public void install(TextResource minifiedJs, TextResource debugJs) {
        getDependencyMixin().install(minifiedJs, debugJs);
    }

    @Override
    public void setDebug(boolean debug) {
        getDependencyMixin().setDebug(debug);
    }

    @Override
    public DependencyCallback getCallback() {
        return getDependencyMixin().getCallback();
    }

    @Override
    public boolean isDependencyLoaded(Class<?> loaderClass) {
        return getDependencyMixin().isDependencyLoaded(loaderClass);
    }

    @Override
    public void setDependencyLoaded(Class<?> loaderClass, boolean loaded) {
        getDependencyMixin().setDependencyLoaded(loaderClass, loaded);
    }

    public DependencyMixin getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin(this);
        }
        return dependencyMixin;
    }
}
