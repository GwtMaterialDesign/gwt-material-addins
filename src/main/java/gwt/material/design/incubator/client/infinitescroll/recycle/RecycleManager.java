package gwt.material.design.incubator.client.infinitescroll.recycle;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.incubator.client.infinitescroll.InfiniteScrollPanel;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gwt.material.design.incubator.client.infinitescroll.recycle.RecycleType.DETACH;
import static gwt.material.design.jquery.client.api.JQuery.$;

//@formatter:off

/**
 * Manages all the recycling mechanism to improve scrolling performance.
 *
 * @author kevzlou7979
 */
public class RecycleManager {

    private int loadIndex = 0;
    private int currentIndex = -1;
    private InfiniteScrollPanel parent;
    private Map<Integer, List<Widget>> recycledWidgets = new HashMap<>();
    private RecycleType type;

    public RecycleManager() {
        this(DETACH);
    }

    public RecycleManager(RecycleType type) {
        this.type = type;
    }

    /**
     * Will recycle the provided widgets (@link widgets} with provided {@link RecyclePosition}
     */
    public void recycle(RecyclePosition position) {
        if (position == RecyclePosition.BOTTOM) {
            // Remove the current recycled widgets
            if (currentIndex <= loadIndex) {
                List<Widget> currentWidgets = recycledWidgets.get(currentIndex);
                if (currentWidgets != null) remove(currentWidgets);

                // Add the previous recycled widgets
                if (hasRecycledWidgets()) {
                    List<Widget> nextWidgets = recycledWidgets.get(currentIndex + 1);
                    if (nextWidgets != null) add(nextWidgets);
                    scrollTo(parent.getBufferTop());
                }
                currentIndex++;
            }
        } else {
            if (currentIndex > 0) {
                // Remove the current recycled widgets
                List<Widget> currentWidgets = recycledWidgets.get(currentIndex);
                if (currentWidgets != null) remove(currentWidgets);

                // Add the previous recycled widgets
                List<Widget> previousWidgets = recycledWidgets.get(currentIndex - 1);
                if (previousWidgets != null) add(previousWidgets);
                scrollTo(parentElement().get(0).getScrollHeight() - (parent.getBufferTop() + parent.getBufferBottom() + parentElement().outerHeight()));
                currentIndex--;
            }
        }
    }

    /**
     * Helper method to scroll to a given offset
     */
    protected void scrollTo(int value) {
        $(parent.getElement()).scrollTop(value);
    }

    /**
     * Helper method to remove the provided widgets with {@link RecycleType} defined
     */
    protected void remove(List<Widget> widgets) {
        switch (type) {
            case DETACH:
                widgets.forEach(widget -> widget.removeFromParent());
                break;
            case DISPLAY:
                widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.NONE));
                break;
        }
    }

    /**
     * Helper method to add the provided widgets with {@link RecycleType} defined
     */
    protected void add(List<Widget> widgets) {
        switch (type) {
            case DETACH:
                widgets.forEach(widget -> parent.add(widget));
                break;
            case DISPLAY:
                widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.BLOCK));
                break;
        }
    }

    /**
     * The Parent Infinite scroll element.
     */
    protected JQueryElement parentElement() {
        return $(parent.getElement());
    }

    /**
     * Will add the widgets in a map {@link this#recycledWidgets}
     */
    public void addWidgets(List<Widget> widgets) {
        recycledWidgets.put(loadIndex, widgets);
        loadIndex++;
        recycle(RecyclePosition.BOTTOM);
    }

    /**
     * Determine if there are recycled widgets
     */
    public boolean hasRecycledWidgets() {
        return recycledWidgets.get(currentIndex + 1) != null;
    }

    /**
     * Get all recycled widgets
     */
    public List<Widget> getRecycledWidgets() {
        List<Widget> widgets = new ArrayList<>();
        for (Integer recycledIndex : recycledWidgets.keySet()) {
            widgets.addAll(recycledWidgets.get(recycledIndex));
        }
        return widgets;
    }

    /**
     * Get all recycled widgets with provided recycledIndex
     */
    public List<Widget> getRecycledWidgets(int index) {
        return recycledWidgets.get(index);
    }

    /**
     * Will set the InfiniteScrollPanel and this will manage all the recycling mechanism
     */
    public void setParent(InfiniteScrollPanel parent) {
        this.parent = parent;

        parent.setPaddingBottom(parent.getBufferBottom());
        parent.setPaddingTop(parent.getBufferTop());
    }

    /**
     * Will reset and unload all the configs of this manager.
     */
    public void unload() {
        loadIndex = 0;
        currentIndex = -1;
        recycledWidgets = new HashMap<>();
    }
}
