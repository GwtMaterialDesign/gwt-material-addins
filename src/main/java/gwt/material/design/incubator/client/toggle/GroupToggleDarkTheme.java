package gwt.material.design.incubator.client.toggle;

import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.progress.ProgressLineBarClientBundle;
import gwt.material.design.incubator.client.progress.ProgressLineBarDebugClientBundle;

public class GroupToggleDarkTheme extends AddinsWidgetDarkTheme {

    public GroupToggleDarkTheme() {
        super(AddinsIncubator.isDebug() ? GroupToggleButtonDebugClientBundle.INSTANCE.groupToggleDarkCss() : GroupToggleButtonClientBundle.INSTANCE.groupToggleButtonDarkCss());
    }
}
