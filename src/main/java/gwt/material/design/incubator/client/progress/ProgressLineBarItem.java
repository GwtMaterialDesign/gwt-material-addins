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
package gwt.material.design.incubator.client.progress;

import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.html.Div;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

/**
 * A child widget set by {@link ProgressLineBar#addOption(Object)}.
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
public class ProgressLineBarItem extends Div {

    @Override
    protected void onLoad() {
        super.onLoad();

        setStyleName(IncubatorCssName.PROGRESS_ITEM);
    }

    public void setActive(boolean active) {
        if (active) {
            addStyleName(CssName.ACTIVE);
        } else {
            removeStyleName(CssName.ACTIVE);
        }
    }
}
