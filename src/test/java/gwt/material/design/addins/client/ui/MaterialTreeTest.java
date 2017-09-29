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
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialWidgetTest;
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
public class MaterialTreeTest extends MaterialWidgetTest<MaterialTree> {

    @Override
    protected MaterialTree createWidget() {
        return new MaterialTree();
    }

    public void testCreateItemAndSelect() {
        MaterialTree tree = getWidget();
        MaterialTreeItem treeItem = new MaterialTreeItem();
        treeItem.setText("Child");
        tree.add(treeItem);
        treeItem.select();
    }

    public void testInsertItemAndSelect() {
        MaterialTree tree = getWidget();
        MaterialTreeItem treeItem = new MaterialTreeItem();
        treeItem.setText("Child");
        tree.insert(treeItem, 0);
        treeItem.select();
    }

    public void testCreateSubItemAndSelect() {
        MaterialTree tree = getWidget();
        MaterialTreeItem root = new MaterialTreeItem("Root");
        tree.add(root);
        MaterialTreeItem child = new MaterialTreeItem("Child");
        root.add(child);
        tree.expand();
        child.select();
    }

    public void testInsertSubItemAndSelect() {
        MaterialTree tree = getWidget();
        MaterialTreeItem root = new MaterialTreeItem("Root");
        tree.add(root);
        MaterialTreeItem child = new MaterialTreeItem("Child");
        root.insert(child, 0);
        tree.expand();
        child.select();
    }

    protected <T extends MaterialTree> void testExpandAndColapse(T tree) {
        tree.expand();
        testItemVisibility(tree, true);
        tree.collapse();
        testItemVisibility(tree, false);
    }

    protected <T extends MaterialTree> void testItemVisibility(T tree, boolean isVisible) {
        for (Widget w : tree) {
            assertNotNull(w);
            assertTrue(w instanceof MaterialTreeItem);
            MaterialTreeItem item = (MaterialTreeItem) w;
            if (isVisible) {
                assertTrue(item.isHide());
            } else {
                assertFalse(item.isHide());
            }
            assertEquals(3, item.getTreeItems().size());
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

    protected <T extends MaterialTree> void testSelectedItem(T tree) {
        assertNotNull(tree.getWidget(0));
        assertTrue(tree.getWidget(0) instanceof MaterialTreeItem);
        MaterialTreeItem item = (MaterialTreeItem) tree.getWidget(0);
        tree.setSelectedItem(item);
        assertEquals(item, tree.getSelectedItem());
        tree.deselectSelectedItem();
        assertFalse(item.getElement().hasClassName(AddinsCssName.SELECTED));
        assertNull(tree.getSelectedItem());
    }

    protected <T extends MaterialTree> void testStructure(T tree) {
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
    public void testChildren() {
        MaterialTree tree = getWidget();
        RootPanel.get().add(tree);
        for (int i = 1; i <= 5; i++) {
            final String TEXT = "item" + i;
            final String URL = "url" + i + ".png";
            MaterialTreeItem item = new MaterialTreeItem();
            item.setUrl(URL);
            item.setIconType(IconType.POLYMER);
            item.setText(TEXT);
            tree.add(item);
        }

        for (int i = 0; i < 5; i++) {
            final String TEXT = "item" + (i + 1);
            final String URL = "url" + (i + 1) + ".png";
            MaterialTreeItem item = (MaterialTreeItem) tree.getWidget(i);
            MaterialWidget divHeader = (MaterialWidget) item.getWidget(0);
            // Check Url
            assertEquals(URL, item.getUrl());
            assertTrue(divHeader.getWidget(0) instanceof MaterialImage);
            MaterialImage image = (MaterialImage) divHeader.getWidget(0);
            assertEquals(image.getUrl(), URL);
            assertTrue(image.getElement().hasAttribute("src"));

            // Check Icon
            assertTrue(divHeader.getWidget(1) instanceof MaterialIcon);
            MaterialIcon icon = (MaterialIcon) divHeader.getWidget(1);
            assertEquals(IconType.POLYMER, icon.getIconType());

            // Check Text
            assertEquals(TEXT, item.getText());
            assertTrue(divHeader.getWidget(2) instanceof Span);
            Span span = (Span) divHeader.getWidget(2);
            assertEquals(TEXT, span.getText());

            // Add more nested child
            for (int k = 1; k <= 3; k++) {
                MaterialTreeItem child = new MaterialTreeItem("item" + k);
                item.add(child);
            }
        }
        assertEquals(5, tree.getChildren().size());
    }
}
