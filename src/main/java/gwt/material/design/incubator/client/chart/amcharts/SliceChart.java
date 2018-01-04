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
import gwt.material.design.incubator.client.chart.amcharts.base.HasSliceChartHandlers;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.AnimationEffect;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.events.*;
import gwt.material.design.incubator.client.chart.amcharts.events.object.SliceEventData;
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
public abstract class SliceChart extends AbstractChart implements HasSliceChartHandlers {

    public SliceChart(ChartType chartType) {
        super(chartType);
    }

    @Override
    public void load() {
        super.load();

        addListener(AmChartEvents.CLICK_SLICE, object -> ClickSliceEvent.fire(this, (SliceEventData) object));
        addListener(AmChartEvents.PULL_IN_SLICE, object -> PullInSliceEvent.fire(this, (SliceEventData) object));
        addListener(AmChartEvents.PULL_OUT_SLICE, object -> PullOutSliceEvent.fire(this, (SliceEventData) object));
        addListener(AmChartEvents.RIGHT_CLICK_SLICE, object -> RightClickSliceEvent.fire(this, (SliceEventData) object));
        addListener(AmChartEvents.ROLL_OUT_SLICE, object -> RollOutSliceEvent.fire(this, (SliceEventData) object));
        addListener(AmChartEvents.ROLL_OVER_SLICE, object -> RollOverSliceEvent.fire(this, (SliceEventData) object));
    }

