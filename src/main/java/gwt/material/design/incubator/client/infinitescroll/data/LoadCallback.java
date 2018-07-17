package gwt.material.design.incubator.client.infinitescroll.data;

public interface LoadCallback<T> {
    /**
     * Should be called when async load success.
     */
    void onSuccess(LoadResult<T> loadResult);

    /**
     * Should be called when async load failed.
     */
    void onFailure(Throwable caught);
}
