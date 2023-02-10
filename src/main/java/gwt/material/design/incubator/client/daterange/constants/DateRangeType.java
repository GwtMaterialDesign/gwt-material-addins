package gwt.material.design.incubator.client.daterange.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.CssType;

public enum DateRangeType implements CssType {

    FIELD("range-field"),
    LABEL("range-label");

    private String cssName;

    DateRangeType(String cssName) {
        this.cssName = cssName;
    }

    @Override
    public String getCssName() {
        return cssName;
    }

    public static DateRangeType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, DateRangeType.class, FIELD);
    }
}
