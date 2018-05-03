package gwt.material.design.incubator.client.language;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

public enum LanguageSelectorType implements CssType {

    IMAGE("language-selector-image"),
    TEXT("language-selector-text");

    private final String cssClass;

    LanguageSelectorType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static LanguageSelectorType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, LanguageSelectorType.class, IMAGE);
    }
}
