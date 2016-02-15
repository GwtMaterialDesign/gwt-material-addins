package gwt.material.design.addins.client.ui;

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


import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.HasDraggable;

//@formatter:off

/**
 * Drag and drop feature on Material Design specs are great UX guide to
 * provide a delightful motion on dragging and dropping gestures.
 * <h3>Initialization</h3>
 * <pre>
 *{@code
 *
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
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#dnd">Drag and Drop</a>
 */
//@formatter:on
public class MaterialDnd implements HasDraggable {

    private Widget target;
    private Widget ignoreFrom;

    public MaterialDnd() {}

    private native void initDraggable(Element target, Element ignoreFrom) /*-{
        $wnd.interact(target)
            .ignoreFrom(ignoreFrom)
            .draggable({
                inertia: true,
                restrict: {
                    restriction: "parent",
                    endOnly: true,
                    elementRect: { top: 0, left: 0, bottom: 1, right: 1 }
                },
                onmove: dragMoveListener,
            });

        function dragMoveListener (event) {
            var target = event.target,
                x = (parseFloat(target.getAttribute('data-x')) || 0) + event.dx,
                y = (parseFloat(target.getAttribute('data-y')) || 0) + event.dy;

            target.style.webkitTransform =
                target.style.transform =
                    'translate(' + x + 'px, ' + y + 'px)';

            target.setAttribute('data-x', x);
            target.setAttribute('data-y', y);
        }
    }-*/;

    @Override
    public void setTarget(final Widget target) {
        this.target = target;
        if(!target.isAttached()) {
            target.addAttachHandler(new AttachEvent.Handler() {
                @Override
                public void onAttachOrDetach(AttachEvent event) {
                    if(event.isAttached()) {
                        initDraggable(target.getElement(), ignoreFrom.getElement());
                    }
                }
            });
        } else {
            initDraggable(target.getElement(), ignoreFrom.getElement());
        }
    }

    @Override
    public Widget getTarget() {
        return target;
    }

    @Override
    public void setIgnoreFrom(Widget ignoreFrom) {
        this.ignoreFrom = ignoreFrom;
    }

    @Override
    public Widget isIgnoreFrom() {
        return ignoreFrom;
    }
}
