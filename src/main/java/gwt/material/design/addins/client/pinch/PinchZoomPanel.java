/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2022 GwtMaterialDesign
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
package gwt.material.design.addins.client.pinch;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.pinch.events.HasPinchZoomHandlers;
import gwt.material.design.addins.client.pinch.events.OnZoomEndEvent;
import gwt.material.design.addins.client.pinch.events.OnZoomStartEvent;
import gwt.material.design.addins.client.pinch.js.JsPinchOptions;
import gwt.material.design.addins.client.pinch.js.JsPinchZoom;

import java.util.Collections;
import java.util.List;

public class PinchZoomPanel extends AbstractAddinsWidget implements HasPinchZoomHandlers {

    protected JsPinchZoom jsPinchZoom;

    protected JsPinchOptions options = new JsPinchOptions();

    public PinchZoomPanel() {

    }

    @Override
    protected void internalLoad() {
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

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(PinchClientBundle.INSTANCE.pinchJs(), PinchDebugClientBundle.INSTANCE.pinchDebugJs()));
    }
}
