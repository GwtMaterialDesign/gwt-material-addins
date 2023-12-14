package gwt.material.design.addins.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.banner.MaterialBannerDarkTheme;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.addins.client.dark.AddinsDarkThemeReloader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.jquery.client.api.JQueryElement;

public abstract class AbstractAddinsWidget extends MaterialWidget implements HasDependency {

    protected DependencyMixin<HasDependency> dependencyMixin;

    public AbstractAddinsWidget() {
    }

    public AbstractAddinsWidget(JQueryElement jQueryElement) {
        super(jQueryElement);
    }

    public AbstractAddinsWidget(Element element) {
        super(element);
    }

    public AbstractAddinsWidget(Element element, String... initialClass) {
        super(element, initialClass);
    }

    @Override
    protected void onLoad() {
        getDependencyMixin().install(() -> {
            internalLoad();
            super.onLoad();
        });
    }

    protected abstract void internalLoad();

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    public void unload() {}

    public void reload() {}

    public DependencyMixin<HasDependency> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }
}
