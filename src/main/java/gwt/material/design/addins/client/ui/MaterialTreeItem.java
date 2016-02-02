package gwt.material.design.addins.client.ui;

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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.HasTreeItems;
import gwt.material.design.addins.client.base.mixin.TreeItemMixin;
import gwt.material.design.client.base.AbstractIconButton;
import gwt.material.design.client.base.HasImage;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.html.Span;

import java.util.List;

//@formatter:off

/**
 * MaterialTreeItem is a component that is needed by {@link gwt.material.design.addins.client.ui.MaterialTree}
 *
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:m.addins='urn:import:gwt.material.design.addins.client.ui'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 *
 * <pre>
 * {@code
 * &lt;-- Icon support -->
 * <m.addins:MaterialTreeItem text="Folder 1" iconType="FOLDER" />
 * &lt;-- Image support -->
 * <m.addins:MaterialTreeItem text="Item 2.1" resource="{res.batman.png}" />
 * }
 * </pre>
 *
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#treeview">Tree View</a>
 */
// @formatter:on
public class MaterialTreeItem extends AbstractIconButton implements HasImage, HasTreeItems {

    private MaterialWidget divHeader = new MaterialWidget(Document.get().createDivElement());
    private Span span;
    private MaterialImage image;
    private final TreeItemMixin<MaterialTreeItem> treeItemMixin = new TreeItemMixin<>(this);

    public MaterialTreeItem() {
        TreeItem i;
        setStyleName("tree-item");
        divHeader.setStyleName("tree-header");
        add(divHeader);
    }

    @Override
    protected Element createElement() {
        return Document.get().createDivElement();
    }

    @Override
    public void setText(String text) {
        span = new Span();
        span.setText(text);
    }

    @Override
    public String getText() {
        return span.getText();
    }

    @Override
    public void add(Widget child) {
        super.add(child);
        if(child instanceof MaterialTreeItem){
            treeItemMixin.getTreeItems().add((MaterialTreeItem) child);
        }
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if(image != null){
            divHeader.add(image);
        }
        divHeader.add(getIcon());
        divHeader.add(span);
        divHeader.addDomHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                initTreeItem();
            }
        }, ClickEvent.getType());
    }

    @Override
    public void setUrl(String url) {
        image = new MaterialImage();
        image.setUrl(url);
    }

    @Override
    public String getUrl() {
        return image.getUrl();
    }

    @Override
    public void setResource(ImageResource resource) {
        image = new MaterialImage();
        image.setResource(resource);
        add(image);
    }

    @Override
    public ImageResource getResource() {
        return image.getResource();
    }

    public MaterialWidget getDivHeader() {
        return divHeader;
    }

    public void setDivHeader(MaterialWidget divHeader) {
        this.divHeader = divHeader;
    }

    @Override
    public void initTreeItem() {
        treeItemMixin.initTreeItem();
    }

    @Override
    public void setParentTree(MaterialTreeItem parentTree) {
        treeItemMixin.setParentTree(parentTree);
    }

    @Override
    public MaterialTreeItem getParentTree() {
        return treeItemMixin.getParentTree();
    }

    @Override
    public void setTree(MaterialTree parentTree) {
        treeItemMixin.setTree(parentTree);
    }

    @Override
    public MaterialTree getTree() {
        return treeItemMixin.getTree();
    }

    @Override
    public void setTreeItems(List<MaterialTreeItem> treeItems) {
        treeItemMixin.setTreeItems(treeItems);
    }

    @Override
    public List<MaterialTreeItem> getTreeItems() {
        return treeItemMixin.getTreeItems();
    }

    @Override
    public void setObject(Object object) {
        treeItemMixin.setObject(object);
    }

    @Override
    public Object getObject() {
        return treeItemMixin.getObject();
    }

    @Override
    public void expand() {
        treeItemMixin.expand();
    }

    @Override
    public void collapse() {
        treeItemMixin.collapse();
    }

    @Override
    public void setHide(boolean hide) {
        treeItemMixin.setHide(hide);
    }

    @Override
    public boolean isHide() {
        return treeItemMixin.isHide();
    }

}
