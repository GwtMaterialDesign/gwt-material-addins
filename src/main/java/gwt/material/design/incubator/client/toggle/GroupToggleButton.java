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
package gwt.material.design.incubator.client.toggle;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

//@formatter:off

/**
 * Group Toggle Button - 3 Buttons that grouped together to form
 * a toggling feature.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 *      GroupToggleButton button = new GroupToggleButton();
 *      button.addSelectionHandler(e -> {
 *          // Do something here
 *      });
 * }
 * </pre>
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class GroupToggleButton extends MaterialWidget implements HasSelectionHandlers<Integer> {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(GroupToggleButtonDebugClientBundle.INSTANCE.groupToggleDebugCss());
        } else {
            MaterialDesignBase.injectCss(GroupToggleButtonClientBundle.INSTANCE.groupToggleButtonCss());
        }
    }

    private MaterialLabel firstToggle = new MaterialLabel("1");
    private MaterialLabel secondToggle = new MaterialLabel("2");
    private MaterialLabel thirdToggle = new MaterialLabel("3");

    public GroupToggleButton() {
        super(Document.get().createDivElement(), IncubatorCssName.GROUP_TOGGLE_BUTTON);
    }


    @Override
    protected void onLoad() {
        super.onLoad();

        IncubatorWidget.showWarning(this);
        registerHandler(firstToggle.addClickHandler(clickEvent -> setActive(0)));
        firstToggle.setGrid("s4");
        add(firstToggle);

        registerHandler(secondToggle.addClickHandler(clickEvent -> setActive(1)));
        secondToggle.setGrid("s4");
        add(secondToggle);

        registerHandler(thirdToggle.addClickHandler(clickEvent -> setActive(2)));
        thirdToggle.setGrid("s4");
        add(thirdToggle);
    }

    /**
     * Automatically set the active button with a given index
     */
    public void setActive(int index) {
        SelectionEvent.fire(this, index);
        for (Widget w : getChildren()) {
            w.removeStyleName(CssName.ACTIVE);
        }
        getWidget(index).addStyleName(CssName.ACTIVE);
    }

    /**
     * Set the text for the first / left button
     */
    public void setFirstToggleText(String firstToggleText) {
        firstToggle.setText(firstToggleText);
    }

    /**
     * Set the text for the second / center button
     */
    public void setSecondToggleText(String secondToggleText) {
        secondToggle.setText(secondToggleText);
    }

    /**
     * Set the text for the thirf / right button
     */
    public void setThirdToggleText(String thirdToggleText) {
        thirdToggle.setText(thirdToggleText);
    }

    public MaterialLabel getFirstToggle() {
        return firstToggle;
    }

    public MaterialLabel getSecondToggle() {
        return secondToggle;
    }

    public MaterialLabel getThirdToggle() {
        return thirdToggle;
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<Integer> selectionHandler) {
        return addHandler(selectionHandler, SelectionEvent.getType());
    }
}
