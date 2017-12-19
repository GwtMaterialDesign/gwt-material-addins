/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.incubator.client.chart.amcharts.js;

import jsinterop.annotations.*;

//@formatter:off

/**
 * Creates the balloons ( tooltips ) of the chart, It follows the mouse cursor when you roll-over the data items.
 * The framework generates the instances automatically you only need to adjust the appearance to your needs.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmBalloon">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmBalloon {

    /**
     * If this is set to true, border color instead of background color will be changed when user rolls-over the slice, graph, etc. Default to true
     */
    @JsProperty
    private boolean adjustBorderColor;

    /**
     * Duration of balloon movement from previous point to current point, in seconds. Default to 0.3
     */
    @JsProperty
    private double animationDuration;

    /**
     * Balloon border opacity. Value range is 0 - 1.
     */
    @JsProperty
    private double borderAlpha;

    /**
     * Balloon border color. Will only be used of adjustBorderColor is false. Default to #FFFFFF
     */
    @JsProperty
    private String borderColor;

    /**
     * Balloon border thickness. Default to 2
     */
    @JsProperty
    private int borderThickness;

    /**
     * Color of text in the balloon. Default to #000000
     */
    @JsProperty
    private String color;

    /**
     * Balloon corner radius. Default to 0
     */
    @JsProperty
    private int cornerRadius;

    /**
     * If your balloon has links, you have to set this to false in order for those links to be clickable. Default to true
     */
    @JsProperty
    private boolean disableMouseEvents;

    /**
     * Allows having drop-shaped balloons. Note, these balloons will not check for overlapping with other balloons,
     * or if they go outside plot area. It also does not change pointer orientation automatically based on its vertical
     * position like regular balloons do. You can use pointerOrientation property if you want it to point to different
     * direction. Not supported by IE8. Default to false
     */
    @JsProperty
    private boolean drop;

    /**
     * Use this property to disable balloons for certain value axes. Default to true
     */
    @JsProperty
    private boolean enabled;

    /**
     * Duration of a fade out animation, in seconds. Default to 0.3
     */
    @JsProperty
    private double fadeOutDuration;

    /**
     * Balloon background opacity. Default to 0.8
     */
    @JsProperty
    private double fillAlpha;

    /**
     * Balloon background color. Usually balloon background color is set by the chart. Only if "adjustBorderColor" is
     * "true" this color will be used. Default to #FFFFFF
     */
    @JsProperty
    private String fillColor;

    /**
     * Specifies if balloon should follow mouse when hovering the slice/column/bullet or stay in fixed position
     * (this does not affect balloon behavior if
     * {@link gwt.material.design.incubator.client.chart.amcharts.js.options.ChartCursor} is used).
     */
    @JsProperty
    private boolean fixedPosition;

    /**
     * Size of text in the balloon. Chart's fontSize is used by default.
     */
    @JsProperty
    private int fontSize;

    /**
     * Horizontal padding of the balloon. Default to 8
     */
    @JsProperty
    private int horizontalPadding;

    /**
     * Maximum width of a balloon.
     */
    @JsProperty
    private int maxWidth;

    /**
     * Defines horizontal distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 1
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */
    @JsProperty
    private int offsetX;

    /**
     * Defines vertical distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 6
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */
    @JsProperty
    private int offsetY;

    /**
     * Works only if balloon.drop set to true, specifies direction of a pointer. Default to down
     */
    @JsProperty
    private String pointerOrientation;

    /**
     * The width of the pointer (arrow) "root". Only used if cornerRadius is 0. Default to 6
     */
    @JsProperty
    private int pointerWidth;

    /**
     * Opacity of a shadow. Default to 0.4
     */
    @JsProperty
    private double shadowAlpha;

    /**
     * Color of a shadow. Default to #000000
     */
    @JsProperty
    private String shadowColor;

    /**
     * If cornerRadius of a balloon is >0, showBullet is set to true for value balloons when ChartCursor is used.
     * If you don't want the bullet near the balloon, set it to false: chart.balloon.showBullet = false.
     * Default to false
     */
    @JsProperty
    private boolean showBullet;

    /**
     * Text alignment, possible values "left", "middle" and "right". Default to middle
     */
    @JsProperty
    private String textAlign;

    /**
     * Vertical padding of the balloon. Default to 4
     */
    @JsProperty
    private int verticalPadding;

    @JsOverlay
    public final void setAdjustBorderColor(boolean adjustBorderColor) {
        this.adjustBorderColor = adjustBorderColor;
    }

    @JsOverlay
    public final void setAnimationDuration(double animationDuration) {
        this.animationDuration = animationDuration;
    }

    @JsOverlay
    public final void setBorderAlpha(double borderAlpha) {
        this.borderAlpha = borderAlpha;
    }

    @JsOverlay
    public final void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @JsOverlay
    public final void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
    }

    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    @JsOverlay
    public final void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @JsOverlay
    public final void setDisableMouseEvents(boolean disableMouseEvents) {
        this.disableMouseEvents = disableMouseEvents;
    }

    @JsOverlay
    public final void setDrop(boolean drop) {
        this.drop = drop;
    }

    @JsOverlay
    public final void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @JsOverlay
    public final void setFadeOutDuration(double fadeOutDuration) {
        this.fadeOutDuration = fadeOutDuration;
    }

    @JsOverlay
    public final void setFillAlpha(double fillAlpha) {
        this.fillAlpha = fillAlpha;
    }

    @JsOverlay
    public final void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    @JsOverlay
    public final void setFixedPosition(boolean fixedPosition) {
        this.fixedPosition = fixedPosition;
    }

    @JsOverlay
    public final void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @JsOverlay
    public final void setHorizontalPadding(int horizontalPadding) {
        this.horizontalPadding = horizontalPadding;
    }

    @JsOverlay
    public final void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    @JsOverlay
    public final void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    @JsOverlay
    public final void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    @JsOverlay
    public final void setPointerOrientation(String pointerOrientation) {
        this.pointerOrientation = pointerOrientation;
    }

    @JsOverlay
    public final void setPointerWidth(int pointerWidth) {
        this.pointerWidth = pointerWidth;
    }

    @JsOverlay
    public final void setShadowAlpha(double shadowAlpha) {
        this.shadowAlpha = shadowAlpha;
    }

    @JsOverlay
    public final void setShadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
    }

    @JsOverlay
    public final void setShowBullet(boolean showBullet) {
        this.showBullet = showBullet;
    }

    @JsOverlay
    public final void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    @JsOverlay
    public final void setVerticalPadding(int verticalPadding) {
        this.verticalPadding = verticalPadding;
    }

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
