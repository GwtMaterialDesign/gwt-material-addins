/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2020 GwtMaterialDesign
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
package gwt.material.design.incubator.client.loadingdot;

import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.loadingstate.LoadingStatePanel;

import java.util.Collections;
import java.util.List;

/**
 * A loader extension https://nzbin.github.io/three-dots/
 */
public class LoadingDots extends AbstractAddinsWidget implements HasType<LoadingDotsType> {

    static {
        IncubatorWidget.showWarning(LoadingStatePanel.class);
    }

    private CssTypeMixin<LoadingDotsType, LoadingDots> typeMixin;

    public LoadingDots() {
        setType(LoadingDotsType.PULSE);
    }

    @Override
    public void setType(LoadingDotsType type) {
        getTypeMixin().setType(type);
    }

    @Override
    public LoadingDotsType getType() {
        return getTypeMixin().getType();
    }

    protected CssTypeMixin<LoadingDotsType, LoadingDots> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin(this);
        }
        return typeMixin;
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(LoadingDotClientBundle.INSTANCE.threeDots(),LoadingDotDebugClientBundle.INSTANCE.threeDots()));
    }
}
