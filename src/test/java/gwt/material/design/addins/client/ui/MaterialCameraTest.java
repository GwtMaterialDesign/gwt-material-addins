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

import gwt.material.design.addins.client.ui.base.AddinsWidgetTestCase;
import gwt.material.design.addins.client.camera.MaterialCameraCapture;

/**
 * Test case for camera component
 *
 * @author kevzlou7979
 */
public class MaterialCameraTest extends AddinsWidgetTestCase<MaterialCameraCapture> {

    @Override
    protected MaterialCameraCapture createWidget() {
        return new MaterialCameraCapture();
    }

    public void testCameraCaptureEvent() {
        // UiBinder
        // given
        MaterialCameraCapture cameraCapture = getWidget(false);

        // when / then
        checkCameraCaptureEvent(cameraCapture);

        // Standard
        // given
        attachWidget();

        // when / then
        checkCameraCaptureEvent(cameraCapture);
    }

    protected void checkCameraCaptureEvent(MaterialCameraCapture cameraCapture) {
        final boolean[] isCaptureFired = new boolean[1];
        final String URL = "data:image/png;base64,";
        final String url = cameraCapture.captureToDataURL();
        cameraCapture.setEnabled(true);
        assertTrue(cameraCapture.isEnabled());
        cameraCapture.addCameraCaptureHandler(event -> isCaptureFired[0] = true);
        cameraCapture.play();
        assertNotNull(url);
        assertEquals(url, URL);
        assertTrue(isCaptureFired[0]);
    }

    public void testStartPauseReload() {
        // UiBinder
        // given
        MaterialCameraCapture cameraCapture = getWidget(false);

        // when / then
        checkStartPauseReload(cameraCapture);

        // Standard
        // given
        attachWidget();

        // when / then
        checkStartPauseReload(cameraCapture);
    }

    protected void checkStartPauseReload(MaterialCameraCapture cameraCapture) {
        cameraCapture.play();
        cameraCapture.setPauseOnUnload(true);
        assertTrue(cameraCapture.isPauseOnUnload());
        cameraCapture.setPauseOnUnload(false);
        assertFalse(cameraCapture.isPauseOnUnload());
        cameraCapture.reload();
    }
}
