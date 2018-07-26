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
import gwt.material.design.client.base.AbstractIconButton;
import gwt.material.design.client.base.HasActive;
import gwt.material.design.client.base.mixin.ActiveMixin;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.html.Icon;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.async.events.ErrorEvent;
import gwt.material.design.incubator.client.async.events.HasAsyncHandlers;
import gwt.material.design.incubator.client.async.events.LoadingEvent;
import gwt.material.design.incubator.client.async.events.SuccessEvent;
import gwt.material.design.incubator.client.base.IncubatorWidget;

//@formatter:off

/**
 * Asynchronous buttons are components that is good ux for
 * calling the server side component and automatically updates
 * the states of the ui logic.
 * <p>
 * <p><i>
 * Note: This component is under the incubation process and subject to change.
 * </i></p>
 * <h3>XML Namespace Declaration</h3>
 *
 * @author kevzlou7979
 */
public abstract class AbstractAsyncButton extends AbstractIconButton
        implements HasActive, HasAsyncHandlers {

    static {
        IncubatorWidget.showWarning(AbstractAsyncButton.class);
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(AsyncDebugClientBundle.INSTANCE.asyncButtonDebugCss());
        } else {
            MaterialDesignBase.injectCss(AsyncClientBundle.INSTANCE.asyncButtonCss());
        }
    }

    protected ActiveMixin<AbstractAsyncButton> activeMixin;
    protected IconType initialIcon;
    protected String initialMessage;
    protected IconType loadingIcon = IconType.AUTORENEW;
    protected IconType errorIcon = IconType.WARNING;
    protected IconType successIcon = IconType.CHECK;

    protected AbstractAsyncButton() {
        super();
    }

    public AbstractAsyncButton(String className) {
        super(className, "");

        setIconPosition(IconPosition.LEFT);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
    }

    public void loading(String message) {
        setActive(true);
        setIconType(loadingIcon);
        setEnabled(false);
        LoadingEvent.fire(this);
    }

    public void error(String message) {
        setActive(false);
        setIconType(errorIcon);
        setEnabled(true);
        ErrorEvent.fire(this);
    }

    public void success(String message) {
        setActive(false);
        setIconType(successIcon);
        setEnabled(true);
        SuccessEvent.fire(this);
    }

    public void reset(IconType iconType) {
        reset(iconType, null);
    }

    public void reset(String message) {
        reset(null, message);
    }

    public void reset(IconType iconType, String message) {
        setActive(true);

        if (iconType != null) setIconType(iconType);
        if (message != null) setText(message);
    }

    @Override
    public void setActive(boolean value) {
        getActiveMixin().setActive(value);
    }

    @Override
    public boolean isActive() {
        return getActiveMixin().isActive();
    }

    public ActiveMixin<AbstractAsyncButton> getActiveMixin() {
        if (activeMixin == null) {
            activeMixin = new ActiveMixin<>(this);
        }
        return activeMixin;
    }

    public IconType getLoadingIcon() {
        return loadingIcon;
    }

    public void setLoadingIcon(IconType loadingIcon) {
        this.loadingIcon = loadingIcon;
    }

    public IconType getErrorIcon() {
        return errorIcon;
    }

    public void setErrorIcon(IconType errorIcon) {
        this.errorIcon = errorIcon;
    }

    public IconType getSuccessIcon() {
        return successIcon;
    }

    public void setSuccessIcon(IconType successIcon) {
        this.successIcon = successIcon;
    }

    @Override
    public void addLoadingHandler(LoadingEvent.LoadingHandler handler) {
        addHandler(handler, LoadingEvent.getType());
    }

    @Override
    public void addErrorHandler(ErrorEvent.ErrorHandler handler) {
        addHandler(handler, ErrorEvent.getType());
    }

    @Override
    public void addSuccessHandler(SuccessEvent.SuccessHandler handler) {
        addHandler(handler, SuccessEvent.getType());
    }
}
