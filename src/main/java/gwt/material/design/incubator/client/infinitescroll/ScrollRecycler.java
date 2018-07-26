package gwt.material.design.incubator.client.infinitescroll;

import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.incubator.client.infinitescroll.constants.RecycleViewPosition;

import java.util.List;

public interface ScrollRecycler {

    void recycle(RecycleViewPosition position);

    void addWidgets(List<Widget> widgets);

    boolean hasCachedWidgets();
}
