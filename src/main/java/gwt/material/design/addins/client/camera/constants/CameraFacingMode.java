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
package gwt.material.design.addins.client.camera.constants;

import java.util.ArrayList;
import java.util.List;

public enum CameraFacingMode {
    FRONT("user"),
    REAR("environment"),
    LEFT("left"),
    RIGHT("right");

    String name;

    CameraFacingMode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<CameraFacingMode> getFacingModes() {
        List<CameraFacingMode> facingModes = new ArrayList<>();
        facingModes.add(CameraFacingMode.FRONT);
        facingModes.add(CameraFacingMode.REAR);
        facingModes.add(CameraFacingMode.LEFT);
        facingModes.add(CameraFacingMode.RIGHT);
        return facingModes;
    }
}