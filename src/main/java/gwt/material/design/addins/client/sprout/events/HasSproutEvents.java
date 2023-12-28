/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2023 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
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
