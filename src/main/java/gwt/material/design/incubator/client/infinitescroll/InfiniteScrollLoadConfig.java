package gwt.material.design.incubator.client.infinitescroll;

public class InfiniteScrollLoadConfig {

    private final int offset;
    private final int limit;

    public InfiniteScrollLoadConfig(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }
}
