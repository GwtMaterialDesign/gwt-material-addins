package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;

//@formatter:off

/**
 * Creates the balloons ( tooltips ) of the chart, It follows the mouse cursor when you roll-over the data items.
 * The framework generates the instances automatically you only need to adjust the appearance to your needs.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmBalloon">Official Documentation</a>
 */
//@formatter:on
public class Balloon extends ChartOptions {

    private AmBalloon balloon;

    public boolean isAdjustBorderColor() {
        return getAmBalloon().adjustBorderColor;
    }

    /**
     * If this is set to true, border color instead of background color will be changed when user rolls-over the slice, graph, etc. Default to true
     */

    public void setAdjustBorderColor(boolean adjustBorderColor) {
        getAmBalloon().adjustBorderColor = adjustBorderColor;
    }


    public double getAnimationDuration() {
        return getAmBalloon().animationDuration;
    }

    /**
     * Duration of balloon movement from previous point to current point, in seconds. Default to 0.3
     */

    public void setAnimationDuration(double animationDuration) {
        getAmBalloon().animationDuration = animationDuration;
    }


    public double getBorderAlpha() {
        return getAmBalloon().borderAlpha;
    }

    /**
     * Balloon border opacity. Value range is 0 - 1.
     */

    public void setBorderAlpha(double borderAlpha) {
        getAmBalloon().borderAlpha = borderAlpha;
    }


    public String getBorderColor() {
        return getAmBalloon().borderColor;
    }

    /**
     * Balloon border color. Will only be used of adjustBorderColor is false. Default to #FFFFFF
     */

    public void setBorderColor(String borderColor) {
        getAmBalloon().borderColor = borderColor;
    }


    public int getBorderThickness() {
        return getAmBalloon().borderThickness;
    }

    /**
     * Balloon border thickness. Default to 2
     */

    public void setBorderThickness(int borderThickness) {
        getAmBalloon().borderThickness = borderThickness;
    }


    public String getColor() {
        return getAmBalloon().color;
    }

    /**
     * Color of text in the getAmBalloon(). Default to #000000
     */

    public void setColor(String color) {
        getAmBalloon().color = color;
    }


    public int getCornerRadius() {
        return getAmBalloon().cornerRadius;
    }

    /**
     * Balloon corner radius. Default to 0
     */

    public void setCornerRadius(int cornerRadius) {
        getAmBalloon().cornerRadius = cornerRadius;
    }


    public boolean isDisableMouseEvents() {
        return getAmBalloon().disableMouseEvents;
    }

    /**
     * If your balloon has links, you have to set this to false in order for those links to be clickable. Default to true
     */

    public void setDisableMouseEvents(boolean disableMouseEvents) {
        getAmBalloon().disableMouseEvents = disableMouseEvents;
    }


    public boolean isDrop() {
        return getAmBalloon().drop;
    }

    /**
     * Allows having drop-shaped balloons. Note, these balloons will not check for overlapping with other balloons,
     * or if they go outside plot area. It also does not change pointer orientation automatically based on its vertical
     * position like regular balloons do. You can use pointerOrientation property if you want it to point to different
     * direction. Not supported by IE8. Default to false
     */

    public void setDrop(boolean drop) {
        getAmBalloon().drop = drop;
    }


    public boolean isEnabled() {
        return getAmBalloon().enabled;
    }

    /**
     * Use this property to disable balloons for certain value axes. Default to true
     */

    public void setEnabled(boolean enabled) {
        getAmBalloon().enabled = enabled;
    }


    public double getFadeOutDuration() {
        return getAmBalloon().fadeOutDuration;
    }

    /**
     * Duration of a fade out animation, in seconds. Default to 0.3
     */

    public void setFadeOutDuration(double fadeOutDuration) {
        getAmBalloon().fadeOutDuration = fadeOutDuration;
    }


    public double getFillAlpha() {
        return getAmBalloon().fillAlpha;
    }

    /**
     * Balloon background opacity. Default to 0.8
     */

    public void setFillAlpha(double fillAlpha) {
        getAmBalloon().fillAlpha = fillAlpha;
    }


    public String getFillColor() {
        return getAmBalloon().fillColor;
    }

    /**
     * Balloon background color. Usually balloon background color is set by the chart. Only if "adjustBorderColor" is
     * "true" this color will be used. Default to #FFFFFF
     */

    public void setFillColor(String fillColor) {
        getAmBalloon().fillColor = fillColor;
    }


    public boolean isFixedPosition() {
        return getAmBalloon().fixedPosition;
    }

