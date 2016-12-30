/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.countup;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.countup.js.CountUp;
import gwt.material.design.addins.client.countup.js.JsCountUpOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Animates a numerical value by counting it up with delightful animations.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 * <ma:countup.MaterialCountUp ui:field="lblNumber" startValue="0" endValue="100" />
 * }
 * </pre>
 * <p>
 * <h3>Java Usage:</h3>
 * <pre>
 * {@code
 * // To start the animation
 * lblNumber.start();
 * }
 * </pre>
 * </p>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#countup">Material CountUp</a>
 */
//@formatter:on
public class MaterialCountUp extends MaterialLabel {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialCountUpDebugClientBundle.INSTANCE.countUpJsDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialCountUpClientBundle.INSTANCE.countUpJs());
        }
    }

    private CountUp countUp;
    private double startValue;
    private double endValue;
    private double decimals;
    private double duration = 2;
    private String separator = ",";
    private String decimal = ".";
    private String prefix = "";
    private String suffix = "";
    private Functions.Func callback;

    public void start() {
        JsCountUpOptions options = new JsCountUpOptions();
        options.separator = separator;
        options.decimal = decimal;
        options.prefix = prefix;
        options.suffix = suffix;
        countUp = new CountUp(getElement(), startValue, endValue, decimals, duration, options);
        countUp.start(callback);
    }

    public double getStartValue() {
        return startValue;
    }

    /**
     * The value you want to begin at (Default : 0)
     */
    public void setStartValue(double startValue) {
        this.startValue = startValue;
    }

    public double getEndValue() {
        return endValue;
    }

    /**
     * The value you want to end at (Default : 0)
     */
    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

    public double getDecimals() {
        return decimals;
    }

    /**
     * Number of decimal places in number (Default : 0)
     */
    public void setDecimals(double decimals) {
        this.decimals = decimals;
    }

    public double getDuration() {
        return duration;
    }

    /**
     * Duration in seconds (Default : 2sec)
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getSeparator() {
        return separator;
    }

    /**
     * Adds separator to your numerical value (Default : ",")
     */
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getDecimal() {
        return decimal;
    }

    /**
     * Set the decimal symbol (Default ".")
     */
    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public String getPrefix() {
        return prefix;
    }

    /**
     * Set the prefix, good for currency values like $ (dollar sign) (Default : " ")
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    /**
     * Set the suffix value for your numbers
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Set the callback function after the count up reach the end value.
     */
    public void setCallback(Functions.Func callback) {
        this.callback = callback;
    }

    /**
     * Toggle pause/resume
     */
    public void pauseResume() {
        countUp.pauseResume();
    }

    /**
     * Reset an animation
     */
    public void reset() {
        countUp.reset();
    }
}
