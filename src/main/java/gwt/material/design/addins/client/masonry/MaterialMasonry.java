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
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.addins.client.masonry.events.HasMasonryHandler;
import gwt.material.design.addins.client.masonry.events.LayoutCompleteEvent;
import gwt.material.design.addins.client.masonry.events.MasonryEvents;
import gwt.material.design.addins.client.masonry.events.RemoveCompleteEvent;
import gwt.material.design.addins.client.masonry.js.JsMasonry;
import gwt.material.design.addins.client.masonry.js.JsMasonryOptions;
import gwt.material.design.client.base.HasDurationTransition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialRow;

import java.util.Arrays;
import java.util.List;

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
public class MaterialMasonry extends MaterialRow implements HasDependency, HasDurationTransition, HasMasonryHandler {

    protected DependencyMixin<HasDependency> dependencyMixin;
    private MaterialWidget sizerDiv = new MaterialWidget(Document.get().createDivElement());
    private JsMasonryOptions options = JsMasonryOptions.create();
    private JsMasonry masonryElement;
    private Widget target;

    public MaterialMasonry() {
        super(Document.get().createDivElement(), AddinsCssName.MASONRY, CssName.ROW);

        sizerDiv.setWidth("8.3333%");
        sizerDiv.setStyleName(AddinsCssName.COL_SIZER);
        add(sizerDiv);
    }

    @Override
    protected void onLoad() {
        getDependencyMixin().install(() -> {
            internalLoad();
            super.onLoad();
        });
    }

    protected void internalLoad() {
        masonryElement = $(getElement());
        masonryElement.imagesLoaded(() -> masonryElement.masonry(options));

        masonryElement.on(MasonryEvents.REMOVE_COMPLETE, (e, param1) -> {
            RemoveCompleteEvent.fire(this, target);
            return true;
        });

        masonryElement.on(MasonryEvents.LAYOUT_COMPLETE, (e, param1) -> {
            LayoutCompleteEvent.fire(this);
            return true;
        });
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    public void unload() {
        if (masonryElement != null) {
            masonryElement.masonry("destroy");
            masonryElement.off(MasonryEvents.REMOVE_COMPLETE);
            masonryElement.off(MasonryEvents.LAYOUT_COMPLETE);
        }
    }

    public void reload() {
        if (masonryElement != null) {
            layout();
            reloadItems();
        }
    }

    @Override
    public boolean remove(Widget w) {
        return remove((IsWidget) w);
    }

    @Override
    public boolean remove(int index) {
        return remove(getWidget(index));
    }

    @Override
    public boolean remove(IsWidget child) {
        masonryRemove((Widget) child);
        return true;
    }

    /**
     * Remove the item with Masonry support
     */
    protected void masonryRemove(Widget target) {
        this.target = target;
        if (target != sizerDiv) {
            super.remove(target);
            reload();
        }
    }

    @Override
    public void clear() {
        for (Widget w : getChildrenList()) {
            if (w != sizerDiv) {
                masonryRemove(w);
            }
        }
        reload();
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
    protected void reloadItems() {
        masonryElement.masonry(options).masonry("reloadItems");
    }

    /**
     * Layout remaining item elements
     */
    protected void layout() {
        masonryElement.masonry(options).masonry("layout");
    }

    /**
     * Get the item selector.
     */
    public String getItemSelector() {
        return options.itemSelector;
    }

    /**
     * Specifies which child elements will be used as item elements in the
     * layout.It's .col by default for grid components.
     */
    public void setItemSelector(String itemSelector) {
        options.itemSelector = itemSelector;
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

    /**
     * Adds horizontal space between item elements.
     * Note: To set vertical space between elements, use margin-bottom CSS.
     * i.e
     * <pre>
     * .grid-item {
     *   margin-bottom: 10px;
     * }
     * </pre>
     */
    public void setGutter(int gutter) {
        options.gutter = gutter;
    }

    public int getGutter() {
        return options.gutter;
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

    public boolean isHorizontalOrder() {
        return options.horizontalOrder;
    }

    /**
     * Lays out items to (mostly) maintain horizontal left-to-right order.
     */
    public void setHorizontalOrder(boolean horizontalOrder) {
        options.horizontalOrder = horizontalOrder;
    }

    public String getStamp() {
        return options.stamp;
    }

    /**
     * Specifies which elements are stamped within the layout. Masonry will layout items below stamped elements.
     *
     * The stamp option stamps elements only when the Masonry instance is first initialized. You can stamp additional
     * elements afterwards with the stamp method.
     */
    public void setStamp(String stamp) {
        options.stamp = stamp;
    }

    public boolean isFitWidth() {
        return options.fitWidth;
    }

    /**
     * Sets the width of the container to fit the available number of columns, based the size of container's parent element.
     * When enabled, you can center the container with CSS.
     * <br/><br/>
     * Note: <b>fitWidth: true</b> does not work with element sizing with percentage width. Either columnWidth needs to be set
     * to a fixed size, like <b>columnWidth: 120</b>, or items need to have a fixed size in pixels, like <b>width: 120px</b>. Otherwise,
     * the container and item widths will collapse on one another.
     */
    public void setFitWidth(boolean fitWidth) {
        options.fitWidth = fitWidth;
    }

    public int getStagger() {
        return options.stagger;
    }

    /**
     * Staggers item transitions, so items transition incrementally after one another. Set as a CSS time format,
     * <b>'0.03s'</b>, or as a number in milliseconds, <b>30</b>.
     */
    public void setStagger(int stagger) {
        options.stagger = stagger;
    }

    public boolean isResize() {
        return options.resize;
    }

    /**
     * Adjusts sizes and positions when window is resized. Enabled by default resize: true.
     */
    public void setResize(boolean resize) {
        options.resize = resize;
    }

    public boolean isInitLayout() {
        return options.initLayout;
    }

    /**
     * Enables layout on initialization. Enabled by default initLayout: true.
     *
     * Set initLayout: false to disable layout on initialization, so you can use methods or add events before the initial layout.
     */
    public void setInitLayout(boolean initLayout) {
        options.initLayout = initLayout;
    }

    public String getTransitionDuration() {
        return options.transitionDuration;
    }

    /**
     * Duration of the transition when items change position or appearance, set in a CSS time format. Default: transitionDuration: '0.4s'
     */
    public void setTransitionDuration(String transitionDuration) {
        options.transitionDuration = transitionDuration;
    }

    public DependencyMixin<HasDependency> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }

    @Override
    public HandlerRegistration addLayoutCompleteHandler(LayoutCompleteEvent.LayoutCompleteHandler handler) {
        return addHandler(handler, LayoutCompleteEvent.TYPE);
    }

    @Override
    public HandlerRegistration addRemoveCompleteHandler(RemoveCompleteEvent.RemoveCompleteHandler handler) {
        return addHandler(handler, RemoveCompleteEvent.TYPE);
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Arrays.asList(new DependencyResource(MaterialMasonryClientBundle.INSTANCE.masonryJs(), MaterialMasonryDebugClientBundle.INSTANCE.masonryJsDebug()),
                new DependencyResource(MaterialMasonryClientBundle.INSTANCE.imageLoadedJs(), MaterialMasonryDebugClientBundle.INSTANCE.imageLoadedJsDebug()));
    }
}
