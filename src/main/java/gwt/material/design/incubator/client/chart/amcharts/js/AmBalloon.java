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
package gwt.material.design.incubator.client.chart.amcharts.js;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Creates the balloons ( tooltips ) of the chart, It follows the mouse cursor when you roll-over the data items.
 * The framework generates the instances automatically you only need to adjust the appearance to your needs.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmBalloon">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmBalloon {

    @JsProperty
    public boolean adjustBorderColor;

    @JsProperty
    public double animationDuration;

    @JsProperty
    public double borderAlpha;

    @JsProperty
    public String borderColor;

    @JsProperty
    public int borderThickness;

    @JsProperty
    public String color;

    @JsProperty
    public int cornerRadius;

    @JsProperty
    public boolean disableMouseEvents;

    @JsProperty
    public boolean drop;

    @JsProperty
    public boolean enabled;

    @JsProperty
    public double fadeOutDuration;

    @JsProperty
    public double fillAlpha;

    @JsProperty
    public String fillColor;

    @JsProperty
    public boolean fixedPosition;

    @JsProperty
    public int fontSize;

    @JsProperty
    public int horizontalPadding;

    @JsProperty
    public int maxWidth;

    @JsProperty
    public int offsetX;

    @JsProperty
    public int offsetY;

    @JsProperty
    public String pointerOrientation;

    @JsProperty
    public int pointerWidth;

    @JsProperty
    public double shadowAlpha;

    @JsProperty
    public String shadowColor;

    @JsProperty
    public boolean showBullet;

    @JsProperty
    public String textAlign;

    @JsProperty
    public int verticalPadding;

    /**
     * Hides balloon.
     */
    @JsMethod
    public native void hide();

    /**
     * Defines a square within which the balloon should appear. Bounds are set by chart class, you don't need to
     * call this method yourself.
     */
    @JsMethod
    public native void setBounds(int left, int top, int right, int bottom);

    /**
     * Sets coordinates the balloon should point to.
     */
    @JsMethod
    public native void setPosition(int x, int y);
}
