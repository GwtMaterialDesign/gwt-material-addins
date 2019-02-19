package gwt.material.design.incubator.client.animation.checkmark;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasDelayTransition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.html.Div;
import gwt.material.design.client.ui.html.Span;
import gwt.material.design.incubator.client.AddinsIncubator;

public class CheckMark extends MaterialWidget implements HasDelayTransition {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(CheckMarkClientDebugBundle.INSTANCE.checkMarkDebugCss());
        } else {
            MaterialDesignBase.injectCss(CheckMarkClientBundle.INSTANCE.checkMarkCss());
        }
    }

    static String CHECK_MARK = "check-mark";
    static String HIDE = "hide";

    private Div iconWrapper = new Div();
    private Span tipLine = new Span();
    private Span longLine = new Span();
    private Div placeholder = new Div();
    private Div fixLine = new Div();

    private int delayInMillis;

    private ToggleStyleMixin<CheckMark> toggleStyleMixin;

    public CheckMark() {
        super(Document.get().createDivElement(), CHECK_MARK);

        iconWrapper.addStyleName("sa-icon sa-success animate");
        tipLine.addStyleName("sa-line sa-tip animateSuccessTip");
        longLine.addStyleName("sa-line sa-long animateSuccessLong");
        placeholder.addStyleName("sa-placeholder");
        fixLine.addStyleName("sa-fix");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        add(iconWrapper);
        iconWrapper.add(tipLine);
        iconWrapper.add(longLine);
        iconWrapper.add(placeholder);
        iconWrapper.add(fixLine);
    }

    public void animate() {
        Scheduler.get().scheduleFixedDelay(() -> {
            getToggleStyleMixin().setOn(false);
            return false;
        }, delayInMillis);
    }

    public void reset() {
        getToggleStyleMixin().setOn(true);
    }

    public ToggleStyleMixin<CheckMark> getToggleStyleMixin() {
        if (toggleStyleMixin == null) {
            toggleStyleMixin = new ToggleStyleMixin<>(this, HIDE);
        }
        return toggleStyleMixin;
    }

    @Override
    public void setDelay(int delayInMillis) {
        this.delayInMillis = delayInMillis;
    }

    @Override
    public int getDelay() {
        return delayInMillis;
    }
}
