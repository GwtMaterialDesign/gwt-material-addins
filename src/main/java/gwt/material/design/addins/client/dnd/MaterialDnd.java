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
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.addins.client.dnd.base.HasDraggable;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.events.DragEndEvent;
import gwt.material.design.addins.client.dnd.events.DragMoveEvent;
import gwt.material.design.addins.client.dnd.events.DragStartEvent;
import gwt.material.design.client.base.MaterialWidget;

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
public class MaterialDnd extends MaterialWidget implements HasDraggable {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectDebugJs(MaterialDndDebugClientBundle.INSTANCE.dndDebugJs());
        } else {
            MaterialResourceInjector.injectJs(MaterialDndClientBundle.INSTANCE.dndJs());
        }

    }

    private boolean inertia;
    private Widget target;
    private Widget ignoreFrom;
    private Restriction restriction = new Restriction();

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
    public void setTarget(final Widget target) {
        this.target = target;
        if(!target.isAttached()) {
            target.addAttachHandler(new AttachEvent.Handler() {
                @Override
                public void onAttachOrDetach(AttachEvent event) {
                    if(event.isAttached()) {
                        initDraggable(target.getElement(), isInertia(), restriction.getRestriction().getValue(), restriction.isEndOnly(),
                                restriction.getTop(), restriction.getLeft(), restriction.getBottom(), restriction.getRight());
                    }
                }
            });
        } else {
            initDraggable(target.getElement(), isInertia(), restriction.getRestriction().getValue(), restriction.isEndOnly(),
                    restriction.getTop(), restriction.getLeft(), restriction.getBottom(), restriction.getRight());
        }
    }

    /**
     * Initialize the draggable widget and it's properties
     * @param target
     */
    private native void initDraggable(Element target, boolean inertia, String restriction, boolean endOnly,
                                      double top, double left, double bottom, double right) /*-{
        var that = this;
        $wnd.jQuery(document).ready(function() {
            $wnd.interact(target)
                .draggable({
                    inertia: inertia,
                    restrict: {
                        restriction: restriction,
                        endOnly: endOnly,
                        elementRect: { top: top, left: left, bottom: bottom, right: right}
                    },
                    onstart: dragStartListener,
                    onmove: dragMoveListener,
                    onend: dragEndListener,
                });

            function dragEndListener(event) {
                that.@gwt.material.design.addins.client.dnd.MaterialDnd::fireDragEndEvent()();
            }

            function dragStartListener(event) {
                that.@gwt.material.design.addins.client.dnd.MaterialDnd::fireDragStartEvent()();
            }

            function dragMoveListener (event) {
                var target = event.target,
                    x = (parseFloat(target.getAttribute('data-x')) || 0) + event.dx,
                    y = (parseFloat(target.getAttribute('data-y')) || 0) + event.dy;

                target.style.webkitTransform =
                    target.style.transform =
                        'translate(' + x + 'px, ' + y + 'px)';

                target.setAttribute('data-x', x);
                target.setAttribute('data-y', y);
                that.@gwt.material.design.addins.client.dnd.MaterialDnd::fireDragMoveEvent()();
            }
        });
    }-*/;

    @Override
    public Widget getTarget() {
        return target;
    }

    @Override
    public void setIgnoreFrom(final Widget ignoreFrom) {
        this.ignoreFrom = ignoreFrom;
        if(!target.isAttached() && !ignoreFrom.isAttached()) {
            ignoreFrom.addAttachHandler(new AttachEvent.Handler() {
                @Override
                public void onAttachOrDetach(AttachEvent event) {
                    if(event.isAttached()) {
                        initIgnoreFrom(target.getElement(), ignoreFrom.getElement());
                    }
                }
            });
        }else {
            initIgnoreFrom(target.getElement(), ignoreFrom.getElement());
        }
    }

    @Override
    public void setIgnoreFrom(final String selector) {
        if(!target.isAttached()){
            target.addAttachHandler(new AttachEvent.Handler() {
                @Override
                public void onAttachOrDetach(AttachEvent event) {
                    initIgnoreFrom(target.getElement(), selector);
                }
            });
        } else {
            initIgnoreFrom(target.getElement(), selector);
        }
    }

    /**
     * Initialize the ignoreFrom function as selector to exclude any widget from dragging
     */
    private native void initIgnoreFrom(Element target, String selector) /*-{
        $wnd.interact(target).ignoreFrom(selector);
    }-*/;

    /**
     * Initialize the ignoreFrom function to exclude any widget from dragging
     */
    private native void initIgnoreFrom(Element target, Element ignoreFrom) /*-{
        $wnd.interact(target).ignoreFrom(ignoreFrom);
    }-*/;

    @Override
    public Widget isIgnoreFrom() {
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

    @Override
    public HandlerRegistration addDragStartHandler(final DragStartEvent.DragStartHandler handler) {
        return addHandler(new DragStartEvent.DragStartHandler() {
            @Override
            public void onDragStart(DragStartEvent event) {
                if(isEnabled()){
                    handler.onDragStart(event);
                }
            }
        }, DragStartEvent.TYPE);
    }

    private void fireDragStartEvent() {
        DragStartEvent.fire(this);
    }

    @Override
    public HandlerRegistration addDragMoveHandler(final DragMoveEvent.DragMoveHandler handler) {
        return addHandler(new DragMoveEvent.DragMoveHandler() {
            @Override
            public void onDragMove(DragMoveEvent event) {
                if(isEnabled()){
                    handler.onDragMove(event);
                }
            }
        }, DragMoveEvent.TYPE);
    }

    private void fireDragMoveEvent() {
        DragMoveEvent.fire(this);
    }

    @Override
    public HandlerRegistration addDragEndHandler(final DragEndEvent.DragEndHandler handler) {
        return addHandler(new DragEndEvent.DragEndHandler() {
            @Override
            public void onDragEnd(DragEndEvent event) {
                if(isEnabled()){
                    handler.onDragEnd(event);
                }
            }
        }, DragEndEvent.TYPE);
    }

    private void fireDragEndEvent() {
        DragEndEvent.fire(this);
    }
}