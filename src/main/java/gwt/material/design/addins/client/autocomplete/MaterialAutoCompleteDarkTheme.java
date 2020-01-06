package gwt.material.design.addins.client.autocomplete;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;

public class MaterialAutoCompleteDarkTheme extends AddinsWidgetDarkTheme {

    public MaterialAutoCompleteDarkTheme() {
        super(MaterialAddins.isDebug() ? MaterialAutocompleteDebugClientBundle.INSTANCE.autocompleteDarkCss() : MaterialAutocompleteClientBundle.INSTANCE.autocompleteDarkCss());
    }
}
