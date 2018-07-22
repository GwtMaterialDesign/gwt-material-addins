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
package gwt.material.design.addins.client.signature;

import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.signature.events.HasSignatureHandlers;
import gwt.material.design.addins.client.signature.events.SignatureClearEvent;
import gwt.material.design.addins.client.signature.events.SignatureEndEvent;
import gwt.material.design.addins.client.signature.events.SignatureStartEvent;
import gwt.material.design.addins.client.signature.js.JsSignaturePadOptions;
import gwt.material.design.addins.client.signature.js.SignaturePad;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.viewport.ViewPort;
import gwt.material.design.client.base.viewport.WidthBoundary;
import gwt.material.design.client.js.Window;

//@formatter:off

/**
 * HTML5 canvas based smooth signature drawing
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code xmlns:ma='urn:import:gwt.material.design.addins.client'}
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code <ma:signature.MaterialSignaturePad dotSize="5" lineMinWidth="5" lineMaxWidth="10" />}
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#signaturePad">Material Signature Pad</a>
 * @see <a href="https://github.com/szimek/signature_pad">LiveStamp SignaturePad 2.3.0</a>
 */
//@formatter:on
public class MaterialSignaturePad extends AbstractValueWidget<String> implements JsLoader, HasSignaturePadOptions, HasSignatureHandlers {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialSignaturePadDebugClientBundle.INSTANCE.signaturePadDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialSignaturePadClientBundle.INSTANCE.signaturePadJs());
        }
    }


    public MaterialSignaturePad() {
        super(Document.get().createCanvasElement(), AddinsCssName.SIGNATURE_PAD);
    }

    private SignaturePad signaturePad;
    private JsSignaturePadOptions options = JsSignaturePadOptions.create();

    @Override
    protected void onLoad() {
        super.onLoad();

        resizeCanvas();
        load();
    }

    /**
     * <b>Handling high DPI screens</b>
     * <p>
     * To correctly handle canvas on low and high DPI screens one has to take devicePixelRatio into account and scale
     * the canvas accordingly. </p>
     *
     * @see <a href="https://github.com/szimek/signature_pad#handling-high-dpi-screens">More info</a>
     */
    protected void resizeCanvas() {
        applyResize();
        ViewPort.when(new WidthBoundary(0, 5120)).then(param1 -> applyResize());
    }

    protected void applyResize() {
        CanvasElement element = getElement().cast();
        double ratio = getRatio();
        element.setWidth((int) (getOffsetWidth() * ratio));
        element.setHeight((int) (getOffsetHeight() * ratio));
        element.getContext2d().scale(ratio, ratio);
        getSignaturePad().clear();
    }

    @Override
    public void load() {
        getSignaturePad().on();
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        getSignaturePad().off();
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    @Override
    public void clear() {
        super.clear();
        reset();
    }

    public void reset() {
        resizeCanvas();
        SignatureClearEvent.fire(this);
    }

    @Override
    public boolean isEmpty() {
        return getSignaturePad().isEmpty();
    }

    @Override
    public void fromDataUrl(String url) {
        getSignaturePad().fromDataURL(url);
    }

    @Override
    public String toDataUrl() {
        return getSignaturePad().toDataURL();
    }

    public SignaturePad getSignaturePad() {
        if (signaturePad == null) {
            options.onBegin = () -> SignatureStartEvent.fire(this);
            options.onEnd = () -> {
                SignatureEndEvent.fire(this);
                ValueChangeEvent.fire(this, getSignaturePad().toDataURL());
            };
            signaturePad = new SignaturePad(getElement(), options);
        }
        return signaturePad;
    }

    public void setSignaturePad(SignaturePad signaturePad) {
        this.signaturePad = signaturePad;
    }

    @Override
    public double getDotSize() {
        return options.dotSize;
    }

    @Override
    public void setDotSize(double dotSize) {
        options.dotSize = dotSize;

        if (signaturePad != null) {
            signaturePad.dotSize = dotSize;
        }
    }

    @Override
    public double getLineMinWidth() {
        return options.minWidth;
    }

    @Override
    public void setLineMinWidth(double lineMinWidth) {
        options.minWidth = lineMinWidth;

        if (signaturePad != null) {
            signaturePad.minWidth = lineMinWidth;
        }
    }

    @Override
    public double getLineMaxWidth() {
        return options.maxWidth;
    }

    @Override
    public void setLineMaxWidth(double lineMaxWidth) {
        options.maxWidth = lineMaxWidth;

        if (signaturePad != null) {
            signaturePad.maxWidth = lineMaxWidth;
        }
    }

    @Override
    public int getThrottle() {
        return options.throttle;
    }

    @Override
    public void setThrottle(int throttle) {
        options.throttle = throttle;

        if (signaturePad != null) {
            signaturePad.throttle = throttle;
        }
    }

    @Override
    public String getPenColor() {
        return options.penColor;
    }

    @Override
    public void setPenColor(String penColor) {
        options.penColor = penColor;

        if (signaturePad != null) {
            signaturePad.penColor = penColor;
        }
    }

    @Override
    public double getVelocityFilterWeight() {
        return options.velocityFilterWeight;
    }

    @Override
    public void setVelocityFilterWeight(double velocityFilterWeight) {
        options.velocityFilterWeight = velocityFilterWeight;

        if (signaturePad != null) {
            signaturePad.velocityFilterWeight = velocityFilterWeight;
        }
    }

    public static native double getRatio() /*-{
        return Math.max(window.devicePixelRatio || 1, 1);
    }-*/;

    @Override
    public HandlerRegistration addSignatureClearHandler(SignatureClearEvent.SignatureClearHandler handler) {
        return addHandler(handler, SignatureClearEvent.TYPE);
    }

    @Override
    public HandlerRegistration addSignatureStartHandler(SignatureStartEvent.SignatureStartHandler handler) {
        return addHandler(handler, SignatureStartEvent.TYPE);
    }

    @Override
    public HandlerRegistration addSignatureEndHandler(SignatureEndEvent.SignatureEndHandler handler) {
        return addHandler(handler, SignatureEndEvent.TYPE);
    }

    @Override
    public String getValue() {
        return getSignaturePad().toDataURL();
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        super.setValue(value, fireEvents);

        // Will set the value internally from signaturepad component
        fromDataUrl(value);
    }
}
