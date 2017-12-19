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
package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.jquery.client.api.Functions;

public interface IPieChart {

    /**
     * Sometimes, because of a rounding, percent of a sum of all slices is not equal to 100%. If you set this to true,
     * when this case happens, number of decimals will be increased so that sum would become 100%. Default to false
     */
    void setAdjustPrecision(boolean adjustPrecision);

    /**
     * Pie lean angle (for 3D effect). Valid range is 0 - 90. Default to 0
     */
    void setAngle(int angle);

    /**
     * If you set some function, the graph will call it and pass
     * {@link gwt.material.design.incubator.client.chart.amcharts.js.options.GraphDataItem} object to it. This function
     * should return a string which will be displayed in a balloon.
     */
    void setBalloonFunction(Functions.Func function);

    /**
     * Balloon text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider. HTML tags can also be used.
     * Default to [[title]]: [[percents]]% ([[value]])\n[[description]]
     */
    void setBalloonText(String balloonText);

    /**
     * Depth of the pie (for 3D effect). Default to 0
     */
    void setDepth3D(int depth3D);

    /**
     * Type of gradient. Use gradientRatio to create gradients. Default to radial
     */
    void setGradientType(String gradientType);

    /**
     * Inner radius of the pie, in pixels or percents. Default to 0
     */
    void setInnerRadius(int innerRadius);

    /**
     * The distance between the label and the slice, in pixels. You can use negative values to put the label on
     * the slice. Default to 20
     */
    void setLabelRadius(int labelRadius);

    /**
     * Name of the field in dataProvider which specifies the length of a tick. Note, the chart will not try to arrange
     * labels automatically if this property is set.
     */
    void setLabelRadiusField(String labelRadiusField);

    /**
     * Label text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider. Default to [[title]]: [[percents]]%
     */
    void setLabelText(String labelText);

    /**
     * Minimum radius of the pie, in pixels. Default to 10
     */
    void setMinRadius(int minRadius);

    /**
     * You can set fixed position of a pie center, in pixels or in percents.
     */
    void setPieX(Object pieX);

    /**
     * You can set fixed position of a pie center, in pixels or in percents.
     */
    void setPieY(Object pieY);

    /**
     * Pull out radius, in pixels or percents. Default to 20%
     */
    void setPullOutRadius(Object pullOutRadius);

    /**
     * Radius of a pie, in pixels or percents. By default, radius is calculated automatically.
     */
    void setRadius(Object radius);

    /**
     * Angle of the first slice, in degrees. This will work properly only if "depth3D" is set to 0. If "depth3D" is
     * greater than 0, then there can be two angles only: 90 and 270. Value range is 0-360. Default to 90
     */
    void setStartAngle(Object startAngle);

    /**
     * Radius of the positions from which the slices will fly in. Default to 500%
     */
    void setStartRadius(Object startRadius);
}
