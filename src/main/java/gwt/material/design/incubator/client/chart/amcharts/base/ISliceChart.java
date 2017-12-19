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

import gwt.material.design.incubator.client.chart.amcharts.base.constants.AnimationEffect;
import gwt.material.design.jquery.client.api.Functions;

public interface ISliceChart {

    /**
     * Text which screen readers will read if user rolls-over the slice or sets focus using tab key (this is possible
     * only if tabIndex property of AmSlicedChart is set to some number). Text is added as aria-label tag. Note - not
     * all screen readers and browsers support this. Default to [[title]]: [[percents]]% [[value]] [[description]]
     */
    void setAccessibleLabel(String accessibleLabel);

    /**
     * Opacity of all slices. Default to 1
     */
    void setAlpha(double alpha);

    /**
     * Name of the field in chart's dataProvider which holds slice's alpha.
     */
    void setAlphaField(String alphaField);

    /**
     * Color of the first slice. All the other will be colored with darker or brighter colors. Use brightnessStep to
     * set intensity of color change for each subsequent slice.
     */
    void setBaseColor(String baseColor);

    /**
     * If you set baseColor to some color, the chart will not use colors array to color each slice but rather this
     * setting to color the first slice with gradually increasing (or decreasing) brightness for each subsequent slice.
     * This setting describes the intensity of each step. Set to positive number to make the color brighter with each
     * slice. Set to negative to make the colors darker for subsequent slices. Default to 20
     */
    void setBrightnessStep(int brightnessStep);

    /**
     * Read-only. Array of Slice objects.
     */
    void setChartData(Object... data);

    /**
     * If this field is set and addClassNames is enabled, the slice element will have this class name set.
     */
    void setClassNameField(String classNameField);

    /**
     * Name of the field in chart's dataProvider which holds slice's color.
     */
    void setColorField(String colorField);

    /**
     * Specifies the colors of the slices, if the slice color is not set. If there are more slices than colors in this
     * array, the chart picks random color.
     */
    void setColors(String... colors);

    /**
     * Name of the field in chart's dataProvider which holds a string with description.
     */
    void setDescriptionField(String descriptionField);

    /**
     * Example: [-0.2, 0, -0.2]. Will make slices to be filled with color gradients. Negative value means the color
     * will be darker than the original, and positive number means the color will be lighter.
     */
    void setGradientRatio(Double... gradientRatio);

    /**
     * Opacity of the group slice. Value range is 0 - 1. Default to 1
     */
    void setGroupedAlpha(double groupedAlpha);

    /**
     * Color of the group slice. The default value is not set - this means the next available color from "colors"
     * array will be used.
     */
    void setGroupedColor(String groupedColor);

    /**
     * Description of the group slice.
     */
    void setGroupedDescription(String groupedDescription);

    /**
     * If this is set to true, the group slice will be pulled out when the chart loads. Default to false
     */
    void setGroupedPulled(boolean groupedPulled);

    /**
     * Title of the group slice.
     */
    void setGroupedTitle(String groupedTitle);

    /**
     * If there is more than one slice whose percentage of the pie is less than this number, those slices will be
     * grouped together into one slice. This is the "other" slice. It will always be the last slice in a pie.
     * Default to 0
     */
    void setGroupPercent(int groupPercent);

    /**
     * Slices with percent less then hideLabelsPercent won't display labels This is useful to avoid cluttering up
     * the chart, if you have a lot of small slices. 0 means all labels will be shown. Default to 0
     */
    void setHideLabelsPercent(int hideLabelsPercent);

    /**
     * Opacity of a hovered slice. Value range is 0 - 1. Default to 1
     */
    void setHoverAlpha(double hoverAlpha);

    /**
     * A field in data which holds color value for the tick. Use it to set color of the label for each slice
     * individually. Default to #000000
     */
    void setLabelColorField(String labelColorField);

    /**
     * You can use it to format data labels in any way you want. Chart will call this method and will pass Slice object
     * and formatted text as attributes. This function should return string which will be displayed as label.
     */
    void setLabelFunction(Functions.Func labelFunction);

    /**
     * Specifies whether data labels are visible. Default to true
     */
    void setLabelsEnabled(boolean labelsEnabled);

    /**
     * Label tick opacity. Value range is 0 - 1. Default to 0.2
     */
    void setLabelTickAlpha(double labelTickAlpha);

    /**
     * Label tick color. Default to #000000
     */
    void setLabelTickColor(String labelTickColor);

    /**
     * Bottom margin of the chart. Default to 10
     */
    void setMarginBottom(int marginBottom);

    /**
     * Left margin of the chart. Default to 0
     */
    void setMarginLeft(int marginLeft);

    /**
     * Right margin of the chart. Default to 0
     */
    void setMarginRight(int marginRight);

    /**
     * Top margin of the chart. Default to 10
     */
    void setMarginTop(int marginTop);

    /**
     * If width of the label is bigger than maxLabelWidth, it will be wrapped. Default to 200
     */
    void setMaxLabelWidth(int maxLabelWidth);

