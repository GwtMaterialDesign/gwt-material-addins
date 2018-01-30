package gwt.material.design.incubator.client.jsontable.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

/**
 * Used by {@link gwt.material.design.incubator.client.jsontable.JsonTable#setType(JsonTableType)}
 *
 * @author kevzlou7979@gmail.com
 */
public enum JsonTableType implements CssType {

    NONE(""),
    STRIPED("striped"),
    BORDERED("bordered"),
    HIGHLIGH("highlight"),
    CENTERED("centered");

    private final String cssClass;

    JsonTableType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static JsonTableType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, JsonTableType.class, JsonTableType.STRIPED);
    }
}

