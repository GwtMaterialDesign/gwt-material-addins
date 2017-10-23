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
import gwt.material.design.addins.client.signature.MaterialSignaturePad;
import gwt.material.design.addins.client.signature.events.SignatureClearEvent;
import gwt.material.design.addins.client.signature.events.SignatureEndEvent;
import gwt.material.design.addins.client.signature.events.SignatureStartEvent;

/**
 * Test case for Signature Pad component
 *
 * @author kevzlou7979
 */
public class MaterialSignaturePadTest extends MaterialWidgetTest<MaterialSignaturePad> {

    final static double DOT_SIZE = 10.0;
    final static double LINE_MIN_WIDTH = 5.0;
    final static double LINE_MAX_WIDTH = 15.0;
    final static int THROTTLE = 12;
    final static String PEN_COLOR = "#000";
    final static double VELOCITY_FILTER_WEIGHT = 10.0;


    @Override
    protected MaterialSignaturePad createWidget() {
        return new MaterialSignaturePad();
    }

    public void testStructure() {
        MaterialSignaturePad signaturePad = getWidget();

        assertEquals("CANVAS", signaturePad.getElement().getTagName());
    }

    public void testProperties() {
        // UiBinder
        // given
        MaterialSignaturePad signaturePad = getWidget(false);

        // when / then
        checkSignaturePad(signaturePad);

        // Standard
        // given
        attachWidget();

        // when / then
        checkSignaturePad(signaturePad);
    }

    protected void checkSignaturePad(MaterialSignaturePad signaturePad) {
        signaturePad.setDotSize(DOT_SIZE);
        assertEquals(DOT_SIZE, signaturePad.getDotSize());

        signaturePad.setLineMaxWidth(LINE_MAX_WIDTH);
        assertEquals(LINE_MAX_WIDTH, signaturePad.getLineMaxWidth());

        signaturePad.setLineMinWidth(LINE_MIN_WIDTH);
        assertEquals(LINE_MIN_WIDTH, signaturePad.getLineMinWidth());

        signaturePad.setPenColor(PEN_COLOR);
        assertEquals(PEN_COLOR, signaturePad.getPenColor());

        signaturePad.setThrottle(THROTTLE);
        assertEquals(THROTTLE, signaturePad.getThrottle());

        signaturePad.setVelocityFilterWeight(VELOCITY_FILTER_WEIGHT);
        assertEquals(VELOCITY_FILTER_WEIGHT, signaturePad.getVelocityFilterWeight());
    }

    public void testEvents() {
        MaterialSignaturePad signaturePad = getWidget();

        boolean[] clearFired = {false};
        signaturePad.addSignatureClearHandler(event -> clearFired[0] = true);
        SignatureClearEvent.fire(signaturePad);
        assertTrue(clearFired[0]);

        boolean[] startFired = {false};
        signaturePad.addSignatureStartHandler(event -> startFired[0] = true);
        SignatureStartEvent.fire(signaturePad);
        assertTrue(startFired[0]);

        boolean[] endFired = {false};
        signaturePad.addSignatureEndHandler(event -> endFired[0] = true);
        SignatureEndEvent.fire(signaturePad);
        assertTrue(endFired[0]);
    }

    public void testClear() {
        // given
        MaterialSignaturePad signaturePad = getWidget();

        // when / then
        signaturePad.clear();
        assertTrue(signaturePad.isEmpty());
    }
}
