/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.incubator.client.kanban.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Arrays;
import java.util.List;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class KanbanBoard {

    @JsProperty
    private String id;

    @JsProperty
    private String title;

    @JsProperty
    private String dragTo;

    @JsProperty
    private KanbanItem[] item;

    @JsOverlay
    public final String getId() {
        return id;
    }

    @JsOverlay
    public final void setId(String id) {
        this.id = id;
    }

    @JsOverlay
    public final String getTitle() {
        return title;
    }

    @JsOverlay
    public final void setTitle(String title) {
        this.title = title;
    }

    @JsOverlay
    public final String getDragTo() {
        return dragTo;
    }

    @JsOverlay
    public final void setDragTo(String dragTo) {
        this.dragTo = dragTo;
    }

    @JsOverlay
    public final List<KanbanItem> getItems() {
        return Arrays.asList(item);
    }

    @JsOverlay
    public final void setItems(List<KanbanItem> items) {
        this.item = items.toArray(new KanbanItem[0]);
    }
}
