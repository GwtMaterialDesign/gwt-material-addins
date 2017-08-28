package gwt.material.design.addins.client.image.constants;

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
