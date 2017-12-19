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

import gwt.material.design.incubator.client.chart.amcharts.base.constants.GridPosition;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Period;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.TickPosition;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.*;

import java.util.Date;

//@formatter:off

/**
 * Extension for {@link AxisBase}, gets automatically populated if none has been specified.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/CategoryAxis">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class CategoryAxis extends AxisBase {

    @JsProperty
    private String autoWrap;

    @JsProperty
    private Functions.Func categoryFunction;

    @JsProperty
    private String classNameField;

    @JsProperty
    private boolean equalSpacing;

    @JsProperty
    private String forceShowField;

    @JsProperty
    private String gridPosition;

    @JsProperty
    private String labelColorField;

    @JsProperty
    Functions.Func labelFunction;

    @JsProperty
    private String minPeriod;

    @JsProperty
    private boolean parseDates;

    @JsProperty
    private boolean startOnAxis;

    @JsProperty
    private String tickPosition;

    @JsProperty
    private boolean twoLineMode;

    @JsProperty
    private String widthField;

    /**
     * Angle of label rotation, if the number of series exceeds autoRotateCount and parseDates is set to false.
     */
    @JsOverlay
    public final void setAutoWrap(String autoWrap) {
        this.autoWrap = autoWrap;
    }

    /**
     * Specifies a method that returns the value that should be used as categoryValue for current item. If this property
     * is set, the return value of the custom data function takes precedence over categoryField. When a chart calls this
     * method, it passes category value, data item from chart's data provider and reference to categoryAxis:
     * categoryFunction(category, dataItem, categoryAxis); This method can be used both when category axis parses dates
     * and when it doesn't. If axis parses dates, your categoryFunction should return Date object. For example, if you
     * have date strings in your data, you can use this method to convert these strings into Date objects.
     */
    @JsOverlay
    public final void setCategoryFunction(Functions.Func categoryFunction) {
        this.categoryFunction = categoryFunction;
    }

    /**
     * If this field is set and addClassNames is enabled, the category axis labels, ticks and grid will have this class
     * name set.
     * <p>
     * NOTE: this will not work if the axis is date-based.
     */
    @JsOverlay
    public final void setClassNameField(String classNameField) {
        this.classNameField = classNameField;
    }

    /**
     * In case your category axis values are Date objects and parseDates is set to true, the chart will parse dates and
     * will place your data points at irregular intervals. However if you want dates to be parsed (displayed on the axis,
     * baloons, etc), but data points to be placed at equal intervals (omiting dates with no data), set equalSpacing
     * to true. Default to false
     */
    @JsOverlay
    public final void setEqualSpacing(boolean equalSpacing) {
        this.equalSpacing = equalSpacing;
    }

    /**
     * Field in data provider which specifies if the category value should always be shown. For example:
     * categoryAxis.forceShowField = "forceShow";
     * <p>
     * And in data:
     * <p>
     * {category:"one", forceShow:true, value:100}
     * <p>
     * Note, this works only when parseDates is set to false.
     */
    @JsOverlay
    public final void setForceShowField(String forceShowField) {
        this.forceShowField = forceShowField;
    }

    /**
     * Specifies if a grid line is placed on the center of a cell or on the beginning of a cell. Possible values are:
     * "start" and "middle" This setting doesn't work if parseDates is set to true. Default to {@link GridPosition#MIDDLE}
     */
    @JsOverlay
    public final void setGridPosition(GridPosition gridPosition) {
        this.gridPosition = gridPosition.getName();
    }

    /**
     * You can use it to set color of a axis label. Works only with non-date-based data.
     */
    @JsOverlay
    public final void setLabelColorField(String labelColorField) {
        this.labelColorField = labelColorField;
    }

    /**
     * You can use this function to format Category axis labels. If this function is set, then it is called with the
     * following parameters passed:
     * <p>
     * if dates are not parsed:
     * labelFunction(valueText, serialDataItem, categoryAxis)
     * <p>
     * if dates are parsed:
     * labelFunction(valueText, date, categoryAxis)
     * <p>
     * Your function should return string which will be displayed on the axis.
     */
    @JsOverlay
    public final void setLabelFunction(Functions.Func labelFunction) {
        this.labelFunction = labelFunction;
    }

    /**
     * Specifies the shortest period of your data. This should be set only if parseDates is set to "true". Possible
     * period values: fff - milliseconds, ss - seconds, mm - minutes, hh - hours, DD - days, MM - months, YYYY - years.
     * <p>
     * It's also possible to supply a number for increments, i.e. "15mm" which will instruct the chart that your data is
     * supplied in 15 minute increments.
     *
     * @param minPeriod
     */
    @JsOverlay
    public final void setMinPeriod(Period minPeriod) {
        this.minPeriod = minPeriod.getValue();
    }

    /**
     * In case your category axis values are Date objects, set this to true. In this case the chart will parse dates and
     * will place your data points at irregular intervals. If you want dates to be parsed, but data points to be placed
     * at equal intervals, set both parseDates and equalSpacing to true.
     * <p>
     * Note: we recommend using JavaScript timestamps to specify date/time. If you are specifying dates as strings in your
     * data, i.e. "2015-01-05", we strongly recommend setting dataDateFormat as well.
     * <p>
     * Important: If this is set to `true`, the data points needs to come pre-ordered in ascending order. Data with
     * incorrect order might result in visual and functional glitches on the chart.
     */
    @JsOverlay
    public final void setParseDates(boolean parseDates) {
        this.parseDates = parseDates;
    }

    /**
     * Specifies whether the graph should start on axis or not. In case you display columns, it is recommended to set
     * this to false. If parseDates is set to true, startOnAxis will allways be false, unless equalSpacing is set to true.
     * Default to false
     */
    @JsOverlay
    public final void setStartOnAxis(boolean startOnAxis) {
        this.startOnAxis = startOnAxis;
    }

    /**
     * Position of a axis tick. Available settings: middle, start. Works only with non-date-based data. Default to
     * {@link TickPosition#MIDDLE}
     */
    @JsOverlay
    public final void setTickPosition(TickPosition tickPosition) {
        this.tickPosition = tickPosition.getName();
    }

    /**
     * Works only when parseDates is set to true and equalSpacing is false. If you set it to true, at the position where
     * bigger period changes, category axis will display date strings of bot small and big period, in two rows. Default
     * to false
     */
    @JsOverlay
    public final void setTwoLineMode(boolean twoLineMode) {
        this.twoLineMode = twoLineMode;
    }

    /**
     * You can specify relative width for your columns using this field and produce Mekko chart using this new feature.
     */
    @JsOverlay
    public final void setWidthField(String widthField) {
        this.widthField = widthField;
    }

    /**
     * Returns coordinate of a category. Works only if parseDates is false. If parseDates is true, use dateToCoordinate method.
     */
    @JsMethod
    public native int categoryToCoordinate(String category);

    /**
     * Returns Date of the coordinate, in case parseDates is set to true and equalSpacing is set to false.
     */
    @JsMethod
    public native Date coordinateToDate(int coordinate);

    /**
     * Returns coordinate of the date, in case parseDates is set to true. if parseDates is false, use
     * categoryToCoordinate method.
     */
    @JsMethod
    public native int dateToCoordinate(Date date);

    /**
     * Returns index of the category which is most close to specified coordinate.
     */
    @JsMethod
    public native int xToIndex(int x);
}
