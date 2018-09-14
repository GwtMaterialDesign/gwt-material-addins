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
package gwt.material.design.incubator.client.timer;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasDurationTransition;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.ColorsMixin;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

import static gwt.material.design.addins.client.bubble.js.JsBubble.$;

//@formatter:off

/**
 * Timer Progress - provides a delightful progress
 * infinite animation that bounces from left to right.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 *      TimerProgress timerProgress = new TimerProgress();
 *      timerProgress.setFillColor(Color.RED);
 *      timerProgress.setEmptyFillColor(Color.RED_LIGHTEN_1);
 *      timerProgress.setDuration(2);
 * }
 * </pre>
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class TimerProgress extends MaterialWidget implements HasDurationTransition {

    private MaterialPanel fill = new MaterialPanel();
    private ColorsMixin<TimerProgress> emptyFillColorMixin;
    private ColorsMixin<MaterialPanel> fillColorMixin;

    static {
        IncubatorWidget.showWarning(TimerProgress.class);
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(TimerProgressDebugClientBundle.INSTANCE.timerDebugCss());
        } else {
            MaterialDesignBase.injectCss(TimerProgressClientBundle.INSTANCE.timerCss());
        }
    }

    private int duration = 1000;

    public TimerProgress() {
        super(Document.get().createDivElement(), IncubatorCssName.TIMER_PROGRESS + " " + IncubatorCssName.BOUNCING);
        fill.addStyleName(IncubatorCssName.FILL);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        add(fill);
        $(fill.getElement()).css("animation-duration", duration + "ms");
        $(fill.getElement()).css("-webkit-animation-duration", duration + "ms");
    }

    public MaterialPanel getFill() {
        return fill;
    }

    /**
     * Set the fill color (Default : BLUE)
     */
    public void setFillColor(Color fillColor) {
        getFillColorMixin().setBackgroundColor(fillColor);
    }

    public Color getFillColor() {
        return getFillColorMixin().getBackgroundColor();
    }

    /**
     * Set the empty fill color (Default : GREY)
     */
    public void setEmptyFillColor(Color emptyFillColor) {
        getEmptyFillColorMixin().setBackgroundColor(emptyFillColor);
    }

    public Color getEmptyFillColor() {
        return getEmptyFillColorMixin().getBackgroundColor();
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    protected ColorsMixin<TimerProgress> getEmptyFillColorMixin() {
        if (emptyFillColorMixin == null) {
            emptyFillColorMixin = new ColorsMixin(this);
        }
        return emptyFillColorMixin;
    }

    protected ColorsMixin<MaterialPanel> getFillColorMixin() {
        if (fillColorMixin == null) {
            fillColorMixin = new ColorsMixin(fill);
        }
        return fillColorMixin;
    }
}
