package gwt.material.design.addins.client.base.dependency;

import com.google.gwt.resources.client.TextResource;

public class DependencyResource {

    private TextResource resource;
    private boolean debug;

    public DependencyResource() {
    }

    public DependencyResource(TextResource resource, boolean debug) {
        this.resource = resource;
        this.debug = debug;
    }

    public TextResource getResource() {
        return resource;
    }

    public void setResource(TextResource resource) {
        this.resource = resource;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
