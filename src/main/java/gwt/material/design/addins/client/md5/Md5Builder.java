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
import gwt.material.design.client.base.HasDependency;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.mixin.DependencyCallback;
import gwt.material.design.client.base.mixin.DependencyMixin;

public class Md5Builder implements HasDependency, JsLoader {

    protected DependencyMixin<Md5Builder> dependencyMixin;
    protected String message;
    protected String converted = "";
    protected Md5Function function;

    public Md5Builder(String message, Md5Function function) {
        this.message = message;
        this.function = function;
        install(Md5ClientBundle.INSTANCE.md5Js(), Md5DebugClientBundle.INSTANCE.md5DebugJs());
    }

    public Md5Builder(String message) {
        this.message = message;
        this.function = Md5Function.HEX;
        install(Md5ClientBundle.INSTANCE.md5Js(), Md5DebugClientBundle.INSTANCE.md5DebugJs());
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
    public void reload() {
        unload();
        load();
    }

    @Override
    public void load() {
        switch (function) {
            case HEX:
                converted = Md5.hex(message);
                break;
            case ARRAY:
                converted = String.valueOf(Md5.array(message));
                break;
            case DIGEST:
                converted = String.valueOf(Md5.digest(message));
                break;
            case ARRAY_BUFFER:
                converted = (String) Md5.arrayBuffer(message);
                break;
            case BUFFER:
                converted = (String) Md5.buffer(message);
                break;
            case BASE_64:
                converted = Md5.base64(message);
                break;
        }
    }

    @Override
    public void unload() {
        Md5.destroy();
    }

    public String convert() {
        return converted;
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

    public DependencyMixin<Md5Builder> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
