package gwt.material.design.addins.client.cropper.constants;

/**
 * The size of the cropped image defaults to {@link #VIEWPORT}
 */
public enum Size {
    VIEWPORT("viewport"),
    ORIGINAL("original");

    private String name;

    Size(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
