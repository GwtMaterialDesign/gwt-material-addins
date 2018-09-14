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

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.base.viewport.Resolution;
import gwt.material.design.client.base.viewport.ViewPort;
import gwt.material.design.client.ui.MaterialSearch;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.search.constants.Theme;

/**
 * Extension to {@link MaterialSearch} which provides an inline
 * style appended to {@link gwt.material.design.client.ui.MaterialNavBar} component.
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
public class InlineSearch extends MaterialSearch {

    private HandlerRegistration focusHandler;
    private HandlerRegistration blurHandler;
    private CssNameMixin<InlineSearch, Theme> cssNameMixin;

    static {
        IncubatorWidget.showWarning(InlineSearch.class);
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(InlineSearchDebugClientBundle.INSTANCE.inlineSearchDebugCss());
        } else {
            MaterialDesignBase.injectCss(InlineSearchClientBundle.INSTANCE.inlineSearchCss());
        }
    }

    public InlineSearch() {
        this(AddinsCssName.FIXED_INLINE_SEARCH);
    }

    public InlineSearch(String className) {
        super();
        addStyleName(AddinsCssName.INLINE_SEARCH);
        addStyleName(className);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        ViewPort.when(Resolution.ALL_MOBILE).then(portChange -> {
            focusHandler = registerHandler(addFocusHandler(focusEvent -> addStyleName(AddinsCssName.WIDE)));
            blurHandler = registerHandler(addBlurHandler(blurEvent -> removeStyleName(AddinsCssName.WIDE)));
        }, viewPortRect -> {
            if (focusHandler != null && blurHandler != null) {
                focusHandler.removeHandler();
                blurHandler.removeHandler();
            }

            focusHandler = null;
            blurHandler = null;
            return true;
        });
    }

    public void setTheme(Theme theme) {
        getCssNameMixin().setCssName(theme);
    }

    protected CssNameMixin<InlineSearch, Theme> getCssNameMixin() {
        if (cssNameMixin == null) {
            cssNameMixin = new CssNameMixin<>(this);
        }
        return cssNameMixin;
    }
}
