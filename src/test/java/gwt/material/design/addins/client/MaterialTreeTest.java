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
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.tree.MaterialTree;
import gwt.material.design.addins.client.tree.MaterialTreeItem;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.html.Span;

/**
 * Test case for tree component
 *
 * @author kevzlou7979
 */
public class MaterialTreeTest extends MaterialAddinsTest {

    public void init() {
        MaterialTree tree = new MaterialTree();
        checkWidget(tree);
        checkStructure(tree);
        checkSelectedItem(tree);
        checkExpandAndColapse(tree);
        checkCreateItemAndSelect(tree);
        checkInsertItemAndSelect(tree);
        checkCreateSubItemAndSelect(tree);
        checkInsertSubItemAndSelect(tree);
    }

    protected void checkCreateItemAndSelect(MaterialTree tree) {
        MaterialTreeItem treeItem = new MaterialTreeItem();
        treeItem.setText("Child");
        tree.add(treeItem);
        treeItem.select();
    }

    protected void checkInsertItemAndSelect(MaterialTree tree) {
        MaterialTreeItem treeItem = new MaterialTreeItem();
        treeItem.setText("Child");
        tree.insert(treeItem, 0);
        treeItem.select();
    }

    protected void checkCreateSubItemAndSelect(MaterialTree tree) {
        MaterialTreeItem root = new MaterialTreeItem("Root");
        tree.add(root);
        MaterialTreeItem child = new MaterialTreeItem("Child");
        root.add(child);
        tree.expand();
        child.select();
    }

    protected void checkInsertSubItemAndSelect(MaterialTree tree) {
        MaterialTreeItem root = new MaterialTreeItem("Root");
        tree.add(root);
        MaterialTreeItem child = new MaterialTreeItem("Child");
        root.insert(child, 0);
        tree.expand();
        child.select();
    }

    protected <T extends MaterialTree> void checkExpandAndColapse(T tree) {
        tree.expand();
        checkItemVisibility(tree, true);
        tree.collapse();
        checkItemVisibility(tree, false);
    }

    protected <T extends MaterialTree> void checkItemVisibility(T tree, boolean isVisible) {
        for (Widget w : tree) {
            assertNotNull(w);
            assertTrue(w instanceof MaterialTreeItem);
            MaterialTreeItem item = (MaterialTreeItem) w;
            if (isVisible) {
                assertTrue(item.isHide());
            } else {
                assertFalse(item.isHide());
            }
            assertEquals(item.getTreeItems().size(), 3);
            for (MaterialTreeItem childItem : item.getTreeItems()) {
                assertNotNull(childItem);
                // Check whether item's child is visible or not
                if (isVisible) {
                    assertTrue(childItem.isVisible());
                } else {
                    assertFalse(childItem.isVisible());
                }
            }
        }
    }

    protected <T extends MaterialTree> void checkSelectedItem(T tree) {
        assertNotNull(tree.getWidget(0));
        assertTrue(tree.getWidget(0) instanceof MaterialTreeItem);
        MaterialTreeItem item = (MaterialTreeItem) tree.getWidget(0);
        tree.setSelectedItem(item);
        assertEquals(tree.getSelectedItem(), item);
        tree.deselectSelectedItem();
        assertFalse(item.getElement().hasClassName(AddinsCssName.SELECTED));
        assertNull(tree.getSelectedItem());
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

            // Add more nested child
            for (int k = 1; k <= 3; k++) {
                MaterialTreeItem child = new MaterialTreeItem("item" + k);
                item.add(child);
            }
        }
        assertEquals(widget.getChildren().size(), 5);
    }
}
