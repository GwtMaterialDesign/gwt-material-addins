package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasSceneHandlers {

    HandlerRegistration addSceneAddHandler(AddEvent.AddHandler handler);

    HandlerRegistration addSceneChangeHandler(ChangeEvent.ChangeHandler handler);

    HandlerRegistration addSceneDestroyHandler(DestroyEvent.DestroyHandler handler);

    HandlerRegistration addSceneEndHandler(EndEvent.EndHandler handler);

    HandlerRegistration addSceneEnterHandler(EnterEvent.EnterHandler handler);

    HandlerRegistration addSceneLeaveHandler(LeaveEvent.LeaveHandler handler);

    HandlerRegistration addSceneProgressHandler(ProgressEvent.ProgressHandler handler);

    HandlerRegistration addSceneRemoveHandler(RemoveEvent.RemoveHandler handler);

    HandlerRegistration addSceneShiftHandler(ShiftEvent.ShiftHandler handler);

    HandlerRegistration addSceneStartHandler(StartEvent.StartHandler handler);

    HandlerRegistration addSceneUpdateHandler(UpdateEvent.UpdateHandler handler);
}
