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
package gwt.material.design.incubator.client.ui;

import com.google.gwt.dom.client.Element;
import gwt.material.design.incubator.client.MaterialWidgetTest;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.emptystate.EmptyState;

/**
 * Test case for Empty State Component
 *
 * @author kevzlou7979
 */
public class EmptyStateTest extends MaterialWidgetTest<EmptyState> {

    @Override
    protected EmptyState createWidget() {
        return new EmptyState();
    }

    public void testStructure() {
        EmptyState emptyState = getWidget();

        Element element = emptyState.getElement();
        assertTrue(element.hasClassName(IncubatorCssName.EMPTY_STATE));
        assertEquals(emptyState.getWidgetCount(), 3);
        // Check for Image
        assertTrue(emptyState.getWidget(0) instanceof MaterialImage);
        MaterialImage image = (MaterialImage) emptyState.getWidget(0);
        checkImage(emptyState, image);
        // Check for Title and Description
        assertTrue(emptyState.getWidget(1) instanceof MaterialLabel);
        MaterialLabel title = (MaterialLabel) emptyState.getWidget(1);
        assertTrue(emptyState.getWidget(2) instanceof MaterialLabel);
        MaterialLabel description = (MaterialLabel) emptyState.getWidget(2);

        checkTitleDescription(emptyState, title, description);
    }

    protected void checkTitleDescription(EmptyState emptyState, MaterialLabel title, MaterialLabel description) {
        final String TITLE = "title";
        final String DESCRIPTION = "description";
        emptyState.setTitle(TITLE);
        assertEquals(emptyState.getTitle(), TITLE);
        assertEquals(title.getText(), TITLE);

        emptyState.setDescription(DESCRIPTION);
        assertEquals(emptyState.getDescription(), DESCRIPTION);
        assertEquals(description.getText(), DESCRIPTION);

        emptyState.setDescription(DESCRIPTION);
    }

    protected void checkImage(EmptyState emptyState, MaterialImage image) {
        final String URL = "test.png";
        emptyState.setUrl(URL);
        assertEquals(emptyState.getUrl(), URL);
        assertEquals(emptyState.getUrl(), image.getUrl());
        assertEquals(image.getUrl(), URL);
    }
}
