package gwt.material.design.addins.client.carousel.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

/**
 * Types of Carousel.<br>
 *
 * @author kevzlou7979
 */
public enum CarouselType implements CssType {
    DEFAULT(""),
    IMAGE("carousel-image"),
    ONBOARD("carousel-onboard");

    private final String cssClass;

    CarouselType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static CarouselType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, CarouselType.class, DEFAULT);
    }
}