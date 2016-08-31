/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.overlay;

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;

//@formatter:off
/**
 * It's an overlay panel layout wherein you can put as many widgets as you want and design it.
 * You can do advance stuff by implementing Path Animator into the overlay panel container.
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
 * <ma:overlay.MaterialOverlay background="blue">
 *      &lt;-- Some content here -->
 * </ma:overlay.MaterialMenuBar>
 * }
 * </pre>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class MaterialOverlay extends MaterialWidget {

    static {
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialOverlayDebugClientBundle.INSTANCE.overlayCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialOverlayClientBundle.INSTANCE.overlayCss());
        }
    }

    public MaterialOverlay() {
        super(Document.get().createDivElement(), "overlay-panel");
    }
}
