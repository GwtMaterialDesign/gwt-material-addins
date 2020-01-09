package gwt.material.design.incubator.client.search;

import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.animation.checkmark.CheckMarkClientBundle;
import gwt.material.design.incubator.client.animation.checkmark.CheckMarkClientDebugBundle;

public class InlineSearchDarkTheme extends AddinsWidgetDarkTheme {

    public InlineSearchDarkTheme() {
        super(AddinsIncubator.isDebug() ? InlineSearchDebugClientBundle.INSTANCE.inlineSearchDarkCss() : InlineSearchClientBundle.INSTANCE.inlineSearchDarkCss());
    }
}
