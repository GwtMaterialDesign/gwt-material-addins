package gwt.material.design.addins.client.dnd;

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


import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dnd.base.DndHelper;
import gwt.material.design.addins.client.dnd.base.HasDraggable;
import gwt.material.design.addins.client.dnd.base.HasDrop;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.events.*;
import gwt.material.design.addins.client.dnd.js.*;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Axis;

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
public class MaterialDnd extends MaterialWidget implements HasDraggable, HasDrop {

    static {
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialDndDebugClientBundle.INSTANCE.dndDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialDndClientBundle.INSTANCE.dndJs());
        }

    }

    private JsDragOptions draggableOptions;
    private boolean inertia;
    private Axis axis;
    private MaterialWidget target;
    private MaterialWidget ignoreFrom;
    private Restriction restriction = new Restriction();

    private JsDropOptions dropOptions;
    private String acceptSelector;
    private double overlap = 0.75;

    public MaterialDnd() {
        super(Document.get().createDivElement());
    }

    public boolean isInertia() {
        return inertia;
    }

    public void setInertia(boolean inertia) {
        this.inertia = inertia;
    }

    @Override
    public void setTarget(final MaterialWidget target) {
        this.target = target;
    }

    /**
     * Initialize the draggable widget and it's properties
     * @param target
     */
    protected void initDraggable(Element target, boolean inertia, Axis axis, String restriction, boolean endOnly,
                                 double top, double left, double bottom, double right) {
        JsDragOptions options = new JsDragOptions();
        options.inertia = inertia;
        if(axis == Axis.HORIZONTAL) {
            options.axis = "x";
        }else {
            options.axis = "x";
        }
        // Restrict Options
        JsDragRestrictions restrict = new JsDragRestrictions();
        restrict.restriction = restriction;
        restrict.endOnly = endOnly;
        // Element Rec Options
        JsDragElementRec elementRect = new JsDragElementRec();
        elementRect.top = top;
        elementRect.left = left;
        elementRect.bottom = bottom;
        elementRect.right = right;
        restrict.elementRect  = elementRect;
        options.restrict = restrict;
        // Events
        JsDnd.interact(target).off("dragmove");
        JsDnd.interact(target).on("dragmove", (event, o) -> {
            DndHelper.initMove(event);
            DragMoveEvent.fire(MaterialDnd.this);
            return true;
        });

        JsDnd.interact(target).off("dragstart");
        JsDnd.interact(target).on("dragstart", (event, o) -> {
            DragStartEvent.fire(MaterialDnd.this);
            return true;
        });
        JsDnd.interact(target).off("dragend");
        JsDnd.interact(target).on("dragend", (event, o) -> {
            DragEndEvent.fire(MaterialDnd.this);
            return true;
        });
        this.draggableOptions = options;
    }

    @Override
    public void draggable() {
        if(!target.isAttached()) {
            target.addAttachHandler(event -> {
                if(event.isAttached()) {
                    initDraggable(target.getElement(), isInertia(), getAxis(), restriction.getRestriction().getValue(), restriction.isEndOnly(),
                            restriction.getTop(), restriction.getLeft(), restriction.getBottom(), restriction.getRight());
                    JsDnd.interact(getTarget().getElement()).draggable(draggableOptions);
                }
            });
        } else {
            initDraggable(target.getElement(), isInertia(), getAxis(), restriction.getRestriction().getValue(), restriction.isEndOnly(),
                    restriction.getTop(), restriction.getLeft(), restriction.getBottom(), restriction.getRight());
            JsDnd.interact(getTarget().getElement()).draggable(draggableOptions);
        }
    }

    @Override
    public void dropzone() {
        if(!target.isAttached()) {
            target.addAttachHandler(event -> {
                if(event.isAttached()) {
                    initDropzone(getAcceptSelector(), getOverlap());
                    JsDnd.interact(target.getElement()).dropzone(dropOptions);
                }
            });
        } else {
            initDropzone(getAcceptSelector(), getOverlap());
            JsDnd.interact(target.getElement()).dropzone(dropOptions);
        }
    }

    protected void initDropzone(String accept, double overlap) {
        JsDropOptions options = new JsDropOptions();
        options.accept = "." + accept;
        options.overlap = overlap;

        JsDnd.interact(target.getElement()).off("dropactivate");
        JsDnd.interact(target.getElement()).on("dropactivate", (event, o) -> {
            DropActivateEvent.fire(MaterialDnd.this);
            return true;
        });

        JsDnd.interact(target.getElement()).off("dragenter");
        JsDnd.interact(target.getElement()).on("dragenter", (event, o) -> {
            DragEnterEvent.fire(MaterialDnd.this, event.getRelatedTarget());
            return true;
        });

        JsDnd.interact(target.getElement()).off("dragleave");
        JsDnd.interact(target.getElement()).on("dragleave", (event, o) -> {
            DragLeaveEvent.fire(MaterialDnd.this, event.getRelatedTarget());
            return true;
        });

        JsDnd.interact(target.getElement()).off("drop");
        JsDnd.interact(target.getElement()).on("drop", (event, o) -> {
            DropEvent.fire(MaterialDnd.this, event.getRelatedTarget());
            return true;
        });

        JsDnd.interact(target.getElement()).off("dropdeactivate");
        JsDnd.interact(target.getElement()).on("dropdeactivate", (event, o) -> {
            DropDeactivateEvent.fire(MaterialDnd.this);
            return true;
        });

        this.dropOptions = options;
    }

    @Override
    public MaterialWidget getTarget() {
        return target;
    }

    @Override
    public void setIgnoreFrom(final MaterialWidget ignoreFrom) {
        this.ignoreFrom = ignoreFrom;
        if(!getTarget().isAttached() && !ignoreFrom.isAttached()) {
            ignoreFrom.addAttachHandler(event -> {
                if(event.isAttached()) {
                    initIgnoreFrom(getTarget().getElement(), ignoreFrom.getElement());
                }
            });
        }else {
            initIgnoreFrom(getTarget().getElement(), ignoreFrom.getElement());
        }
    }

    @Override
    public void setIgnoreFrom(final String selector) {
        if(!getTarget().isAttached()){
            getTarget().addAttachHandler(event -> {
                initIgnoreFrom(getTarget().getElement(), selector);
            });
        } else {
            initIgnoreFrom(getTarget().getElement(), selector);
        }
    }

    /**
     * Initialize the ignoreFrom function as selector to exclude any widget from dragging
     */
    protected void initIgnoreFrom(Element target, String selector) {
        JsDnd.interact(target).ignoreFrom(selector);
    }

    /**
     * Initialize the ignoreFrom function to exclude any widget from dragging
     */
    protected void initIgnoreFrom(Element target, Element ignoreFrom) {
        JsDnd.interact(target).ignoreFrom(ignoreFrom);
    }

    @Override
    public MaterialWidget isIgnoreFrom() {
        return ignoreFrom;
    }

    @Override
    public void setRestriction(Restriction restriction) {
        this.restriction = restriction;
    }

    @Override
    public Restriction getRestriction() {
        return restriction;
    }

    public Axis getAxis() {
        return axis;
    }

    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    @Override
    public double getOverlap() {
        return overlap;
    }

    @Override
    public HandlerRegistration addDropActivateHandler(DropActivateEvent.DropActivateHandler handler) {
        return addHandler(handler, DropActivateEvent.TYPE);
    }

    @Override
    public HandlerRegistration addDragEnterHandler(DragEnterEvent.DragEnterHandler handler) {
        return addHandler(handler, DragEnterEvent.TYPE);
    }

    @Override
    public HandlerRegistration addDragLeaveHandler(DragLeaveEvent.DragLeaveHandler handler) {
        return addHandler(handler, DragLeaveEvent.TYPE);
    }

    @Override
    public HandlerRegistration addDropDeactivateHandler(DropDeactivateEvent.DropDeactivateHandler handler) {
        return addHandler(handler, DropDeactivateEvent.TYPE);
    }

    @Override
    public HandlerRegistration addDropHandler(DropEvent.DropHandler handler) {
        return addHandler(handler, DropEvent.TYPE);
    }

    @Override
    public void setOverlap(double overlap) {
        this.overlap = overlap;
    }

    @Override
    public String getAcceptSelector() {
        return acceptSelector;
    }

    @Override
    public void setAcceptSelector(String acceptSelector) {
        this.acceptSelector = acceptSelector;
    }

    @Override
    public HandlerRegistration addDragStartHandler(final DragStartEvent.DragStartHandler handler) {
        return addHandler(handler, DragStartEvent.TYPE);
    }

    @Override
    public HandlerRegistration addDragMoveHandler(final DragMoveEvent.DragMoveHandler handler) {
        return addHandler(handler, DragMoveEvent.TYPE);
    }

    @Override
    public HandlerRegistration addDragEndHandler(final DragEndEvent.DragEndHandler handler) {
        return addHandler(handler, DragEndEvent.TYPE);
    }
}