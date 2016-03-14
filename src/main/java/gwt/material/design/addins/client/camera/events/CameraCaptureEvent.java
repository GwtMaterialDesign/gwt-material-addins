package gwt.material.design.addins.client.camera.events;

import gwt.material.design.addins.client.camera.base.HasCameraCaptureHandlers;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2016 GwtMaterialDesign
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

import gwt.material.design.addins.client.camera.MaterialCameraCapture;

import com.google.gwt.event.shared.GwtEvent;

/**
 * <p>
 * Event that holds informartion about the state of a {@link HasCameraCaptureHandlers}, such
 * as {@link MaterialCameraCapture}.
 * </p>
 * <p>
 * When the stream has started, after the user allows the browser to use the camera, an event 
 * with {@link CaptureStatus#STARTED} is raised. If the stream is paused, an event with
 * {@link CaptureStatus#PAUSED} is raised. If the user doesn't allow the browser to use the camera,
 * or if any other error occurs, an event with  {@link CaptureStatus#ERRORED} is raised, with the 
 * {@link #getErrorMessage()} set.
 * </p>
 * 
 * @author gilberto-torrezan
 */
public class CameraCaptureEvent extends GwtEvent<CameraCaptureHandler> {

    private static Type<CameraCaptureHandler> TYPE = new Type<CameraCaptureHandler>();

    public enum CaptureStatus {
        STARTED, PAUSED, ERRORED;
    }

    private final CaptureStatus captureStatus;
    private final String errorMessage;

    private CameraCaptureEvent(CaptureStatus captureStatus, String errorMessage) {
        this.captureStatus = captureStatus;
        this.errorMessage = errorMessage;
    }

    /**
     * Fires an event with the {@link CaptureStatus}.
     */
    public static <T> void fire(HasCameraCaptureHandlers source, CaptureStatus status) {
        CameraCaptureEvent event = new CameraCaptureEvent(status, null);
        source.fireEvent(event);
    }

    /**
     * Fires an event with the {@link CaptureStatus#ERRORED} status and the error message.
     */
    public static <T> void fire(HasCameraCaptureHandlers source, String errorMessage) {
        CameraCaptureEvent event = new CameraCaptureEvent(CaptureStatus.ERRORED, errorMessage);
        source.fireEvent(event);
    }

    /**
     * Returns the {@link CaptureStatus} that raised this event.
     */
    public CaptureStatus getCaptureStatus() {
        return captureStatus;
    }

    /**
     * Returns the error message when the {@link #getCaptureStatus()} is {@link CaptureStatus#ERRORED}.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<CameraCaptureHandler> getAssociatedType() {
        return TYPE;
    }

    public static Type<CameraCaptureHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CameraCaptureHandler handler) {
        handler.onCameraCaptureChange(this);
    }

}
