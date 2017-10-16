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
package gwt.material.design.addins.client.ui;

import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.carousel.MaterialCarousel;
import gwt.material.design.addins.client.carousel.events.*;
import gwt.material.design.addins.client.carousel.js.JsCarouselOptions;
import gwt.material.design.client.ui.MaterialPanel;

public class MaterialCarouselTest extends MaterialWidgetTest<MaterialCarousel> {

    @Override
    protected MaterialCarousel createWidget() {
        return new MaterialCarousel();
    }

    public void testResponsiveOptions() {
        // given
        MaterialCarousel carousel = getWidget();

        // when / then
        JsCarouselOptions mobileOptions = JsCarouselOptions.create();
        mobileOptions.setSlidesToShow(3);
        mobileOptions.setSlidesToScroll(3);
        carousel.setMobileSettings(mobileOptions);
        assertEquals(mobileOptions, carousel.getMobileSettings());

        JsCarouselOptions tabletOptions = JsCarouselOptions.create();
        tabletOptions.setSlidesToShow(4);
        tabletOptions.setSlidesToScroll(4);
        carousel.setTabletSettings(tabletOptions);
        assertEquals(tabletOptions, carousel.getTabletSettings());
    }

    public void testEvents() {
        // given
        MaterialCarousel carousel = getWidget();

        // when / then
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

    public void testProperties() {
        // given
        MaterialCarousel carousel = getWidget();

        // when / then
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
        assertEquals(1, carousel.getSlidesToShow());
        carousel.setSlidesToScroll(1);
        assertEquals(1, carousel.getSlidesToScroll());
        carousel.setSpeed(100);
        assertEquals(100, carousel.getSpeed());
        carousel.setAutoplaySpeed(100);
        assertEquals(100, carousel.getAutoplaySpeed());
        carousel.setEdgeFriction(10);
        assertEquals(10.0, carousel.getEdgeFriction());
    }

    public void testStructure() {
        // given
        MaterialCarousel carousel = getWidget();

        // when / then
        assertEquals(carousel.getBtnNextArrow(), carousel.getWidget(0));
        assertTrue(carousel.getWidget(0).getElement().hasClassName(AddinsCssName.CAROUSEL_NEXT_ARROW));

        assertEquals(carousel.getBtnPrevArrow(), carousel.getWidget(1));
        assertTrue(carousel.getWidget(1).getElement().hasClassName(AddinsCssName.CAROUSEL_PREV_ARROW));

        assertEquals(carousel.getWrapper(), carousel.getWidget(2));
        assertTrue(carousel.getWidget(2).getElement().hasClassName(AddinsCssName.MATERIAL_CAROUSEL_CONTAINER));

        for (int i = 1; i <= 5; i++) {
            MaterialPanel panel = new MaterialPanel();
            carousel.add(panel);
        }

        assertEquals(5, carousel.getContainer().getChildren().size());
    }
}
