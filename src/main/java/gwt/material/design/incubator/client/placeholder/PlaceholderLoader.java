package gwt.material.design.incubator.client.placeholder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.base.MaterialWidget;

public class PlaceholderLoader {

    private int totalItems;
    private MaterialWidget container;
    private PlaceholderRenderer renderer;

    public PlaceholderLoader setContainer(MaterialWidget container) {
        this.container = container;
        return this;
    }

    public PlaceholderLoader setRenderer(PlaceholderRenderer renderer) {
        this.renderer = renderer;
        return this;
    }

    public PlaceholderLoader setTotalItems(int totalItems) {
        this.totalItems = totalItems;
        return this;
    }

    public void load() {
        if (container != null) {
            if (renderer != null) {
                container.clear();
                for (int i = 0; i < totalItems; i++) {
                    Widget widget = renderer.render();
                    container.add(widget);
                }
            } else {
                GWT.log("Widget renderer is not defined");
            }
        } else {
            GWT.log("Container is not defined.", new IllegalStateException());
        }
    }

    public void unload(){
        container.clear();
    }
}
