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
        // UiBinder
        // given
        MaterialCutOut cutOut = getWidget(false);

        // when / then
        checkProperties(cutOut);

        // Standard
        // given
        attachWidget();

        // when / then
        checkProperties(cutOut);
    }

    protected void checkProperties(MaterialCutOut cutOut) {
        final int ANIMATION_DURATION = 200;
        final String ANIMATION_TIMING = "linear";
        final String BACKGROUND_SIZE = "100px";
        final int CUTOUT_PADDING = 20;
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
        // UiBinder
        // given
        MaterialCutOut cutOut = getWidget(false);

        // when / then
        checkStructure(cutOut);

        // Standard
        // given
        attachWidget();

        // when / then
        checkStructure(cutOut);
    }

    protected void checkStructure(MaterialCutOut cutOut) {
        cutOut.setTarget(target);
        assertEquals(cutOut.getTargetElement(), target.getElement());
    }

    public void testOpenCloseProgrammatically() {
        // UiBinder
        // given
        MaterialCutOut cutOut = getWidget(false);

        // when / then
        checkOpenCloseProgrammatically(cutOut);

        // Standard
        // given
        attachWidget();

        // when / then
        checkOpenCloseProgrammatically(cutOut);
    }

    protected void checkOpenCloseProgrammatically(MaterialCutOut cutOut) {
        final boolean[] isOpenFired = {false};
        final boolean[] isCloseFired = {false};
        cutOut.addOpenHandler(openEvent -> isOpenFired[0] = true);
        cutOut.open();
        cutOut.addCloseHandler(closeEvent -> isCloseFired[0] = true);
        cutOut.close();
        assertTrue(isOpenFired[0]);
        assertTrue(isCloseFired[0]);
    }

    @Override
    public void testColor() {
        // UiBinder
        // given
        MaterialCutOut cutOut = getWidget(false);

        // when / then
        checkColor(cutOut);

        // Standard
        // given
        attachWidget();

        // when / then
        checkColor(cutOut);
    }

    protected void checkColor(MaterialCutOut cutOut) {
        cutOut.setBackgroundColor(Color.RED);
        assertEquals(Color.RED, cutOut.getBackgroundColor());
        cutOut.setTextColor(Color.RED);
        assertEquals(Color.RED, cutOut.getTextColor());
    }

    @Override
    public  void testCircle() {
        // UiBinder
        // given
        MaterialCutOut cutOut = getWidget(false);

        // when / then
        checkCircle(cutOut);

        // Standard
        // given
        attachWidget();

        // when / then
        checkCircle(cutOut);
    }

    protected void checkCircle(MaterialCutOut cutOut) {
        cutOut.setCircle(true);
        assertTrue(cutOut.isCircle());
        cutOut.setCircle(false);
        assertFalse(cutOut.isCircle());
    }

    @Override
    public void testOpacity() {
        // UiBinder
        // given
        MaterialCutOut cutOut = getWidget(false);

        // when / then
        checkOpacity(cutOut);

        // Standard
        // given
        attachWidget();

        // when / then
        checkOpacity(cutOut);
    }

    protected void checkOpacity(MaterialCutOut cutOut) {
        cutOut.setOpacity(0.0);
        assertEquals(0.0, cutOut.getOpacity());

        cutOut.setOpacity(1.0);
        assertEquals(1.0, cutOut.getOpacity());
    }
}
