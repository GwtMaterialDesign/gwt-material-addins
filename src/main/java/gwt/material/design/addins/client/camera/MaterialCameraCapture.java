package gwt.material.design.addins.client.camera;

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

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.VideoElement;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.camera.base.HasCameraCaptureHandlers;
import gwt.material.design.addins.client.camera.events.CameraCaptureEvent;
import gwt.material.design.addins.client.camera.events.CameraCaptureEvent.CaptureStatus;
import gwt.material.design.addins.client.camera.events.CameraCaptureHandler;
import gwt.material.design.client.base.MaterialWidget;

//@formatter:off
/**
 * <p>
 * MaterialCameraCapture is a widget that captures the video stream from the camera, using the
 * HTML5 {@code MediaDevices.getUserMedia()} (Streams API). This widget can capture images from the video, to allow
 * the upload to the server of photos from the camera.
 * </p>
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <p><pre>
 * {@code
 * <ma:camera.MaterialCameraCapture ui:field="camera" />
 * }
 * </pre></p>
 *
 * <h3>Java Usage:</h3>
 * <p><pre>
 *  if (MaterialCameraCapture.isSupported()){
 *      MaterialCameraCapture camera = new MaterialCameraCapture();
 *      camera.addCameraCaptureHandler(new CameraCaptureHandler() {
 *          {@literal @}Override
 *          public void onCameraCaptureChange(CameraCaptureEvent event) {
 *              if (event.getCaptureStatus() == CaptureStatus.ERRORED){
 *                  Window.alert("Error on starting the camera capture: " + event.getErrorMessage());
 *                  ((MaterialCameraCapture)event.getSource()).removeFromParent();
 *              }
 *          }
 *      });
 *      add(camera); //adds to the layout
 *  }
 *  else {
 *      Window.alert("Sorry, your browser doesn't support the camera capture.");
 *  }
 * </pre></p>
 *
 * <h3>Styling:</h3>
 * <p>
 * To limit the width of the camera capture widget on mobile devices, you can use {@code max-width: 100%} on the widget.
 * The browser will take care of the aspect ratio of the video.
 * </p>
 *
 * <h3>Notice:</h3>
 * <p>
 * This widget only works on pages served by a secure protocol (HTTPS). For the browser compatibility,
 * access <a href="http://caniuse.com/#feat=stream">http://caniuse.com/#feat=stream</a>
 * </p>
 *
 * @author gilberto-torrezan
 */
// @formatter:on
public class MaterialCameraCapture extends MaterialWidget implements HasCameraCaptureHandlers {

    protected boolean pauseOnUnload = true;

    public MaterialCameraCapture() {
        super(Document.get().createVideoElement());
    }

    /**
     * Captures the current frame of the video to an image data URL. It's the same as calling
     * {@link #captureToDataURL(String)} using "image/png".
     *
     * @return The Data URL of the captured image, which can be used as "src" on an "img" element
     * or sent to the server
     */
    public String captureToDataURL() {
        return captureToDataURL("image/png");
    }

    /**
     * Captures the current frame of the video to an image data URL.
     *
     * @param mimeType The type of the output image, such as "image/png" or "image/jpeg".
     *
     * @return The Data URL of the captured image, which can be used as "src" on an "img" element
     * or sent to the server
     */
    public String captureToDataURL(String mimeType) {
        return nativeCaptureToDataURL(Canvas.createIfSupported().getCanvasElement(), getElement(), mimeType);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        VideoElement el = getElement().cast();
        if (el.getSrc() == null || el.isPaused()) {
            play();
        }
    }

    @Override
    protected void onUnload() {
        if (pauseOnUnload) {
            pause();
        }
    }

    /**
     * <p>
     * Starts the video stream from the camera. This is called when the component is loaded.
     * Use {@link CameraCaptureHandler}s to be notified when the stream actually starts or if
     * an error occurs.
     * </p>
     * <p>
     * At this point the user is requested by the browser to allow the application to use the camera.
     * If the user doesn't allow it, an error is notified to the {@link CameraCaptureHandler}s.
     * </p>
     */
    public void play() {
        if (!isSupported()) {
            onCameraCaptureError("MaterialCameraCapture is not supported in this browser.");
            return;
        }
        VideoElement el = getElement().cast();
        if (el.getSrc() == null) {
            nativePlay(getElement());
        } else {
            el.play();
        }
    }

