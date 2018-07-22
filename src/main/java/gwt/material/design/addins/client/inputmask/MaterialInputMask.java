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
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.inputmask.events.*;
import gwt.material.design.addins.client.inputmask.js.JsInputMaskOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.ui.MaterialValueBox;

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
 * @see <a href="https://igorescobar.github.io/jQuery-Mask-Plugin/docs.html">jQuery-Mask-Plugin 1.14.10</a>
 */
//@formatter:on
public class MaterialInputMask<T> extends MaterialValueBox<T>
        implements JsLoader, HasInputMaskHandlers {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialInputMaskDebugClientBundle.INSTANCE.inputMaskDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialInputMaskClientBundle.INSTANCE.inputMaskJs());
        }
    }

    private String mask;
    private JsInputMaskOptions options = new JsInputMaskOptions();

    public MaterialInputMask() {
        setup((ValueBoxBase<T>) new TextBox());
    }

    public void setup(ValueBoxBase<T> tValueBox) {
        valueBoxBase = tValueBox;
        add(valueBoxBase);
        setType(InputType.TEXT);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        if (mask == null || mask.isEmpty()) {
            GWT.log("You must provide a mask pattern in order to mask your field");
        } else {
            load(mask);
        }
    }

    /**
     * Mask the input field with given mask value.
     */
    public void load(String mask) {
        options.onComplete = object -> CompleteEvent.fire(this, object);
        options.onKeyPress = object -> KeyPressEvent.fire(this, object);
        options.onChange = object -> ChangeEvent.fire(this, object);
        options.onInvalid = (object, event, function, error) -> InvalidEvent.fire(this, object, error[0]);
        $(valueBoxBase.getElement()).mask(mask, options);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        $(valueBoxBase.getElement()).unmask();
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    public String getMask() {
        return mask;
    }

    /**
     * Set the mask pattern to apply into the text field
     */
    public void setMask(String mask) {
        this.mask = mask;
    }

    public boolean isReverse() {
        return options.reverse;
    }

    /**
     * The mask will be placed from the right to the left if reverse is true (Default : false)
     */
    public void setReverse(boolean reverse) {
        options.reverse = reverse;
    }

    public boolean isClearIfNotMatch() {
        return options.clearIfNotMatch;
    }

    /**
     * The textfield will automatically clears whenever the value is not match with the mask provided. (Default : false)
     */
    public void setClearIfNotMatch(boolean clearIfNotMatch) {
        options.clearIfNotMatch = clearIfNotMatch;
    }

    public boolean isSelectOnFocus() {
        return options.selectOnFocus;
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
        return $(valueBoxBase.getElement()).cleanVal();
    }

    @Override
    public HandlerRegistration addCompleteHandler(CompleteEvent.CompleteHandler handler) {
        return addHandler(handler, CompleteEvent.TYPE);
    }

    @Override
    public HandlerRegistration addChangeHandler(ChangeEvent.ChangeHandler handler) {
        return addHandler(handler, ChangeEvent.TYPE);
    }

    @Override
    public HandlerRegistration addInvalidHandler(InvalidEvent.InvalidHandler handler) {
        return addHandler(handler, InvalidEvent.TYPE);
    }

    @Override
    public HandlerRegistration addKeyPressHandler(KeyPressEvent.KeyPressHandler handler) {
        return addHandler(handler, KeyPressEvent.TYPE);
    }
}
