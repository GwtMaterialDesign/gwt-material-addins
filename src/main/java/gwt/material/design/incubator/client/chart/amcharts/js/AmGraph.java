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

import gwt.material.design.incubator.client.chart.amcharts.js.options.AmValueAxis;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * JSInterop Util for {@link gwt.material.design.incubator.client.chart.amcharts.options.Graph}
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmGraph">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmGraph {

    @JsProperty
    public String accessibleLabel;

    @JsProperty
    public String alphaField;

    @JsProperty
    public boolean animationPlayed;

    @JsProperty
    public AmBalloon balloon;

    @JsProperty
    public String ballonColor;

    @JsProperty
    public Functions.Func balloonFunction;

    @JsProperty
    public String balloonText;

    @JsProperty
    public boolean behindColumns;

    @JsProperty
    public String bullet;

    @JsProperty
    public int bulletAlpha;

    @JsProperty
    public AmValueAxis bulletAxis;

    @JsProperty
    public int bulletBorderAlpha;

    @JsProperty
    public String bulletBorderColor;

    @JsProperty
    public String bulletBorderThickness;

    @JsProperty
    public String bulletColor;

    @JsProperty
    public String bulletField;

    @JsProperty
    public int bulletHitAreaSize;

    @JsProperty
    public int bulletOffset;

    @JsProperty
    public int bulletSize;

    @JsProperty
    public String bulletSizeField;

    @JsProperty
    public String classNameField;

    @JsProperty
    public String closeField;

    @JsProperty
    public String clustered;

    @JsProperty
    public String color;

    @JsProperty
    public String colorField;

    @JsProperty
    public String columnIndexField;

    @JsProperty
    public String columnWidth;

    @JsProperty
    public boolean connect;

    @JsProperty
    public int cornerRadiusTop;

    @JsProperty
    public int cursorBulletAlpha;

    @JsProperty
    public String customBullet;

    @JsProperty
    public String customBulletField;

    @JsProperty
    public String customMarker;

    @JsProperty
    public int dashLength;

    @JsProperty
    public String dashLengthField;

    @JsProperty
    public String dateFormat;

    @JsProperty
    public String descriptionField;

    @JsProperty
    public String errorField;

    @JsProperty
    public int fillAlphas;

    @JsProperty
    public String fillColors;

    @JsProperty
    public String fillColorsField;

    @JsProperty
    public AmValueAxis fillToAxis;

    @JsProperty
    public AmGraph fillToAmGraph;

    @JsProperty
    public int fixedColumnWidth;

    @JsProperty
    public int fontSize;

    @JsProperty
    public boolean forceGap;

    @JsProperty
    public String gapField;

    @JsProperty
    public double gapPeriod;

    @JsProperty
    public String gradientOrientation;

    @JsProperty
    public boolean hidden;

    @JsProperty
    public int hideBulletsCount;

    @JsProperty
    public String highField;

    @JsProperty
    public String id;

    @JsProperty
    public boolean includeInMinMax;

    @JsProperty
    public String labelAnchor;

    @JsProperty
    public String labelColorField;

    @JsProperty
    public Functions.Func labelFunction;

    @JsProperty
    public int labelOffset;

    @JsProperty
    public String labelPosition;

    @JsProperty
    public int labelRotation;

    @JsProperty
    public String labelText;

    @JsProperty
    public double legendAlpha;

    @JsProperty
    public String legendColor;

    @JsProperty
    public Object legendColorFunction;

    @JsProperty
    public String legendPeriodValueText;

    @JsProperty
    public String legendValueText;

    @JsProperty
    public double lineAlpha;

    @JsProperty
    public String lineColor;

    @JsProperty
    public String lineColorField;

    @JsProperty
    public int lineThickness;

    @JsProperty
    public String lowField;

    @JsProperty
    public String markerType;

    @JsProperty
    public int maxBulletSize;

    @JsProperty
    public int minDistance;

    @JsProperty
    public int negativeBase;

    @JsProperty
    public double negativeFillAlphas;

    @JsProperty
    public String negativeFillColors;

    @JsProperty
    public double negativeLineAlpha;

    @JsProperty
    public String negativeLineColor;

    @JsProperty
    public boolean newStack;

    @JsProperty
    public boolean noStepRisers;

    @JsProperty
    public String openField;

    @JsProperty
    public Object pattern;

    @JsProperty
    public String patternField;

    @JsProperty
    public int periodSpan;

    @JsProperty
    public String pointPosition;

    @JsProperty
    public int precision;

    @JsProperty
    public boolean proCandlesticks;

    @JsProperty
    public Object segmentData;

    @JsProperty
    public boolean showAllValueLabels;

    @JsProperty
    public boolean showBalloon;

    @JsProperty
    public String showBalloonAt;

    @JsProperty
    public String showBulletsAt;

    @JsProperty
    public boolean showHandOnHover;

    @JsProperty
    public boolean showOnAxis;

    @JsProperty
    public boolean stackable;

    @JsProperty
    public String stepDirection;

    @JsProperty
    public boolean switchable;

    @JsProperty
    public int tabIndex;

    @JsProperty
    public String title;

    @JsProperty
    public int topRadius;

    @JsProperty
    public String type;

    @JsProperty
    public String urlField;

    @JsProperty
    public String urlTarget;

    @JsProperty
    public boolean useLineColorForBulletBorder;

    @JsProperty
    public boolean useNegativeColorIfDown;

    @JsProperty
    public AmValueAxis valueAxis;

    @JsProperty
    public String valueField;

    @JsProperty
    public boolean visibleInLegend;

    @JsProperty
    public AmValueAxis xAxis;

    @JsProperty
    public String xField;

    @JsProperty
    public AmValueAxis yAxis;

    @JsProperty
    public String yField;

    @JsMethod
    public native void hideBullets();

    @JsMethod
    public native void showBullets();
}
