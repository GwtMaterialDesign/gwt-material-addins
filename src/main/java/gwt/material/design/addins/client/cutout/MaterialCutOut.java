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
package gwt.material.design.addins.client.cutout;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.base.HasCircle;
import gwt.material.design.client.base.HasDurationTransition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;

import static gwt.material.design.jquery.client.api.JQuery.$;

//@formatter:off

/**
 * MaterialCutOut is a fullscreen dialog-like component to show users about new
 * features or important elements of the document.
 * <p>
 * You can use {@link CloseHandler}s to be notified when the cut out is closed.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p>
 * <pre>
 * {@code
 * <ma:cutout.MaterialCutOut ui:field="cutOut">
 *      <!-- add any widgets here -->
 * </ma:cutout.MaterialCutOut>
 * }
 * </pre>
 * <p>
 * <h3>Java Usage:</h3>
 * {@code
 * MaterialCutOut cutOut = ... //create using new or using UiBinder
 * cutOut.setTarget(myTargetWidget); //the widget or element you want to focus
 * cutOut.open(); //shows the dialog over the page
 * }
 * <p>
 * <h3>Custom styling:</h3> You use change the cut out style by using the
 * <code>material-cutout</code> class, and <code>material-cutout-focus</code>
 * class for the focusElement box.
 * <p>
 * <h3>Notice:</h3>On some iOS devices, on mobile Safari, the CutOut may not open when the
 * {@link #setCircle(boolean)} is set to <code>true</code>. This is because of problems on Safari
 * with box-shadows over rounded borders. To avoid this issue you can disable the circle. Check the
 * <a href="https://github.com/GwtMaterialDesign/gwt-material/issues/227">issue 227</a> for details.
 *
 * @author gilberto-torrezan
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#cutouts">Material Cutouts</a>
 */
