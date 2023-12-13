package gwt.material.design.addins.client.base.dependency;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.base.mixin.DependencyCallback;

import java.util.List;

public class DependencyInjector {

    public static void installJs(DependencyResource dep, DependencyCallback callback) {
        try {
            TextResource resource = dep.getResource();
            String text = resource.getText() + (dep.isDebug() ?
                    "//# sourceURL=" + resource.getName() + ".js" : "");

            // Inject the script resource
            ScriptInjector.fromString(text)
                    .setWindow(ScriptInjector.TOP_WINDOW)
                    .setRemoveTag(!dep.isDebug())
                    .inject();
            if (callback != null) callback.onSuccess();
        } catch (RuntimeException e) {
            if (callback != null) callback.onError(e.getMessage());
        }
    }

    public static void installCss(List<DependencyResource> cssDependencies) {
        DependencyResource dep = getMinifiedOrDebugResource(cssDependencies);
        if (dep != null && dep.getResource() != null) {
            StyleInjector.inject(dep.getResource().getText());
        }
    }

    public static DependencyResource getMinifiedOrDebugResource(List<DependencyResource> resources) {
        if (MaterialAddins.isDebug()) {
            for (DependencyResource resource : resources) {
                if (resource.isDebug()) {
                    return resource;
                }
            }
        } else {
            for (DependencyResource resource : resources) {
                if (!resource.isDebug()) {
                    return resource;
                }
            }
        }
        return null;
    }
}
