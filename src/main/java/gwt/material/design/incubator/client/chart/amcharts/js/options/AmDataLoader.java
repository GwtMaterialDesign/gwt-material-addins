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

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * By default all amCharts libraries accept data in JSON format. It needs to be there when the web page loads, defined
 * in-line or loaded via custom code.
 * <p>
 * This plugin introduces a native wrapper that enables automatic loading of data from external data data sources in
 * CSV and JSON formats.
 * <p>
 * Most of the times you will just need to provide a URL of the external data source – static file or dynamically
 * generated – and it will do the rest.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="http://www.amcharts.com/kbase/using-data-loader-plugin/">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmDataLoader {

    @JsProperty
    public boolean async;

    @JsProperty
    public Functions.Func complete;

    @JsProperty
    public String delimiter;

    @JsProperty
    public Functions.Func error;

    @JsProperty
    public String format;

    @JsProperty
    public Functions.Func load;

    @JsProperty
    public boolean noStyles;

    @JsProperty
    public Functions.Func postProcess;

    @JsProperty
    public boolean showErrors;

    @JsProperty
    public boolean showCurtain;

    @JsProperty
    public int reload;

    @JsProperty
    public String url;

    @JsProperty
    public boolean reverse;

    @JsProperty
    public int skip;

    @JsProperty
    public boolean timestamp;

    @JsProperty
    public boolean useColumnNames;
}
