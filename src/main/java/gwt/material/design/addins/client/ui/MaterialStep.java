package gwt.material.design.addins.client.ui;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.mixin.ActiveMixin;
import gwt.material.design.client.base.ComplexWidget;
import gwt.material.design.client.base.HasActive;
import gwt.material.design.client.base.HasError;
import gwt.material.design.client.base.HasTitle;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.html.Div;

//@formatter:off

/**
 * Material Step is a child element of Material Stepper, sometimes called Stepper Item, used to indicate the active
 * inactive items on the Stepper Component.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:m.addins='urn:import:gwt.material.design.addins.client.ui'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 *
 * <pre>
 * {@code
 *   <m.addins:MaterialStep step="1" title="Name of Step 1">
 *       <m.addins:MaterialPanel width="100%" height="300px" backgroundColor="grey lighten-2"/>
 *       <m.addins:MaterialButton ui:field="btnContinue1" text="Continue to Step 2" grid="l4" marginTop="12" backgroundColor="blue" textColor="white" waves="DEFAULT"/>
 *       <m.addins:MaterialButton ui:field="btnPrev1" text="Cancel" grid="l4" marginTop="12" type="FLAT" waves="DEFAULT"/>
 *   </m.addins:MaterialStep>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#steppers">Material Steppers</a>
 */
// @formatter:on
public class MaterialStep extends ComplexWidget implements HasActive, HasTitle, HasError, HasClickHandlers {

    private int step;
    private String title;
    private String description;

    // containers
    private Div conCircle = new Div();
    private Div conBody = new Div();

    // elements
    private Div divCircle = new Div();
    private Div divLine = new Div();
    private Div divTitle = new Div();
    private Div divDescription = new Div();
    private Div divBody = new Div();

    private MaterialIcon iconError = new MaterialIcon(IconType.REPORT_PROBLEM);
    private MaterialIcon iconSuccess = new MaterialIcon(IconType.CHECK_CIRCLE);
    private final ActiveMixin<MaterialStep> activeMixin = new ActiveMixin<>(this);
    private MaterialStepper stepper;

    public MaterialStep() {
        super(Document.get().createDivElement());
        setStyleName("step");

        super.add(conCircle);
        conCircle.add(divCircle);
        conCircle.add(divLine);

        super.add(conBody);
        conBody.add(divTitle);
        conBody.add(divBody);

        divCircle.setStyleName("circle");
        divLine.setStyleName("line");
        divTitle.setStyleName("title");
        divBody.setStyleName("body");
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if(getParent() instanceof MaterialStepper){
            stepper = (MaterialStepper) getParent();
            if(stepper.getAxis() == Axis.HORIZONTAL){
                conCircle.add(divTitle);
                conCircle.add(divLine);
                conCircle.add(divDescription);
            }else{
                conBody.insert(divTitle, 0);
                conCircle.add(divLine);
            }

        }
        conCircle.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                stepper.goToStep(step);
            }
        });
    }

    @Override
    public void add(Widget child) {
        divBody.add(child);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
        divCircle.getElement().setInnerHTML(String.valueOf(step));
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
        divTitle.getElement().setInnerHTML(title);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
        divDescription.setStyleName("description");
        divDescription.getElement().setInnerHTML(description);
        conBody.insert(divDescription, 1);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void setActive(boolean active) {
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    public void setError(String error) {
        removeStyleName("success");
        addStyleName("error");
        applyIconStatus(iconError, "red", error);
    }

    @Override
    public void setSuccess(String success) {
        removeStyleName("error");
        addStyleName("success");
        applyIconStatus(iconSuccess, "blue", success);
    }

    @Override
    public void clearErrorOrSuccess() {
        iconError.removeFromParent();
        iconSuccess.removeFromParent();
        conCircle.insert(divCircle, 0);
        removeStyleName("error");
        removeStyleName("success");
    }


    private void applyIconStatus(MaterialIcon icon, String color, String description){
        iconError.removeFromParent();
        iconSuccess.removeFromParent();
        divCircle.removeFromParent();
        conCircle.insert(icon, 0);
        divDescription.getElement().setInnerHTML(description);
    }

    public Div getDivBody() {
        return divBody;
    }

    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return divCircle.addDomHandler(handler, ClickEvent.getType());
    }
}
