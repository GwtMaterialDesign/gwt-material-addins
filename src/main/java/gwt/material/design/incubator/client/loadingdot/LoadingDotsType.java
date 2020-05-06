package gwt.material.design.incubator.client.loadingdot;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

public enum LoadingDotsType implements CssType {

    ELASTIC("dot-elastic"),
    PULSE("dot-pulse"),
    FLASHING("dot-flashing"),
    COLLISION("dot-collision"),
    REVOLUTION("dot-revolution"),
    CAROUSEL("dot-carousel"),
    TYPING("dot-typing"),
    WINDMILL("dot-windmill"),
    BRIKS("dot-bricks"),
    FLOATING("dot-floating"),
    DOT_FIRE("dot-fire"),
    SPIN("dot-spin"),
    FALLING("dot-falling"),
    STRETCHING("dot-stretching");

    private String cssClass;

    LoadingDotsType(String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static LoadingDotsType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, LoadingDotsType.class, PULSE);
    }
}
