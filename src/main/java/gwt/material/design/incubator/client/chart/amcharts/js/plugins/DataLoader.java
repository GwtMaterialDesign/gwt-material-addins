package gwt.material.design.incubator.client.chart.amcharts.js.plugins;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class DataLoader {

    @JsProperty
    public String url;

    @JsProperty
    public String format;

    @JsOverlay
    public final void setUrl(String url) {
        this.url = url;
    }

    @JsOverlay
    public final void setFormat(String format) {
        this.format = format;
    }
}
