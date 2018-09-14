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
import gwt.material.design.addins.client.countup.MaterialCountUp;

public class MaterialCountUpTest extends MaterialWidgetTest<MaterialCountUp> {

    final static double START_VALUE = 0.0;
    final static double END_VALUE = 100.0;
    final static double DURATION = 200.0;
    final static double DECIMALS = 2.0;

    @Override
    protected MaterialCountUp createWidget() {
        MaterialCountUp countUp = new MaterialCountUp();
        countUp.setStartValue(START_VALUE);
        countUp.setEndValue(END_VALUE);
        assertEquals(countUp.getStartValue(), START_VALUE);
        assertEquals(countUp.getEndValue(), END_VALUE);
        return countUp;
    }

    public void testSeparatorAndDecimal() {
        // UiBinder
        // given
        MaterialCountUp countUp = getWidget(false);

        // when / then
        checkSeparatorAndDecimal(countUp);

        // Standard
        // given
        attachWidget();

        // when / then
        checkSeparatorAndDecimal(countUp);
    }

    protected void checkSeparatorAndDecimal(MaterialCountUp countUp) {
        countUp.setSeparator(",");
        countUp.setDecimal(".");
        countUp.setDecimals(DECIMALS);
        assertEquals(countUp.getSeparator(), ",");
        assertEquals(countUp.getDecimal(), ".");
        assertEquals(countUp.getDecimals(), DECIMALS);
    }

    public void testDuration() {
        // UiBinder
        // given
        MaterialCountUp countup = getWidget(false);

        // when / then
        checkDuration(countup);

        // Standard
        // given
        attachWidget();

        // when / then
        checkDuration(countup);
    }

    protected void checkDuration(MaterialCountUp countUp) {
        countUp.setDuration(DURATION);
        assertEquals(countUp.getDuration(), DURATION);
    }

    public void testSuffixAndPrefix() {
        // UiBinder
        // given
        MaterialCountUp countUp = getWidget(false);

        // when / then
        checkSuffixAndPrefix(countUp);

        // Standard
        // given
        attachWidget();

        // when / then
        checkSuffixAndPrefix(countUp);
    }

    protected void checkSuffixAndPrefix(MaterialCountUp countUp) {
        countUp.setPrefix("$");
        countUp.setSuffix("US");
        assertEquals(countUp.getPrefix(), "$");
        assertEquals(countUp.getSuffix(), "US");
    }

    public void testReset() {
        // UiBinder
        // given
        MaterialCountUp countUp = getWidget(false);

        // when / then
        checkReset(countUp);

        // Standard
        // given
        attachWidget();

        // when / then
        checkReset(countUp);
    }

    protected void checkReset(MaterialCountUp countUp) {
        countUp.setStartValue(START_VALUE);
        countUp.setEndValue(END_VALUE);
        countUp.start();
        countUp.reset();
        assertEquals("0", countUp.getElement().getInnerHTML());
    }
}
