package gwt.material.design.addins.client.cropper.constants;

/**
 * The type of result to return defaults to 'canvas'
 *
 * @author kevzlou7979
 */
public enum Type {

    BASE64("base64"),
    HTML("html"),
    BLOB("blob"),
    ROW_CANVAS("rowcanvas");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
