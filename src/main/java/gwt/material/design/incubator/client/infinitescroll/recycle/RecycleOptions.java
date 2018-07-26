package gwt.material.design.incubator.client.infinitescroll.recycle;

public class RecycleOptions {

    private int bufferTop = 40;
    private int bufferBottom = 40;
    private RecycleType type = RecycleType.DETACH;

    public RecycleOptions() {
    }

    public RecycleOptions(int bufferTop, int bufferBottom, RecycleType type) {
        this.bufferTop = bufferTop;
        this.bufferBottom = bufferBottom;
        this.type = type;
    }

    public int getBufferTop() {
        return bufferTop;
    }

    public void setBufferTop(int bufferTop) {
        this.bufferTop = bufferTop;
    }

    public int getBufferBottom() {
        return bufferBottom;
    }

    public void setBufferBottom(int bufferBottom) {
        this.bufferBottom = bufferBottom;
    }

    public RecycleType getType() {
        return type;
    }

    public void setType(RecycleType type) {
        this.type = type;
    }
}
