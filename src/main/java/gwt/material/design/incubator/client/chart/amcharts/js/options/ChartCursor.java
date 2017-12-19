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

import gwt.material.design.incubator.client.chart.amcharts.base.constants.CursorPosition;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Orientation;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.*;

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
public class ChartCursor {

    @JsProperty
    private int adjustment;

    @JsProperty
    private double animationDuration;

    @JsProperty
    private boolean avoidBalloonOverlapping;

    @JsProperty
    private String balloonPointerOrientation;

    @JsProperty
    private boolean bulletsEnabled;

    @JsProperty
    private int bulletSize;

    @JsProperty
    private double categoryBalloonAlpha;

    @JsProperty
    private String categoryBalloonColor;

    @JsProperty
    private String categoryBalloonDateFormat;

    @JsProperty
    private boolean categoryBalloonEnabled;

    @JsProperty
    private Functions.Func categoryBalloonFunction;

    @JsProperty
    private String categoryBalloonText;

    @JsProperty
    private String color;

    @JsProperty
    private int cursorAlpha;

    @JsProperty
    private String cursorColor;

    @JsProperty
    private String cursorPosition;

    @JsProperty
    private boolean enabled;

    @JsProperty
    private boolean fullWidth;

    @JsProperty
    private double graphBulletAlpha;

    @JsProperty
    private int graphBulletSize;

    @JsProperty
    private boolean leaveAfterTouch;

    @JsProperty
    private boolean leaveCursor;

    @JsProperty
    private String limitToGraph;

    @JsProperty
    private Object[] listeners;

    @JsProperty
    private boolean oneBalloonOnly;

    @JsProperty
    private boolean pan;

    @JsProperty
    private double selectionAlpha;

    @JsProperty
    private boolean selectWithoutZooming;

    @JsProperty
    private boolean showNextAvailable;

    @JsProperty
    private int tabIndex;

    @JsProperty
    private boolean valueBalloonsEnabled;

    @JsProperty
    private double valueLineAlpha;

    @JsProperty
    private boolean valueLineBalloonEnabled;

    @JsProperty
    private boolean valueLineEnabled;

    @JsProperty
    private boolean valueZoomable;

    @JsProperty
    private boolean zoomable;

    @JsProperty
    private boolean zooming;

    /**
     * If you set adjustment to -1, the balloon will be shown near previous, if you set it to 1 - near next data point.
     * Default to 0
     */
    @JsOverlay
    public final void setAdjustment(int adjustment) {
        this.adjustment = adjustment;
    }

    /**
     * Duration of animation of a line, in seconds. Default to 0.3
     */
    @JsOverlay
    public final void setAnimationDuration(double animationDuration) {
        this.animationDuration = animationDuration;
    }

    /**
     * Specifies if cursor should arrange balloons so they won't overlap. If chart is rotated, it might be good idea to
     * turn this off. Default to true
     */
    @JsOverlay
    public final void setAvoidBalloonOverlapping(boolean avoidBalloonOverlapping) {
        this.avoidBalloonOverlapping = avoidBalloonOverlapping;
    }

    /**
     * Defines if the balloon should be shown above the datapoint or sideways. Default to
     * {@link gwt.material.design.incubator.client.chart.amcharts.base.constants.Orientation#HORIZONTAL}
     */
    @JsOverlay
    public final void setBalloonPointerOrientation(Orientation balloonPointerOrientation) {
        this.balloonPointerOrientation = balloonPointerOrientation.getName();
    }

    /**
     * Specifies if bullet for each graph will follow the cursor. Default to false
     */
    @JsOverlay
    public final void setBulletsEnabled(boolean bulletsEnabled) {
        this.bulletsEnabled = bulletsEnabled;
    }

    /**
     * Size of bullets, following the cursor. Default to 8
     */
    @JsOverlay
    public final void setBulletSize(int bulletSize) {
        this.bulletSize = bulletSize;
    }

    /**
     * Opacity of the category balloon. Default to 1
     */
    @JsOverlay
    public final void setCategoryBalloonAlpha(double categoryBalloonAlpha) {
        this.categoryBalloonAlpha = categoryBalloonAlpha;
    }

