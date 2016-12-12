package gwt.material.design.addins.client.dragula.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JsDragula extends JQueryElement {

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JsDragula dragula(Element... elements);

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JsDragula dragula(Element[] elements, JsDragulaOptions options);

    public native JQueryElement on(String events, Functions.Func2<Element, Element> handler);

    public native JQueryElement on(String events, Func4<Element, Element, Element, Element> handler);

    @FunctionalInterface
    @JsFunction
    public interface Func4<A, B, C, D> {
        void call(A param1, B param2, C param3, D param4);
    }
}
