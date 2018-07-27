package gwt.material.design.incubator.client.infinitescroll.recycle;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.incubator.client.infinitescroll.InfiniteScrollPanel;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class RecycleManager {

    private int loadIndex = 0;
    private int currentIndex = -1;
    private InfiniteScrollPanel parent;
    private Map<Integer, List<Widget>> recycledWidgets = new HashMap<>();
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
            // Remove the current recycled widgets
            List<Widget> currentWidgets = recycledWidgets.get(currentIndex);
            if (currentWidgets != null) remove(currentWidgets);

            // Add the previous recycled widgets
            List<Widget> previousWidgets = recycledWidgets.get(currentIndex - 1);
            if (previousWidgets != null) add(previousWidgets);
            scrollTo(parentElement().get(0).getScrollHeight() - (options.getBufferTop() + options.getBufferBottom() + parentElement().outerHeight()));
            currentIndex--;
        }
    }

    protected void recycleBottom() {
        // Remove the current recycled widgets
        if (currentIndex <= loadIndex) {
            List<Widget> currentWidgets = recycledWidgets.get(currentIndex);
            if (currentWidgets != null) remove(currentWidgets);

            // Add the previous recycled widgets
            if (hasRecycledWidgets()) {
                List<Widget> nextWidgets = recycledWidgets.get(currentIndex + 1);
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
        switch (options.getType()) {
            case DETACH:
                widgets.forEach(widget -> widget.removeFromParent());
                break;
            case DISPLAY:
                widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.NONE));
                break;
        }
    }

    protected void add(List<Widget> widgets) {
        switch (options.getType()) {
            case DETACH:
                widgets.forEach(widget -> parent.add(widget));
                break;
            case DISPLAY:
                widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.BLOCK));
                break;
        }
    }

    protected JQueryElement parentElement() {
        return $(parent.getElement());
    }

    public void addWidgets(List<Widget> widgets) {
        recycledWidgets.put(loadIndex, widgets);
        loadIndex++;
        recycle(RecyclePosition.BOTTOM);
    }

    public boolean hasRecycledWidgets() {
        return recycledWidgets.get(currentIndex + 1) != null;
    }

    public List<Widget> getRecycledWidgets() {
        List<Widget> widgets = new ArrayList<>();
        for (Integer recycledIndex : recycledWidgets.keySet()) {
            widgets.addAll(recycledWidgets.get(recycledIndex));
        }
        return widgets;
    }

    public void setParent(InfiniteScrollPanel parent) {
        this.parent = parent;

        parent.setPaddingBottom(options.getBufferBottom());
        parent.setPaddingTop(options.getBufferTop());
    }

    public void unload() {
        loadIndex = 0;
        currentIndex = -1;
        recycledWidgets = new HashMap<>();
    }
}