    /**
     * Color of the category balloon. cursorColor is used if not set.
     */
    @JsOverlay
    public final void setCategoryBalloonColor(String categoryBalloonColor) {
        this.categoryBalloonColor = categoryBalloonColor;
    }

    /**
     * Category balloon date format (used only if category axis parses dates). Check this page for instructions on how
     * to format dates.
     */
    @JsOverlay
    public final void setCategoryBalloonDateFormat(String categoryBalloonDateFormat) {
        this.categoryBalloonDateFormat = categoryBalloonDateFormat;
    }

    /**
     * Specifies whether category balloon is enabled. Default to true
     */
    @JsOverlay
    public final void setCategoryBalloonEnabled(boolean categoryBalloonEnabled) {
        this.categoryBalloonEnabled = categoryBalloonEnabled;
    }

    /**
     * Allows formatting any category balloon text you want. categoryBalloonFunction should return a string which will
     * be displayed in a balloon. When categoryBalloonFunction is called, category value (or date) is passed as an argument.
     */
    @JsOverlay
    public final void setCategoryBalloonFunction(Functions.Func categoryBalloonFunction) {
        this.categoryBalloonFunction = categoryBalloonFunction;
    }

    /**
     * You can have [[category]] - [[toCategory]] tags in there and show category ranges this way. Default to [[category]]
     */
    @JsOverlay
    public final void setCategoryBalloonText(String categoryBalloonText) {
        this.categoryBalloonText = categoryBalloonText;
    }

    /**
     * Text color. Default to #FFFFFF
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    /**
     * Opacity of the cursor line. Default to 1
     */
    @JsOverlay
    public final void setCursorAlpha(int cursorAlpha) {
        this.cursorAlpha = cursorAlpha;
    }

    /**
     * Color of the cursor line. Default to #CC000
     */
    @JsOverlay
    public final void setCursorColor(String cursorColor) {
        this.cursorColor = cursorColor;
    }

    /**
     * Specifies where the cursor line should be placed - on the beginning of the period (day, hour, etc) or in the
     * middle (only when parseDates property of categoryAxis is set to true). If you want the cursor to follow mouse
     * and not to glue to the nearest data point, set "mouse" here. Possible values are: start, middle, mouse. Default
     * to {@link CursorPosition#MIDDLE}
     */
    @JsOverlay
    public final void setCursorPosition(CursorPosition cursorPosition) {
        this.cursorPosition = cursorPosition.getName();
    }

    /**
     * Specifies whether cursor is enabled. Default true
     */
    @JsOverlay
    public final void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * If set to true, instead of a cursor line user will see a fill which width will always be equal to the width of
     * one data item. We'd recommend setting cursorAlpha to 0.1 or some other small number if using this feature.
     * Default to false.
     */
    @JsOverlay
    public final void setFullWidth(boolean fullWidth) {
        this.fullWidth = fullWidth;
    }

    /**
     * If you make graph's bullets invisible by setting their opacity to 0 and will set graphBulletAlpha to 1, the
     * bullets will only appear at the cursor's position.
     */
    @JsOverlay
    public final void setGraphBulletAlpha(double graphBulletAlpha) {
        this.graphBulletAlpha = graphBulletAlpha;
    }

    /**
     * Size of a graph's bullet (if available) at the cursor position. If you don't want the bullet to change it's size,
     * set this property to 1. Default to 1.7
     */
    @JsOverlay
    public final void setGraphBulletSize(int graphBulletSize) {
        this.graphBulletSize = graphBulletSize;
    }

    /**
     * This makes cursor and balloons to remain after user touches the chart. Default to true
     */
    @JsOverlay
    public final void setLeaveAfterTouch(boolean leaveAfterTouch) {
        this.leaveAfterTouch = leaveAfterTouch;
    }

    /**
     * Specifies if cursor should be left at it's last position. Useful for touch devices - user might want to see the
     * balloons after he moves finger away. Default to false
     */
    @JsOverlay
    public final void setLeaveCursor(boolean leaveCursor) {
        this.leaveCursor = leaveCursor;
    }

