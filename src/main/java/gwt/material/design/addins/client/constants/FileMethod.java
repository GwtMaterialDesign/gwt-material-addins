package gwt.material.design.addins.client.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

/**
 * Defaults to "post" and can be changed to "put" if necessary.
 * @author kevzlou7979
 */
public enum FileMethod implements CssType {
    POST("post"),
    PUT("put");

    private final String cssClass;

    FileMethod(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static FileMethod fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, FileMethod.class, POST);
    }
}