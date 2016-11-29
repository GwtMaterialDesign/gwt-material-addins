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
package gwt.material.design.addins.client.pathanimator;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.pathanimator.js.JsPathAnimator;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.jquery.client.api.Functions;

import static gwt.material.design.jquery.client.api.JQuery.$;

//@formatter:off

/**
 * Custom component that provides meaningfull transition between two elements to show visual continuity.
 * <p>
 * <pre>
 * {@code
 *
 * // CAN BE CALLED AS A HELPER STATIC CONTEXT
 * MaterialPathAnimator.animate(Element source, Element target, Functions.Func animateCallback);
 *
 * // INSTANTIATE THE PUSHPIN COMPONENT
 * MaterialPathAnimator animator = new MaterialPathAnimator();
 * animator.setSourceElement(btnSource1.getElement());
 * animator.setTargetElement(panelTarget1.getElement());
 * animator.animate();
 * // Reverse Animate
 * animator.reverseAnimate();
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#pathAnimator">Material Path Animator</a>
 */
//@formatter:on
public class MaterialPathAnimator {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectJs(MaterialPathAnimatorDebugClientBundle.INSTANCE.pathanimatorDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialPathAnimatorClientBundle.INSTANCE.pathanimatorJs());
        }
    }

    private Element sourceElement;
    private Element targetElement;
    private Functions.Func animateCallback;
    private Functions.Func reverseCallback;

    public MaterialPathAnimator() {
    }

    /**
     * Animate the path animator
     */
    public void animate() {
        $("document").ready(() -> {
            JsPathAnimator.cta(sourceElement, targetElement, () -> {
                if (animateCallback != null) {
                    animateCallback.call();
                } else {
                    // For default animateCallback when animateCallback is null
                    targetElement.getStyle().setVisibility(Style.Visibility.VISIBLE);
                    targetElement.getStyle().setOpacity(1);
                }
            });
        });
    }

    /**
     * Helper method to apply the path animator.
     *
     * @param source Source element to apply the Path Animator
     * @param target Target element to apply the Path Animator
     */
    public static void animate(Element source, final Element target) {
        animate(source, target, null);
    }

    /**
     * Helper method to apply the path animator.
     *
     * @param source Source widget to apply the Path Animator
     * @param target Target widget to apply the Path Animator
     */
    public static void animate(Widget source, final Widget target) {
        animate(source.getElement(), target.getElement());
    }

    /**
     * Helper method to apply the path animator with callback.
     *
     * @param source   Source widget to apply the Path Animator
     * @param target   Target widget to apply the Path Animator
     * @param callback The callback method to be called when the path animator is applied
     */
    public static void animate(Widget source, Widget target, Functions.Func callback) {
        animate(source.getElement(), target.getElement(), callback);
    }

    /**
     * Helper method to apply the path animator with callback.
     *
     * @param sourceElement   Source widget to apply the Path Animator
     * @param targetElement   Target widget to apply the Path Animator
     * @param animateCallback The callback method to be called when the path animator is applied
     */
    public static void animate(Element sourceElement, Element targetElement, Functions.Func animateCallback) {
        MaterialPathAnimator animator = new MaterialPathAnimator();
        animator.setSourceElement(sourceElement);
        animator.setTargetElement(targetElement);
        animator.setAnimateCallback(animateCallback);
        animator.animate();
    }

    /**
     * Reverse the Animation
     */
    public void reverseAnimate() {
        $("document").ready(() -> {
            if (reverseCallback != null) {
                reverseCallback.call();
            } else {
                targetElement.getStyle().setVisibility(Style.Visibility.HIDDEN);
                targetElement.getStyle().setOpacity(0);
            }
            JsPathAnimator.cta(targetElement, sourceElement);
        });
    }

    /**
     * Helper method to reverse animate the source element to target element.
     *
     * @param sourceElement Source element to apply the Path Animator
     * @param targetElement Target element to apply the Path Animator
     */
    public static void reverseAnimate(final Element sourceElement, final Element targetElement) {
        reverseAnimate(sourceElement, targetElement, null);
    }

    /**
     * Helper method to reverse animate the source element to target element.
     *
     * @param source Source widget to apply the Path Animator
     * @param target Target widget to apply the Path Animator
     */
    public static void reverseAnimate(final Widget source, final Widget target) {
        reverseAnimate(source.getElement(), target.getElement());
    }

    /**
     * Helper method to reverse animate the source element to target element with reverse callback.
     *
     * @param source          Source widget to apply the Path Animator
     * @param target          Target widget to apply the Path Animator
     * @param reverseCallback The reverse callback method to be called when the path animator is applied
     */
    public static void reverseAnimate(Widget source, Widget target, Functions.Func reverseCallback) {
        reverseAnimate(source.getElement(), target.getElement(), reverseCallback);
    }

    /**
     * Helper method to reverse animate the source element to target element with reverse callback
     *
     * @param sourceElement   Source element to apply the Path Animator
     * @param targetElement   Target element to apply the Path Animator
     * @param reverseCallback The reverse callback method to be called when the path animator is applied
     */
    public static void reverseAnimate(Element sourceElement, Element targetElement, Functions.Func reverseCallback) {
        MaterialPathAnimator animator = new MaterialPathAnimator();
        animator.setSourceElement(sourceElement);
        animator.setTargetElement(targetElement);
        animator.setReverseCallback(reverseCallback);
        animator.reverseAnimate();
    }

    /**
     * Get the source element
     */
    public Element getSourceElement() {
        return sourceElement;
    }

    /**
     * Set the source element
     */
    public void setSourceElement(Element sourceElement) {
        this.sourceElement = sourceElement;
    }

    /**
     * Get the target element
     */
    public Element getTargetElement() {
        return targetElement;
    }

    /**
     * Set the target element
     */
    public void setTargetElement(Element targetElement) {
        this.targetElement = targetElement;
    }

    /**
     * Get the callback method when the path animator is applied
     */
    public Functions.Func getAnimateCallback() {
        return animateCallback;
    }

    /**
     * Set the callback method when the path animator is applied
     */
    public void setAnimateCallback(Functions.Func animateCallback) {
        this.animateCallback = animateCallback;
    }

    /**
     * Get the reverse callback method when the path animator is applied
     */
    public Functions.Func getReverseCallback() {
        return reverseCallback;
    }

    /**
     * Set the reverse callback method when the path animator is applied
     */
    public void setReverseCallback(Functions.Func reverseCallback) {
        this.reverseCallback = reverseCallback;
    }
}