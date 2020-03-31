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

import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.cropper.MaterialImageCropper;
import gwt.material.design.addins.client.cropper.constants.Shape;
import gwt.material.design.addins.client.cropper.events.CropEvent;
import gwt.material.design.addins.client.cropper.js.JsCropperDimension;

/**
 * Test case for Image Cropper component
 *
 * @author kevzlou7979
 */
public class MaterialImageCropperTest extends MaterialWidgetTest<MaterialImageCropper> {

    final static int BOUNDARY_WIDTH = 200;
    final static int BOUNDARY_HEIGHT = 200;
    final static int VIEWPORT_WIDTH = 100;
    final static int VIEWPORT_HEIGHT = 100;
    final static String CUSTOM_CLASS = "custom";
    final static String CROP_RESULT = "some-result";
    final static Shape SHAPE = Shape.SQUARE;

    @Override
    protected MaterialImageCropper createWidget() {
        return new MaterialImageCropper();
    }

    public void testProperties() {
        // UiBinder
        // given
        MaterialImageCropper cropper = getWidget(false);

        // when / then
        checkProperties(cropper);

        // Standard
        // given
        attachWidget();

        // when / then
        checkProperties(cropper);
    }

    protected void checkProperties(MaterialImageCropper cropper) {
        JsCropperDimension boundary = new JsCropperDimension();
        boundary.width = BOUNDARY_WIDTH;
        boundary.height = BOUNDARY_HEIGHT;

        JsCropperDimension viewport = new JsCropperDimension();
        viewport.width = VIEWPORT_WIDTH;
        viewport.height = VIEWPORT_HEIGHT;

        cropper.setViewport(viewport);
        assertEquals(viewport, cropper.getViewPort());
        assertEquals(viewport.width, cropper.getViewPort().width);
        assertEquals(viewport.height, cropper.getViewPort().height);

        cropper.setBoundary(boundary);
        assertEquals(boundary, cropper.getBoundary());
        assertEquals(boundary.width, cropper.getBoundary().width);
        assertEquals(boundary.height, cropper.getBoundary().height);

        cropper.setShape(SHAPE);
        assertEquals(SHAPE, cropper.getShape());
        assertEquals(SHAPE.getCssName(), cropper.getViewPort().type);

        cropper.setEnableZoom(true);
        assertTrue(cropper.isEnableZoom());
        cropper.setEnableZoom(false);
        assertFalse(cropper.isEnableZoom());

        cropper.setEnableResize(true);
        assertTrue(cropper.isEnableResize());
        cropper.setEnableResize(false);
        assertFalse(cropper.isEnableResize());

        cropper.setEnableOrientation(true);
        assertTrue(cropper.isEnableOrientation());
        cropper.setEnableOrientation(false);
        assertFalse(cropper.isEnableOrientation());

        cropper.setEnforceBoundary(true);
        assertTrue(cropper.isEnforceBoundary());
        cropper.setEnforceBoundary(false);
        assertFalse(cropper.isEnforceBoundary());

        cropper.setMouseWheelZoom(true);
        assertEquals(cropper.getMouseWheelZoom(), true);
        cropper.setMouseWheelZoom(false);
        assertEquals(cropper.getMouseWheelZoom(), false);

        cropper.setShowZoomer(true);
        assertTrue(cropper.isShowZoomer());
        cropper.setShowZoomer(false);
        assertFalse(cropper.isShowZoomer());

        cropper.setCustomClass(CUSTOM_CLASS);
        assertEquals(CUSTOM_CLASS, cropper.getCustomClass());
    }

    public void testCropEvent() {
        // given
        MaterialImageCropper cropper = getWidget(false);

        boolean[] firedCropHandler = {false};
        cropper.addCropHandler(event -> {
            assertEquals(CROP_RESULT, event.getResult());
            firedCropHandler[0] = true;
        });

        CropEvent.fire(cropper, CROP_RESULT);
        assertTrue(firedCropHandler[0]);
    }
}
