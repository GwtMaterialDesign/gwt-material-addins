package gwt.material.design.incubator.client.formatter;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class MetricRange {

    @JsProperty
    double divider;

    @JsProperty
    String suffix;

    @JsOverlay
    public final static MetricRange create(double divider, String suffix) {
        MetricRange metricRange = new MetricRange();
        metricRange.divider = divider;
        metricRange.suffix = suffix;
        return metricRange;
    }
}