    /**
     * If set to an id or a reference to AmGraph object, CategoryAxis cursor line will be limited to this graph instead
     * of being drawn through full height of plot area. Note, this works with serial chart only. Also, cursorPosition of
     * ChartCursor must be set to middle.
     */
    @JsOverlay
    public final void setLimitToGraph(String limitToGraph) {
        this.limitToGraph = limitToGraph;
    }

    /**
     * You can add listeners of events using this property. Example: listeners =
     * [{"event":"changed", "method":handleEvent}];
     */
    @JsOverlay
    public final void setListeners(Object[] listeners) {
        this.listeners = listeners;
    }

    /**
     * If this is set to true, only one balloon at a time will be displayed. Note, this is quite CPU consuming. Default
     * to false
     */
    @JsOverlay
    public final void setOneBalloonOnly(boolean oneBalloonOnly) {
        this.oneBalloonOnly = oneBalloonOnly;
    }

    /**
     * If this is set to true, the user will be able to pan the chart instead of zooming. Default to false
     */
    @JsOverlay
    public final void setPan(boolean pan) {
        this.pan = pan;
    }

    /**
     * Opacity of the selection. Default to 0.2
     */
    @JsOverlay
    public final void setSelectionAlpha(double selectionAlpha) {
        this.selectionAlpha = selectionAlpha;
    }

    /**
     * Specifies if cursor should only mark selected area but not zoom-in after user releases mouse button. Default
     * to false
     */
    @JsOverlay
    public final void setSelectWithoutZooming(boolean selectWithoutZooming) {
        this.selectWithoutZooming = selectWithoutZooming;
    }

    /**
     * If true, the graph will display balloon on next available data point if currently hovered item doesn't have value
     * for this graph. Default to false
     */
    @JsOverlay
    public final void setShowNextAvailable(boolean showNextAvailable) {
        this.showNextAvailable = showNextAvailable;
    }

    /**
     * In case you set it to some number, the chart will set focus on chart cursor (works only with serial chart) when
     * user clicks tab key. When a focus is set user can move cursor using cursor keys. Note, not all browsers and
     * readers support this.
     */
    @JsOverlay
    public final void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    /**
     * Specifies whether value balloons are enabled. In case they are not, the balloons might be displayed anyway, when
     * the user rolls-over the column or bullet. Default to true
     */
    @JsOverlay
    public final void setValueBalloonsEnabled(boolean valueBalloonsEnabled) {
        this.valueBalloonsEnabled = valueBalloonsEnabled;
    }

    /**
     * Opacity of value line. Will use cursorAlpha value if not set. Default to false
     */
    @JsOverlay
    public final void setValueLineAlpha(double valueLineAlpha) {
        this.valueLineAlpha = valueLineAlpha;
    }

    /**
     * Specifies if value balloon next to value axes labels should be displayed. Default tot false
     */
    @JsOverlay
    public final void setValueLineBalloonEnabled(boolean valueLineBalloonEnabled) {
        this.valueLineBalloonEnabled = valueLineBalloonEnabled;
    }

    /**
     * Specifies if cursor of Serial chart should display horizontal (or vertical if chart is rotated) line.
     * This line might help users to compare distant values of a chart. You can also enable value balloons on
     * this line by setting valueLineBalloonEnabled to true. Default to false
     */
    @JsOverlay
    public final void setValueLineEnabled(boolean valueLineEnabled) {
        this.valueLineEnabled = valueLineEnabled;
    }

    /**
     * Specifies if the user can zoom-in value axess of a serial chart. Default to false
     */
    @JsOverlay
    public final void setValueZoomable(boolean valueZoomable) {
        this.valueZoomable = valueZoomable;
    }

    /**
     * Specifies if the user can zoom-in the chart. If pan is set to true, zoomable is switched to false automatically.
     * Default to true
     */
    @JsOverlay
    public final void setZoomable(boolean zoomable) {
        this.zoomable = zoomable;
    }

    /**
     * Read-only. Indicates if currently user is selecting some chart area to zoom-in.
     */
    @JsOverlay
    public final void setZooming(boolean zooming) {
        this.zooming = zooming;
    }

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
    public native void syncWithCursor(ChartCursor chartCursor);

    // TODO Events
}
