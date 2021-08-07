package gwt.material.design.addins.client.md5;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;

public class Md5Util {
    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(Md5DebugClientBundle.INSTANCE.md5DebugJs());
        } else {
            MaterialDesignBase.injectJs(Md5ClientBundle.INSTANCE.md5Js());
        }
    }

    public Md5Util() {

    }

    public String hex(String message) {
        return Md5.hex(message);
    }

    public byte[] array(String message) {
        return Md5.array(message);
    }

    public byte[] digest(String message) {
        return Md5.digest(message);
    }

    public Object arrayBuffer(String message) {
        return Md5.arrayBuffer(message);
    }

    public Object buffer(String message) {
        return Md5.buffer(message);
    }

    public String base64(String message) {
        return Md5.base64(message);
    }
}
