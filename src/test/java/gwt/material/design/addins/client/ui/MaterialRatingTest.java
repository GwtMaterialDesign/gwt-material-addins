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
package gwt.material.design.addins.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.rating.MaterialRating;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;

/**
 * Test case for rating component
 *
 * @author kevzlou7979
 */
public class MaterialRatingTest extends MaterialWidgetTest<MaterialRating> {

    @Override
    protected MaterialRating createWidget() {
        return new MaterialRating();
    }
    
    public void testEditable() {
        // UiBinder
        // given
        MaterialRating rating = getWidget(false);

        // when / then
        checkEditable(rating);

        // Standard
        // given
        attachWidget();

        // when / then
        checkEditable(rating);
    }

    protected void checkEditable(MaterialRating rating) {
        // when / then
        rating.setEnabled(true);
        rating.setValue(5);
        rating.setMaxRating(10);
        rating.setEditable(false);
        assertFalse(rating.isEditable());
        // Get single icon to test whether mouse out / click handler will be fired (Expected : false)
        // And the value should not be changed (Expected : 5)
        assertTrue(rating.getWidget(3) instanceof MaterialIcon);
        MaterialIcon icon = (MaterialIcon) rating.getWidget(0);
        fireClickEvent(icon);
        assertEquals(5, Math.toIntExact(rating.getValue()));
    }

    public void testValue() {
        // UiBinder
        // given
        MaterialRating rating = getWidget();

        // Determine the number of selected icons vs. unselected ones
        rating.setSelectedRatingIcon(IconType.FAVORITE);
        rating.setUnselectedRatingIcon(IconType.FAVORITE_BORDER);
        testRatingUpdate(3, rating.getMaxRating(), rating); // Update on value(3) , maxrating(default - 5)
        // Check value and max rating combination to test whether designated icons are applied
        testRatingUpdate(5, 5, rating);
        testRatingUpdate(5, 10, rating);
    }

    protected void testRatingUpdate(Integer value, int maxRating, MaterialRating rating) {
        rating.setMaxRating(maxRating);
        rating.setValue(value);
        assertEquals(maxRating, rating.getMaxRating());
        assertEquals(value, rating.getValue());
        for (Widget w : rating) {
            assertTrue(w instanceof MaterialIcon);
            MaterialIcon icon = (MaterialIcon) w;
            if (rating.getWidgetIndex(w) < value) {
                assertEquals(IconType.FAVORITE, icon.getIconType());
                assertTrue(icon.getElement().hasClassName(AddinsCssName.MATERIAL_RATING_SELECTED));
            } else {
                assertEquals(IconType.FAVORITE_BORDER, icon.getIconType());
                assertTrue(icon.getElement().hasClassName(AddinsCssName.MATERIAL_RATING_UNSELECTED));
            }
        }
        checkValueChangeEvent(rating, 5, 2);
    }

    public void testStructure() {
        // UiBinder
        // given
        MaterialRating rating = getWidget();

        // when / then
        final int MAX_RATING = rating.getMaxRating();
        assertEquals(5, MAX_RATING);
        IconType selectedIcon = rating.getSelectedRatingIcon();
        IconType unselectedIcon = rating.getUnselectedRatingIcon();
        assertEquals(IconType.STAR, selectedIcon);
        assertEquals(IconType.STAR_BORDER, unselectedIcon);
        assertEquals(rating.getWidgetCount(), MAX_RATING);
        for (Widget w : rating) {
            assertTrue(w instanceof MaterialIcon);
            MaterialIcon icon = (MaterialIcon) w;
            assertEquals(IconType.STAR_BORDER, icon.getIconType());
        }
    }
}
