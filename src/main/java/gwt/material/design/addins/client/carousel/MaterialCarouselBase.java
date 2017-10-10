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
package gwt.material.design.addins.client.carousel;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialPanel;

/**
 * Base class for MaterialCarousel
 *
 * @author kevzlou7979
 */
public class MaterialCarouselBase extends MaterialWidget {

    public MaterialCarouselBase() {
        super(Document.get().createDivElement(), AddinsCssName.MATERIAL_CAROUSEL);
    }

    private MaterialPanel container = new MaterialPanel();
    private MaterialButton btnNextArrow = new MaterialButton();
    private MaterialButton btnPrevArrow = new MaterialButton();
    private MaterialPanel wrapper = new MaterialPanel();

    @Override
    protected void onLoad() {
        String uid = DOM.createUniqueId();

        btnNextArrow.setIconType(IconType.KEYBOARD_ARROW_RIGHT);
        btnNextArrow.setType(ButtonType.FLOATING);
        btnNextArrow.setWaves(WavesType.DEFAULT);
        btnNextArrow.setText("Next");
        btnNextArrow.addStyleName(AddinsCssName.CAROUSEL_NEXT_ARROW);
        btnNextArrow.setId(uid + "-next-arrow");

        btnPrevArrow.setIconType(IconType.KEYBOARD_ARROW_LEFT);
        btnPrevArrow.setType(ButtonType.FLOATING);
        btnPrevArrow.setWaves(WavesType.DEFAULT);
        btnPrevArrow.setText("Previous");
        btnPrevArrow.addStyleName(AddinsCssName.CAROUSEL_PREV_ARROW);
        btnPrevArrow.setId(uid + "-prev-arrow");

        super.add(btnNextArrow);
        super.add(btnPrevArrow);

        wrapper.setStyleName(AddinsCssName.MATERIAL_CAROUSEL_CONTAINER);
        container.setId(uid + "-container");
        wrapper.add(container);
        super.add(wrapper);

        super.onLoad();
    }

    public MaterialPanel getWrapper() {
        return wrapper;
    }

    public MaterialPanel getContainer() {
        return container;
    }

    public MaterialButton getBtnNextArrow() {
        return btnNextArrow;
    }

    public MaterialButton getBtnPrevArrow() {
        return btnPrevArrow;
    }
}
