package gwt.material.design.incubator.client.progress;

import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;
import gwt.material.design.incubator.client.AddinsIncubator;

public class ProgressLineBarDarkTheme extends AddinsWidgetDarkTheme {

    public ProgressLineBarDarkTheme() {
        super(AddinsIncubator.isDebug() ? ProgressLineBarDebugClientBundle.INSTANCE.progressLineBarDarkCss() : ProgressLineBarClientBundle.INSTANCE.progressLineBarDarkCss());
    }
}
