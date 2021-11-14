package gwt.material.design.addins.client.camera;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.camera.base.*;
import gwt.material.design.addins.client.camera.constants.CameraFacingMode;
import gwt.material.design.addins.client.camera.events.CameraCaptureEvent;
import gwt.material.design.addins.client.camera.events.CameraCaptureEvent.CaptureStatus;
import gwt.material.design.addins.client.camera.events.CameraCaptureHandler;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.jscore.client.api.Navigator;
import gwt.material.design.jscore.client.api.media.*;

import java.util.ArrayList;
import java.util.List;

import static gwt.material.design.addins.client.camera.JsCamera.$;


//@formatter:off

/**
 * <p>
 * MaterialCameraCapture is a widget that captures the video stream from the camera, using the
 * HTML5 {@code MediaDevices.getUserMedia()} (Streams API). This widget can capture images from the video, to allow
 * the upload to the server of photos from the camera.
 * </p>
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p><pre>
 * {@code
 * <ma:camera.MaterialCameraCapture ui:field="camera" />
 * }
 * </pre></p>
 * <p>
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
 * <p>
 * <h3>Styling:</h3>
 * <p>
 * To limit the width of the camera capture widget on mobile devices, you can use {@code max-width: 100%} on the widget.
 * The browser will take care of the aspect ratio of the video.
 * </p>
 * <p>
 * <h3>Notice:</h3>
 * <p>
 * This widget only works on pages served by a secure protocol (HTTPS). For the browser compatibility,
 * access <a href="http://caniuse.com/#feat=stream">http://caniuse.com/#feat=stream</a>
 * </p>
 *
 * @author gilberto-torrezan
 * @author kevzlou7979
 */
// @formatter:on
public class MaterialCameraCapture extends MaterialWidget implements JsLoader, HasCameraCaptureHandlers, HasCameraActions {

    protected int width = 1280;
    protected int height = 720;
    protected boolean pauseOnUnload = false;
    protected CameraFacingMode facingMode = CameraFacingMode.FRONT;
    private MediaStream mediaStream;
    private MaterialWidget video = new MaterialWidget(Document.get().createVideoElement());
    private MaterialPanel overlayPanel;
    private boolean autoPlay = true;

    public MaterialCameraCapture() {
        super(Document.get().createDivElement(), "camera-wrapper");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        setLayoutPosition(Style.Position.RELATIVE);
        add(video);

        load();
    }

