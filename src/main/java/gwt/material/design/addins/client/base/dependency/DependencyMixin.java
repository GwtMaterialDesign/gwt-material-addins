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
import gwt.material.design.addins.client.dark.AddinsDarkThemeReloader;
import gwt.material.design.client.base.mixin.DependencyCallback;
import gwt.material.design.client.theme.dark.DarkThemeLoader;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DependencyMixin<T extends HasDependency> implements HasDependency {

    private InstallCallbacks callbacks = new InstallCallbacks();
    private T lib;

    public DependencyMixin(T lib) {
        this.lib = lib;
    }

    public void install(InstallCallback callback) {
        if (lib != null && callback != null) {
            if (isInstalled(lib)) {
                callback.installed();
            } else {
                GWT.log("Installing Dependency [" + lib.getClass().getSimpleName() + "]");
                installJs(lib.getJsDependencies(), callback);
                installCss(lib.getCssDependencies());
                installDarkTheme(lib.getDarkTheme());
            }
        }
    }

    public void installJs(List<DependencyResource> resources, InstallCallback callback) {
        if (resources != null) {
            if (!resources.isEmpty()) {
                this.callbacks.add(lib.getClass(), callback);
                DependencyInjector.installJs(resources, new DependencyCallback() {
                    @Override
                    public void onSuccess() {
                        callbacks.installed(lib.getClass(), true);
                        List<InstallCallback> installCallbacks = callbacks.get(lib.getClass());
                        if (installCallbacks != null) {
                            for (InstallCallback installCallback : installCallbacks) {
                                installCallback.installed();
                            }
                            callbacks.get(lib.getClass()).clear();
                        }
                    }

                    @Override
                    public void onError(String error) {
                        throw new RuntimeException("Widget Dependency for [" + lib.getClass().getSimpleName() + "] is not successfully installed." + error);
                    }
                });
            } else {
                callback.installed();
            }
        }
    }

    public void installCss(List<DependencyResource> resources) {
        DependencyInjector.installCss(resources);
        if (lib.getJsDependencies() == null || lib.getJsDependencies().isEmpty()) {
            callbacks.installed(lib.getClass(), true);
        }
    }

    public void installDarkTheme(Class<? extends DarkThemeLoader> darkTheme) {
        AddinsDarkThemeReloader.get().reload(darkTheme);
    }

    public boolean isInstalled(T lib) {
        return callbacks.isInstalled(lib.getClass());
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        List<DependencyResource> dependencies = lib.getJsDependencies();
        Collections.sort(dependencies, Comparator.comparing(DependencyResource::getOrder));
        return dependencies;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return lib.getCssDependencies();
    }

}
