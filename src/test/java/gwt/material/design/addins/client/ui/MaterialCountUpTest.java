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

    @Override
    protected MaterialCountUp createWidget() {
        MaterialCountUp countUp = new MaterialCountUp();
        countUp.setStartValue(0);
        countUp.setEndValue(1);
        assertEquals(countUp.getStartValue(), 0.0);
        assertEquals(countUp.getEndValue(), 10.5);
        return countUp;
    }

    public void testSeparatorAndDecimal() {
        // given
        MaterialCountUp countUp = getWidget();

        // when / then
        countUp.setSeparator(",");
        countUp.setDecimal(".");
        countUp.setDecimals(2);
        assertEquals(countUp.getSeparator(), ",");
        assertEquals(countUp.getDecimal(), ".");
        assertEquals(countUp.getDecimals(), 2.0);
    }

    public void testDuration() {
        // given
        MaterialCountUp countup = getWidget();

        // when / then
        countup.setDuration(1000);
        assertEquals(countup.getDuration(), 1000.0);
    }

    public void testSuffixAndPrefix() {
        // given
        MaterialCountUp countUp = getWidget();

        // when / then
        countUp.setPrefix("$");
        countUp.setSuffix("US");
        assertEquals(countUp.getPrefix(), "$");
        assertEquals(countUp.getSuffix(), "US");
    }

    public void testReset() {
        // given
        MaterialCountUp countUp = getWidget();

        // given / then
        countUp.reset();
        assertEquals("", countUp.getElement().getInnerHTML());
    }
}
