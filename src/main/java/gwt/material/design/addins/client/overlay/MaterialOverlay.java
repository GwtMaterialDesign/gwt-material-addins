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
package gwt.material.design.addins.client.overlay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasDurationTransition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;

import static gwt.material.design.jquery.client.api.JQuery.$;

//@formatter:off

/**
 * It's an overlay panel layout wherein you can put as many widgets as you want and design it.
 * You can do advance stuff by implementing Path Animator into the overlay panel container.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 * <ma:overlay.MaterialOverlay background="blue">
 *      &lt;-- Some content here -->
 * </ma:overlay.MaterialOverlay>
 * }
 * </pre>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class MaterialOverlay extends MaterialWidget implements HasOpenHandlers<MaterialOverlay>,
        HasCloseHandlers<MaterialOverlay>, HasDurationTransition {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialOverlayDebugClientBundle.INSTANCE.overlayCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialOverlayClientBundle.INSTANCE.overlayCss());
        }
    }

    private Element sourceElement;
    private MaterialPathAnimator animator = new MaterialPathAnimator();
    private MaterialOverlayTab overlayTab;
    private MaterialIcon minimizeIcon = new MaterialIcon(IconType.KEYBOARD_ARROW_DOWN);

    public MaterialOverlay() {
        super(Document.get().createDivElement(), AddinsCssName.OVERLAY_PANEL);
    }

    public MaterialOverlay(Color backgroundColor) {
        this();
        setBackgroundColor(backgroundColor);
    }

    public MaterialOverlay(Color backgroundColor, Style.Visibility visibility, Double opacity) {
        this(backgroundColor);
        setVisibility(visibility);
        setOpacity(opacity);
    }

    public void open(MaterialWidget source) {
        open(source.getElement());
    }

    /**
     * Open the Overlay Panel with Path Animator applied
     */
    public void open(Element sourceElement) {
        this.sourceElement = sourceElement;
        $("body").attr("style", "overflow: hidden !important");
        animator.setSourceElement(sourceElement);
        animator.setTargetElement(getElement());
        animator.setCompletedCallback(() -> OpenEvent.fire(MaterialOverlay.this, MaterialOverlay.this));
        animator.animate();
    }

    /**
     * Open the Overlay Panel without Path Animator
     */
    public void open() {
        setVisibility(Style.Visibility.VISIBLE);
        setOpacity(1);
        OpenEvent.fire(this, this);
    }

    /**
     * Close the Overlay Panel with Path Animator applied.
     */
    public void close() {
        close(true);
    }

    /**
     * Close the Overlay Panel with Path Animator applied.
     *
     * @param fireEventImmediately should we fire the close event immediately or wait for the animation.
     */
    public void close(boolean fireEventImmediately) {
        if ($(getElement()).parents(AddinsCssName.OVERLAY_PANEL).length() == 1) {
            body().attr("style", "overflow: hidden !important");
        } else {
            body().attr("style", "overflow: auto !important");
        }
        if (sourceElement != null) {
            if(!fireEventImmediately) {
                animator.setCompletedCallback(() -> CloseEvent.fire(MaterialOverlay.this, MaterialOverlay.this));
            } else {
                CloseEvent.fire(MaterialOverlay.this, MaterialOverlay.this);
            }
            animator.reverseAnimate();
        } else {
            setOpacity(0);
            setVisibility(Style.Visibility.HIDDEN);
            CloseEvent.fire(MaterialOverlay.this, MaterialOverlay.this);
        }
    }

    public boolean isOpen() {
        Style.Visibility visibility = getVisibility();
        return visibility == null || !visibility.equals(Style.Visibility.HIDDEN);
    }

    /**
     * Get source element for path animator
     */
    public Element getSourceElement() {
        return sourceElement;
    }

    /**
     * Set source element for path animator
     */
    public void setSourceElement(Element sourceElement) {
        this.sourceElement = sourceElement;
    }

    @Override
    public int getDuration() {
        return animator.getDuration();
    }

    @Override
    public void setDuration(int duration) {
        animator.setDuration(duration);
    }

    public int getTargetShowDuration() {
        return animator.getTargetShowDuration();
    }

    /**
     * Duration (in milliseconds) of targetElement to become visible, if hidden initially. The library will automatically try to figure this out from the element's computed styles. Default is 0 seconds.
     */
    public void setTargetShowDuration(int targetShowDuration) {
        animator.setTargetShowDuration(targetShowDuration);
    }

    public int getExtraTransitionDuration() {
        return animator.getExtraTransitionDuration();
    }

    /**
     * Extra duration (in milliseconds) of targetElement to provide visual continuity between the animation and the rendering of the targetElement. Default is 1 second
     */
    public void setExtraTransitionDuration(int extraTransitionDuration) {
        animator.setExtraTransitionDuration(extraTransitionDuration);
    }

    public void setRelativeToWindow(boolean relativeToWindow) {
        animator.setRelativeToWindow(relativeToWindow);
    }

    public boolean isRelativeToWindow() {
        return animator.isRelativeToWindow();
    }

    @Override
    public HandlerRegistration addCloseHandler(CloseHandler<MaterialOverlay> closeHandler) {
        return addHandler(new CloseHandler<MaterialOverlay>() {
            @Override
            public void onClose(CloseEvent<MaterialOverlay> closeEvent) {
                if (isEnabled()) {
                    closeHandler.onClose(closeEvent);
                }
            }
        }, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler<MaterialOverlay> openHandler) {
        return addHandler(new OpenHandler<MaterialOverlay>() {
            @Override
            public void onOpen(OpenEvent<MaterialOverlay> openEvent) {
                if (isEnabled()) {
                    openHandler.onOpen(openEvent);
                }
            }
        }, OpenEvent.getType());
    }

    public MaterialOverlayTab getOverlayTab() {
        return overlayTab;
    }

    public void setOverlayTab(MaterialOverlayTab overlayTab) {
        this.overlayTab = overlayTab;
        minimizeIcon.addStyleName(AddinsCssName.MINIMIZE_ICON);
        minimizeIcon.addMouseDownHandler(e -> minimize());
        add(minimizeIcon);
    }

    protected void minimize() {
        if (overlayTab != null) {
            overlayTab.minimize(this);
        } else {
            GWT.log("You must set the overlay container before minimizing the overlay.", new IllegalStateException());
        }
    }

    public MaterialIcon getMinimizeIcon() {
        return minimizeIcon;
    }
}