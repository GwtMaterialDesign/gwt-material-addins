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
package gwt.material.design.addins.client.masonry;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.masonry.js.JsMasonryOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasDurationTransition;
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
 */
//@formatter:on
public class MaterialMasonry extends MaterialRow implements HasDurationTransition {

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
    private boolean percentPosition = true;
    private boolean originLeft = true;
    private boolean originTop = true;
    private int duration = 400;
    private boolean initialize;

    private MaterialWidget sizerDiv = new MaterialWidget(Document.get().createDivElement());

    public MaterialMasonry() {
        super(Document.get().createDivElement(), AddinsCssName.MASONRY, CssName.ROW);
        enableFeature(Feature.ONLOAD_ADD_QUEUE, true);
        sizerDiv.setWidth("8.3333%");
        sizerDiv.setStyleName(AddinsCssName.COL_SIZER);
        add(sizerDiv);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initMasonry();

        if (!initialize) {
            initialize = true;
        }
    }

    public void initMasonry() {
        initMasonryJs(getElement());
    }

    protected void initMasonryJs(Element e) {
        window().ready(() -> $(e).imagesLoaded(() -> $(e).masonry(getMasonryOptions())));
    }

    protected JsMasonryOptions getMasonryOptions() {
        JsMasonryOptions options = new JsMasonryOptions();
        options.itemSelector = ".masonry > " + getItemSelector();
        options.percentPosition = isPercentPosition();
        options.columnWidth = "." + AddinsCssName.COL_SIZER;
        options.originLeft = isOriginLeft();
        options.originTop = isOriginTop();
        options.transitionDuration = getDuration() + "ms";
        return options;
    }

    @Override
    public boolean remove(IsWidget child) {
        Widget widget = (Widget) child;
        remove(widget.getElement());

        if (initialize) {
            initMasonry();
        }
        return true;
    }

    @Override
    public boolean remove(Widget w) {
        return this.remove((IsWidget) w);
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
        if (initialize) {
            $(getElement()).masonry(getMasonryOptions()).masonry("remove", e).masonry("layout");
        }
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
     * Reload the layout effective only when adding and inserting items
     */
    public void reload() {
        if (initialize) {
            reloadItems();
            layout();
        }
    }

    /**
     * Reload all items inside the masonry
     */
    public void reloadItems() {
        $(getElement()).masonry(getMasonryOptions()).masonry("reloadItems");
    }

    /**
     * Layout remaining item elements
     */
    public void layout() {
        $(getElement()).masonry(getMasonryOptions()).masonry("layout");
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
        return percentPosition;
    }

    /**
     * Sets item positions in percent values, rather than pixel values. percentPosition: true works
     * well with percent-width items, as items will not transition their position on resize.
     */
    public void setPercentPosition(boolean percentPosition) {
        this.percentPosition = percentPosition;
    }

    /**
     * Get the boolean value of origin left.
     */
    public boolean isOriginLeft() {
        return originLeft;
    }

    /**
     * Controls the horizontal flow of the layout. By default, item elements start positioning at the
     * left, with originLeft: true. Set originLeft: false for right-to-left layouts.
     */
    public void setOriginLeft(boolean originLeft) {
        this.originLeft = originLeft;
    }

    /**
     * Get the boolean value of origin top.
     */
    public boolean isOriginTop() {
        return originTop;
    }

    /**
     * Controls the vertical flow of the layout. By default, item elements start positioning at the top,
     * with originTop: true. Set originTop: false for bottom-up layouts. It’s like Tetris
     */
    public void setOriginTop(boolean originTop) {
        this.originTop = originTop;
    }

    public MaterialWidget getSizerDiv() {
        return sizerDiv;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }
}