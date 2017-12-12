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
package gwt.material.design.incubator.client.chart.chartjs.js.datasets;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ChartDataSets {

    @JsProperty
    private String label;

    @JsProperty
    private Object[] data;

    @JsOverlay
    public final String getLabel() {
        return label;
    }

    /**
     * The label for the dataset which appears in the legend and tooltips.
     */
    @JsOverlay
    public void setLabel(String label) {
        this.label = label;
    }

    @JsOverlay
    public final Object[] getData() {
        return data;
    }

    @JsOverlay
    public final void setData(Object... data) {
        this.data = data;
    }

}
