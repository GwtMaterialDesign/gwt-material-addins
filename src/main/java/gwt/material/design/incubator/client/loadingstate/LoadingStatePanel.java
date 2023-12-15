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
package gwt.material.design.incubator.client.loadingstate;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.loadingstate.constants.State;
import gwt.material.design.incubator.client.loadingstate.events.ErrorEvent;
import gwt.material.design.incubator.client.loadingstate.events.HasLoadingStateHandler;
import gwt.material.design.incubator.client.loadingstate.events.LoadingEvent;
import gwt.material.design.incubator.client.loadingstate.events.SuccessEvent;

import java.util.Collections;
import java.util.List;

/**
 * An extension to {@link MaterialPanel} that defines
 * a specific states to control it's children.
 *
 * <p><i>
 *     Note: This component is under the incubator process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
public class LoadingStatePanel extends AbstractAddinsWidget implements HasLoadingStateHandler {

    static {
        IncubatorWidget.showWarning(LoadingStatePanel.class);
    }

    private State state;
    private MaterialIcon icon = new MaterialIcon(IconType.LOOP);
    private MaterialLabel lblTitle = new MaterialLabel();
    private MaterialLabel lblDescription = new MaterialLabel();
    private MaterialLoader loader = new MaterialLoader();
    private boolean animation = true;

    public LoadingStatePanel() {}

    @Override
    protected void internalLoad() {
        setVisible(false);
        addStyleName(IncubatorCssName.LOADING_STATE);
        lblTitle.addStyleName(CssName.TITLE);
        lblDescription.addStyleName(AddinsCssName.DESCRIPTION);
        add(icon);
        loader.setContainer(icon);

        add(lblTitle);
        add(lblDescription);
    }

    public void setIcon(IconType iconType) {
        icon.setIconType(iconType);
    }

    public MaterialIcon getIcon() {
        return icon;
    }

    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    public void setDescription(String description) {
        lblDescription.setText(description);
    }

    public void setState(State state, String title, String description) {
        this.state = state;
        setTitle(title);
        setDescription(description);
        setVisible(true);
        if (isAnimation()) {
            new MaterialAnimation().transition(Transition.BOUNCEIN).animate(icon);
            new MaterialAnimation().transition(Transition.BOUNCEINUP).animate(lblTitle);
            new MaterialAnimation().transition(Transition.BOUNCEINUP).animate(lblDescription);
        }
        if (state == State.LOADING) {
            icon.setIconType(IconType.LOOP);
            icon.setBackgroundColor(Color.WHITE);
            icon.setIconColor(Color.BLACK);
            LoadingEvent.fire(this);
            loader.show();

        } else if (state == State.SUCCESS) {
            loader.hide();
            icon.setIconType(IconType.CHECK);
            icon.setBackgroundColor(Color.BLUE);
            icon.setIconColor(Color.WHITE);

            SuccessEvent.fire(this);
        } else if (state == State.ERROR) {
            loader.hide();
            icon.setIconType(IconType.ERROR);
            icon.setBackgroundColor(Color.RED);
            icon.setIconColor(Color.WHITE);

            ErrorEvent.fire(this);
        }
    }

    public boolean isAnimation() {
        return animation;
    }

    public void setAnimation(boolean animation) {
        this.animation = animation;
    }

    public State getState() {
        return state;
    }

    @Override
    public HandlerRegistration addLoadingHandler(LoadingEvent.LoadingHandler handler) {
        return addHandler(handler, LoadingEvent.getType());
    }

    @Override
    public HandlerRegistration addSuccessHandler(SuccessEvent.SuccessHandler handler) {
        return addHandler(handler, SuccessEvent.getType());
    }

    @Override
    public HandlerRegistration addErrorHandler(ErrorEvent.ErrorHandler handler) {
        return addHandler(handler, ErrorEvent.getType());
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(LoadingStatePanelClientBundle.INSTANCE.loadingStateCss(), LoadingStatePanelDebugClientBundle.INSTANCE.loadingStateDebugCss()));
    }
}
