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
package gwt.material.design.addins.client.pathanimator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import elemental2.promise.Promise;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.addins.client.pathanimator.base.HasPathStyles;
import gwt.material.design.addins.client.pathanimator.base.PathStyleProperty;
import gwt.material.design.addins.client.pathanimator.base.PathStylerMixin;
import gwt.material.design.addins.client.pathanimator.js.JsPathAnimator;
import gwt.material.design.addins.client.pathanimator.js.JsPathAnimatorOptions;
import gwt.material.design.client.JQueryProvider;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.HasDurationTransition;
import gwt.material.design.client.base.helper.ScrollHelper;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.OffsetPosition;
import gwt.material.design.client.ui.animate.debugger.AnimationGlobalConfig;
import gwt.material.design.jquery.client.api.Functions;

import java.util.Collections;
import java.util.List;

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
 * @see <a href="https://github.com/chinchang/cta.js">CTAJs 0.3.2</a>
 */
//@formatter:on
public class MaterialPathAnimator implements HasDependency, HasDurationTransition, HasPathStyles {

    private ScrollHelper scrollHelper;
    private Element sourceElement;
    private Element targetElement;
    private Functions.Func animateCallback, startAnimateCallback, reverseCallback, completedCallback;
    private JsPathAnimatorOptions options = JsPathAnimatorOptions.create();
    private PathStylerMixin<MaterialPathAnimator> stylerMixin;
    private DependencyMixin<MaterialPathAnimator> dependencyMixin;

    public MaterialPathAnimator() {

    }

    public MaterialPathAnimator(Element sourceElement, Element targetElement) {
        this();
        this.sourceElement = sourceElement;
        this.targetElement = targetElement;
    }

    /**
     * Helper method to apply the path animator.
     *
     * @param source Source element to apply the Path Animator
     * @param target Target element to apply the Path Animator
     */
    public static Promise<MaterialPathAnimator> animate(Element source, final Element target) {
        return animate(source, target, null);
    }

    /**
     * Helper method to apply the path animator.
     *
     * @param source Source widget to apply the Path Animator
     * @param target Target widget to apply the Path Animator
     */
    public static Promise<MaterialPathAnimator> animate(Widget source, final Widget target) {
        return animate(source.getElement(), target.getElement());
    }

    /**
     * Helper method to apply the path animator with callback.
     *
     * @param source   Source widget to apply the Path Animator
     * @param target   Target widget to apply the Path Animator
     * @param callback The callback method to be called when the path animator is applied
     */
    public static Promise<MaterialPathAnimator> animate(Widget source, Widget target, Functions.Func callback) {
        return animate(source.getElement(), target.getElement(), callback);
    }

    /**
     * Helper method to apply the path animator with callback.
     *
     * @param sourceElement   Source widget to apply the Path Animator
     * @param targetElement   Target widget to apply the Path Animator
     * @param animateCallback The callback method to be called when the path animator is applied
     */
    public static Promise<MaterialPathAnimator> animate(Element sourceElement, Element targetElement, Functions.Func animateCallback) {
        MaterialPathAnimator animator = new MaterialPathAnimator();
        animator.setSourceElement(sourceElement);
        animator.setTargetElement(targetElement);
        animator.setAnimateCallback(animateCallback);
        return animator.animate();
    }

    /**
     * Animate the path animator
     */
    public Promise<MaterialPathAnimator> animate() {
        Promise<MaterialPathAnimator> promise = new Promise<>((resolve, reject) -> {
            getDependencyMixin().install(() -> {
                this.scrollHelper = new ScrollHelper();
                detectOutOfScopeElement(targetElement, () -> {
                    $("document").ready(() -> {
                        if (AnimationGlobalConfig.isEnableAnimation()) {
                            onStartAnimateCallback();
                            JsPathAnimator.cta(sourceElement, targetElement, options, () -> {
                                if (animateCallback != null) {
                                    animateCallback.call();
                                } else {
                                    // For default animateCallback when animateCallback is null
                                    targetElement.getStyle().setVisibility(Style.Visibility.VISIBLE);
                                    targetElement.getStyle().setOpacity(1);
                                }

                                onCompleteCallback();
                            });
                        } else {
                            onCompleteCallback();
                        }
                    });
                });
                resolve.onInvoke(this);
            });
        });
        return promise;
    }

    /**
     * Reverse the Animation
     */
    public Promise<MaterialPathAnimator> reverseAnimate() {
        Promise<MaterialPathAnimator> promise = new Promise<>((resolve, reject) -> {
            getDependencyMixin().install(() -> {
                this.scrollHelper = new ScrollHelper();
                onStartAnimateCallback();
                $("document").ready(() -> {
                    if (AnimationGlobalConfig.isEnableAnimation()) {
                        if (reverseCallback != null) {
                            reverseCallback.call();
                        } else {
                            targetElement.getStyle().setVisibility(Style.Visibility.HIDDEN);
                            targetElement.getStyle().setOpacity(0);
                        }
                        detectOutOfScopeElement(sourceElement, () -> JsPathAnimator.cta(targetElement, sourceElement, options, () -> onCompleteCallback()));
                    } else {
                        onCompleteCallback();
                    }
                });
                resolve.onInvoke(this);
            });
        });

        return promise;
    }

