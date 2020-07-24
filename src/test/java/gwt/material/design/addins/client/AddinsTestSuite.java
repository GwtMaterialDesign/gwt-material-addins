/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2020 GwtMaterialDesign
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

import com.google.gwt.junit.tools.GWTTestSuite;
import gwt.material.design.addins.client.ui.*;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.animation.AnimationTest;
import gwt.material.design.client.ui.helper.ColorHelperTest;
import gwt.material.design.client.ui.helper.EnumHelperTest;
import gwt.material.design.client.ui.helper.ScrollHelperTest;
import gwt.material.design.client.ui.pwa.PwaManagerTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AddinsTestSuite extends GWTTestSuite {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test Suite for Addins");

        // Addins Tests
        suite.addTestSuite(MaterialAutocompleteTest.class);
        suite.addTestSuite(MaterialAvatarTest.class);
        suite.addTestSuite(MaterialBubbleTest.class);
        suite.addTestSuite(MaterialCameraTest.class);
        suite.addTestSuite(MaterialCarouselTest.class);
        suite.addTestSuite(MaterialCircularProgressTest.class);
        suite.addTestSuite(MaterialComboBoxTest.class);
        suite.addTestSuite(MaterialCountUpTest.class);
        suite.addTestSuite(MaterialCutoutTest.class);
        suite.addTestSuite(MaterialDndTest.class);
        suite.addTestSuite(MaterialDocViewerTest.class);
        suite.addTestSuite(MaterialEmptyStateTest.class);
        suite.addTestSuite(MaterialFileUploaderTest.class);
        suite.addTestSuite(MaterialIconMorphTest.class);
        suite.addTestSuite(MaterialImageCropperTest.class);
        suite.addTestSuite(MaterialInputMaskTest.class);
        suite.addTestSuite(MaterialLiveStampTest.class);
        suite.addTestSuite(MaterialMenuBarTest.class);
        suite.addTestSuite(MaterialOverlayTabTest.class);
        suite.addTestSuite(MaterialOverlayTest.class);
        suite.addTestSuite(MaterialPathAnimatorTest.class);
        suite.addTestSuite(MaterialPopupMenuTest.class);
        suite.addTestSuite(MaterialRatingTest.class);
        suite.addTestSuite(MaterialRichEditorTest.class);
        suite.addTestSuite(MaterialScrollfireTest.class);
        suite.addTestSuite(MaterialSideProfileTest.class);
        suite.addTestSuite(MaterialSignaturePadTest.class);
        suite.addTestSuite(MaterialSplitPanelTest.class);
        suite.addTestSuite(MaterialStepperTest.class);
        suite.addTestSuite(MaterialSubheaderTest.class);
        suite.addTestSuite(MaterialSwipeableTest.class);
        suite.addTestSuite(MaterialTimePickerTest.class);
        suite.addTestSuite(MaterialTreeTest.class);
        suite.addTestSuite(MaterialWebpImageTest.class);
        suite.addTestSuite(MaterialWindowTest.class);
        return suite;
    }
}
