package gwt.material.design.addins.client.sprout.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "SV.Player")
public class JsSproutPlayer {

    public JsSproutPlayer(JsSproutOptions options) {
    }

    /**
     * The bind() method allows you to execute a function when a video event is fired.
     */
    @JsMethod
    public native void bind(String event, Functions.Func1<Object> callback);

    /**
     * The unbind() method allows you to stop a previously binded function from executing when the event is fired.
     */
    @JsMethod
    public native void unbind(String event, Functions.Func1<Object> callback);

    /**
     * The play() method will start playing the video if the player is paused or the video has not begun playing yet.
     */
    @JsMethod
    public native void play();

    /**
     * The pause() method will pause the video if it is playing.
     */
    @JsMethod
    public native void pause();

    /**
     * The setVolume() method will set the volume of the player. setVolume accepts a float value between 0.0 and 1.0.
     */
    @JsMethod
    public native void setVolume(float volume);


    /**
     * The getVolume() method returns the current volume level of the player.
     * Returns: A float value between 0.0 and 1.0 representing the current volume of the player.
     */
    @JsMethod
    public native float getVolume();

    /**
     * The seek() method will seek to the given time in the video. The seek method accepts an float value representing
     * the number of seconds from the beginning of the video to which to seek. If you try to seek to a point greater
     * than the duration of the video, the video will start over from the beginning.
     */
    @JsMethod
    public native void seek(float value);

    /**
     * The getCurrentTime() method returns the current position of the player within the video.
     * Returns:A float representing the number of seconds from the beginning of the video.
     */
    @JsMethod
    public native float getCurrentTime();

    /**
     * The getPercentLoaded() method returns the percentage of the video that has loaded.
     * Returns: A float value between 0.0 and 1.0 wich represents the percentage of bytes of the video which have been loaded.
     */
    @JsMethod
    public native float getPercentLoaded();

    /**
     * The getDuration method returns the duration of the video.
     * Returns: An integer value representing the duration of the video in seconds.
     */
    @JsMethod
    public native int getDuration();

    /**
     * The getEmail() method will return the email address that was collected if an email address is required to play
     * the video or if one was passed into the embed code using the vemail parameter.
     * Returns: An email address if one was passed in or null if there was none collected.
     */
    @JsMethod
    public native String getEmail();

    /**
     * The setPlaybackRate() method will change the playback rate of the video. Most browsers stop playing audio outside
     * playbackRate bounds of 0.5 and 4, leaving the video playing silently. For most applications, it’s recommended that
     * you limit the range to between 0.5 and 4. The pitch of the audio track does not change when the playback rate is altered.
     * Negative values will not cause the media to play in reverse.
     */
    @JsMethod
    public native void setPlaybackRate(float value);

    /**
     * The getPlaybackRate() method returns the current playback rate of the video.
     * Returns: A float value representing the current playback rate of the video.
     */
    @JsMethod
    public native int getPlaybackRate();

    /**
     * The setQualityLevel() method will trigger a quality level switch for the next video fragment. Pass in the hieght
     * value of any available levels advertised by the qualityLevels event, or ‘auto’ to revert back to automatic quality switching.
     */
    @JsMethod
    public native void setQualityLevel(int qualityLevel);

    /**
     * The getQualityLevel() method returns the current quality level of the video.
     * Returns: A integer value representing the height of the currently selected quality level, or ‘auto’ if the player
     * is set to automatically handle quality level switching on it’s own.
     */
    @JsMethod
    public native int getQualityLevel();

    /**
     * The play() method for playlists allows you to begin playing a specific video in the playlist.
     * The index parameter indicates which video, using a 0 based index, in the playlist to play.
     */
    @JsMethod
    public native void play(int index);
}
