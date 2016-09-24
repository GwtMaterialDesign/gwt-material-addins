package gwt.material.design.addins.client.camera.events;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2016 GwtMaterialDesign
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

import com.google.gwt.event.shared.EventHandler;
import gwt.material.design.addins.client.camera.MaterialCameraCapture;

/**
 * Handler for {@link CameraCaptureEvent}s.
 * 
 * @author gilberto-torrezan
 * 
 * @see MaterialCameraCapture
 */
public interface CameraCaptureHandler extends EventHandler {

    /**
     * Fired when there's a change on the state of the camera capture.
     */
    void onCameraCaptureChange(CameraCaptureEvent event);

}
