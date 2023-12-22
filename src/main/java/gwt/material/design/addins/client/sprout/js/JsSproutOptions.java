package gwt.material.design.addins.client.sprout.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The SproutVideo Javascript Player API gives you more control over the SproutVideo Video Player.
 * Not only can you receive events from the player, but you can also control the player through Javascript.
 *
 * https://sproutvideo.com/help/articles/27-javascript_player_api
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsSproutOptions {

    /**
     * This is the ID of the video you wish to control through the API
     * Optional (specify either the videoId or playlistId property)
     */
    @JsProperty
    public String videoId;

    /**
     * This is the ID of the video you wish to control through the API
     * Optional (specify either the videoId or playlistId property)
     */
    @JsProperty
    public String playlistId;
}
