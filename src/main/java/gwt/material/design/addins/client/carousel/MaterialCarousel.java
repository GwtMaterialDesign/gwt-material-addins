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

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.carousel.constants.CarouselType;
import gwt.material.design.addins.client.carousel.events.*;
import gwt.material.design.addins.client.carousel.js.JsCarousel;
import gwt.material.design.addins.client.carousel.js.JsCarouselOptions;
import gwt.material.design.addins.client.carousel.js.JsResponsiveOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.mixin.CssTypeMixin;

import static gwt.material.design.addins.client.carousel.js.JsCarousel.$;

//@formatter:off

/**
 * Carousel is a robust and versatile component that can be an image slider, to an item carousel, to an onboarding experience. It is touch enabled making it especially smooth to use on mobile.
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
 * <ma:carousel.MaterialCarousel textAlign="CENTER">
 *    <m:MaterialPanel paddingTop="50" backgroundColor="GREY_LIGHTEN_2" padding="20" height="200px">
 *      <m:MaterialLabel textColor="BLUE" fontSize="5em" fontWeight="LIGHTER" text="1" />
 *    </m:MaterialPanel>
 *
 *    <m:MaterialPanel paddingTop="50" backgroundColor="GREY_LIGHTEN_2" padding="20" height="200px">
 *      <m:MaterialLabel textColor="BLUE" fontSize="5em" fontWeight="LIGHTER" text="2" />
 *    </m:MaterialPanel>
 *    <!-- Other panels here -->
 *  </ma:carousel.MaterialCarousel>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#carousel">Material Carousel</a>
 */
//@formatter:on
public class MaterialCarousel extends MaterialCarouselBase implements HasType<CarouselType>, HasCarouselEvents {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialCarouselDebugClientBundle.INSTANCE.carouselCssDebug());
            MaterialDesignBase.injectDebugJs(MaterialCarouselDebugClientBundle.INSTANCE.carouselJsDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialCarouselClienBundle.INSTANCE.carouselCss());
            MaterialDesignBase.injectJs(MaterialCarouselClienBundle.INSTANCE.carouselJs());
        }
    }

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
    private double edgeFriction = 0.15;
    private String centerPadding = "100px";
    private JsCarouselOptions options = new JsCarouselOptions();
    private JsResponsiveOptions[] responsiveOptions = new JsResponsiveOptions[]{};
    private JsCarouselOptions tabletSettings;
    private JsCarouselOptions mobileSettings;

    private final CssTypeMixin<CarouselType, MaterialCarousel> typeMixin = new CssTypeMixin<>(this);


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

    public void initialize() {
        options.dots = showDots;
        options.arrows = showArrows;
        options.infinite = infinite;
        options.centerMode = centerMode;
        options.variableWidth = variableWidth;
        options.adaptiveHeight = adaptiveHeight;
        options.autoplay = autoplay;
        options.fade = fade;
        options.edgeFriction = edgeFriction;
        options.autoplaySpeed = autoplaySpeed;
        options.slidesToShow = slidesToShow;
        options.slidesToScroll = slidesToScroll;
        options.speed = speed;
        options.centerPadding = centerPadding;
        options.nextArrow = "#" + getBtnNextArrow().getId();
        options.prevArrow = "#" + getBtnPrevArrow().getId();

        $(getElement()).on("afterChange", (e, slick, currentSlide) -> {
            AfterChangeEvent.fire(this, Integer.parseInt(currentSlide.toString()));
            return true;
        });

        $(getElement()).on("beforeChange", (e, slick, currentSlide, nextSlide) -> {
            BeforeChangeEvent.fire(this, Integer.parseInt(currentSlide.toString()), Integer.parseInt(nextSlide.toString()));
            return true;
        });

        $(getElement()).on("init", (e) -> {
            InitEvent.fire(this);
            return true;
        });

        $(getElement()).on("destroy", (e) -> {
            DestroyEvent.fire(this);
            return true;
        });

        $(getElement()).on("swipe", (e, slick, direction) -> {
            SwipeEvent.fire(this, direction.toString());
            return true;
        });

        // Tablet Settings
        if (tabletSettings != null) {
            JsResponsiveOptions tabletOpt = new JsResponsiveOptions();
            tabletOpt.breakpoint = 992;
            tabletOpt.settings = tabletSettings;
            responsiveOptions[0] = tabletOpt;
        }

        // Mobile Settings
        if (mobileSettings != null) {
            JsResponsiveOptions mobileOpt = new JsResponsiveOptions();
            mobileOpt.breakpoint = 600;
            mobileOpt.settings = mobileSettings;
            responsiveOptions[1] = mobileOpt;
        }

        options.responsive = responsiveOptions;
        getCarouselElement().slick(options);
    }

    protected JsCarousel getCarouselElement() {
        return $("#" + getContainer().getId());
    }

    public void destroy() {
        getCarouselElement().slick("unslick");
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

    public double getEdgeFriction() {
        return edgeFriction;
    }

    /**
     * Resistance when swiping edges of non-infinite carousels
     */
    public void setEdgeFriction(double edgeFriction) {
        this.edgeFriction = edgeFriction;
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

    /** TODO METHODS **/

    /**
     * Returns the current slide index
     */
    public int getCurrentSlideIndex() {
        if (getCarouselElement().slick("slickCurrentSlide").toString() != null) {
            return Integer.parseInt(getCarouselElement().slick("slickCurrentSlide").toString());
        }
        return -1;
    }

    /**
     * Navigates to a slide by index with animate as second parameter
     */
    public void goToSlide(int index, boolean animate) {
        getCarouselElement().slick("slickGoTo", index, animate);
    }

    /**
     * Navigates to a slide by index with animation
     */
    public void goToSlide(int index) {
        getCarouselElement().slick("slickGoTo", index, true);
    }

    /**
     * Navigates to the next slide
     */
    public void next() {
        getCarouselElement().slick("slickNext");
    }

    /**
     * Navigates to the previous slide
     */
    public void previous() {
        getCarouselElement().slick("slickPrev");
    }

    /**
     * Pauses autoplay
     */
    public void pause() {
        getCarouselElement().slick("slickPause");
    }

    /**
     * Starts autoplay
     */
    public void play() {
        getCarouselElement().slick("slickPlay");
    }

    @Override
    public void setType(CarouselType type) {
        typeMixin.setType(type);
    }

    @Override
    public CarouselType getType() {
        return typeMixin.getType();
    }

    public JsCarouselOptions getTabletSettings() {
        return tabletSettings;
    }

    public void setTabletSettings(JsCarouselOptions tabletSettings) {
        this.tabletSettings = tabletSettings;
    }

    public JsCarouselOptions getMobileSettings() {
        return mobileSettings;
    }

    public void setMobileSettings(JsCarouselOptions mobileSettings) {
        this.mobileSettings = mobileSettings;
    }

    @Override
    public HandlerRegistration addAfterChangeHandler(AfterChangeEvent.AfterChangeHandler handler) {
        return addHandler(handler, AfterChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addBeforeChangeHandler(BeforeChangeEvent.BeforeChangeHandler handler) {
        return addHandler(handler, BeforeChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addInitHandler(InitEvent.InitHandler handler) {
        return addHandler(handler, InitEvent.getType());
    }

    @Override
    public HandlerRegistration addDestroyHandler(DestroyEvent.DestroyHandler handler) {
        return addHandler(handler, DestroyEvent.getType());
    }

    @Override
    public HandlerRegistration addSwipeHandler(SwipeEvent.SwipeHandler handler) {
        return addHandler(handler, SwipeEvent.getType());
    }
}
