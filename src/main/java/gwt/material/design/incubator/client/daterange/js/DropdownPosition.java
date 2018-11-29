package gwt.material.design.incubator.client.daterange.js;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

public enum DropdownPosition implements CssType {

    LEFT("left"),
    RIGHT("right"),
    CENTER("center");

    private final String cssClass;

    DropdownPosition(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static DropdownPosition fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, DropdownPosition.class, LEFT);
    }
}
