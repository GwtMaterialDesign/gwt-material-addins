package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;

public class Balloon extends ChartOptions {

    private AmBalloon balloon = new AmBalloon();

    public boolean isAdjustBorderColor() {
        return balloon.adjustBorderColor;
    }

    /**
     * If this is set to true, border color instead of background color will be changed when user rolls-over the slice, graph, etc. Default to true
     */

    public void setAdjustBorderColor(boolean adjustBorderColor) {
        balloon.adjustBorderColor = adjustBorderColor;
    }


    public double getAnimationDuration() {
        return balloon.animationDuration;
    }

    /**
     * Duration of balloon movement from previous point to current point, in seconds. Default to 0.3
     */

    public void setAnimationDuration(double animationDuration) {
        balloon.animationDuration = animationDuration;
    }


    public double getBorderAlpha() {
        return balloon.borderAlpha;
    }

    /**
     * Balloon border opacity. Value range is 0 - 1.
     */

    public void setBorderAlpha(double borderAlpha) {
        balloon.borderAlpha = borderAlpha;
    }


    public String getBorderColor() {
        return balloon.borderColor;
    }

    /**
     * Balloon border color. Will only be used of adjustBorderColor is false. Default to #FFFFFF
     */

    public void setBorderColor(String borderColor) {
        balloon.borderColor = borderColor;
    }


    public int getBorderThickness() {
        return balloon.borderThickness;
    }

    /**
     * Balloon border thickness. Default to 2
     */

    public void setBorderThickness(int borderThickness) {
        balloon.borderThickness = borderThickness;
    }


    public String getColor() {
        return balloon.color;
    }

    /**
     * Color of text in the balloon. Default to #000000
     */

    public void setColor(String color) {
        balloon.color = color;
    }


    public int getCornerRadius() {
        return balloon.cornerRadius;
    }

    /**
     * Balloon corner radius. Default to 0
     */

    public void setCornerRadius(int cornerRadius) {
        balloon.cornerRadius = cornerRadius;
    }


    public boolean isDisableMouseEvents() {
        return balloon.disableMouseEvents;
    }

    /**
     * If your balloon has links, you have to set this to false in order for those links to be clickable. Default to true
     */

    public void setDisableMouseEvents(boolean disableMouseEvents) {
        balloon.disableMouseEvents = disableMouseEvents;
    }


    public boolean isDrop() {
        return balloon.drop;
    }

    /**
     * Allows having drop-shaped balloons. Note, these balloons will not check for overlapping with other balloons,
     * or if they go outside plot area. It also does not change pointer orientation automatically based on its vertical
     * position like regular balloons do. You can use pointerOrientation property if you want it to point to different
     * direction. Not supported by IE8. Default to false
     */

    public void setDrop(boolean drop) {
        balloon.drop = drop;
    }


    public boolean isEnabled() {
        return balloon.enabled;
    }

    /**
     * Use this property to disable balloons for certain value axes. Default to true
     */

    public void setEnabled(boolean enabled) {
        balloon.enabled = enabled;
    }


    public double getFadeOutDuration() {
        return balloon.fadeOutDuration;
    }

    /**
     * Duration of a fade out animation, in seconds. Default to 0.3
     */

    public void setFadeOutDuration(double fadeOutDuration) {
        balloon.fadeOutDuration = fadeOutDuration;
    }


    public double getFillAlpha() {
        return balloon.fillAlpha;
    }

    /**
     * Balloon background opacity. Default to 0.8
     */

    public void setFillAlpha(double fillAlpha) {
        balloon.fillAlpha = fillAlpha;
    }


    public String getFillColor() {
        return balloon.fillColor;
    }

    /**
     * Balloon background color. Usually balloon background color is set by the chart. Only if "adjustBorderColor" is
     * "true" this color will be used. Default to #FFFFFF
     */

    public void setFillColor(String fillColor) {
        balloon.fillColor = fillColor;
    }


    public boolean isFixedPosition() {
        return balloon.fixedPosition;
    }

    /**
     * Specifies if balloon should follow mouse when hovering the slice/column/bullet or stay in fixed position
     * (this does not affect balloon behavior if
     * {@link ChartCursor} is used).
     */

    public void setFixedPosition(boolean fixedPosition) {
        balloon.fixedPosition = fixedPosition;
    }


    public int getFontSize() {
        return balloon.fontSize;
    }

    /**
     * Size of text in the balloon. Chart's fontSize is used by default.
     */

    public void setFontSize(int fontSize) {
        balloon.fontSize = fontSize;
    }


    public int getHorizontalPadding() {
        return balloon.horizontalPadding;
    }

    /**
     * Horizontal padding of the balloon. Default to 8
     */

    public void setHorizontalPadding(int horizontalPadding) {
        balloon.horizontalPadding = horizontalPadding;
    }


    public int getMaxWidth() {
        return balloon.maxWidth;
    }

    /**
     * Maximum width of a balloon.
     */

    public void setMaxWidth(int maxWidth) {
        balloon.maxWidth = maxWidth;
    }


    public int getOffsetX() {
        return balloon.offsetX;
    }

    /**
     * Defines horizontal distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 1
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */

    public void setOffsetX(int offsetX) {
        balloon.offsetX = offsetX;
    }


    public int getOffsetY() {
        return balloon.offsetY;
    }

    /**
     * Defines vertical distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 6
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */

    public void setOffsetY(int offsetY) {
        balloon.offsetY = offsetY;
    }


    public String getPointerOrientation() {
        return balloon.pointerOrientation;
    }

    /**
     * Works only if balloon.drop set to true, specifies direction of a pointer. Default to down
     */

    public void setPointerOrientation(String pointerOrientation) {
        balloon.pointerOrientation = pointerOrientation;
    }


    public int getPointerWidth() {
        return balloon.pointerWidth;
    }

    /**
     * The width of the pointer (arrow) "root". Only used if cornerRadius is 0. Default to 6
     */

    public void setPointerWidth(int pointerWidth) {
        balloon.pointerWidth = pointerWidth;
    }


    public double getShadowAlpha() {
        return balloon.shadowAlpha;
    }

    /**
     * Opacity of a shadow. Default to 0.4
     */

    public void setShadowAlpha(double shadowAlpha) {
        balloon.shadowAlpha = shadowAlpha;
    }


    public String getShadowColor() {
        return balloon.shadowColor;
    }

    /**
     * Color of a shadow. Default to #000000
     */

    public void setShadowColor(String shadowColor) {
        balloon.shadowColor = shadowColor;
    }


    public boolean isShowBullet() {
        return balloon.showBullet;
    }

    /**
     * If cornerRadius of a balloon is >0, showBullet is set to true for value balloons when ChartCursor is used.
     * If you don't want the bullet near the balloon, set it to false: chart.balloon.showBullet = false.
     * Default to false
     */

    public void setShowBullet(boolean showBullet) {
        balloon.showBullet = showBullet;
    }


    public String getTextAlign() {
        return balloon.textAlign;
    }

    /**
     * Text alignment, possible values "left", "middle" and "right". Default to middle
     */

    public void setTextAlign(String textAlign) {
        balloon.textAlign = textAlign;
    }


    public int getVerticalPadding() {
        return balloon.verticalPadding;
    }

    /**
     * Vertical padding of the balloon. Default to 4
     */

    public void setVerticalPadding(int verticalPadding) {
        balloon.verticalPadding = verticalPadding;
    }

    public AmBalloon getBalloon() {
        return balloon;
    }
}
