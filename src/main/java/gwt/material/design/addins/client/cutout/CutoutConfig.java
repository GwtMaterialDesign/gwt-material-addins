package gwt.material.design.addins.client.cutout;

public class CutoutConfig {

    private boolean absolute;
    private int addedOffsetTop;

    public CutoutConfig() {
    }

    public CutoutConfig(boolean absolute) {
        this.absolute = absolute;
    }

    public CutoutConfig(boolean absolute, int addedOffsetTop) {
        this.absolute = absolute;
        this.addedOffsetTop = addedOffsetTop;
    }

    public boolean isAbsolute() {
        return absolute;
    }

    public void setAbsolute(boolean absolute) {
        this.absolute = absolute;
    }

    public int getAddedOffsetTop() {
        return addedOffsetTop;
    }

    public void setAddedOffsetTop(int addedOffsetTop) {
        this.addedOffsetTop = addedOffsetTop;
    }
}
