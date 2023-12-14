package gwt.material.design.addins.client.base.dependency;

import com.google.gwt.resources.client.TextResource;

public class DependencyResource {

    private TextResource minified;
    private TextResource debug;

    public DependencyResource() {
    }

    public DependencyResource(TextResource minified, TextResource debug) {
        this.minified = minified;
        this.debug = debug;
    }

    public TextResource getMinified() {
        return minified;
    }

    public void setMinified(TextResource minified) {
        this.minified = minified;
    }

    public TextResource getDebug() {
        return debug;
    }

    public void setDebug(TextResource debug) {
        this.debug = debug;
    }
}
