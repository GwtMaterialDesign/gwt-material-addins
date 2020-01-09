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
package gwt.material.design.incubator.client.dark;

import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.incubator.client.animation.checkmark.CheckMarkDarkTheme;
import gwt.material.design.incubator.client.daterange.DateRangeDarkTheme;
import gwt.material.design.incubator.client.google.addresslookup.AddressLookupDarkTheme;
import gwt.material.design.incubator.client.placeholder.PlaceholderDarkTheme;
import gwt.material.design.incubator.client.progress.ProgressLineBarDarkTheme;
import gwt.material.design.incubator.client.tag.TagLabelDarkTheme;
import gwt.material.design.incubator.client.toggle.GroupToggleDarkTheme;

public class IncubatorDarkThemeLoader extends DarkThemeLoader {

    public IncubatorDarkThemeLoader() {
        super(new AddressLookupDarkTheme(),
            new CheckMarkDarkTheme(),
            new DateRangeDarkTheme(),
            new GroupToggleDarkTheme(),
            new PlaceholderDarkTheme(),
            new ProgressLineBarDarkTheme(),
            new TagLabelDarkTheme());
    }
}
