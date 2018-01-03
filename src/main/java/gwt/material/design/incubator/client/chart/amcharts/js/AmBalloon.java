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

    @JsProperty
    private boolean adjustBorderColor;

    @JsProperty
    private double animationDuration;

    @JsProperty
    private double borderAlpha;

    @JsProperty
    private String borderColor;

    @JsProperty
    private int borderThickness;

    @JsProperty
    private String color;

    @JsProperty
    private int cornerRadius;

    @JsProperty
    private boolean disableMouseEvents;

    @JsProperty
    private boolean drop;

    @JsProperty
    private boolean enabled;

    @JsProperty
    private double fadeOutDuration;

    @JsProperty
    private double fillAlpha;

    @JsProperty
    private String fillColor;

    @JsProperty
    private boolean fixedPosition;

    @JsProperty
    private int fontSize;

    @JsProperty
    private int horizontalPadding;

    @JsProperty
    private int maxWidth;

    @JsProperty
    private int offsetX;

    @JsProperty
    private int offsetY;

    @JsProperty
    private String pointerOrientation;

    @JsProperty
    private int pointerWidth;

    @JsProperty
    private double shadowAlpha;

    @JsProperty
    private String shadowColor;

    @JsProperty
    private boolean showBullet;

    @JsProperty
    private String textAlign;

    @JsProperty
    private int verticalPadding;

    @JsOverlay
    public final boolean isAdjustBorderColor() {
        return adjustBorderColor;
    }

    /**
     * If this is set to true, border color instead of background color will be changed when user rolls-over the slice, graph, etc. Default to true
     */
    @JsOverlay
    public final void setAdjustBorderColor(boolean adjustBorderColor) {
        this.adjustBorderColor = adjustBorderColor;
    }

    @JsOverlay
    public final double getAnimationDuration() {
        return animationDuration;
    }

    /**
     * Duration of balloon movement from previous point to current point, in seconds. Default to 0.3
     */
    @JsOverlay
    public final void setAnimationDuration(double animationDuration) {
        this.animationDuration = animationDuration;
    }

    @JsOverlay
    public final double getBorderAlpha() {
        return borderAlpha;
    }

    /**
     * Balloon border opacity. Value range is 0 - 1.
     */
    @JsOverlay
    public final void setBorderAlpha(double borderAlpha) {
        this.borderAlpha = borderAlpha;
    }

    @JsOverlay
    public final String getBorderColor() {
        return borderColor;
    }

    /**
     * Balloon border color. Will only be used of adjustBorderColor is false. Default to #FFFFFF
     */
    @JsOverlay
    public final void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @JsOverlay
    public final int getBorderThickness() {
        return borderThickness;
    }

    /**
     * Balloon border thickness. Default to 2
     */
    @JsOverlay
    public final void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
    }

    @JsOverlay
    public final String getColor() {
        return color;
    }

    /**
     * Color of text in the balloon. Default to #000000
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    @JsOverlay
    public final int getCornerRadius() {
        return cornerRadius;
    }

    /**
     * Balloon corner radius. Default to 0
     */
    @JsOverlay
    public final void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @JsOverlay
    public final boolean isDisableMouseEvents() {
        return disableMouseEvents;
    }

    /**
     * If your balloon has links, you have to set this to false in order for those links to be clickable. Default to true
     */
    @JsOverlay
    public final void setDisableMouseEvents(boolean disableMouseEvents) {
        this.disableMouseEvents = disableMouseEvents;
    }

    @JsOverlay
    public final boolean isDrop() {
        return drop;
    }

    /**
     * Allows having drop-shaped balloons. Note, these balloons will not check for overlapping with other balloons,
     * or if they go outside plot area. It also does not change pointer orientation automatically based on its vertical
     * position like regular balloons do. You can use pointerOrientation property if you want it to point to different
     * direction. Not supported by IE8. Default to false
     */
    @JsOverlay
    public final void setDrop(boolean drop) {
        this.drop = drop;
    }

    @JsOverlay
    public final boolean isEnabled() {
        return enabled;
    }

    /**
     * Use this property to disable balloons for certain value axes. Default to true
     */
    @JsOverlay
    public final void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @JsOverlay
    public final double getFadeOutDuration() {
        return fadeOutDuration;
    }

    /**
     * Duration of a fade out animation, in seconds. Default to 0.3
     */
    @JsOverlay
    public final void setFadeOutDuration(double fadeOutDuration) {
        this.fadeOutDuration = fadeOutDuration;
    }

    @JsOverlay
    public final double getFillAlpha() {
        return fillAlpha;
    }

    /**
     * Balloon background opacity. Default to 0.8
     */
    @JsOverlay
    public final void setFillAlpha(double fillAlpha) {
        this.fillAlpha = fillAlpha;
    }

    @JsOverlay
    public final String getFillColor() {
        return fillColor;
    }

    /**
     * Balloon background color. Usually balloon background color is set by the chart. Only if "adjustBorderColor" is
     * "true" this color will be used. Default to #FFFFFF
     */
    @JsOverlay
    public final void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    @JsOverlay
    public final boolean isFixedPosition() {
        return fixedPosition;
    }

    /**
     * Specifies if balloon should follow mouse when hovering the slice/column/bullet or stay in fixed position
     * (this does not affect balloon behavior if
     * {@link gwt.material.design.incubator.client.chart.amcharts.js.options.ChartCursor} is used).
     */
    @JsOverlay
    public final void setFixedPosition(boolean fixedPosition) {
        this.fixedPosition = fixedPosition;
    }

    @JsOverlay
    public final int getFontSize() {
        return fontSize;
    }

    /**
     * Size of text in the balloon. Chart's fontSize is used by default.
     */
    @JsOverlay
    public final void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @JsOverlay
    public final int getHorizontalPadding() {
        return horizontalPadding;
    }

    /**
     * Horizontal padding of the balloon. Default to 8
     */
    @JsOverlay
    public final void setHorizontalPadding(int horizontalPadding) {
        this.horizontalPadding = horizontalPadding;
    }

    @JsOverlay
    public final int getMaxWidth() {
        return maxWidth;
    }

    /**
     * Maximum width of a balloon.
     */
    @JsOverlay
    public final void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    @JsOverlay
    public final int getOffsetX() {
        return offsetX;
    }

    /**
     * Defines horizontal distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 1
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */
    @JsOverlay
    public final void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    @JsOverlay
    public final int getOffsetY() {
        return offsetY;
    }

    /**
     * Defines vertical distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 6
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */
    @JsOverlay
    public final void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    @JsOverlay
    public final String getPointerOrientation() {
        return pointerOrientation;
    }

    /**
     * Works only if balloon.drop set to true, specifies direction of a pointer. Default to down
     */
    @JsOverlay
    public final void setPointerOrientation(String pointerOrientation) {
        this.pointerOrientation = pointerOrientation;
    }

    @JsOverlay
    public final int getPointerWidth() {
        return pointerWidth;
    }

    /**
     * The width of the pointer (arrow) "root". Only used if cornerRadius is 0. Default to 6
     */
    @JsOverlay
    public final void setPointerWidth(int pointerWidth) {
        this.pointerWidth = pointerWidth;
    }

    @JsOverlay
    public final double getShadowAlpha() {
        return shadowAlpha;
    }

    /**
     * Opacity of a shadow. Default to 0.4
     */
    @JsOverlay
    public final void setShadowAlpha(double shadowAlpha) {
        this.shadowAlpha = shadowAlpha;
    }

    @JsOverlay
    public final String getShadowColor() {
        return shadowColor;
    }

    /**
     * Color of a shadow. Default to #000000
     */
    @JsOverlay
    public final void setShadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
    }

    @JsOverlay
    public final boolean isShowBullet() {
        return showBullet;
    }

    /**
     * If cornerRadius of a balloon is >0, showBullet is set to true for value balloons when ChartCursor is used.
     * If you don't want the bullet near the balloon, set it to false: chart.balloon.showBullet = false.
     * Default to false
     */
    @JsOverlay
    public final void setShowBullet(boolean showBullet) {
        this.showBullet = showBullet;
    }

    @JsOverlay
    public final String getTextAlign() {
        return textAlign;
    }

    /**
     * Text alignment, possible values "left", "middle" and "right". Default to middle
     */
    @JsOverlay
    public final void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    @JsOverlay
    public final int getVerticalPadding() {
        return verticalPadding;
    }

    /**
     * Vertical padding of the balloon. Default to 4
     */
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
