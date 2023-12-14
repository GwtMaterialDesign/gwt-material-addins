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
package gwt.material.design.addins.client.sideprofile;

import com.google.gwt.dom.client.Document;
import com.google.gwt.resources.client.ImageResource;
import gwt.material.design.addins.client.AbstractAddinsValueWidget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.HasImage;
import gwt.material.design.client.base.HasNoSideNavSelection;
import gwt.material.design.client.constants.CssName;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
 * <m:MaterialSideNavPush ui:field="sidenav" m:id="right-sidenav" width="300">
 *  <ma:sideprofile.MaterialSideProfile
 *      url="someurl">
 *      <m:MaterialImage url="someurl"/>
 *      <m:MaterialLabel text="GWT Material" textColor="WHITE"/>
 *      <m:MaterialLink text="gwt-material@gmail.com" activates="dropProfile" iconType="ARROW_DROP_DOWN"
 *      iconPosition="RIGHT" textColor="WHITE"/>
 *  </ma:sideprofile.MaterialSideProfile>
 * </m:MaterialSideNavPush>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @author Ben Dol
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#!sidenavs">Material Side Profile</a>
 * @see <a href="https://material.io/guidelines/patterns/navigation-drawer.html">Material Design Specification</a>
 */
//@formatter:on
public class MaterialSideProfile extends AbstractAddinsValueWidget<String> implements HasImage, HasNoSideNavSelection {

    private String alt;
    private String url;
    private ImageResource resource;

    public MaterialSideProfile() {
        super(Document.get().createDivElement(), CssName.SIDE_PROFILE);
    }

    @Override
    public String getValue() {
        return url;
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        this.url = value;
        applyBackground(url);
        super.setValue(value, fireEvents);
    }

    @Override
    public void setUrl(String url) {
        setValue(url, true);
    }

    @Override
    public String getUrl() {
        return getValue();
    }

    @Override
    public void setResource(ImageResource resource) {
        this.resource = resource;
        setUrl(resource.getSafeUri().asString());
    }

    @Override
    public ImageResource getResource() {
        return resource;
    }

    @Override
    public void setAlt(String alt) {
        this.alt = alt;
        getElement().setAttribute("alt", alt);
    }

    @Override
    public String getAlt() {
        return alt;
    }

    protected void applyBackground(String url) {
        getElement().setAttribute("style", "background-image: url(" + url + "); background-size: cover;");
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(MaterialSideProfileClientBundle.INSTANCE.sideprofileCss(), MaterialSideProfileDebugClientBundle.INSTANCE.sideprofileCssDebug()));
    }
}
