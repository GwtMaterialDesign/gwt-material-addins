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
package gwt.material.design.incubator.client.walkthrough;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.carousel.MaterialCarousel;
import gwt.material.design.addins.client.carousel.MaterialCarouselFixedItem;
import gwt.material.design.addins.client.carousel.constants.CarouselType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.Type;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.walkthrough.events.CompleteEvent;

//@formatter:off

/**
 * An extension to Onboard Type of {@link MaterialCarousel} component
 * which provides additional features and handler registrations.
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class Walkthrough extends MaterialCarousel {

    static {
        IncubatorWidget.showWarning(Walkthrough.class);
    }

    private MaterialCarouselFixedItem item = new MaterialCarouselFixedItem();
    private MaterialButton submit = new MaterialButton("Get Started");

    @Override
    protected void onLoad() {
        super.onLoad();

        item.add(submit);
        submit.setFontSize("0.8em");
        submit.setBackgroundColor(Color.WHITE);
        submit.setTextColor(Color.GREY);
        submit.setWaves(WavesType.DEFAULT);
        add(item);

        setType(CarouselType.ONBOARD);
        setLayoutPosition(Style.Position.FIXED);
        setEdgeFriction(0);

        registerHandler(addAfterChangeHandler(event -> animate(event.getCurrentSlide())));
        registerHandler(addInitHandler(event -> animate(0)));
        registerHandler(submit.addClickHandler(clickEvent -> CompleteEvent.fire(this)));
    }

    protected void animate(int index) {
        Widget w = getContainer().getWidget(index);
        if (w instanceof WalkthroughItem) {
            ((WalkthroughItem) w).animate();
        }
    }

    public void register(String username, String appName) {
        WalkthroughManager.register(username, appName);
    }

    public boolean hasWalkthrough(String username, String appName) {
        return WalkthroughManager.hasWalkthrough(username, appName);
    }

    public HandlerRegistration addCompleteHandler(CompleteEvent.CompleteHandler handler) {
        return addHandler(handler, CompleteEvent.TYPE);
    }
}
