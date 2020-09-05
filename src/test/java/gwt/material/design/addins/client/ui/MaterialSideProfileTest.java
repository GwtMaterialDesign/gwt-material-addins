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
package gwt.material.design.addins.client.ui;

import gwt.material.design.addins.client.ui.base.AddinsWidgetTestCase;
import gwt.material.design.addins.client.sideprofile.MaterialSideProfile;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialLabel;

public class MaterialSideProfileTest extends AddinsWidgetTestCase<MaterialSideProfile> {

    final static String URL = "someurl";
    final static String RESULT_ATTRIBUTE = "background-image: url(" + URL + "); background-size: cover;";

    @Override
    protected MaterialSideProfile createWidget() {
        MaterialSideProfile profile = new MaterialSideProfile();
        profile.add(new MaterialLabel());
        return profile;
    }

    public void testStructure() {
        // UiBinder
        // given
        MaterialSideProfile profile = getWidget(false);

        // when / then
        checkStructure(profile, false);

        // Standard
        // given
        attachWidget();

        // when / then
        checkStructure(profile, true);
    }

    protected void checkStructure(MaterialSideProfile profile, boolean checkElement) {
        if (checkElement) {
            assertTrue(profile.getElement().hasClassName(CssName.SIDE_PROFILE));
        }
        assertEquals(1, profile.getWidgetCount());
        assertTrue(profile.getWidget(0) instanceof MaterialLabel);
    }

    public void testImage() {
        // UiBinder
        // given
        MaterialSideProfile profile = getWidget(true);

        // when / then
        checkImage(profile);

        // Standard
        // given
        attachWidget();

        // when / then
        checkImage(profile);
    }

    protected void checkImage(MaterialSideProfile profile) {
        profile.setUrl(URL);
        assertEquals(URL, profile.getUrl());
        assertEquals(RESULT_ATTRIBUTE, profile.getElement().getAttribute("style"));
    }
}