// @formatter:on
public class MaterialCutOut extends MaterialWidget implements HasCloseHandlers<MaterialCutOut>,
        HasOpenHandlers<MaterialCutOut>, HasCircle, HasDurationTransition {

    private Color backgroundColor = Color.BLUE;
    private int cutOutPadding = 10;
    private double opacity = 0.8;
    private boolean animated = true;
    private String animationTimingFunction = "ease";
    private String backgroundSize;
    private String computedBackgroundColor;
    private boolean circle = false;
    private boolean autoAddedToDocument = false;
    private String viewportOverflow;
    private Element targetElement;
    private Element focusElement;
    private int duration = 500;

    public MaterialCutOut() {
        super(Document.get().createDivElement(), AddinsCssName.MATERIAL_CUTOUT);

        focusElement = Document.get().createDivElement();
        getElement().appendChild(focusElement);

        getElement().getStyle().setOverflow(Overflow.HIDDEN);
        getElement().getStyle().setDisplay(Display.NONE);
    }

    public MaterialCutOut(Color backgroundColor, Boolean circle, Double opacity) {
        this();
        setBackgroundColor(backgroundColor);
        setCircle(circle);
        setOpacity(opacity);
    }

    /**
     * Opens the dialog cut out taking all the screen. The target element should
     * be set before calling this method.
     *
     * @throws IllegalStateException if the target element is <code>null</code>
     * @see #setTarget(Widget)
     */
    public void open() {
        setCutOutStyle();

        if (targetElement == null) {
            throw new IllegalStateException("The target element should be set before calling open().");
        }
        targetElement.scrollIntoView();

        if (computedBackgroundColor == null) {
            setupComputedBackgroundColor();
        }

        //temporarily disables scrolling by setting the overflow of the page to hidden
        Style docStyle = Document.get().getDocumentElement().getStyle();
        viewportOverflow = docStyle.getOverflow();
        docStyle.setProperty("overflow", "hidden");

        if (backgroundSize == null) {
            backgroundSize = body().width() + 300 + "px";
        }

        setupTransition();
        if (animated) {
            focusElement.getStyle().setProperty("boxShadow", "0px 0px 0px 0rem " + computedBackgroundColor);

            //the animation will take place after the boxshadow is set by the deferred command
            Scheduler.get().scheduleDeferred(() -> {
                focusElement.getStyle().setProperty("boxShadow", "0px 0px 0px " + backgroundSize + " " + computedBackgroundColor);
            });
        } else {
            focusElement.getStyle().setProperty("boxShadow", "0px 0px 0px " + backgroundSize + " " + computedBackgroundColor);
        }

        if (circle) {
            focusElement.getStyle().setProperty("WebkitBorderRadius", "50%");
            focusElement.getStyle().setProperty("borderRadius", "50%");
        } else {
            focusElement.getStyle().clearProperty("WebkitBorderRadius");
            focusElement.getStyle().clearProperty("borderRadius");
        }
        setupCutOutPosition(focusElement, targetElement, cutOutPadding, circle);

        setupWindowHandlers();
        getElement().getStyle().clearDisplay();

        // verify if the component is added to the document (via UiBinder for
        // instance)
        if (getParent() == null) {
            autoAddedToDocument = true;
            RootPanel.get().add(this);
        }
        OpenEvent.fire(this, this);
    }

    protected void setCutOutStyle() {
        Style style = getElement().getStyle();
        style.setWidth(100, Unit.PCT);
        style.setHeight(100, Unit.PCT);
        style.setPosition(Position.FIXED);
        style.setTop(0, Unit.PX);
        style.setLeft(0, Unit.PX);
        style.setZIndex(10000);

        focusElement.setClassName(AddinsCssName.MATERIAL_CUTOUT_FOCUS);
        style = focusElement.getStyle();
        style.setProperty("content", "\'\'");
        style.setPosition(Position.ABSOLUTE);
        style.setZIndex(-1);
    }

    /**
     * Closes the cut out. It is the same as calling
     * {@link #close(boolean)} with <code>false</code>.
     */
    public void close() {
        this.close(false);
    }

    /**
     * Closes the cut out.
     *
     * @param autoClosed Notifies with the dialog was auto closed or closed by user action
     */
    public void close(boolean autoClosed) {
        //restore the old overflow of the page
        Document.get().getDocumentElement().getStyle().setProperty("overflow", viewportOverflow);

        getElement().getStyle().setDisplay(Display.NONE);

        getHandlerRegistry().clearHandlers();

        // if the component added himself to the document, it must remove
        // himself too
        if (autoAddedToDocument) {
            this.removeFromParent();
            autoAddedToDocument = false;
        }
        CloseEvent.fire(this, this, autoClosed);
    }

    @Override
    public void setBackgroundColor(Color bgColor) {
        backgroundColor = bgColor;
        //resetting the computedBackgroundColor
        computedBackgroundColor = null;
    }

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setOpacity(double opacity) {
        this.opacity = opacity;
        //resetting the computedBackgroundColor
        computedBackgroundColor = null;
    }

    @Override
    public Double getOpacity() {
        return opacity;
    }

    /**
     * @return the animation timing fucntion of the opening cut out
     */
    public String getAnimationTimingFunction() {
        return animationTimingFunction;
    }

    /**
     * Sets the animation timing fucntion of the opening cut out.
     *
     * @param animationTimingFunction The speed curve of the animation, such as ease (the default), linear and
     *                                ease-in-out
     */
    public void setAnimationTimingFunction(String animationTimingFunction) {
        this.animationTimingFunction = animationTimingFunction;
    }

    /**
     * Sets if the cut out should be rendered as a circle or a simple rectangle.
     * Circle is better for targets with same width and height. The default is
     * <code>false</code> (is a rectangle).
     */
    @Override
    public void setCircle(boolean circle) {
        this.circle = circle;
    }

    /**
     * @return The if the cut out should be rendered as a circle or a simple
     * rectangle
     */
    @Override
    public boolean isCircle() {
        return circle;
    }

    /**
     * Sets the padding in pixels of the cut out focusElement in relation to the target
     * element. The default is 10.
     */
    public void setCutOutPadding(int cutOutPadding) {
        this.cutOutPadding = cutOutPadding;
    }

    /**
     * @return The padding in pixels of the cut out focusElement in relation to the
     * target element
     */
    public int getCutOutPadding() {
        return cutOutPadding;
    }

    /**
     * Sets the target element to be focused by the cut out.
     */
    public void setTarget(Element targetElement) {
        this.targetElement = targetElement;
    }

    /**
     * Sets the target widget to be focused by the cut out. Its the same as
     * calling setTarget(widget.getElement());
     *
     * @see #setTarget(Element)
     */
    public void setTarget(Widget widget) {
        setTarget(widget.getElement());
    }

    /**
     * @return The target element to be focused
     */
    public Element getTargetElement() {
        return targetElement;
    }

    /**
     * Enables or disables the open animation of the cut out.
     * The default is <code>true</code>.
     */
    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    /**
     * @return If the animation of the cut out is enabled when opening.
     */
    public boolean isAnimated() {
        return animated;
    }

    /**
     * Sets the radius size of the Cut Out background. By default, it takes the whole page
     * by using 100rem as size.
     *
     * @param backgroundSize The size of the background of the Cut Out. You can use any supported
     *                       CSS unit for box shadows, such as rem and px.
     */
    public void setBackgroundSize(String backgroundSize) {
        this.backgroundSize = backgroundSize;
    }

    /**
     * @return The radius size of the background of the Cut Out.
     */
    public String getBackgroundSize() {
        return backgroundSize;
    }

    /**
     * Setups the cut out position when the screen changes size or is scrolled.
     */
    protected void setupCutOutPosition(Element cutOut, Element relativeTo, int padding, boolean circle) {
        float top = relativeTo.getAbsoluteTop() - body().scrollTop();
        float left = relativeTo.getAbsoluteLeft();

        float width = relativeTo.getOffsetWidth();
        float height = relativeTo.getOffsetHeight();

        if (circle) {
            if (width != height) {
                float dif = width - height;
                if (width > height) {
                    height += dif;
                    top -= dif / 2;
                } else {
                    dif = -dif;
                    width += dif;
                    left -= dif / 2;
                }
            }
        }

        top -= padding;
        left -= padding;
        width += padding * 2;
        height += padding * 2;

        $(cutOut).css("top", top + "px");
        $(cutOut).css("left", left + "px");
        $(cutOut).css("width", width + "px");
        $(cutOut).css("height", height + "px");
    }

    /**
     * Configures a resize handler and a scroll handler on the window to
     * properly adjust the Cut Out.
     */
    protected void setupWindowHandlers() {

        registerHandler(Window.addResizeHandler(event -> setupCutOutPosition(focusElement, targetElement, cutOutPadding, circle)));
        registerHandler(Window.addWindowScrollHandler(event -> setupCutOutPosition(focusElement, targetElement, cutOutPadding, circle)));
    }

    protected void setupTransition() {
        if (animated) {
            focusElement.getStyle().setProperty("WebkitTransition", "box-shadow " + getDuration() + "ms " + animationTimingFunction);
            focusElement.getStyle().setProperty("transition", "box-shadow " + getDuration() + "ms " + animationTimingFunction);
        } else {
            focusElement.getStyle().clearProperty("WebkitTransition");
            focusElement.getStyle().clearProperty("transition");
        }
    }

    /**
     * Gets the computed background color, based on the backgroundColor CSS
     * class.
     */
    protected void setupComputedBackgroundColor() {
        // temp is just a widget created to evaluate the computed background
        // color
        MaterialWidget temp = new MaterialWidget(Document.get().createDivElement());
        temp.setBackgroundColor(backgroundColor);

        // setting a style to make it invisible for the user
        Style style = temp.getElement().getStyle();
        style.setPosition(Position.FIXED);
        style.setWidth(1, Unit.PX);
        style.setHeight(1, Unit.PX);
        style.setLeft(-10, Unit.PX);
        style.setTop(-10, Unit.PX);
        style.setZIndex(-10000);

        // adding it to the body (on Chrome the component must be added to the
        // DOM before getting computed values).
        String computed = ColorHelper.setupComputedBackgroundColor(backgroundColor);

        // convert rgb to rgba, considering the opacity field
        if (opacity < 1 && computed.startsWith("rgb(")) {
            computed = computed.replace("rgb(", "rgba(").replace(")", ", " + opacity + ")");
        }

        computedBackgroundColor = computed;
    }

    public Element getFocusElement() {
        return focusElement;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public HandlerRegistration addCloseHandler(final CloseHandler<MaterialCutOut> handler) {
        return addHandler(handler, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler<MaterialCutOut> handler) {
        return addHandler(handler, OpenEvent.getType());
    }
}
