package gwt.material.design.addins.client.bubble;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.bubble.js.JsBubbleOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasPosition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.Position;

import static gwt.material.design.addins.client.bubble.js.JsBubble.$;

//@formatter:off

/**
 * Bubble component used on chat module
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
 * {@code
 * <ma:bubble.MaterialBubble backgroundColor="white darken-1" position="LEFT" float="LEFT">
 *   <m:MaterialLabel text="I love Material Design"/>
 *   <m:MaterialLabel text="Dec 12, 2015" fontSize="0.8" textColor="grey"/>
 * </ma:bubble.MaterialBubble>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#bubble">Material Bubble</a>
 */
//@formatter:on
public class MaterialBubble extends MaterialWidget implements HasPosition {

    private MaterialWidget triangle;
    private final CssNameMixin<MaterialWidget, Position> positionMixin;

    static {
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialBubbleDebugClientBundle.INSTANCE.bubbleJsDebug());
            MaterialDesignBase.injectCss(MaterialBubbleDebugClientBundle.INSTANCE.bubbleCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialBubbleClientBundle.INSTANCE.bubbleJs());
            MaterialDesignBase.injectCss(MaterialBubbleClientBundle.INSTANCE.bubbleCss());
        }
    }

    public MaterialBubble() {
        super(Document.get().createSpanElement(), "bubble");
        triangle = new MaterialWidget(Document.get().createDivElement());
        triangle.setStyleName("triangle");
        positionMixin = new CssNameMixin<>(triangle);
        add(triangle);
        setShadow(1);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initBubble(ColorHelper.setupComputedBackgroundColor(getBackgroundColor()), getPosition().getCssName());
    }

    /**
     * Initialize the bubble component
     * @param color - color of the bubble
     * @param position - position of the bubble (RIGHT, TOP, LEFT, BOTTOM)
     */
    protected void initBubble(String color, String position) {
        JsBubbleOptions options = new JsBubbleOptions();
        options.position = position;
        options.color = color;
        $(getElement()).bubble(options);
    }

    @Override
    public Position getPosition() {
        return positionMixin.getCssName();
    }

    @Override
    public void setPosition(Position position) {
        positionMixin.setCssName(position);
    }
}
