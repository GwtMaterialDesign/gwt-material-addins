package gwt.material.design.addins.client.avatar;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialImage;

//@formatter:off

/**
 * Gravatar images based on @link(https://gravatar.com/)
 * provides user avatar from email or a unique version of it.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * Simple usage
 * {@code
 *
 * <ma:avatar.MaterialAvatar width="80" height="80"/>
 *
 * }
 * </pre>
 *
 * Gravatar usage
 * {@code
 *
 * <ma:avatar.MaterialAvatar value="<email or any string>" width="80" height="80" defaultAvatarType="monsterid"/>
 *
 * }
 * </pre>
 *
 * @author paulux84
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#avatar">Material Avatar</a>
 */
//@formatter:on
public class MaterialAvatar  extends MaterialImage {


    public enum DefaultAvatarType{
        mm,
        identicon,
        monsterid,
        wavatar,
        retro,
        blank
    }

    static {
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialAvatarDebugClientBundle.INSTANCE.md5DebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialAvatarClientBundle.INSTANCE.md5Js());
        }
    }

    private static final String gravatarUrl="https://www.gravatar.com/avatar/";
    private DefaultAvatarType defaultImage;
    private String value;

    public MaterialAvatar(){
        super(gravatarUrl+"?&d="+DefaultAvatarType.identicon);
    }

    /**
     * Set the value of the avatar and pass it's md5 hash to gravatar service.
     * If an email is passed and that email is registered on gravat you get related avatar
     * @param value a simple string or user email
     */
    public void setValue(String value){
        this.value=value;
        setUrl("https://www.gravatar.com/avatar/"+ generateHashCode(value)+"?&d="+defaultImage);
    }

    /**
     * Get the value of the avatar
     * @return an email or a simple string
     */
    public String getValue() {
        return value;
    }

    /**
     * In addition to allowing you to use user avatar, Gravatar has a number of built in options which you can also use as defaults.
     * Most of these work by taking the requested email hash and using it to generate a themed image that is unique to that email address.
     * To use these options, just pass one of the {@link DefaultAvatarType}
     * @param defaultAvatarType
     */
    public void setDefaultAvatarType(DefaultAvatarType defaultAvatarType){
        this.defaultImage=defaultAvatarType;
        setUrl(gravatarUrl+"?&d="+defaultImage);
    }

    protected native String generateHashCode(String value) /*-{
        return $wnd.md5(value);
    }-*/;

}
