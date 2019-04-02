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

public class MetricValue {

    private Double numericalValue;
    private String suffix;

    public MetricValue() {}

    public MetricValue(Double numericalValue) {
        this.numericalValue = numericalValue;
    }

    public MetricValue(Double numericalValue, String suffix) {
        this.numericalValue = numericalValue;
        this.suffix = suffix;
    }

    public Double getNumericalValue() {
        return numericalValue;
    }

    public void setNumericalValue(Double value) {
        this.numericalValue = value;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
