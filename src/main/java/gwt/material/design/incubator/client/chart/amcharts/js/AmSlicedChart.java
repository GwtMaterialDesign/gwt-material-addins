package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.js.options.Slice;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.MouseEvent;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * @author kevzlou7979@gmail.com
 * @see <a href="">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmSlicedChart extends AmChart {

    @JsProperty
    public String accessibleLabel;

    @JsProperty
    public double alpha;

    @JsProperty
    public String alphaField;

    @JsProperty
    public String baseColor;

    @JsProperty
    public int brightnessStep;

    @JsProperty
    public Object[] chartData;

    @JsProperty
    public String classNameField;

    @JsProperty
    public String colorField;

    @JsProperty
    public String[] colors;

    @JsProperty
    public String descriptionField;

    @JsProperty
    public int[] gradientRatio;

    @JsProperty
    public int groupedAlpha;

    @JsProperty
    public String groupedColor;

    @JsProperty
    public String groupedDescription;

    @JsProperty
    public boolean groupedPulled;

    @JsProperty
    public String groupedTitle;

    @JsProperty
    public int groupPercent;

    @JsProperty
    public int hideLabelsPercent;

    @JsProperty
    public double hoverAlpha;

    @JsProperty
    public String labelColorField;

    @JsProperty
    public Functions.Func labelFunction;

    @JsProperty
    public boolean labelsEnabled;

    @JsProperty
    public double labelTickAlpha;

    @JsProperty
    public String labelTickColor;

    @JsProperty
    public int marginBottom;

    @JsProperty
    public int marginLeft;

    @JsProperty
    public int marginRight;

    @JsProperty
    public int marginTop;

    @JsProperty
    public int maxLabelWidth;

    @JsProperty
    public double outlineAlpha;

    @JsProperty
    public String outlineColor;

    @JsProperty
    public int outlineThickness;

    @JsProperty
    public String patternField;

    @JsProperty
    public String pulledField;

    @JsProperty
    public int pullOutDuration;

    @JsProperty
    public String pullOutEffect;

    @JsProperty
    public boolean pullOutOnlyOne;

    @JsProperty
    public boolean sequencedAnimation;

    @JsProperty
    public boolean showZeroSlices;

    @JsProperty
    public double startAlpha;

    @JsProperty
    public int startDuration;

    @JsProperty
    public String startEffect;

    @JsProperty
    public int tabIndex;

    @JsProperty
    public String titleField;

    @JsProperty
    public String urlField;

    @JsProperty
    public String urlTarget;

    @JsProperty
    public String valueField;

    @JsProperty
    public String visibleInLegendField;

    @JsMethod
    public native void animateAgain();

    @JsMethod
    public native void clickSlice(Object slice);

    @JsMethod
    public native void hideSlice(Object slice);

    @JsMethod
    public native void rollOutSlice(Object slice);

    @JsMethod
    public native void rollOverSlice(Object slice);

    /**
     * 	Shows slice.
     */
    @JsMethod
    public native void showSlice(Object slice);

    /**
     * Dispatched when user clicks on a slice. Event is an instance of original mouse event.
     */
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> clickSlide;

    /**
     * Dispatched when user clicks on a slice and the slice is pulled-in. Event is an instance of original mouse event.
     */
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> pullInSlice;

    /**
     * Dispatched when user clicks on a slice and the slice is pulled-out. Event is an instance of original mouse event.
     */
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> pullOutSlice;

    /**
     * Dispatched when user right-clicks the slice. Event is an instance of original mouse event.
     */
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> rightClickSlice;

    /**
     * Dispatched when user rolls-out of the slice. Event is an instance of original mouse event.
     */
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> rollOutSlice;

    /**
     * Dispatched when user rolls-over the slice. Event is an instance of original mouse event.
     */
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> rollOverSlice;
}
