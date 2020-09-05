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

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "jKanban")
public class JKanban extends JQueryElement {

    public JKanban() {}

    @JsConstructor
    public JKanban(KanbanOptions options) {
    }

    @JsMethod
    public native void addElement(String boardId, KanbanItem element);

    @JsMethod
    public native void addForm(String boardId, Element formElement);

    @JsMethod
    public native void addBoards(KanbanBoard[] boards);

    @JsMethod
    public native KanbanItem findElement(String id);

    @JsMethod
    public native void replaceElement(String id, KanbanItem element);

    @JsMethod
    public native String getParentBoardID(String id);

    @JsMethod
    public native KanbanBoard findBoard(String id);

    @JsMethod
    public native KanbanItem[] getBoardElements(String id);

    @JsMethod
    public native void removeElement(String id);

    @JsMethod
    public native void removeBoard(String id);
}
