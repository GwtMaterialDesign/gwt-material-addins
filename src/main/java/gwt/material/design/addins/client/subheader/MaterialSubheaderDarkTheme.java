package gwt.material.design.addins.client.subheader;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;

public class MaterialSubheaderDarkTheme extends AddinsWidgetDarkTheme {

    public MaterialSubheaderDarkTheme() {
        super(MaterialAddins.isDebug() ? MaterialSubHeaderDebugClientBundle.INSTANCE.subheaderDarkCss() : MaterialSubHeaderClientBundle.INSTANCE.subheaderDarkCss());
    }
}
