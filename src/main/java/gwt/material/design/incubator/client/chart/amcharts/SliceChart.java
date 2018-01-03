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
package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.AbstractChart;
import gwt.material.design.incubator.client.chart.amcharts.base.ISliceChart;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.AnimationEffect;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmSlicedChart;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Extension for {@link AbstractChart} and base class of {@link PieChart} and {@link FunnelChart}. It can not be
 * instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmSlicedChart">Official Documentation</a>
 */
//@formatter:on
public abstract class SliceChart extends AbstractChart implements ISliceChart {

    public SliceChart(ChartType chartType) {
        super(chartType);
    }

    /**
     * Text which screen readers will read if user rolls-over the slice or sets focus using tab key (this is possible
     * only if tabIndex property of AmSlicedChart is set to some number). Text is added as aria-label tag. Note - not
     * all screen readers and browsers support this. Default to [[title]]: [[percents]]% [[value]] [[description]]
     */
    public void setAccessibleLabel(String accessibleLabel) {
        getChart().accessibleLabel = accessibleLabel;
    }

    /**
     * Opacity of all slices. Default to 1
     */
    public void setAlpha(double alpha) {
        getChart().alpha = alpha;
    }

    /**
     * Name of the field in chart's dataProvider which holds slice's alpha.
     */
    public void setAlphaField(String alphaField) {
        getChart().alphaField = alphaField;
    }

    /**
     * Color of the first slice. All the other will be colored with darker or brighter colors. Use brightnessStep to
     * set intensity of color change for each subsequent slice.
     */
    public void setBaseColor(String baseColor) {
        getChart().baseColor = baseColor;
    }

    /**
     * If you set baseColor to some color, the chart will not use colors array to color each slice but rather this
     * setting to color the first slice with gradually increasing (or decreasing) brightness for each subsequent slice.
     * This setting describes the intensity of each step. Set to positive number to make the color brighter with each
     * slice. Set to negative to make the colors darker for subsequent slices. Default to 20
     */
    public void setBrightnessStep(int brightnessStep) {
        getChart().brightnessStep = brightnessStep;
    }

    /**
     * Read-only. Array of Slice objects.
     */
    public void setChartData(Object... chartData) {
        getChart().chartData = chartData;
    }

    /**
     * If this field is set and addClassNames is enabled, the slice element will have this class name set.
     */
    public void setClassNameField(String classNameField) {
        getChart().classNameField = classNameField;
    }

    /**
     * Name of the field in chart's dataProvider which holds slice's color.
     */
    public void setColorField(String colorField) {
        getChart().colorField = colorField;
    }

    /**
     * Specifies the colors of the slices, if the slice color is not set. If there are more slices than colors in this
     * array, the chart picks random color.
     */
    public void setColors(String... colors) {
        getChart().colors = colors;
    }

    /**
     * Name of the field in chart's dataProvider which holds a string with description.
     */
    public void setDescriptionField(String descriptionField) {
        getChart().descriptionField = descriptionField;
    }

    /**
     * Example: [-0.2, 0, -0.2]. Will make slices to be filled with color gradients. Negative value means the color
     * will be darker than the original, and positive number means the color will be lighter.
     */
    public void setGradientRatio(Double... gradientRatio) {
        getChart().gradientRatio = gradientRatio;
    }

    /**
     * Opacity of the group slice. Value range is 0 - 1. Default to 1
     */
    public void setGroupedAlpha(double groupedAlpha) {
        getChart().groupedAlpha = groupedAlpha;
    }

    @Override
    public void setGroupedColor(String groupedColor) {
        getChart().groupedColor = groupedColor;
    }

    @Override
    public void setGroupedDescription(String groupedDescription) {
        getChart().groupedDescription = groupedDescription;
    }

    @Override
    public void setGroupedPulled(boolean groupedPulled) {
        getChart().groupedPulled = groupedPulled;
    }

    @Override
    public void setGroupedTitle(String groupedTitle) {
        getChart().groupedTitle = groupedTitle;
    }

    @Override
    public void setGroupPercent(int groupPercent) {
        getChart().groupPercent = groupPercent;
    }

    @Override
    public void setHideLabelsPercent(int hideLabelsPercent) {
        getChart().hideLabelsPercent = hideLabelsPercent;
    }

