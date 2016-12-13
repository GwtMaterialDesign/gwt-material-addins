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
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.tree.base.HasTreeItems;
import gwt.material.design.client.base.AbstractIconButton;
import gwt.material.design.client.base.HasImage;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.html.Span;

import java.util.ArrayList;
import java.util.List;

//@formatter:off

/**
 * MaterialTreeItem is a component that is needed by {@link MaterialTree}
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
 * &lt;-- Icon support -->
 * <ma:tree.MaterialTreeItem text="Folder 1" iconType="FOLDER" />
 * &lt;-- Image support -->
 * <ma:tree.MaterialTreeItem text="Item 2.1" resource="{res.batman.png}" />
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#treeview">Tree View</a>
 */
// @formatter:on
public class MaterialTreeItem extends AbstractIconButton implements HasImage, HasTreeItems {

    private MaterialWidget divHeader = new MaterialWidget(Document.get().createDivElement());

    private Span span;
    private MaterialImage image;

    private MaterialTree tree;
    private Object object;
    private HandlerRegistration clickRegistration;

    private boolean hide = true;
    private boolean initialized;

    public MaterialTreeItem() {
        super(AddinsCssName.TREE_ITEM);
        divHeader.setStyleName(AddinsCssName.TREE_HEADER);
        add(divHeader);
    }

    public MaterialTreeItem(String text) {
        this();
        setText(text);
    }

    public MaterialTreeItem(String text, IconType icon) {
        this(text);
        setIconType(icon);
    }

    public MaterialTreeItem(String text, ImageResource resource) {
        this(text);
        setResource(resource);
    }

    public MaterialTreeItem(String text, IconType icon, Color iconColor) {
        this(text, icon);
        setIconColor(iconColor);
    }

    @Override
    protected Element createElement() {
        return Document.get().createDivElement();
    }

    @Override
    public void setText(String text) {
        if (span == null) {
            span = new Span();
        }
        span.setText(text);
    }

    @Override
    public String getText() {
        return span.getText();
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        if(!initialized) {
            if(image != null) {
                divHeader.add(image);
            }
            divHeader.add(getIcon());
            divHeader.add(span);
            initialized = true;
        }

        if (clickRegistration != null) {
            clickRegistration.removeHandler();
        }
        clickRegistration = divHeader.addClickHandler(event -> select());
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        if (clickRegistration != null) {
            clickRegistration.removeHandler();
            clickRegistration = null;
        }
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

    public Span getSpan() {
        return span;
    }

    public MaterialImage getImage() {
        return image;
    }

    public void select() {
        // Fire selection event
        SelectionEvent.fire(getTree(), this);

        List<MaterialTreeItem> treeItems = getTreeItems();
        if (!treeItems.isEmpty()) {
            for (MaterialTreeItem treeItem : treeItems) {
                if (hide) {
                    treeItem.setVisible(false);
                } else {
                    treeItem.setVisible(true);
                }
            }
            // Firing of events based on the status of the tree item
            if (hide) {
                CloseEvent.fire(getTree(), this);
                hide = false;
            } else {
                OpenEvent.fire(getTree(), this);
                hide = true;
            }
        }
    }

    public List<MaterialTreeItem> getTreeItems() {
        List<MaterialTreeItem> treeItems = new ArrayList<>();
        for (Widget child : getChildren()) {
            if (child instanceof MaterialTreeItem) {
                treeItems.add((MaterialTreeItem) child);
            }
        }
        return treeItems;
    }

    @Override
    public MaterialTree getTree() {
        return tree;
    }

    protected void setTree(MaterialTree tree) {
        this.tree = tree;

        for (Widget child : getChildren()) {
            if (child instanceof MaterialTreeItem) {
                ((MaterialTreeItem) child).setTree(tree);
            }
        }
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
        for (MaterialTreeItem item : getTreeItems()) {
            item.setVisible(true);
        }
    }

    @Override
    public void collapse() {
        for (MaterialTreeItem item : getTreeItems()) {
            item.setVisible(false);
        }
    }

    @Override
    public void setHide(boolean hide) {
        this.hide = hide;
    }

    @Override
    public boolean isHide() {
        return hide;
    }

    @Override
    protected void add(Widget child, com.google.gwt.user.client.Element container) {
        super.add(child, container);
        if (child instanceof MaterialTreeItem) {
            ((MaterialTreeItem) child).setTree(getTree());
        }
    }

    @Override
    protected void insert(Widget child, com.google.gwt.user.client.Element container, int beforeIndex, boolean domInsert) {
        super.insert(child, container, beforeIndex, domInsert);
        if (child instanceof MaterialTreeItem) {
            ((MaterialTreeItem) child).setTree(getTree());
        }
    }

    @Override
    public void addItem(MaterialTreeItem item) {
        add(item);
        expand();
    }

    @Override
    public void removeItem(MaterialTreeItem item) {
        remove(item);
    }

    @Override
    public void removeItem(int index) {
        remove(getWidget(index));
    }

    @Override
    public void insertItem(MaterialTreeItem item, int index) {
        insert(item, index);
        expand();
    }

    @Override
    public void removeFromTree() {
        removeFromParent();
    }

    @Override
    public void removeFromParent() {
        tree = null;
        super.removeFromParent();
    }
}