    @Override
    public void unload() {
        super.unload();

        // TODO Unload Events
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
     * Read-only. Array of AmSlice objects.
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

    /**
     * Color of the group slice. The default value is not set - this means the next available color from "colors"
     * array will be used.
     */
    public void setGroupedColor(String groupedColor) {
        getChart().groupedColor = groupedColor;
    }

    /**
     * Description of the group slice.
     */
    public void setGroupedDescription(String groupedDescription) {
        getChart().groupedDescription = groupedDescription;
    }

    /**
     * If this is set to true, the group slice will be pulled out when the chart loads. Default to false
     */
    public void setGroupedPulled(boolean groupedPulled) {
        getChart().groupedPulled = groupedPulled;
    }

    /**
     * Title of the group slice.
     */
    public void setGroupedTitle(String groupedTitle) {
        getChart().groupedTitle = groupedTitle;
    }

    /**
     * If there is more than one slice whose percentage of the pie is less than this number, those slices will be
     * grouped together into one slice. This is the "other" slice. It will always be the last slice in a pie.
     * Default to 0
     */
    public void setGroupPercent(int groupPercent) {
        getChart().groupPercent = groupPercent;
    }

    /**
     * Slices with percent less then hideLabelsPercent won't display labels This is useful to avoid cluttering up
     * the chart, if you have a lot of small slices. 0 means all labels will be shown. Default to 0
     */
    public void setHideLabelsPercent(int hideLabelsPercent) {
        getChart().hideLabelsPercent = hideLabelsPercent;
    }

    /**
     * Opacity of a hovered slice. Value range is 0 - 1. Default to 1
     */
    public void setHoverAlpha(double hoverAlpha) {
        getChart().hoverAlpha = hoverAlpha;
    }

    /**
     * A field in data which holds color value for the tick. Use it to set color of the label for each slice
     * individually. Default to #000000
     */
    public void setLabelColorField(String labelColorField) {
        getChart().labelColorField = labelColorField;
    }

    /**
     * You can use it to format data labels in any way you want. Chart will call this method and will pass AmSlice object
     * and formatted text as attributes. This function should return string which will be displayed as label.
     */
    public void setLabelFunction(Functions.Func labelFunction) {
        getChart().labelFunction = labelFunction;
    }

    /**
     * Specifies whether data labels are visible. Default to true
     */
    public void setLabelsEnabled(boolean labelsEnabled) {
        getChart().labelsEnabled = labelsEnabled;
    }

    /**
     * Label tick opacity. Value range is 0 - 1. Default to 0.2
     */
    public void setLabelTickAlpha(double labelTickAlpha) {
        getChart().labelTickAlpha = labelTickAlpha;
    }

    /**
     * Label tick color. Default to #000000
     */
    public void setLabelTickColor(String labelTickColor) {
        getChart().labelTickColor = labelTickColor;
    }

    /**
     * Bottom margin of the chart. Default to 10
     */
    public void setMarginBottom(int marginBottom) {
        getChart().marginBottom = marginBottom;
    }

    /**
     * Left margin of the chart. Default to 0
     */
    public void setMarginLeft(int marginLeft) {
        getChart().marginLeft = marginLeft;
    }

    /**
     * Right margin of the chart. Default to 0
     */
    public void setMarginRight(int marginRight) {
        getChart().marginRight = marginRight;
    }

    /**
     * Top margin of the chart. Default to 10
     */
    public void setMarginTop(int marginTop) {
        getChart().marginTop = marginTop;
    }

    /**
     * If width of the label is bigger than maxLabelWidth, it will be wrapped. Default to 200
     */
    public void setMaxLabelWidth(int maxLabelWidth) {
        getChart().maxLabelWidth = maxLabelWidth;
    }

    /**
     * Outline opacity. Value range is 0 - 1. Default to 0
     */
    public void setOutlineAlpha(double outlineAlpha) {
        getChart().outlineAlpha = outlineAlpha;
    }

    /**
     * Outline color. Default to #FFFFFF
     */
    public void setOutlineColor(String outlineColor) {
        getChart().outlineColor = outlineColor;
    }

    /**
     * Pie outline thickness. Default to 1
     */
    public void setOutlineThickness(int outlineThickness) {
        getChart().outlineThickness = outlineThickness;
    }

    /**
     * Field name in your data provider which holds pattern information. Value of pattern should be object with url,
     * width, height of an image, optionally it might have x, y, randomX and randomY values. For example:
     * {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}. Check amcharts/patterns folder for
     * some patterns. You can create your own patterns and use them. Note, x, y, randomX and randomY properties won't
     * work with IE8 and older. 3D bar/Pie charts won't work properly with patterns.
     */
    public void setPatternField(String patternField) {
        getChart().patternField = patternField;
    }

    /**
     * Name of the field in chart's dataProvider which holds a boolean value telling the chart whether this slice must
     * be pulled or not.
     */
    public void setPulledField(String pulledField) {
        getChart().pulledField = pulledField;
    }

    /**
     * Pull out duration, in seconds. Default to 1
     */
    public void setPullOutDuration(int pullOutDuration) {
        getChart().pullOutDuration = pullOutDuration;
    }

    /**
     * Pull out effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "bounce"
     */
    public void setPullOutEffect(String pullOutEffect) {
        getChart().pullOutEffect = pullOutEffect;
    }

    /**
     * If this is set to true, only one slice can be pulled out at a time. If the viewer clicks on a slice, any other
     * pulled-out slice will be pulled in. Default to false
     */
    public void setPullOutOnlyOne(boolean pullOutOnlyOne) {
        getChart().pullOutOnlyOne = pullOutOnlyOne;
    }

    /**
     * Specifies whether the animation should be sequenced or all slices should appear at once. Default to true
     */
    public void setSequencedAnimation(boolean sequencedAnimation) {
        getChart().sequencedAnimation = sequencedAnimation;
    }

    /**
     * If you set this to true, the chart will display outlines (if visible) and labels for slices even if their value
     * is 0. Default to false
     */
    public void setShowZeroSlices(boolean showZeroSlices) {
        getChart().showZeroSlices = showZeroSlices;
    }

    /**
     * Initial opacity of all slices. Slices will fade in from startAlpha. Default to 0
     */
    public void setStartAlpha(double startAlpha) {
        getChart().startAlpha = startAlpha;
    }

    /**
     * Duration of the animation, in seconds. Default to 1
     */
    public void setStartDuration(int startDuration) {
        getChart().startDuration = startDuration;
    }

    /**
     * Animation effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "bounce"
     */
    public void setStartEffect(AnimationEffect startEffect) {
        getChart().startEffect = startEffect.getName();
    }

    /**
     * Name of the field in chart's dataProvider which holds slice's title.
     */
    public void setTitleField(String titleField) {
        getChart().titleField = titleField;
    }

    /**
     * Name of the field in chart's dataProvider which holds url which would be accessed if the user clicks on a slice.
     */
    public void setUrlField(String urlField) {
        getChart().urlField = urlField;
    }

    /**
     * If url is specified for a slice, it will be opened when user clicks on it. urlTarget specifies target of this url.
     * Use _blank if you want url to be opened in a new window. Default to _self
     */
    public void setUrlTarget(String urlTarget) {
        getChart().urlTarget = urlTarget;
    }

    /**
     * Name of the field in chart's dataProvider which holds slice's value.
     */
    public void setValueField(String valueField) {
        getChart().valueField = valueField;
    }

    /**
     * Use this field to selectively specify which slice is shown in legend. It should be set to a boolean field in
     * data (that holds either true or false). For example if you set visibleInLegendField to "showInLegend", all slices
     * that have showInLegend: false in their data will not be shown in the legend.
     */
    public void setVisibleInLegendField(String visibleInLegendField) {
        getChart().visibleInLegendField = visibleInLegendField;
    }

    /**
     * You can trigger the animation of the chart.
     */
    public void animateAgain() {
        getChart().animateAgain();
    }

    /**
     * You can trigger the click on a slice from outside.
     */
    public void clickSlice(Object slice) {
        getChart().clickSlice(slice);
    }

    /**
     * Hides slice.
     */
    public void hideSlice(Object slice) {
        getChart().hideSlice(slice);
    }

    /**
     * You can simulate roll-out of a slice from outside.
     */
    public void rollOutSlice(Object slice) {
        getChart().rollOutSlice(slice);
    }

    /**
     * You can simulate roll-over a slice from outside.
     */
    public void rollOverSlice(Object slice) {
        getChart().rollOverSlice(slice);
    }

    /**
     * Shows slice.
     */
    public void showSlice(Object slice) {
        getChart().showSlice(slice);
    }

    @Override
    public abstract AmSlicedChart getChart();

    @Override
    public void addClickSliceHandler(ClickSliceEvent.ClickSliceHandler handler) {
        addHandler(handler, ClickSliceEvent.getType());
    }

    @Override
    public void addPullInSliceHandler(PullInSliceEvent.PullInSliceHandler handler) {
        addHandler(handler, PullInSliceEvent.getType());
    }

    @Override
    public void addPullOutSliceHandler(PullOutSliceEvent.PullOutSliceHandler handler) {
        addHandler(handler, PullOutSliceEvent.getType());
    }

    @Override
    public void addRightClickSliceHandler(RightClickSliceEvent.RightClickSliceHandler handler) {
        addHandler(handler, RightClickSliceEvent.getType());
    }

    @Override
    public void addRollOutSliceHandler(RollOutSliceEvent.RollOutSliceHandler handler) {
        addHandler(handler, RollOutSliceEvent.getType());
    }

    @Override
    public void addRollOverSliceHandler(RollOverSliceEvent.RollOverSliceHandler handler) {
        addHandler(handler, RollOverSliceEvent.getType());
    }
}
