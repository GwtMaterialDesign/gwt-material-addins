package gwt.material.design.incubator.client.tag;

import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.progress.ProgressLineBarClientBundle;
import gwt.material.design.incubator.client.progress.ProgressLineBarDebugClientBundle;

public class TagLabelDarkTheme extends AddinsWidgetDarkTheme {

    public TagLabelDarkTheme() {
        super(AddinsIncubator.isDebug() ? TagDebugClientBundle.INSTANCE.tagDarkCss() : TagClientBundle.INSTANCE.tagDarkCss());
    }
}
