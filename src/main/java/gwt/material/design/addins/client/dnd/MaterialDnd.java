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
package gwt.material.design.addins.client.dnd;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.UIObject;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dnd.base.DndHelper;
import gwt.material.design.addins.client.dnd.js.JsDnd;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.addins.client.dnd.js.JsDropOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.events.*;
import gwt.material.design.jquery.client.api.Functions.EventFunc;
import gwt.material.design.jquery.client.api.JQuery;

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
    private Element ignoreFrom;

    private JsDropOptions dropOptions;
    private JsDragOptions dragOptions;

    private EventFunc dragmove, dragstart, dragend, dropactivate,
                      dragenter, dragleave, drop, dropdeactivate;

    protected MaterialDnd(MaterialWidget target) {
        this.target = target;
        dragmove = event -> {
            DndHelper.initMove(event);
            DragMoveEvent.fire(target);
            return true;
        };
        dragstart = event -> {
            DragStartEvent.fire(target);
            return true;
        };
        dragend = event -> {
            DragEndEvent.fire(target);
            return true;
        };
        dropactivate = event -> {
            DropActivateEvent.fire(target);
            return true;
        };
        dragenter = event -> {
            DragEnterEvent.fire(target, event.getRelatedTarget());
            return true;
        };
        dragleave = event -> {
            DragLeaveEvent.fire(target, event.getRelatedTarget());
            return true;
        };
        drop = event -> {
            DropEvent.fire(target, event.getRelatedTarget());
            return true;
        };
        dropdeactivate = event -> {
            DropDeactivateEvent.fire(target);
            return true;
        };
    }

    protected MaterialDnd draggable() {
        if(jsDnd == null) {
            jsDnd = JsDnd.interact(target.getElement());
        }
        // Events
        jsDnd.off("dragmove", dragmove);
        jsDnd.on("dragmove", dragmove);

        jsDnd.off("dragstart", dragstart);
        jsDnd.on("dragstart", dragstart);

        jsDnd.off("dragend", dragend);
        jsDnd.on("dragend", dragend);

        jsDnd.draggable(dragOptions);
        return this;
    }

    public MaterialDnd draggable(JsDragOptions options) {
        dragOptions = options;
        // TODO: Validate options
        if (target.isAttached()) {
            draggable();
        } else {
            target.addAttachHandler(event -> draggable(), true);
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
        if(jsDnd == null) {
            jsDnd = JsDnd.interact(target.getElement());
        }
        jsDnd.off("dropactivate", dropactivate);
        jsDnd.on("dropactivate", dropactivate);

        jsDnd.off("dragenter", dragenter);
        jsDnd.on("dragenter", dragenter);

        jsDnd.off("dragleave", dragleave);
        jsDnd.on("dragleave", dragleave);

        jsDnd.off("drop", drop);
        jsDnd.on("drop", drop);

        jsDnd.off("dropdeactivate", dropdeactivate);
        jsDnd.on("dropdeactivate", dropdeactivate);

        jsDnd.dropzone(dropOptions);
        return this;
    }

    public MaterialDnd dropzone(JsDropOptions options) {
        dropOptions = options;
        // TODO: Validate options
        if (target.isAttached()) {
            dropzone();
        } else {
            target.addAttachHandler(event -> dropzone(), true);
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

    public void ignoreFrom(Element element) {
        this.ignoreFrom = element;
        if (target.isAttached()) {
            JsDnd.interact(target.getElement()).ignoreFrom(element);
        } else {
            target.addAttachHandler(event -> {
                JsDnd.interact(target.getElement()).ignoreFrom(element);
            }, true);
        }
    }

    public void ignoreFrom(String selector) {
        this.ignoreFrom = JQuery.$(selector).asElement();
        if (target.isAttached()) {
            JsDnd.interact(target.getElement()).ignoreFrom(selector);
        } else {
            target.addAttachHandler(event -> {
                JsDnd.interact(target.getElement()).ignoreFrom(selector);
            }, true);
        }
    }

    public MaterialWidget getTarget() {
        return target;
    }

    public Element getIgnoreFrom() {
        return ignoreFrom;
    }

    public JsDropOptions getDropOptions() {
        return dropOptions;
    }

    public JsDragOptions getDragOptions() {
        return dragOptions;
    }
}