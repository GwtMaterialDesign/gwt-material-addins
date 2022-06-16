package gwt.material.design.addins.client.pinch;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.pinch.events.HasPinchZoomHandlers;
import gwt.material.design.addins.client.pinch.events.OnZoomEndEvent;
import gwt.material.design.addins.client.pinch.events.OnZoomStartEvent;
import gwt.material.design.addins.client.pinch.js.JsPinchOptions;
import gwt.material.design.addins.client.pinch.js.JsPinchZoom;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialToast;

public class PinchZoomPanel extends MaterialPanel implements HasPinchZoomHandlers {

    protected JsPinchZoom jsPinchZoom;

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(PinchDebugClientBundle.INSTANCE.pinchJs());
        } else {
            MaterialDesignBase.injectJs(PinchClientBundle.INSTANCE.pinchJs());
        }
    }

    protected JsPinchOptions options = new JsPinchOptions();

    public PinchZoomPanel() {

    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    protected void load() {

        options.onZoomStart = (param1, param2) -> {
            fireEvent(new OnZoomStartEvent());
        };

        options.onZoomEnd = (param1, param2) -> {
            fireEvent(new OnZoomEndEvent());
        };

        options.onDoubleTap = (param1, param2) -> {
            
        };

        jsPinchZoom = new JsPinchZoom(getElement(), options);
    }

    public void setTapZoomFactor(Integer tapZoomFactor) {
        options.tapZoomFactor = tapZoomFactor;
    }

    public Integer getTapZoomFactor() {
        return options.tapZoomFactor;
    }

    public void setLockDragAxis(Boolean lockDragAxis) {
        options.lockDragAxis = lockDragAxis;
    }

    public boolean isLockDragAxis() {
        return options.lockDragAxis;
    }

    public void enable() {
        jsPinchZoom.enable();
    }

    public void disable() {
        jsPinchZoom.disable();
    }

    @Override
    public HandlerRegistration addOnZoomStartHandler(OnZoomStartEvent.OnZoomStartHandler handler) {
        return addHandler(handler, OnZoomStartEvent.TYPE);
    }

    @Override
    public HandlerRegistration addOnZoomEndHandler(OnZoomEndEvent.OnZoomEndHandler handler) {
        return addHandler(handler, OnZoomEndEvent.TYPE);
    }
}
