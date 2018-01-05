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

import gwt.material.design.incubator.client.chart.amcharts.js.AmAngularGauge;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGaugeBand;
import gwt.material.design.jquery.client.api.MouseEvent;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GaugeAxisData {

    @JsProperty
    private String type;

    @JsProperty
    private AmGaugeBand dataItem;

    @JsProperty
    private AmAngularGauge chart;

    @JsProperty
    private MouseEvent event;

    @JsOverlay
    public final String getType() {
        return type;
    }

    @JsOverlay
    public final AmGaugeBand getDataItem() {
        return dataItem;
    }

    @JsOverlay
    public final AmAngularGauge getChart() {
        return chart;
    }

    @JsOverlay
    public final MouseEvent getEvent() {
        return event;
    }
}
