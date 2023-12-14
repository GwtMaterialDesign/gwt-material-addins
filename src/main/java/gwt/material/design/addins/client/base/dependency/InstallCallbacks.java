package gwt.material.design.addins.client.base.dependency;

import com.google.gwt.core.client.GWT;

import java.util.*;

public class InstallCallbacks {

    private static Map<Class<? extends HasDependency>, List<InstallCallback>> callbacksMap = new LinkedHashMap<>();
    private static Map<Class<? extends HasDependency>, Boolean> installedMap = new HashMap<>();

    public InstallCallbacks() {
    }

    public void add(Class<? extends HasDependency> lib, InstallCallback callback) {
        List<InstallCallback> callbacks = get(lib);
        if (callbacks == null) {
            callbacks = new ArrayList<>();
        }
        if (!callbacks.contains(callback)) {
            callbacks.add(callback);
        }
        callbacksMap.put(lib, callbacks);
    }

    public List<InstallCallback> get(Class<? extends HasDependency> lib) {
        return callbacksMap.get(lib);
    }

    public void installed(Class<? extends HasDependency> lib, boolean installed) {
        installedMap.put(lib, installed);
    }

    public boolean isInstalled(Class<? extends HasDependency> lib) {
        Boolean installed = installedMap.get(lib);
        return installed != null ? installed : false;
    }
}