    /**
     * Will detect if the target / source element is out of scope in the viewport.
     * If it is then we will call {@link ScrollHelper#scrollTo(double)} with default offset position
     * of {@link OffsetPosition#MIDDLE}.
     */
    protected void detectOutOfScopeElement(Element element, Functions.Func callback) {
        if (element != null) {
            if (scrollHelper.isInViewPort(element)) {
                callback.call();
            } else {
                scrollHelper.setOffsetPosition(OffsetPosition.MIDDLE);
                scrollHelper.setCompleteCallback(() -> callback.call());
                scrollHelper.scrollTo(element);
            }
        }
    }

    protected void onStartAnimateCallback() {
        if (startAnimateCallback != null) {
            startAnimateCallback.call();
        }
    }

    protected void onCompleteCallback() {
        if (completedCallback != null) {
            completedCallback.call();
        }
    }

    /**
     * Helper method to reverse animate the source element to target element.
     *
     * @param sourceElement Source element to apply the Path Animator
     * @param targetElement Target element to apply the Path Animator
     */
    public static Promise<MaterialPathAnimator> reverseAnimate(final Element sourceElement, final Element targetElement) {
        return reverseAnimate(sourceElement, targetElement, null);
    }

    /**
     * Helper method to reverse animate the source element to target element.
     *
     * @param source Source widget to apply the Path Animator
     * @param target Target widget to apply the Path Animator
     */
    public static Promise<MaterialPathAnimator> reverseAnimate(final Widget source, final Widget target) {
        return reverseAnimate(source.getElement(), target.getElement());
    }

    /**
     * Helper method to reverse animate the source element to target element with reverse callback.
     *
     * @param source          Source widget to apply the Path Animator
     * @param target          Target widget to apply the Path Animator
     * @param reverseCallback The reverse callback method to be called when the path animator is applied
     */
    public static Promise<MaterialPathAnimator> reverseAnimate(Widget source, Widget target, Functions.Func reverseCallback) {
        return reverseAnimate(source.getElement(), target.getElement(), reverseCallback);
    }

    /**
     * Helper method to reverse animate the source element to target element with reverse callback
     *
     * @param sourceElement   Source element to apply the Path Animator
     * @param targetElement   Target element to apply the Path Animator
     * @param reverseCallback The reverse callback method to be called when the path animator is applied
     */
    public static Promise<MaterialPathAnimator> reverseAnimate(Element sourceElement, Element targetElement, Functions.Func reverseCallback) {
        MaterialPathAnimator animator = new MaterialPathAnimator();
        animator.setSourceElement(sourceElement);
        animator.setTargetElement(targetElement);
        animator.setReverseCallback(reverseCallback);
        return animator.reverseAnimate();
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

    public void setAnimateOnStartCallback(Functions.Func startAnimateCallback) {
        this.startAnimateCallback = startAnimateCallback;
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

    /**
     * Set a callback for when the animation has completed.
     */
    public void setCompletedCallback(Functions.Func completedCallback) {
        this.completedCallback = completedCallback;
    }

    @Override
    public void setDuration(int duration) {
        options.duration = (duration * AnimationGlobalConfig.getSpeed().getValue()) / 1000.0;
    }

    @Override
    public int getDuration() {
        return (int) (options.duration * 1000);
    }

    /**
     * Duration (in milliseconds) of targetElement to become visible, if hidden initially. The library will automatically try to figure this out from the element's computed styles. Default is 0 seconds.
     */
    public void setTargetShowDuration(int targetShowDuration) {
        options.targetShowDuration = (targetShowDuration * AnimationGlobalConfig.getSpeed().getValue()) / 1000.0;
    }

    public int getTargetShowDuration() {
        return (int) (options.targetShowDuration * 1000);
    }

    /**
     * Extra duration (in milliseconds) of targetElement to provide visual continuity between the animation and the rendering of the targetElement. Default is 1 second
     */
    public void setExtraTransitionDuration(int extraTransitionDuration) {
        options.extraTransitionDuration = (extraTransitionDuration * AnimationGlobalConfig.getSpeed().getValue()) / 1000.0;
    }

    public int getExtraTransitionDuration() {
        return (int) (options.extraTransitionDuration * 1000);
    }

    public boolean isRelativeToWindow() {
        return options.relativeToWindow;
    }

    /**
     * Set to true if your target element is fixed positioned in the window. Default is relative to document (works good with normal elements).
     */
    public void setRelativeToWindow(boolean relativeToWindow) {
        options.relativeToWindow = relativeToWindow;
    }

    public ScrollHelper getScrollHelper() {
        return scrollHelper;
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        getStylerMixin().setBackgroundColor(backgroundColor);
    }

    @Override
    public void setStyleProperty(PathStyleProperty property) {
        getStylerMixin().setStyleProperty(property);
    }

    @Override
    public void setStyleProperty(String property, String value) {
        getStylerMixin().setStyleProperty(property, value);
    }

    @Override
    public void clearStyleProperty(String property) {
        getStylerMixin().clearStyleProperty(property);
    }

    @Override
    public void clearStyles() {
        getStylerMixin().clearStyles();
    }

    public Element getBridgeElement() {
        return getStylerMixin().getBridgeElement();
    }

    @Override
    public void setShadow(Integer shadowDepth) {
        getStylerMixin().setShadow(shadowDepth);
    }

    protected PathStylerMixin<MaterialPathAnimator> getStylerMixin() {
        if (stylerMixin == null) {
            stylerMixin = new PathStylerMixin<>(this);
        }
        return stylerMixin;
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(MaterialPathAnimatorClientBundle.INSTANCE.pathanimatorJs(), MaterialPathAnimatorDebugClientBundle.INSTANCE.pathanimatorDebugJs()));
    }

    public DependencyMixin<MaterialPathAnimator> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
