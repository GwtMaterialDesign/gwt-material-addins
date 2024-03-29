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

import gwt.material.design.addins.client.inputmask.AbstractInputMask;
import gwt.material.design.addins.client.ui.base.MaterialValueBoxTest;

/**
 * Test case for Input Mask component
 *
 * @author kevzlou7979
 */
public class MaterialInputMaskTest extends MaterialValueBoxTest<AbstractInputMask> {

    final static String MASK_REGEX = "000.000.000.000";
    final static String VALUE = "123456789098";
    final static String EXPECTED_VALUE = "123456789098";

    @Override
    protected AbstractInputMask createWidget() {
        return new AbstractInputMask();
    }

    public void testProperties() {
        // UiBinder
        // given
        AbstractInputMask inputMask = getWidget();
        inputMask.setMask(MASK_REGEX);

        assertEquals(MASK_REGEX, inputMask.getMask());

        // when / then
        checkProperties(inputMask);

        // Standard
        // given
        attachWidget();

        // when / then
        checkProperties(inputMask);
    }

    protected void checkProperties(AbstractInputMask inputMask) {
        inputMask.setSelectOnFocus(true);
        assertTrue(inputMask.isSelectOnFocus());
        inputMask.setSelectOnFocus(false);
        assertFalse(inputMask.isSelectOnFocus());

        inputMask.setClearIfNotMatch(true);
        assertTrue(inputMask.isClearIfNotMatch());
        inputMask.setClearIfNotMatch(false);
        assertFalse(inputMask.isClearIfNotMatch());

        inputMask.setReverse(true);
        assertTrue(inputMask.isReverse());
        inputMask.setReverse(false);
        assertFalse(inputMask.isClearIfNotMatch());
    }

    public void testValue() {
        // UiBinder
        // given
        AbstractInputMask inputMask = getWidget();

        // when / then
        checkValue(inputMask, false);

        // Standard
        // given
        attachWidget();

        // when / then
        checkValue(inputMask, true);
    }

    protected void checkValue(AbstractInputMask inputMask, boolean checkCleanValue) {
        inputMask.setMask(MASK_REGEX);
        inputMask.setValue(VALUE);

        if (checkCleanValue) {
            assertEquals(EXPECTED_VALUE, inputMask.getValue());
            assertEquals(VALUE, inputMask.getCleanValue());
        }
    }

    public void testUnMask() {
        AbstractInputMask inputMask = getWidget();

        inputMask.setMask(MASK_REGEX);
        inputMask.setValue(VALUE);
        assertEquals(VALUE, inputMask.getValue());
        inputMask.clear();
        assertEquals("", inputMask.getValue());
    }
}
