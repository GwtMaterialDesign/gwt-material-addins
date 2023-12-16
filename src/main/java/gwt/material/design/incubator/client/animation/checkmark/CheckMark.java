/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.incubator.client.animation.checkmark;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasDelayTransition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.client.ui.html.Div;
import gwt.material.design.client.ui.html.Span;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.dark.IncubatorDarkThemeReloader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckMark extends AbstractAddinsWidget implements HasDelayTransition {

    static String CHECK_MARK = "check-mark";
    static String HIDE = "hide";

    private Div iconWrapper = new Div();
    private Span tipLine = new Span();
    private Span longLine = new Span();
    private Div placeholder = new Div();
    private Div fixLine = new Div();

    private int delayInMillis;

    private ToggleStyleMixin<CheckMark> toggleStyleMixin;

    public CheckMark() {
        super(Document.get().createDivElement(), CHECK_MARK);

        iconWrapper.addStyleName("sa-icon sa-success animate");
        tipLine.addStyleName("sa-line sa-tip animateSuccessTip");
        longLine.addStyleName("sa-line sa-long animateSuccessLong");
        placeholder.addStyleName("sa-placeholder");
        fixLine.addStyleName("sa-fix");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        add(iconWrapper);
        iconWrapper.add(tipLine);
        iconWrapper.add(longLine);
        iconWrapper.add(placeholder);
        iconWrapper.add(fixLine);

        IncubatorDarkThemeReloader.get().reload(CheckMarkDarkTheme.class);
    }

    public void animate() {
        Scheduler.get().scheduleFixedDelay(() -> {
            getToggleStyleMixin().setOn(false);
            return false;
        }, delayInMillis);
    }

    public void reset() {
        getToggleStyleMixin().setOn(true);
    }

    public ToggleStyleMixin<CheckMark> getToggleStyleMixin() {
        if (toggleStyleMixin == null) {
            toggleStyleMixin = new ToggleStyleMixin<>(this, HIDE);
        }
        return toggleStyleMixin;
    }

    @Override
    public void setDelay(int delayInMillis) {
        this.delayInMillis = delayInMillis;
    }

    @Override
    public int getDelay() {
        return delayInMillis;
    }

    @Override
    public Class<? extends DarkThemeLoader> getDarkTheme() {
        return CheckMarkDarkTheme.class;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(CheckMarkClientBundle.INSTANCE.checkMarkCss(), CheckMarkClientDebugBundle.INSTANCE.checkMarkDebugCss()));
    }
}
