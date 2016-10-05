/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
import gwt.material.design.addins.client.avatar.MaterialAvatar;
import gwt.material.design.addins.client.bubble.MaterialBubble;
import gwt.material.design.addins.client.dnd.MaterialDnd;
import gwt.material.design.addins.client.docviewer.MaterialDocViewer;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.addins.client.iconmorph.MaterialIconMorph;
import gwt.material.design.addins.client.menubar.MaterialMenuBar;
import gwt.material.design.addins.client.rating.MaterialRating;
import gwt.material.design.addins.client.scrollfire.MaterialScrollfire;
import gwt.material.design.addins.client.splitpanel.MaterialSplitPanel;
import gwt.material.design.addins.client.stepper.MaterialStepper;
import gwt.material.design.client.ui.MaterialIcon;
import junit.framework.Test;
import junit.framework.TestCase;

public class GwtMaterialAddinsTestSuite extends TestCase {

    public static Test suite() {
        final GWTTestSuite suite = new GWTTestSuite("gwt-material-addins test suite");
        suite.addTestSuite(MaterialAutocompleteTest.class);
        suite.addTestSuite(MaterialAvatarTest.class);
        suite.addTestSuite(MaterialBubbleTest.class);
        suite.addTestSuite(MaterialCameraTest.class);
        suite.addTestSuite(MaterialComboBoxTest.class);
        suite.addTestSuite(MaterialCutoutTest.class);
        suite.addTestSuite(MaterialDndTest.class);
        suite.addTestSuite(MaterialDocViewerTest.class);
        suite.addTestSuite(MaterialFileUploaderTest.class);
        suite.addTestSuite(MaterialIconMorphTest.class);
        suite.addTestSuite(MaterialMasonryTest.class);
        suite.addTestSuite(MaterialMenuBarTest.class);
        suite.addTestSuite(MaterialOverlayTest.class);
        suite.addTestSuite(MaterialPathAnimatorTest.class);
        suite.addTestSuite(MaterialPopupMenuTest.class);
        suite.addTestSuite(MaterialRatingTest.class);
        suite.addTestSuite(MaterialRichEditorTest.class);
        suite.addTestSuite(MaterialScrollfireTest.class);
        suite.addTestSuite(MaterialSplitPanelTest.class);
        suite.addTestSuite(MaterialStepperTest.class);
        suite.addTestSuite(MaterialSubheaderTest.class);
        suite.addTestSuite(MaterialTimePickerTest.class);
        suite.addTestSuite(MaterialTreeTest.class);
        suite.addTestSuite(MaterialWindowTest.class);
        suite.addTestSuite(MaterialTimePickerTest.class);
        return suite;
    }
}
