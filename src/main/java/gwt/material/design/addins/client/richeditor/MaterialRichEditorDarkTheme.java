package gwt.material.design.addins.client.richeditor;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;

public class MaterialRichEditorDarkTheme extends AddinsWidgetDarkTheme {

    public MaterialRichEditorDarkTheme() {
        super(MaterialAddins.isDebug() ? MaterialRichEditorDebugClientBundle.INSTANCE.richEditorDarkCss() : MaterialRichEditorClientBundle.INSTANCE.richEditorDarkCss());
    }
}
