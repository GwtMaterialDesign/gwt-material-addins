package gwt.material.design.addins.client.tree.base.mixin;

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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.stepper.base.mixin.AbstractMixin;
import gwt.material.design.addins.client.tree.base.HasTreeItems;
import gwt.material.design.addins.client.tree.MaterialTree;
import gwt.material.design.addins.client.tree.MaterialTreeItem;
import gwt.material.design.client.base.HasFontSize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevzlou7979
 */
public class TreeItemMixin<T extends Widget & HasFontSize> extends AbstractMixin<T> implements HasTreeItems {

    private boolean hide = true;
    private List<MaterialTreeItem> treeItems = new ArrayList<>();
    private MaterialTree tree;
    private MaterialTreeItem parentTree;
    private Object object;
    public TreeItemMixin(final T widget) {
        super(widget);
    }


    @Override
    public void initTreeItem() {
        MaterialTreeItem item = (MaterialTreeItem) uiObject;
        // Fire selection event
        SelectionEvent.fire(getTree(), item);
        if(!getTreeItems().isEmpty()) {
            for (MaterialTreeItem treeItem : getTreeItems()) {
                if (hide) {
                    treeItem.setVisible(false);
                } else {
                    treeItem.setVisible(true);
                }
            }
            // Firing of events based on the status of the tree item
            if (hide) {
                CloseEvent.fire(getTree(), item);
                hide = false;
            } else {
                OpenEvent.fire(getTree(), item);
                hide = true;
            }
        }
    }

    @Override
    public void setParentTree(MaterialTreeItem parentTree) {
        this.parentTree = parentTree;
    }

    @Override
    public MaterialTreeItem getParentTree() {
        return parentTree;
    }

    @Override
    public void setTree(MaterialTree tree) {
        this.tree = tree;
    }

    @Override
    public MaterialTree getTree() {
        return tree;
    }

    @Override
    public void setTreeItems(List<MaterialTreeItem> treeItems) {
        this.treeItems = treeItems;
    }

    @Override
    public List<MaterialTreeItem> getTreeItems() {
        return treeItems;
    }

    @Override
    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object getObject() {
        return object;
    }

    @Override
    public void expand() {
        for(MaterialTreeItem item : getTreeItems()){
            item.setVisible(true);
        }
    }

    @Override
    public void collapse() {
        for(MaterialTreeItem item : getTreeItems()){
            item.setVisible(false);
        }
    }

    public boolean isHide() {
        return hide;
    }

    @Override
    public void addItem(MaterialTreeItem item) {
        getMaterialTreeItem().add(item);
        getMaterialTreeItem().expand();
        getMaterialTreeItem().getTree().initTree(getMaterialTreeItem());
    }

    @Override
    public void removeItem(MaterialTreeItem item) {
        getMaterialTreeItem().remove(item);
        getMaterialTreeItem().getTree().initTree(getMaterialTreeItem());
    }

    @Override
    public void removeItem(int index) {
        getMaterialTreeItem().remove(getMaterialTreeItem().getWidget(index));
        getMaterialTreeItem().getTree().initTree(getMaterialTreeItem());
    }

    @Override
    public void insertItem(MaterialTreeItem item, int index) {
        getMaterialTreeItem().insert(item, index);
        getMaterialTreeItem().expand();
        getMaterialTreeItem().getTree().initTree(getMaterialTreeItem());
    }

    @Override
    public void removeFromTree() {
        getMaterialTreeItem().removeFromParent();
        getMaterialTreeItem().getTree().initTree(getMaterialTreeItem());
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    protected MaterialTreeItem getMaterialTreeItem(){
        if(uiObject instanceof MaterialTreeItem){
            return (MaterialTreeItem)uiObject;
        }else{
            GWT.log("Widget is not instanceof MaterialTreeItem");
            return null;
        }
    }
}