    @Override
    public void setHoverAlpha(double hoverAlpha) {
        getChart().hoverAlpha = hoverAlpha;
    }

    @Override
    public void setLabelColorField(String labelColorField) {
        getChart().labelColorField = labelColorField;
    }

    @Override
    public void setLabelFunction(Functions.Func labelFunction) {
        getChart().labelFunction = labelFunction;
    }

    @Override
    public void setLabelsEnabled(boolean labelsEnabled) {
        getChart().labelsEnabled = labelsEnabled;
    }

    @Override
    public void setLabelTickAlpha(double labelTickAlpha) {
        getChart().labelTickAlpha = labelTickAlpha;
    }

    @Override
    public void setLabelTickColor(String labelTickColor) {
        getChart().labelTickColor = labelTickColor;
    }

    @Override
    public void setMarginBottom(int marginBottom) {
        getChart().marginBottom = marginBottom;
    }

    @Override
    public void setMarginLeft(int marginLeft) {
        getChart().marginLeft = marginLeft;
    }

    @Override
    public void setMarginRight(int marginRight) {
        getChart().marginRight = marginRight;
    }

    @Override
    public void setMarginTop(int marginTop) {
        getChart().marginTop = marginTop;
    }

    @Override
    public void setMaxLabelWidth(int maxLabelWidth) {
        getChart().maxLabelWidth = maxLabelWidth;
    }

    @Override
    public void setOutlineAlpha(double outlineAlpha) {
        getChart().outlineAlpha = outlineAlpha;
    }

    @Override
    public void setOutlineColor(String outlineColor) {
        getChart().outlineColor = outlineColor;
    }

    @Override
    public void setOutlineThickness(int outlineThickness) {
        getChart().outlineThickness = outlineThickness;
    }

    @Override
    public void setPatternField(String patternField) {
        getChart().patternField = patternField;
    }

    @Override
    public void setPulledField(String pulledField) {
        getChart().pulledField = pulledField;
    }

    @Override
    public void setPullOutDuration(int pullOutDuration) {
        getChart().pullOutDuration = pullOutDuration;
    }

    @Override
    public void setPullOutEffect(String pullOutEffect) {
        getChart().pullOutEffect = pullOutEffect;
    }

    @Override
    public void setPullOutOnlyOne(boolean pullOutOnlyOne) {
        getChart().pullOutOnlyOne = pullOutOnlyOne;
    }

    @Override
    public void setSequencedAnimation(boolean sequencedAnimation) {
        getChart().sequencedAnimation = sequencedAnimation;
    }

    @Override
    public void setShowZeroSlices(boolean showZeroSlices) {
        getChart().showZeroSlices = showZeroSlices;
    }

    @Override
    public void setStartAlpha(double startAlpha) {
        getChart().startAlpha = startAlpha;
    }

    @Override
    public void setStartDuration(int startDuration) {
        getChart().startDuration = startDuration;
    }

    @Override
    public void setStartEffect(AnimationEffect startEffect) {
        getChart().startEffect = startEffect.getName();
    }

    @Override
    public void setTitleField(String titleField) {
        getChart().titleField = titleField;
    }

    @Override
    public void setUrlField(String urlField) {
        getChart().urlField = urlField;
    }

    @Override
    public void setUrlTarget(String urlTarget) {
        getChart().urlTarget = urlTarget;
    }

    @Override
    public void setValueField(String valueField) {
        getChart().valueField = valueField;
    }

    @Override
    public void setVisibleInLegendField(String visibleInLegendField) {
        getChart().visibleInLegendField = visibleInLegendField;
    }

    @Override
    public void animateAgain() {
        getChart().animateAgain();
    }

    @Override
    public void clickSlice(Object slice) {
        getChart().clickSlice(slice);
    }

    @Override
    public void hideSlice(Object slice) {
        getChart().hideSlice(slice);
    }

    @Override
    public void rollOutSlice(Object slice) {
        getChart().rollOutSlice(slice);
    }

    @Override
    public void rollOverSlice(Object slice) {
        getChart().rollOverSlice(slice);
    }

    @Override
    public void showSlice(Object slice) {
        getChart().showSlice(slice);
    }

    @Override
    public abstract AmSlicedChart getChart();
}
