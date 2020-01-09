package gwt.material.design.incubator.client.animation.checkmark;

import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.daterange.DateRangeClientBundle;
import gwt.material.design.incubator.client.daterange.DateRangeClientDebugBundle;

public class CheckMarkDarkTheme extends AddinsWidgetDarkTheme {

    public CheckMarkDarkTheme() {
        super(AddinsIncubator.isDebug() ? CheckMarkClientDebugBundle.INSTANCE.checkMarkDarkCss() : CheckMarkClientBundle.INSTANCE.checkMarkDarkCss());
    }
}
