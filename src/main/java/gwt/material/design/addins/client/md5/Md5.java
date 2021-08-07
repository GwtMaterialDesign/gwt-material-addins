package gwt.material.design.addins.client.md5;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "md5")
public class Md5 {

    public Md5(String message) {
    }

    public Md5() {
    }

    @JsMethod(namespace = "md5")
    public static native String hex(String message);

    @JsMethod(namespace = "md5")
    public static native byte[] array(String message);

    @JsMethod(namespace = "md5")
    public static native byte[] digest(String message);

    @JsMethod(namespace = "md5")
    public static native Object arrayBuffer(String message);

    @JsMethod(namespace = "md5")
    public static native Object buffer(String message);

    @JsMethod(namespace = "md5")
    public static native String base64(String message);
}