    /**
     * Restarts the video stream from the camera. 
     * The user is requested again by the browser to allow the application to use the camera.
     */
    public void restart() {
        if (!isSupported()) {
            onCameraCaptureError("MaterialCameraCapture is not supported in this browser.");
            return;
        }
        nativePlay(getElement());
    }

    /**
     * Pauses the video stream from the camera.
     */
    public void pause() {
        VideoElement el = getElement().cast();
        el.pause();
        onCameraCapturePause();
    }

    /**
     * Sets if the camera capture should pause when the widget is unloaded.
     * The default is <code>true</code>. 
     */
    public void setPauseOnUnload(boolean pauseOnUnload) {
        this.pauseOnUnload = pauseOnUnload;
    }

    /**
     * Returns if the camera capture should pause when the widget is unloaded.
     * The default is <code>true</code>.
     */
    public boolean isPauseOnUnload() {
        return pauseOnUnload;
    }

    /**
     * Native call to the streams API
     */
    protected native void nativePlay(Element video)/*-{
        var navigator = $wnd.navigator;
        var widget = this;

        var onSuccess = function(stream) {
            var vendorURL = $wnd.URL || $wnd.webkitURL;
            video.src = vendorURL.createObjectURL(stream);
            video.play();
            widget.@gwt.material.design.addins.client.camera.MaterialCameraCapture::onCameraCaptureLoad()();
        };

        var onFailure = function(err) {
            console.log("MaterialCameraCapture: An error occured! " + err);
            widget.@gwt.material.design.addins.client.camera.MaterialCameraCapture::onCameraCaptureError(Ljava/lang/String;)(err.message);
        };

        //using premisses
        if (navigator.mediaDevices.getUserMedia){
            var p = navigator.mediaDevices.getUserMedia({video: true, audio: false});
            p.then(onSuccess);
            //workaround for the catch keyword. See https://groups.google.com/forum/#!topic/google-web-toolkit/t1KGh-7KL-k
            p["catch"](onFailure);
        }
        else {
            navigator.getMedia = (navigator.getUserMedia ||
            navigator.webkitGetUserMedia ||
            navigator.mozGetUserMedia ||
            navigator.msGetUserMedia);
            navigator.getMedia({video: true, audio: false}, onSuccess, onFailure);
        }
    }-*/;

    /**
     * Native call to capture the frame of the video stream.
     */
    protected native String nativeCaptureToDataURL(CanvasElement canvas, Element video, String mimeType)/*-{
        var width = video.videoWidth;
        var height = video.videoHeight;

        if (isNaN(width) || isNaN(height)) {
            width = video.clientWidth;
            height = video.clientHeight;
        }

        canvas.width = width;
        canvas.height = height;

        var context = canvas.getContext('2d');
        context.drawImage(video, 0, 0, width, height);

        var data = canvas.toDataURL(mimeType);
        return data;
    }-*/;

    /**
     * Tests if the browser supports the Streams API. This should be called before creating any
     * MaterialCameraCapture widgets to avoid errors on the browser.
     *
     * @return <code>true</code> if the browser supports this widget, <code>false</code> otherwise 
     */
    public static native boolean isSupported()/*-{
        return !!(navigator.mediaDevices.getUserMedia ||
        navigator.getUserMedia ||
        navigator.webkitGetUserMedia ||
        navigator.mozGetUserMedia ||
        navigator.msGetUserMedia);
    }-*/;

    /**
     * Called by the component when the stream has started.
     */
    protected void onCameraCaptureLoad() {
        CameraCaptureEvent.fire(this, CaptureStatus.STARTED);
    }

    /**
     * Called  by the component when the stream has paused.
     */
    protected void onCameraCapturePause() {
        CameraCaptureEvent.fire(this, CaptureStatus.PAUSED);
    }

    /**
     *  Called by the component when the stream when an error occurs.
     */
    protected void onCameraCaptureError(String error) {
        CameraCaptureEvent.fire(this, error);
    }

    @Override
    public HandlerRegistration addCameraCaptureHandler(final CameraCaptureHandler handler) {
        return addHandler(new CameraCaptureHandler() {
            @Override
            public void onCameraCaptureChange(CameraCaptureEvent event) {
                if(isEnabled()){
                    handler.onCameraCaptureChange(event);
                }
            }
        }, CameraCaptureEvent.getType());
    }

}
