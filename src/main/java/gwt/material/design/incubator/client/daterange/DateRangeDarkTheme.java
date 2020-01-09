package gwt.material.design.incubator.client.daterange;

import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.tag.TagClientBundle;
import gwt.material.design.incubator.client.tag.TagDebugClientBundle;

public class DateRangeDarkTheme extends AddinsWidgetDarkTheme {

    public DateRangeDarkTheme() {
        super(AddinsIncubator.isDebug() ? DateRangeClientDebugBundle.INSTANCE.dateRangeDarkCss() : DateRangeClientBundle.INSTANCE.dateRangeDarkCss());
    }
}
