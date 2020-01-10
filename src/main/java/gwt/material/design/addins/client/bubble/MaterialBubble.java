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
package gwt.material.design.addins.client.bubble;

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.bubble.js.JsBubbleOptions;
import gwt.material.design.addins.client.combobox.MaterialComboBoxDarkTheme;
import gwt.material.design.addins.client.dark.AddinsDarkThemeReloader;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasPosition;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.Position;

import static gwt.material.design.addins.client.bubble.js.JsBubble.$;

//@formatter:off

/**
 * Bubble component used on chat module
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
public class MaterialBubble extends MaterialWidget implements JsLoader, HasPosition {

    private MaterialWidget triangle = new MaterialWidget(Document.get().createDivElement());
    private CssNameMixin<MaterialWidget, Position> positionMixin;
    private JsBubbleOptions options = new JsBubbleOptions();

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialBubbleDebugClientBundle.INSTANCE.bubbleJsDebug());
            MaterialDesignBase.injectCss(MaterialBubbleDebugClientBundle.INSTANCE.bubbleCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialBubbleClientBundle.INSTANCE.bubbleJs());
            MaterialDesignBase.injectCss(MaterialBubbleClientBundle.INSTANCE.bubbleCss());
        }
    }

    public MaterialBubble() {
        super(Document.get().createSpanElement(), AddinsCssName.BUBBLE);
        triangle.setStyleName(AddinsCssName.TRIANGLE);
        getPositionMixin().setCssName(Position.LEFT);
        add(triangle);
        setShadow(1);
    }

    public MaterialBubble(Color textColor, Color backgroundColor) {
        this();
        setTextColor(textColor);
        setBackgroundColor(backgroundColor);
    }

    public MaterialBubble(Color textColor, Color backgroundColor, Position position) {
        this(textColor, backgroundColor);
        setPosition(position);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        $(getElement()).bubble(options);
        AddinsDarkThemeReloader.get().reload(MaterialBubbleDarkTheme.class);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    @Override
    public void setBackgroundColor(Color bgColor) {
        super.setBackgroundColor(bgColor);
        options.color = ColorHelper.setupComputedBackgroundColor(bgColor);
        reload();
    }

    @Override
    public Position getPosition() {
        return options.position != null ? Position.fromStyleName(options.position) : null;
    }

    @Override
    public void setPosition(Position position) {
        options.position = position.getCssName();
        getPositionMixin().setCssName(position);
        reload();
    }

    public MaterialWidget getTriangle() {
        return triangle;
    }

    protected CssNameMixin<MaterialWidget, Position> getPositionMixin() {
        if (positionMixin == null) {
            positionMixin = new CssNameMixin<>(triangle);
        }
        return positionMixin;
    }
}
