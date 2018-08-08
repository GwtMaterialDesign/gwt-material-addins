package gwt.material.design.incubator.client.infinitescroll.recycle;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.incubator.client.infinitescroll.InfiniteScrollPanel;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static gwt.material.design.incubator.client.infinitescroll.recycle.RecycleType.DETACH;
import static gwt.material.design.jquery.client.api.JQuery.$;

//@formatter:off

/**
 * Manages all the recycling mechanism to improve scrolling performance.
 *
 * @author kevzlou7979
 */
public class RecycleManager {

    private int currentIndex = 0;
    private int stubCount = 0;
    private int loadIndex = 0;
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

        stubCount = determineStubCount();

        switch (position) {
            case BOTTOM:
                if (hasRecycledWidgets()) {
                    // Will remove the  current recycled widgets
                    remove(getRecycledWidgets().stream()
                            .skip(0)
                            .limit((parent.getLimit() * (currentIndex + 1)) - stubCount)
                            .collect(Collectors.toList()));

                    currentIndex++;

                    // Will determine if the current index is greater than the load index then we need to recycle the next
                    // set of recycled widgets
                    if (currentIndex < loadIndex) {
                        add(getRecycledWidgets(currentIndex));
                    }
                }
                break;
            case TOP:
                if (currentIndex > 0) {
                    // Will remove the current recycled widgets
                    remove(getRecycledWidgets(currentIndex));

                    // Will add the previous recycled widgets
                    int skip = ((parent.getLimit() * currentIndex) - parent.getLimit()) - stubCount;
                    insert(getRecycledWidgets().stream()
                            .skip(skip < 0 ? 0 : skip)
                            .limit(parent.getLimit())
                            .collect(Collectors.toList()));

                    currentIndex--;
                }
                break;
        }
    }

    /**
     * Helper method to remove the provided widgets with {@link RecycleType} defined
     */
    protected void remove(List<Widget> widgets) {
        if (widgets != null) {
            switch (type) {
                case DETACH:
                    widgets.forEach(widget -> widget.removeFromParent());
                    break;
                case DISPLAY:
                    widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.NONE));
                    break;
            }
        }
    }

    /**
     * Helper method to insert the provided widgets with {@link RecycleType} defined
     */
    protected void insert(List<Widget> widgets) {
        switch (type) {
            case DETACH:
                for (Widget widget : widgets) {
                    int index = widgets.indexOf(widget);
                    parent.insert(widget, index);
                }

                break;
            case DISPLAY:
                widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.BLOCK));
                break;
        }
    }

    /**
     * Helper method to add the provided widgets with {@link RecycleType} defined
     */
    protected void add(List<Widget> widgets) {
        switch (type) {
            case DETACH:
                for (Widget widget : widgets) {
                    parent.add(widget);
                }

                break;
            case DISPLAY:
                widgets.forEach(widget -> widget.getElement().getStyle().setDisplay(Style.Display.BLOCK));
                break;
        }
    }

    protected int determineStubCount() {
        if (stubCount <= 0) {
            stubCount = parent.getLimit() / 2;
        }
        return stubCount;
    }

    /**
     * Will add the widgets in a map {@link this#recycledWidgets}
     */
    public void recycleWidgets(List<Widget> widgets) {
        recycledWidgets.put(loadIndex, widgets);
        recycle(RecyclePosition.BOTTOM);
        loadIndex++;
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

    public int getStubCount() {
        return stubCount;
    }

    public void setStubCount(int stubCount) {
        this.stubCount = stubCount;
    }

    /**
     * Will set the InfiniteScrollPanel and this will manage all the recycling mechanism
     */
    public void setParent(InfiniteScrollPanel parent) {
        this.parent = parent;
    }

    /**
     * Will reset and unload all the configs of this manager.
     */
    public void unload() {
        currentIndex = 0;
        loadIndex = 0;
        recycledWidgets = new HashMap<>();
    }
}
