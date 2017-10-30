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
package gwt.material.design.addins.client.swipeable;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.gesture.velocity.js.JsTransitionOptions;
import gwt.material.design.addins.client.gesture.velocity.js.JsVelocity;
import gwt.material.design.addins.client.gesture.velocity.js.JsVelocityOptions;
import gwt.material.design.addins.client.swipeable.base.HasSwipeableHandler;
import gwt.material.design.addins.client.swipeable.events.*;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;

import static gwt.material.design.addins.client.gesture.hammer.js.JsHammer.$;

/**
 * A panel that allows any of its nested children to be swiped away.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {
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
 *
 * @author kevzlou7979
 * @author Ben Dol
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#swipeable">Material Swipeable</a>
 */
//@formatter:on
public class MaterialSwipeablePanel extends MaterialWidget implements JsLoader, HasSwipeableHandler<Widget> {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialSwipeableDebugClientBundle.INSTANCE.swipeableJsDebug());
            MaterialDesignBase.injectCss(MaterialSwipeableDebugClientBundle.INSTANCE.swipeableCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialSwipeableClientBundle.INSTANCE.swipeableJs());
            MaterialDesignBase.injectCss(MaterialSwipeableClientBundle.INSTANCE.swipeableCss());
        }
    }

    public MaterialSwipeablePanel() {
        super(Document.get().createDivElement(), AddinsCssName.SWIPEABLE);
    }

    public MaterialSwipeablePanel(Color backgroundColor) {
        this();
        setBackgroundColor(backgroundColor);
    }

    public MaterialSwipeablePanel(Color backgroundColor, Integer shadow) {
        this(backgroundColor);
        setShadow(shadow);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        for (Widget w : getChildren()) {
            if (!w.getStyleName().contains(AddinsCssName.IGNORED)) {
                load(w.getElement(), w);
            }
        }
    }

    protected void load(Element container, Widget target) {
        JQueryElement parent = $(container);
        parent.each((object, element) -> {
            boolean swipeLeftToRight[] = {false};
            boolean swipeRightToLeft[] = {false};

            $(element).hammer().bind("pan", (result) -> {
                int direction = result.gesture.direction;
                int x = result.gesture.deltaX;
                double velocityX = result.gesture.velocityX;

                JsVelocity.$(container).velocity(buildVelocityOption(x), buildTransitionOption(50, false, "easeOutQuad", null));

                if (direction == 4 && (x > parent.innerWidth() || velocityX < -0.75)) {
                    swipeLeftToRight[0] = true;
                }

                if (direction == 2 && (x < (-1 * parent.innerWidth() / 2) || velocityX > 0.75)) {
                    swipeRightToLeft[0] = true;
                }

            }).bind("panend", e -> {
                // Reset if collection is moved back into original position
                if (Math.abs(e.gesture.deltaX) < ($(element).innerWidth() / 2)) {
                    swipeLeftToRight[0] = false;
                    swipeRightToLeft[0] = false;
                }

                // Sets final position once pan ended
                if (swipeLeftToRight[0] || swipeRightToLeft[0]) {
                    double fullWidth = 0;
                    if (swipeLeftToRight[0]) {
                        fullWidth = parent.innerWidth();
                        SwipeRightEvent.fire(MaterialSwipeablePanel.this, target);
                    }

                    if (swipeRightToLeft[0]) {
                        fullWidth = -1 * parent.innerWidth();
                        SwipeLeftEvent.fire(MaterialSwipeablePanel.this, target);
                    }

                    Functions.Func completeCallback = () -> {
                        parent.css("border", "none");
                        JsVelocity.$(parent).velocity(buildVelocityOption(0, 0), buildTransitionOption(200, false, "easeQuadOut", () -> parent.remove()));
                    };

                    JsVelocity.$(parent).velocity(buildVelocityOption(fullWidth), buildTransitionOption(100, false, "easeOutQuad", completeCallback));
                } else {
                    JsVelocity.$(parent).velocity(buildVelocityOption(0), buildTransitionOption(100, false, "easeQuad", null));
                }
            });
        });
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        for (Widget widget : getChildren()) {
            JQueryElement element = $(widget.getElement());
            element.off("pan");
            element.off("panend");
        }
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    protected JsVelocityOptions buildVelocityOption(double translateX) {
        JsVelocityOptions option = new JsVelocityOptions();
        option.translateX = translateX;
        return option;
    }

    protected JsVelocityOptions buildVelocityOption(double height, double padding) {
        JsVelocityOptions option = new JsVelocityOptions();
        option.height = 0;
        option.padding = 0;
        return option;
    }

    protected JsTransitionOptions buildTransitionOption(int duration, boolean queue, String easing, Functions.Func completeCallback) {
        JsTransitionOptions option = new JsTransitionOptions();
        option.duration = duration;
        option.easing = easing;
        option.queue = queue;
        if (completeCallback != null) {
            option.complete = completeCallback;
        }
        return option;
    }

    /**
     * Ignore any elements to be swipeable
     */
    public void ignore(UIObject object, UIObject... objects) {
        object.addStyleName(AddinsCssName.IGNORED);

        if (objects != null) {
            for (UIObject obj : objects) {
                obj.addStyleName(AddinsCssName.IGNORED);
            }
        }
    }

    /**
     * Remove Ignore property to any ignored elements
     */
    public void removeIgnore(UIObject object, UIObject... objects) {
        object.removeStyleName(AddinsCssName.IGNORED);

        if (objects != null) {
            for (UIObject obj : objects) {
                obj.removeStyleName(AddinsCssName.IGNORED);
            }
        }
    }

    @Override
    public HandlerRegistration addSwipeLeftHandler(final SwipeLeftEvent.SwipeLeftHandler<Widget> handler) {
        return addHandler(new SwipeLeftEvent.SwipeLeftHandler<Widget>() {
            @Override
            public void onSwipeLeft(SwipeLeftEvent<Widget> event) {
                if (isEnabled()) {
                    handler.onSwipeLeft(event);
                }
            }
        }, SwipeLeftEvent.getType());
    }

    @Override
    public HandlerRegistration addSwipeRightHandler(final SwipeRightEvent.SwipeRightHandler<Widget> handler) {
        return addHandler(new SwipeRightEvent.SwipeRightHandler<Widget>() {
            @Override
            public void onSwipeRight(SwipeRightEvent<Widget> event) {
                if (isEnabled()) {
                    handler.onSwipeRight(event);
                }
            }
        }, SwipeRightEvent.getType());
    }

    @Override
    public HandlerRegistration addOnStartSwipeLeftHandler(OnStartSwipeLeftEvent.OnStartSwipeLeftHandler<Widget> handler) {
        return addHandler(handler, OnStartSwipeLeftEvent.getType());
    }

    @Override
    public HandlerRegistration addOnStartSwipeRightHandler(OnStartSwipeRightEvent.OnStartSwipeRightHandler<Widget> handler) {
        return addHandler(handler, OnStartSwipeRightEvent.getType());
    }

    @Override
    public HandlerRegistration addOnEndSwipeLeftHandler(OnEndSwipeLeftEvent.OnEndSwipeLeftHandler<Widget> handler) {
        return addHandler(handler, OnEndSwipeLeftEvent.getType());
    }

    @Override
    public HandlerRegistration addOnEndSwipeRightHandler(OnEndSwipeRightEvent.OnEndSwipeRightHandler<Widget> handler) {
        return addHandler(handler, OnEndSwipeRightEvent.getType());
    }
}
