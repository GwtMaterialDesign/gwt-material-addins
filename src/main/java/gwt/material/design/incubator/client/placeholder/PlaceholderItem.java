/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.placeholder;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.dark.IncubatorDarkThemeReloader;
import gwt.material.design.incubator.client.loadingstate.LoadingStatePanel;

public class PlaceholderItem extends MaterialWidget {

    static {
        IncubatorWidget.showWarning(LoadingStatePanel.class);
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(PlaceholderDebugClientBundle.INSTANCE.contentPlaceholder());
        } else {
            MaterialDesignBase.injectCss(PlaceholderClientBundle.INSTANCE.contentPlaceholderCss());
        }
    }

    public PlaceholderItem() {
        super(Document.get().createDivElement(), IncubatorCssName.CONTENT_PLACEHOLDER);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        IncubatorDarkThemeReloader.get().reload(PlaceholderDarkTheme.class);
    }
}
