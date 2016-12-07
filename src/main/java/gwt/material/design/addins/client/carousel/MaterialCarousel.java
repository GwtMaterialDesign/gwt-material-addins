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
package gwt.material.design.addins.client.carousel;

import com.google.gwt.core.client.Scheduler;
import gwt.material.design.addins.client.carousel.js.JsCarouselOptions;

import static gwt.material.design.addins.client.carousel.js.JsCarousel.$;

public class MaterialCarousel extends MaterialCarouselBase {

    private boolean infinite;
    private boolean centerMode;
    private boolean variableWidth;
    private boolean showDots = true;
    private boolean showArrows = true;
    private boolean adaptiveHeight = false;
    private boolean autoplay;
    private boolean fade;
    private int slidesToShow = 1;
    private int slidesToScroll = 1;
    private int speed = 300;
    private int autoplaySpeed = 3000;
    private String centerPadding = "100px";


    @Override
    protected void onLoad() {
        super.onLoad();

        buildArrowNavigation();
        initialize();
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        destroy();
    }

    protected void initialize() {
        JsCarouselOptions options = new JsCarouselOptions();
        options.dots = showDots;
        options.arrows = showArrows;
        options.infinite = infinite;
        options.centerMode = centerMode;
        options.variableWidth = variableWidth;
        options.adaptiveHeight = adaptiveHeight;
        options.autoplay = autoplay;
        options.fade = fade;
        options.autoplaySpeed = autoplaySpeed;
        options.slidesToShow = slidesToShow;
        options.slidesToScroll = slidesToScroll;
        options.speed = speed;
        options.centerPadding = centerPadding;
        options.nextArrow = "#" + getBtnNextArrow().getId();
        options.prevArrow = "#" + getBtnPrevArrow().getId();

        Scheduler.get().scheduleDeferred(() -> {
            $("#" + getContainer().getId()).slick(options);
        });
    }

    public void destroy() {
        $("#" + getContainer().getId()).slick("unslick");
    }

    public boolean isShowDots() {
        return showDots;
    }

    /**
     * Show dots indicators (Default : true)
     */
    public void setShowDots(boolean showDots) {
        this.showDots = showDots;
    }

    public boolean isShowArrows() {
        return showArrows;
    }

    /**
     * Show Prev/Next Arrows (Default : true)
     */
    public void setShowArrows(boolean showArrows) {
        this.showArrows = showArrows;
        getBtnPrevArrow().setVisible(showArrows);
        getBtnNextArrow().setVisible(showArrows);
    }

    public int getSlidesToShow() {
        return slidesToShow;
    }

    /**
     * Number of Slides to show (Default : 1)
     */
    public void setSlidesToShow(int slidesToShow) {
        this.slidesToShow = slidesToShow;
    }

    public int getSlidesToScroll() {
        return slidesToScroll;
    }

    /**
     * Number of Slides to Scroll (Default : 1)
     */
    public void setSlidesToScroll(int slidesToScroll) {
        this.slidesToScroll = slidesToScroll;
    }

    public boolean isInfinite() {
        return infinite;
    }

    /**
     * Provides Infinite loop sliding (Default : true)
     */
    public void setInfinite(boolean infinite) {
        this.infinite = infinite;
    }

    public boolean isCenterMode() {
        return centerMode;
    }

    /**
     * Enables centered view with partial prev/next slides. Use with odd numbered slidesToShow counts. (Default : false)
     */
    public void setCenterMode(boolean centerMode) {
        this.centerMode = centerMode;
    }

    public boolean isVariableWidth() {
        return variableWidth;
    }

    /**
     * Allow any Variable width slides (Default : false)
     */
    public void setVariableWidth(boolean variableWidth) {
        this.variableWidth = variableWidth;
    }

    public boolean isAdaptiveHeight() {
        return adaptiveHeight;
    }

    /**
     * Enables adaptive height for single slide horizontal carousels. (Default : false)
     */
    public void setAdaptiveHeight(boolean adaptiveHeight) {
        this.adaptiveHeight = adaptiveHeight;
    }

    public int getSpeed() {
        return speed;
    }

    /**
     * Slide/Fade animation speed in milliseconds (Default : 300ms)
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getCenterPadding() {
        return centerPadding;
    }

    /**
     * Side padding when in center mode (px or %) (Default : 50px)
     */
    public void setCenterPadding(String centerPadding) {
        this.centerPadding = centerPadding;
    }

    public boolean isAutoplay() {
        return autoplay;
    }

    /**
     * Enables Autoplay (Default : false)
     */
    public void setAutoplay(boolean autoplay) {
        this.autoplay = autoplay;
    }

    public int getAutoplaySpeed() {
        return autoplaySpeed;
    }

    /**
     * Autoplay Speed in milliseconds (Default : 3000 ms or 3 seconds)
     */
    public void setAutoplaySpeed(int autoplaySpeed) {
        this.autoplaySpeed = autoplaySpeed;
    }

    public boolean isFade() {
        return fade;
    }

    /**
     * Enable Fade Transition
     */
    public void setFade(boolean fade) {
        this.fade = fade;
    }
}
