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
package gwt.material.design.incubator.client.chart.chartjs.js;

import com.google.gwt.canvas.dom.client.Context2d;
import gwt.material.design.incubator.client.chart.chartjs.js.options.GlobalOptions;
import gwt.material.design.jquery.client.api.Event;
import gwt.material.design.jscore.client.api.core.Element;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import java.util.List;

/**
 * JSInterop utils for ChartJs
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="http://www.chartjs.org/docs/latest/developers/api.html">ChartJs API</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Chart {

    public Chart(Context2d context, GlobalOptions options) {}

    public Chart(com.google.gwt.dom.client.Element element, GlobalOptions options) {}

    @JsMethod
    public native void destroy();

    @JsMethod
    public native void update(GlobalOptions options);

    @JsMethod
    public native void reset();

    @JsMethod
    public native void render(GlobalOptions options);

    @JsMethod
    public native void stop();

    @JsMethod
    public native void resize();

    @JsMethod
    public native void clear();

    @JsMethod
    public native String toBase64Image();

    @JsMethod
    public native String generateLegend();

    @JsMethod
    public native Element getElementAtEvent(Event event);

    @JsMethod
    public native List<Element> getElementsAtEvent(Event event);

    @JsMethod
    public native List<Element> getDatasetAtEvent(Event event);

    @JsMethod
    public native Object getDatasetMeta(int index);
}
