package gwt.material.design.incubator.client.async.events;

public interface HasAsyncHandlers {

    void addLoadingHandler(LoadingEvent.LoadingHandler handler);

    void addErrorHandler(ErrorEvent.ErrorHandler handler);

    void addSuccessHandler(SuccessEvent.SuccessHandler handler);
}
