/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.ui;

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.overlay.MaterialOverlay;
import gwt.material.design.addins.client.overlay.MaterialOverlayTab;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MaterialOverlayTabTest extends MaterialWidgetTest<MaterialOverlayTab> {

    private MaterialButton activator;

    @Override
    protected MaterialOverlayTab createWidget() {
        MaterialOverlayTab overlayTab = new MaterialOverlayTab();
        activator = new MaterialButton("SAMPLE");
        overlayTab.setActivator(activator);
        RootPanel.get().add(activator);
        return overlayTab;
    }

    public void testOverlayTab() {
        // given
        MaterialOverlayTab overlayTab = getWidget();

        // when / then
        List<MaterialOverlay> overlays = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            MaterialOverlay overlay = new MaterialOverlay();
            overlayTab.minimize(overlay);
            overlays.add(overlay);
        }
    }


}
