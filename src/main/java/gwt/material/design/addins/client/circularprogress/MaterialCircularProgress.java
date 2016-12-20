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
package gwt.material.design.addins.client.circularprogress;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.circularprogress.events.CircularProgressEvent;
import gwt.material.design.addins.client.circularprogress.events.CircularProgressEvents;
import gwt.material.design.addins.client.circularprogress.events.HasCircularProgressHandlers;
import gwt.material.design.addins.client.circularprogress.js.JsCircularProgressOptions;
import gwt.material.design.addins.client.stepper.events.CompleteEvent;
import gwt.material.design.addins.client.stepper.events.StartEvent;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.html.Span;

import static gwt.material.design.addins.client.circularprogress.js.JsCircularProgress.$;

/**
 * Circular Progress that draws an animated circular progress bar. Good for dashboards.
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
 * <!-- Default -->
 * <ma:circularprogress.MaterialCircularProgress value="0.3" grid="s12 m4 l3"/>
 * <!-- Fill Color -->
 * <ma:circularprogress.MaterialCircularProgress fillColor="PURPLE" emptyFillColor="PURPLE_LIGHTEN_4" value="0.3" grid="s12 m4 l3"/>
 * <!-- Thickness -->
 * <ma:circularprogress.MaterialCircularProgress value="0.3" thickness="20" grid="s12 m4 l3"/>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#circularprogress">Material Circular Progress</a>
 */
public class MaterialCircularProgress extends MaterialWidget implements HasCircularProgressHandlers {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialCircularProgressDebugClientBundle.INSTANCE.circularProgressDebugJs());
            MaterialDesignBase.injectCss(MaterialCircularProgressDebugClientBundle.INSTANCE.circularProgressDebugCss());
        } else {
            MaterialDesignBase.injectJs(MaterialCircularProgressClientBundle.INSTANCE.circularProgressJs());
            MaterialDesignBase.injectCss(MaterialCircularProgressClientBundle.INSTANCE.circularProgressCss());
        }
    }

    private double value = 0.0;
    private int size = 100;
    private int thickness = 8;
    private double startAngle = Math.PI;
    private Color fillColor = Color.BLUE;
    private Color emptyFillColor = Color.GREY_LIGHTEN_2;
    private boolean reverse;
    private boolean initialized;

    private Span lblText = new Span();

    public MaterialCircularProgress() {
        super(Document.get().createDivElement(), "circular-progress");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        if (!initialized) {
            initialize();
            initialized = true;
        }
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        $(getElement()).off(CircularProgressEvents.START);
        $(getElement()).off(CircularProgressEvents.PROGRESS);
        $(getElement()).off(CircularProgressEvents.COMPLETED);
        initialized = false;
    }

    protected void initialize() {
        JsCircularProgressOptions options = new JsCircularProgressOptions();
        options.value = value;
        options.fill = ColorHelper.setupComputedBackgroundColor(fillColor);
        options.emptyFill = ColorHelper.setupComputedBackgroundColor(emptyFillColor);
        options.size = size;
        options.thickness = thickness;
        options.startAngle = startAngle;
        options.reverse = reverse;
        $(getElement()).on(CircularProgressEvents.PROGRESS, (e, progress, step) -> {
            CircularProgressEvent.fire(this, (double) progress, (double) step);
            return true;
        });
        $(getElement()).on(CircularProgressEvents.START, (e, param1) -> {
            StartEvent.fire(this);
            return true;
        });

        $(getElement()).on(CircularProgressEvents.COMPLETED, (e, param1) -> {
            CompleteEvent.fire(this, (int) value);
            return true;
        });
        $(getElement()).circleProgress(options);

        lblText.setWidth(size + "px");
        lblText.setHeight(size + "px");
        lblText.getElement().getStyle().setLineHeight(size, Style.Unit.PX);
        add(lblText);

    }

    public double getValue() {
        return value;
    }

    /**
     * This is the only required option. It should be from 0.0 to 1.0 (Default: 0)
     */
    public void setValue(double value) {
        this.value = value;
        if (initialized) {
            $(getElement()).circleProgress("value", value);
        }
    }

    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Set the fillColor of the circular progress
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getEmptyFillColor() {
        return emptyFillColor;
    }

    /**
     * Set the empty fill color of the circular progress
     */
    public void setEmptyFillColor(Color emptyFillColor) {
        this.emptyFillColor = emptyFillColor;
    }

    public double getSize() {
        return size;
    }

    /**
     * Set the size of the circle / canvas in pixels
     */
    public void setSize(int size) {
        this.size = size;
    }

    public int getThickness() {
        return thickness;
    }

    /**
     * Thickness width of the arc. (Default : 8)
     */
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public double getStartAngle() {
        return startAngle;
    }

    /**
     * Initial angle of the circular progress component (Default : -Math.PI);
     */
    public void setStartAngle(double startAngle) {
        this.startAngle = startAngle;
    }

    public boolean isReverse() {
        return reverse;
    }

    /**
     * Reverse animation and arc draw (Default : false)
     */
    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    @Override
    public void addCircularProgressEvent(CircularProgressEvent.CircularProgressHandler handler) {
        addHandler(handler, CircularProgressEvent.TYPE);
    }

    @Override
    public void addStartHandler(StartEvent.StartHandler handler) {
        addHandler(handler, StartEvent.TYPE);
    }

    @Override
    public void addCompleteHandler(CompleteEvent.CompleteHandler handler) {
        addHandler(handler, CompleteEvent.TYPE);
    }

    /**
     * Set the text of the circular progress
     */
    public void setText(String text) {
        lblText.setText(text);
    }

    @Override
    public void setFontSize(String fontSize) {
        lblText.setFontSize(fontSize);
    }

    /**
     * Redraw the the circular progress
     */
    public void redraw() {
        $(getElement()).circleProgress("redraw");
    }
}
