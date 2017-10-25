package gwt.material.design.addins.client.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface InlineSearchDebugClientBundle extends ClientBundle {
    InlineSearchDebugClientBundle INSTANCE = GWT.create(InlineSearchDebugClientBundle.class);

    @Source("resources/css/inline-search.css")
    TextResource inlineSearchDebugCss();
}
