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
package gwt.material.design.incubator.client.search;

import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.base.viewport.Resolution;
import gwt.material.design.client.base.viewport.ViewPort;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.progress.ProgressLineBar;

/**
 * Another search component the extends to {@link InlineSearch} which
 * enables the toggle open / close functionality.
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
public class ExpandableInlineSearch extends InlineSearch {

    private String width;

    private ToggleStyleMixin<ExpandableInlineSearch> toggleStyleMixin;

    public ExpandableInlineSearch() {
        super(AddinsCssName.EXPANDABLE_SEARCH);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        registerHandler(addCloseHandler(closeEvent -> close()));
        registerHandler(addBlurHandler(blurEvent -> addStyleName(CssName.INACTIVE)));
        registerHandler(addFocusHandler(focusEvent -> removeStyleName(CssName.INACTIVE)));
    }

    @Override
    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public void open() {
        super.open();

        getToggleStyleMixin().setOn(true);

        ViewPort.when(Resolution.ALL_MOBILE, Resolution.TABLET).then(param1 -> {
            if (isOpen()) {
                super.setWidth("90%");
            }
        }, viewPort -> {
            if (isOpen()) {
                super.setWidth(width);
            }
            return false;
        });
    }

    public boolean isOpen() {
        return getToggleStyleMixin().isOn();
    }

    @Override
    public void close() {
        getToggleStyleMixin().setOn(false);
        super.setWidth("0px");
    }

    protected ToggleStyleMixin<ExpandableInlineSearch> getToggleStyleMixin() {
        if (toggleStyleMixin == null) {
            toggleStyleMixin = new ToggleStyleMixin<>(this, CssName.OPEN);
        }
        return toggleStyleMixin;
    }
}
