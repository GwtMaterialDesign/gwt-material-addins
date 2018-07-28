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
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.dnd.constants.DragEvents;
import gwt.material.design.addins.client.dnd.constants.DropEvents;
import gwt.material.design.addins.client.dnd.js.JsDnd;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.addins.client.dnd.js.JsDropOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.events.*;
import gwt.material.design.jquery.client.api.Event;

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
public class MaterialDnd {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialDndDebugClientBundle.INSTANCE.dndDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialDndClientBundle.INSTANCE.dndJs());
        }
    }

    private JsDnd jsDnd;
    private final MaterialWidget target;
    private Element[] ignoreFrom;
    private JsDropOptions dropOptions;
    private JsDragOptions dragOptions;
    private String ignoreFromClassName;

    protected MaterialDnd(MaterialWidget target) {
        this.target = target;
    }

    protected MaterialDnd draggable() {
        if (jsDnd == null) {
            jsDnd = JsDnd.interact(target.getElement());

            // Events
            jsDnd.off(DragEvents.DRAG_MOVE).on(DragEvents.DRAG_MOVE, event -> {
                move(event);
                DragMoveEvent.fire(this.target);
                return true;
            });
            jsDnd.off(DragEvents.DRAG_START).on(DragEvents.DRAG_START, event -> {
                DragStartEvent.fire(this.target);
                return true;
            });
            jsDnd.off(DragEvents.DRAG_END).on(DragEvents.DRAG_END, event -> {
                DragEndEvent.fire(this.target);
                return true;
            });
        }
        jsDnd.draggable(dragOptions);
        return this;
    }

    public MaterialDnd draggable(JsDragOptions options) {
        dragOptions = options;
        if (target.isAttached()) {
            draggable();
        } else {
            target.registerHandler(target.addAttachHandler(event -> draggable(), true));
        }
        return this;
    }

    public static MaterialDnd draggable(MaterialWidget target) {
        return draggable(target, JsDragOptions.create());
    }

    public static MaterialDnd draggable(MaterialWidget target, JsDragOptions options) {
        return new MaterialDnd(target).draggable(options);
    }

    protected MaterialDnd dropzone() {
        if (jsDnd == null) {
            jsDnd = JsDnd.interact(target.getElement());

            // Events
            jsDnd.off(DropEvents.DROP_ACTIVATE).on(DropEvents.DROP_ACTIVATE, event -> {
                DropActivateEvent.fire(this.target);
                return true;
            });
            jsDnd.off(DragEvents.DRAG_ENTER).on(DragEvents.DRAG_ENTER, event -> {
                DragEnterEvent.fire(this.target, event.getRelatedTarget());
                return true;
            });
            jsDnd.off(DragEvents.DRAG_LEAVE).on(DragEvents.DRAG_LEAVE, event -> {
                DragLeaveEvent.fire(this.target, event.getRelatedTarget());
                return true;
            });
            jsDnd.off(DropEvents.DROP).on(DropEvents.DROP, event -> {
                DropEvent.fire(this.target, event.getRelatedTarget());
                return true;
            });
            jsDnd.off(DropEvents.DROP_DEACTIVATE).on(DropEvents.DROP_DEACTIVATE, event -> {
                DropDeactivateEvent.fire(this.target);
                return true;
            });
        }

        jsDnd.dropzone(dropOptions);
        return this;
    }

    public MaterialDnd dropzone(JsDropOptions options) {
        dropOptions = options;
        if (target.isAttached()) {
            dropzone();
        } else {
            target.registerHandler(target.addAttachHandler(event -> dropzone(), true));
        }
        return this;
    }

    public static MaterialDnd dropzone(MaterialWidget target) {
        return dropzone(target, JsDropOptions.create());
    }

    public static MaterialDnd dropzone(MaterialWidget target, JsDropOptions options) {
        return new MaterialDnd(target).dropzone(options);
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

    public JsDragOptions getDragOptions() {
        return dragOptions;
    }

    public static native void move(Event event) /*-{
        var target = event.target,
            x = (parseFloat(target.getAttribute('data-x')) || 0) + event.dx,
            y = (parseFloat(target.getAttribute('data-y')) || 0) + event.dy;

        target.style.webkitTransform =
            target.style.transform =
                'translate(' + x + 'px, ' + y + 'px)';

        target.setAttribute('data-x', x);
        target.setAttribute('data-y', y);
    }-*/;
}