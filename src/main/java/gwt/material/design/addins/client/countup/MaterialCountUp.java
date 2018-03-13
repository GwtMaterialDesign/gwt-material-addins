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

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.countup.js.CountUp;
import gwt.material.design.addins.client.countup.js.JsCountUpOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.AbstractValueWidget;
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
 * @see <a href="https://github.com/inorganik/countUp.js">CountUpJs 1.9.0</a>
 */
//@formatter:on
public class MaterialCountUp extends AbstractValueWidget<Double> {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialCountUpDebugClientBundle.INSTANCE.countUpJsDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialCountUpClientBundle.INSTANCE.countUpJs());
        }
    }

    private CountUp countUp;


    private JsCountUpOptions options = JsCountUpOptions.create();

    public MaterialCountUp() {
        super(Document.get().createLabelElement());
    }

    public void start() {
        countUp = new CountUp(getElement(), getStartValue(), getEndValue(), getDecimals(), getDuration(), options);
        countUp.start(getCallback());
    }

    /**
     * Toggle pause/resume
     */
    public void pauseResume() {
        if (countUp != null) {
            countUp.pauseResume();
        }
    }

    /**
     * Reset an animation
     */
    public void reset() {
        super.reset();

        if (countUp != null) {
            countUp.reset();
        }
    }

    public double getStartValue() {
        return options.startValue;
    }

    /**
     * The value you want to begin at (Default : 0)
     */
    public void setStartValue(double startValue) {
        options.startValue = startValue;
    }

    public double getEndValue() {
        return options.endValue;
    }

    @Override
    public Double getValue() {
        return getEndValue();
    }

    @Override
    public void setValue(Double value, boolean fireEvents) {
        setValue(value, fireEvents, true);
    }

    /**
     * Provide a better control whether you want to automatically start the counting of the new value. By Default it will
     * start counting with the given value.
     */
    public void setValue(Double value, boolean fireEvents, boolean autoStart) {
        super.setValue(value, fireEvents);
        setEndValue(value);

        if (autoStart) {
            start();
        }
    }

    /**
     * The value you want to end at (Default : 0)
     */
    public void setEndValue(double endValue) {
        options.endValue = endValue;
    }

    public double getDecimals() {
        return options.decimals;
    }

    /**
     * Number of decimal places in number (Default : 0)
     */
    public void setDecimals(double decimals) {
        options.decimals = decimals;
    }

    public double getDuration() {
        return options.duration;
    }

    /**
     * Duration in seconds (Default : 2sec)
     */
    public void setDuration(double duration) {
        options.duration = duration;
    }

    public String getSeparator() {
        return options.separator;
    }

    /**
     * Adds separator to your numerical value (Default : ",")
     */
    public void setSeparator(String separator) {
        options.separator = separator;
    }

    public String getDecimal() {
        return options.decimal;
    }

    /**
     * Set the decimal symbol (Default ".")
     */
    public void setDecimal(String decimal) {
        options.decimal = decimal;
    }

    public String getPrefix() {
        return options.prefix;
    }

    /**
     * Set the prefix, good for currency values like $ (dollar sign) (Default : " ")
     */
    public void setPrefix(String prefix) {
        options.prefix = prefix;
    }

    public String getSuffix() {
        return options.suffix;
    }

    /**
     * Set the suffix value for your numbers
     */
    public void setSuffix(String suffix) {
        options.suffix = suffix;
    }

    public Functions.Func getCallback() {
        return options.callback;
    }

    /**
     * Set the callback function after the count up reach the end value.
     */
    public void setCallback(Functions.Func callback) {
        options.callback = callback;
    }
}
