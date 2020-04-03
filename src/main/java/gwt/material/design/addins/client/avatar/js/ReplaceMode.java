package gwt.material.design.addins.client.avatar.js;

public enum ReplaceMode {

    /**
     * Icons are never rendered automatically. You need to call jdenticon.update() manually to render identicons.
     */
    NEVER("never"),

    /**
     * Icons are rendered once the page has loaded. Any dynamically inserted or modified icons will not be rendered
     * unless jdenticon.update() is manually called.
     */
    ONCE("once"),

    /**
     * Icons are rendered upon page load, and the DOM is monitored for new icons using a MutationObserver.
     * Use this if icons are inserted dynamically, e.g. by using Angular, React or VanillaJS. This option behaves as
     * "once" in IE<11.
     */
    OBSERVE("observe");

    private String name;

    ReplaceMode(java.lang.String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
