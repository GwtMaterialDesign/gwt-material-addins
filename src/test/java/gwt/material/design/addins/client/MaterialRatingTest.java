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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.GwtMaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.rating.MaterialRating;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import org.junit.Test;

public class MaterialRatingTest extends GwtMaterialAddinsTest {

    @Test
    public void testRating() {
        MaterialRating rating = new MaterialRating();
        checkWidget(rating);
        checkStructure(rating);
        checkValue(rating);
        checkValueChangeEvent(rating);
        checkEditable(rating);
    }

    protected <T extends MaterialRating> void checkEditable(T rating) {
        rating.setEnabled(true);
        rating.setValue(5);
        rating.setMaxRating(10);
        rating.setEditable(false);
        assertFalse(rating.isEditable());

        // Get single icon to check whether mouse out / click handler will be fired (Expected : false)
        // And the value should not be changed (Expected : 5)
        assertTrue(rating.getWidget(3) instanceof MaterialIcon);
        MaterialIcon icon = (MaterialIcon) rating.getWidget(0);
        icon.fireEvent(new ClickEvent() {
        });
        assertEquals(Math.toIntExact(rating.getValue()), 5);
    }

    protected <T extends MaterialRating> void checkValueChangeEvent(T rating) {
        final boolean[] isValueChangeFired = {false};
        final Integer VALUE = 2;
        rating.addValueChangeHandler(valueChangeEvent -> {
            assertEquals(valueChangeEvent.getValue(), VALUE);
            isValueChangeFired[0] = true;
        });
        rating.setValue(2, true);
        assertTrue(isValueChangeFired[0]);
    }

    protected <T extends MaterialRating> void checkValue(T rating) {
        // Determine the number of selected icons vs. unselected ones
        rating.setSelectedRatingIcon(IconType.FAVORITE);
        rating.setUnselectedRatingIcon(IconType.FAVORITE_BORDER);
        checkRatingUpdate(3, rating.getMaxRating(), rating); // Update on value(3) , maxrating(default - 5)
        // Check value and max rating combination to check whether designated icons are applied
        checkRatingUpdate(5, 5, rating);
        checkRatingUpdate(5, 10, rating);
    }

    protected void checkRatingUpdate(Integer value, int maxRating, MaterialRating rating) {
        rating.setMaxRating(maxRating);
        rating.setValue(value);
        assertEquals(rating.getMaxRating(), maxRating);
        assertEquals(rating.getValue(), value);
        for (Widget w : rating) {
            assertTrue(w instanceof MaterialIcon);
            MaterialIcon icon = (MaterialIcon) w;
            if (rating.getWidgetIndex(w) < value) {
                assertEquals(icon.getIconType(), IconType.FAVORITE);
                assertTrue(icon.getElement().hasClassName(AddinsCssName.MATERIAL_RATING_SELECTED));
            } else {
                assertEquals(icon.getIconType(), IconType.FAVORITE_BORDER);
                assertTrue(icon.getElement().hasClassName(AddinsCssName.MATERIAL_RATING_UNSELECTED));
            }
        }
    }

    protected <T extends MaterialRating> void checkStructure(T rating) {
        final int MAX_RATING = rating.getMaxRating();
        assertEquals(MAX_RATING, 5);
        IconType selectedIcon = rating.getSelectedRatingIcon();
        IconType unselectedIcon = rating.getUnselectedRatingIcon();

        assertEquals(selectedIcon, IconType.STAR);
        assertEquals(unselectedIcon, IconType.STAR_BORDER);

        assertEquals(rating.getWidgetCount(), MAX_RATING);
        for (Widget w : rating) {
            assertTrue(w instanceof MaterialIcon);
            MaterialIcon icon = (MaterialIcon) w;
            assertEquals(icon.getIconType(), IconType.STAR_BORDER);
        }
    }
}
