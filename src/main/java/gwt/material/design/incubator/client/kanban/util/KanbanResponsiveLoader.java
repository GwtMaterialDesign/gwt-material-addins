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
package gwt.material.design.incubator.client.kanban.util;

import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.incubator.client.kanban.Kanban;
import gwt.material.design.incubator.client.kanban.KanbanClientBundle;

public class KanbanResponsiveLoader {

    static {
        MaterialDesign.injectJs(KanbanClientBundle.INSTANCE.longPressEventJs());
    }

    private Kanban kanban;
    private ToggleStyleMixin<Kanban> toggleStyleMixin;

    protected KanbanResponsiveLoader() {
    }

    public KanbanResponsiveLoader(Kanban kanban) {
        this.kanban = kanban;
    }

    public void load() {
        if (kanban != null && kanban.isAttached()) {
            getToggleStyleMixin().setOn(true);
        }
    }

    public void unload() {
        if (kanban != null && kanban.isAttached()) {
            getToggleStyleMixin().setOn(false);
        }
    }

    public boolean isResponsive() {
        return getToggleStyleMixin().isOn();
    }

    public ToggleStyleMixin<Kanban> getToggleStyleMixin() {
        if (toggleStyleMixin == null) {
            toggleStyleMixin = new ToggleStyleMixin<>(kanban, "responsive");
        }
        return toggleStyleMixin;
    }
}
