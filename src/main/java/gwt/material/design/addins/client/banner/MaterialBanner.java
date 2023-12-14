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
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.banner.event.HasBannerHandlers;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.dark.AddinsDarkThemeReloader;
import gwt.material.design.client.base.HasOpenClose;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class MaterialBanner extends AbstractAddinsWidget implements HasOpenClose, HasBannerHandlers {

    private final MaterialIcon icon;
    private final MaterialLabel messageLabel;
    private final MaterialPanel actions;
    private int offsetTop = 0;
    private int durationInMillis = 300;
    private List<Element> targetPushElements;

    private ToggleStyleMixin<Widget> openMixin;

    public MaterialBanner() {
        super(Document.get().createDivElement(), "banner");

        icon = new MaterialIcon();
        icon.setVisible(false);
        icon.addStyleName("banner-icon");

        messageLabel = new MaterialLabel();
        messageLabel.addStyleName("message");

        actions = new MaterialPanel();
        actions.addStyleName("actions");

        targetPushElements = new ArrayList<>();
    }

    @Override
    protected void internalLoad() {
        add(icon);
        add(messageLabel);
        add(actions);

        close();
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
    public boolean isOpen() {
        return false;
    }

    @Override
    public void open() {
        getOpenMixin().setOn(true);
        setTop(offsetTop);
        pushTargetElements(getOuterHeight());
        OpenEvent.fire(this, getMessage());
    }

    public void open(Element... targetElements) {
        setTargetPushElements(Arrays.asList(targetElements));
        open();
    }

    @Override
    public void close() {
        int outerHeight = getOuterHeight();
        getOpenMixin().setOn(false);
        setTop(outerHeight > 0 ? -outerHeight : -64);
        pushTargetElements(0);
        CloseEvent.fire(this, getMessage());
    }

    protected void pushTargetElements(int translateY) {
        $(getElement()).css("transition", "all " + durationInMillis + "ms ease");
        for (Element element : targetPushElements) {
            $(element).css("transition", "all " + durationInMillis + "ms ease");
            $(element).css("transform", "translateY(" + translateY + "px)");
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

    public List<Element> getTargetPushElements() {
        return targetPushElements;
    }

    public void setTargetPushElements(List<Element> targetPushElements) {
        this.targetPushElements = targetPushElements;
    }

    public int getOffsetTop() {
        return offsetTop;
    }

    public void setOffsetTop(int offsetTop) {
        this.offsetTop = offsetTop;
    }

    public int getOuterHeight() {
        return $(getElement()).outerHeight(true);
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(MaterialBannerClientBundle.INSTANCE.bannerMinifiedCss(),
                MaterialBannerDebugClientBundle.INSTANCE.bannerDebugCss()));
    }

    @Override
    public Class<? extends DarkThemeLoader> getDarkTheme() {
        return MaterialBannerDarkTheme.class;
    }

    public ToggleStyleMixin<Widget> getOpenMixin() {
        if (openMixin == null) {
            openMixin = new ToggleStyleMixin<>(RootPanel.get(), "banner-open");
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
