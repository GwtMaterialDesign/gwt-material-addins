package gwt.material.design.addins.client.camera;

public enum CameraResolution {

    /**
     * Quarter Video Graphics Array
     */
    QVGA(320, 240),
    /**
     * Standard Definition
     **/
    SD(640, 480),
    /**
     * High Definition
     **/
    HD(1280, 720),
    /**
     * Full High Definition
     **/
    FULL_HD(1920, 1080),
    /**
     * Television 4K
     **/
    TELEVISION_4K(3840, 2160),
    /**
     * Cinema 4K
     **/
    CINEMA_4K(4096, 2160),
    /**
     * 8K
     **/
    _8K(7680, 4320);

    private int width;
    private int height;

    CameraResolution(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
