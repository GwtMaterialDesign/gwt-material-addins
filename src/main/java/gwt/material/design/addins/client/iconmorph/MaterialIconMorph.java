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
package gwt.material.design.addins.client.iconmorph;

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasDurationTransition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.TransitionConfig;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.ui.MaterialIcon;

//@formatter:off

/**
 * Provides visual continuity by morphing two material icons.
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
 * <ma:iconmorph.MaterialIconMorph iconSize="SMALL">
 *    <m:MaterialIcon iconType="POLYMER"/>
 *    <m:MaterialIcon iconType="DONE"/>
 * </ma:iconmorph.MaterialIconMorph>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#morphingIcons">Material Icon Morph</a>
 * @see <a href="https://material.io/guidelines/motion/creative-customization.html#creative-customization-icons">Material Design Specification</a>
 */
//@formatter:on
public class MaterialIconMorph extends MaterialWidget implements HasDurationTransition {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialIconMorphDebugClientBundle.INSTANCE.morphCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialIconMorphClientBundle.INSTANCE.morphCss());
        }
    }

    private final CssNameMixin<MaterialIconMorph, IconSize> sizeMixin = new CssNameMixin<>(this);
    private MaterialIcon source, target;

    public MaterialIconMorph() {
        super(Document.get().createDivElement(), AddinsCssName.ANIM_CONTAINER);
        getElement().setAttribute("onclick", "this.classList.toggle('morphed')");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        build();
    }

    @Override
    protected void build() {
        if (getWidgetCount() >= 2) {
            source = (MaterialIcon) getWidget(0);
            source.addStyleName(AddinsCssName.ICONS + " " + AddinsCssName.SOURCE);
            target = (MaterialIcon) getWidget(1);
            target.addStyleName(AddinsCssName.ICONS + " " + AddinsCssName.TARGET);
        }
    }

    public void setIconSize(IconSize size) {
        sizeMixin.setCssName(size);
    }

    @Override
    public void setDuration(int duration) {
        setTransition(new TransitionConfig(duration, "all"));
    }

    @Override
    public int getDuration() {
        return 0;
    }

    public MaterialIcon getSource() {
        return source;
    }

    public MaterialIcon getTarget() {
        return target;
    }
}
