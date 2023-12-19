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
package gwt.material.design.addins.client.subheader;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.addins.client.subheader.constants.SubHeaderType;
import gwt.material.design.addins.client.subheader.js.JsSubHeader;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.client.theme.dark.DarkThemeLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static gwt.material.design.client.js.JsMaterialElement.$;

//@formatter:off

/**
 * SubHeader Container will wrap your subheader items.
 * There are two types of SubHeader Container <br/>
 * 1. PINNED<br/>
 * 2. STATIC
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
 * <ma:subheader.MaterialSubHeaderContainer height="400px" type="PINNED">
 *     <ma:subheader.MaterialSubHeader text="Subheader" textColor="pink" />
 * </ma:subheader.MaterialSubHeaderContainer>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#subheaders">Material Subheader</a>
 */
//@formatter:on
public class MaterialSubHeaderContainer extends MaterialWidget implements HasDependency, HasType<SubHeaderType> {

    private CssTypeMixin<SubHeaderType, MaterialSubHeaderContainer> typeMixin;
    private List<MaterialSubHeader> subHeaders = new ArrayList<>();
    protected DependencyMixin<HasDependency> dependencyMixin;

    public MaterialSubHeaderContainer() {
        super(Document.get().createDivElement(), AddinsCssName.CONTAINER1);
    }

    public MaterialSubHeaderContainer(SubHeaderType type) {
        this();
        setType(type);
    }

    @Override
    protected void onLoad() {
        getDependencyMixin().install(() -> {
            internalLoad();
            super.onLoad();
        });
    }

    protected void internalLoad() {
        if (getType() == SubHeaderType.PINNED) {
            String subHeaderClass = DOM.createUniqueId();
            for (Widget w : getChildren()) {
                if (w instanceof MaterialSubHeader) {
                    w.addStyleName(subHeaderClass);
                    subHeaders.add((MaterialSubHeader) w);
                }
            }

            JsSubHeader.initSubheader("." + subHeaderClass, getElement());

            if (subHeaders.size() == 0) {
                $(getElement()).find(".top_holder").css("display", "none");
            }
        }
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }
    
    public void unload() {
        subHeaders.clear();
    }

    public void reload() {
        unload();
        internalLoad();
    }

    @Override
    public void setType(SubHeaderType type) {
        getTypeMixin().setType(type);
    }

    @Override
    public SubHeaderType getType() {
        return getTypeMixin().getType();
    }

    protected CssTypeMixin<SubHeaderType, MaterialSubHeaderContainer> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin<>(this);
        }
        return typeMixin;
    }

    public DependencyMixin<HasDependency> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }

    @Override
    public Class<? extends DarkThemeLoader> getDarkTheme() {
        return MaterialSubheaderDarkTheme.class;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(MaterialSubHeaderClientBundle.INSTANCE.subheaderCss(),
                MaterialSubHeaderDebugClientBundle.INSTANCE.subheaderCssDebug()));
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(MaterialSubHeaderClientBundle.INSTANCE.subheaderJs(),
                MaterialSubHeaderDebugClientBundle.INSTANCE.subheaderJsDebug()));
    }
}
