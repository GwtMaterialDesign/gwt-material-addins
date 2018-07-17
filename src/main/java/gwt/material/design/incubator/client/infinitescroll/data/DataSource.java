package gwt.material.design.incubator.client.infinitescroll.data;

public interface DataSource<T> {

    void load(LoadConfig<T> loadConfig, LoadCallback<T> callback);
}