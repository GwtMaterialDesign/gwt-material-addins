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
