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

import com.google.gwt.dom.client.Element;
import gwt.material.design.client.ui.MaterialRow;

//@formatter:off

/**
 * Masonry works by placing elements in optimal position based on available vertical space, sort of like a mason fitting stones in a wall.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:m.addins='urn:import:gwt.material.design.addins.client.ui'
 * }
 * </pre>
 *
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
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#masonry">Material Masonry</a>
 * @author kevzlou7979
 */
//@formatter:on
public class MaterialMasonry extends MaterialRow {

    private String itemSelector = ".col";
    private boolean percentPosition = true;
    private boolean originLeft = true;
    private boolean originTop = true;
    private double transitionDuration;

    public MaterialMasonry() {}

    @Override
    protected void onLoad() {
        super.onLoad();
        initMasonry();
    }

    private void initMasonry() {
        initMasonry(getElement());
    }

    /**
     * Initialize the masonry component
     * @param e
     */
    private native void initMasonry(Element e) /*-{
        var that = this;
        var grid = $wnd.jQuery(e).masonry({
            // options...
            itemSelector: that.@gwt.material.design.addins.client.ui.MaterialMasonry::getItemSelector()(),
            percentPosition: that.@gwt.material.design.addins.client.ui.MaterialMasonry::isPercentPosition()(),
            originLeft: that.@gwt.material.design.addins.client.ui.MaterialMasonry::isOriginLeft()(),
            originTop: that.@gwt.material.design.addins.client.ui.MaterialMasonry::isOriginTop()(),
            transitionDuration: that.@gwt.material.design.addins.client.ui.MaterialMasonry::getTransitionDuration()() + 'ms'
        });
        // change size of item by toggling gigante class
        grid.on( 'click', '.col', function() {
            $(this).toggleClass('gigante');
            // trigger layout after item size changes
            grid.masonry('layout');
            grid.masonry('reloadItems');
        });
    }-*/;

    /**
     * Get the item selector
     * @return
     */
    public String getItemSelector() {
        return itemSelector;
    }

    /**
     * Specifies which child elements will be used as item elements in the layout.It's .col by default for grid components
     * @param itemSelector
     */
    public void setItemSelector(String itemSelector) {
        this.itemSelector = itemSelector;
    }

    /**
     * Get the percent position boolean value
     * @return
     */
    public boolean isPercentPosition() {
        return percentPosition;
    }

    /**
     * Sets item positions in percent values, rather than pixel values. percentPosition: true works well with percent-width items, as items will not transition their position on resize.
     * @param percentPosition
     */
    public void setPercentPosition(boolean percentPosition) {
        this.percentPosition = percentPosition;
    }

    /**
     * Get the boolean value of origin left
     * @return
     */
    public boolean isOriginLeft() {
        return originLeft;
    }

    /**
     * Controls the horizontal flow of the layout. By default, item elements start positioning at the left, with originLeft: true. Set originLeft: false for right-to-left layouts.
     * @param originLeft
     */
    public void setOriginLeft(boolean originLeft) {
        this.originLeft = originLeft;
    }

    /**
     * Get the boolean value of origin top
     * @return
     */
    public boolean isOriginTop() {
        return originTop;
    }

    /**
     * Controls the vertical flow of the layout. By default, item elements start positioning at the top, with originTop: true. Set originTop: false for bottom-up layouts. It’s like Tetris
     * @param originTop
     */
    public void setOriginTop(boolean originTop) {
        this.originTop = originTop;
    }

    /**
     * Get the transition duration in milliseconds
     * @return
     */
    public double getTransitionDuration() {
        return transitionDuration;
    }

    public void setTransitionDuration(double transitionDuration) {
        this.transitionDuration = transitionDuration;
    }
}
