package gwt.material.design.incubator.client.infinitescroll;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.incubator.client.infinitescroll.constants.RecycleType;
import gwt.material.design.incubator.client.infinitescroll.constants.RecycleViewPosition;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class DefaultScrollRecycler implements ScrollRecycler {

    private int loadIndex = 0;
    private int currentIndex = -1;
    private InfiniteScrollPanel parent;
    private RecycleType type = RecycleType.DETACH;
    private Map<Integer, List<Widget>> cachedWidgets = new HashMap<>();

    public DefaultScrollRecycler(InfiniteScrollPanel parent) {
        this.parent = parent;
    }

    @Override
    public void recycle(RecycleViewPosition position) {
        if (position == RecycleViewPosition.BOTTOM) {
            recycleBottom();
        } else {
            recycleTop();
        }
    }

    protected void recycleTop() {
        if (currentIndex > 0) {
            // Remove the current cached widgets
            List<Widget> currentWidgets = cachedWidgets.get(currentIndex);
            if (currentWidgets != null) remove(currentWidgets);

            // Add the previous cached widgets
            List<Widget> previousWidgets = cachedWidgets.get(currentIndex - 1);
            if (previousWidgets != null) add(previousWidgets);

            // Will scroll to the way top for the widget
            double val = parentElement().get(0).getScrollHeight() - (parent.getBufferTop() + parent.getBufferBottom() + parentElement().outerHeight());
            $(parent.getElement()).scrollTop((int) val);

            currentIndex--;
        }
    }

    protected void recycleBottom() {
        // Remove the current cached widgets
        List<Widget> currentWidgets = cachedWidgets.get(currentIndex);
        if (currentWidgets != null) remove(currentWidgets);

        // Add the previous cached widgets
        if (hasCachedWidgets()) {
            List<Widget> nextWidgets = cachedWidgets.get(currentIndex + 1);
            if (nextWidgets != null) add(nextWidgets);

            // Will scroll to the way top for the widget
            $(parent.getElement()).scrollTop(parent.getBufferTop());
        }

        currentIndex++;
    }

    protected void remove(List<Widget> widgets) {
        if (type == RecycleType.VISIBILITY) {
            widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.NONE));
        } else if (type == RecycleType.DETACH) {
            widgets.forEach(widget -> widget.removeFromParent());
        }
    }

    protected void add(List<Widget> widgets) {
        if (type == RecycleType.VISIBILITY) {
            widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.BLOCK));
        } else if (type == RecycleType.DETACH) {
            widgets.forEach(widget -> parent.add(widget));
        }
    }

    protected JQueryElement parentElement() {
        return $(parent.getElement());
    }

    @Override
    public void addWidgets(List<Widget> widgets) {
        cachedWidgets.put(loadIndex, widgets); // 0
        loadIndex++;
        recycle(RecycleViewPosition.BOTTOM);
    }

    public boolean hasCachedWidgets() {
        return cachedWidgets.get(currentIndex + 1) != null;
    }
}
