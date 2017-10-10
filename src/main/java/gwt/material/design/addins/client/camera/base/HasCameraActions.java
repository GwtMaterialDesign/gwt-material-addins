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
package gwt.material.design.addins.client.camera.base;

import gwt.material.design.addins.client.camera.events.CameraCaptureHandler;

public interface HasCameraActions {

    /**
     * <p>
     * Starts the video stream from the camera. This is called when the component is loaded.
     * Use {@link CameraCaptureHandler}s to be notified when the stream actually starts or if
     * an error occurs.
     * </p>
     * <p>
     * At this point the user is requested by the browser to allow the application to use the camera.
     * If the user doesn't allow it, an error is notified to the {@link CameraCaptureHandler}s.
     * </p>
     */
    void play();

    /**
     * Pauses the video stream from the camera.
     */
    void pause();

    /**
     * Stops all the Tracks that is currently streaming
     */
    void stop();

    /**
     * Captures the current frame of the video to an image data URL. It's the same as calling
     * {@link gwt.material.design.addins.client.camera.MaterialCameraCapture#captureToDataURL(String)} using "image/png".
     *
     * @return The Data URL of the captured image, which can be used as "src" on an "img" element
     * or sent to the server
     */
    String captureToDataURL();

    /**
     * Captures the current frame of the video to an image data URL.
     *
     * @param mimeType The type of the output image, such as "image/png" or "image/jpeg".
     * @return The Data URL of the captured image, which can be used as "src" on an "img" element
     * or sent to the server
     */
    String captureToDataURL(String mimeType);
}
