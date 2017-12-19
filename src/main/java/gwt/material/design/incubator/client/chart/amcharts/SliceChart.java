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

    @Override
    public void setAccessibleLabel(String accessibleLabel) {
        getChart().accessibleLabel = accessibleLabel;
    }

    @Override
    public void setAlpha(double alpha) {
        getChart().alpha = alpha;
    }

    @Override
    public void setAlphaField(String alphaField) {
        getChart().alphaField = alphaField;
    }

    @Override
    public void setBaseColor(String baseColor) {
        getChart().baseColor = baseColor;
    }

    @Override
    public void setBrightnessStep(int brightnessStep) {
        getChart().brightnessStep = brightnessStep;
    }

    @Override
    public void setChartData(Object... chartData) {
        getChart().chartData = chartData;
    }

    @Override
    public void setClassNameField(String classNameField) {
        getChart().classNameField = classNameField;
    }

    @Override
    public void setColorField(String colorField) {
        getChart().colorField = colorField;
    }

    @Override
    public void setColors(String... colors) {
        getChart().colors = colors;
    }

    @Override
    public void setDescriptionField(String descriptionField) {
        getChart().descriptionField = descriptionField;
    }

    @Override
    public void setGradientRatio(Double... gradientRatio) {
        getChart().gradientRatio = gradientRatio;
    }

    @Override
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
