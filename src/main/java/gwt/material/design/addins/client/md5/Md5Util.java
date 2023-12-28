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

import elemental2.promise.Promise;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;

import java.util.Collections;
import java.util.List;

public class Md5Util implements HasDependency {

    protected static Md5Util instance = new Md5Util();
    protected DependencyMixin<Md5Util> dependencyMixin;
    protected String message;
    protected Md5Function function;

    public Md5Util() {
        getDependencyMixin().install(() -> {});
    }

    public String convert(String message, Md5Function function) {
        this.message = message;
        this.function = function;
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
        return converted;
    }

    public String convert(String message) {
        return convert(message, Md5Function.HEX);
    }

    public void unload() {
        Md5.destroy();
    }

    public DependencyMixin<Md5Util> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(Md5ClientBundle.INSTANCE.md5Js(), Md5DebugClientBundle.INSTANCE.md5DebugJs()));
    }
}