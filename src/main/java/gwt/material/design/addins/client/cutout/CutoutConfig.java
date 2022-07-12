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

    protected boolean absolute;
    protected int addedOffsetTop;
    protected int width;
    protected int maxHeight = 0;
    protected int maxWidth = 0;

    public CutoutConfig() {
    }

    public CutoutConfig(boolean absolute) {
        this.absolute = absolute;
    }

    public CutoutConfig(boolean absolute, int addedOffsetTop) {
        this.absolute = absolute;
        this.addedOffsetTop = addedOffsetTop;
    }

    public int getWidth() {
        return width;
    }

    public <M extends CutoutConfig> M setWidth(int width) {
        this.width = width;
        return (M) this;
    }

    public boolean isAbsolute() {
        return absolute;
    }

    public <M extends CutoutConfig> M setAbsolute(boolean absolute) {
        this.absolute = absolute;
        return (M) this;
    }

    public int getAddedOffsetTop() {
        return addedOffsetTop;
    }

    public <M extends CutoutConfig> M setAddedOffsetTop(int addedOffsetTop) {
        this.addedOffsetTop = addedOffsetTop;
        return (M) this;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public <M extends CutoutConfig> M setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        return (M) this;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public <M extends CutoutConfig> M setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
        return (M) this;
    }
}
