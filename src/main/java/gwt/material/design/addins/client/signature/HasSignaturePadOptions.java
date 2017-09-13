package gwt.material.design.addins.client.signature;

public interface HasSignaturePadOptions {

    double getDotSize();

    /**
     * Set the radius of a single dot.
     */
    void setDotSize(double dotSize);

    double getLineMinWidth();

    /**
     * Set the minimum width of a line. Defaults to 0.5.
     */
    void setLineMinWidth(double lineMinWidth);

    double getLineMaxWidth();

    /**
     * Set the maximum width of a line. Defaults to 2.5.
     */
    void setLineMaxWidth(double lineMaxWidth);

    int getThrottle();

    /**
     * Draw the next point at most once per every x milliseconds. Set it to 0 to turn off throttling. Defaults to 16.
     */
    void setThrottle(int throttle);

    String getPenColor();

    /**
     * Color used to draw the lines. Can be any color format accepted by context.fillStyle. Defaults to "black".
     */
    void setPenColor(String penColor);

    double getVelocityFilterWeight();

    /**
     * Weight used to modify new velocity based on the previous velocity. Defaults to 0.7.
     */
    void setVelocityFilterWeight(double velocityFilterWeight);

    /**
     * Clears the signature pad canvas
     */
    void clear();

    /**
     * Returns true if canvas is empty, otherwise returns false
     */
    boolean isEmpty();

    /**
     * Returns signature image as data URL
     */
    String toDataUrl();

    /**
     * Draws signature image from data URL.
     */
    void fromDataUrl(String url);
}
