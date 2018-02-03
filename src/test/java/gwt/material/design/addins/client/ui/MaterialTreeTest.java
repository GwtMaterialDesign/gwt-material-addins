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

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.OpenEvent;
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

    final static int NUMBER_OF_ITEM = 5;
    final static String TEXT = "sometext";
    final static String URL = "url";
    final static IconType ICON = IconType.POLYMER;

    @Override
    protected MaterialTree createWidget() {
        MaterialTree tree = new MaterialTree();
        for (int i = 1; i <= NUMBER_OF_ITEM; i++) {
            MaterialTreeItem item = new MaterialTreeItem();
            item.setText(TEXT);
            item.setUrl(URL);
            item.setIconType(ICON);
            tree.add(item);
        }
        return tree;
    }

    public void testCreateItemAndSelect() {
        // given
        MaterialTree tree = getWidget();
        MaterialTreeItem item = (MaterialTreeItem) tree.getChildren().get(0);

        // when / then
        item.select();
        assertEquals(item, tree.getSelectedItem());
    }

    public void testInsertItemAndSelect() {
        // given
        MaterialTree tree = getWidget();
        MaterialTreeItem treeItem = new MaterialTreeItem();

        // when / then
        treeItem.setText("Child");
        tree.insert(treeItem, 0);
        treeItem.select();
        assertEquals(treeItem, tree.getWidget(0));
        assertEquals(treeItem, tree.getSelectedItem());
    }

    public void testCreateSubItemAndSelect() {
        // given
        MaterialTree tree = getWidget();
        MaterialTreeItem root = new MaterialTreeItem("Root");
        MaterialTreeItem child = new MaterialTreeItem("Child");

        // when / then
        tree.add(root);
        root.add(child);
        tree.expand();
        child.select();
        assertEquals(child, tree.getSelectedItem());
        assertEquals(child, root.getTreeItems().get(0));
    }

    public void testInsertSubItemAndSelect() {
        // given
        MaterialTree tree = getWidget();
        MaterialTreeItem root = new MaterialTreeItem("Root");
        MaterialTreeItem child = new MaterialTreeItem("Child");

        // when / then
        tree.add(root);
        root.insert(child, 0);
        tree.expand();
        child.select();
        assertEquals(child, tree.getSelectedItem());
        assertEquals(child, root.getTreeItems().get(0));
    }

    public void testExpandAndColapse() {
        // given
        MaterialTree tree = getWidget();
        MaterialTreeItem item1 = (MaterialTreeItem) tree.getWidget(0);
        MaterialTreeItem item2 = (MaterialTreeItem) tree.getWidget(1);
        for (int i = 1; i <= 3; i++) {
            item1.add(new MaterialTreeItem(TEXT));
            item2.add(new MaterialTreeItem(TEXT));
        }

        assertEquals(3, item1.getTreeItems().size());
        assertEquals(3, item2.getTreeItems().size());

        // when / then
        tree.expand();
        checkTreeItemVisibility(tree, true);

        tree.collapse();
        checkTreeItemVisibility(tree, false);
    }

    protected void checkTreeItemVisibility(MaterialWidget tree, boolean expand) {
        for (Widget widget : tree) {
            assertTrue(widget instanceof MaterialTreeItem);
            MaterialTreeItem item = (MaterialTreeItem) widget;
            if (expand) {
                assertTrue(item.isHide());
            } else {
                assertFalse(item.isHide());
            }
        }
    }

    public void testSelectedItem() {
        // given
        MaterialTree tree = getWidget();

        // when / then
        MaterialTreeItem item = (MaterialTreeItem) tree.getWidget(0);
        tree.setSelectedItem(item);
        assertEquals(item, tree.getSelectedItem());
    }

    public void testStructure() {
        // given
        MaterialTree tree = getWidget();

        // when / then
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
        // given
        MaterialTree tree = getWidget();

        // when / then
        for (int i = 0; i < NUMBER_OF_ITEM; i++) {
            MaterialTreeItem item = (MaterialTreeItem) tree.getWidget(i);
            MaterialWidget divHeader = (MaterialWidget) item.getWidget(0);
            // Check Url
            assertEquals(URL, item.getUrl());
            assertTrue(divHeader.getWidget(0) instanceof MaterialImage);
            MaterialImage image = (MaterialImage) divHeader.getWidget(0);
            assertEquals(URL, image.getUrl());
            assertTrue(image.getElement().hasAttribute("src"));

            // Check Icon
            assertTrue(divHeader.getWidget(1) instanceof MaterialIcon);
            MaterialIcon icon = (MaterialIcon) divHeader.getWidget(1);
            assertEquals(ICON, icon.getIconType());

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
        assertEquals(NUMBER_OF_ITEM, tree.getChildren().size());
    }

    public void testImageItems() {
        // given
        final String URL_OPEN = "open.png";
        final String URL_CLOSE = "close.png";
        MaterialTree tree = getWidget();

        // when / then
        tree.clear();
        assertEquals(0, tree.getWidgetCount());

        MaterialTreeItem item = new MaterialTreeItem();
        tree.add(item);
        assertEquals(1, tree.getWidgetCount());

        // Check Open
        tree.addOpenHandler(openEvent -> openEvent.getTarget().setUrl(URL_OPEN));
        OpenEvent.fire(tree, item);
        assertEquals(URL_OPEN, item.getImage().getUrl());

        // Check Close
        tree.addCloseHandler(closeEvent -> closeEvent.getTarget().setUrl(URL_CLOSE));
        CloseEvent.fire(tree, item);
        assertEquals(URL_CLOSE, item.getImage().getUrl());
    }
}
