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
