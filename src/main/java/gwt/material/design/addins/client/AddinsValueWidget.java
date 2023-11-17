package gwt.material.design.addins.client;

import com.google.gwt.dom.client.Element;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.HasDependency;
import gwt.material.design.client.base.mixin.DependencyMixin;

public abstract class AddinsValueWidget<T> extends AbstractValueWidget<T> implements HasDependency {

    protected DependencyMixin dependencyMixin;

    public AddinsValueWidget(Element element) {
        super(element);
    }

    public AddinsValueWidget(Element element, String... initialClass) {
        super(element, initialClass);
    }

    @Override
    public void onDependencyLoaded() {

    }

    public boolean isDependencyLoaded() {
        return getDependencyMixin().isDependencyLoaded(getClass());
    }

    public DependencyMixin getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin(getClass());
        }
        return dependencyMixin;
    }
}
