package gwt.material.design.incubator.client.google.addresslookup;

import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;
import gwt.material.design.incubator.client.AddinsIncubator;

public class AddressLookupDarkTheme extends AddinsWidgetDarkTheme {

    public AddressLookupDarkTheme() {
        super(AddinsIncubator.isDebug() ? AddressLookupDebugClientBundle.INSTANCE.addressLookupDarkCss() : AddressLookupClientBundle.INSTANCE.addressLookupDarkCss());
    }
}
