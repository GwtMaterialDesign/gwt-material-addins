package gwt.material.design.addins.client.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface InlineSearchClientBundle extends ClientBundle {
    InlineSearchClientBundle INSTANCE = GWT.create(InlineSearchClientBundle.class);

    @Source("resources/css/inline-search.min.css")
    TextResource inlineSearchCss();
}
