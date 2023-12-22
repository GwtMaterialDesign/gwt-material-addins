package gwt.material.design.addins.client.sprout.events;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasSproutEvents {

    HandlerRegistration addPlayHandler(PlayEvent.PlayHandler handler);

    HandlerRegistration addPauseHandler(PauseEvent.PauseHandler handler);

    HandlerRegistration addLoadingHandler(LoadingEvent.LoadingHandler handler);

    HandlerRegistration addProgressHandler(ProgressEvent.ProgressHandler handler);

    HandlerRegistration addCompletedHandler(CompletedEvent.CompletedHandler handler);

    HandlerRegistration addVolumeHandler(VolumeEvent.VolumeHandler handler);

    HandlerRegistration addReady(ReadyEvent.ReadyHandler handler);

    HandlerRegistration addRateChangeHandler(RateChangeEvent.RateChangeHandler handler);

    HandlerRegistration addQualityLevelsHandler(QualityLevelsEvent.QualityLevelsHandler handler);

    HandlerRegistration addQualityLevelChangeHandler(QualityLevelChangeEvent.QualityLevelChangeHandler handler);

    HandlerRegistration addSwitchVideoHandler(SwitchVideoEvent.SwitchVideoHandler handler);

    HandlerRegistration addPlaylistCompleteHandler(PlaylistCompleteEvent.PlaylistCompleteHandler handler);
}
