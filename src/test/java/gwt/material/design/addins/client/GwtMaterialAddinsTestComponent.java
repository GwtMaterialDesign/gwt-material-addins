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
package gwt.material.design.addins.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.resources.MaterialResources;
import gwt.material.design.client.resources.WithJQueryResources;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class GwtMaterialAddinsTestComponent extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "gwt.material.design.addins.GwtMaterialAddins";
    }

    @Override
    protected void gwtSetUp() throws Exception {
        super.gwtSetUp();
        setup();
    }

    public void setup() {
        // Test JQuery
        WithJQueryResources jquery = GWT.create(WithJQueryResources.class);
        MaterialDesign.injectJs(jquery.jQuery());
        assertTrue(MaterialDesign.isjQueryLoaded());
        // Test Materialize
        MaterialDesign.injectJs(MaterialResources.INSTANCE.materializeJs());
        assertTrue(MaterialDesign.isMaterializeLoaded());
        // gwt-material-jquery Test
        assertNotNull($("body"));
    }

    public void testAutocomplete() {
        new MaterialAutocompleteTest().init();
    }

    public void testAvatar() {
        new MaterialAvatarTest().init();
    }

    public void testBubble() {
        new MaterialBubbleTest().init();
    }

    public void testCamera() {
        new MaterialCameraTest().init();
    }

    public void testCombobox() {
        new MaterialComboBoxTest().init();
    }

    public void testCutout() {
        new MaterialCutoutTest().init();
    }

    public void testDnd() {
        new MaterialDndTest().init();
    }

    public void testDocViewer() {
        new MaterialDocViewerTest().init();
    }

    public void testEmptyState() {
        new MaterialEmptyStateTest().init();
    }

    public void testFileUploader() {
        new MaterialFileUploaderTest().init();
    }

    public void testIconMorph() {
        new MaterialIconMorphTest().init();
    }

    public void testMasonry() {
        new MaterialMasonryTest().init();
    }

    public void testMenubar() {
        new MaterialMenuBarTest().init();
    }

    public void testOverlay() {
        new MaterialOverlayTest().init();
    }

    public void testPathAnimator() {
        new MaterialPathAnimatorTest().init();
    }

    public void testPopupMenu() {
        new MaterialPopupMenuTest().init();
    }

    public void testRating() {
        new MaterialRatingTest().init();
    }

    public void testRichEditor() {
        new MaterialRichEditorTest().init();
    }

    public void testScrollFire() {
        new MaterialScrollfireTest().init();
    }

    public void testSplitPanel() {
        new MaterialSplitPanelTest().init();
    }

    public void testStepper() {
        new MaterialStepperTest().init();
    }

    public void testSubheader() {
        new MaterialSubheaderTest().init();
    }

    public void testSwipeable() {
        new MaterialSwipeableTest().init();
    }

    public void testTimePicker() {
        new MaterialTimePickerTest().init();
    }

    public void testTree() {
        new MaterialTreeTest().init();
    }

    public void testWindow() {
        new MaterialWindowTest().init();
    }
}
