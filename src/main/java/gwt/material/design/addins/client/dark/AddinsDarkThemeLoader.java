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

import gwt.material.design.addins.client.autocomplete.MaterialAutoCompleteDarkTheme;
import gwt.material.design.addins.client.banner.MaterialBannerDarkTheme;
import gwt.material.design.addins.client.bubble.MaterialBubbleDarkTheme;
import gwt.material.design.addins.client.carousel.MaterialCarouselDarkTheme;
import gwt.material.design.addins.client.combobox.MaterialComboBoxDarkTheme;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploaderDarkTheme;
import gwt.material.design.addins.client.overlay.MaterialOverlayDarkTheme;
import gwt.material.design.addins.client.rating.MaterialRatingDarkTheme;
import gwt.material.design.addins.client.richeditor.MaterialRichEditorDarkTheme;
import gwt.material.design.addins.client.splitpanel.MaterialSplitPanelDarkTheme;
import gwt.material.design.addins.client.stepper.MaterialStepperDarkTheme;
import gwt.material.design.addins.client.subheader.MaterialSubheaderDarkTheme;
import gwt.material.design.addins.client.timepicker.MaterialTimePickerDarkTheme;
import gwt.material.design.addins.client.tree.MaterialTreeDarkTheme;
import gwt.material.design.addins.client.window.MaterialWindowDarkTheme;
import gwt.material.design.client.theme.dark.DarkThemeLoader;

public class AddinsDarkThemeLoader extends DarkThemeLoader {

    public AddinsDarkThemeLoader() {
        super(new MaterialAutoCompleteDarkTheme(),
            new MaterialBubbleDarkTheme(),
            new MaterialBannerDarkTheme(),
            new MaterialComboBoxDarkTheme(),
            new MaterialCarouselDarkTheme(),
            new MaterialFileUploaderDarkTheme(),
            new MaterialOverlayDarkTheme(),
            new MaterialTimePickerDarkTheme(),
            new MaterialRatingDarkTheme(),
            new MaterialRichEditorDarkTheme(),
            new MaterialStepperDarkTheme(),
            new MaterialSplitPanelDarkTheme(),
            new MaterialSubheaderDarkTheme(),
            new MaterialTreeDarkTheme(),
            new MaterialWindowDarkTheme());
    }
}
