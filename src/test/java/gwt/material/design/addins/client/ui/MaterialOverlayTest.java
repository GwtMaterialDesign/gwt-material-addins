/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.overlay.MaterialOverlay;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialButton;

/**
 * Test case for overlay component
 *
 * @author kevzlou7979
 */
public class MaterialOverlayTest extends MaterialWidgetTest<MaterialOverlay> {

    private MaterialWidget source;
    
    @Override
    protected MaterialOverlay createWidget() {
        MaterialOverlay overlay = new MaterialOverlay();
        source = new MaterialButton();
        RootPanel.get().add(source);
        return overlay;
    }

    @Override
    protected void gwtTearDown() throws Exception {
        super.gwtTearDown();

        source.removeFromParent();
    }

    public void testOpenCloseEvents() {
        // UiBinder
        // given
        MaterialOverlay overlay = getWidget(false);

        // when / then
        checkOpenCloseEvents(overlay);

        // Standard
        // given
        attachWidget();

        // when / then
        checkOpenCloseEvents(overlay);
    }

    protected void checkOpenCloseEvents(MaterialOverlay overlay) {
        // when / then
        overlay.setEnabled(true);
        checkOpenHandler(overlay);
        checkCloseHandler(overlay);

        // given
        final boolean[] isOpenFired = {false};
        overlay.addOpenHandler(openEvent -> isOpenFired[0] = true);

        // when / then
        overlay.open();
        assertTrue(isOpenFired[0]);

        // given
        overlay.close();
        overlay.open(source);

        // when / then
        assertEquals("hidden", overlay.body().asElement().getStyle().getOverflow());
        assertEquals(source.getElement(), overlay.getSourceElement());

        // given
        final boolean[] isCloseFired = {false};
        overlay.addCloseHandler(closeEvent -> isCloseFired[0] = true);

        // when / then
        overlay.close();
        assertEquals("auto", overlay.body().asElement().getStyle().getOverflow());
        assertTrue(isCloseFired[0]);
    }

    public void testStructure() {
        // UiBinder
        // given
        MaterialOverlay overlay = getWidget(false);

        // when / then
        checkStructure(overlay, false);

        // Standard
        // given
        attachWidget();

        // when / then
        checkStructure(overlay, true);
    }

    protected void checkStructure(MaterialOverlay overlay, boolean checkElement) {
        if (checkElement) {
            assertTrue(overlay.getElement().hasClassName(AddinsCssName.OVERLAY_PANEL));
        }
    }

    public void testNestedOverlay() {
        // given
        MaterialOverlay overlay = getWidget();
        MaterialOverlay child = new MaterialOverlay();
        overlay.add(child);

        // when / then
        overlay.open();
        child.open();
        child.close();

        child.addCloseHandler(closeEvent -> assertEquals("hidden", RootPanel.get().getElement().getStyle().getOverflow()));
        assertEquals(RootPanel.get(), overlay.getParent());
        assertEquals(overlay, child.getParent());
    }
}
