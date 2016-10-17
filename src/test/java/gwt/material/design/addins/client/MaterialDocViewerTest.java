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

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.docviewer.MaterialDocViewer;

/**
 * Test case for doc viewer component
 *
 * @author kevzlou7979
 */
public class MaterialDocViewerTest extends MaterialAddinsTest {

    public void init() {
        MaterialDocViewer docViewer = new MaterialDocViewer();
        checkWidget(docViewer);
        checkUrl(docViewer);
    }

    protected <T extends MaterialDocViewer> void checkUrl(T docViewer) {
        final String URL = "someurl";
        docViewer.setUrl(URL);
        RootPanel.get().add(docViewer);
        assertEquals(docViewer.getUrl(), URL);
        assertTrue(docViewer.getElement().hasAttribute("src"));
        docViewer.setEmbedded(true);
        assertEquals(docViewer.getElement().getAttribute("src"), "http://docs.google.com/gview?url=someurl&embedded=true");
        docViewer.setEmbedded(false);
        docViewer.removeFromParent();
        RootPanel.get().add(docViewer);
        assertEquals(docViewer.getElement().getAttribute("src"), "http://docs.google.com/gview?url=someurl&embedded=false");
    }
}