    @Override
    public void load() {
        if (autoPlay) play();
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        stop();
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    @Override
    public void play() {
        if (!isSupported()) {
            onCameraCaptureError("MaterialCameraCapture is not supported in this browser.");
            return;
        }

        nativePlay(video.getElement());
    }

    @Override
    public void pause() {
        VideoElement el = video.getElement().cast();
        el.pause();
        onCameraCapturePause();
    }

    @Override
    public void stop() {
        if (pauseOnUnload) {
            pause();
        }

        if (mediaStream != null) {
            for (MediaStreamTrack track : mediaStream.getTracks()) {
                track.stop();
            }
        }
    }

    @Override
    public String captureToDataURL() {
        return captureToDataURL("image/png");
    }

    @Override
    public String captureToDataURL(String mimeType) {
        return nativeCaptureToDataURL(Canvas.createIfSupported().getCanvasElement(), video.getElement(), mimeType);
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
    protected void nativePlay(Element video) {
        MediaStream stream = null;
        if (Navigator.getUserMedia != null) {
            stream = Navigator.getUserMedia;
            GWT.log("Uses Default user Media");
        } else if (Navigator.webkitGetUserMedia != null) {
            stream = Navigator.webkitGetUserMedia;
            GWT.log("Uses Webkit User Media");
        } else if (Navigator.mozGetUserMedia != null) {
            stream = Navigator.mozGetUserMedia;
            GWT.log("Uses Moz User Media");
        } else if (Navigator.msGetUserMedia != null) {
            stream = Navigator.msGetUserMedia;
            GWT.log("Uses Microsoft user Media");
        } else {
            GWT.log("No supported media found in your browser");
        }

        if (stream != null) {
            Navigator.getMedia = stream;
            Constraints constraints = new Constraints();
            constraints.audio = false;

            MediaTrackConstraints mediaTrackConstraints = new MediaTrackConstraints();
            mediaTrackConstraints.width = width;
            mediaTrackConstraints.height = height;
            mediaTrackConstraints.facingMode = facingMode.getName();
            constraints.video = mediaTrackConstraints;

            Navigator.mediaDevices.getUserMedia(constraints).then((streamObj) -> {
                mediaStream = (MediaStream) streamObj;

                if (mediaStream != null) {
                    try {
                        video.setPropertyObject("srcObject", mediaStream);
                    } catch (Exception exception) {
                        if (URL.createObjectURL(mediaStream) != null) {
                            $(video).attr("src", URL.createObjectURL(mediaStream));
                        } else if (WebkitURL.createObjectURL(mediaStream) != null) {
                            $(video).attr("src", WebkitURL.createObjectURL(mediaStream));
                        }
                    } finally {
                        if (video instanceof VideoElement) {
                            ((VideoElement) video).play();
                        }
                    }
                }

                onCameraCaptureLoad();
                return null;
            }).fail((e, error) -> {
                GWT.log("MaterialCameraCapture: An error occured! " + error);
                onCameraCaptureError(error.toString());
                return null;
            });
        }
    }

    /**
     * Native call to capture the frame of the video stream.
     */
    protected String nativeCaptureToDataURL(CanvasElement canvas, Element element, String mimeType) {
        VideoElement videoElement = (VideoElement) element;
        int width = videoElement.getVideoWidth();
        int height = videoElement.getVideoHeight();
        if (Double.isNaN(width) || Double.isNaN(height)) {
            width = videoElement.getClientWidth();
            height = videoElement.getClientHeight();
        }
        canvas.setWidth(width);
        canvas.setHeight(height);
        Context2d context = canvas.getContext2d();
        context.drawImage(videoElement, 0, 0, width, height);
        return canvas.toDataUrl(mimeType);
    }

    /**
     * Tests if the browser supports the Streams API. This should be called before creating any
     * MaterialCameraCapture widgets to avoid errors on the browser.
     *
     * @return <code>true</code> if the browser supports this widget, <code>false</code> otherwise
     */
    public static boolean isSupported() {
        return Navigator.webkitGetUserMedia != null
            || Navigator.getUserMedia != null
            || Navigator.mozGetUserMedia != null
            || Navigator.msGetUserMedia != null;
    }

    public void addOverlay(MaterialWidget overlay) {
        getOverlayPanel().add(overlay);
    }

    public void removeOverlay(MaterialWidget overlay) {
        getOverlayPanel().remove(overlay);
    }

    public void clearOverlays() {
        getOverlayPanel().clear();
    }

    public MaterialWidget getVideo() {
        return video;
    }

    public void setVideo(MaterialWidget video) {
        this.video = video;
    }

    public MaterialPanel getOverlayPanel() {
        if (overlayPanel == null && overlayPanel.isAttached()) {
            overlayPanel = new MaterialPanel();
            overlayPanel.setLayoutPosition(Style.Position.FIXED);
            overlayPanel.setTop(0);
            overlayPanel.setLeft(0);
            overlayPanel.setBottom(0);
            overlayPanel.setRight(0);
            add(overlayPanel);
        }
        return overlayPanel;
    }

    public boolean isAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    /**
     * Set the resolution of the camera
     */
    public void setResolution(int width, int height) {
        this.width = width;
        this.height = height;
        reload();
    }

    /**
     * Set the resolution the camera
     *
     * @see CameraResolution
     */
    public void setResolution(CameraResolution resolution) {
        setResolution(resolution.getWidth(), resolution.getHeight());
    }

    /**
     * Set the facing mode of the camera (Best usecase for Mobile Devices)
     */
    public void setFacingMode(CameraFacingMode facingMode) {
        this.facingMode = facingMode;
        reload();
    }

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
     * Called by the component when the stream when an error occurs.
     */
    protected void onCameraCaptureError(String error) {
        CameraCaptureEvent.fire(this, error);
    }

    @Override
    public HandlerRegistration addCameraCaptureHandler(final CameraCaptureHandler handler) {
        return addHandler(event -> {
            if (isEnabled()) {
                handler.onCameraCaptureChange(event);
            }
        }, CameraCaptureEvent.getType());
    }

    public static void isSupported(CameraSupportCallback callback) {
        if (isSupported()) {
            checkRegisteredCamera(devices -> {
                if (devices.size() > 0) {
                    checkAllowedCamera(callback::call);
                } else {
                    callback.call(false);
                }
            });
        } else {
            callback.call(false);
        }
    }

    public static void checkRegisteredCamera(RegisteredCameraCallback callback) {
        Navigator.mediaDevices.enumerateDevices().then(param1 -> {
            List<MediaDeviceInfo> cameraDevices = new ArrayList<>();
            Object[] objects = (Object[]) param1;
            if (objects != null) {
                for (Object object : objects) {
                    if (object instanceof MediaDeviceInfo) {
                        if (((MediaDeviceInfo) object).kind.equals("videoinput")) {
                            cameraDevices.add((MediaDeviceInfo) object);
                        }
                    }
                }
            }
            callback.call(cameraDevices);
            return true;
        }).fail((e, param1) -> {
            callback.call(new ArrayList<>());
            return false;
        });
    }

    public static void checkAllowedCamera(AllowedCameraCallback callback) {
        Constraints constraints = new Constraints();
        constraints.video = true;
        Navigator.mediaDevices.getUserMedia(constraints).then(param11 -> {
            callback.call(true);
            return true;
        }).fail((e, param11) -> {
            callback.call(false);
            return false;
        });
    }
}
