package gwt.material.design.incubator.client.loadingdot;

import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.loadingstate.LoadingStatePanel;

/**
 * A loader extension https://nzbin.github.io/three-dots/
 */
public class LoadingDots extends MaterialPanel implements HasType<LoadingDotsType> {

    static {
        IncubatorWidget.showWarning(LoadingStatePanel.class);
        if (AddinsIncubator.isDebug()) {
            MaterialDesign.injectCss(LoadingDotClientBundle.INSTANCE.threeDots());
        } else {
            MaterialDesign.injectCss(LoadingDotDebugClientBundle.INSTANCE.threeDots());
        }

    }

    private CssTypeMixin<LoadingDotsType, LoadingDots> typeMixin;

    public LoadingDots() {
        setType(LoadingDotsType.PULSE);
    }

    @Override
    public void setType(LoadingDotsType type) {
        getTypeMixin().setType(type);
    }

    @Override
    public LoadingDotsType getType() {
        return getTypeMixin().getType();
    }

    protected CssTypeMixin<LoadingDotsType, LoadingDots> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin(this);
        }
        return typeMixin;
    }
}
