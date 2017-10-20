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

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.docviewer.MaterialDocViewer;

/**
 * Test case for doc viewer component
 *
 * @author kevzlou7979
 */
public class MaterialDocViewerTest extends MaterialWidgetTest<MaterialDocViewer> {

    @Override
    protected MaterialDocViewer createWidget() {
        return new MaterialDocViewer();
    }

    public void testUrl() {
        // UiBinder
        // given
        MaterialDocViewer docViewer = getWidget(false);

        // when / then
        checkUrl(docViewer);

        // Standard
        // given
        attachWidget();

        // when / then
        checkUrl(docViewer);
    }

    protected void checkUrl(MaterialDocViewer docViewer) {
        final String URL = "someurl";
        docViewer.setUrl(URL);
        RootPanel.get().add(docViewer);
        assertEquals(URL, docViewer.getUrl());
        assertTrue(docViewer.getElement().hasAttribute("src"));
        docViewer.setEmbedded(true);
        assertEquals("https://docs.google.com/gview?url=someurl&embedded=true", docViewer.getElement().getAttribute("src"));
        docViewer.setEmbedded(false);
        assertEquals("https://docs.google.com/gview?url=someurl&embedded=false", docViewer.getElement().getAttribute("src"));
    }
}
