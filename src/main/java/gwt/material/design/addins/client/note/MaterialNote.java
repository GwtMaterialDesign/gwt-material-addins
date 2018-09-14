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
package gwt.material.design.addins.client.note;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasIcon;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.TextMixin;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;

//@formatter:off

/**
 * MaterialNote is basic panel with text indication to quoate a certain part of your website
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
 * <m:MaterialNote text="Some message here" iconType="WARNING" backgroundColor="RED_LIGHTEN_5" textColor="RED" />
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#note">Note</a>
 */
//@formatter:on
public class MaterialNote extends MaterialWidget implements HasIcon {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialNoteDebugClientBundle.INSTANCE.noteCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialNoteClientBundle.INSTANCE.noteCss());
        }
    }

    private MaterialIcon icon = new MaterialIcon(IconType.STAR);
    private MaterialLabel lblMessage = new MaterialLabel();
    private final TextMixin<MaterialLabel> textMixin = new TextMixin<>(lblMessage);

    public MaterialNote() {
        super(Document.get().createDivElement(), AddinsCssName.MATERIAL_NOTE);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        add(icon);
        add(lblMessage);
    }

    public String getText() {
        return textMixin.getText();
    }

    public void setText(String text) {
        textMixin.setText(text);
    }

    @Override
    public MaterialIcon getIcon() {
        return icon;
    }

    @Override
    public void setIconType(IconType iconType) {
        icon.setIconType(iconType);
    }

    @Override
    public void setIconPosition(IconPosition iconPosition) {
        icon.setIconPosition(iconPosition);
    }

    @Override
    public void setIconSize(IconSize iconSize) {
        icon.setIconSize(iconSize);
    }

    @Override
    public void setIconFontSize(double v, Style.Unit unit) {
        icon.setIconFontSize(v, unit);
    }

    @Override
    public void setIconColor(Color color) {
        icon.setIconColor(color);
    }

    @Override
    public Color getIconColor() {
        return icon.getIconColor();
    }

    @Override
    public void setIconPrefix(boolean b) {
        icon.setIconPrefix(b);
    }

    @Override
    public boolean isIconPrefix() {
        return icon.isIconPrefix();
    }
}
