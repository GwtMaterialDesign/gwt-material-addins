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
package gwt.material.design.addins.client.carousel.ui;

import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;

public class PreviousArrow extends MaterialButton {

    @Override
    protected void onLoad() {
        super.onLoad();

        setId(DOM.createUniqueId());
        setIconType(IconType.KEYBOARD_ARROW_LEFT);
        setType(ButtonType.FLOATING);
        setWaves(WavesType.DEFAULT);
        setText("Previous");
        addStyleName(AddinsCssName.CAROUSEL_PREV_ARROW);
    }
}
