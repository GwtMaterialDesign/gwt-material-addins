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
package gwt.material.design.incubator.client.async;

import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasActive;
import gwt.material.design.client.base.mixin.ActiveMixin;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.SpinnerColor;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialSpinner;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

//@formatter:off

/**
 * Asynchronous buttons are components that is good ux for
 * calling the server side component and automatically updates
 * the states of the ui logic.
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 * <h3>XML Namespace Declaration</h3>
 *
 * @author kevzlou7979
 */
public class AsyncButton extends MaterialButton implements HasActive {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(AsyncDebugClientBundle.INSTANCE.asyncButtonDebugCss());
        } else {
            MaterialDesignBase.injectCss(AsyncClientBundle.INSTANCE.asyncButtonCss());
        }
    }

    private ActiveMixin<AsyncButton> activeMixin;

    private MaterialSpinner loader = new MaterialSpinner();

    public AsyncButton() {
        super();
        addStyleName(IncubatorCssName.ASYNC_BUTTON);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        IncubatorWidget.showWarning(this);
        loader.setColor(SpinnerColor.BLUE_ONLY);
        add(loader);
    }

    public void loading() {
        setActive(true);
    }

    public void loading(String message) {
        loading();
        setBackgroundColor(Color.WHITE);
        setTextColor(Color.BLACK);
        setText(message);
    }

    public void error(String message) {
        setActive(false);
        setBackgroundColor(Color.WHITE);
        setTextColor(Color.RED);
        setIconType(IconType.WARNING);
        setText(message);
    }

    public void success(String message) {
        setActive(false);
        setBackgroundColor(Color.WHITE);
        setTextColor(Color.BLACK);
        setIconType(IconType.CHECK);
        setText(message);
    }

    @Override
    public void setActive(boolean value) {
        getActiveMixin().setActive(value);
    }

    @Override
    public boolean isActive() {
        return getActiveMixin().isActive();
    }

    public ActiveMixin<AsyncButton> getActiveMixin() {
        if (activeMixin == null) {
            activeMixin = new ActiveMixin<>(this);
        }
        return activeMixin;
    }
}
