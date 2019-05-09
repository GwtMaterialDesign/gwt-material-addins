/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.incubator.client.formatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetricPrefixFormatter {

    private static List<MetricRange> ranges = new ArrayList<>();

    private MetricPrefixFormatter() {}

    static {
        ranges.addAll(Arrays.asList(MetricRange.create(1e12, "T"),
                MetricRange.create(1e9, "B"),
                MetricRange.create(1e6, "M"),
                MetricRange.create(1e3, "k")));
    }

    public static MetricValue formatNumber(Double value) {
        for (int i = 0; i < ranges.size(); i++) {
            if (value >= ranges.get(i).divider) {
                return new MetricValue((value / ranges.get(i).divider), ranges.get(i).suffix);
            }
        }
        return new MetricValue(value);
    }
}
