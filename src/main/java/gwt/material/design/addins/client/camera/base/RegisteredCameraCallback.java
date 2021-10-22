package gwt.material.design.addins.client.camera.base;

import gwt.material.design.jscore.client.api.media.MediaDeviceInfo;

import java.util.List;

public interface RegisteredCameraCallback {

    void call(List<MediaDeviceInfo> devices);
}
