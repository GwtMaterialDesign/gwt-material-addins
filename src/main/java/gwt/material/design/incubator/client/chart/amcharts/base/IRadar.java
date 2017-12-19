package gwt.material.design.incubator.client.chart.amcharts.base;

public interface IRadar {

    /**
     * Field in your data provider containing categories.
     */
    void setCategoryField(String categoryField);

    /**
     * Bottom margin of the chart. Default to 0
     */
    void setMarginBottom(int marginBottom);

    /**
     * Left margin of the chart. Default to 0
     */
    void setMarginLeft(int marginLeft);

    /**
     * Right margin of the chart. Default to 0
     */
    void setMarginRight(int marginRight);

    /**
     * Top margin of the chart. Default to 0
     */
    void setMarginTop(int marginTop);

    /**
     * Radius of a radar. Default to 35%
     */
    void setRadius(Object radius);
}
