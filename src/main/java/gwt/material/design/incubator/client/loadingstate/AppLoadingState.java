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
package gwt.material.design.incubator.client.loadingstate;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;

public class AppLoadingState extends LoadingStatePanel {

    private Widget target;

    @Override
    protected void onLoad() {
        super.onLoad();

        registerHandler(addLoadingHandler(event -> target.setVisible(false)));
        registerHandler(addSuccessHandler(event -> target.setVisible(false)));
        registerHandler(addErrorHandler(event -> reset(target)));
    }

    public void reset(Widget target) {
        reset(target, 3000);
    }

    public void reset(Widget target, int delay) {
        new MaterialAnimation().transition(Transition.BOUNCEOUTDOWN).delay(delay).animate(this, () -> {
            target.setVisible(true);
            new MaterialAnimation().transition(Transition.BOUNCEINUP).animate(target, () -> {
                RootPanel.get().getElement().getStyle().clearOverflow();
                target.setVisible(true);
            });
            setVisible(false);
        });
    }

    public Widget getTarget() {
        return target;
    }

    public void setTarget(Widget target) {
        this.target = target;
    }
}
