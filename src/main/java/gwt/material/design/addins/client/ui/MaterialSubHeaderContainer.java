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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.constants.SubHeaderType;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.CssTypeMixin;

//@formatter:off

/**
 * SubHeader Container will wrap your subheader items.
 * There are two types of SubHeader Container <br/>
 * 1. PINNED<br/>
 * 2. STATIC
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
 * <m:MaterialSubHeaderContainer height="400px" type="PINNED">
 *     <m.addins:MaterialSubHeader text="Subheader" textColor="pink" />
 * </m:MaterialSubHeaderContainer>
 * }
 * </pre>
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#subheaders">Material Subheader</a>
 * @author kevzlou7979
 */
//@formatter:on
public class MaterialSubHeaderContainer extends MaterialWidget implements HasType<SubHeaderType>{

    private final CssTypeMixin<SubHeaderType, MaterialSubHeaderContainer> typeMixin = new CssTypeMixin<>(this);

    public MaterialSubHeaderContainer() {
        super(Document.get().createDivElement());
        setStyleName("container1");
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if(getType() == SubHeaderType.PINNED) {
            String uniqueName = DOM.createUniqueId();
            for (Widget w : getChildren()) {
                if (w instanceof MaterialSubHeader) {
                    w.addStyleName(uniqueName);
                }
            }
            initSubheaders("." + uniqueName, getElement());
        }
    }

    private native void initSubheaders(String subheader, Element container) /*-{
        $wnd.initSubheader(subheader, container);
    }-*/;

    @Override
    public void setType(SubHeaderType type) {
        typeMixin.setType(type);
    }

    @Override
    public SubHeaderType getType() {
        return typeMixin.getType();
    }
}
