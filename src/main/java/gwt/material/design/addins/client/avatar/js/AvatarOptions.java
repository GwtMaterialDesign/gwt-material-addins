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
package gwt.material.design.addins.client.avatar.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for combobox component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AvatarOptions {

    @JsProperty
    private Double[] hues;

    @JsProperty
    private AvatarLightnessOptions lightness;

    @JsProperty
    private AvatarSaturationOptions saturation;

    @JsProperty
    private String backColor;

    @JsProperty
    private Number padding;

    @JsProperty
    private String replaceMode;

    @JsOverlay
    public final Double[] getHues() {
        return hues;
    }

    /**
     * Limits the possible hues in generated icons. The hues are specified as an array of hues in degrees.
     * If the option is omitted or an empty array is specified, all hues are allowed.
     * Default null
     */
    @JsOverlay
    public final void setHues(Double[] hues) {
        this.hues = hues;
    }

    @JsOverlay
    public final AvatarLightnessOptions getLightness() {
        return lightness;
    }

    @JsOverlay
    public final void setLightness(AvatarLightnessOptions lightness) {
        this.lightness = lightness;
    }

    @JsOverlay
    public final AvatarSaturationOptions getSaturation() {
        return saturation;
    }

    @JsOverlay
    public final void setSaturation(AvatarSaturationOptions saturation) {
        this.saturation = saturation;
    }

    @JsOverlay
    public final String getBackColor() {
        return backColor;
    }

    /**
     * Specifies the background color to be rendered behind the icon. Supported syntaxes are #rgb, #rgba, #rrggbb and
     * #rrggbbaa.
     * <p>
     * Default : 	"#00000000"
     */
    @JsOverlay
    public final void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    @JsOverlay
    public final Number getPadding() {
        return padding;
    }

    /**
     * Specifies the padding surrounding the icon in percents in the range 0.0 to 0.5. Additional padding might be
     * inserted by Jdenticon to ensure the icon is aligned to the pixel grid. For jdenticon.drawIcon() the default
     * value is 0. For all other methods the default value is 0.08.
     * Default : 	0 or 0.08
     */
    @JsOverlay
    public final void setPadding(Number padding) {
        this.padding = padding;
    }

    @JsOverlay
    public final String getReplaceMode() {
        return replaceMode;
    }

    /**
     * Specifies when icons will be rendered. This option has no effect on Node.js.
     * <ul>
     *     <li>
     *         {@link ReplaceMode#NEVER} – icons are never rendered automatically. You need to call jdenticon.update() manually to render
     *     identicons.
     *     </li>
     *     <li>
     *         {@link ReplaceMode#ONCE} – icons are rendered once the page has loaded. Any dynamically inserted or modified icons will
     *         not be rendered unless jdenticon.update() is manually called.
     *     </li>
     *     <li>
     *         {@link ReplaceMode#OBSERVE} – icons are rendered upon page load, and the DOM is monitored for new icons using a MutationObserver.
     *         Use this if icons are inserted dynamically, e.g. by using Angular, React or VanillaJS. This option behaves as "once" in IE<11.
     *     </li>
     * </ul>
     */
    @JsOverlay
    public final void setReplaceMode(ReplaceMode replaceMode) {
        this.replaceMode = replaceMode.getName();
    }
}
