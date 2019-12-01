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
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Arrays;
import java.util.List;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class KanbanOptions {


    protected KanbanOptions() {
    }

    @JsOverlay
    public static final KanbanOptions create() {
        String Z_DEPTH_1 = "z-depth-1";
        KanbanOptions options = new KanbanOptions();
        options.setWidthBoard("360px");
        options.setDragEl((element, source) -> {
            if (element != null && !element.hasClassName(Z_DEPTH_1)) {
                element.addClassName(Z_DEPTH_1);
            }
        });
        options.setDragendEl(element -> {
            if (element != null && element.hasClassName(Z_DEPTH_1)) {
                element.removeClassName(Z_DEPTH_1);
            }
        });
        return options;
    }

    @JsProperty
    private String element;

    @JsProperty
    private String gutter;

    @JsProperty
    private String widthBoard;

    @JsProperty
    private boolean responsivePercentage;

    @JsProperty
    private boolean dragItems;

    @JsProperty
    private KanbanBoard[] boards;

    @JsProperty
    private boolean dragBoards;

    @JsProperty
    private boolean addItemButton;

    @JsProperty
    private String buttonContent;

    @JsProperty
    private Functions.Func1<Element> click;

    @JsProperty
    private Functions.Func2<Element, Object> dragEl;

    @JsProperty
    private Functions.Func1<Element> dragendEl;

    @JsProperty
    private Func4<Element, Object, Object, Object> dropEl;

    @JsProperty
    private Functions.Func2<Element, Object> dragBoard;

    @JsProperty
    private Functions.Func1<Element> dragendBoard;

    @JsProperty
    private Functions.Func2<Element, Object> buttonClick;

    @JsOverlay
    public final String getElement() {
        return element;
    }

    @JsOverlay
    public final void setElement(String element) {
        this.element = element;
    }

    @JsOverlay
    public final String getGutter() {
        return gutter;
    }

    @JsOverlay
    public final void setGutter(String gutter) {
        this.gutter = gutter;
    }

    @JsOverlay
    public final String getWidthBoard() {
        return widthBoard;
    }

    @JsOverlay
    public final void setWidthBoard(String widthBoard) {
        this.widthBoard = widthBoard;
    }

    @JsOverlay
    public final boolean isResponsivePercentage() {
        return responsivePercentage;
    }

    @JsOverlay
    public final void setResponsivePercentage(boolean responsivePercentage) {
        this.responsivePercentage = responsivePercentage;
    }

    @JsOverlay
    public final boolean isDragItems() {
        return dragItems;
    }

    @JsOverlay
    public final void setDragItems(boolean dragItems) {
        this.dragItems = dragItems;
    }

    @JsOverlay
    public final List<KanbanBoard> getBoards() {
        return Arrays.asList(boards);
    }

    @JsOverlay
    public final void setBoards(List<KanbanBoard> boards) {
        this.boards = boards.toArray(new KanbanBoard[0]);
    }

    @JsOverlay
    public final boolean isDragBoards() {
        return dragBoards;
    }

    @JsOverlay
    public final void setDragBoards(boolean dragBoards) {
        this.dragBoards = dragBoards;
    }

    @JsOverlay
    public final boolean isAddItemButton() {
        return addItemButton;
    }

    @JsOverlay
    public final void setAddItemButton(boolean addItemButton) {
        this.addItemButton = addItemButton;
    }

    @JsOverlay
    public final String getButtonContent() {
        return buttonContent;
    }

    @JsOverlay
    public final void setButtonContent(String buttonContent) {
        this.buttonContent = buttonContent;
    }

    @JsOverlay
    public final Functions.Func1<Element> getClick() {
        return click;
    }

    @JsOverlay
    public final void setClick(Functions.Func1<Element> click) {
        this.click = click;
    }

    @JsOverlay
    public final Functions.Func2<Element, Object> getDragEl() {
        return dragEl;
    }

    @JsOverlay
    public final void setDragEl(Functions.Func2<Element, Object> dragEl) {
        this.dragEl = dragEl;
    }

    @JsOverlay
    public final Functions.Func1<Element> getDragendEl() {
        return dragendEl;
    }

    @JsOverlay
    public final void setDragendEl(Functions.Func1<Element> dragendEl) {
        this.dragendEl = dragendEl;
    }

    @JsOverlay
    public final Func4<Element, Object, Object, Object> getDropEl() {
        return dropEl;
    }

    @JsOverlay
    public final void setDropEl(Func4<Element, Object, Object, Object> dropEl) {
        this.dropEl = dropEl;
    }

    @JsOverlay
    public final Functions.Func2<Element, Object> getDragBoard() {
        return dragBoard;
    }

    @JsOverlay
    public final void setDragBoard(Functions.Func2<Element, Object> dragBoard) {
        this.dragBoard = dragBoard;
    }

    @JsOverlay
    public final Functions.Func1<Element> getDragendBoard() {
        return dragendBoard;
    }

    @JsOverlay
    public final void setDragendBoard(Functions.Func1<Element> dragendBoard) {
        this.dragendBoard = dragendBoard;
    }

    @JsOverlay
    public final Functions.Func2<Element, Object> getButtonClick() {
        return buttonClick;
    }

    @JsOverlay
    public final void setButtonClick(Functions.Func2<Element, Object> buttonClick) {
        this.buttonClick = buttonClick;
    }

    interface Func4<A, B, C, D> {
        void call(A param1, B param2, C param3, D param4);
    }
}
