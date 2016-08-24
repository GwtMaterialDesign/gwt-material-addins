package gwt.material.design.addins.client.tree.base;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import gwt.material.design.addins.client.tree.MaterialTree;
import gwt.material.design.addins.client.tree.MaterialTreeItem;

import java.util.List;

/**
 * @author kevzlou7979
 */
public interface HasTreeItems {

    /**
     * Get the tree component.
     */
    MaterialTree getTree();

    /**
     * Get all the tree items of the current item.
     */
    List<MaterialTreeItem> getTreeItems();

    /**
     * Set tbe object data for tree item.
     */
    void setObject(Object object);

    /**
     * Get the object data.
     */
    Object getObject();

    /**
     * Expand the tree item's content.
     */
    void expand();

    /**
     * Collapse the tree item's content.
     */
    void collapse();

    /**
     * Set the value of hide variable (boolean).
     */
    void setHide(boolean hide);

    /**
     * Gets the value of hide variable (boolean).
     */
    boolean isHide();

    /**
     * Adds item into it's parent tree item.
     */
    void addItem(MaterialTreeItem item);

    /**
     * Removes a given material tree item.
     */
    void removeItem(MaterialTreeItem item);

    /**
     * Removes a given material item with given index.
     */
    void removeItem(int index);

    /**
     * Inserts an item with given index.
     */
    void insertItem(MaterialTreeItem item, int index);

    /**
     * Removes this tree item to it's parent tree node.
     */
    void removeFromTree();
}
