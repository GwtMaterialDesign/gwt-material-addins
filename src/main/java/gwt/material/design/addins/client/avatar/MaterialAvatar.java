/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.avatar;

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.avatar.js.JsAvatar;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;

//@formatter:off

/**
 * Generated avatar based on @link(https://jdenticon.com/)
 * provides a unique avatar based on unique name.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 *
 * <ma:avatar.MaterialAvatar name="kevzlou7979" width="80" height="80"/>
 *
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#avatar">Material Avatar</a>
 */
//@formatter:on
public class MaterialAvatar extends MaterialWidget {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialAvatarDebugClientBundle.INSTANCE.jdenticonDebugJs());
            MaterialDesignBase.injectDebugJs(MaterialAvatarDebugClientBundle.INSTANCE.jdenticonDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialAvatarClientBundle.INSTANCE.jdenticonJs());
            MaterialDesignBase.injectJs(MaterialAvatarClientBundle.INSTANCE.md5Js());
        }
    }

    private String name;

    public MaterialAvatar() {
        super(Document.get().createCanvasElement());
    }

    public MaterialAvatar(String name) {
        this();
        setName(name);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        if (getName() != null) {
            initialize();
        }
    }

    /**
     * Get the name of the avatar.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the avatar and hashed it using md5 js library to
     * pass it into jdenticon avatar process.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWidth(String width) {
        getElement().setAttribute("width", width);
    }

    @Override
    public void setHeight(String height) {
        getElement().setAttribute("height", height);
    }

    /**
     * Generate hash code - needed by jdenticon to generate avatar.
     */
    protected String generateHashCode(String value) {
        return JsAvatar.md5(value);
    }

    /**
     * Initialize the avatar process - useful when trying to update your avatar
     */
    public void initialize() {
        getElement().setAttribute("data-jdenticon-hash", generateHashCode(getName()));
        update();
    }

    protected void update() {
        JsAvatar.jdenticon();
    }
}