    /**
     * Outline opacity. Value range is 0 - 1. Default to 0
     */
    void setOutlineAlpha(double outlineAlpha);

    /**
     * Outline color. Default to #FFFFFF
     */
    void setOutlineColor(String outlineColor);

    /**
     * Pie outline thickness. Default to 1
     */
    void setOutlineThickness(int outlineThickness);

    /**
     * Field name in your data provider which holds pattern information. Value of pattern should be object with url,
     * width, height of an image, optionally it might have x, y, randomX and randomY values. For example:
     * {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}. Check amcharts/patterns folder for
     * some patterns. You can create your own patterns and use them. Note, x, y, randomX and randomY properties won't
     * work with IE8 and older. 3D bar/Pie charts won't work properly with patterns.
     */
    void setPatternField(String patternField);

    /**
     * Name of the field in chart's dataProvider which holds a boolean value telling the chart whether this slice must
     * be pulled or not.
     */
    void setPulledField(String pulledField);

    /**
     * Pull out duration, in seconds. Default to 1
     */
    void setPullOutDuration(int pullOutDuration);

    /**
     * Pull out effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "bounce"
     */
    void setPullOutEffect(String pullOutEffect);

    /**
     * If this is set to true, only one slice can be pulled out at a time. If the viewer clicks on a slice, any other
     * pulled-out slice will be pulled in. Default to false
     */
    void setPullOutOnlyOne(boolean pullOutOnlyOne);

    /**
     * Specifies whether the animation should be sequenced or all slices should appear at once. Default to true
     */
    void setSequencedAnimation(boolean sequencedAnimation);

    /**
     * If you set this to true, the chart will display outlines (if visible) and labels for slices even if their value
     * is 0. Default to false
     */
    void setShowZeroSlices(boolean showZeroSlices);

    /**
     * Initial opacity of all slices. Slices will fade in from startAlpha. Default to 0
     */
    void setStartAlpha(double startAlpha);

    /**
     * Duration of the animation, in seconds. Default to 1
     */
    void setStartDuration(int startDuration);

    /**
     * Animation effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "bounce"
     */
    void setStartEffect(AnimationEffect startEffect);

    /**
     * In case you set it to some number, the chart will set focus on a slice (starting from first) when user clicks
     * tab key. When a focus is set, screen readers like NVDA Screen reader will read label which is set using
     * accessibleLabel property of AmSlicedChart. Note, not all browsers and readers support this.
     */
    void setTabIndex(int tabIndex);

    /**
     * Name of the field in chart's dataProvider which holds slice's title.
     */
    void setTitleField(String titleField);

    /**
     * Name of the field in chart's dataProvider which holds url which would be accessed if the user clicks on a slice.
     */
    void setUrlField(String urlField);

    /**
     * If url is specified for a slice, it will be opened when user clicks on it. urlTarget specifies target of this url.
     * Use _blank if you want url to be opened in a new window. Default to _self
     */
    void setUrlTarget(String urlTarget);

    /**
     * Name of the field in chart's dataProvider which holds slice's value.
     */
    void setValueField(String valueField);

    /**
     * Use this field to selectively specify which slice is shown in legend. It should be set to a boolean field in
     * data (that holds either true or false). For example if you set visibleInLegendField to "showInLegend", all slices
     * that have showInLegend: false in their data will not be shown in the legend.
     */
    void setVisibleInLegendField(String visibleInLegendField);

    /**
     * You can trigger the animation of the chart.
     */
    void animateAgain();

    /**
     * You can trigger the click on a slice from outside.
     */
    void clickSlice(Object slice);

    /**
     * Hides slice.
     */
    void hideSlice(Object slice);

    /**
     * You can simulate roll-out of a slice from outside.
     */
    void rollOutSlice(Object slice);

    /**
     * You can simulate roll-over a slice from outside.
     */
    void rollOverSlice(Object slice);

    /**
     * Shows slice.
     */
    void showSlice(Object slice);

    // TODO Events
    /**
     * Dispatched when user clicks on a slice. Event is an instance of original mouse event.
     *//*
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> clickSlide;

    *//**
     * Dispatched when user clicks on a slice and the slice is pulled-in. Event is an instance of original mouse event.
     *//*
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> pullInSlice;

    *//**
     * Dispatched when user clicks on a slice and the slice is pulled-out. Event is an instance of original mouse event.
     *//*
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> pullOutSlice;

    *//**
     * Dispatched when user right-clicks the slice. Event is an instance of original mouse event.
     *//*
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> rightClickSlice;

    *//**
     * Dispatched when user rolls-out of the slice. Event is an instance of original mouse event.
     *//*
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> rollOutSlice;

    *//**
     * Dispatched when user rolls-over the slice. Event is an instance of original mouse event.
     *//*
    @JsProperty
    public Functions.EventFunc3<String, Slice, MouseEvent> rollOverSlice;*/
}
