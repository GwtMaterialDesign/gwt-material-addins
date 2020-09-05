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
package gwt.material.design.addins.client.dark;

import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.client.theme.dark.DarkThemeManager;

public class AddinsDarkThemeReloader {

    static AddinsDarkThemeReloader instance;

    public void reload(Class<? extends DarkThemeLoader> widgetLoader) {
        DarkThemeLoader addinsLoader = DarkThemeManager.get().getLoader(AddinsDarkThemeLoader.class);
        if (addinsLoader != null) {
            DarkThemeLoader child = addinsLoader.getChild(widgetLoader);
            if (child != null && child instanceof AddinsWidgetDarkTheme) {
                ((AddinsWidgetDarkTheme) child).suppressReload();
            }
        }
    }

    public static AddinsDarkThemeReloader get() {
        if (instance == null) {
            instance = new AddinsDarkThemeReloader();
        }
        return instance;
    }
}
