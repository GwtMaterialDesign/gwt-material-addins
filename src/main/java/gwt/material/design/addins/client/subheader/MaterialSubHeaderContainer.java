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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.subheader.constants.SubHeaderType;
import gwt.material.design.addins.client.subheader.js.JsSubHeader;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.CssTypeMixin;

import java.util.ArrayList;
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
public class MaterialSubHeaderContainer extends MaterialWidget implements HasType<SubHeaderType> {

    static {
        MaterialSubHeader.loadResources();
    }

    private CssTypeMixin<SubHeaderType, MaterialSubHeaderContainer> typeMixin;
    private List<MaterialSubHeader> subHeaders = new ArrayList<>();

    public MaterialSubHeaderContainer() {
        super(Document.get().createDivElement(), AddinsCssName.CONTAINER1);
    }

    public MaterialSubHeaderContainer(SubHeaderType type) {
        this();
        setType(type);
    }

    @Override
    protected void initialize() {
        subHeaders.clear();
        if (getType() == SubHeaderType.PINNED) {
            String uniqueName = DOM.createUniqueId();
            for (Widget w : getChildren()) {
                if (w instanceof MaterialSubHeader) {
                    w.addStyleName(uniqueName);
                    subHeaders.add((MaterialSubHeader) w);
                }
            }
            initialize("." + uniqueName, getElement());
            if (subHeaders.size() == 0) {
                $(getElement()).find(".top_holder").css("display", "none");
            }
        }
    }

    protected void initialize(String subheader, Element container) {
        JsSubHeader.initSubheader(subheader, container);
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
}
