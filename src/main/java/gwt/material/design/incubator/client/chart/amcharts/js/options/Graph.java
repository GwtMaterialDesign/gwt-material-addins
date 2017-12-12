package gwt.material.design.incubator.client.chart.amcharts.js.options;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.GraphType;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Graph {

    /**
     * Text which screen readers will read if user rolls-over the bullet/column or sets focus using tab key (this is
     * possible only if tabIndex property of AmGraph is set to some number). Text is added as aria-label tag. Note -
     * not all screen readers and browsers support this.
     */
    @JsProperty
    public String accessibleLabel;

    /**
     * Name of the alpha field in your dataProvider.
     */
    @JsProperty
    public String alphaField;

    /**
     * If you set this to true before chart is drawn, the animation of this graph won't be played.
     */
    @JsProperty
    public boolean animationPlayed;

    //TODO Turn to Balloon
    /**
     * Allows customizing graphs balloons individually (only when ChartCursor is used). Note: the balloon object is not
     * created automatically, you should create it before setting properties
     */
    @JsProperty
    public Object balloon;

    /**
     * Value balloon color. Will use graph or data item color if not set.
     */
    @JsProperty
    public String ballonColor;

    /**
     * If you set some function, the graph will call it and pass GraphDataItem and AmGraph objects to it. This function
     * should return a string which will be displayed in a balloon.
     */
    @JsProperty
    public Functions.Func balloonFunction;

    /**
     * Balloon text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]] or any other
     * field name from your data provider. HTML tags can also be used.
     */
    @JsProperty
    public String balloonText;

    /**
     * Specifies if the line graph should be placed behind column graphs
     */
    @JsProperty
    public boolean behindColumns;

    // TODO Add an Overlay
    /**
     * Type of the bullets. Possible values are: "none", "round", "square", "triangleUp", "triangleDown",
     * "triangleLeft", "triangleRight", "bubble", "diamond", "xError", "yError" and "custom".
     */
    @JsProperty
    public String bullet;

    /**
     * Opacity of bullets. Value range is 0 - 1.
     */
    @JsProperty
    public int bulletAlpha;

    // TODO Turn to ValueAxis
    /**
     * bulletAxis value is used when you are building error chart. Error chart is a regular serial or XY chart with
     * bullet type set to "xError" or "yError". The graph should know which axis should be used to determine the size
     * of this bullet - that's when bulletAxis should be set. Besides that, you should also set graph.errorField.
     * You can also use other bullet types with this feature too. For example, if you set bulletAxis for XY chart,
     * the size of a bullet will change as you zoom the chart.
     */
    @JsProperty
    public Object bulletAxis;

    /**
     * Bullet border opacity.
     */
    @JsProperty
    public int bulletBorderAlpha;


    @JsProperty
    public String type;

    @JsProperty
    public String title;

    @JsProperty
    public String valueField;

    @JsOverlay
    public final void setType(GraphType type) {
        this.type = type.getName();
    }

    @JsOverlay
    public final void setTitle(String title) {
        this.title = title;
    }

    @JsOverlay
    public final void setValueField(String valueField) {
        this.valueField = valueField;
    }
}
