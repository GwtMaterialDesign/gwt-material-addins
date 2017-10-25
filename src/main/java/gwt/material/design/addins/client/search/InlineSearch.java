package gwt.material.design.addins.client.search;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.search.constants.Theme;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.base.viewport.Resolution;
import gwt.material.design.client.base.viewport.ViewPort;
import gwt.material.design.client.ui.MaterialSearch;

public class InlineSearch extends MaterialSearch {

    private HandlerRegistration focusHandler;
    private HandlerRegistration blurHandler;
    private CssNameMixin<InlineSearch, Theme> cssNameMixin;

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(InlineSearchDebugClientBundle.INSTANCE.inlineSearchDebugCss());
        } else {
            MaterialDesignBase.injectCss(InlineSearchClientBundle.INSTANCE.inlineSearchCss());
        }
    }

    public InlineSearch() {
        super();
        addStyleName(AddinsCssName.INLINE_SEARCH);
    }

    @Override
    protected void onLoad() {
        super.onLoad();


        ViewPort.when(Resolution.ALL_MOBILE).then(portChange -> {
            focusHandler = registerHandler(addFocusHandler(focusEvent -> addStyleName(AddinsCssName.WIDE)));
            blurHandler = registerHandler(addBlurHandler(blurEvent -> removeStyleName(AddinsCssName.WIDE)));
        }, viewPortRect -> {
            if (focusHandler != null && blurHandler != null) {
                focusHandler.removeHandler();
                blurHandler.removeHandler();
            }

            focusHandler = null;
            blurHandler = null;
            return true;
        });
    }

    public void setTheme(Theme theme) {
        getCssNameMixin().setCssName(theme);
    }

    protected CssNameMixin<InlineSearch, Theme> getCssNameMixin() {
        if (cssNameMixin == null) {
            cssNameMixin = new CssNameMixin<>(this);
        }
        return cssNameMixin;
    }
}
