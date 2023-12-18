/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.addins.client.dnd;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.UIObject;
import elemental2.promise.Promise;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.addins.client.dnd.constants.DragEvents;
import gwt.material.design.addins.client.dnd.constants.DropEvents;
import gwt.material.design.addins.client.dnd.constants.ResizeEvents;
import gwt.material.design.addins.client.dnd.event.InteractDragEvent;
import gwt.material.design.addins.client.dnd.event.dispatch.DragEventDispatcher;
import gwt.material.design.addins.client.dnd.event.dispatch.DropEventDispatcher;
import gwt.material.design.addins.client.dnd.event.dispatch.ResizeEventDispatcher;
import gwt.material.design.addins.client.dnd.event.listener.DefaultDragMoveEventListener;
import gwt.material.design.addins.client.dnd.event.listener.DragEventListener;
import gwt.material.design.addins.client.dnd.js.JsDnd;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.addins.client.dnd.js.JsDropOptions;
import gwt.material.design.addins.client.dnd.js.JsResizableOptions;
import gwt.material.design.client.base.MaterialWidget;

import java.util.Collections;
import java.util.List;

//@formatter:off

/**
 * Drag and drop feature on Material Design specs are great UX guide to
 * provide a delightful motion on dragging and dropping gestures.
 * <p>
 * <h3>Java Usage</h3>
 * <pre>
 * {@code
 *
 * MaterialDnd dnd = new MaterialDnd();
 * // Set the draggable object
 * dnd.setDraggable(widget);
 *
 * // Set the ignored widget when dragging the element
 * dnd.setIgnoreFrom(toolbar);
 *
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#dnd">Drag and Drop</a>
 * @see <a href="https://github.com/taye/interact.js">InteractJs 1.2.6</a>
 */
//@formatter:on
public class MaterialDnd implements HasDependency {

    private JsDnd jsDnd;
    private final MaterialWidget target;
    private Element[] ignoreFrom;
    private JsDropOptions dropOptions;
    private JsDragOptions dragOptions;
    private JsResizableOptions resizableOptions;
    private String ignoreFromClassName;
    private DragEventListener dragMoveListener;
    private DragEventDispatcher dragEventDispatcher;
    private DropEventDispatcher dropEventDispatcher;
    private ResizeEventDispatcher resizeEventDispatcher;
    private DependencyMixin<MaterialDnd> dependencyMixin;

    public MaterialDnd(MaterialWidget target) {
        this.target = target;
        this.dragEventDispatcher = new DragEventDispatcher(target);
        this.dropEventDispatcher = new DropEventDispatcher(target);
        this.resizeEventDispatcher = new ResizeEventDispatcher(target);
    }

    public Promise<MaterialDnd> draggable() {
        return draggable(JsDragOptions.create());
    }
    public Promise<MaterialDnd> draggable(JsDragOptions dragOptions) {
        Promise<MaterialDnd> promise = new Promise<>((resolve, reject) -> {
            getDependencyMixin().install(() -> {
                if (jsDnd == null) {
                    jsDnd = JsDnd.interact(target.getElement());

                    // Events
                    jsDnd.off(DragEvents.DRAG_START).on(DragEvents.DRAG_START, event -> {
                        dragEventDispatcher.fireDragStartEvent();
                        return true;
                    });
                    jsDnd.off(DragEvents.DRAG_MOVE).on(DragEvents.DRAG_MOVE, (event) -> {
                        if (dragMoveListener == null) {
                            dragMoveListener = new DefaultDragMoveEventListener();
                        }
                        dragMoveListener.register((InteractDragEvent) event);
                        dragEventDispatcher.fireDragMoveEvent();
                        return true;
                    });
                    jsDnd.off(DragEvents.DRAG_END).on(DragEvents.DRAG_END, event -> {
                        dragEventDispatcher.fireDragEndEvent();
                        return true;
                    });
                }
                jsDnd.draggable(dragOptions);
                resolve.onInvoke(this);
            });
        });
        return promise;
    }

    public Promise<MaterialDnd> dropzone() {
        return dropzone(JsDropOptions.create());
    }

