package gwt.material.design.addins.client.signature.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class SignaturePad extends JQueryElement {

    public SignaturePad(Element element) {}

    public SignaturePad(Element element, JsSignaturePadOptions options) {}

    @JsMethod
    public native String toDataURL();

    @JsMethod
    public native String toDataURL(String type);

    @JsMethod
    public native void fromDataURL(String data);

    @JsMethod
    public native void clear();

    @JsMethod
    public native boolean isEmpty();
}
