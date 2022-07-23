/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2021 GwtMaterialDesign
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
package gwt.material.design.addins.client.camera;

public enum CameraResolution {

    /**
     * Quarter Video Graphics Array
     */
    QVGA(320, 240),
    /**
     * Standard Definition
     **/
    SD(640, 480),
    /**
     * High Definition
     **/
    HD(1280, 720),
    /**
     * Full High Definition
     **/
    FULL_HD(1920, 1080),
    /**
     * Television 4K
     **/
    TELEVISION_4K(3840, 2160),
    /**
     * Cinema 4K
     **/
    CINEMA_4K(4096, 2160),
    /**
     * 8K
     **/
    _8K(7680, 4320);

    private int width;
    private int height;

    CameraResolution(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static CameraResolution get(String name) {
        for (CameraResolution value : values()) {
            if (name.toUpperCase().equals(value.name())) {
                return value;
            }
        }
        return HD;
    }
}
