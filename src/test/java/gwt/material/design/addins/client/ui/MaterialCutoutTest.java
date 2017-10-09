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

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.cutout.MaterialCutOut;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;

/**
 * Test case for cut out component
 *
 * @author kevzlou7979
 */
public class MaterialCutoutTest extends MaterialWidgetTest<MaterialCutOut> {

    private MaterialIcon target;

    @Override
    protected MaterialCutOut createWidget() {
        // given
        MaterialCutOut cutOut = new MaterialCutOut();
        target = new MaterialIcon(IconType.POLYMER);
        RootPanel.get().add(target);

        // when
        cutOut.setTarget(target);

        // then
        assertEquals(target.getElement(), cutOut.getTargetElement());
        return cutOut;
    }

    @Override
    protected void gwtTearDown() throws Exception {
        super.gwtTearDown();

        target.removeFromParent();
    }

    public void testProperties() {
        // given
        MaterialCutOut cutOut = getWidget();
        final int ANIMATION_DURATION = 200;
        final String ANIMATION_TIMING = "linear";
        final String BACKGROUND_SIZE = "100px";
        final int CUTOUT_PADDING = 20;

        // when / then
        cutOut.setAnimated(true);
        assertTrue(cutOut.isAnimated());
        cutOut.setAnimated(false);
        assertFalse(cutOut.isAnimated());
        cutOut.setDuration(ANIMATION_DURATION);
        assertEquals(ANIMATION_DURATION, cutOut.getDuration());
        cutOut.setAnimationTimingFunction(ANIMATION_TIMING);
        assertEquals(ANIMATION_TIMING, cutOut.getAnimationTimingFunction());
        cutOut.setBackgroundSize(BACKGROUND_SIZE);
        assertEquals(BACKGROUND_SIZE, cutOut.getBackgroundSize());
        cutOut.setCutOutPadding(CUTOUT_PADDING);
        assertEquals(CUTOUT_PADDING, cutOut.getCutOutPadding());
    }

    public void testStructure() {
        // given
        MaterialCutOut cutOut = getWidget();

        // when / then
        cutOut.setTarget(target);
        assertEquals(cutOut.getTargetElement(), target.getElement());
    }

    public void testOpenCloseProgrammatically() {
        // given
        MaterialCutOut cutOut = getWidget();
        final boolean[] isOpenFired = {false};
        final boolean[] isCloseFired = {false};

        // when / then
        cutOut.addOpenHandler(openEvent -> isOpenFired[0] = true);
        cutOut.open();
        cutOut.addCloseHandler(closeEvent -> isCloseFired[0] = true);
        cutOut.close();
        assertTrue(isOpenFired[0]);
        assertTrue(isCloseFired[0]);
    }

    @Override
    public void testColor() {
        // given
        MaterialCutOut cutOut = getWidget();

        // when / then
        cutOut.setBackgroundColor(Color.RED);
        assertEquals(Color.RED, cutOut.getBackgroundColor());
        cutOut.setTextColor(Color.RED);
        assertEquals(Color.RED, cutOut.getTextColor());
    }

    @Override
    public  void testCircle() {
        // given
        MaterialCutOut cutOut = getWidget();

        // when / then
        cutOut.setCircle(true);
        assertTrue(cutOut.isCircle());
        cutOut.setCircle(false);
        assertFalse(cutOut.isCircle());
    }
}
