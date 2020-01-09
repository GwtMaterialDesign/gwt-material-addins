package gwt.material.design.incubator.client.placeholder;

import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.progress.ProgressLineBarClientBundle;
import gwt.material.design.incubator.client.progress.ProgressLineBarDebugClientBundle;

public class PlaceholderDarkTheme extends AddinsWidgetDarkTheme {

    public PlaceholderDarkTheme() {
        super(AddinsIncubator.isDebug() ? PlaceholderDebugClientBundle.INSTANCE.contentPlaceholderDarkCss() : PlaceholderClientBundle.INSTANCE.contentPlaceholderDarkCss());
    }
}
