/*
 * #%L
 * Errai Prototype
 * %%
 * Copyright (C) 2015 - 2017 Doltech
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
package gwt.material.design.incubator.client.toggle;

import gwt.material.design.client.base.HasActive;
import gwt.material.design.client.base.mixin.ActiveMixin;
import gwt.material.design.client.ui.MaterialButton;

public class ToggleButton extends MaterialButton implements HasActive {

    private boolean toggle;
    private GroupToggleButton groupParent;

    private ActiveMixin<ToggleButton> activeMixin;

    public ToggleButton(String text) {
        super(text);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        setToggle(false);
        setShadow(0);
    }

    public void toggle() {
        if (isToggle()) {
            setToggle(false);
        } else {
            setToggle(true);
        }
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
        setActive(toggle);
    }

    public GroupToggleButton getGroupParent() {
        return groupParent;
    }

    public void setGroupParent(GroupToggleButton groupParent) {
        this.groupParent = groupParent;
    }

    @Override
    public void setActive(boolean active) {
        getActiveMixin().setActive(active);
    }

    @Override
    public boolean isActive() {
        return getActiveMixin().isActive();
    }

    public ActiveMixin<ToggleButton> getActiveMixin() {
        if (activeMixin == null) {
            activeMixin = new ActiveMixin<ToggleButton>(this);
        }
        return activeMixin;
    }
}
