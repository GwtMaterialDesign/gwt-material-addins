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

import com.google.gwt.core.client.Scheduler;
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.scrollfire.MaterialScrollfire;
import gwt.material.design.client.ui.MaterialPanel;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * Test case for scrollfire component
 *
 * @author kevzlou7979
 */
public class MaterialScrollfireTest extends MaterialWidgetTest<MaterialPanel> {

    @Override
    protected MaterialPanel createWidget() {
        return new MaterialPanel();
    }

    public void testScrollfire() {
        // UiBinder
        // given
        MaterialPanel panel = getWidget(false);

        // when / then
        checkScrollfire(panel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkScrollfire(panel);
    }

    protected void checkScrollfire(MaterialPanel panel) {
        final boolean[] isScrollFired = {false};
        // when / then
        MaterialScrollfire scrollfire = new MaterialScrollfire(panel.getElement());
        scrollfire.setCallback(() -> isScrollFired[0] = true);
        scrollfire.apply();
        $("body").scrollTop(1000);
        Scheduler.get().scheduleDeferred(() -> assertTrue(isScrollFired[0]));
    }
}
