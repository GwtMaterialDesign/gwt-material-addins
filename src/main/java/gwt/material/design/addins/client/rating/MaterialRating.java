package gwt.material.design.addins.client.rating;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2016 GwtMaterialDesign
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

import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasValue;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * MaterialRating is the component used by the 5-star rating system, for
 * example, allowing users to easily express their opinion about a product,
 * review, video and so on.
 * </p>
 * <p>
 * By default, it uses the {@link IconType#STAR} to represent the selected
 * rating, but other icons can be set using the
 * {@link #setSelectedRatingIcon(IconType)} method.
 * </p>
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <p>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p>
 * <pre>
 * {@code
 * <ma:rating.MaterialRating ui:field="rating" />
 * }
 * </pre>
 * <p>
 * To use different icons, for instance, hearts, you can set:
 * <p>
 * <pre>
 * {@code
 * <ma:rating.MaterialRating ui:field="rating" selectedRatingIcon="FAVORITE" unselectedRatingIcon="FAVORITE_BORDER" textColor="red" />
 * }
 * </pre>
 * <p>
 * You can also set the maximum rating (the default is 5):
 * <p>
 * <pre>
 * {@code
 * <ma:rating.MaterialRating ui:field="rating" maxRating="7" />
 * }
 * </pre>
 * <p>
 * <h3>Example Java Usage:</h3>
 * <p>
 * <pre>
 * {@code
 * MaterialRating rating = ... //create using new or using UiBinder
 * rating.addValueChangeHandler(...); // MaterialRating implements HasValue<Integer>
 * rating.setEditable(false); // disables user interaction
 * rating.setValue(2); // directly sets the desired rating
 * int selectedValue = rating.getValue(); // retrieves the selected rating
 * }
 * </pre>
 * <p>
 * <h3>Custom styling:</h3>
 * <p>
 * You use change the MaterialRating style by using the
 * <code>material-rating</code> CSS class. Selected rating icons have the
 * <code>material-rating-selected</code> CSS class, and unselected the
 * <code>material-rating-unselected</code> CSS class.
 * </p>
 *
 * @author gilberto-torrezan
 */
public class MaterialRating extends MaterialWidget implements HasValue<Integer> {

    private boolean editable = true;
    private int currentRating = 0;
    private int maxRating = 5;
    private IconType selectedRatingIcon = IconType.STAR;
    private IconType unselectedRatingIcon = IconType.STAR_BORDER;
    private List<MaterialIcon> iconList = new LinkedList<>();

    /**
     * Default constructor.
     */
    public MaterialRating() {
        super(DOM.createDiv(), AddinsCssName.MATERIAL_RATING);
        revalidateLayout();
    }

    public MaterialRating(IconType selectedRatingIcon, IconType unselectedRatingIcon, Color textColor) {
        this();
        setSelectedRatingIcon(selectedRatingIcon);
        setUnselectedRatingIcon(unselectedRatingIcon);
    }

    public MaterialRating(IconType selectedRatingIcon, IconType unselectedRatingIcon, Color textColor, Integer value) {
        this(selectedRatingIcon, unselectedRatingIcon, textColor);
        setValue(value);
    }

    public MaterialRating(IconType selectedRatingIcon, IconType unselectedRatingIcon, Color textColor, Integer value, Integer maxRating) {
        this(selectedRatingIcon, unselectedRatingIcon, textColor, value);
        setMaxRating(maxRating);
    }

    /**
     * Sets the maximum number of icons to show - which represents the maximum
     * selectable rating. The default is 5.
     *
     * @param maxRating The maximum selectable rating for this component
     */
    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
        revalidateLayout();
    }

    /**
     * Returns the maximum selectable rating in this component.
     * The default is 5.
     *
     * @return The maximum rating
     */
    public int getMaxRating() {
        return maxRating;
    }

    /**
     * Sets the {@link IconType} to be used to represent the selected ratings.
     * The default is {@link IconType#STAR}.
     *
     * @param selectedRatingIcon The icon of the selected ratings
     */
    public void setSelectedRatingIcon(IconType selectedRatingIcon) {
        this.selectedRatingIcon = selectedRatingIcon;
        revalidateLayout();
    }

    /**
     * Returns the {@link IconType} used to represent the selected ratings. The
     * default is {@link IconType#STAR}.
     *
     * @return The icon for selected ratings
     */
    public IconType getSelectedRatingIcon() {
        return selectedRatingIcon;
    }

    /**
     * Sets the {@link IconType} to be used to represent the not selected
     * ratings. The default is {@link IconType#STAR_BORDER}.
     *
     * @param unselectedRatingIcon The icon of the unselected ratings
     */
    public void setUnselectedRatingIcon(IconType unselectedRatingIcon) {
        this.unselectedRatingIcon = unselectedRatingIcon;
        revalidateLayout();
    }

    /**
     * Returns the {@link IconType} used to represent the not selected ratings.
     * The default is {@link IconType#STAR_BORDER}.
     *
     * @return The icon for unselected ratings
     */
    public IconType getUnselectedRatingIcon() {
        return unselectedRatingIcon;
    }

    @Override
    public void clear() {
        iconList.clear();
        super.clear();
    }

    /**
     * Method called internally by the component to re-validate the number of
     * icons when the maximum rating is changed.
     */
    protected void revalidateLayout() {
        for (MaterialIcon icon : iconList) {
            icon.removeFromParent();
        }
        iconList.clear();

        // same mouse-out handler for all icons
        MouseOutHandler outHandler = event -> {
            if (!isEnabled() || !isEditable()) {
                return;
            }
            revalidateSelection(currentRating);
        };

        for (int i = 0; i < maxRating; i++) {
            final int rating = i + 1;
            MaterialIcon icon = new MaterialIcon(unselectedRatingIcon);
            icon.addClickHandler(event -> {
                if (!isEnabled() || !isEditable()) {
                    return;
                }
                setValue(rating, true);
            });
            icon.addMouseOverHandler(event -> {
                if (!isEnabled() || !isEditable()) {
                    return;
                }
                revalidateSelection(rating);
            });
            icon.addMouseOutHandler(outHandler);
            add(icon);
            iconList.add(icon);
        }
        revalidateSelection(currentRating);
    }

    /**
     * Method called internally by the component to revalidade selections by the
     * user, switching the icons accordingly.
     */
    protected void revalidateSelection(int rating) {
        for (MaterialIcon icon : iconList) {
            icon.removeStyleName(AddinsCssName.MATERIAL_RATING_UNSELECTED);
            icon.removeStyleName(AddinsCssName.MATERIAL_RATING_SELECTED);
        }

        for (int i = 0; i < rating && i < iconList.size(); i++) {
            MaterialIcon icon = iconList.get(i);
            icon.setIconType(selectedRatingIcon);
            icon.addStyleName(AddinsCssName.MATERIAL_RATING_SELECTED);
        }

        for (int i = rating; i < iconList.size(); i++) {
            MaterialIcon icon = iconList.get(i);
            icon.setIconType(unselectedRatingIcon);
            icon.addStyleName(AddinsCssName.MATERIAL_RATING_UNSELECTED);
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Integer> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public Integer getValue() {
        return currentRating;
    }

    @Override
    public void setValue(Integer value) {
        setValue(value, false);
    }

    @Override
    public void setValue(Integer value, boolean fireEvents) {
        currentRating = value;
        revalidateSelection(currentRating);
        if (fireEvents) {
            ValueChangeEvent.fire(this, value);
        }
    }

    /**
     * Sets whether the user can interact with the component or not.
     * Non-editable MaterialRatings can only show values, not allowing users to
     * change them. The default is <code>true</code> (editable).
     *
     * @param editable <code>true</code> to allow the user change the state of the component,
     *                 <code>false</code> otherwise.
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * Returns whether the component is editable by the user. The default is
     * <code>true</code> (editable).
     *
     * @return <code>true</code> if the component is editable by the user,
     * <code>false</code> otherwise'
     */
    public boolean isEditable() {
        return editable;
    }
}
