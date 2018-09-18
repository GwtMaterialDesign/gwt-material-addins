package gwt.material.design.incubator.client.placeholder;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.loadingstate.LoadingStatePanel;

public class PlaceholderItem extends MaterialWidget {

    static {
        IncubatorWidget.showWarning(LoadingStatePanel.class);
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(PlaceholderDebugClientBundle.INSTANCE.contentPlaceholder());
        } else {
            MaterialDesignBase.injectCss(PlaceholderClientBundle.INSTANCE.contentPlaceholderCss());
        }
    }

    public PlaceholderItem() {
        super(Document.get().createDivElement(), IncubatorCssName.CONTENT_PLACEHOLDER);
    }
}
