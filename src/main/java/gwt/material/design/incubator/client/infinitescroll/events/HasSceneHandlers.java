/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
