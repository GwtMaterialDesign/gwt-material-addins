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
package gwt.material.design.addins.client.masonry;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.masonry.js.JsMasonry;
import gwt.material.design.addins.client.masonry.js.JsMasonryOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasDurationTransition;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialRow;

import static gwt.material.design.addins.client.masonry.js.JsMasonry.$;

//@formatter:off

/**
 * Masonry works by placing elements in optimal position based on available vertical space, sort of like a mason fitting stones in a wall.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:m.addins='urn:import:gwt.material.design.addins.client.ui'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {
 * @code
 * <m.addins:MaterialMasonry>
 *     <m:MaterialColumn grid="l1" padding="4" backgroundColor="blue" height="200px">
 *         <m:MaterialLabel text="1"/>
 *     </m:MaterialColumn>
 *     &lt;-- Other columns here -->
 * </m.addins:MaterialMasonry>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#masonry">Material Masonry</a>
 * @see <a href="https://github.com/desandro/masonry">Masonry 4.0.0</a>
 */
//@formatter:on
public class MaterialMasonry extends MaterialRow implements JsLoader, HasDurationTransition {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialMasonryDebugClientBundle.INSTANCE.masonryJsDebug());
            MaterialDesignBase.injectDebugJs(MaterialMasonryDebugClientBundle.INSTANCE.imageLoadedJsDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialMasonryClientBundle.INSTANCE.masonryJs());
            MaterialDesignBase.injectJs(MaterialMasonryClientBundle.INSTANCE.imageLoadedJs());
        }
    }

    private String itemSelector = ".col";
    private MaterialWidget sizerDiv = new MaterialWidget(Document.get().createDivElement());
    private JsMasonryOptions options = new JsMasonryOptions();

    public MaterialMasonry() {
        super(Document.get().createDivElement(), AddinsCssName.MASONRY, CssName.ROW);

        sizerDiv.setWidth("8.3333%");
        sizerDiv.setStyleName(AddinsCssName.COL_SIZER);
        add(sizerDiv);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        JsMasonry element = $(getElement());
        options.itemSelector = ".masonry > " + getItemSelector();
        options.columnWidth = "." + AddinsCssName.COL_SIZER;
        window().ready(() -> element.imagesLoaded(() -> element.masonry(options)));
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        $(getElement()).masonry("destroy");
    }

    @Override
    public void reload() {
        reloadItems();
        layout();
    }

    @Override
    public boolean remove(IsWidget child) {
        Widget widget = (Widget) child;
        remove(widget.getElement());
        reload();
        return true;
    }

    @Override
    public boolean remove(Widget w) {
        return remove((IsWidget) w);
    }

    @Override
    public boolean remove(int index) {
        remove(getWidget(index).getElement());
        return true;
    }

    /**
     * Remove the item with Masonry support
     */
    protected void remove(Element e) {
        $(getElement()).masonry(options).masonry("remove", e).masonry("layout");
    }

    @Override
    public void clear() {
        for (Widget widget : getChildren()) {
            remove(widget.getElement());
        }
    }

    @Override
    public void add(Widget child) {
        super.add(child);
        reload();
    }

    @Override
    protected void add(Widget child, com.google.gwt.user.client.Element container) {
        super.add(child, container);
        reload();
    }

    @Override
    protected void insert(Widget child, com.google.gwt.user.client.Element container, int beforeIndex, boolean domInsert) {
        super.insert(child, container, beforeIndex, domInsert);
        reload();
    }

    @Override
    public void insert(Widget child, int beforeIndex) {
        super.insert(child, beforeIndex);
        reload();
    }

    /**
     * Reload all items inside the masonry
     */
    public void reloadItems() {
        $(getElement()).masonry(options).masonry("reloadItems");
    }

    /**
     * Layout remaining item elements
     */
    public void layout() {
        $(getElement()).masonry(options).masonry("layout");
    }

    /**
     * Get the item selector.
     */
    public String getItemSelector() {
        return itemSelector;
    }

    /**
     * Specifies which child elements will be used as item elements in the
     * layout.It's .col by default for grid components.
     */
    public void setItemSelector(String itemSelector) {
        this.itemSelector = itemSelector;
    }

    /**
     * Get the percent position boolean value.
     */
    public boolean isPercentPosition() {
        return options.percentPosition;
    }

    /**
     * Sets item positions in percent values, rather than pixel values. percentPosition: true works
     * well with percent-width items, as items will not transition their position on resize.
     */
    public void setPercentPosition(boolean percentPosition) {
        options.percentPosition = percentPosition;
    }

    /**
     * Get the boolean value of origin left.
     */
    public boolean isOriginLeft() {
        return options.originLeft;
    }

    /**
     * Controls the horizontal flow of the layout. By default, item elements start positioning at the
     * left, with originLeft: true. Set originLeft: false for right-to-left layouts.
     */
    public void setOriginLeft(boolean originLeft) {
        options.originLeft = originLeft;
    }

    /**
     * Get the boolean value of origin top.
     */
    public boolean isOriginTop() {
        return options.originTop;
    }

    /**
     * Controls the vertical flow of the layout. By default, item elements start positioning at the top,
     * with originTop: true. Set originTop: false for bottom-up layouts. It’s like Tetris
     */
    public void setOriginTop(boolean originTop) {
        options.originTop = originTop;
    }

    public MaterialWidget getSizerDiv() {
        return sizerDiv;
    }

    @Override
    public void setDuration(int duration) {
        options.transitionDuration = duration + "ms";
    }

    @Override
    public int getDuration() {
        return options.transitionDuration != null ? Integer.parseInt(options.transitionDuration.replace("ms", "")) : 0;
    }
}