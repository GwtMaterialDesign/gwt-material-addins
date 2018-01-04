package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.GridPosition;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Period;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.TickPosition;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmAxisBase;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmCategoryAxis;
import gwt.material.design.jquery.client.api.Functions;

public class CategoryAxis extends AxisBase {

    private AmCategoryAxis categoryAxis = new AmCategoryAxis();

    @Override
    protected AmAxisBase getAxis() {
        return categoryAxis;
    }

    @Override
    public void load() {
        super.load();
    }

    @Override
    public void unload() {

    }

    public String getAutoWrap() {
        return categoryAxis.autoWrap;
    }

    /**
     * Angle of label rotation, if the number of series exceeds autoRotateCount and parseDates is set to false.
     */

    public void setAutoWrap(String autoWrap) {
        categoryAxis.autoWrap = autoWrap;
    }

    public Functions.Func getCategoryFunction() {
        return categoryAxis.categoryFunction;
    }

    /**
     * Specifies a method that returns the value that should be used as categoryValue for current item. If this property
     * is set, the return categoryAxis.value of the custom data function takes precedence over categoryField. When a chart calls this
     * method, it passes category value, data item from chart's data provider and reference to categoryAxis:
     * categoryFunction(category, dataItem, categoryAxis); This method can be used both when category axis parses dates
     * and when it doesn't. If axis parses dates, your categoryFunction should return categoryAxis.Date object. For example, if you
     * have date strings in your data, you can use this method to convert these strings into Date objects.
     */

    public void setCategoryFunction(Functions.Func categoryFunction) {
        categoryAxis.categoryFunction = categoryFunction;
    }

    public String getClassNameField() {
        return categoryAxis.classNameField;
    }

    /**
     * If this field is set and addClassNames is enabled, the category axis labels, ticks and grid will have this class
     * name set.
     * <p>
     * NOTE: this will not work if the axis is date-based.
     */

    public void setClassNameField(String classNameField) {
        categoryAxis.classNameField = classNameField;
    }

    public boolean isEqualSpacing() {
        return categoryAxis.equalSpacing;
    }

    /**
     * In case your category axis values are Date objects and parseDates is set to true, the chart will parse dates and
     * will place your data points at irregular intervals. However if you want dates to be parsed (displayed on the axis,
     * baloons, etc), but data points to be placed at equal intervals (omiting dates with no data), set equalSpacing
     * to true. Default to false
     */

    public void setEqualSpacing(boolean equalSpacing) {
        categoryAxis.equalSpacing = equalSpacing;
    }

    public String getForceShowField() {
        return categoryAxis.forceShowField;
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

    public void setForceShowField(String forceShowField) {
        categoryAxis.forceShowField = forceShowField;
    }

    public String getGridPosition() {
        return categoryAxis.gridPosition;
    }

    /**
     * Specifies if a grid line is placed on the center of a cell or on the beginning of a cell. Possible values are:
     * "start" and "middle" This setting doesn't work if parseDates is set to true. Default to {@link GridPosition#MIDDLE}
     */

    public void setGridPosition(GridPosition gridPosition) {
        categoryAxis.gridPosition = gridPosition.getName();
    }

    public String getLabelColorField() {
        return categoryAxis.labelColorField;
    }

    /**
     * You can use it to set color of a axis label. Works only with non-date-based data.
     */

    public void setLabelColorField(String labelColorField) {
        categoryAxis.labelColorField = labelColorField;
    }

    public Functions.Func getLabelFunction() {
        return categoryAxis.labelFunction;
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
     * Your function should return categoryAxis.string which will be displayed on the axis.
     */

    public void setLabelFunction(Functions.Func labelFunction) {
        categoryAxis.labelFunction = labelFunction;
    }

    public String getMinPeriod() {
        return categoryAxis.minPeriod;
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

    public void setMinPeriod(Period minPeriod) {
        categoryAxis.minPeriod = minPeriod.getValue();
    }

    public boolean isParseDates() {
        return categoryAxis.parseDates;
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

    public void setParseDates(boolean parseDates) {
        categoryAxis.parseDates = parseDates;
    }

    public boolean isStartOnAxis() {
        return categoryAxis.startOnAxis;
    }

    /**
     * Specifies whether the graph should start on axis or not. In case you display columns, it is recommended to set
     * this to false. If parseDates is set to true, startOnAxis will allways be false, unless equalSpacing is set to true.
     * Default to false
     */

    public void setStartOnAxis(boolean startOnAxis) {
        categoryAxis.startOnAxis = startOnAxis;
    }

    public String getTickPosition() {
        return categoryAxis.tickPosition;
    }

    /**
     * Position of a axis tick. Available settings: middle, start. Works only with non-date-based data. Default to
     * {@link TickPosition#MIDDLE}
     */

    public void setTickPosition(TickPosition tickPosition) {
        categoryAxis.tickPosition = tickPosition.getName();
    }

    public boolean isTwoLineMode() {
        return categoryAxis.twoLineMode;
    }

    /**
     * Works only when parseDates is set to true and equalSpacing is false. If you set it to true, at the position where
     * bigger period changes, category axis will display date strings of bot small and big period, in two rows. Default
     * to false
     */

    public void setTwoLineMode(boolean twoLineMode) {
        categoryAxis.twoLineMode = twoLineMode;
    }

    public String getWidthField() {
        return categoryAxis.widthField;
    }

    /**
     * You can specify relative width for your columns using this field and produce Mekko chart using this new feature.
     */

    public void setWidthField(String widthField) {
        categoryAxis.widthField = widthField;
    }

    public AmCategoryAxis getCategoryAxis() {
        return categoryAxis;
    }
}
