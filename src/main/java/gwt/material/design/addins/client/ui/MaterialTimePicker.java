package gwt.material.design.addins.client.ui;

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
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
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
 */
//@formatter:on
public class MaterialTimePicker extends MaterialWidget implements HasError, HasPlaceholder, HasOrientation, HasCloseHandlers<String>, HasOpenHandlers<String> {

    MaterialPanel panel = new MaterialPanel();
    MaterialInput input = new MaterialInput();

    private String time;
    private String placeholder;
    private boolean autoClose;
    private boolean hour24;
    private Orientation orientation = Orientation.PORTRAIT;

    private MaterialLabel lblError = new MaterialLabel();

    private final ErrorMixin<MaterialTimePicker, MaterialLabel> errorMixin = new ErrorMixin<>(this, lblError, input);

    public MaterialTimePicker() {
        super(Document.get().createElement("div"));
        input.setType(InputType.TEXT);
        panel.add(input);
        panel.add(lblError);
        add(panel);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        input.getElement().setAttribute("type", "text");
        initTimePicker();
    }

    public void reset() {
        setTime("");
        clearErrorOrSuccess();
    }

    /**
     * @return the time
     */
    public String getTime() {
        return getTime(input.getElement());
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
        input.getElement().setAttribute("value", time.toUpperCase());
    }

    public boolean isAutoClose() {
        return autoClose;
    }

    public void setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
    }

    /**
     * False (default) change to 24 hours system.
     * @return
     */
    public boolean isHour24() {
        return hour24;
    }

    public void setHour24(boolean hour24) {
        this.hour24 = hour24;
    }

    /**
     * @return the placeholder
     */
    @Override
    public String getPlaceholder() {
        return placeholder;
    }

    /**
     * @param placeholder the placeholder to set
     */
    @Override
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        input.getElement().setAttribute("placeholder", placeholder);
    }

    /**
     * @return the orientation
     */
    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * @param orientation the orientation to set : can be Horizontal or Vertical
     */
    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void setError(String error) {
        errorMixin.setError(error);
    }

    @Override
    public void setSuccess(String success) {
        errorMixin.setSuccess(success);
    }

    @Override
    public void clearErrorOrSuccess() {
        errorMixin.clearErrorOrSuccess();
    }

    public void initTimePicker() {
        initTimePicker(DOM.createUniqueId(), input.getElement(), getOrientation().getCssName(), isAutoClose(), isHour24());
    }

    protected native void initTimePicker(String clockId, Element e, String orientation, boolean autoClose, boolean hour24) /*-{
        var that = this;
        $wnd.jQuery(e).lolliclock({
            autoclose: autoClose,
            orientation: orientation,
            hour24: hour24,
            uniqueId: clockId,
            afterShow: function() {
                that.@gwt.material.design.addins.client.ui.MaterialTimePicker::fireOpenEvent()();
            },
            beforeHide: function() {
                var hour = $wnd.jQuery('#' + clockId).find('.lolliclock-hours').find('.lolliclock-time-new').html();
                var minutes = $wnd.jQuery('#' + clockId).find('.lolliclock-minutes').find('.lolliclock-time-new').html();
                var suffix = $wnd.jQuery('#' + clockId).find('.lolliclock-am-pm').html();
                var time =  hour + ':' + minutes + " " + suffix;
                that.@gwt.material.design.addins.client.ui.MaterialTimePicker::fireCloseEvent(*)(time);
            }
        });
        $wnd.jQuery(e).blur();
    }-*/;

    private native String getTime(Element e)/*-{
        return $wnd.jQuery(e).val();
    }-*/;

    @Override
    public void setEnabled(boolean enabled) {
        input.setEnabled(enabled);
    }

    @Override
    public HandlerRegistration addCloseHandler(CloseHandler<String> handler) {
        return addHandler(handler, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler<String> handler) {
        return addHandler(handler, OpenEvent.getType());
    }

    private void fireCloseEvent(String time) {
        CloseEvent.fire(this, time);
    }

    private void fireOpenEvent() {
        OpenEvent.fire(this, time);
    }
}
