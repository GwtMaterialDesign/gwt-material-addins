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

import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.camera.MaterialCameraCapture;

/**
 * Test case for camera component
 *
 * @author kevzlou7979
 */
public class MaterialCameraTest extends MaterialAddinsTest {

    public void init() {
        MaterialCameraCapture cameraCapture = new MaterialCameraCapture();
        checkWidget(cameraCapture);
        checkCameraCaptureEvent(cameraCapture);
        checkPausePlayRestart(cameraCapture);
    }

    protected <T extends MaterialCameraCapture> void checkCameraCaptureEvent(T cameraCapture) {
        final boolean[] isCaptureFired = new boolean[1];
        cameraCapture.setEnabled(true);
        assertTrue(cameraCapture.isEnabled());
        cameraCapture.addCameraCaptureHandler(event -> {
            isCaptureFired[0] = true;
        });
        cameraCapture.play();
        final String URL = "data:image/png;base64,";
        final String url = cameraCapture.captureToDataURL();
        assertNotNull(url);
        assertEquals(url, URL);
        assertTrue(isCaptureFired[0]);
    }

    protected <T extends MaterialCameraCapture> void checkPausePlayRestart(T cameraCapture) {
        cameraCapture.play();
        cameraCapture.setPauseOnUnload(true);
        assertTrue(cameraCapture.isPauseOnUnload());
        cameraCapture.setPauseOnUnload(false);
        assertFalse(cameraCapture.isPauseOnUnload());
        cameraCapture.restart();
    }
}
