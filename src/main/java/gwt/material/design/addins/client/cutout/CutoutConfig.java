/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2022 GwtMaterialDesign
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
package gwt.material.design.addins.client.cutout;

public class CutoutConfig {

    private boolean absolute;
    private int addedOffsetTop;

    public CutoutConfig() {
    }

    public CutoutConfig(boolean absolute) {
        this.absolute = absolute;
    }

    public CutoutConfig(boolean absolute, int addedOffsetTop) {
        this.absolute = absolute;
        this.addedOffsetTop = addedOffsetTop;
    }

    public boolean isAbsolute() {
        return absolute;
    }

    public void setAbsolute(boolean absolute) {
        this.absolute = absolute;
    }

    public int getAddedOffsetTop() {
        return addedOffsetTop;
    }

    public void setAddedOffsetTop(int addedOffsetTop) {
        this.addedOffsetTop = addedOffsetTop;
    }
}
