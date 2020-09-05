/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.placeholder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.base.MaterialWidget;

public class PlaceholderLoader {

    private int totalItems;
    private MaterialWidget container;
    private PlaceholderRenderer renderer;

    public PlaceholderLoader setContainer(MaterialWidget container) {
        this.container = container;
        return this;
    }

    public PlaceholderLoader setRenderer(PlaceholderRenderer renderer) {
        this.renderer = renderer;
        return this;
    }

    public PlaceholderLoader setTotalItems(int totalItems) {
        this.totalItems = totalItems;
        return this;
    }

    public void load() {
        if (container != null) {
            if (renderer != null) {
                container.clear();
                for (int i = 0; i < totalItems; i++) {
                    Widget widget = renderer.render();
                    container.add(widget);
                }
            } else {
                GWT.log("Widget renderer is not defined");
            }
        } else {
            GWT.log("Container is not defined.", new IllegalStateException());
        }
    }

    public void unload(){
        container.clear();
    }
}
