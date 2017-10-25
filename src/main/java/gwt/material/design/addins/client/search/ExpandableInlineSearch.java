package gwt.material.design.addins.client.search;

import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.CssName;

public class ExpandableInlineSearch extends InlineSearch {

    private String width;

    private ToggleStyleMixin<ExpandableInlineSearch> toggleStyleMixin;

    public ExpandableInlineSearch() {
        super();
        addStyleName(AddinsCssName.EXPANDABLE_SEARCH);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        registerHandler(addCloseHandler(closeEvent -> close()));
        registerHandler(addBlurHandler(blurEvent -> addStyleName(CssName.INACTIVE)));
        registerHandler(addFocusHandler(focusEvent -> removeStyleName(CssName.INACTIVE)));
    }

    @Override
    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public void open() {
        super.open();

        getToggleStyleMixin().setOn(true);
        super.setWidth(width);
    }

    public boolean isOpen() {
        return getToggleStyleMixin().isOn();
    }

    public void close() {
        getToggleStyleMixin().setOn(false);
        super.setWidth("0px");
    }

    protected ToggleStyleMixin<ExpandableInlineSearch> getToggleStyleMixin() {
        if (toggleStyleMixin == null) {
            toggleStyleMixin = new ToggleStyleMixin<>(this, CssName.OPEN);
        }
        return toggleStyleMixin;
    }
}
