package gwt.material.design.incubator.client.infinitescroll.data;

import com.google.gwt.user.client.ui.Widget;

public interface Renderer<T> {

    Widget render(T model);
}
