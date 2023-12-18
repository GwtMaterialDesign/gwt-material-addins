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
import elemental2.promise.Promise;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.addins.client.dragula.js.JsDragula;
import gwt.material.design.addins.client.dragula.js.JsDragulaOptions;

import java.util.Collections;
import java.util.List;

public class MaterialDragula implements HasDependency {

    private DependencyMixin<MaterialDragula> dependencyMixin;
    private JsDragulaOptions options = JsDragulaOptions.create();
    private JsDragula dragula;

    public MaterialDragula() {}

    public Promise<MaterialDragula> apply(Element... elements) {
        Promise<MaterialDragula> promise = new Promise<>((resolve, reject) -> {
            getDependencyMixin().install(() -> {
                dragula = JsDragula.dragula(elements, options);
                resolve.onInvoke(this);
            });
        });
        return promise;
    }

    public String getDirection() {
        return options.direction;
    }

    public void setDirection(String direction) {
        options.direction = direction;
    }

    public boolean isCopy() {
        return options.copy;
    }

    public void setCopy(boolean copy) {
        options.copy = copy;
    }

    public boolean isCopySortSource() {
        return options.copySortSource;
    }

    public void setCopySortSource(boolean copySortSource) {
        options.copySortSource = copySortSource;
    }

    public boolean isRevertOnSpill() {
        return options.revertOnSpill;
    }

    public void setRevertOnSpill(boolean revertOnSpill) {
        options.revertOnSpill = revertOnSpill;
    }

    public boolean isRemoveOnSpill() {
        return options.removeOnSpill;
    }

    public void setRemoveOnSpill(boolean removeOnSpill) {
        this.options.removeOnSpill = removeOnSpill;
    }

    public boolean isIgnoreInputTextSelection() {
        return options.ignoreInputTextSelection;
    }

    public void setIgnoreInputTextSelection(boolean ignoreInputTextSelection) {
        options.ignoreInputTextSelection = ignoreInputTextSelection;
    }

    public JsDragula getDragula() {
        return dragula;
    }

    public void setDragula(JsDragula dragula) {
        this.dragula = dragula;
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(MaterialDragulaClientBundle.INSTANCE.dragulaJs(), MaterialDragulaClientBundle.INSTANCE.dragulaDebugJs()));
    }

    public DependencyMixin<MaterialDragula> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
