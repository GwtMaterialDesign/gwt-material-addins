package gwt.material.design.addins.client.tree;

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
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.client.base.MaterialWidget;

//@formatter:off

/**
 * MaterialTree is a component that wraps all the tree items that provide lists of
 * event handlers like open/close and selection event.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 *
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
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#treeview">Tree View</a>
 */
// @formatter:on
public class MaterialTree extends MaterialWidget implements HasCloseHandlers<MaterialTreeItem>, HasOpenHandlers<MaterialTreeItem>, HasSelectionHandlers<MaterialTreeItem> {


    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectCss(MaterialTreeDebugClientBundle.INSTANCE.treeCssDebug());
        } else {
            MaterialResourceInjector.injectCss(MaterialTreeClientBundle.INSTANCE.treeCss());
        }
    }

    private MaterialTreeItem selectedTree;

    public MaterialTree() {
        super(Document.get().createDivElement(), "tree");
    }

    private void initSelectionEvent() {
        // Add selection event
        addSelectionHandler(new SelectionHandler<MaterialTreeItem>() {
            @Override
            public void onSelection(SelectionEvent<MaterialTreeItem> event) {
                for(Widget item : getChildren()){
                    if(item instanceof MaterialTreeItem){
                        clearItemSelectedStyles((MaterialTreeItem) item);
                    }
                }
                MaterialTreeItem treeItem = event.getSelectedItem();
                treeItem.addStyleName("selected");
                setSelectedTree(treeItem);
            }
        });
    }

    @Override
    public void add(Widget child) {
        if(child instanceof MaterialTreeItem){
            super.add(child);
        }else{
            GWT.log("Material Tree must contain on Material Tree Items");
        }
    }


    @Override
    protected void onLoad() {
        super.onLoad();
        for(Widget w : getChildren()){
            if(w instanceof MaterialTreeItem){
                initTree((MaterialTreeItem) w);
            }
        }
    }

    // Recursive function to set the parent of tree item
    public void initTree(MaterialTreeItem item) {
        item.setTree(this);
        for(MaterialTreeItem treeItem : item.getTreeItems()){
            initTree(treeItem);
        }
        initSelectionEvent();
    }

    private void clearItemSelectedStyles(MaterialTreeItem item) {
        item.removeStyleName("selected");
        for(MaterialTreeItem treeItem : item.getTreeItems()){
            clearItemSelectedStyles(treeItem);
        }
    }

    @Override
    public HandlerRegistration addCloseHandler(final CloseHandler<MaterialTreeItem> handler) {
        return addHandler(new CloseHandler<MaterialTreeItem>() {
            @Override
            public void onClose(CloseEvent<MaterialTreeItem> event) {
                if(isEnabled()){
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
                if(isEnabled()){
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
                if(isEnabled()){
                    handler.onSelection(event);
                }
            }
        }, SelectionEvent.getType());
    }

    public MaterialTreeItem getSelectedTree() {
        return selectedTree;
    }

    public void setSelectedTree(MaterialTreeItem selectedTree) {
        this.selectedTree = selectedTree;
    }


    /**
     * Expand all tree item's content
     */
    public void expand() {
        for(Widget w : getChildren()){
            if(w instanceof MaterialTreeItem){
                expandItems((MaterialTreeItem) w);
            }
        }
    }

    /**
     * Recursive function to expand each tree item
     * @param item
     */
    private void expandItems(MaterialTreeItem item) {
        item.expand();
        item.setHide(true);
        for(MaterialTreeItem t : item.getTreeItems()){
            expandItems(t);
        }
    }

    /**
     * Collapse all tree item's content
     */
    public void collapse() {
        for(Widget w : getChildren()){
            if(w instanceof MaterialTreeItem){
                collapseItems((MaterialTreeItem)w);
            }
        }
    }

    /**
     * Recursive function to collapse each tree item
     * @param item
     */
    private void collapseItems(MaterialTreeItem item) {
        item.collapse();
        item.setHide(false);
        for(MaterialTreeItem t : item.getTreeItems()){
            collapseItems(t);
        }
    }
}

