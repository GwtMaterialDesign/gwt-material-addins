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
package gwt.material.design.addins.client.base.dependency;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.mixin.DependencyCallback;

import java.util.List;

public class DependencyInjector {

    /**
     * This is not been tested on Asynchronous injection. The fromString is a synchronous call that library is loaded and ready.
     * @param resources
     * @param callback
     */
    public static void installJs(List<DependencyResource> resources, DependencyCallback callback) {
        try {
            for (DependencyResource dep : resources) {
                TextResource resource = MaterialAddins.isDebug() ? dep.getDebug() : dep.getMinified();
                String text = resource.getText() + (MaterialAddins.isDebug() ?
                        "//# sourceURL=" + resource.getName() + ".js" : "");

                // Inject the script resource
                ScriptInjector.fromString(text)
                        .setWindow(ScriptInjector.TOP_WINDOW)
                        .setRemoveTag(!MaterialAddins.isDebug())
                        .inject();
                MaterialDesignBase.injectJs(resource);
            }
            if (callback != null) callback.onSuccess();
        } catch (RuntimeException e) {
            if (callback != null) callback.onError(e.getMessage());
        }
    }

    public static void installCss(List<DependencyResource> cssDependencies) {
        for (DependencyResource dep : cssDependencies) {
            if (MaterialAddins.isDebug()) {
                StyleInjector.inject(dep.getDebug().getText());
            } else {
                StyleInjector.inject(dep.getMinified().getText());
            }
        }
    }
}
