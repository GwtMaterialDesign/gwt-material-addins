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
package gwt.material.design.addins.client.avatar;

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.AbstractAddinsValueWidget;
import gwt.material.design.addins.client.avatar.js.AvatarOptions;
import gwt.material.design.addins.client.avatar.js.JsAvatar;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.md5.Md5ClientBundle;
import gwt.material.design.addins.client.md5.Md5Converter;
import gwt.material.design.addins.client.md5.Md5DebugClientBundle;

import java.util.Arrays;
import java.util.List;

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
 * @see <a href="https://github.com/dmester/jdenticon">Jdenticon 1.3.2</a>
 */
//@formatter:on
public class MaterialAvatar extends AbstractAddinsValueWidget<String> {

    private String value;
    private AvatarOptions options;

    public MaterialAvatar() {
        super(Document.get().createCanvasElement());
    }

    public MaterialAvatar(String name) {
        this();
        setValue(name, false);
    }

    @Override
    protected void internalLoad() {
        if (options != null) {
            JsAvatar.config = options;
        }
        JsAvatar.jdenticon();
    }

    @Override
    public void reset() {
        super.reset();

        reload();
    }

    /**
     * Replaced by {@link MaterialAvatar#getValue()}
     */
    @Deprecated
    public String getName() {
        return getValue();
    }

    /**
     * Replaced by {@link MaterialAvatar#setValue(String, boolean)} )}
     */
    @Deprecated
    public void setName(String name) {
        setValue(name, true);
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        super.setValue(value, fireEvents);
        new Md5Converter().convert(value).then(converted -> {
            getElement().setAttribute("data-jdenticon-hash", converted);
            return null;
        });
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setWidth(String width) {
        getElement().setAttribute("width", width);
    }

    @Override
    public void setHeight(String height) {
        getElement().setAttribute("height", height);
    }

    @Override
    public int getWidth() {
        String width = getElement().getAttribute("width");
        return width != null ? Integer.parseInt(width) : 0;
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Arrays.asList(new DependencyResource(Md5ClientBundle.INSTANCE.md5Js(),Md5DebugClientBundle.INSTANCE.md5DebugJs(), 0),
                new DependencyResource(MaterialAvatarClientBundle.INSTANCE.jdenticonJs(), MaterialAvatarDebugClientBundle.INSTANCE.jdenticonDebugJs(), 1));
    }

    public int getHeight() {
        String height = getElement().getAttribute("height");
        return height != null ? Integer.parseInt(height) : 0;
    }

    /**
     * Allowing to set the dimension of the Avatar component.
     *
     * @param width  - the width dimension of the avatar without any Unit suffix (e.i 100)
     * @param height - the height dimension of the avatar without any Unit suffix (e.i 100)
     */
    public void setDimension(int width, int height) {
        setWidth(String.valueOf(width));
        setHeight(String.valueOf(height));
        reload();
    }


    public AvatarOptions getOptions() {
        return options;
    }

    public void setOptions(AvatarOptions options) {
        this.options = options;
    }
}
