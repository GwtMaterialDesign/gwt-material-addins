package gwt.material.design.incubator.client.infinitescroll.recycle;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.incubator.client.infinitescroll.InfiniteScrollPanel;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class RecycleManager {

    private int loadIndex = 0;
    private int currentIndex = -1;
    private InfiniteScrollPanel parent;
    private Map<Integer, List<Widget>> cachedWidgets = new HashMap<>();
    private RecycleOptions options = new RecycleOptions();

    public RecycleManager() {
        this(new RecycleOptions());
    }

    public RecycleManager(RecycleOptions options) {
        this.options = options;
    }

    public void recycle(RecyclePosition position) {
        if (position == RecyclePosition.BOTTOM) {
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
            scrollTo(parentElement().get(0).getScrollHeight() - (options.getBufferTop() + options.getBufferBottom() + parentElement().outerHeight()));
            currentIndex--;
        }
    }

    protected void recycleBottom() {
        // Remove the current cached widgets
        if (currentIndex <= loadIndex) {
            List<Widget> currentWidgets = cachedWidgets.get(currentIndex);
            if (currentWidgets != null) remove(currentWidgets);

            // Add the previous cached widgets
            if (hasCachedWidgets()) {
                List<Widget> nextWidgets = cachedWidgets.get(currentIndex + 1);
                if (nextWidgets != null) add(nextWidgets);
                scrollTo(options.getBufferTop());
            }
            currentIndex++;
        }
    }

    protected void scrollTo(int value) {
        $(parent.getElement()).scrollTop(value);
    }

    protected void remove(List<Widget> widgets) {
        if (options.getType() == RecycleType.VISIBILITY) {
            widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.NONE));
        } else if (options.getType() == RecycleType.DETACH) {
            widgets.forEach(widget -> widget.removeFromParent());
        }
    }

    protected void add(List<Widget> widgets) {
        if (options.getType() == RecycleType.VISIBILITY) {
            widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.BLOCK));
        } else if (options.getType() == RecycleType.DETACH) {
            widgets.forEach(widget -> parent.add(widget));
        }
    }

    protected JQueryElement parentElement() {
        return $(parent.getElement());
    }

    public void addWidgets(List<Widget> widgets) {
        cachedWidgets.put(loadIndex, widgets); // 0
        loadIndex++;
        recycle(RecyclePosition.BOTTOM);
    }

    public boolean hasCachedWidgets() {
        return cachedWidgets.get(currentIndex + 1) != null;
    }

    public void setParent(InfiniteScrollPanel parent) {
        this.parent = parent;

        parent.setPaddingBottom(options.getBufferBottom());
        parent.setPaddingTop(options.getBufferTop());
    }
}
