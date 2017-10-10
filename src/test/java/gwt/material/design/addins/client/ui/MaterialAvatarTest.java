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

import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.avatar.MaterialAvatar;
import gwt.material.design.addins.client.avatar.js.JsAvatar;

/**
 * Test case for avatar component
 *
 * @author kevzlou7979
 */
public class MaterialAvatarTest extends MaterialWidgetTest<MaterialAvatar> {

    @Override
    protected MaterialAvatar createWidget() {
        return new MaterialAvatar();
    }

    public void testValue() {
        // given
        MaterialAvatar avatar = getWidget();
        final String NAME = "test1";
        final String HASH_CODE = JsAvatar.md5(NAME);

        // when
        avatar.setValue(NAME);

        // then
        assertEquals(NAME, avatar.getValue());
        assertTrue(avatar.getElement().hasAttribute("data-jdenticon-hash"));
        assertEquals(HASH_CODE, avatar.getElement().getAttribute("data-jdenticon-hash"));
    }

    public void testValueChangeHandler() {
        final String FIRST_VALUE = "test1";
        final String SECOND_VALUE = "test2";
        MaterialAvatar avatar = getWidget();

        checkValueChangeEvent(avatar, FIRST_VALUE, SECOND_VALUE);
    }

    // TODO Test Dimension
    public void testDimension() {
        final int WIDTH = 100;
        final int HEIGHT = 100;
        MaterialAvatar avatar = getWidget();

        avatar.setDimension(WIDTH, HEIGHT);
        assertEquals(WIDTH, avatar.getWidth());
        assertEquals(HEIGHT, avatar.getHeight());
    }

    public void testSVGWithHeight() {
        // given
        MaterialAvatar avatar = getWidget();
        final String WIDTH = "50";
        final String HEIGHT = "50";

        // when
        avatar.setWidth(WIDTH);
        avatar.setHeight(HEIGHT);

        // then
        assertTrue(avatar.getElement().hasAttribute("width"));
        assertEquals(WIDTH, avatar.getElement().getAttribute("width"));
        assertTrue(avatar.getElement().hasAttribute("height"));
        assertEquals(HEIGHT, avatar.getElement().getAttribute("height"));
    }
}
