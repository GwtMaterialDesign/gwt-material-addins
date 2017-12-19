package gwt.material.design.incubator.client.chart.amcharts.base;

public interface IFunnelChart {

    /**
     * The angle of the 3D part of the chart. This creates a 3D effect (if the "depth3D" is > 0). Default to 0
     */
    void setAngle(int angle);

    /**
     * Balloon text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider. HTML tags can also be used. Default to "[[title]]: [[value]]\n[[description]]"
     */
    void setBalloonText(String balloonText);

    /**
     * Width of a base (first slice) of a chart. "100%" means it will occupy all available space.
     */
    void setBaseWidth(int baseWidth);

    /**
     * The depth of funnel/pyramid. Set angle to >0 value in order this to work. Note, neckHeight/neckWidth will
     * become 0 if you set these properties to bigger than 0 values. Default to 0
     */
    void setDepth3D(int depth3D);

    /**
     * Specifies where labels should be placed. Allowed values are left / center / right. If you set left or right,
     * you should increase left or right margin in order labels to be visible. Default to "center"
     */
    void setLabelPosition(String labelPosition);

    /**
     * Label text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider.
     */
    void setLabelText(String labelText);

    /**
     * Height of a funnel neck. If default value, zero is used, the funnel won't have neck at all, which will make it
     * look like pyramid.
     */
    void setNeckHeight(int neckHeight);

    /**
     * Width of a funnel neck. If default value, zero is used, the funnel won't have neck at all, which will make it
     * look like pyramid.
     */
    void setNeckWidth(int neckWidth);

    /**
     * Specifies the distance by which slice should be pulled when user clicks on it.
     */
    void setPullDistance(int pullDistance);

    /**
     * If rotate is set to true, the funnel will be rotated and will became a pyramid.
     */
    void setRotate(boolean rotate);

    /**
     * Initial x coordinate of slices. They will animate to the final x position from this one.
     */
    void setStartX(int startX);

    /**
     * Initial y coordinate of slices. They will animate to the final y position from this one.
     */
    void setStartY(int startY);

    /**
     * By default, the height of a slice represents it's value. However you might want the area of a slice to represent
     * value - set this property to "area" then.
     */
    void setValueRepresents(String valueRepresents);
}
