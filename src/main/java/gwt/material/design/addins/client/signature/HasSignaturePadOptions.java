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
