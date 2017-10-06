package gwt.material.design.addins.client.splitpanel.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

public enum Side implements CssType {
    ALL("all"),
    FIRST("first"),
    SECOND("second"),
    BOTH("both");

    private final String cssClass;

    Side(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static Side fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, Side.class, BOTH);
    }
}
