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
import gwt.material.design.addins.client.swipeable.base.HasSwipeable;
import gwt.material.design.addins.client.swipeable.events.SwipeLeftEvent;
import gwt.material.design.addins.client.swipeable.events.SwipeRightEvent;
import gwt.material.design.addins.client.swipeable.js.JsSwipeable;
import gwt.material.design.client.MaterialDesignBase;
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
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialSwipeableDebugClientBundle.INSTANCE.swipeableJsDebug());
            MaterialDesignBase.injectCss(MaterialSwipeableDebugClientBundle.INSTANCE.swipeableCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialSwipeableClientBundle.INSTANCE.swipeableJs());
            MaterialDesignBase.injectCss(MaterialSwipeableClientBundle.INSTANCE.swipeableCss());
        }
    }

    private final String IGNORED = "swipe-ignored";

    public MaterialSwipeablePanel() {
        super(Document.get().createDivElement(), "swipeable");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        for(Widget w : getChildren()) {
            if(!w.getStyleName().contains(IGNORED)) {
                initSwipeable(w.getElement(), w);
            }
        }
    }

    @Override
    public void initSwipeable(Element element, Widget target) {
        JsSwipeable.initSwipeablePanel(element, () -> {
            SwipeLeftEvent.fire(MaterialSwipeablePanel.this, target);
        }, () -> {
            SwipeRightEvent.fire(MaterialSwipeablePanel.this, target);
        });
    }

    @Override
    public HandlerRegistration addSwipeLeft(final SwipeLeftEvent.SwipeLeftHandler<Widget> handler) {
        return addHandler(new SwipeLeftEvent.SwipeLeftHandler<Widget>() {
            @Override
            public void onSwipeLeft(SwipeLeftEvent<Widget> event) {
                if(isEnabled()) {
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
                if(isEnabled()) {
                    handler.onSwipeRight(event);
                }
            }
        }, SwipeRightEvent.getType());
    }

    public void ignore(UIObject object, UIObject... objects) {
        object.addStyleName(IGNORED);

        if(objects != null) {
            for(UIObject obj : objects) {
                obj.addStyleName(IGNORED);
            }
        }
    }
}
