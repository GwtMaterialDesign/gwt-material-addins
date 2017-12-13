package gwt.material.design.incubator.client.chart.amcharts.js;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Creates the balloons ( tooltips ) of the chart, It follows the mouse cursor when you roll-over the data items.
 * The framework generates the instances automatically you only need to adjust the appearance to your needs.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmBalloon">Official Documentation</a>
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmBalloon {

    /**
     * If this is set to true, border color instead of background color will be changed when user rolls-over the slice, graph, etc. Default to true
     */
    @JsProperty
    public boolean adjustBorderColor;

    /**
     * Duration of balloon movement from previous point to current point, in seconds. Default to 0.3
     */
    @JsProperty
    public double animationDuration;

    /**
     * Balloon border opacity. Value range is 0 - 1.
     */
    @JsProperty
    public double borderAlpha;

    /**
     * Balloon border color. Will only be used of adjustBorderColor is false. Default to #FFFFFF
     */
    @JsProperty
    public String borderColor;

    /**
     * Balloon border thickness. Default to 2
     */
    @JsProperty
    public int borderThickness;

    /**
     * Color of text in the balloon. Default to #000000
     */
    @JsProperty
    public String color;

    /**
     * Balloon corner radius. Default to 0
     */
    @JsProperty
    public int cornerRadius;

    /**
     * If your balloon has links, you have to set this to false in order for those links to be clickable. Default to true
     */
    @JsProperty
    public boolean disableMouseEvents;

    /**
     * Allows having drop-shaped balloons. Note, these balloons will not check for overlapping with other balloons,
     * or if they go outside plot area. It also does not change pointer orientation automatically based on its vertical
     * position like regular balloons do. You can use pointerOrientation property if you want it to point to different
     * direction. Not supported by IE8. Default to false
     */
    @JsProperty
    public boolean drop;

    /**
     * Use this property to disable balloons for certain value axes. Default to true
     */
    @JsProperty
    public boolean enabled;

    /**
     * Duration of a fade out animation, in seconds. Default to 0.3
     */
    @JsProperty
    public double fadeOutDuration;

    /**
     * Balloon background opacity. Default to 0.8
     */
    @JsProperty
    public double fillAlpha;

    /**
     * Balloon background color. Usually balloon background color is set by the chart. Only if "adjustBorderColor" is
     * "true" this color will be used. Default to #FFFFFF
     */
    @JsProperty
    public String fillColor;

    /**
     * Specifies if balloon should follow mouse when hovering the slice/column/bullet or stay in fixed position
     * (this does not affect balloon behavior if
     * {@link gwt.material.design.incubator.client.chart.amcharts.js.options.ChartCursor} is used).
     */
    @JsProperty
    public boolean fixedPosition;

    /**
     * Size of text in the balloon. Chart's fontSize is used by default.
     */
    @JsProperty
    public int fontSize;

    /**
     * Horizontal padding of the balloon. Default to 8
     */
    @JsProperty
    public int horizontalPadding;

    /**
     * Maximum width of a balloon.
     */
    @JsProperty
    public int maxWidth;

    /**
     * Defines horizontal distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 1
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */
    @JsProperty
    public int offsetX;

    /**
     * Defines vertical distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 6
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */
    @JsProperty
    public int offsetY;

    /**
     * Works only if balloon.drop set to true, specifies direction of a pointer. Default to down
     */
    @JsProperty
    public String pointerOrientation;

    /**
     * The width of the pointer (arrow) "root". Only used if cornerRadius is 0. Default to 6
     */
    @JsProperty
    public int pointerWidth;

    /**
     * Opacity of a shadow. Default to 0.4
     */
    @JsProperty
    private double shadowAlpha;

    /**
     * Color of a shadow. Default to #000000
     */
    @JsProperty
    public String shadowColor;

    /**
     * If cornerRadius of a balloon is >0, showBullet is set to true for value balloons when ChartCursor is used.
     * If you don't want the bullet near the balloon, set it to false: chart.balloon.showBullet = false.
     * Default to false
     */
    @JsProperty
    public boolean showBullet;

    /**
     * Text alignment, possible values "left", "middle" and "right". Default to middle
     */
    @JsProperty
    public String textAlign;

    /**
     * Vertical padding of the balloon. Default to 4
     */
    @JsProperty
    public int verticalPadding;

    /**
     * Hides balloon.
     */
    @JsMethod
    public native void hide();

    /**
     * Defines a square within which the balloon should appear. Bounds are set by chart class, you don't need to
     * call this method yourself.
     */
    @JsMethod
    public native void setBounds(int left, int top, int right, int bottom);

    /**
     * Sets coordinates the balloon should point to.
     */
    @JsMethod
    public native void setPosition(int x, int y);
}
