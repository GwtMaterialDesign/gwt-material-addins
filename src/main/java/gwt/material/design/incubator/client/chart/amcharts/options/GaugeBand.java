package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGaugeBand;
import jsinterop.annotations.JsMethod;

public class GaugeBand extends ChartOptions {

    private AmGaugeBand gaugeBand = new AmGaugeBand();

    public double getAlpha() {
        return gaugeBand.alpha;
    }

    /**
     * Opacity of band fill. Will use axis.bandAlpha if not set any.
     */

    public void setAlpha(double alpha) {
        gaugeBand.alpha = alpha;
    }

    public String getBalloonText() {
        return gaugeBand.balloonText;
    }

    /**
     * When rolled-over, band will display balloon if you set some text for this property.
     */

    public void setBalloonText(String balloonText) {
        gaugeBand.balloonText = balloonText;
    }

    public String getColor() {
        return gaugeBand.color;
    }

    /**
     * Color of a band.
     */

    public void setColor(String color) {
        gaugeBand.color = color;
    }

    public int getEndValue() {
        return gaugeBand.endValue;
    }

    /**
     * End value of a fill.
     */
    @JsMethod
    public native void setEndValue(int value);

    public int[] getGradientRatio() {
        return gaugeBand.gradientRatio;
    }

    /**
     * Example: [-0.2, 0, -0.2]. Will make bands to be filled with color gradients. Negative value means the color will
     * be darker than the original, and positive number means the color will be lighter.
     */

    public void setGradientRatio(int[] gradientRatio) {
        gaugeBand.gradientRatio = gradientRatio;
    }

    public String getId() {
        return gaugeBand.id;
    }

    /**
     * Unique id of a band.
     */

    public void setId(String id) {
        gaugeBand.id = id;
    }

    public Object getInnerRadius() {
        return gaugeBand.innerRadius;
    }

    /**
     * Inner radius of a band. If not set any, the band will end with the end of minor ticks. Set 0 if you want the band
     * to be drawn to the axis center.
     */

    public void setInnerRadius(Object innerRadius) {
        gaugeBand.innerRadius = innerRadius;
    }

    public Object getRadius() {
        return gaugeBand.radius;
    }

    /**
     * Band radius. If not set any, the band will start with the axis outline.
     */

    public void setRadius(Object radius) {
        gaugeBand.radius = radius;
    }

    public int getStartValue() {
        return gaugeBand.startValue;
    }

    /**
     * Start value of a fill.
     */
    @JsMethod
    public native void setStartValue(int value);

    public String getUrl() {
        return gaugeBand.url;
    }

    public void setUrl(String url) {
        gaugeBand.url = url;
    }

    public AmGaugeBand getGaugeBand() {
        return gaugeBand;
    }
}
