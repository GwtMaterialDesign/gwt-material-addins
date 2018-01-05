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
package gwt.material.design.incubator.client.chart.amcharts.js.options;

import gwt.material.design.incubator.client.chart.amcharts.events.object.Listener;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Creates a cursor for the chart which follows the mouse movements. In case of
 * {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart} charts it shows the
 * balloons of hovered data points.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/ChartCursor">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmChartCursor {

    @JsProperty
    public int adjustment;

    @JsProperty
    public double animationDuration;

    @JsProperty
    public boolean avoidBalloonOverlapping;

    @JsProperty
    public String balloonPointerOrientation;

    @JsProperty
    public boolean bulletsEnabled;

    @JsProperty
    public int bulletSize;

    @JsProperty
    public double categoryBalloonAlpha;

    @JsProperty
    public String categoryBalloonColor;

    @JsProperty
    public String categoryBalloonDateFormat;

    @JsProperty
    public boolean categoryBalloonEnabled;

    @JsProperty
    public Functions.Func categoryBalloonFunction;

    @JsProperty
    public String categoryBalloonText;

    @JsProperty
    public String color;

    @JsProperty
    public int cursorAlpha;

    @JsProperty
    public String cursorColor;

    @JsProperty
    public String cursorPosition;

    @JsProperty
    public boolean enabled;

    @JsProperty
    public boolean fullWidth;

    @JsProperty
    public double graphBulletAlpha;

    @JsProperty
    public int graphBulletSize;

    @JsProperty
    public boolean leaveAfterTouch;

    @JsProperty
    public boolean leaveCursor;

    @JsProperty
    public String limitToGraph;

    @JsProperty
    public Listener[] listeners;

    @JsProperty
    public boolean oneBalloonOnly;

    @JsProperty
    public boolean pan;

    @JsProperty
    public double selectionAlpha;

    @JsProperty
    public boolean selectWithoutZooming;

    @JsProperty
    public boolean showNextAvailable;

    @JsProperty
    public int tabIndex;

    @JsProperty
    public boolean valueBalloonsEnabled;

    @JsProperty
    public double valueLineAlpha;

    @JsProperty
    public boolean valueLineBalloonEnabled;

    @JsProperty
    public boolean valueLineEnabled;

    @JsProperty
    public boolean valueZoomable;

    @JsProperty
    public boolean zoomable;

    @JsProperty
    public boolean zooming;

    /**
     * Adds event listener to the object.
     */
    @JsMethod
    public native void addListener(String type, Functions.Func handler);

    /**
     * This method can be used when selectWithoutZooming is set to true and you need to clear the selection made by user.
     */
    @JsMethod
    public native void clearSelection();

    /**
     * Hides cursor.
     */
    @JsMethod
    public native void hideCursor();

    /**
     * Removes event listener from the object.
     */
    @JsMethod
    public native void removeListener(String type, Functions.Func handler);

    /**
     * You can force cursor to appear at specified cateogry or date.
     */
    @JsMethod
    public native void showCursorAt(String category);

    /**
     * Allows to sync one serial chart’s cursor with another chart’s cursor.
     * <p>
     * Important! This method will work correctly only if plot area of both charts is identically equal in width.
     */
    @JsMethod
    public native void syncWithCursor(AmChartCursor chartCursor);

    // TODO Events
}
