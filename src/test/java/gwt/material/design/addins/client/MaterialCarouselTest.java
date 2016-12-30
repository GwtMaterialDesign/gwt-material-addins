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
package gwt.material.design.addins.client;

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.carousel.MaterialCarousel;
import gwt.material.design.addins.client.carousel.events.*;
import gwt.material.design.addins.client.carousel.js.JsCarouselOptions;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialPanel;

public class MaterialCarouselTest extends MaterialAddinsTest {

    public void init() {
        MaterialCarousel carousel = new MaterialCarousel();
        RootPanel.get().add(carousel);
        checkWidget(carousel);
        checkProperties(carousel);
        checkEvents(carousel);
        checkResponsiveOptions(carousel);
    }

    protected <T extends MaterialCarousel> void checkResponsiveOptions(T carousel) {
        JsCarouselOptions mobileOptions = new JsCarouselOptions();
        mobileOptions.slidesToShow = 3;
        mobileOptions.slidesToScroll = 3;
        carousel.setMobileSettings(mobileOptions);
        assertEquals(carousel.getMobileSettings(), mobileOptions);

        JsCarouselOptions tabletOptions = new JsCarouselOptions();
        tabletOptions.slidesToShow = 4;
        tabletOptions.slidesToScroll = 4;
        carousel.setTabletSettings(tabletOptions);
        assertEquals(carousel.getTabletSettings(), tabletOptions);
    }

    protected <T extends MaterialCarousel> void checkEvents(T carousel) {
        final boolean[] afterChangeFired = {false};
        carousel.addAfterChangeHandler(e -> afterChangeFired[0] = true);
        carousel.fireEvent(new AfterChangeEvent(0));
        assertTrue(afterChangeFired[0]);
        final boolean[] beforeChangeFired = {false};
        carousel.addBeforeChangeHandler(e -> beforeChangeFired[0] = true);
        carousel.fireEvent(new BeforeChangeEvent(0, 1));
        assertTrue(beforeChangeFired[0]);
        final boolean[] initFired = {false};
        carousel.addInitHandler(e -> initFired[0] = true);
        carousel.fireEvent(new InitEvent());
        assertTrue(initFired[0]);
        final boolean[] destroyFired = {false};
        carousel.addDestroyHandler(e -> destroyFired[0] = true);
        carousel.fireEvent(new DestroyEvent());
        assertTrue(destroyFired[0]);
        final boolean[] swipeFired = {false};
        carousel.addSwipeHandler(e -> swipeFired[0] = true);
        carousel.fireEvent(new SwipeEvent("right"));
        assertTrue(swipeFired[0]);
    }

    protected <T extends MaterialCarousel> void checkProperties(T carousel) {
        carousel.setInfinite(true);
        assertTrue(carousel.isInfinite());
        carousel.setCenterMode(true);
        assertTrue(carousel.isCenterMode());
        carousel.setVariableWidth(true);
        assertTrue(carousel.isVariableWidth());
        carousel.setShowDots(true);
        assertTrue(carousel.isShowDots());
        carousel.setShowArrows(true);
        assertTrue(carousel.isShowArrows());
        carousel.setAdaptiveHeight(true);
        assertTrue(carousel.isAdaptiveHeight());
        carousel.setAutoplay(true);
        assertTrue(carousel.isAutoplay());
        carousel.setFade(true);
        assertTrue(carousel.isFade());
        carousel.setSlidesToShow(1);
        assertEquals(carousel.getSlidesToShow(), 1);
        carousel.setSlidesToScroll(1);
        assertEquals(carousel.getSlidesToScroll(), 1);
        carousel.setSpeed(100);
        assertEquals(carousel.getSpeed(), 100);
        carousel.setAutoplaySpeed(100);
        assertEquals(carousel.getAutoplaySpeed(), 100);
        carousel.setEdgeFriction(10);
        assertEquals(carousel.getEdgeFriction(), 10.0);
    }

    @Override
    protected <T extends MaterialWidget> void checkChildren(T widget) {
       // checkStructure(new MaterialCarousel());
    }

    public void checkStructure(MaterialCarousel carousel) {
        RootPanel.get().add(carousel);
        assertEquals(carousel.getWidget(0), carousel.getBtnNextArrow());
        assertTrue(carousel.getWidget(0).getElement().hasClassName(AddinsCssName.CAROUSEL_NEXT_ARROW));
        assertEquals(carousel.getWidget(1), carousel.getBtnPrevArrow());
        assertTrue(carousel.getWidget(1).getElement().hasClassName(AddinsCssName.CAROUSEL_PREV_ARROW));
        assertEquals(carousel.getWidget(2), carousel.getContainer());
        assertTrue(carousel.getWidget(2).getElement().hasClassName(AddinsCssName.MATERIAL_CAROUSEL_CONTAINER));

        for (int i = 1; i <= 5; i++) {
            MaterialPanel panel = new MaterialPanel();
            carousel.add(panel);
        }

        assertEquals(carousel.getContainer().getChildren().size(), 5);
    }
}
