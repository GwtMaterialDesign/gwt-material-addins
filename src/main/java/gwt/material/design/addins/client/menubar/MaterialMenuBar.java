package gwt.material.design.addins.client.menubar;

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
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;

//@formatter:off
/**
 * Menu bar is a component that bring a good UI UX navigation for Desktop or tablet interface.
 * It may require to have a dropdown components inside menu bar.
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
 *{@code
 * <ma:menubar.MaterialMenuBar>
 *      &lt;!-- Menu Bar link -->
 *      <m:MateriaLink text="File" activates="dp-edit"/>
 *
 *      &lt;!-- Edit Drop Down -->
 *      <m:MaterialDropDown activator="dp-edit" belowOrigin="true">
 *      <m:MaterialLink text="Undo" iconType="UNDO" textColor="black">
 *          <m:MaterialLabel text="Ctrl + Z" float="RIGHT"/>
 *      </m:MaterialLink>
 *      <m:MaterialLink text="Redo" iconType="REDO" textColor="black">
 *          <m:MaterialLabel text="Ctrl + Y" float="RIGHT"/>
 *      </m:MaterialLink>
 *   </m:MaterialDropDown>
 * </ma:menubar.MaterialMenuBar>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#menubar">MenuBar</a>
 */
//@formatter:on
public class MaterialMenuBar extends MaterialWidget {

    static {
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialMenuBarDebugClientBundle.INSTANCE.menubarCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialMenuBarClientBundle.INSTANCE.menubarCss());
        }
    }

    public MaterialMenuBar() {
        super(Document.get().createDivElement(), "menu-bar");
    }

}
