package gwt.material.design.incubator.client.async;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

public class AsyncIcon extends AbstractAsyncButton {

    public AsyncIcon() {
        super(IncubatorCssName.ASYNC_ICON);
    }

    @Override
    protected Element createElement() {
        return Document.get().createElement("i");
    }
}
