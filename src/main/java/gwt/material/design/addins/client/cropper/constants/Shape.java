package gwt.material.design.addins.client.cropper.constants;

/**
 * The cropper guideline shape within the viewport defaults to {@link #SQUARE}
 *
 * @author kevzlou7979
 */
public enum  Shape {

    SQUARE("square"),
    CIRCLE("circle");

    private String name;

    Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