    public Promise<MaterialDnd> dropzone(JsDropOptions dropOptions) {
        Promise<MaterialDnd> promise = new Promise<>((resolve, reject) -> {
            getDependencyMixin().install(() -> {
                if (jsDnd == null) {
                    jsDnd = JsDnd.interact(target.getElement());

                    // Events
                    jsDnd.off(DropEvents.DROP_ACTIVATE).on(DropEvents.DROP_ACTIVATE, event -> {
                        dropEventDispatcher.fireDropActiveEvent();
                        return true;
                    });
                    jsDnd.off(DragEvents.DRAG_ENTER).on(DragEvents.DRAG_ENTER, event -> {
                        dragEventDispatcher.fireDragEnterEvent(event.getRelatedTarget());
                        return true;
                    });
                    jsDnd.off(DragEvents.DRAG_LEAVE).on(DragEvents.DRAG_LEAVE, event -> {
                        dragEventDispatcher.fireDragLeaveEvent(event.getRelatedTarget());
                        return true;
                    });
                    jsDnd.off(DropEvents.DROP).on(DropEvents.DROP, event -> {
                        dropEventDispatcher.fireDropEvent(event.getRelatedTarget());
                        return true;
                    });
                    jsDnd.off(DropEvents.DROP_DEACTIVATE).on(DropEvents.DROP_DEACTIVATE, event -> {
                        dropEventDispatcher.fireDropDeactivateEvent();
                        return true;
                    });
                }

                jsDnd.dropzone(dropOptions);
                resolve.onInvoke(this);
            });
        });
        return promise;
    }

    public Promise<MaterialDnd> resizable() {
        return resizable(JsResizableOptions.create());
    }

    public Promise<MaterialDnd> resizable(JsResizableOptions resizableOptions) {
        Promise<MaterialDnd> promise = new Promise<>((resolve, reject) -> {
            getDependencyMixin().install(() -> {
                if (jsDnd == null) {
                    jsDnd = JsDnd.interact(target.getElement());
                }
                jsDnd.off(ResizeEvents.RESIZE_MOVE).on(ResizeEvents.RESIZE_MOVE, e -> {
                    resizeEventDispatcher.fireResizeMoveEvent();
                    return true;
                });
                jsDnd.resizable(resizableOptions);
                resolve.onInvoke(this);
            });
        });
        return promise;
    }

    public void unload() {
        unloadDragEvents();
        unloadDropEvents();
    }

    public void unloadDragEvents() {
        jsDnd.off(DragEvents.DRAG_MOVE);
        jsDnd.off(DragEvents.DRAG_START);
        jsDnd.off(DragEvents.DRAG_END);
        jsDnd.off(DropEvents.DROP_ACTIVATE);
        jsDnd.off(DragEvents.DRAG_ENTER);
        jsDnd.off(DragEvents.DRAG_LEAVE);
    }

    public void unloadDropEvents() {
        jsDnd.off(DropEvents.DROP_ACTIVATE);
        jsDnd.off(DropEvents.DROP);
        jsDnd.off(DropEvents.DROP_DEACTIVATE);
    }

    public void ignoreFrom(UIObject uiObject) {
        ignoreFrom(uiObject.getElement());
    }

    public void ignoreFrom(Element... elements) {
        this.ignoreFrom = elements;

        String ignoredClass = getIgnoreFromClassName();
        for (Element element : elements) {
            element.addClassName(ignoredClass);
        }

        ignoreFrom("." + ignoredClass);
    }

    public void ignoreFrom(String selector) {
        this.ignoreFromClassName = selector;
        if (target.isAttached()) {
            JsDnd.interact(target.getElement()).ignoreFrom(selector);
        } else {
            target.registerHandler(target.addAttachHandler(event -> JsDnd.interact(target.getElement()).ignoreFrom(selector), true));
        }
    }

    public String getIgnoreFromClassName() {
        if (ignoreFromClassName == null) {
            ignoreFromClassName = AddinsCssName.INTERACT_IGNORED_CONTENT;
        }
        return ignoreFromClassName;
    }

    public MaterialWidget getTarget() {
        return target;
    }

    public Element[] getIgnoreFrom() {
        return ignoreFrom;
    }

    public JsDropOptions getDropOptions() {
        return dropOptions;
    }

    public void setDropOptions(JsDropOptions dropOptions) {
        this.dropOptions = dropOptions;
    }

    public JsDragOptions getDragOptions() {
        return dragOptions;
    }

    public void setDragOptions(JsDragOptions dragOptions) {
        this.dragOptions = dragOptions;
    }

    public DragEventListener getDragMoveListener() {
        return dragMoveListener;
    }

    public void setDragMoveListener(DragEventListener dragMoveListener) {
        this.dragMoveListener = dragMoveListener;
    }

    public JsResizableOptions getResizableOptions() {
        return resizableOptions;
    }

    public void setResizableOptions(JsResizableOptions resizableOptions) {
        this.resizableOptions = resizableOptions;
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(MaterialDndClientBundle.INSTANCE.dndJs(), MaterialDndDebugClientBundle.INSTANCE.dndDebugJs()));
    }

    public DependencyMixin<MaterialDnd> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
