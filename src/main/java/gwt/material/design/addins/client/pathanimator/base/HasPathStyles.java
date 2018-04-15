package gwt.material.design.addins.client.pathanimator.base;

import com.google.gwt.dom.client.Element;
import gwt.material.design.client.constants.Color;

/**
 * Accessing the Path Navigation Bridge element that performs
 * the illusion that the source element is path animated to target element.
 *
 * @author kevzlou7979@gmail.com
 */
public interface HasPathStyles {

    /**
     * Set the shadow of the bridge element
     */
    void setShadow(Integer depth);

    /**
     * Set the background color of the bridge element
     */
    void setBackgroundColor(Color color);

    /**
     * Set the css style property directly to the bridge element
     */
    void setStyleProperty(PathStyleProperty property);

    /**
     * Set the css style property directly to the bridge element
     * with parameters.
     */
    void setStyleProperty(String property, String value);

    /**
     * Clears the style property provided
     */
    void clearStyleProperty(String property);

    /**
     * Will clear all the styles of the bridge element.
     */
    void clearStyles();

    /**
     * Get the Bridge element - the Div that provides an illusion between the path animation of the source element
     * and the target element.
     */
    Element getBridgeElement();
}
