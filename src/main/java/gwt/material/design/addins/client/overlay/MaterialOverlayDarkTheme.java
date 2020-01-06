package gwt.material.design.addins.client.overlay;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;

public class MaterialOverlayDarkTheme extends AddinsWidgetDarkTheme {

    public MaterialOverlayDarkTheme() {
        super(MaterialAddins.isDebug() ? MaterialOverlayDebugClientBundle.INSTANCE.overlayDarkCss() : MaterialOverlayClientBundle.INSTANCE.overlayDarkCss());
    }
}
