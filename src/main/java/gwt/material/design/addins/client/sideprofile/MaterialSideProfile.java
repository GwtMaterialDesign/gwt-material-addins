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
package gwt.material.design.addins.client.sideprofile;

import com.google.gwt.dom.client.Document;
import com.google.gwt.resources.client.ImageResource;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasImage;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.CssName;

//@formatter:off

/**
 * SideProfile is a component that is attached on SideNav Component. Consists of
 * Image , Label and link components.
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
 * <m:MaterialSideNav type="OPEN" m:id="sideNav" closeOnClick="false" width="280">
 *    <ma:sideprofile.MaterialSideProfile url="http://static1.squarespace.com/static/51609147e4b0715db61d32b6/521b97cee4b05f031fd12dde/5519e33de4b06a1002802805/1431718693701/?format=1500w">
 *        <m:MaterialImage url="http://b.vimeocdn.com/ps/339/488/3394886_300.jpg" />
 *        <m:MaterialLabel text="GWT Material" textColor="white"/>
 *        <m:MaterialLink text="gwt-material@gmail.com" activates="dropProfile" iconType="ARROW_DROP_DOWN" iconPosition="RIGHT" textColor="white"/>
 *    </ma:sideprofile.MaterialSideProfile>
 * </m:MaterialSideNav>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @author Ben Dol
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#!sidenavs">Material Side Profile</a>
 */
//@formatter:on
public class MaterialSideProfile extends MaterialWidget implements HasImage {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialSideProfileDebugClientBundle.INSTANCE.sideprofileCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialSideProfileClientBundle.INSTANCE.sideprofileCss());
        }
    }

    private String url;
    private ImageResource resource;

    public MaterialSideProfile() {
        super(Document.get().createDivElement(), CssName.SIDE_PROFILE);
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
        applyBackground(url);
    }

    protected void applyBackground(String url) {
        getElement().setAttribute("style", "background-image: url(" + url + "); background-size: cover;");
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setResource(ImageResource resource) {
        this.resource = resource;
        applyBackground(resource.getSafeUri().asString());
    }

    @Override
    public ImageResource getResource() {
        return resource;
    }
}
