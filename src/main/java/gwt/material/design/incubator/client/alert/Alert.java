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
package gwt.material.design.incubator.client.alert;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.note.MaterialNote;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasInOutDurationTransition;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.TransitionConfig;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.incubator.client.alert.constants.AlertType;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Alert component is an extension of {@link MaterialNote} which delivers
 * a delightful message alerts.
 * <p>
 * <p><i>
 * Note: This component is under the incubation process and subject to change.
 * </i></p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 *      Alert alert = new Alert();
 *      alert.setText("This is an error");
 *      alert.setType(AlertType.ERROR);
 *      alert.open();
 * }
 * </pre>
 *
 * @author kevzlou7979
 */
public class Alert extends MaterialNote implements HasType<AlertType>, HasOpenHandlers, HasCloseHandlers, HasInOutDurationTransition {

    private static boolean resourcesLoaded = false;

    static {
        IncubatorWidget.showWarning(Alert.class);
        loadResources();
    }

    static void loadResources() {
        if (!resourcesLoaded) {
            if (MaterialAddins.isDebug()) {
                MaterialDesignBase.injectCss(AlertDebugClientBundle.INSTANCE.alertDebugCss());
            } else {
                MaterialDesignBase.injectCss(AlertClientBundle.INSTANCE.alertCss());
            }
            resourcesLoaded = true;
        }
    }

    private CssTypeMixin<AlertType, Alert> cssTypeMixin;
    private ToggleStyleMixin<Alert> toggleStyleMixin;

    private int inDuration = 400;
    private int outDuration = 3000;

    public Alert() {
    }

    public Alert(String text) {
        setText(text);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        setLayoutPosition(Style.Position.ABSOLUTE);
        setTransition(new TransitionConfig(getElement(), inDuration, "all"));
    }

    /**
     * Open / Show alert messages component.
     */
    public void open() {
        getToggleStyleMixin().setOn(true);
        OpenEvent.fire(this, this);
    }

    /**
     * Open / Show alert messages with provided callback
     *
     * @param callback
     */
    public void open(Functions.Func callback) {
        open();
        Scheduler.get().scheduleFixedDelay(() -> {
            callback.call();
            return false;
        }, inDuration);
    }

    public void open(int delay) {
        Scheduler.get().scheduleFixedDelay(() -> {
            open(() -> close());
            return false;
        }, delay);
    }

    /**
     * Close / Hide alert message component.
     */
    public void close() {
        getToggleStyleMixin().setOn(false);
        CloseEvent.fire(this, this);
    }

    /**
     * Set the text of alert message component.
     */
    public void setText(String text, AlertType type) {
        setText(text);
        setType(type);
    }

    @Override
    public void setType(AlertType alertType) {
        getCssTypeMixin().setType(alertType);
        switch (alertType) {
            case ERROR:
                setIconType(IconType.WARNING);
                break;
            case INFORMATION:
                setIconType(IconType.INFO);
                break;
            case WARNING:
                setIconType(IconType.WARNING);
                break;
            default:
                break;
        }
    }

    @Override
    public AlertType getType() {
        return getCssTypeMixin().getType();
    }

    @Override
    public void setInDuration(int inDuration) {
        this.inDuration = inDuration;
    }

    @Override
    public int getInDuration() {
        return inDuration;
    }

    @Override
    public void setOutDuration(int outDuration) {
        this.outDuration = outDuration;
    }

    @Override
    public int getOutDuration() {
        return outDuration;
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler openHandler) {
        return addHandler(openHandler, OpenEvent.getType());
    }

    @Override
    public HandlerRegistration addCloseHandler(CloseHandler closeHandler) {
        return addHandler(closeHandler, CloseEvent.getType());
    }

    public CssTypeMixin<AlertType, Alert> getCssTypeMixin() {
        if (cssTypeMixin == null) {
            cssTypeMixin = new CssTypeMixin<>(this);
        }
        return cssTypeMixin;
    }

    public ToggleStyleMixin<Alert> getToggleStyleMixin() {
        if (toggleStyleMixin == null) {
            toggleStyleMixin = new ToggleStyleMixin<>(this, CssName.OPEN);
        }
        return toggleStyleMixin;
    }
}
