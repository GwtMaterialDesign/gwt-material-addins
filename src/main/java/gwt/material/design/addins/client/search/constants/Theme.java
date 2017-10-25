package gwt.material.design.addins.client.search.constants;

import com.google.gwt.dom.client.Style;
import gwt.material.design.client.base.helper.EnumHelper;

public enum Theme implements Style.HasCssName {
    DEFAULT(""),
    LIGHT("light"),
    DARK("dark");

    private String cssClass;

    Theme(String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static Theme fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, Theme.class, DEFAULT);
    }
}
