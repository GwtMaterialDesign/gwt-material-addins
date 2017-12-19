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
package gwt.material.design.incubator.client.chart.amcharts.base.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

/**
 * Type of the graph. Possible values are: "line", "column", "step", "smoothedLine", "candlestick", "ohlc".
 * XY and Radar charts can only display "line" type graphs.
 *
 * @author kevzlou7979@gmail.com
 */
public enum ChartType implements CssType {

    SERIAL("serial"),
    PIE("pie"),
    XY("xy"),
    RADAR("radar"),
    FUNNEL("funnel"),
    GAUGE("gauge"),
    GANTT("gantt");

    String name;

    ChartType(String name) {
        this.name = name;
    }

    public static ChartType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ChartType.class, SERIAL);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getCssName() {
        return name;
    }
}
