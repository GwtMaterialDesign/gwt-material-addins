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
package gwt.material.design.addins.client.dragula;

import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.dragula.js.JsDragula;
import gwt.material.design.addins.client.dragula.js.JsDragulaOptions;
import gwt.material.design.client.MaterialDesignBase;

public class MaterialDragula {

    static {
        MaterialDesignBase.injectJs(MaterialDragulaClientBundle.INSTANCE.dragulaJs());
    }

    private String direction = "vertical";
    private boolean copy;
    private boolean copySortSource;
    private boolean revertOnSpill;
    private boolean removeOnSpill;
    private boolean ignoreInputTextSelection = true;
    private JsDragula dragula;

    public MaterialDragula() {

    }

    public void apply(Element... elements) {
        JsDragulaOptions options = new JsDragulaOptions();
        options.direction = direction;
        options.copy = copy;
        options.copySortSource = copySortSource;
        options.revertOnSpill = revertOnSpill;
        options.removeOnSpill = removeOnSpill;
        options.ignoreInputTextSelection = ignoreInputTextSelection;

        dragula = JsDragula.dragula(elements, options);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isCopy() {
        return copy;
    }

    public void setCopy(boolean copy) {
        this.copy = copy;
    }

    public boolean isCopySortSource() {
        return copySortSource;
    }

    public void setCopySortSource(boolean copySortSource) {
        this.copySortSource = copySortSource;
    }

    public boolean isRevertOnSpill() {
        return revertOnSpill;
    }

    public void setRevertOnSpill(boolean revertOnSpill) {
        this.revertOnSpill = revertOnSpill;
    }

    public boolean isRemoveOnSpill() {
        return removeOnSpill;
    }

    public void setRemoveOnSpill(boolean removeOnSpill) {
        this.removeOnSpill = removeOnSpill;
    }

    public boolean isIgnoreInputTextSelection() {
        return ignoreInputTextSelection;
    }

    public void setIgnoreInputTextSelection(boolean ignoreInputTextSelection) {
        this.ignoreInputTextSelection = ignoreInputTextSelection;
    }

    public JsDragula getDragula() {
        return dragula;
    }

    public void setDragula(JsDragula dragula) {
        this.dragula = dragula;
    }
}
