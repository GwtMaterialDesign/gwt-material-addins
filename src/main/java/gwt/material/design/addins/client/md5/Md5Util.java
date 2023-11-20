/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2021 GwtMaterialDesign
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
package gwt.material.design.addins.client.md5;

import com.google.gwt.resources.client.TextResource;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasDependency;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.mixin.DependencyCallback;
import gwt.material.design.client.base.mixin.DependencyMixin;

public class Md5Util implements HasDependency, JsLoader {

    protected DependencyMixin<Md5Util> dependencyMixin;

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(Md5DebugClientBundle.INSTANCE.md5DebugJs());
        } else {
            MaterialDesignBase.injectJs(Md5ClientBundle.INSTANCE.md5Js());
        }
    }

    public Md5Util() {

    }

    public String hex(String message) {
        return Md5.hex(message);
    }

    public byte[] array(String message) {
        return Md5.array(message);
    }

    public byte[] digest(String message) {
        return Md5.digest(message);
    }

    public Object arrayBuffer(String message) {
        return Md5.arrayBuffer(message);
    }

    public Object buffer(String message) {
        return Md5.buffer(message);
    }

    public String base64(String message) {
        return Md5.base64(message);
    }


    @Override
    public void install(TextResource minifiedJs, TextResource debugJs, TextResource minifiedCss, TextResource debugCss) {
        getDependencyMixin().install(minifiedJs, debugJs, minifiedCss, debugCss);
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

    @Override
    public void reload() {

    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    public DependencyMixin<Md5Util> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
