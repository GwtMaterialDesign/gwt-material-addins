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
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.carousel.constants.CarouselType;
import gwt.material.design.addins.client.carousel.constants.RespondTo;
import gwt.material.design.addins.client.carousel.events.*;
import gwt.material.design.addins.client.carousel.js.JsCarouselOptions;
import gwt.material.design.addins.client.carousel.ui.NextArrow;
import gwt.material.design.addins.client.carousel.ui.PreviousArrow;
import gwt.material.design.addins.client.dark.AddinsDarkThemeReloader;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTab;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.List;

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
 * @see <a href="https://github.com/kenwheeler/slick">SlickJs 1.6.0</a>
 */
//@formatter:on
public class MaterialCarousel extends MaterialWidget implements JsLoader, HasType<CarouselType>, HasCarouselEvents, HasValue<List<String>> {

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


    private JsCarouselOptions options = JsCarouselOptions.create();

    private CssTypeMixin<CarouselType, MaterialCarousel> typeMixin;
    private List<String> values;

    public MaterialCarousel() {
        super(Document.get().createDivElement(), AddinsCssName.MATERIAL_CAROUSEL);
    }

    private final ToggleStyleMixin<MaterialCarousel> fsMixin = new ToggleStyleMixin<>(this, CssName.FULLSCREEN);

