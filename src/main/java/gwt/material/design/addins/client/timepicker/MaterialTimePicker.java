package gwt.material.design.addins.client.timepicker;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasValue;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.timepicker.js.JsTimePickerOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasError;
import gwt.material.design.client.base.HasOrientation;
import gwt.material.design.client.base.HasPlaceholder;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.ErrorMixin;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.constants.Orientation;
import gwt.material.design.client.ui.MaterialInput;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.html.Label;

import java.util.Date;

import static gwt.material.design.addins.client.timepicker.js.JsTimePicker.$;

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

//@formatter:off

/**
 * Material Time Picker - provide a simple way to select a single value from a pre-determined set.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code <ma:timepicker.MaterialTimePicker placeholder="Time Arrival" />}
 * </pre>
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#timepickers">Material Pickers</a>
 * @author kevzlou7979
 * @author Ben Dol
 */
//@formatter:on
public class MaterialTimePicker extends MaterialWidget implements HasError, HasPlaceholder, HasOrientation,
        HasCloseHandlers<Date>, HasOpenHandlers<Date>, HasValue<Date> {

    static {
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialTimePickerDebugClientBundle.INSTANCE.timepickerJsDebug());
            MaterialDesignBase.injectCss(MaterialTimePickerDebugClientBundle.INSTANCE.timepickerCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialTimePickerClientBundle.INSTANCE.timepickerJs());
            MaterialDesignBase.injectCss(MaterialTimePickerClientBundle.INSTANCE.timepickerCss());
        }
    }

    /** Wraps the actual input. */
    private MaterialPanel panel = new MaterialPanel();

    /** The input element for the time picker. */
    private MaterialInput input = new MaterialInput();

    /** Label to display errors messages. */
    private MaterialLabel lblError = new MaterialLabel();

    /** The current value held by the time picker. */
    private Date time;

    private Label label = new Label();

    /** */
    private ToggleStyleMixin<MaterialInput> validMixin = new ToggleStyleMixin<>(this.input, "valid");

    private final ErrorMixin<MaterialTimePicker, MaterialLabel> errorMixin = new ErrorMixin<>(this, this.lblError, this.input);

    private String placeholder;
    private boolean autoClose;
    private boolean hour24;
    private Orientation orientation = Orientation.PORTRAIT;


    public MaterialTimePicker() {
        super(Document.get().createElement("div"), "timepicker", "input-field");
        this.input.setType(InputType.TEXT);
        this.panel.add(this.input);
        this.panel.add(label);
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
        this.label.setText(placeholder);
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
    public void setHelperText(String helperText) {
        this.errorMixin.setHelperText(helperText);
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
     * @param uniqueId
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
    protected void initTimePicker(String uniqueId, Element e, String orientation, boolean autoClose, boolean hour24) {
        $("document").ready(() -> {
            JsTimePickerOptions options = new JsTimePickerOptions();
            options.autoclose = autoClose;
            options.orientation = orientation;
            options.hour24 = hour24;
            options.uniqueId = uniqueId;
            options.beforeShow = () -> {
                beforeShow();
            };
            options.afterShow = () -> {
                afterShow();
            };
            options.afterHide = () -> {
                afterHide();
            };
            $(e).lolliclock(options);
            $(e).blur();
        });
    }


    /**
     * Called after the lolliclock event <code>afterShow</code>.
     */
    protected void beforeShow() {

        this.input.getElement().blur();

        // Add class 'valid' for visual feedback.
        this.validMixin.setOn(true);
    }

    /**
     * Called after the lolliclock event <code>afterShow</code>.
     */
    protected void afterShow() {
        this.fireOpenEvent();
    }

    /**
     * Called after the lolliclock event <code>afterHide</code>.
     */
    protected void afterHide() {

        String timeString = this.getTime(this.input.getElement());

        Date parsedDate = null;

        if(timeString.equals("") == false && timeString != null) {
            try {
                if(this.hour24 == true) {
                    DateTimeFormat hour24DateTimeFormat = DateTimeFormat.getFormat("HH:mm");
                    parsedDate = hour24DateTimeFormat.parse(timeString);
                } else {
                    DateTimeFormat hour12DateTimeFormat = DateTimeFormat.getFormat("hh:mm aa");
                    parsedDate = hour12DateTimeFormat.parse(timeString);
                }
            } catch(Exception e) {
                // Silently catch parse errors
            }
        }

        this.setValue(parsedDate);

        // Remove class 'valid' after hide.
        this.validMixin.setOn(false);

        this.fireCloseEvent();
    }

    protected String getTime(Element e) {
        return $(e).val().toString();
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.input.setEnabled(enabled);
    }

    @Override
    public HandlerRegistration addCloseHandler(final CloseHandler<Date> handler) {
        return this.addHandler(new CloseHandler<Date>() {
            @Override
            public void onClose(CloseEvent<Date> event) {
                if(isEnabled()){
                    handler.onClose(event);
                }
            }
        }, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(final OpenHandler<Date> handler) {
        return this.addHandler(new OpenHandler<Date>() {
            @Override
            public void onOpen(OpenEvent<Date> event) {
                if(isEnabled()){
                    handler.onOpen(event);
                }
            }
        }, OpenEvent.getType());
    }

    protected void fireCloseEvent() {
        CloseEvent.fire(this, this.time);
    }

    protected void fireOpenEvent() {
        OpenEvent.fire(this, this.time);
    }

    protected void fireValueChangeEvent() {
        ValueChangeEvent.fire(this, this.time);
    }

    @Override
    public void clear() {
        this.clearTimePickerValue(this.input.getElement());
    }

    protected void clearTimePickerValue(Element e) {
        $(e).val("");
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Date> handler) {
        return this.addHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> event) {
                if(isEnabled()){
                    handler.onValueChange(event);
                }
            }
        }, ValueChangeEvent.getType());
    }

    @Override
    public Date getValue() {
        return this.time;
    }

    @Override
    public void setValue(Date time) {
        this.setValue(time, true);
    }

    @Override
    public void setValue(Date time, boolean fireEvents) {

        if(this.time != null) {
            if(this.time.equals(time)) {
                return;
            }
        }

        if(this.time == time) {
            return;
        }

        this.time = time;

        String timeString = null;

        if(this.hour24 == true) {
            DateTimeFormat hour24DateTimeFormat = DateTimeFormat.getFormat("HH:mm");
            timeString = hour24DateTimeFormat.format(time);
        } else {
            DateTimeFormat hour12DateTimeFormat = DateTimeFormat.getFormat("hh:mm aa");
            timeString = hour12DateTimeFormat.format(time);
        }

        this.setValue(this.input.getElement(), timeString);

        if(fireEvents == true) {
            this.fireValueChangeEvent();
        }
    }

    protected void setValue(Element e, String time) {
        $(e).val(time);
    }
}
