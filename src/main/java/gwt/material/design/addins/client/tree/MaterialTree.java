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
package gwt.material.design.addins.client.tree;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;

//@formatter:off

/**
 * MaterialTree is a component that wraps all the tree items that provide lists of
 * event handlers like open/close and selection event.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 * <ma:tree.MaterialTree>
 *     <ma:tree.MaterialTreeItem text="Folder 1" iconType="FOLDER" />
 *     <ma:tree.MaterialTreeItem text="Folder 2" iconType="FOLDER">
 *         &lt;-- Image support -->
 *         <ma:tree.MaterialTreeItem text="Item 2.1" resource="{res.batman.png}" />
 *         <ma:tree.MaterialTreeItem text="Item 2.2" resource="{res.superman.png}" />
 *         <ma:tree.MaterialTreeItem text="Item 2.3" resource="{res.spiderman.png}" />
 *     </ma:tree.MaterialTreeItem>
 *     <ma:tree.MaterialTreeItem text="Folder 3" iconType="FOLDER" />
 * </ma:tree.MaterialTree>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @author Ben Dol
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#treeview">Tree View</a>
 */
// @formatter:on
public class MaterialTree extends MaterialWidget implements HasCloseHandlers<MaterialTreeItem>,
        HasOpenHandlers<MaterialTreeItem>, HasSelectionHandlers<MaterialTreeItem> {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialTreeDebugClientBundle.INSTANCE.treeCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialTreeClientBundle.INSTANCE.treeCss());
        }
    }

    private MaterialTreeItem selectedItem;
    private HandlerRegistration selectionHandler;

    public MaterialTree() {
        super(Document.get().createDivElement(), AddinsCssName.TREE);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // Ensure all children know we are the root.
        for (Widget child : getChildren()) {
            if (child instanceof MaterialTreeItem) {
                ((MaterialTreeItem) child).setTree(this);
            }
        }

        // Add selection event
        if (selectionHandler != null) {
            selectionHandler.removeHandler();
        }
        selectionHandler = addSelectionHandler(event -> {
            for (Widget item : getChildren()) {
                if (item instanceof MaterialTreeItem) {
                    clearSelectedStyles((MaterialTreeItem) item);
                }
            }
            MaterialTreeItem treeItem = event.getSelectedItem();
            treeItem.addStyleName(AddinsCssName.SELECTED);
            setSelectedItem(treeItem);
        });
    }

    @Override
    protected void add(Widget child, com.google.gwt.user.client.Element container) {
        if (child instanceof MaterialTreeItem) {
            super.add(child, container);
            ((MaterialTreeItem) child).setTree(this);
        } else {
            throw new IllegalArgumentException("MaterialTree can only contain MaterialTreeItem");
        }
    }

    @Override
    protected void insert(Widget child, com.google.gwt.user.client.Element container, int beforeIndex, boolean domInsert) {
        if (child instanceof MaterialTreeItem) {
            super.insert(child, container, beforeIndex, domInsert);
            ((MaterialTreeItem) child).setTree(this);
        } else {
            throw new IllegalArgumentException("MaterialTree can only contain MaterialTreeItem");
        }
    }

    protected void clearSelectedStyles(MaterialTreeItem item) {
        item.removeStyleName(AddinsCssName.SELECTED);

        for (MaterialTreeItem treeItem : item.getTreeItems()) {
            clearSelectedStyles(treeItem);
        }
    }

    @Override
    public HandlerRegistration addCloseHandler(final CloseHandler<MaterialTreeItem> handler) {
        return addHandler(new CloseHandler<MaterialTreeItem>() {
            @Override
            public void onClose(CloseEvent<MaterialTreeItem> event) {
                if (isEnabled()) {
                    handler.onClose(event);
                }
            }
        }, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(final OpenHandler<MaterialTreeItem> handler) {
        return addHandler(new OpenHandler<MaterialTreeItem>() {
            @Override
            public void onOpen(OpenEvent<MaterialTreeItem> event) {
                if (isEnabled()) {
                    handler.onOpen(event);
                }
            }
        }, OpenEvent.getType());
    }

    @Override
    public HandlerRegistration addSelectionHandler(final SelectionHandler<MaterialTreeItem> handler) {
        return addHandler(new SelectionHandler<MaterialTreeItem>() {
            @Override
            public void onSelection(SelectionEvent<MaterialTreeItem> event) {
                if (isEnabled()) {
                    handler.onSelection(event);
                }
            }
        }, SelectionEvent.getType());
    }

    public MaterialTreeItem getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(MaterialTreeItem selectedItem) {
        this.selectedItem = selectedItem;
    }

    /**
     * Expand all tree item's content
     */
    public void expand() {
        for (Widget w : getChildren()) {
            if (w instanceof MaterialTreeItem) {
                expandItems((MaterialTreeItem) w);
            }
        }
    }

    /**
     * Recursive function to expand each tree item.
     */
    protected void expandItems(MaterialTreeItem item) {
        item.expand();
        item.setHide(true);
        item.getTreeItems().forEach(this::expandItems);
    }

    /**
     * Collapse all tree item's content
     */
    public void collapse() {
        for (Widget w : getChildren()) {
            if (w instanceof MaterialTreeItem) {
                collapseItems((MaterialTreeItem) w);
            }
        }
    }

    /**
     * Deselect selected tree item
     */
    public void deselectSelectedItem() {
        // Check whether tree has selected item
        if (selectedItem != null) {
            clearSelectedStyles(selectedItem);
            setSelectedItem(null);
            SelectionEvent.fire(this, null);
        }
    }

    /**
     * Recursive function to collapse each tree item.
     */
    protected void collapseItems(MaterialTreeItem item) {
        item.collapse();
        item.setHide(false);

        item.getTreeItems().forEach(this::collapseItems);
    }
}