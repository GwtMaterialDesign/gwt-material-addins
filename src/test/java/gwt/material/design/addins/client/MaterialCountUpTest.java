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
package gwt.material.design.addins.client;

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.countup.MaterialCountUp;

public class MaterialCountUpTest extends MaterialAddinsTest {

    public void init() {
        MaterialCountUp countUp = new MaterialCountUp();
        RootPanel.get().add(countUp);
        checkWidget(countUp);
        checkProperties(countUp);
    }

    protected <T extends MaterialCountUp> void checkProperties(T carousel) {
        carousel.setStartValue(0);
        carousel.setEndValue(10.5);
        carousel.setSeparator(",");
        carousel.setDecimal(".");
        carousel.setDuration(1000);
        carousel.setDecimals(2);
        carousel.setPrefix("$");
        carousel.setSuffix("US");
        carousel.start();
        assertEquals(carousel.getStartValue(), 0.0);
        assertEquals(carousel.getEndValue(), 10.5);
        assertEquals(carousel.getSeparator(), ",");
        assertEquals(carousel.getDecimal(), ".");
        assertEquals(carousel.getDuration(), 1000.0);
        assertEquals(carousel.getDecimals(), 2.0);
        assertEquals(carousel.getPrefix(), "$");
        assertEquals(carousel.getSuffix(), "US");
    }
}
