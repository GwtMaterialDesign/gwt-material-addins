package gwt.material.design.addins.client.ui;

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
import gwt.material.design.client.base.HasPosition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.Position;

//@formatter:off

/**
 * Bubble component used on chat module
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:m.addins='urn:import:gwt.material.design.addins.client.ui'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 *{@code
<m:MaterialBubble backgroundColor="white darken-1" position="LEFT" float="LEFT">
    <m:MaterialLabel text="I love Material Design"/>
    <m:MaterialLabel text="Dec 12, 2015" fontSize="0.8" textColor="grey"/>
</m:MaterialBubble>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#bubble">Material Bubble</a>
 */
//@formatter:on
public class MaterialBubble extends MaterialWidget implements HasPosition {

    private MaterialWidget triangle;
    private final CssNameMixin<MaterialWidget, Position> positionMixin;

    public MaterialBubble() {
        super(Document.get().createSpanElement());
        setStyleName("bubble");
        triangle = new MaterialWidget(Document.get().createDivElement());
        triangle.setStyleName("triangle");
        positionMixin = new CssNameMixin<>(triangle);
        add(triangle);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initBubble(getElement(), ColorHelper.setupComputedBackgroundColor(getBackgroundColor()), getPosition().getCssName());
    }

    /**
     * Initialize the bubble component
     * @param element - element to be set
     * @param color - color of the bubble
     * @param type - type of the bubble (RIGHT, TOP, LEFT, BOTTOM)
     */
    private native void initBubble(Element element, String color, String type) /*-{
        $wnd.jQuery(document).ready(function() {
            $wnd.jQuery(element).bubble({
                position: type,
                color: color
            });
        });
    }-*/;

    @Override
    public Position getPosition() {
        return positionMixin.getCssName();
    }

    @Override
    public void setPosition(Position position) {
        positionMixin.setCssName(position);
    }
}
