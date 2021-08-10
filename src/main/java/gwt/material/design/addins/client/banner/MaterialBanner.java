/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2021 GwtMaterialDesign
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
package gwt.material.design.addins.client.banner;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.banner.event.HasBannerHandlers;
import gwt.material.design.addins.client.dark.AddinsDarkThemeReloader;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasOpenClose;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class MaterialBanner extends MaterialWidget implements HasOpenClose, HasBannerHandlers {

    private final MaterialIcon icon;
    private final MaterialLabel messageLabel;
    private final MaterialPanel actions;
    private int translateY = 0;
    private int durationInMillis = 300;
    private Widget targetContainer;

    private ToggleStyleMixin<MaterialBanner> openMixin;

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialBannerDebugClientBundle.INSTANCE.bannerDebugCss());
        } else {
            MaterialDesignBase.injectCss(MaterialBannerClientBundle.INSTANCE.bannerCss());
        }
    }

    public MaterialBanner() {
        super(Document.get().createDivElement(), "banner");

        icon = new MaterialIcon();
        icon.setVisible(false);
        icon.addStyleName("banner-icon");

        messageLabel = new MaterialLabel();
        messageLabel.addStyleName("message");

        actions = new MaterialPanel();
        actions.addStyleName("actions");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        add(icon);
        add(messageLabel);
        add(actions);


        updateTransition();

        AddinsDarkThemeReloader.get().reload(MaterialBannerDarkTheme.class);
    }

    @Override
    public void add(Widget child) {
        if (child instanceof MaterialBannerActions) {
            actions.add(child);
        } else {
            super.add(child);
        }
    }

    @Override
    public void open() {
        getOpenMixin().setOn(true);
        OpenEvent.fire(this, getMessage());
        calculateTranslateY();
    }

    @Override
    public void close() {
        getOpenMixin().setOn(false);
        CloseEvent.fire(this, getMessage());
        pushTargetContainer(0);
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    protected void calculateTranslateY() {
        translateY = $(getElement()).outerHeight(true);
        setTransform("translateY(" + -translateY + "px)");
        pushTargetContainer(translateY);
    }

    protected void pushTargetContainer(int translateY) {
        if (targetContainer != null) {
            $(targetContainer.getElement()).css("transform", "translateY(" + translateY + "px)");
        }
    }

    protected void updateTransition() {
        $(getElement()).css("transition", "all " + durationInMillis + "ms ease");
        if (targetContainer != null) {
            $(targetContainer.getElement()).css("transition", "all " + durationInMillis + "ms ease");
        }
    }

    public int getDurationInMillis() {
        return durationInMillis;
    }

    public void setDurationInMillis(int durationInMillis) {
        this.durationInMillis = durationInMillis;
    }

    public String getMessage() {
        return messageLabel.getText();
    }

    public void setMessage(String message) {
        if (message != null && !message.isEmpty()) {
            messageLabel.setText(message);
        } else {
            messageLabel.setText("");
        }
    }

    public IconType getIconType() {
        return icon.getIconType();
    }

    public void setIconType(IconType iconType) {
        if (iconType != null) {
            icon.setIconType(iconType);
            icon.setVisible(true);
        } else {
            icon.setVisible(false);
        }
    }

    public MaterialIcon getIcon() {
        return icon;
    }

    public MaterialLabel getMessageLabel() {
        return messageLabel;
    }

    public Widget getTargetContainer() {
        return targetContainer;
    }

    public void setTargetContainer(Widget targetContainer) {
        this.targetContainer = targetContainer;
    }

    public ToggleStyleMixin<MaterialBanner> getOpenMixin() {
        if (openMixin == null) {
            openMixin = new ToggleStyleMixin<>(this, "open");
        }
        return openMixin;
    }

    @Override
    public HandlerRegistration addCloseHandler(CloseHandler handler) {
        return addHandler(handler, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler handler) {
        return addHandler(handler, OpenEvent.getType());
    }
}
