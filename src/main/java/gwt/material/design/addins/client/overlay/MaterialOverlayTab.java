/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.overlay;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialBadge;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialPanel;

import java.util.ArrayList;
import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class MaterialOverlayTab extends MaterialWidget {

    private MaterialButton activator = new MaterialButton();
    private MaterialBadge badge = new MaterialBadge();
    private MaterialPanel leanOverlay = new MaterialPanel();
    private List<MaterialOverlay> overlays = new ArrayList<>();
    private boolean toggle;
    private int zIndex = 1002;
    private boolean maximized;
    private List<HandlerRegistration> maximizeHandlers = new ArrayList<>();

    public MaterialOverlayTab() {
        super(Document.get().createDivElement(), "overlay-tab");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        badge.setText("0");
        badge.setCircle(true);
        activator.add(badge);
        activator.addStyleName(CssName.ACTIVATOR);
        activator.addClickHandler(clickEvent -> {
            if (!toggle) {
                Scheduler.get().scheduleDeferred(() -> {
                    restore();
                    toggle = true;
                });
            } else {
                Scheduler.get().scheduleDeferred(() -> {
                    close();
                    toggle = false;
                });
            }
        });

        activator.setBackgroundColor(Color.WHITE);
        activator.setIconColor(Color.GREY);
        activator.setSize(ButtonSize.LARGE);
        activator.setType(ButtonType.FLOATING);
        activator.setIconType(IconType.CONTENT_COPY);
        add(activator);

        leanOverlay.setStyleName(AddinsCssName.LEAN_OVERLAY);
        add(leanOverlay);
    }

    public void register(MaterialOverlay overlay) {
        if (!overlays.contains(overlay)) {
            overlay.addStyleName(CssName.TAB);
            overlay.setDepth(zIndex);
            overlays.add(overlay);
            zIndex++;
            badge.setText(overlays.size() + "");
        }
    }

    public void minimize(MaterialOverlay overlay) {
        if (!maximized) {
            MaterialPathAnimator animator = new MaterialPathAnimator();
            animator.setReverseCallback(() -> {
                register(overlay);
                activator.setIconType(IconType.CONTENT_COPY);
                overlay.getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
                overlay.getElement().getStyle().setOpacity(0);
            });
            animator.setSourceElement(getActivator().getElement());
            animator.setTargetElement(overlay.getElement());
            animator.reverseAnimate();
            body().attr("style", "overflow: auto !important");
        } else {
            Scheduler.get().scheduleDeferred(() -> {
                overlays.stream().filter(other -> other != overlay).forEach(other -> {
                    other.removeStyleName(AddinsCssName.HIDDEN);
                });
                overlay.removeStyleName(AddinsCssName.MAXIMIZE);
            });
        }
    }

    public void restore() {
        float scale;
        float transY;
        float index;
        for (MaterialOverlay overlay : overlays) {
            // Calculate the specific tab overlay width to stacked them.
            index = overlays.indexOf(overlay);
            transY = index * 10;
            scale = 0.5f + (index / 25.0f);
            overlay.setVisibility(Style.Visibility.VISIBLE);
            overlay.setOpacity(1);
            $(overlay.getElement()).css("transform", "translate3d(0," + transY + "vh, 0) scale(" + scale + ")");

            // Add maximize handler to this overlay
            maximizeHandlers.add(overlay.addMouseDownHandler(e -> maximize(overlay)));
        }
        leanOverlay.setDisplay(Display.BLOCK);
        activator.setIconType(IconType.CLOSE);
    }

    public void maximize(MaterialOverlay overlay) {
        overlays.stream().filter(other -> other != overlay).forEach(other -> {
            other.addStyleName(AddinsCssName.HIDDEN);
        });
        overlay.addStyleName(AddinsCssName.MAXIMIZE);
        maximized = true;
    }

    public void close() {
        leanOverlay.setDisplay(Display.NONE);
        activator.setIconType(IconType.CONTENT_COPY);
        for (MaterialOverlay overlay : overlays) {
            overlay.setVisibility(Style.Visibility.HIDDEN);
            overlay.setOpacity(0);
            overlay.removeStyleName(AddinsCssName.MAXIMIZE);
            overlay.removeStyleName(AddinsCssName.HIDDEN);
            $(overlay.getElement()).css("transform", "translate3d(0px, 0px, 0px) scale(1)");
        }
        maximizeHandlers.forEach(HandlerRegistration::removeHandler);
        maximized = false;
    }

    public void setActivator(MaterialButton activator) {
        this.activator = activator;
    }

    public MaterialButton getActivator() {
        return activator;
    }
}