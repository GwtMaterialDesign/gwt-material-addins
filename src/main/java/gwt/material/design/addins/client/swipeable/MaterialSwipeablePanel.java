package gwt.material.design.addins.client.swipeable;

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

/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.addins.client.swipeable.base.HasSwipeable;
import gwt.material.design.addins.client.swipeable.events.SwipeLeftEvent;
import gwt.material.design.addins.client.swipeable.events.SwipeRightEvent;
import gwt.material.design.client.base.MaterialWidget;

/**
 * A panel that allows any of its nested children to be swiped away.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 *{
 * @code
 * <ma:swipeable.MaterialSwipeablePanel ui:field="swipeablePanel" shadow="1" backgroundColor="white" padding="12">
 *   <m:MaterialLabel text="You can swipe native components. This is a plain label" backgroundColor="yellow" padding="12" />
 *   <m:MaterialCard>
 *     <m:MaterialCardContent>
 *       <m:MaterialLabel text="This is another Card Component that is swipeable." />
 *       </m:MaterialCardContent>
 *     </m:MaterialCard>
 * </ma:swipeable.MaterialSwipeablePanel>
 * }
 * </pre>
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#swipeable">Material Swipeable</a>
 * @author kevzlou7979
 * @author Ben Dol
 */
//@formatter:on
public class MaterialSwipeablePanel extends MaterialWidget implements HasSwipeable<Widget> {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectCss(MaterialSwipeableDebugClientBundle.INSTANCE.swipeableCssDebug());
        } else {
            MaterialResourceInjector.injectCss(MaterialSwipeableClientBundle.INSTANCE.swipeableCss());
        }
    }

    private final String DISABLED = "disabled-swipe";

    public MaterialSwipeablePanel() {
        super(Document.get().createDivElement(), "swipeable");
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        for(Widget w : getChildren()) {
            if(!w.getStyleName().contains(DISABLED)) {
                initSwipeable(w.getElement(), w);
            }
        }
    }


    @Override
    public void initSwipeable(Element element, Widget target) {
        initSwipeableElement(element, target);
    }

    /**
     * Initialize the swipeable element
     * @param element
     * @param target
     */
    private native void initSwipeableElement(Element element, Widget target) /*-{
        var that = this;
        var swipeLeftToRight;
        var swipeRightToLeft;
        // Dismissible Collections
        $wnd.jQuery(element).each(function() {
            $wnd.jQuery(this).hammer({
                prevent_default: false
            }).bind('pan', function(e) {
                if (e.gesture.pointerType === "touch") {
                    var parent = $wnd.jQuery(this);
                    var direction = e.gesture.direction;
                    var x = e.gesture.deltaX;
                    var velocityX = e.gesture.velocityX;

                    parent.velocity({ translateX: x
                    }, {duration: 50, queue: false, easing: 'easeOutQuad'});

                    // Swipe Left
                    if (direction === 4 && (x > (parent.innerWidth() / 2) || velocityX < -0.75)) {
                        swipeLeftToRight = true;
                    }

                    // Swipe Right
                    if (direction === 2 && (x < (-1 * parent.innerWidth() / 2) || velocityX > 0.75)) {
                        swipeRightToLeft = true;
                    }
                }
            }).bind('panend', function(e) {
                // Reset if collection is moved back into original position
                if (Math.abs(e.gesture.deltaX) < ($wnd.jQuery(this).innerWidth() / 2)) {
                    swipeRightToLeft = false;
                    swipeLeftToRight = false;
                }

                if (e.gesture.pointerType === "touch") {
                    var parent = $wnd.jQuery(this);
                    if (swipeLeftToRight || swipeRightToLeft) {
                        var fullWidth;
                        if (swipeLeftToRight) {
                            fullWidth = parent.innerWidth();
                            that.@gwt.material.design.addins.client.swipeable.MaterialSwipeablePanel::fireSwipeRightEvent(*)(target);
                        }
                        else {
                            fullWidth = -1 * parent.innerWidth();
                            that.@gwt.material.design.addins.client.swipeable.MaterialSwipeablePanel::fireSwipeLeftEvent(*)(target);
                        }

                        parent.velocity({ translateX: fullWidth,
                        }, {duration: 100, queue: false, easing: 'easeOutQuad', complete:
                            function() {
                                parent.css('border', 'none');
                                parent.velocity({ height: 0, padding: 0,
                                }, {duration: 200, queue: false, easing: 'easeOutQuad', complete:
                                    function() {
                                        parent.remove();
                                    }
                                });
                            }
                        });
                    }
                    else {
                        parent.velocity({ translateX: 0,
                        }, {duration: 100, queue: false, easing: 'easeOutQuad'});
                    }
                    swipeLeftToRight = false;
                    swipeRightToLeft = false;
                }
            });

        });
    }-*/;

    @Override
    public HandlerRegistration addSwipeLeft(final SwipeLeftEvent.SwipeLeftHandler<Widget> handler) {
        return addHandler(new SwipeLeftEvent.SwipeLeftHandler<Widget>() {
            @Override
            public void onSwipeLeft(SwipeLeftEvent<Widget> event) {
                if(isEnabled()){
                    handler.onSwipeLeft(event);
                }
            }
        }, SwipeLeftEvent.getType());
    }

    @Override
    public HandlerRegistration addSwipeRight(final SwipeRightEvent.SwipeRightHandler<Widget> handler) {
        return addHandler(new SwipeRightEvent.SwipeRightHandler<Widget>() {
            @Override
            public void onSwipeRight(SwipeRightEvent<Widget> event) {
                if(isEnabled()){
                    handler.onSwipeRight(event);
                }
            }
        }, SwipeRightEvent.getType());
    }

    /**
     * Fire the Swipe left event listener
     * @param target
     */
    public void fireSwipeLeftEvent(Widget target) {
        SwipeLeftEvent.fire(MaterialSwipeablePanel.this, target);
    }

    /**
     * Fire the Swipe right event listener
     * @param target
     */
    public void fireSwipeRightEvent(Widget target) {
        SwipeRightEvent.fire(MaterialSwipeablePanel.this, target);
    }

    public void setDisable(Widget... widgets) {
        for(Widget w : widgets){
            w.addStyleName(DISABLED);
        }
    }
}
