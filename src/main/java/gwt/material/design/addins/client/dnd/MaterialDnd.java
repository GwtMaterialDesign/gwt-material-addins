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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.UIObject;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dnd.base.DndHelper;
import gwt.material.design.addins.client.dnd.js.*;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.events.*;
import gwt.material.design.jquery.client.api.JQuery;

//@formatter:off

/**
 * Drag and drop feature on Material Design specs are great UX guide to
 * provide a delightful motion on dragging and dropping gestures.
 *
 * <h3>Java Usage</h3>
 * <pre>
 *{@code
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
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialDndDebugClientBundle.INSTANCE.dndDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialDndClientBundle.INSTANCE.dndJs());
        }
    }

    private MaterialWidget target;
    private Element ignoreFrom;

    private JsDropOptions dropOptions;
    private JsDragOptions dragOptions;

    protected MaterialDnd() {
    }

    protected static MaterialDnd draggable(MaterialWidget target, MaterialDnd dnd) {
        // Events
        JsDnd jsDnd = JsDnd.interact(target.getElement());
        jsDnd.off("dragmove");
        jsDnd.on("dragmove", (event, o) -> {
            DndHelper.initMove(event);
            DragMoveEvent.fire(target);
            return true;
        });
        jsDnd.off("dragstart");
        jsDnd.on("dragstart", (event, o) -> {
            DragStartEvent.fire(target);
            return true;
        });
        jsDnd.off("dragend");
        jsDnd.on("dragend", (event, o) -> {
            DragEndEvent.fire(target);
            return true;
        });

        jsDnd.draggable(dnd.dragOptions);
        return dnd;
    }

    public static MaterialDnd draggable(MaterialWidget target) {
        return draggable(target, JsDragOptions.create());
    }

    public static MaterialDnd draggable(MaterialWidget target, JsDragOptions options) {
        MaterialDnd dnd = new MaterialDnd();
        dnd.setTarget(target);
        dnd.dragOptions = options;

        // TODO: Validate options

        if(target.isAttached()) {
            draggable(target, dnd);
        } else {
            target.addAttachHandler(event -> draggable(target, dnd), true);
        }
        return dnd;
    }

    protected static MaterialDnd dropzone(MaterialWidget target, MaterialDnd dnd) {
        JsDnd jsDnd = JsDnd.interact(target.getElement());

        jsDnd.off("dropactivate");
        jsDnd.on("dropactivate", (event, o) -> {
            DropActivateEvent.fire(target);
            return true;
        });

        jsDnd.off("dragenter");
        jsDnd.on("dragenter", (event, o) -> {
            DragEnterEvent.fire(target, event.getRelatedTarget());
            return true;
        });

        jsDnd.off("dragleave");
        jsDnd.on("dragleave", (event, o) -> {
            DragLeaveEvent.fire(target, event.getRelatedTarget());
            return true;
        });

        jsDnd.off("drop");
        jsDnd.on("drop", (event, o) -> {
            DropEvent.fire(target, event.getRelatedTarget());
            return true;
        });

        jsDnd.off("dropdeactivate");
        jsDnd.on("dropdeactivate", (event, o) -> {
            DropDeactivateEvent.fire(target);
            return true;
        });

        jsDnd.dropzone(dnd.dropOptions);
        return dnd;
    }

    public static MaterialDnd dropzone(MaterialWidget target) {
        return dropzone(target, JsDropOptions.create());
    }

    public static MaterialDnd dropzone(MaterialWidget target, JsDropOptions options) {
        MaterialDnd dnd = new MaterialDnd();
        dnd.setTarget(target);
        dnd.dropOptions = options;

        // TODO: Validate options

        if(target.isAttached()) {
            dropzone(target, dnd);
        } else {
            target.addAttachHandler(event -> dropzone(target, dnd), true);
        }
        return dnd;
    }

    public void ignoreFrom(UIObject uiObject) {
        ignoreFrom(uiObject.getElement());
    }

    public void ignoreFrom(Element element) {
        this.ignoreFrom = element;
        if(target.isAttached()) {
            JsDnd.interact(target.getElement()).ignoreFrom(element);
        } else {
            target.addAttachHandler(event -> {
                JsDnd.interact(target.getElement()).ignoreFrom(element);
            }, true);
        }
    }

    public void ignoreFrom(String selector) {
        this.ignoreFrom = JQuery.$(selector).asElement();
        if(target.isAttached()) {
            JsDnd.interact(target.getElement()).ignoreFrom(selector);
        } else {
            target.addAttachHandler(event -> {
                JsDnd.interact(target.getElement()).ignoreFrom(selector);
            }, true);
        }
    }

    protected void setTarget(final MaterialWidget target) {
        this.target = target;
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