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
package gwt.material.design.addins.client;

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.masonry.MaterialMasonry;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialColumn;

public class MaterialMasonryTest extends MaterialAddinsTest {

    public void init() {
        MaterialMasonry masonry = new MaterialMasonry();
        checkWidget(masonry);
        checkStructure(masonry);
        checkProperties(masonry);
    }

    @Override
    protected <T extends MaterialWidget> void checkChildren(T widget) {
        MaterialMasonry masonry = new MaterialMasonry();
        for (int i = 1; i <= 5; i++) {
            MaterialColumn col = new MaterialColumn();
            col.setGrid("s4");
            checkGrid(col);
            masonry.add(col);
        }
    }

    protected <T extends MaterialMasonry> void checkStructure(T masonry) {
        // Check if Feature is enabled
        RootPanel.get().add(masonry);
        assertTrue(masonry.isFeatureEnabled(MaterialWidget.Feature.ONLOAD_ADD_QUEUE));
        assertEquals(masonry.getWidgetCount(), 1);
        MaterialWidget sizerDiv = (MaterialWidget) masonry.getWidget(0);
        assertTrue(sizerDiv.getElement().hasClassName(AddinsCssName.COL_SIZER));
    }

    protected <T extends MaterialMasonry> void checkProperties(T masonry) {
        assertEquals(masonry.getItemSelector(), ".col");
        masonry.setItemSelector(".sample");
        assertEquals(masonry.getItemSelector(), ".sample");
        assertTrue(masonry.isPercentPosition());
        masonry.setPercentPosition(false);
        assertFalse(masonry.isPercentPosition());
        assertTrue(masonry.isOriginLeft());
        masonry.setOriginLeft(false);
        assertFalse(masonry.isOriginLeft());
        assertTrue(masonry.isOriginTop());
        masonry.setOriginTop(false);
        assertFalse(masonry.isOriginTop());
        assertEquals(masonry.getTransitionDuration(), Double.valueOf(400));
        masonry.setTransitionDuration(100);
        assertEquals(masonry.getTransitionDuration(), Double.valueOf(100));
    }
}
