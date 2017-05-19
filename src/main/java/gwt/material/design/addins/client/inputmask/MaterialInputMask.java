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
package gwt.material.design.addins.client.inputmask;

import com.google.gwt.core.client.GWT;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.inputmask.js.JsInputMaskOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialTextBox;

import static gwt.material.design.addins.client.inputmask.js.JsInputMask.$;

//@formatter:off

/**
 * An input mask helps the user with the input by ensuring a predefined format.
 * This can be useful for dates, numerics, phone numbers etc...
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
 * <ma:inputmask.MaterialInputMask label="Ip Address" placeholder="eg: 000.000.000.000" mask="000.000.000.000"/>
 * <ma:inputmask.MaterialInputMask label="Percentage" placeholder="eg: 000000.00%" mask="000000.00%" reverse="true"/>
 * <ma:inputmask.MaterialInputMask label="Credit Card" placeholder="eg: 0000 0000 0000 0000" mask="0000 0000 0000 0000" clearIfNotMatch="true"/>
 * <ma:inputmask.MaterialInputMask label="Credit Card" placeholder="eg: 0000 0000 0000 0000" mask="0000 0000 0000 0000" selectOnFocus="true"/>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#inputFields">Material Input Fields</a>
 */
//@formatter:on
public class MaterialInputMask extends MaterialTextBox {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialInputMaskDebugClientBundle.INSTANCE.inputMaskDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialInputMaskClientBundle.INSTANCE.inputMaskJs());
        }
    }

    private String mask;
    private JsInputMaskOptions options = new JsInputMaskOptions();

    @Override
    protected void initialize() {
        if (mask == null || mask.isEmpty()) {
            GWT.log("You must provide a mask pattern in order to mask your field");
        } else {
            mask(mask);
        }
    }

    /**
     * Set the mask pattern to apply into the text field
     */
    public void setMask(String mask) {
        this.mask = mask;
    }

    /**
     * The mask will be placed from the right to the left if reverse is true (Default : false)
     */
    public void setReverse(boolean reverse) {
        options.reverse = reverse;
    }

    /**
     * The textfield will automatically clears whenever the value is not match with the mask provided. (Default : false)
     */
    public void setClearIfNotMatch(boolean clearIfNotMatch) {
        options.clearIfNotMatch = clearIfNotMatch;
    }

    /**
     * Set whether you want to set on focus on your mask for easy selection.
     */
    public void setSelectOnFocus(boolean selectOnFocus) {
        options.selectOnFocus = selectOnFocus;
    }

    /**
     * Gets the value of the field without the mask.
     */
    public String getCleanValue() {
        return $(asTextBox().getElement()).cleanVal();
    }


    /**
     * Destroy the mask.
     */
    public void unmask() {
        $(asTextBox().getElement()).unmask();
    }

    /**
     * Mask the input field with given mask value.
     */
    public void mask(String mask) {
        $(asTextBox().getElement()).mask(mask, options);
    }
}
