/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.addins.client.range;

import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.addins.client.range.js.JsContinuousRange;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRange;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.Collections;
import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;


public class ContinuousRangeSlider extends MaterialRange implements HasDependency, HasType<ContinuousRangeSliderType> {

    protected DependencyMixin<HasDependency> dependencyMixin;

    protected CssTypeMixin<ContinuousRangeSliderType, ContinuousRangeSlider> typeMixin;

    public ContinuousRangeSlider() {
        super();
    }

    @Override
    protected void onLoad() {
        getDependencyMixin().install(() -> {
            internalLoad();
            super.onLoad();
        });
    }

    protected void internalLoad() {
        setType(ContinuousRangeSliderType.SHADOW);
        $(getElement()).on("slider-change", (event, o) -> {
            setValue(Integer.parseInt(getRangeInputElement().getValue()), true, false);
            return true;
        });
        getThumb().removeFromParent();
        updateClassName(false);
        JsContinuousRange.$(getRangeContainer().getElement()).rkmd_rangeSlider();
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        updateClassName(true);
    }

    protected void updateClassName(boolean remove) {
        String styleName = AddinsCssName.CONTINUOUS_SLIDER;
        MaterialPanel rangeContainer = getRangeContainer();
        if (rangeContainer != null && rangeContainer.isAttached()) {
            if (remove) {
                if (rangeContainer.getElement().hasClassName(styleName)) {
                    rangeContainer.removeStyleName(styleName);
                }
            } else {
                if (!rangeContainer.getElement().hasClassName(styleName)) {
                    rangeContainer.addStyleName(styleName);
                }
            }
        }
    }

    @Override
    public void setType(ContinuousRangeSliderType type) {
        getTypeMixin().setType(type);
    }

    @Override
    public void setValue(Integer value, boolean fireEvents) {
        super.setValue(value, fireEvents);
        updateDom(value);
    }

    public void setValue(Integer value, boolean fireEvents, boolean updateDom) {
        if (updateDom) {
            updateDom(value);
        }
        super.setValue(value, fireEvents);
    }

    protected void updateDom(Integer value) {
        JQueryElement sliderFill = $(getElement()).find(".slider-fill");
        JQueryElement sliderHandler = $(getElement()).find(".slider-handle");
        double percent = (value * 1.0 / getMax()) * 100;
        if (sliderFill != null && sliderHandler != null) {
            sliderFill.css("width", percent + "%");
            sliderHandler.css("left", percent + "%");
        }
    }

    @Override
    public ContinuousRangeSliderType getType() {
        return getTypeMixin().getType();
    }

    public CssTypeMixin<ContinuousRangeSliderType, ContinuousRangeSlider> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin<>(this, getRangeContainer());
        }
        return typeMixin;
    }

    public DependencyMixin<HasDependency> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(ContinuousRangeSliderDebugClientBundle.INSTANCE.continuousRangeCss(), ContinuousRangeSliderClientBundle.INSTANCE.continuousRangeCss()));
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(ContinuousRangeSliderDebugClientBundle.INSTANCE.continuousRangeJs(), ContinuousRangeSliderDebugClientBundle.INSTANCE.continuousRangeJs()));
    }
}
