package gwt.material.design.incubator.client.kanban.util;

import com.google.gwt.core.client.Scheduler;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.kanban.Kanban;
import gwt.material.design.incubator.client.kanban.KanbanClientBundle;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.Date;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class KanbanResponsiveLoader {

    static {
        MaterialDesign.injectJs(KanbanClientBundle.INSTANCE.longPressEventJs());
    }

    private Kanban kanban;
    private ToggleStyleMixin<Kanban> toggleStyleMixin;

    protected KanbanResponsiveLoader() {
    }

    public KanbanResponsiveLoader(Kanban kanban) {
        this.kanban = kanban;
    }

    public void load() {
        if (kanban != null && kanban.isAttached()) {
            getToggleStyleMixin().setOn(true);
        }
    }

    public void unload() {
        if (kanban != null && kanban.isAttached()) {
            getToggleStyleMixin().setOn(false);
        }
    }

    public boolean isResponsive() {
        return getToggleStyleMixin().isOn();
    }

    public ToggleStyleMixin<Kanban> getToggleStyleMixin() {
        if (toggleStyleMixin == null) {
            toggleStyleMixin = new ToggleStyleMixin<>(kanban, "responsive");
        }
        return toggleStyleMixin;
    }
}
