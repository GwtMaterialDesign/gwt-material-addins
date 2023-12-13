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
 *//*

package gwt.material.design.addins.client.md5;

import com.google.gwt.resources.client.TextResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.mixin.DependencyCallback;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;

import java.util.List;

public class Md5Converter implements HasDependency, JsLoader {

    protected static Md5Converter instance;
    protected DependencyMixin<Md5Converter> dependencyMixin;
    protected String message;
    protected Md5Function function;
    protected Md5ConvertCallback callback;

    public Md5Converter() {}

    public void convert(String message, Md5Function function, Md5ConvertCallback callback) {
        this.message = message;
        this.callback = callback;
        this.function = function;
        install(Md5ClientBundle.INSTANCE.md5Js(), Md5DebugClientBundle.INSTANCE.md5DebugJs());
    }

    public void convert(String message, Md5ConvertCallback callback) {
        convert(message, Md5Function.HEX, callback);
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
        if (callback != null) {
            String converted = "";
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
            callback.call(converted);
        } else {
            throw new RuntimeException("Md5 convert callback must be defined");
        }
    }

    @Override
    public void unload() {
        Md5.destroy();
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
    public boolean isInstalled(Class<?> loaderClass) {
        return getDependencyMixin().isInstalled(loaderClass);
    }

    @Override
    public void setDependencyLoaded(Class<?> loaderClass, boolean loaded) {
        getDependencyMixin().setDependencyLoaded(loaderClass, loaded);
    }

    @Override
    public void internalLoad() {

    }

    @Override
    public List<TextResource> getJsDependencies() {
        return null;
    }

    public static Md5Converter get() {
        if (instance == null) {
            instance = new Md5Converter();
        }
        return instance;
    }

    public DependencyMixin<Md5Converter> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
*/
