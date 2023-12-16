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
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.base.viewport.Resolution;
import gwt.material.design.client.base.viewport.ViewPort;
import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.client.ui.MaterialSearch;
import gwt.material.design.incubator.client.search.constants.Theme;

import java.util.Collections;
import java.util.List;

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
public class InlineSearch extends AbstractAddinsWidget {

    private HandlerRegistration focusHandler;
    private HandlerRegistration blurHandler;
    private CssNameMixin<InlineSearch, Theme> cssNameMixin;

    public InlineSearch() {
        this(AddinsCssName.FIXED_INLINE_SEARCH);
    }

    public InlineSearch(String className) {
        super();
        addStyleName(AddinsCssName.INLINE_SEARCH);
        addStyleName(className);
    }

    @Override
    protected void internalLoad() {
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

    @Override
    public Class<? extends DarkThemeLoader> getDarkTheme() {
        return InlineSearchDarkTheme.class;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(InlineSearchClientBundle.INSTANCE.inlineSearchCss(), InlineSearchDebugClientBundle.INSTANCE.inlineSearchDebugCss()));
    }
}
