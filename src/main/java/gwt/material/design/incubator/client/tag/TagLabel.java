package gwt.material.design.incubator.client.tag;

import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.incubator.client.AddinsIncubator;

public class TagLabel extends MaterialLabel {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(TagDebugClientBundle.INSTANCE.tagDebugCss());
        } else {
            MaterialDesignBase.injectCss(TagClientBundle.INSTANCE.tagCss());
        }
    }

    public TagLabel() {
        super();

        addStyleName("tag-label");
    }
}
