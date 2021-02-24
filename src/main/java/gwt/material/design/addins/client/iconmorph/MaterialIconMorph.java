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
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasDurationTransition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.TransitionConfig;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.ui.MaterialIcon;

import static gwt.material.design.jquery.client.api.JQuery.$;

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

    protected static final String ICON_MORPH = "icon-morph";
    protected static final String MORPHED = "morphed";
    protected CssNameMixin<MaterialIconMorph, IconSize> sizeMixin;
    protected String customSize;
    protected MaterialIcon source, target;

    public MaterialIconMorph() {
        super(Document.get().createDivElement(), AddinsCssName.ANIM_CONTAINER, ICON_MORPH);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        registerHandler(addClickHandler(event -> {
            $(getElement()).toggleClass(MORPHED);
            IconMorphedEvent.fire(this, getElement().hasClassName(MORPHED));
        }));

        // Check if we add the source and target icons thru ui binder
        if (source == null && target == null) {
            if (getWidgetCount() == 2) {
                source = (MaterialIcon) getWidget(0);
                target = (MaterialIcon) getWidget(1);
            }
        }

        if (source != null) {
            source.addStyleName(AddinsCssName.ICONS + " " + AddinsCssName.SOURCE);
            if (!source.isAttached()) add(source);
        }
        if (target != null) {
            target.addStyleName(AddinsCssName.ICONS + " " + AddinsCssName.TARGET);
            if (!target.isAttached()) add(target);
        }

        applyCustomSize(customSize);
    }

    protected void applyCustomSize(String customSize) {
        if (customSize != null) {
            setWidth(customSize);
            setHeight(customSize);

            if (source != null) {
                source.setWidth(customSize);
                source.setHeight(customSize);
                source.setFontSize(customSize);
            }

            if (target != null) {
                target.setWidth(customSize);
                target.setHeight(customSize);
                target.setFontSize(customSize);
            }
        }
    }

    public void reset() {
        getElement().removeClassName(MORPHED);
    }

    public void setIconSize(IconSize size) {
        getSizeMixin().setCssName(size);
    }

    public void setCustomSize(String customSize) {
        this.customSize = customSize;
    }

    @Override
    public void setDuration(int duration) {
        setTransition(new TransitionConfig(duration, "all"));
    }

    @Override
    public int getDuration() {
        return 0;
    }

    public void setSource(MaterialIcon source) {
        this.source = source;
    }

    public void setTarget(MaterialIcon target) {
        this.target = target;
    }

    public MaterialIcon getSource() {
        return source;
    }

    public MaterialIcon getTarget() {
        return target;
    }

    public CssNameMixin<MaterialIconMorph, IconSize> getSizeMixin() {
        if (sizeMixin == null) {
            sizeMixin = new CssNameMixin<>(this);
        }
        return sizeMixin;
    }

    public HandlerRegistration addIconMorphedHandler(IconMorphedEvent.IconMorphedHandler handler) {
        return addHandler(handler, IconMorphedEvent.TYPE);
    }
}
