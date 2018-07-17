package gwt.material.design.incubator.client.infinitescroll.data;

import java.util.List;

public class LoadResult<T> {

    private final List<T> data;
    private final int offset;
    private final int totalLength;
    private final boolean cacheData;

    public LoadResult(List<T> data, int offset, int totalLength) {
        this(data, offset, totalLength, true);
    }

    public LoadResult(List<T> data, int offset, int totalLength, boolean cacheData) {
        this.data = data;
        this.offset = offset;
        this.totalLength = totalLength;
        this.cacheData = cacheData;
    }

    /**
     * Return result data.
     */
    public List<T> getData() {
        return data;
    }

    /**
     * Return actual offset of the result. In most cases equals requested offset.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Return total length of the data.
     * <br/>
     * <ul>
     *  <li>For non-paging requests equals size of the data.</li>
     *  <li>For paging requests should equals total number of records</li>
     * </ul>
     */
    public int getTotalLength() {
        return totalLength;
    }
}
