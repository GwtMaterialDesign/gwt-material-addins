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

import com.google.gwt.core.client.GWT;

import java.util.*;

public class InstallCallbacks {

    private static Map<Class<? extends HasDependency>, List<InstallCallback>> callbacksMap = new LinkedHashMap<>();
    private static Map<Class<? extends HasDependency>, Boolean> installedMap = new HashMap<>();

    public InstallCallbacks() {
    }

    public void add(Class<? extends HasDependency> lib, InstallCallback callback) {
        List<InstallCallback> callbacks = get(lib);
        if (callbacks == null) {
            callbacks = new ArrayList<>();
        }
        if (!callbacks.contains(callback)) {
            callbacks.add(callback);
        }
        callbacksMap.put(lib, callbacks);
    }

    public List<InstallCallback> get(Class<? extends HasDependency> lib) {
        return callbacksMap.get(lib);
    }

    public void installed(Class<? extends HasDependency> lib, boolean installed) {
        installedMap.put(lib, installed);
        GWT.log("Successfully Installed [" + lib.getSimpleName() + "]");
    }

    public boolean isInstalled(Class<? extends HasDependency> lib) {
        Boolean installed = installedMap.get(lib);
        return installed != null ? installed : false;
    }
}
