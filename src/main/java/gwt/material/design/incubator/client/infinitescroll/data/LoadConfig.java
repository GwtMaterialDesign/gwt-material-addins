package gwt.material.design.incubator.client.infinitescroll.data;

public class LoadConfig<T> {

    private final int offset;
    private final int limit;

    public LoadConfig(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    /**
     * Get load offset.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Get load limit. Set to "0" for no limit.
     */
    public int getLimit() {
        return limit;
    }
}
