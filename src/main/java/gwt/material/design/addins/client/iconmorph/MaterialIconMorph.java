package gwt.material.design.addins.client.iconmorph;

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
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialToast;

//@formatter:off
/**
 * Provides visual continuity by morphing two material icons.
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
 * <ma:iconmorph.MaterialIconMorph iconSize="SMALL">
 *    <m:MaterialIcon iconType="POLYMER"/>
 *    <m:MaterialIcon iconType="DONE"/>
 * </ma:iconmorph.MaterialIconMorph>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#morphingIcons">Material Icon Morph</a>
 */
//@formatter:on
public class MaterialIconMorph extends MaterialWidget {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectCss(MaterialIconMorphDebugClientBundle.INSTANCE.morphCssDebug());
        } else {
            MaterialResourceInjector.injectCss(MaterialIconMorphClientBundle.INSTANCE.morphCss());
        }
    }

    private final CssNameMixin<MaterialIconMorph, IconSize> sizeMixin = new CssNameMixin<>(this);

    public MaterialIconMorph() {
        super(Document.get().createDivElement(), "anim-container");
        getElement().setAttribute("onclick", "this.classList.toggle('morphed')");
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if (getWidgetCount() >= 2) {
            MaterialIcon source = (MaterialIcon) getWidget(0);
            source.addStyleName("icons source");
            MaterialIcon target = (MaterialIcon) getWidget(1);
            target.addStyleName("icons target");
        }else{
            MaterialToast.fireToast("Nothing");
        }
    }

    public void setIconSize(IconSize size) {
        sizeMixin.setCssName(size);
    }
}
