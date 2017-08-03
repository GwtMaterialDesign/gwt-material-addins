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

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.scrollfire.MaterialScrollfire;
import gwt.material.design.client.ui.MaterialPanel;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * Test case for scrollfire component
 *
 * @author kevzlou7979
 */
public class MaterialScrollfireTest extends MaterialAddinsTest {

    public void init() {
        MaterialPanel panel = new MaterialPanel();
        RootPanel.get().add(panel);
        final boolean[] isScrollFired = {false};
        MaterialScrollfire scrollfire = new MaterialScrollfire(panel.getElement());
        scrollfire.setCallback(() -> {
            isScrollFired[0] = true;
        });
        scrollfire.apply();
        $("body").scrollTop(1000);
        Scheduler.get().scheduleDeferred(() -> {
            assertTrue(isScrollFired[0]);
        });
    }
}
