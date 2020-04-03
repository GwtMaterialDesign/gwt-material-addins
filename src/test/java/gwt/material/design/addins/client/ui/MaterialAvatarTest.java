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
import gwt.material.design.addins.client.avatar.js.*;

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
        // UiBinder
        // given
        MaterialAvatar avatar = getWidget(false);

        // when / then
        checkValue(avatar);

        // Standard
        // given
        attachWidget();

        // when / then
        checkValue(avatar);
    }

    protected void checkValue(MaterialAvatar avatar) {
        // when / then
        final String NAME = "test1";
        final String HASH_CODE = JsAvatar.md5(NAME);
        avatar.setValue(NAME);
        assertEquals(NAME, avatar.getValue());
        assertTrue(avatar.getElement().hasAttribute("data-jdenticon-hash"));
        assertEquals(HASH_CODE, avatar.getElement().getAttribute("data-jdenticon-hash"));
    }

    public void testValueChangeHandler() {
        // given
        MaterialAvatar avatar = getWidget();

        // when / then
        final String FIRST_VALUE = "test1";
        final String SECOND_VALUE = "test2";
        checkValueChangeEvent(avatar, FIRST_VALUE, SECOND_VALUE);
    }

    public void testDimension() {
        // UiBinder
        // given
        MaterialAvatar avatar = getWidget(false);

        // when / then
        checkDimension(avatar);

        // Standard
        // given
        attachWidget();

        // when / then
        checkDimension(avatar);
    }

    protected void checkDimension(MaterialAvatar avatar) {
        final int WIDTH = 100;
        final int HEIGHT = 100;
        avatar.setDimension(WIDTH, HEIGHT);
        assertEquals(WIDTH, avatar.getWidth());
        assertEquals(HEIGHT, avatar.getHeight());
    }

    public void testSVGWithHeight() {
        // UiBinder
        // given
        MaterialAvatar avatar = getWidget(false);

        // when / then
        checkSVGWithHeight(avatar);

        // Standard
        // given
        attachWidget();

        // when / then
        checkSVGWithHeight(avatar);
    }

    protected void checkSVGWithHeight(MaterialAvatar avatar) {
        final String WIDTH = "50";
        final String HEIGHT = "50";
        avatar.setWidth(WIDTH);
        avatar.setHeight(HEIGHT);
        assertTrue(avatar.getElement().hasAttribute("width"));
        assertEquals(WIDTH, avatar.getElement().getAttribute("width"));
        assertTrue(avatar.getElement().hasAttribute("height"));
        assertEquals(HEIGHT, avatar.getElement().getAttribute("height"));
    }

    public void testOptions() {
        // UiBinder
        // given
        MaterialAvatar avatar = getWidget(false);

        // when / then
        checkOptions(avatar);

        // Standard
        // given
        attachWidget();

        // when / then
        checkOptions(avatar);
    }

    public void checkOptions(MaterialAvatar avatar) {
        final Double[] HUES = new Double[]{1.0, 2.0};
        final Double[] LIGHTNESS_COLOR = new Double[]{2.0, 3.0};
        final Double[] GRAYSCALE = new Double[]{2.0, 3.0};

        AvatarOptions options = new AvatarOptions();
        // Hues
        options.setHues(HUES);
        assertEquals(HUES, options.getHues());
        // Lightness
        final AvatarLightnessOptions lightnessOptions = new AvatarLightnessOptions();
        lightnessOptions.setColor(LIGHTNESS_COLOR);
        assertEquals(LIGHTNESS_COLOR, lightnessOptions.getColor());
        lightnessOptions.setGrayscale(GRAYSCALE);
        assertEquals(GRAYSCALE, lightnessOptions.getGrayscale());
        options.setLightness(lightnessOptions);
        assertEquals(lightnessOptions, options.getLightness());
        // Saturation
        final AvatarSaturationOptions saturationOptions = new AvatarSaturationOptions();
        saturationOptions.setColor(1.0);
        assertEquals(1.0, saturationOptions.getColor());
        saturationOptions.setGrayscale(0.5);
        assertEquals(0.5, saturationOptions.getGrayscale());
        options.setSaturation(saturationOptions);
        assertEquals(saturationOptions, options.getSaturation());
        // Padding
        final int PADDING = 20;
        options.setPadding(PADDING);
        assertEquals(PADDING, options.getPadding());
        // Back Color
        final String BACK_COLOR = "#ffffff";
        options.setBackColor(BACK_COLOR);
        assertEquals(BACK_COLOR, options.getBackColor());
        // Replace Mode
        options.setReplaceMode(ReplaceMode.NEVER);
        assertEquals(ReplaceMode.NEVER.getName(), options.getReplaceMode());
        options.setReplaceMode(ReplaceMode.OBSERVE);
        assertEquals(ReplaceMode.OBSERVE.getName(), options.getReplaceMode());
        options.setReplaceMode(ReplaceMode.ONCE);
        assertEquals(ReplaceMode.ONCE.getName(), options.getReplaceMode());
        avatar.setOptions(options);
        assertEquals(options, avatar.getOptions());
    }
}
