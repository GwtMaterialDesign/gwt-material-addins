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
import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.client.base.AbstractIconButton;
import gwt.material.design.client.constants.Color;

import java.util.Collections;
import java.util.List;

//@formatter:off

/**
 * SubHeaders are special list tiles that delineate distinct sections of a list or grid list and are typically related
 * to the current filtering or sorting criteria. Subheader tiles are either displayed inline with tiles or can be
 * associated with content, for example, in an adjacent column.
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
 *      <ma:subheader.MaterialSubHeader text="Subheader" textColor="pink" />
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#subheaders">Material Subheader</a>
 * @see <a href="https://material.io/guidelines/components/subheaders.html">Material Design Specification</a>
 */
//@formatter:on
public class MaterialSubHeader extends AbstractIconButton implements HasDependency {

    private DependencyMixin<MaterialSubHeader> dependencyMixin;

    public MaterialSubHeader() {
        super(AddinsCssName.SUBHEADER);
    }

    public MaterialSubHeader(String text) {
        this();
        setText(text);
    }

    public MaterialSubHeader(String text, Color textColor) {
        this(text);
        setTextColor(textColor);
    }

    @Override
    protected void onLoad() {
        getDependencyMixin().install(super::onLoad);
    }

    @Override
    protected Element createElement() {
        return Document.get().createDivElement();
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

    public DependencyMixin<MaterialSubHeader> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
