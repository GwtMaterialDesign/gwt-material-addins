package gwt.material.design.addins.client.rating;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;

public class MaterialRatingDarkTheme extends AddinsWidgetDarkTheme {

    public MaterialRatingDarkTheme() {
        super(MaterialAddins.isDebug() ? MaterialRatingDebugClientBundle.INSTANCE.ratingDarkCss() : MaterialRatingClientBundle.INSTANCE.ratingDarkCss());
    }
}
