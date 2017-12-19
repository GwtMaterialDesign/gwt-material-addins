package gwt.material.design.incubator.client.chart.amcharts.base;

public interface IXyChart {

    /**
     * In case you have date-based value axis in your XY chart, you can specify your corresponding values as strings.
     * In that case you will need to set this setting to whatever format your are using for date/time.
     * <p>
     * <p>
     * Check this page for available formats.
     * <p>
     * Please note that two-digit years (YY) as well as literal month names (MMM) are NOT supported in this setting.
     */
    void setDataDateFormat(String dataDateFormat);

    /**
     * Specifies if Scrollbar of X axis (horizontal) should be hidden. Default to false
     */
    void setHideXScrollbar(boolean hideXScrollbar);

    /**
     * Specifies if Scrollbar of Y axis (vertical) should be hidden. Default false
     */
    void setHideYScrollbar(boolean hideYScrollbar);

    /**
     * These can be used to adjust size/scale of bubbles. If these properties are not set, the bubble with smallest
     * value will be of minBulletSize and bubble with biggest value will be of maxBulletSize. However, you might want
     * bubble size to change relative to 0 or some other value. In this case you can use minValue and maxValue properties.
     * Note, if you use these two settings, you might also want to set minBulletSize to 0.
     */
    void setMaxValue(int maxValue);

    /**
     * Maximum zoom factor of the chart. Default to 20
     */
    void setMaxZoomFactor(int maxZoomFactor);

    /**
     * These can be used to adjust size/scale of bubbles. If these properties are not set, the bubble with smallest
     * value will be of minBulletSize and bubble with biggest value will be of maxBulletSize. However, you might want
     * bubble size to change relative to 0 or some other value. In this case you can use minValue and maxValue properties.
     * Note, if you use these two settings, you might also want to set minBulletSize to 0.
     */
    void setMinValue(int minValue);

    /**
     * Zooms out, charts shows all available data.
     */
    void zoomOut();
}
