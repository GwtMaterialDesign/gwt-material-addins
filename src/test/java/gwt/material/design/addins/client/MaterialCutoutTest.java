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

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.cutout.MaterialCutOut;
import gwt.material.design.client.base.HasCircle;
import gwt.material.design.client.base.HasColors;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;

/**
 * Test case for cut out component
 *
 * @author kevzlou7979
 */
public class MaterialCutoutTest extends MaterialAddinsTest {

    public void init() {
        MaterialCutOut cutOut = new MaterialCutOut();
        checkWidget(cutOut);
        checkOpenHandler(cutOut);
        checkCloseHandler(cutOut);
        checkStructure(cutOut);
        checkOpenCloseProgrammatically(cutOut);
        checkProperties(cutOut);
    }

    protected <T extends MaterialCutOut> void checkProperties(T cutOut) {
        final int ANIMATION_DURATION = 200;
        final String ANIMATION_TIMING = "linear";
        final String BACKGROUND_SIZE = "100px";
        final int CUTOUT_PADDING = 20;
        cutOut.setAnimated(true);
        assertTrue(cutOut.isAnimated());
        cutOut.setAnimated(false);
        assertFalse(cutOut.isAnimated());
        cutOut.setDuration(ANIMATION_DURATION);
        assertEquals(cutOut.getDuration(), ANIMATION_DURATION);
        cutOut.setAnimationTimingFunction(ANIMATION_TIMING);
        assertEquals(cutOut.getAnimationTimingFunction(), ANIMATION_TIMING);
        cutOut.setBackgroundSize(BACKGROUND_SIZE);
        assertEquals(cutOut.getBackgroundSize(), BACKGROUND_SIZE);
        cutOut.setCutOutPadding(CUTOUT_PADDING);
        assertEquals(cutOut.getCutOutPadding(), CUTOUT_PADDING);
    }

    protected <T extends MaterialCutOut> void checkStructure(T cutOut) {
        RootPanel.get().add(cutOut);
        MaterialButton target = new MaterialButton();
        cutOut.setTarget(target);
        assertEquals(cutOut.getTargetElement(), target.getElement());
    }

    protected <T extends MaterialCutOut> void checkOpenCloseProgrammatically(T cutOut) {
        final boolean[] isOpenFired = {false};
        cutOut.addOpenHandler(openEvent -> {
            isOpenFired[0] = true;
        });
        cutOut.open();

        final boolean[] isCloseFired = {false};
        cutOut.addCloseHandler(closeEvent -> {
            isCloseFired[0] = true;
        });
        cutOut.close();

        assertTrue(isOpenFired[0]);
        assertTrue(isCloseFired[0]);
    }

    @Override
    protected <T extends MaterialWidget & HasColors> void checkColor(T widget) {
        widget.setBackgroundColor(Color.RED);
        assertEquals(widget.getBackgroundColor(), Color.RED);

        widget.setTextColor(Color.RED);
        assertEquals(widget.getTextColor(), Color.RED);
    }

    @Override
    protected <T extends MaterialWidget & HasCircle> void checkCircle(T widget) {
        widget.setCircle(true);
        assertTrue(widget.isCircle());
        widget.setCircle(false);
        assertFalse(widget.isCircle());
    }
}
