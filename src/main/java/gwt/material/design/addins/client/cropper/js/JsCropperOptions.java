package gwt.material.design.addins.client.cropper.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JsCopper JsInterop Options
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsCropperOptions {

    /**
     * The outer container of the cropper.
     */
    @JsProperty
    public JsCropperDimension boundary;

    /**
     * The inner container of the cropper. The visible part of the image
     */
    @JsProperty
    public JsCropperDimension viewport;

    /**
     * A class of your choosing to add to the container to add custom styles to your cropper
     */
    @JsProperty
    public String customClass;

    /**
     * Enable or disable support for specifying a custom orientation when binding images.
     */
    @JsProperty
    public boolean enableOrientation;

    /**
     * Enable zooming functionality. If set to false - scrolling and pinching would not zoom.
     */
    @JsProperty
    public boolean enableZoom;

    /**
     * Restricts zoom so image cannot be smaller than viewport
     */
    @JsProperty
    public boolean enforceBoundary;

    /**
     * Enable or disable the ability to use the mouse wheel to zoom in and out on a cropper instance
     */
    @JsProperty
    public boolean mouseWheelZoom;

    /**
     * Hide or Show the zoom slider
     */
    @JsProperty
    public boolean showZoomer;
}
