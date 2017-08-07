package gwt.material.design.addins.client.camera.constants;

import java.util.ArrayList;
import java.util.List;

public enum CameraFacingMode {
    FRONT("user"),
    REAR("environment");

    String name;

    CameraFacingMode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<CameraFacingMode> getFacingModes() {
        List<CameraFacingMode> facingModes = new ArrayList<>();
        facingModes.add(CameraFacingMode.FRONT);
        facingModes.add(CameraFacingMode.REAR);
        return facingModes;
    }
}