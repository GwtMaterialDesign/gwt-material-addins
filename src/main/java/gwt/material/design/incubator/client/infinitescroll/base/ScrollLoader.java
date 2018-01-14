/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.infinitescroll.base;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.HasActive;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.ActiveMixin;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.html.Span;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

public class ScrollLoader extends MaterialWidget implements HasActive {

    private Span label = new Span();
    private ActiveMixin<ScrollLoader> activeMixin;

    public ScrollLoader() {
        super(Document.get().createDivElement(), IncubatorCssName.INFINITE_SCROLL_LOADER);

        setActive(false);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        label.setText("Loading");
        add(label);
    }

    @Override
    public boolean isActive() {
        return getActiveMixin().isActive();
    }

    @Override
    public void setActive(boolean active) {
        getActiveMixin().setActive(active);

        MaterialLoader.loading(active, this);
    }

    public void setDisplayLabel(boolean visible) {
        label.setVisible(visible);
    }

    public boolean isVisible() {
        return label.isVisible();
    }

    public ActiveMixin<ScrollLoader> getActiveMixin() {
        if (activeMixin == null) {
            activeMixin = new ActiveMixin<ScrollLoader>(this);
        }
        return activeMixin;
    }
}
