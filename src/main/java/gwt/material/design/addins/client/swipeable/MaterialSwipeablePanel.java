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
package gwt.material.design.addins.client.swipeable;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.swipeable.base.HasSwipeableHandler;
import gwt.material.design.addins.client.swipeable.events.SwipeLeftEvent;
import gwt.material.design.addins.client.swipeable.events.SwipeRightEvent;
import gwt.material.design.addins.client.swipeable.js.JsSwipeable;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;

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
public class MaterialSwipeablePanel extends MaterialWidget implements HasSwipeableHandler<Widget> {

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
    protected void initialize() {
        for (Widget w : getChildren()) {
            if (!w.getStyleName().contains(AddinsCssName.IGNORED)) {
                initialize(w.getElement(), w);
            }
        }
    }

    protected void initialize(Element element, Widget target) {
        JsSwipeable.initSwipeablePanel(element, () -> {
            SwipeLeftEvent.fire(MaterialSwipeablePanel.this, target);
        }, () -> SwipeRightEvent.fire(MaterialSwipeablePanel.this, target));
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
}
