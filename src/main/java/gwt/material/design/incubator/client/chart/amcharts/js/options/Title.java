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
package gwt.material.design.incubator.client.chart.amcharts.js.options;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Creates a title on above the chart, multiple can be assigned.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/Title">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Title {

    @JsProperty
    private double alpha;

    @JsProperty
    private boolean bold;

    @JsProperty
    private String color;

    @JsProperty
    private String id;

    @JsProperty
    private int size;

    @JsProperty
    private int tabIndex;

    @JsProperty
    private String text;

    /**
     * Opacity of a title. Default to 1
     */
    @JsOverlay
    public final void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    /**
     * Specifies if title should be bold or not. Default to true
     */
    @JsOverlay
    public final void setBold(boolean bold) {
        this.bold = bold;
    }

    /**
     * Text color of a title.
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    /**
     * Unique id of a Title. You don't need to set it, unless you want to.
     */
    @JsOverlay
    public final void setId(String id) {
        this.id = id;
    }

    /**
     * Text size of a title.
     */
    @JsOverlay
    public final void setSize(int size) {
        this.size = size;
    }

    /**
     * In case you set it to some number, the chart will set focus on the title when user clicks tab key. When a focus
     * is set, screen readers like NVDA Screen reader will read the title. Note, not all browsers and readers support this.
     */
    @JsOverlay
    public final void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    /**
     * Text of a title.
     */
    @JsOverlay
    public final void setText(String text) {
        this.text = text;
    }
}
