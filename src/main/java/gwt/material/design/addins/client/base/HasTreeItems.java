package gwt.material.design.addins.client.base;

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

import gwt.material.design.addins.client.ui.MaterialTree;
import gwt.material.design.addins.client.ui.MaterialTreeItem;

import java.util.List;

/**
 * @author kevzlou7979
 */
public interface HasTreeItems {

    /**
     * Initialize the tree item component
     */
    void initTreeItem();

    /**
     * Set the parent tree item
     * @param parentTree
     */
    void setParentTree(MaterialTreeItem parentTree);

    /**
     * Get the parent tree item
     * @return
     */
    MaterialTreeItem getParentTree();

    /**
     * Set the tree for initialization of tree handlers (open , close , selection etc.)
     * @param parentTree
     */
    void setTree(MaterialTree parentTree);

    /**
     * Get the tree component
     * @return
     */
    MaterialTree getTree();

    /**
     * Set the tree items of the current item
     * @param treeItems
     */
    void setTreeItems(List<MaterialTreeItem> treeItems);

    /**
     * Get all the tree items of the current item
     * @return
     */
    List<MaterialTreeItem> getTreeItems();

    /**
     * Set tbe object data for tree item
     * @param object
     */
    void setObject(Object object);

    /**
     * Get the object data
     * @return
     */
    Object getObject();

    /**
     * Expand the tree item's content
     */
    void expand();

    /**
     * Collapse the tree item's content
     */
    void collapse();

    /**
     * Set the value of hide variable (boolean)
     * @param hide
     */
    void setHide(boolean hide);

    /**
     * Gets the value of hide variable (boolean)
     * @return
     */
    boolean isHide();
}
