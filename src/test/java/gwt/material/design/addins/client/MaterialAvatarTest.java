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
package gwt.material.design.addins.client;

import gwt.material.design.addins.client.avatar.MaterialAvatar;
import gwt.material.design.addins.client.avatar.js.JsAvatar;
import gwt.material.design.addins.client.base.MaterialAddinsTest;

/**
 * Test case for avatar component
 *
 * @author kevzlou7979
 */
public class MaterialAvatarTest extends MaterialAddinsTest {

    public void init() {
        MaterialAvatar avatar = new MaterialAvatar();
        checkWidget(avatar);
        checkNameAndHashCode(avatar);
        checkSVGWithHeight(avatar);
    }

    protected <T extends MaterialAvatar> void checkNameAndHashCode(T avatar) {
        final String NAME = "test1";
        avatar.setName(NAME);
        avatar.reinitialize();
        final String HASH_CODE = JsAvatar.md5(NAME);
        assertEquals(avatar.getName(), NAME);
        assertTrue(avatar.getElement().hasAttribute("data-jdenticon-hash"));
        assertEquals(avatar.getElement().getAttribute("data-jdenticon-hash"), HASH_CODE);
    }

    protected <T extends MaterialAvatar> void checkSVGWithHeight(T avatar) {
        final String WIDTH = "50";
        final String HEIGHT = "50";
        avatar.setWidth(WIDTH);
        avatar.setHeight(HEIGHT);

        assertTrue(avatar.getElement().hasAttribute("width"));
        assertEquals(avatar.getElement().getAttribute("width"), WIDTH);

        assertTrue(avatar.getElement().hasAttribute("height"));
        assertEquals(avatar.getElement().getAttribute("height"), HEIGHT);
    }
}
