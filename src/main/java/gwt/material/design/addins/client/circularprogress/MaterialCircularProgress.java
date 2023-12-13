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

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.AbstractAddinsValueWidget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.circularprogress.events.*;
import gwt.material.design.addins.client.circularprogress.js.JsCircularProgressOptions;
import gwt.material.design.addins.client.circularprogress.ui.CircularProgressLabel;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.base.mixin.FontSizeMixin;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.Color;

import java.util.ArrayList;
import java.util.List;

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
 * @see <a href="https://github.com/kottenator/jquery-circle-progress">jquery-circle-progress 1.2.2</a>
 */
public class MaterialCircularProgress extends AbstractAddinsValueWidget<Double> implements HasCircularProgressHandlers {

    private final CircularProgressLabel label = new CircularProgressLabel();
    private final JsCircularProgressOptions options = JsCircularProgressOptions.create();
    private Color fillColor = Color.BLUE;
    private Color emptyFillColor = Color.GREY_LIGHTEN_2;
    private ToggleStyleMixin<MaterialWidget> responsiveMixin;
    private FontSizeMixin<MaterialWidget> fontSizeMixin;

    public MaterialCircularProgress() {
        super(Document.get().createDivElement(), AddinsCssName.CIRCULAR_PROGRESS);
    }

    @Override
    public void internalLoad() {
        if (!label.isAttached()) {
            add(label);
            label.setSize(getSize(), isResponsive());
        }
        loadHandlers();
        Scheduler.get().scheduleDeferred(() -> $(getElement()).circleProgress(options));
    }

    public void loadHandlers() {
        $(getElement()).on(CircularProgressEvents.PROGRESS, (e, progress, step) -> {
            ProgressEvent.fire(this, (double) progress, (double) step);
            return true;
        });
        $(getElement()).on(CircularProgressEvents.START, (e, param1) -> {
            StartEvent.fire(this, getValue());
            return true;
        });

        $(getElement()).on(CircularProgressEvents.COMPLETED, (e, param1) -> {
            CompleteEvent.fire(this, getValue());
            return true;
        });
    }

    @Override
    public void unload() {
        if (label.isAttached()) {
            label.removeFromParent();
        }

        $(getElement()).off(CircularProgressEvents.START);
        $(getElement()).off(CircularProgressEvents.PROGRESS);
        $(getElement()).off(CircularProgressEvents.COMPLETED);
    }

    @Override
    public void reload() {
        reload(false);
    }

    public void reload(boolean redraw) {
        unload();
        internalLoad();
        if (redraw) {
            redraw();
        }
    }

    @Override
    public void reset() {
        super.reset();

        reload();
    }

    public void redraw() {
        $(getElement()).circleProgress("redraw");
    }

    @Override
    public Double getValue() {
        return options.value;
    }

    @Override
    public void setValue(Double value) {
        setValue(value, false);
    }

    @Override
    public void setValue(Double value, boolean fireEvents) {
        super.setValue(value, fireEvents);

        if (!isAttached()) {
            options.value = value;
        } else {
            $(getElement()).circleProgress("value", value);
        }
    }

    /**
     * This is the only required option. It should be from 0.0 to 1.0 (Default: 0)
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Set the fillColor of the circular progress
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        options.fill = ColorHelper.setupComputedBackgroundColor(fillColor);
    }

    public Color getEmptyFillColor() {
        return emptyFillColor;
    }

    /**
     * Set the empty fill color of the circular progress
     */
    public void setEmptyFillColor(Color emptyFillColor) {
        this.emptyFillColor = emptyFillColor;
        options.emptyFill = ColorHelper.setupComputedBackgroundColor(emptyFillColor);
    }

    public double getSize() {
        return options.size;
    }

    /**
     * Set the size of the circle / canvas in pixels
     */
    public void setSize(int size) {
        options.size = size;
    }

    public int getThickness() {
        return (int) options.thickness;
    }

    /**
     * Thickness width of the arc. (Default : 8)
     */
    public void setThickness(int thickness) {
        options.thickness = thickness;
    }

    public double getStartAngle() {
        return options.startAngle;
    }

    /**
     * Initial angle of the circular progress component (Default : -Math.PI);
     */
    public void setStartAngle(double startAngle) {
        options.startAngle = startAngle;
    }

    public boolean isReverse() {
        return options.reverse;
    }

    /**
     * Reverse animation and arc draw (Default : false)
     */
    public void setReverse(boolean reverse) {
        options.reverse = reverse;
    }

    /**
     * Set the text of the circular progress
     */
    public void setText(String text) {
        label.setText(text);
    }

    public boolean isResponsive() {
        return getResponsiveMixin().isOn();
    }

    /**
     * Enable Responsive circular progress
     * If responsive we will set the size to maximum value = 1000,
     * else set it to the default size = 100
     **/
    public void setResponsive(boolean responsive) {
        options.size = responsive ? 1000 : 100;
        getResponsiveMixin().setOn(responsive);
    }

    public CircularProgressLabel getLabel() {
        return label;
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        List<DependencyResource> resources = new ArrayList<>();
        resources.add(new DependencyResource(MaterialCircularProgressDebugClientBundle.INSTANCE.circularProgressDebugJs(), true));
        resources.add(new DependencyResource(MaterialCircularProgressClientBundle.INSTANCE.circularProgressJs(), false));
        return resources;
    }


    @Override
    public List<DependencyResource> getCssDependencies() {
        List<DependencyResource> resources = new ArrayList<>();
        resources.add(new DependencyResource(MaterialCircularProgressClientBundle.INSTANCE.circularProgressCss(), true));
        resources.add(new DependencyResource(MaterialCircularProgressDebugClientBundle.INSTANCE.circularProgressDebugCss(), false));
        return resources;
    }

    public ToggleStyleMixin<MaterialWidget> getResponsiveMixin() {
        if (responsiveMixin == null) {
            responsiveMixin = new ToggleStyleMixin<>(this, AddinsCssName.RESPONSIVE);
        }
        return responsiveMixin;
    }

    @Override
    protected FontSizeMixin<MaterialWidget> getFontSizeMixin() {
        if (fontSizeMixin == null) {
            fontSizeMixin = new FontSizeMixin<>(label);
        }
        return fontSizeMixin;
    }

    @Override
    public void addProgressHandler(ProgressEvent.ProgressHandler handler) {
        addHandler(handler, ProgressEvent.TYPE);
    }

    @Override
    public void addStartHandler(StartEvent.StartHandler handler) {
        addHandler(handler, StartEvent.TYPE);
    }

    @Override
    public void addCompleteHandler(CompleteEvent.CompleteHandler handler) {
        addHandler(handler, CompleteEvent.TYPE);
    }
}
