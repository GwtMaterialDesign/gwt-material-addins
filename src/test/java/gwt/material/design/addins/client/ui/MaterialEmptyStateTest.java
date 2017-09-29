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
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.emptystate.MaterialEmptyState;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTitle;
import gwt.material.design.client.ui.html.Div;

public class MaterialEmptyStateTest extends MaterialWidgetTest<MaterialEmptyState> {

    @Override
    protected MaterialEmptyState createWidget() {
        return new MaterialEmptyState();
    }

    public void testStructure() {
        MaterialEmptyState emptyState = getWidget();

        final String TITLE = "title";
        final String DESCRIPTION = "description";
        final IconType ICON = IconType.POLL;

        emptyState.setTitle(TITLE);
        emptyState.setDescription(DESCRIPTION);
        emptyState.setIconType(ICON);
        RootPanel.get().add(emptyState);

        assertTrue(emptyState.getElement().hasClassName(AddinsCssName.EMPTY_STATE));
        assertTrue(emptyState.getElement().hasClassName(CssName.VALIGN_WRAPPER));

        assertEquals(1, emptyState.getWidgetCount());
        assertEquals(emptyState.getContainer(), emptyState.getWidget(0));

        Div container = emptyState.getContainer();
        assertEquals(1, container.getWidgetCount());
        assertTrue(container.getElement().hasClassName(CssName.VALIGN));
        assertTrue(container.getElement().hasClassName(CssName.CENTER));

        assertTrue(container.getWidget(0) instanceof MaterialTitle);
        MaterialTitle title = (MaterialTitle) container.getWidget(0);

        assertEquals(TITLE, title.getHeader().getText());
        assertEquals(DESCRIPTION, title.getParagraph().getText());

        assertTrue(title.getWidget(0) instanceof MaterialIcon);
        MaterialIcon icon = (MaterialIcon) title.getWidget(0);
        assertEquals(ICON, icon.getIconType());
    }

    public void testLoading() {
        MaterialEmptyState emptyState = getWidget();
        emptyState.setLoading(true);
        assertTrue(emptyState.isLoading());
        emptyState.setLoading(false);
        assertFalse(emptyState.isLoading());
    }
}