    @Override
    protected void onLoad() {
        super.onLoad();

        container.setId(DOM.createUniqueId());
        wrapper.setStyleName(AddinsCssName.MATERIAL_CAROUSEL_CONTAINER);
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

        $(getElement()).on(CarouselEvents.EDGE, (e, direction) -> {
            EdgeEvent.fire(this, direction);
            return true;
        });

        $(getElement()).on(CarouselEvents.LAZY_LOAD_ERROR, (e, image, imageSource) -> {
            LazyLoadedErrorEvent.fire(this, image, imageSource);
            return true;
        });

        $(getElement()).on(CarouselEvents.LAZY_LOADED, (e, image, imageSource) -> {
            LazyLoadedEvent.fire(this, image, imageSource);
            return true;
        });

        $(getElement()).on(CarouselEvents.RE_INIT, (e) -> {
            ReInitEvent.fire(this);
            return true;
        });

        $(getElement()).on(CarouselEvents.SET_POSITION, (e) -> {
            SetPositionEvent.fire(this);
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
        if (nextArrow != null) {
            options.nextArrow = "#" + nextArrow.getId();
        }

        if (previousArrow != null) {
            options.prevArrow = "#" + previousArrow.getId();
        }

        $(container.getElement()).slick(options);
        AddinsDarkThemeReloader.get().reload(MaterialCarouselDarkTheme.class);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        JQueryElement element = $(getElement());
        element.off(CarouselEvents.AFTER_CHANGE);
        element.off(CarouselEvents.BEFORE_CHANGE);
        element.off(CarouselEvents.INIT);
        element.off(CarouselEvents.DESTROY);
        element.off(CarouselEvents.EDGE);
        element.off(CarouselEvents.LAZY_LOAD_ERROR);
        element.off(CarouselEvents.LAZY_LOADED);
        element.off(CarouselEvents.RE_INIT);
        element.off(CarouselEvents.SET_POSITION);
        element.off(CarouselEvents.SWIPE);

        destroy();
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    public void destroy() {
        command("unslick");
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

    /**
     * Filters slides using jQuery .filter syntax
     */
    public void filter(String selector) {
        command("slickFilter", selector);
    }

    /**
     * Removes applied filter
     */
    public void unFilter() {
        command("slickUnfilter");
    }

    protected Object command(String action, Object... params) {
        if (container == null) {
            GWT.log("Your carousel container is not yet initialized", new IllegalStateException());
        } else {
            return $("\\#" + container.getId()).slick(action, params);
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
        return options.dots;
    }

    /**
     * Show dots indicators (Default : true)
     */
    public void setShowDots(boolean showDots) {
        options.dots = showDots;
    }

    public boolean isShowArrows() {
        return options.arrows;
    }

    /**
     * Show Prev/Next Arrows (Default : true)
     */
    public void setShowArrows(boolean showArrows) {
        options.arrows = showArrows;
        getBtnPrevArrow().setVisible(showArrows);
        getBtnNextArrow().setVisible(showArrows);
    }

    public int getSlidesToShow() {
        return options.slidesToShow;
    }

    /**
     * Number of Slides to show (Default : 1)
     */
    public void setSlidesToShow(int slidesToShow) {
        options.slidesToShow = slidesToShow;
    }

    public int getSlidesToScroll() {
        return options.slidesToScroll;
    }

    /**
     * Number of Slides to Scroll (Default : 1)
     */
    public void setSlidesToScroll(int slidesToScroll) {
        options.slidesToScroll = slidesToScroll;
    }

    public boolean isInfinite() {
        return options.infinite;
    }

    /**
     * Provides Infinite loop sliding (Default : true)
     */
    public void setInfinite(boolean infinite) {
        options.infinite = infinite;
    }

    public boolean isCenterMode() {
        return options.centerMode;
    }

    /**
     * Enables centered view with partial prev/next slides. Use with odd numbered slidesToShow counts. (Default : false)
     */
    public void setCenterMode(boolean centerMode) {
        options.centerMode = centerMode;
    }

    public boolean isVariableWidth() {
        return options.variableWidth;
    }

    /**
     * Allow any Variable width slides (Default : false)
     */
    public void setVariableWidth(boolean variableWidth) {
        options.variableWidth = variableWidth;
    }

    public boolean isAdaptiveHeight() {
        return options.adaptiveHeight;
    }

    /**
     * Enables adaptive height for single slide horizontal carousels. (Default : false)
     */
    public void setAdaptiveHeight(boolean adaptiveHeight) {
        options.adaptiveHeight = adaptiveHeight;
    }

    public int getSpeed() {
        return options.speed;
    }

    /**
     * Slide/Fade animation speed in milliseconds (Default : 300ms)
     */
    public void setSpeed(int speed) {
        options.speed = speed;
    }

    public String getCenterPadding() {
        return options.centerPadding;
    }

    /**
     * Side padding when in center mode (px or %) (Default : 50px)
     */
    public void setCenterPadding(String centerPadding) {
        options.centerPadding = centerPadding;
    }

    public boolean isAutoplay() {
        return options.autoplay;
    }

    /**
     * Enables Autoplay (Default : false)
     */
    public void setAutoplay(boolean autoplay) {
        options.autoplay = autoplay;
    }

    public int getAutoplaySpeed() {
        return options.autoplaySpeed;
    }

    /**
     * Autoplay Speed in milliseconds (Default : 3000 ms or 3 seconds)
     */
    public void setAutoplaySpeed(int autoplaySpeed) {
        options.autoplaySpeed = autoplaySpeed;
    }

    public double getEdgeFriction() {
        return options.edgeFriction;
    }

    /**
     * Resistance when swiping edges of non-infinite carousels
     */
    public void setEdgeFriction(double edgeFriction) {
        options.edgeFriction = edgeFriction;
    }

    public boolean isFade() {
        return options.fade;
    }

    /**
     * Enable Fade Transition
     */
    public void setFade(boolean fade) {
        options.fade = fade;
    }

    public boolean isFocusOnSelect() {
        return options.focusOnSelect;
    }

    /**
     * Enable focus on selected element (click)
     */
    public void setFocusOnSelect(boolean focusOnSelect) {
        options.focusOnSelect = focusOnSelect;
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
        return options.responsive[TABLET_SETTINGS].settings;
    }

    public void setTabletSettings(JsCarouselOptions tabletSettings) {
        options.responsive[TABLET_SETTINGS].settings = tabletSettings;
    }

    public JsCarouselOptions getMobileSettings() {
        return options.responsive[MOBILE_SETTINGS].settings;
    }

    public void setMobileSettings(JsCarouselOptions mobileSettings) {
        options.responsive[MOBILE_SETTINGS].settings = mobileSettings;
    }

    public void setTabNavigation(MaterialTab tab) {
        registerHandler(tab.addSelectionHandler(e -> goToSlide(e.getSelectedItem())));
        registerHandler(addBeforeChangeHandler(e -> tab.setTabIndex(e.getNextSlide())));
    }

    public void setCarouselNavigation(MaterialCarousel navigation) {
        registerHandler(navigation.addAfterChangeHandler(event -> goToSlide(event.getCurrentSlide())));
        registerHandler(addBeforeChangeHandler(event -> navigation.goToSlide(event.getNextSlide())));
    }

    public Functions.Func getCustomPaging() {
        return options.customPaging;
    }

    /**
     * Custom paging templates. See source for use example.
     */
    public void setCustomPaging(Functions.Func customPaging) {
        this.options.customPaging = customPaging;
    }

    public String getDotsClass() {
        return options.dotsClass;
    }

    /**
     * Class for slide indicator dots container
     */
    public void setDotsClass(String dotsClass) {
        this.options.dotsClass = dotsClass;
    }

    public boolean isFocusOnChange() {
        return options.focusOnChange;
    }

    /**
     * Puts focus on slide after change
     */
    public void setFocusOnChange(boolean focusOnChange) {
        this.options.focusOnChange = focusOnChange;
    }

    public String getRespondTo() {
        return options.respondTo;
    }

    /**
     * Width that responsive object responds to. Can be 'window', 'slider' or 'min' (the smaller of the two).
     *
     * @see gwt.material.design.addins.client.carousel.constants.RespondTo
     */
    public void setRespondTo(RespondTo respondTo) {
        this.options.respondTo = respondTo.getName();
    }

    public String getSlide() {
        return options.slide;
    }

    /**
     * Slide element query
     */
    public void setSlide(String slide) {
        this.options.slide = slide;
    }

    public boolean isUseCSS() {
        return options.useCSS;
    }

    /**
     * Enable/Disable CSS Transitions
     */
    public void setUseCSS(boolean useCSS) {
        this.options.useCSS = useCSS;
    }

    public boolean isUseTransform() {
        return options.useTransform;
    }

    /**
     * Enable/Disable CSS Transforms
     */
    public void setUseTransform(boolean useTransform) {
        this.options.useTransform = useTransform;
    }

    public int getZIndex() {
        return options.zIndex;
    }

    /**
     * Set the zIndex values for slides, useful for IE9 and lower
     */
    public void setZIndex(int zIndex) {
        this.options.zIndex = zIndex;
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
    public HandlerRegistration addEdgeHandler(EdgeEvent.EdgeHandler handler) {
        return addHandler(handler, EdgeEvent.getType());
    }

    @Override
    public HandlerRegistration addLazyLoadedErrorHandler(LazyLoadedErrorEvent.LazyLoadedErrorHandler handler) {
        return addHandler(handler, LazyLoadedErrorEvent.getType());
    }

    @Override
    public HandlerRegistration addLazyLoadedHandler(LazyLoadedEvent.LazyLoadedHandler handler) {
        return addHandler(handler, LazyLoadedEvent.getType());
    }

    @Override
    public HandlerRegistration addReInitHandler(ReInitEvent.ReInitHandler handler) {
        return addHandler(handler, ReInitEvent.getType());
    }

    @Override
    public HandlerRegistration addSetPositionHandler(SetPositionEvent.SetPositionHandler handler) {
        return addHandler(handler, SetPositionEvent.getType());
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

    @Override
    public List<String> getValue() {
        return values;
    }

    @Override
    public void setValue(List<String> values) {
        setValue(values, false);
    }

    @Override
    public void setValue(List<String> values, boolean fireEvent) {
        this.values = values;

        container.clear();
        for (String value : values) {
            MaterialImage image = new MaterialImage(value);
            container.add(image);

            if (isAttached()) {
                reload();
            }
        }

        if (fireEvent) {
            ValueChangeEvent.fire(this, values);
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<List<String>> valueChangeHandler) {
        return addHandler(valueChangeHandler, ValueChangeEvent.getType());
    }
}
