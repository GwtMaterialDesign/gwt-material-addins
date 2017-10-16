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
package gwt.material.design.addins.client.carousel.js;

import gwt.material.design.client.base.Options;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for carousel component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsCarouselOptions extends Options {

    private JsCarouselOptions() {}

    @JsOverlay
    public final static JsCarouselOptions create() {
        JsCarouselOptions options = new JsCarouselOptions();
        options.infinite = false;
        options.centerMode = false;
        options.variableWidth = false;
        options.dots = true;
        options.arrows = true;
        options.adaptiveHeight = false;
        options.autoplay = false;
        options.fade = false;
        options.slidesToShow = 1;
        options.slidesToScroll = 1;
        options.speed = 300;
        options.autoplaySpeed = 3000;
        options.edgeFriction = 0.15;
        options.swipeToSlide = true;
        options.focusOnSelect = false;
        options.centerPadding = "100px";

        // Responsive options
        JsResponsiveOptions[] responsiveOptions = new JsResponsiveOptions[]{};
        JsCarouselOptions tabletSettings = new JsCarouselOptions();
        JsCarouselOptions mobileSettings = new JsCarouselOptions();

        // Tablet Settings
        JsResponsiveOptions tabletOpt = new JsResponsiveOptions();
        tabletOpt.breakpoint = 992;
        tabletOpt.settings = tabletSettings;
        responsiveOptions[0] = tabletOpt;

        // Mobile Settings
        JsResponsiveOptions mobileOpt = new JsResponsiveOptions();
        mobileOpt.breakpoint = 600;
        mobileOpt.settings = mobileSettings;
        responsiveOptions[1] = mobileOpt;

        options.responsive = responsiveOptions;

        return options;
    }

    @JsProperty
    private boolean accessibility;

    @JsProperty
    private boolean adaptiveHeight;

    @JsProperty
    private boolean autoplay;

    @JsProperty
    private int autoplaySpeed;

    @JsProperty
    private boolean arrows;

    @JsProperty
    private String asNavFor;

    @JsProperty
    private String appendArrows;

    @JsProperty
    private String appendDots;

    @JsProperty
    private String prevArrow;

    @JsProperty
    private String nextArrow;

    @JsProperty
    private boolean centerMode;

    @JsProperty
    private String centerPadding;

    @JsProperty
    private String cssEase;

    @JsProperty
    private boolean dots;

    @JsProperty
    private boolean draggable;

    @JsProperty
    private boolean fade;

    @JsProperty
    private boolean focusOnSelect;

    @JsProperty
    private String easing;

    @JsProperty
    private double edgeFriction;

    @JsProperty
    private boolean infinite;

    @JsProperty
    private boolean variableWidth;

    @JsProperty
    private int initialSlide;

    @JsProperty
    private String lazyLoad;

    @JsProperty
    private boolean mobileFirst;

    @JsProperty
    private boolean pauseOnFocus;

    @JsProperty
    private boolean pauseOnHover;

    @JsProperty
    private boolean pauseOnDotsHover;

    @JsProperty
    private int rows;

    @JsProperty
    private int slidesPerRow;

    @JsProperty
    private int slidesToShow;

    @JsProperty
    private int slidesToScroll;

    @JsProperty
    private int speed;

    @JsProperty
    private boolean swipe;

    @JsProperty
    private boolean swipeToSlide;

    @JsProperty
    private boolean touchMove;

    @JsProperty
    private int touchThreshold;

    @JsProperty
    private boolean vertical;

    @JsProperty
    private boolean verticalSwiping;

    @JsProperty
    private boolean rtl;

    @JsProperty
    private boolean waitForAnimate;

    @JsProperty
    private JsResponsiveOptions[] responsive;

    // Getters and Setters

    public boolean isAccessibility() {
        return accessibility;
    }

    public void setAccessibility(boolean accessibility) {
        maybeNotifyChange("accessibility", this.accessibility, accessibility);
        this.accessibility = accessibility;
    }

    public boolean isAdaptiveHeight() {
        return adaptiveHeight;
    }

    public void setAdaptiveHeight(boolean adaptiveHeight) {
        maybeNotifyChange("adaptiveHeight", this.adaptiveHeight, adaptiveHeight);
        this.adaptiveHeight = adaptiveHeight;
    }

    public boolean isAutoplay() {
        return autoplay;
    }

    public void setAutoplay(boolean autoplay) {
        maybeNotifyChange("autoplay", this.autoplay, autoplay);
        this.autoplay = autoplay;
    }

    public int getAutoplaySpeed() {
        return autoplaySpeed;
    }

    public void setAutoplaySpeed(int autoplaySpeed) {
        maybeNotifyChange("autoplaySpeed", this.autoplaySpeed, autoplaySpeed);
        this.autoplaySpeed = autoplaySpeed;
    }

    public boolean isArrows() {
        return arrows;
    }

    public void setArrows(boolean arrows) {
        maybeNotifyChange("arrows", this.arrows, arrows);
        this.arrows = arrows;
    }

    public String getAsNavFor() {
        return asNavFor;
    }

    public void setAsNavFor(String asNavFor) {
        maybeNotifyChange("asNavFor", this.asNavFor, asNavFor);
        this.asNavFor = asNavFor;
    }

    public String getAppendArrows() {
        return appendArrows;
    }

    public void setAppendArrows(String appendArrows) {
        maybeNotifyChange("appendArrows", this.appendArrows, appendArrows);
        this.appendArrows = appendArrows;
    }

    public String getAppendDots() {
        return appendDots;
    }

    public void setAppendDots(String appendDots) {
        maybeNotifyChange("appendDots", this.appendDots, appendDots);
        this.appendDots = appendDots;
    }

    public String getPrevArrow() {
        return prevArrow;
    }

    public void setPrevArrow(String prevArrow) {
        maybeNotifyChange("prevArrow", this.prevArrow, prevArrow);
        this.prevArrow = prevArrow;
    }

    public String getNextArrow() {
        return nextArrow;
    }

    public void setNextArrow(String nextArrow) {
        maybeNotifyChange("nextArrow", this.nextArrow, nextArrow);
        this.nextArrow = nextArrow;
    }

    public boolean isCenterMode() {
        return centerMode;
    }

    public void setCenterMode(boolean centerMode) {
        maybeNotifyChange("centerMode", this.centerMode, centerMode);
        this.centerMode = centerMode;
    }

    public String getCenterPadding() {
        return centerPadding;
    }

    public void setCenterPadding(String centerPadding) {
        maybeNotifyChange("centerPadding", this.centerPadding, centerPadding);
        this.centerPadding = centerPadding;
    }

    public String getCssEase() {
        return cssEase;
    }

    public void setCssEase(String cssEase) {
        maybeNotifyChange("cssEase", this.cssEase, cssEase);
        this.cssEase = cssEase;
    }

    public boolean isDots() {
        return dots;
    }

    public void setDots(boolean dots) {
        maybeNotifyChange("dots", this.dots, dots);
        this.dots = dots;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public void setDraggable(boolean draggable) {
        maybeNotifyChange("draggable", this.draggable, draggable);
        this.draggable = draggable;
    }

    public boolean isFade() {
        return fade;
    }

    public void setFade(boolean fade) {
        maybeNotifyChange("fade", this.fade, fade);
        this.fade = fade;
    }

    public boolean isFocusOnSelect() {
        return focusOnSelect;
    }

    public void setFocusOnSelect(boolean focusOnSelect) {
        maybeNotifyChange("focusOnSelect", this.focusOnSelect, focusOnSelect);
        this.focusOnSelect = focusOnSelect;
    }

    public String getEasing() {
        return easing;
    }

    public void setEasing(String easing) {
        maybeNotifyChange("easing", this.easing, easing);
        this.easing = easing;
    }

    public double getEdgeFriction() {
        return edgeFriction;
    }

    public void setEdgeFriction(double edgeFriction) {
        maybeNotifyChange("edgeFriction", this.edgeFriction, edgeFriction);
        this.edgeFriction = edgeFriction;
    }

    public boolean isInfinite() {
        return infinite;
    }

    public void setInfinite(boolean infinite) {
        maybeNotifyChange("infinite", this.infinite, infinite);
        this.infinite = infinite;
    }

    public boolean isVariableWidth() {
        return variableWidth;
    }

    public void setVariableWidth(boolean variableWidth) {
        maybeNotifyChange("variableWidth", this.variableWidth, variableWidth);
        this.variableWidth = variableWidth;
    }

    public int getInitialSlide() {
        return initialSlide;
    }

    public void setInitialSlide(int initialSlide) {
        maybeNotifyChange("initialSlide", this.initialSlide, initialSlide);
        this.initialSlide = initialSlide;
    }

    public String getLazyLoad() {
        return lazyLoad;
    }

    public void setLazyLoad(String lazyLoad) {
        maybeNotifyChange("lazyLoad", this.lazyLoad, lazyLoad);
        this.lazyLoad = lazyLoad;
    }

    public boolean isMobileFirst() {
        return mobileFirst;
    }

    public void setMobileFirst(boolean mobileFirst) {
        maybeNotifyChange("mobileFirst", this.mobileFirst, mobileFirst);
        this.mobileFirst = mobileFirst;
    }

    public boolean isPauseOnFocus() {
        return pauseOnFocus;
    }

    public void setPauseOnFocus(boolean pauseOnFocus) {
        maybeNotifyChange("pauseOnFocus", this.pauseOnFocus, pauseOnFocus);
        this.pauseOnFocus = pauseOnFocus;
    }

    public boolean isPauseOnHover() {
        return pauseOnHover;
    }

    public void setPauseOnHover(boolean pauseOnHover) {
        maybeNotifyChange("pauseOnHover", this.pauseOnHover, pauseOnHover);
        this.pauseOnHover = pauseOnHover;
    }

    public boolean isPauseOnDotsHover() {
        return pauseOnDotsHover;
    }

    public void setPauseOnDotsHover(boolean pauseOnDotsHover) {
        maybeNotifyChange("pauseOnDotsHover", this.pauseOnDotsHover, pauseOnDotsHover);
        this.pauseOnDotsHover = pauseOnDotsHover;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        maybeNotifyChange("rows", this.rows, rows);
        this.rows = rows;
    }

    public int getSlidesPerRow() {
        return slidesPerRow;
    }

    public void setSlidesPerRow(int slidesPerRow) {
        maybeNotifyChange("slidesPerRow", this.slidesPerRow, slidesPerRow);
        this.slidesPerRow = slidesPerRow;
    }

    public int getSlidesToShow() {
        return slidesToShow;
    }

    public void setSlidesToShow(int slidesToShow) {
        maybeNotifyChange("slidesToShow", this.slidesToShow, slidesToShow);
        this.slidesToShow = slidesToShow;
    }

    public int getSlidesToScroll() {
        return slidesToScroll;
    }

    public void setSlidesToScroll(int slidesToScroll) {
        maybeNotifyChange("slidesToScroll", this.slidesToScroll, slidesToScroll);
        this.slidesToScroll = slidesToScroll;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        maybeNotifyChange("speed", this.speed, speed);
        this.speed = speed;
    }

    public boolean isSwipe() {
        return swipe;
    }

    public void setSwipe(boolean swipe) {
        maybeNotifyChange("swipe", this.swipe, swipe);
        this.swipe = swipe;
    }

    public boolean isSwipeToSlide() {
        return swipeToSlide;
    }

    public void setSwipeToSlide(boolean swipeToSlide) {
        maybeNotifyChange("swipeToSlide", this.swipeToSlide, swipeToSlide);
        this.swipeToSlide = swipeToSlide;
    }

    public boolean isTouchMove() {
        return touchMove;
    }

    public void setTouchMove(boolean touchMove) {
        maybeNotifyChange("touchMove", this.touchMove, touchMove);
        this.touchMove = touchMove;
    }

    public int getTouchThreshold() {
        return touchThreshold;
    }

    public void setTouchThreshold(int touchThreshold) {
        maybeNotifyChange("touchThreshold", this.touchThreshold, touchThreshold);
        this.touchThreshold = touchThreshold;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        maybeNotifyChange("vertical", this.vertical, vertical);
        this.vertical = vertical;
    }

    public boolean isVerticalSwiping() {
        return verticalSwiping;
    }

    public void setVerticalSwiping(boolean verticalSwiping) {
        maybeNotifyChange("verticalSwiping", this.verticalSwiping, verticalSwiping);
        this.verticalSwiping = verticalSwiping;
    }

    public boolean isRtl() {
        return rtl;
    }

    public void setRtl(boolean rtl) {
        maybeNotifyChange("rtl", this.rtl, rtl);
        this.rtl = rtl;
    }

    public boolean isWaitForAnimate() {
        return waitForAnimate;
    }

    public void setWaitForAnimate(boolean waitForAnimate) {
        maybeNotifyChange("waitForAnimate", this.waitForAnimate, waitForAnimate);
        this.waitForAnimate = waitForAnimate;
    }

    public JsResponsiveOptions[] getResponsive() {
        return responsive;
    }

    public void setResponsive(JsResponsiveOptions[] responsive) {
        maybeNotifyChange("responsive", this.responsive, responsive);
        this.responsive = responsive;
    }
}
