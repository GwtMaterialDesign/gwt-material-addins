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
package gwt.material.design.incubator.client.infinitescroll.js;

import gwt.material.design.jquery.client.api.JQueryElement;
import gwt.material.design.jscore.client.api.core.Element;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for ScrollMagic.Scene
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, namespace = "ScrollMagic")
public class Scene extends JQueryElement {

    /**
     * A Scene defines where the controller should react and how.
     */
    public Scene(SceneOptions options) {}

    /**
     * Add the scene to a controller.
     *
     * @param controller The controller to which the scene should be added.
     */
    @JsMethod
    public native Scene addTo(Controller controller);

    /**
     * Get the associated controller.
     *
     * @return Parent controller or undefined
     */
    @JsMethod
    public native Controller controller();

    /**
     * Destroy the scene and everything.
     *
     * @param reset If true the pin and tween (if existent) will be reset.
     */
    @JsMethod
    public native void destroy(boolean reset);

    /**
     * Get or Set the scene's progress.
     * Usually it shouldn't be necessary to use this as a setter, as it is set automatically by scene.update().
     * The order in which the events are fired depends on the duration of the scene:
     * <p>
     * Scenes with duration == 0:
     * Scenes that have no duration by definition have no ending. Thus the end event will never be fired.
     * When the trigger position of the scene is passed the events are always fired in this order:
     * enter, start, progress when scrolling forward
     * and
     * progress, start, leave when scrolling in reverse
     * Scenes with duration > 0:
     * Scenes with a set duration have a defined start and end point.
     * When scrolling past the start position of the scene it will fire these events in this order:
     * enter, start, progress
     * When continuing to scroll and passing the end point it will fire these events:
     * progress, end, leave
     * When reversing through the end point these events are fired:
     * enter, end, progress
     * And when continuing to scroll past the start position in reverse it will fire:
     * progress, start, leave
     * In between start and end the progress event will be called constantly, whenever the progress changes.
     *
     * @return
     */
    @JsMethod
    public native int progress();

    /**
     * Updates dynamic scene variables like the trigger element position or the duration. This method is automatically
     * called in regular intervals from the controller. See ScrollMagic.Controller option refreshInterval. You can call
     * it to minimize lag, for example when you intentionally change the position of the triggerElement. If you don't it
     * will simply be updated in the next refresh interval of the container, which is usually sufficient.
     */
    @JsMethod
    public native Scene refresh();

    /**
     * Remove the scene from the controller. This is the equivalent to Controller.removeScene(scene). The scene will not
     * be updated anymore until you readd it to a controller. To remove the pin or the tween you need to call removeTween()
     * or removePin() respectively.
     *
     * @return Parent object for chaining.
     */
    @JsMethod
    public native Scene remove();

    /**
     * Remove the class binding from the scene.
     *
     * @param reset If false and the classes are currently active, they will remain on the element. If true they will be removed.
     */
    @JsMethod
    public native Scene removeClassToggle(boolean reset);

    /**
     * Remove the pin from the scene.
     *
     * @param reset If false the spacer will not be removed and the element's position will not be reset.
     */
    @JsMethod
    public native Scene removePin(boolean reset);

    /**
     * Define a css class modification while the scene is active. When the scene triggers the classes will be added to
     * the supplied element and removed, when the scene is over. If the scene duration is 0 the classes will only be
     * removed if the user scrolls back past the start position.
     *
     * @param element A Selector targeting one or more elements or a DOM object that is supposed to be modified.
     * @param classes One or more Classnames (separated by space) that should be added to the element during the scene.
     * @return
     */
    @JsMethod
    public native Scene setClassToggle(Element element, String classes);

    /**
     * Pin an element for the duration of the tween. If the scene duration is 0 the element will only be unpinned, if
     * the user scrolls back past the start position. Make sure only one pin is applied to an element at the same time.
     * An element can be pinned multiple times, but only successively. NOTE: The option pushFollowers has no effect,
     * when the scene duration is 0.
     *
     * @param element  A Selector targeting an element or a DOM object that is supposed to be pinned.
     * @param settings Settings for the pin
     */
    @JsMethod
    public native Scene setPin(Element element, PinSettings settings);

    /**
     * Updates the Scene to reflect the current state. This is the equivalent to Controller.updateScene(scene, immediately).
     * The update method calculates the scene's start and end position (based on the trigger element, trigger hook,
     * duration and offset) and checks it against the current scroll position of the container. It then updates the
     * current scene state accordingly (or does nothing, if the state is already correct) – Pins will be set to their
     * correct position and tweens will be updated to their correct progress. This means an update doesn't necessarily
     * result in a progress change. The progress event will be fired if the progress has indeed changed between this
     * update and the last.
     * <p>
     * <b>NOTE:</b> This method gets called constantly whenever ScrollMagic detects a change. The only application for
     * you is if you change something outside of the realm of ScrollMagic, like moving the trigger or changing tween parameters.
     * <p>
     *
     * @param immediately If true the update will be instant, if false it will wait until next update cycle (better performance).
     */
    @JsMethod
    public native void update(boolean immediately);

    @JsMethod
    public native void duration(int duration);

    @JsMethod
    public native int duration();

    @JsMethod
    public native void enabled(boolean enabled);

    @JsMethod
    public native boolean enabled();

    @JsMethod
    public native void loglevel(int loglevel);

    @JsMethod
    public native int loglevel();

    @JsMethod
    public native void offset(double newOffset);

    @JsMethod
    public native void reverse(boolean reverse);

    @JsMethod
    public native boolean reverse();

    @JsMethod
    public native void triggerElement(Object triggerElement);

    @JsMethod
    public native Object triggerElement();

    @JsMethod
    public native void triggerHook(int triggerHook);

    @JsMethod
    public native int triggerHook();

    @JsMethod
    public native int scrollOffset();

    @JsMethod
    public native String state();

    @JsMethod
    public native int triggerPosition();
}
