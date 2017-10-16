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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.MaterialAddinWidget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.carousel.constants.CarouselType;
import gwt.material.design.addins.client.carousel.events.*;
import gwt.material.design.addins.client.carousel.js.JsCarouselOptions;
import gwt.material.design.addins.client.carousel.ui.NextArrow;
import gwt.material.design.addins.client.carousel.ui.PreviousArrow;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTab;

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
public class MaterialCarousel extends MaterialAddinWidget<JsCarouselOptions> implements HasType<CarouselType>, HasCarouselEvents {

    static int TABLET_SETTINGS = 0;
    static int MOBILE_SETTINGS = 1;

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialCarouselDebugClientBundle.INSTANCE.customCssDebug());
            MaterialDesignBase.injectCss(MaterialCarouselDebugClientBundle.INSTANCE.carouselCssDebug());
            MaterialDesignBase.injectDebugJs(MaterialCarouselDebugClientBundle.INSTANCE.carouselJsDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialCarouselClientBundle.INSTANCE.customCss());
            MaterialDesignBase.injectCss(MaterialCarouselClientBundle.INSTANCE.carouselCss());
            MaterialDesignBase.injectJs(MaterialCarouselClientBundle.INSTANCE.carouselJs());
        }
    }

    private MaterialPanel container = new MaterialPanel();
    private NextArrow nextArrow = new NextArrow();
    private PreviousArrow previousArrow = new PreviousArrow();
    private MaterialPanel wrapper = new MaterialPanel();

    private CssTypeMixin<CarouselType, MaterialCarousel> typeMixin;

    public MaterialCarousel() {
        super(Document.get().createDivElement(), JsCarouselOptions.create(), AddinsCssName.MATERIAL_CAROUSEL);
    }

    private final ToggleStyleMixin<MaterialCarousel> fsMixin = new ToggleStyleMixin<>(this, CssName.FULLSCREEN);

    @Override
    protected void onLoad() {
        super.onLoad();

        wrapper.setStyleName(AddinsCssName.MATERIAL_CAROUSEL_CONTAINER);
        container.setId(DOM.createUniqueId());
        wrapper.add(container);

        super.add(nextArrow);
        super.add(previousArrow);
        super.add(wrapper);

        $(getElement()).on(CarouselEvents.AFTER_CHANGE, (e, slick, currentSlide) -> {
            AfterChangeEvent.fire(this, Integer.parseInt(currentSlide.toString()));
            return true;
        });

        $(getElement()).on(CarouselEvents.BEFORE_CHANGE, (e, slick, currentSlide, nextSlide) -> {
            BeforeChangeEvent.fire(this, Integer.parseInt(currentSlide.toString()), Integer.parseInt(nextSlide.toString()));
            e.stopPropagation();
            return true;
        });

        $(getElement()).on(CarouselEvents.INIT, (e) -> {
            InitEvent.fire(this);
            return true;
        });

        $(getElement()).on(CarouselEvents.DESTROY, (e) -> {
            DestroyEvent.fire(this);
            return true;
        });

        $(getElement()).on(CarouselEvents.SWIPE, (e, slick, direction) -> {
            SwipeEvent.fire(this, direction.toString());
            return true;
        });

        load();
    }

    @Override
    public void load() {
        options.setNextArrow("#" + getBtnNextArrow().getId());
        options.setPrevArrow("#" + getBtnPrevArrow().getId());

        super.load();

        Scheduler.get().scheduleDeferred(() -> $(container.getElement()).slick(options));
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        $(getElement()).off(CarouselEvents.AFTER_CHANGE);
        $(getElement()).off(CarouselEvents.BEFORE_CHANGE);
        $(getElement()).off(CarouselEvents.INIT);
        $(getElement()).off(CarouselEvents.DESTROY);
        $(getElement()).off(CarouselEvents.SWIPE);

        destroy();
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    public void destroy() {
        command("destroy");
    }

    @Override
    public void add(Widget child) {
        if (child instanceof MaterialCarouselFixedItem) {
            wrapper.add(child);
        } else {
            container.add(child);
            command("slickAdd", child.getElement());
        }
    }

    @Override
    public boolean remove(int index) {
        command("slickRemove", index);
        return true;
    }

    @Override
    public void clear() {
        getContainer().clear();
    }

    /**
     * Returns the current slide index
     */
    public int getCurrentSlideIndex() {
        if (command("slickCurrentSlide").toString() != null) {
            return Integer.parseInt(command("slickCurrentSlide").toString());
        }
        return -1;
    }

    /**
     * Navigates to a slide by index with animate as second parameter
     */
    public void goToSlide(int index, boolean noAnimation) {
        command("slickGoTo", index, noAnimation);
    }

    /**
     * Navigates to a slide by index with animation
     */
    public void goToSlide(int index) {
        command("slickGoTo", index, false);
    }

    /**
     * Navigates to the next slide
     */
    public void next() {
        command("slickNext");
    }

    /**
     * Navigates to the previous slide
     */
    public void previous() {
        command("slickPrev");
    }

    /**
     * Pauses autoplay
     */
    public void pause() {
        command("slickPause");
    }

    /**
     * Starts autoplay
     */
    public void play() {
        command("slickPlay");
    }

    protected Object command(String action, Object... params) {
        if (container == null) {
            GWT.log("Your carousel container is not yet initialized", new IllegalStateException());
        } else {
            return $("#" + container.getId()).slick(action, params);
        }
        return null;
    }

    /**
     * Set the image slider to fullscreen view.
     */
    public void setFullscreen(boolean fullscreen) {
        fsMixin.setOn(fullscreen);
    }

    public boolean isFullscreen() {
        return fsMixin.isOn();
    }

    public boolean isShowDots() {
        return options.isDots();
    }

    /**
     * Show dots indicators (Default : true)
     */
    public void setShowDots(boolean showDots) {
        options.setDots(showDots);
    }

    public boolean isShowArrows() {
        return options.isArrows();
    }

    /**
     * Show Prev/Next Arrows (Default : true)
     */
    public void setShowArrows(boolean showArrows) {
        options.setArrows(showArrows);

        getBtnPrevArrow().setVisible(showArrows);
        getBtnNextArrow().setVisible(showArrows);
    }

    public int getSlidesToShow() {
        return options.getSlidesToShow();
    }

    /**
     * Number of Slides to show (Default : 1)
     */
    public void setSlidesToShow(int slidesToShow) {
        options.setSlidesToShow(slidesToShow);
    }

    public int getSlidesToScroll() {
        return options.getSlidesToScroll();
    }

    /**
     * Number of Slides to Scroll (Default : 1)
     */
    public void setSlidesToScroll(int slidesToScroll) {
        options.setSlidesToScroll(slidesToScroll);
    }

    public boolean isInfinite() {
        return options.isInfinite();
    }

    /**
     * Provides Infinite loop sliding (Default : true)
     */
    public void setInfinite(boolean infinite) {
        options.setInfinite(infinite);
    }

    public boolean isCenterMode() {
        return options.isCenterMode();
    }

    /**
     * Enables centered view with partial prev/next slides. Use with odd numbered slidesToShow counts. (Default : false)
     */
    public void setCenterMode(boolean centerMode) {
        options.setCenterMode(centerMode);
    }

    public boolean isVariableWidth() {
        return options.isVariableWidth();
    }

    /**
     * Allow any Variable width slides (Default : false)
     */
    public void setVariableWidth(boolean variableWidth) {
        options.setVariableWidth(variableWidth);
    }

    public boolean isAdaptiveHeight() {
        return options.isAdaptiveHeight();
    }

    /**
     * Enables adaptive height for single slide horizontal carousels. (Default : false)
     */
    public void setAdaptiveHeight(boolean adaptiveHeight) {
        options.setAdaptiveHeight(adaptiveHeight);
    }

    public int getSpeed() {
        return options.getSpeed();
    }

    /**
     * Slide/Fade animation speed in milliseconds (Default : 300ms)
     */
    public void setSpeed(int speed) {
        options.setSpeed(speed);
    }

    public String getCenterPadding() {
        return options.getCenterPadding();
    }

    /**
     * Side padding when in center mode (px or %) (Default : 50px)
     */
    public void setCenterPadding(String centerPadding) {
        options.setCenterPadding(centerPadding);
    }

    public boolean isAutoplay() {
        return options.isAutoplay();
    }

    /**
     * Enables Autoplay (Default : false)
     */
    public void setAutoplay(boolean autoplay) {
        options.setAutoplay(autoplay);
    }

    public int getAutoplaySpeed() {
        return options.getAutoplaySpeed();
    }

    /**
     * Autoplay Speed in milliseconds (Default : 3000 ms or 3 seconds)
     */
    public void setAutoplaySpeed(int autoplaySpeed) {
        options.setAutoplaySpeed(autoplaySpeed);
    }

    public double getEdgeFriction() {
        return options.getEdgeFriction();
    }

    /**
     * Resistance when swiping edges of non-infinite carousels
     */
    public void setEdgeFriction(double edgeFriction) {
        options.setEdgeFriction(edgeFriction);
    }

    public boolean isFade() {
        return options.isFade();
    }

    /**
     * Enable Fade Transition
     */
    public void setFade(boolean fade) {
        options.setFade(fade);
    }

    public boolean isFocusOnSelect() {
        return options.isFocusOnSelect();
    }

    /**
     * Enable focus on selected element (click)
     */
    public void setFocusOnSelect(boolean focusOnSelect) {
        options.setFocusOnSelect(focusOnSelect);
    }

    @Override
    public void setType(CarouselType type) {
        getTypeMixin().setType(type);
    }

    @Override
    public CarouselType getType() {
        return getTypeMixin().getType();
    }

    public JsCarouselOptions getTabletSettings() {
        return options.getResponsive()[TABLET_SETTINGS].settings;
    }

    public void setTabletSettings(JsCarouselOptions tabletSettings) {
        options.getResponsive()[TABLET_SETTINGS].settings = tabletSettings;
    }

    public JsCarouselOptions getMobileSettings() {
        return options.getResponsive()[MOBILE_SETTINGS].settings;
    }

    public void setMobileSettings(JsCarouselOptions mobileSettings) {
        options.getResponsive()[MOBILE_SETTINGS].settings = mobileSettings;
    }

    public void setTabNavigation(MaterialTab tab) {
        registerHandler(tab.addSelectionHandler(e -> goToSlide(e.getSelectedItem())));
        registerHandler(addBeforeChangeHandler(e -> tab.setTabIndex(e.getNextSlide())));
    }

    public void setCarouselNavigation(MaterialCarousel navigation) {
        registerHandler(navigation.addAfterChangeHandler(event -> goToSlide(event.getCurrentSlide())));
        registerHandler(addBeforeChangeHandler(event -> navigation.goToSlide(event.getNextSlide())));
    }

    public MaterialPanel getWrapper() {
        return wrapper;
    }

    public MaterialPanel getContainer() {
        return container;
    }

    public MaterialButton getBtnNextArrow() {
        return nextArrow;
    }

    public MaterialButton getBtnPrevArrow() {
        return previousArrow;
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

    protected CssTypeMixin<CarouselType, MaterialCarousel> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin<>(this);
        }
        return typeMixin;
    }
}