package gwt.material.design.addins.client.livestamp;

import com.google.gwt.core.client.GWT;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialToast;

import java.util.Date;

import static gwt.material.design.addins.client.livestamp.js.JsLiveStamp.$;

public class MaterialLiveStamp extends MaterialLabel {

    private boolean initialized;

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialLiveStampDebugClientBundle.INSTANCE.momentDebugJs());
            MaterialDesignBase.injectDebugJs(MaterialLiveStampDebugClientBundle.INSTANCE.liveStampDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialLiveStampClientBundle.INSTANCE.momentJs());
            MaterialDesignBase.injectJs(MaterialLiveStampClientBundle.INSTANCE.liveStampJs());
        }
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if (!initialized) {
            getElement().setAttribute("data-livestamp", new Date().toString());
            initialized = true;
        }
    }
}
