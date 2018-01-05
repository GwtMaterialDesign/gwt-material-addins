/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.chart.amcharts.events.object;

import gwt.material.design.incubator.client.chart.amcharts.js.AmChart;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class SerialZoomedData {

    @JsProperty
    private Date endDate;

    @JsProperty
    private int endIndex;

    @JsProperty
    private String endValue;

    @JsProperty
    private Date startDate;

    @JsProperty
    private int startIndex;

    @JsProperty
    private String startValue;

    @JsProperty
    private AmChart chart;

    @JsOverlay
    public final Date getEndDate() {
        return endDate;
    }

    @JsOverlay
    public final int getEndIndex() {
        return endIndex;
    }

    @JsOverlay
    public final String getEndValue() {
        return endValue;
    }

    @JsOverlay
    public final Date getStartDate() {
        return startDate;
    }

    @JsOverlay
    public final int getStartIndex() {
        return startIndex;
    }

    @JsOverlay
    public final String getStartValue() {
        return startValue;
    }

    @JsOverlay
    public final AmChart getChart() {
        return chart;
    }
}
