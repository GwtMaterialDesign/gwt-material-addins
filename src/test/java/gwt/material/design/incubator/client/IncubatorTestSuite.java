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
package gwt.material.design.incubator.client;

import com.google.gwt.junit.tools.GWTTestSuite;
import gwt.material.design.addins.client.ui.MaterialAutocompleteTest;
import gwt.material.design.addins.client.ui.MaterialAvatarTest;
import gwt.material.design.incubator.client.toggle.GroupToggleButton;
import gwt.material.design.incubator.client.ui.*;
import junit.framework.Test;
import junit.framework.TestSuite;

public class IncubatorTestSuite extends GWTTestSuite {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test Suite for Incubator Widgets");

        // Incubator Widgets Tests
        suite.addTestSuite(AlertTest.class);
        suite.addTestSuite(GroupToggleButtonTest.class);
        suite.addTestSuite(LoadingStateTest.class);
        suite.addTestSuite(ReCaptchaTest.class);
        suite.addTestSuite(TimerProgressTest.class);
        return suite;
    }
}
