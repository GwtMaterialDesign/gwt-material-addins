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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsCarouselOptions {

    @JsProperty
    public boolean accessibility;

    @JsProperty
    public boolean adaptiveHeight;

    @JsProperty
    public boolean autoplay;

    @JsProperty
    public int autoplaySpeed;

    @JsProperty
    public boolean arrows;

    @JsProperty
    public String asNavFor;

    @JsProperty
    public String appendArrows;

    @JsProperty
    public String appendDots;

    @JsProperty
    public String prevArrow;

    @JsProperty
    public String nextArrow;

    @JsProperty
    public boolean centerMode;

    @JsProperty
    public String centerPadding;

    @JsProperty
    public String cssEase;

    @JsProperty
    public boolean dots;

    @JsProperty
    public boolean draggable;

    @JsProperty
    public boolean fade;

    @JsProperty
    public boolean focusOnSelect;

    @JsProperty
    public String easing;

    @JsProperty
    public int edgeFriction;

    @JsProperty
    public boolean infinite;

    @JsProperty
    public boolean variableWidth;

    @JsProperty
    public int initialSlide;

    @JsProperty
    public String lazyLoad;

    @JsProperty
    public boolean mobileFirst;

    @JsProperty
    public boolean pauseOnFocus;

    @JsProperty
    public boolean pauseOnHover;

    @JsProperty
    public boolean pauseOnDotsHover;

    @JsProperty
    public int rows;

    @JsProperty
    public int slidesPerRow;

    @JsProperty
    public int slidesToShow;

    @JsProperty
    public int slidesToScroll;

    @JsProperty
    public int speed;

    @JsProperty
    public boolean swipe;

    @JsProperty
    public boolean swipeToSlide;

    @JsProperty
    public boolean touchMove;

    @JsProperty
    public int touchThreshold;

    @JsProperty
    public boolean vertical;

    @JsProperty
    public boolean verticalSwiping;

    @JsProperty
    public boolean rtl;

    @JsProperty
    public boolean waitForAnimate;
}