    /**
     * Specifies if balloon should follow mouse when hovering the slice/column/bullet or stay in fixed position
     * (this does not affect balloon behavior if
     * {@link ChartCursor} is used).
     */

    public void setFixedPosition(boolean fixedPosition) {
        getAmBalloon().fixedPosition = fixedPosition;
    }


    public int getFontSize() {
        return getAmBalloon().fontSize;
    }

    /**
     * Size of text in the getAmBalloon(). Chart's fontSize is used by default.
     */

    public void setFontSize(int fontSize) {
        getAmBalloon().fontSize = fontSize;
    }


    public int getHorizontalPadding() {
        return getAmBalloon().horizontalPadding;
    }

    /**
     * Horizontal padding of the getAmBalloon(). Default to 8
     */

    public void setHorizontalPadding(int horizontalPadding) {
        getAmBalloon().horizontalPadding = horizontalPadding;
    }


    public int getMaxWidth() {
        return getAmBalloon().maxWidth;
    }

    /**
     * Maximum width of a getAmBalloon().
     */

    public void setMaxWidth(int maxWidth) {
        getAmBalloon().maxWidth = maxWidth;
    }


    public int getOffsetX() {
        return getAmBalloon().offsetX;
    }

    /**
     * Defines horizontal distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 1
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */

    public void setOffsetX(int offsetX) {
        getAmBalloon().offsetX = offsetX;
    }


    public int getOffsetY() {
        return getAmBalloon().offsetY;
    }

    /**
     * Defines vertical distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon
     * might flicker, as mouse might lose focus on hovered object. Default to 6
     * <p>
     * NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
     * </p>
     */

    public void setOffsetY(int offsetY) {
        getAmBalloon().offsetY = offsetY;
    }


    public String getPointerOrientation() {
        return getAmBalloon().pointerOrientation;
    }

    /**
     * Works only if getAmBalloon().drop set to true, specifies direction of a pointer. Default to down
     */

    public void setPointerOrientation(String pointerOrientation) {
        getAmBalloon().pointerOrientation = pointerOrientation;
    }


    public int getPointerWidth() {
        return getAmBalloon().pointerWidth;
    }

    /**
     * The width of the pointer (arrow) "root". Only used if cornerRadius is 0. Default to 6
     */

    public void setPointerWidth(int pointerWidth) {
        getAmBalloon().pointerWidth = pointerWidth;
    }


    public double getShadowAlpha() {
        return getAmBalloon().shadowAlpha;
    }

    /**
     * Opacity of a shadow. Default to 0.4
     */

    public void setShadowAlpha(double shadowAlpha) {
        getAmBalloon().shadowAlpha = shadowAlpha;
    }


    public String getShadowColor() {
        return getAmBalloon().shadowColor;
    }

    /**
     * Color of a shadow. Default to #000000
     */

    public void setShadowColor(String shadowColor) {
        getAmBalloon().shadowColor = shadowColor;
    }


    public boolean isShowBullet() {
        return getAmBalloon().showBullet;
    }

    /**
     * If cornerRadius of a balloon is >0, showBullet is set to true for value balloons when ChartCursor is used.
     * If you don't want the bullet near the balloon, set it to false: chart.getAmBalloon().showBullet = false.
     * Default to false
     */

    public void setShowBullet(boolean showBullet) {
        getAmBalloon().showBullet = showBullet;
    }


    public String getTextAlign() {
        return getAmBalloon().textAlign;
    }

    /**
     * Text alignment, possible values "left", "middle" and "right". Default to middle
     */

    public void setTextAlign(String textAlign) {
        getAmBalloon().textAlign = textAlign;
    }


    public int getVerticalPadding() {
        return getAmBalloon().verticalPadding;
    }

    /**
     * Vertical padding of the getAmBalloon(). Default to 4
     */

    public void setVerticalPadding(int verticalPadding) {
        getAmBalloon().verticalPadding = verticalPadding;
    }

    /**
     * Hides getAmBalloon().
     */
    public void hide() {
        getAmBalloon().hide();
    }

    /**
     * Defines a square within which the balloon should appear. Bounds are set by chart class, you don't need to
     * call this method yourself.
     */
    public void setBounds(int left, int top, int right, int bottom) {
        getAmBalloon().setBounds(left, top, right, bottom);
    }

    /**
     * Sets coordinates the balloon should point to.
     */
    public void setPosition(int x, int y) {
        getAmBalloon().setPosition(x, y);
    }

    public AmBalloon getAmBalloon() {
        if (balloon == null) {
            balloon = new AmBalloon();
        }
        return balloon;
    }
}
