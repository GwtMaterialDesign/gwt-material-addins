/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2023 GwtMaterialDesign
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
package gwt.material.design.addins.client.sprout;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.sprout.events.*;
import gwt.material.design.addins.client.sprout.js.*;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.jquery.client.api.Functions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SproutVideo extends AbstractAddinsWidget implements HasSproutEvents {

    private JsSproutPlayer player;
    private JsSproutOptions options = new JsSproutOptions();

    public SproutVideo() {
        super(DOM.createElement("video"));
    }

    @Override
    protected void internalLoad() {
        player = new JsSproutPlayer(options);
        bind("play", event -> {
            PlayEvent.fire(this);
        });
        bind("pause", event -> {
            PauseEvent.fire(this);
        });
        bind("loading", percentage -> {
            LoadingEvent.fire((Float) percentage, this);
        });
        bind("progress", data -> {
            ProgressEvent.fire((ProgressData) data, this);
        });
        bind("completed", event -> {
            CompletedEvent.fire(this);
        });
        bind("volume", data -> {
            VolumeEvent.fire((Float) data, this);
        });
        bind("ready", data -> {
            ReadyEvent.fire((ReadyData) data,this);
        });
        bind("rateChange", data -> {
            RateChangeEvent.fire((Float) data, this);
        });
        bind("qualityLevels", data -> {
            QualityLevelsEvent.fire((QualityLevel) data,this);
        });
        bind("qualityLevelChange", data -> {
            QualityLevelChangeEvent.fire((Integer) data, this);
        });
        bind("switchvideo", data -> {
            SwitchVideoEvent.fire((SwitchData) data, this);
        });
        bind("playlistcomplete", event -> {
            PlaylistCompleteEvent.fire(this);
        });
    }

    /**
     * The bind() method allows you to execute a function when a video event is fired.
     */
    public void bind(String event, Functions.Func1<Object> callback) {
        player.bind(event, callback);
    }

    /**
     * The unbind() method allows you to stop a previously binded function from executing when the event is fired.
     */
    public void unbind(String event, Functions.Func1<Object> callback) {
        player.unbind(event, callback);
    }

    /**
     * The play() method will start playing the video if the player is paused or the video has not begun playing yet.
     */
    public void play() {
        player.play();
    }

    /**
     * The pause() method will pause the video if it is playing.
     */
    public void pause() {
        player.pause();
    }

    /**
     * The setVolume() method will set the volume of the player. setVolume accepts a float value between 0.0 and 1.0.
     */
    public void setVolume(float volume) {
        player.setVolume(volume);
    }

    /**
     * The getVolume() method returns the current volume level of the player.
     * Returns: A float value between 0.0 and 1.0 representing the current volume of the player.
     */
    public float getVolume() {
        return player.getVolume();
    }

    /**
     * The seek() method will seek to the given time in the video. The seek method accepts an float value representing
     * the number of seconds from the beginning of the video to which to seek. If you try to seek to a point greater
     * than the duration of the video, the video will start over from the beginning.
     */
    public void seek(float value) {
        player.seek(value);
    }

    /**
     * The getCurrentTime() method returns the current position of the player within the video.
     * Returns:A float representing the number of seconds from the beginning of the video.
     */
    public float getCurrentTime() {
        return player.getCurrentTime();
    }

    /**
     * The getPercentLoaded() method returns the percentage of the video that has loaded.
     * Returns: A float value between 0.0 and 1.0 wich represents the percentage of bytes of the video which have been loaded.
     */
    public float getPercentLoaded() {
        return player.getPercentLoaded();
    }

    /**
     * The getDuration method returns the duration of the video.
     * Returns: An integer value representing the duration of the video in seconds.
     */
    public int getDuration() {
        return player.getDuration();
    }

    /**
     * The getEmail() method will return the email address that was collected if an email address is required to play
     * the video or if one was passed into the embed code using the vemail parameter.
     * Returns: An email address if one was passed in or null if there was none collected.
     */
    public String getEmail() {
        return player.getEmail();
    }

    /**
     * The setPlaybackRate() method will change the playback rate of the video. Most browsers stop playing audio outside
     * playbackRate bounds of 0.5 and 4, leaving the video playing silently. For most applications, it’s recommended that
     * you limit the range to between 0.5 and 4. The pitch of the audio track does not change when the playback rate is altered.
     * Negative values will not cause the media to play in reverse.
     */
    public void setPlaybackRate(float value) {
        player.setPlaybackRate(value);
    }

    /**
     * The getPlaybackRate() method returns the current playback rate of the video.
     * Returns: A float value representing the current playback rate of the video.
     */
    public int getPlaybackRate() {
        return player.getPlaybackRate();
    }

    /**
     * The setQualityLevel() method will trigger a quality level switch for the next video fragment. Pass in the hieght
     * value of any available levels advertised by the qualityLevels event, or ‘auto’ to revert back to automatic quality switching.
     */
    public void setQualityLevel(int qualityLevel) {
        player.setQualityLevel(qualityLevel);
    }

    /**
     * The getQualityLevel() method returns the current quality level of the video.
     * Returns: A integer value representing the height of the currently selected quality level, or ‘auto’ if the player
     * is set to automatically handle quality level switching on it’s own.
     */
    public int getQualityLevel() {
        return player.getQualityLevel();
    }

    /**
     * The play() method for playlists allows you to begin playing a specific video in the playlist.
     * The index parameter indicates which video, using a 0 based index, in the playlist to play.
     */
    public void play(int index) {
        player.play(index);
    }

    public JsSproutOptions getOptions() {
        return options;
    }

    public void setOptions(JsSproutOptions options) {
        this.options = options;
    }

    @Override
    public HandlerRegistration addPlayHandler(PlayEvent.PlayHandler handler) {
        return addHandler(handler, PlayEvent.TYPE);
    }

    @Override
    public HandlerRegistration addPauseHandler(PauseEvent.PauseHandler handler) {
        return addHandler(handler, PauseEvent.TYPE);
    }

    @Override
    public HandlerRegistration addLoadingHandler(LoadingEvent.LoadingHandler handler) {
        return addHandler(handler, LoadingEvent.TYPE);
    }

    @Override
    public HandlerRegistration addProgressHandler(ProgressEvent.ProgressHandler handler) {
        return addHandler(handler, ProgressEvent.TYPE);
    }

    @Override
    public HandlerRegistration addCompletedHandler(CompletedEvent.CompletedHandler handler) {
        return addHandler(handler, CompletedEvent.TYPE);
    }

    @Override
    public HandlerRegistration addVolumeHandler(VolumeEvent.VolumeHandler handler) {
        return addHandler(handler, VolumeEvent.TYPE);
    }

    @Override
    public HandlerRegistration addReady(ReadyEvent.ReadyHandler handler) {
        return addHandler(handler, ReadyEvent.TYPE);
    }

    @Override
    public HandlerRegistration addRateChangeHandler(RateChangeEvent.RateChangeHandler handler) {
        return addHandler(handler, RateChangeEvent.TYPE);
    }

    @Override
    public HandlerRegistration addQualityLevelsHandler(QualityLevelsEvent.QualityLevelsHandler handler) {
        return addHandler(handler, QualityLevelsEvent.TYPE);
    }

    @Override
    public HandlerRegistration addQualityLevelChangeHandler(QualityLevelChangeEvent.QualityLevelChangeHandler handler) {
        return addHandler(handler, QualityLevelChangeEvent.TYPE);
    }

    @Override
    public HandlerRegistration addSwitchVideoHandler(SwitchVideoEvent.SwitchVideoHandler handler) {
        return addHandler(handler, SwitchVideoEvent.TYPE);
    }

    @Override
    public HandlerRegistration addPlaylistCompleteHandler(PlaylistCompleteEvent.PlaylistCompleteHandler handler) {
        return addHandler(handler, PlaylistCompleteEvent.TYPE);
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(SproutVideoClientBundle.INSTANCE.sproutJs(), SproutVideoDebugClientBundle.INSTANCE.sproutDebugJs()));
    }
}
