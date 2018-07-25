package gwt.material.design.incubator.client.async;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

public class AsyncButton extends AbstractAsyncButton {

    public AsyncButton() {
        super(IncubatorCssName.ASYNC_BUTTON);

        setType(ButtonType.RAISED);
    }

    @Override
    public void loading(String message) {
        super.loading(message);
        setText(message);
    }

    @Override
    public void success(String message) {
        super.success(message);
        setText(message);
    }

    @Override
    public void error(String message) {
        super.error(message);
        setText(message);
    }

    @Override
    protected Element createElement() {
        return Document.get().createPushButtonElement();
    }
}
