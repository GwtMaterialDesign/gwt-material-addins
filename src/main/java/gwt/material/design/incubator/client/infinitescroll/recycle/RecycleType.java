package gwt.material.design.incubator.client.infinitescroll.recycle;

/**
 * Recycle Type - provide a recycling mechanism managed by {@link RecycleManager}.
 *
 * @author kevzlou7979
 */
public enum RecycleType {

    /**
     * Will recycle the widgets affecting only it's display by setting the
     * css {@link com.google.gwt.dom.client.Style.Display} property to BLOCK or NONE
     */
    DISPLAY,
    /**
     * Will recycle the widgets on it's DOM structure by attaching or detaching the widgets
     */
    DETACH
}
