package gwt.material.design.addins.client.base.dependency;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.base.mixin.DependencyCallback;

import java.util.List;

public class DependencyInjector {

    public static void installJs(List<DependencyResource> resources, DependencyCallback callback) {
        try {
            for (DependencyResource dep : resources) {
                TextResource resource = MaterialAddins.isDebug() ? dep.getDebug() : dep.getMinified();
                String text = resource.getText() + (MaterialAddins.isDebug() ?
                        "//# sourceURL=" + resource.getName() + ".js" : "");

                // Inject the script resource
                ScriptInjector.fromString(text)
                        .setWindow(ScriptInjector.TOP_WINDOW)
                        .setRemoveTag(!MaterialAddins.isDebug())
                        .inject();


            }
            if (callback != null) callback.onSuccess();
        } catch (RuntimeException e) {
            if (callback != null) callback.onError(e.getMessage());
        }
    }

    public static void installCss(List<DependencyResource> cssDependencies) {
        for (DependencyResource dep : cssDependencies) {
            if (MaterialAddins.isDebug()) {
                StyleInjector.inject(dep.getDebug().getText());
            } else {
                StyleInjector.inject(dep.getMinified().getText());
            }
        }
    }
}
