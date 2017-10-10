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
        return new MaterialCountUp();
    }

    public void testProperties() {
        // given
        MaterialCountUp countup = getWidget();

        // when / then
        countup.setStartValue(0);
        countup.setEndValue(10.5);
        countup.setSeparator(",");
        countup.setDecimal(".");
        countup.setDuration(1000);
        countup.setDecimals(2);
        countup.setPrefix("$");
        countup.setSuffix("US");
        countup.start();
        assertEquals(countup.getStartValue(), 0.0);
        assertEquals(countup.getEndValue(), 10.5);
        assertEquals(countup.getSeparator(), ",");
        assertEquals(countup.getDecimal(), ".");
        assertEquals(countup.getDuration(), 1000.0);
        assertEquals(countup.getDecimals(), 2.0);
        assertEquals(countup.getPrefix(), "$");
        assertEquals(countup.getSuffix(), "US");
    }
}
