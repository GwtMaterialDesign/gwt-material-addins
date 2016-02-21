package gwt.material.design.addins.client.ui;

import java.util.Date;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.logical.shared.HasOpenHandlers;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasValue;

import gwt.material.design.client.base.HasError;
import gwt.material.design.client.base.HasOrientation;
import gwt.material.design.client.base.HasPlaceholder;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.ErrorMixin;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.constants.Orientation;
import gwt.material.design.client.ui.MaterialInput;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;

//@formatter:off

/**
 * Material Time Picker -  provide a simple way to select a single value from a pre-determined set.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:m.addins='urn:import:gwt.material.design.addins.client.ui'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 *{@code <m.addins:MaterialTimePicker placeholder="Time Arrival" />
 * </pre>
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#timepickers">Material Pickers</a>
 * @author kevzlou7979
 * @author Ben Dol
 * @author silentsnooc
 */
//@formatter:on
public class MaterialTimePicker extends MaterialWidget implements HasError, HasPlaceholder, HasOrientation,
        HasCloseHandlers<Date>, HasOpenHandlers<Date>, HasValue<Date> {

    /** Wraps the actual input. */
    private MaterialPanel panel = new MaterialPanel();
    
    /** The input element for the time picker. */
    private MaterialInput input = new MaterialInput();
    
    /** Label to display errors messages. */
    private MaterialLabel lblError = new MaterialLabel();

    /** The current value held by the time picker. */
    private Date time;
    
    private final ErrorMixin<MaterialTimePicker, MaterialLabel> errorMixin = new ErrorMixin<>(this, this.lblError, this.input);
    
    private String placeholder;
    private boolean autoClose;
    private boolean hour24;
    private Orientation orientation = Orientation.PORTRAIT;

    
    public MaterialTimePicker() {
        super(Document.get().createElement("div"));
        this.input.setType(InputType.TEXT);
        this.panel.add(this.input);
        this.panel.add(this.lblError);
        this.add(this.panel);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        this.input.getElement().setAttribute("type", "text");
        this.initTimePicker();
    }

    /**
     * Side effects:
     * <ul>
     *   <li>Resets the time to <i>now<i></li>
     *   <li>Clears erros/success message</li>
     * </ul>
     */
    public void reset() {
        this.setValue(new Date());
        this.clearErrorOrSuccess();
    }

    /**
     * @return the time
     */
    public String getTime() {
        return this.getTime(this.input.getElement());
    }

    public boolean isAutoClose() {
        return this.autoClose;
    }

    public void setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
    }

    /**
     * False (default) change to 24 hours system.
     * 
     * @return <code>false</code> in case 12 hours mode is set;
     *         <code>true</code> otherwise.
     */
    public boolean isHour24() {
        return this.hour24;
    }

    /**
     * 
     * @param hour24
     */
    public void setHour24(boolean hour24) {
        this.hour24 = hour24;
    }

    /**
     * @return The placeholder text.
     */
    @Override
    public String getPlaceholder() {
        return this.placeholder;
    }

    /**
     * @param placeholder
     *            The placeholder text to set.
     */
    @Override
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        this.input.getElement().setAttribute("placeholder", placeholder);
    }

    /**
     * @return The orientation.
     */
    @Override
    public Orientation getOrientation() {
        return this.orientation;
    }

    /**
     * @param orientation
     *            The orientation to set: Can be Horizontal or Vertical.
     */
    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void setError(String error) {
        this.errorMixin.setError(error);
    }

    @Override
    public void setSuccess(String success) {
        this.errorMixin.setSuccess(success);
    }

    @Override
    public void clearErrorOrSuccess() {
        this.errorMixin.clearErrorOrSuccess();
    }

    public void initTimePicker() {
        this.initTimePicker(DOM.createUniqueId(), this.input.getElement(), this.getOrientation().getCssName(), this.isAutoClose(), this.isHour24());
    }

    /**
     * 
     * @param clockId
     *            The clock id for the lolliclock.
     * @param e
     *            The HTML element serving as container for textual content.
     * @param orientation
     *            The initial orientation.
     * @param autoClose
     *            Autoclose <code>true</code> or <code>false</code>
     * @param hour24
     *            Set this <true>true</code> for a 24 hours clock;
     *            <code>false</code> otherwise.
     */
    protected native void initTimePicker(String clockId, Element e, String orientation, boolean autoClose, boolean hour24) /*-{
        var that = this;
        $wnd.jQuery(e).lolliclock({
            autoclose: autoClose,
            orientation: orientation,
            hour24: hour24,
            uniqueId: clockId,
            afterShow: function() {
                that.@gwt.material.design.addins.client.ui.MaterialTimePicker::afterShow()();
            },
            afterHide: function() {
                var hour = $wnd.jQuery('#' + clockId).find('.lolliclock-hours').find('.lolliclock-time-new').html();
                var minutes = $wnd.jQuery('#' + clockId).find('.lolliclock-minutes').find('.lolliclock-time-new').html();
                var suffix = $wnd.jQuery('#' + clockId).find('.lolliclock-am-pm').html();
                var time =  hour + ':' + minutes + " " + suffix;
                that.@gwt.material.design.addins.client.ui.MaterialTimePicker::afterHide(*)(time);
            }
        });
        $wnd.jQuery(e).blur();
    }-*/;
    
    /**
     * Called after the lolliclock event <code>afterShow</code>.
     */
    private void afterShow() {
        this.fireOpenEvent();
    }
        
    /**
     * Called after the lolliclock event <code>afterHide</code>.
     * 
     * @param time
     *            The time given by lolliclock in 12-hours <code>hh:mm aa</code>
     *            format.
     */
    private void afterHide(String time) {
        
        DateTimeFormat hour12DateTimeFormat = DateTimeFormat.getFormat("hh:mm aa");
        Date parsedDate = hour12DateTimeFormat.parse(time);
        
        if(this.hour24 == true) {
            DateTimeFormat hour24DateTimeFormat = DateTimeFormat.getFormat("HH:mm");
            time = hour24DateTimeFormat.format(parsedDate);
        }
        this.setValue(parsedDate);
        this.fireCloseEvent(time);
    }
    
    private native String getTime(Element e)/*-{
        return $wnd.jQuery(e).val();
    }-*/;

    @Override
    public void setEnabled(boolean enabled) {
        this.input.setEnabled(enabled);
    }

    @Override
    public HandlerRegistration addCloseHandler(CloseHandler<Date> handler) {
        return this.addHandler(handler, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler<Date> handler) {
        return this.addHandler(handler, OpenEvent.getType());
    }

    private void fireCloseEvent(String time) {
        CloseEvent.fire(this, this.time);
    }

    private void fireOpenEvent() {
        OpenEvent.fire(this, this.time);
    }
    
    private void fireValueChangeEvent() {
        ValueChangeEvent.fire(this, this.time);
    }

    @Override
    public void clear() {
        this.clearTimePickerValue(this.input.getElement());
    }

    private native void clearTimePickerValue(Element e) /*-{
        $wnd.jQuery(e).val('');
    }-*/;
    
    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date> handler) {
        return this.addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public Date getValue() {
        return this.time;
    }

    @Override
    public void setValue(Date time) {
        this.time = time;
        this.fireValueChangeEvent();
    }

    @Override
    public void setValue(Date time, boolean fireEvents) {
        
        this.time = time;
        
        if(fireEvents == true) {
            this.fireValueChangeEvent();
        }
    }

}
