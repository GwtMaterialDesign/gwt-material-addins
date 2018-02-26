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

import gwt.material.design.addins.client.livestamp.MaterialLiveStamp;
import gwt.material.design.addins.client.ui.base.AbstractValueWidgetTest;
import gwt.material.design.client.base.AbstractValueWidget;

import java.util.Date;

/**
 * Test case for Live Stamp component
 *
 * @author kevzlou7979
 */
public class MaterialLiveStampTest extends AbstractValueWidgetTest<MaterialLiveStamp> {

    final static Date VALUE = new Date();
    final static Date SECOND_VALUE = new Date(12,12,12);

    @Override
    protected MaterialLiveStamp createWidget() {
        return new MaterialLiveStamp();
    }

    public void testStructure() {
        MaterialLiveStamp liveStamp = getWidget();

        assertTrue(liveStamp instanceof AbstractValueWidget);
        assertEquals("SPAN", liveStamp.getElement().getTagName());
    }

    public void testValue() {
        // given
        MaterialLiveStamp liveStamp = getWidget();

        // when / then
        liveStamp.setValue(VALUE);
        assertSame(VALUE.toString(), liveStamp.getValue().toString());
    }
}
