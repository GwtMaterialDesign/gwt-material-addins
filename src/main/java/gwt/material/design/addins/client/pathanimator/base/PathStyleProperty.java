package gwt.material.design.addins.client.pathanimator.base;

/**
 * A property to handle the css properties to stylize
 * the Path Animation Bridge element {@link PathStylerMixin}
 */
public class PathStyleProperty {

    private String property;
    private String value;

    public PathStyleProperty() {
    }

    public PathStyleProperty(String property, String value) {
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
