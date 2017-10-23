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

import com.google.gwt.dom.client.Document;
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

    private MaterialWidget source;
    private MaterialPathAnimator animator = new MaterialPathAnimator();

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

    /**
     * Open the Overlay Panel with Path Animator applied
     */
    public void open(MaterialWidget source) {
        this.source = source;
        $("body").attr("style", "overflow: hidden !important");
        animator.setSourceElement(source.getElement());
        animator.setTargetElement(getElement());
        animator.animate();
        OpenEvent.fire(this, this);
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
     * Close the Overlay Panel with Path Animator applied
     */
    public void close() {
        body().attr("style", "overflow: auto !important");
        if (source != null) {
            animator.reverseAnimate();
        }
        CloseEvent.fire(this, this);
    }

    /**
     * Get source widget for path animator
     */
    public MaterialWidget getSource() {
        return source;
    }

    /**
     * Set source widget for path animator
     */
    public void setSource(MaterialWidget source) {
        this.source = source;
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
}