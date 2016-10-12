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
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.tree.MaterialTree;
import gwt.material.design.addins.client.tree.MaterialTreeItem;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.html.Span;

public class MaterialTreeTest extends MaterialAddinsTest {

    public void init() {
        MaterialTree tree = new MaterialTree();
        checkWidget(tree);
        checkStructure(tree);
    }

    protected <T extends MaterialTree> void checkStructure(T tree) {
        assertNotNull(tree.getWidget(0));
        assertTrue(tree.getWidget(0) instanceof MaterialTreeItem);
        MaterialTreeItem item = (MaterialTreeItem) tree.getWidget(0);
        assertTrue(item.getDivHeader().getElement().hasClassName(AddinsCssName.TREE_HEADER));
        MaterialWidget divHeader = item.getDivHeader();
        assertTrue(divHeader.getWidget(0) instanceof MaterialImage);
        assertTrue(divHeader.getWidget(1) instanceof MaterialIcon);
        assertTrue(divHeader.getWidget(2) instanceof Span);
    }

    @Override
    protected <T extends MaterialWidget> void checkChildren(T widget) {
        RootPanel.get().add(widget);
        for (int i = 1; i <= 5; i++) {
            final String TEXT = "item" + i;
            final String URL = "url" + i + ".png";
            MaterialTreeItem item = new MaterialTreeItem();
            item.setUrl(URL);
            item.setIconType(IconType.POLYMER);
            item.setText(TEXT);
            widget.add(item);
        }

        for (int i = 0; i < 5; i++) {
            final String TEXT = "item" + (i + 1);
            final String URL = "url" + (i + 1) + ".png";
            MaterialTreeItem item = (MaterialTreeItem) widget.getWidget(i);
            MaterialWidget divHeader = (MaterialWidget) item.getWidget(0);
            // Check Url
            assertEquals(item.getUrl(), URL);
            assertTrue(divHeader.getWidget(0) instanceof MaterialImage);
            MaterialImage image = (MaterialImage) divHeader.getWidget(0);
            assertEquals(image.getUrl(), URL);
            assertTrue(image.getElement().hasAttribute("src"));

            // Check Icon
            assertTrue(divHeader.getWidget(1) instanceof MaterialIcon);
            MaterialIcon icon = (MaterialIcon) divHeader.getWidget(1);
            assertEquals(icon.getIconType(), IconType.POLYMER);

            // Check Text
            assertEquals(item.getText(), TEXT);
            assertTrue(divHeader.getWidget(2) instanceof Span);
            Span span = (Span) divHeader.getWidget(2);
            assertEquals(span.getText(), TEXT);
        }
        assertEquals(widget.getChildren().size(), 5);
    }
}
