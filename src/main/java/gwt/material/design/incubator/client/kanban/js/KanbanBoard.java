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
