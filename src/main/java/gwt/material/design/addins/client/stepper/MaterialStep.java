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
package gwt.material.design.addins.client.stepper;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.stepper.constants.State;
import gwt.material.design.client.base.*;
import gwt.material.design.client.base.mixin.ActiveMixin;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.html.Div;

//@formatter:off

/**
 * Material Step is a child element of Material Stepper, sometimes called Stepper Item, used to indicate the active
 * inactive items on the Stepper Component.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 *   <ma:stepper.MaterialStep step="1" title="Name of Step 1">
 *       <m:MaterialPanel width="100%" height="300px" backgroundColor="grey lighten-2"/>
 *       <m:MaterialButton ui:field="btnContinue1" text="Continue to Step 2" grid="l4" marginTop="12" backgroundColor="blue" textColor="white" waves="DEFAULT"/>
 *       <m:MaterialButton ui:field="btnPrev1" text="Cancel" grid="l4" marginTop="12" type="FLAT" waves="DEFAULT"/>
 *   </ma:stepper.MaterialStep>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#steppers">Material Steppers</a>
 * @see <a href="https://material.io/guidelines/components/steppers.html">Material Design Specification</a>
 */
// @formatter:on
public class MaterialStep extends MaterialWidget implements HasActive, HasTitle, HasError, HasAxis,
        HasSelectionHandlers<MaterialStep> {

    private int step;
    private String title;
    private String description = "";
    private Div conCircle = new Div();
    private Div conBody = new Div();
    private Div divCircle = new Div();
    private Div divLine = new Div();
    private Div divTitle = new Div();
    private Div divDescription = new Div();
    private Div divBody = new Div();
    private MaterialIcon iconError = new MaterialIcon(IconType.REPORT_PROBLEM);
    private MaterialIcon iconSuccess = new MaterialIcon(IconType.CHECK_CIRCLE);
    private ActiveMixin<MaterialStep> activeMixin;
    private Axis axis = Axis.HORIZONTAL;
    private State state;

    public MaterialStep() {
        super(Document.get().createDivElement(), AddinsCssName.STEP);

        super.add(conCircle);
        conCircle.add(divCircle);
        conCircle.add(divLine);

        super.add(conBody);
        conBody.add(divTitle);
        conBody.add(divBody);

        divCircle.setStyleName(CssName.CIRCLE);
        divLine.setStyleName(AddinsCssName.LINE);
        divTitle.setStyleName(CssName.TITLE);
        divBody.setStyleName(AddinsCssName.BODY);
    }

    public MaterialStep(String title, String description) {
        this();
        setTitle(title);
        setDescription(description);
    }

    public MaterialStep(String title, String description, Integer step) {
        this(title, description);
        setStep(step);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        ClickHandler handler = event -> {
            if (isEnabled() && isVisible()) {
                SelectionEvent.fire(MaterialStep.this, MaterialStep.this);
            }
        };
        registerHandler(conCircle.addClickHandler(handler));
        registerHandler(divTitle.addClickHandler(handler));
        registerHandler(divDescription.addClickHandler(handler));
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
        divCircle.getElement().setInnerSafeHtml(SafeHtmlUtils.fromString(String.valueOf(step)));
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
        divTitle.getElement().setInnerSafeHtml(SafeHtmlUtils.fromString(title));
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
        divDescription.setStyleName(AddinsCssName.DESCRIPTION);
        divDescription.getElement().setInnerSafeHtml(SafeHtmlUtils.fromString(description));
        conBody.insert(divDescription, 1);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void setActive(boolean active) {
        getActiveMixin().setActive(active);
    }

    @Override
    public boolean isActive() {
        return getActiveMixin().isActive();
    }

    @Override
    public void setError(String error) {
        removeStyleName(AddinsCssName.SUCCESS);
        addStyleName(AddinsCssName.ERROR);
        applyIconStatus(iconError, error);
        state = State.ERROR;
    }

    @Override
    public void setSuccess(String success) {
        removeStyleName(AddinsCssName.ERROR);
        addStyleName(AddinsCssName.SUCCESS);
        applyIconStatus(iconSuccess, success);
        state = State.SUCCESS;
    }

    @Override
    public void setHelperText(String helperText) {
        setDescription(helperText);
    }

    public State getState() {
        return state;
    }

    @Override
    public void clearErrorOrSuccess() {
        iconError.removeFromParent();
        iconSuccess.removeFromParent();
        conCircle.insert(divCircle, 0);
        removeStyleName(AddinsCssName.ERROR);
        removeStyleName(AddinsCssName.SUCCESS);
    }

    protected void applyIconStatus(MaterialIcon icon, String description) {
        iconError.removeFromParent();
        iconSuccess.removeFromParent();
        divCircle.removeFromParent();
        conCircle.insert(icon, 0);
        if (description != null) {
            divDescription.getElement().setInnerSafeHtml(SafeHtmlUtils.fromString(description));
        }
    }

    /**
     * Will set the distance width of the step line from another step.
     */
    public void setLineDistanceWidth(int lineDistanceWidth) {
        if (divLine.isAttached()) {
            divLine.setWidth(lineDistanceWidth + "px");
        } else {
            divLine.addAttachHandler(event -> divLine.setWidth(lineDistanceWidth + "px"));
        }
    }

    public Div getConCircle() {
        return conCircle;
    }

    public Div getConBody() {
        return conBody;
    }

    public Div getDivCircle() {
        return divCircle;
    }

    public Div getDivLine() {
        return divLine;
    }

    public Div getDivTitle() {
        return divTitle;
    }

    public Div getDivDescription() {
        return divDescription;
    }

    public Div getDivBody() {
        return divBody;
    }

    @Override
    public void setAxis(Axis axis) {
        if (axis == null) {
            axis = Axis.HORIZONTAL;
        }
        this.axis = axis;
        switch (axis) {
            case HORIZONTAL:
                conCircle.add(divTitle);
                conCircle.add(divLine);
                conCircle.add(divDescription);
                break;
            case VERTICAL:
                conBody.insert(divTitle, 0);
                conBody.insert(divDescription, 1);
                conCircle.add(divLine);

                break;
        }
    }

    @Override
    public Axis getAxis() {
        return axis;
    }

    public MaterialIcon getIconError() {
        return iconError;
    }

    public MaterialIcon getIconSuccess() {
        return iconSuccess;
    }

    protected ActiveMixin<MaterialStep> getActiveMixin() {
        if (activeMixin == null) {
            activeMixin = new ActiveMixin<>(this);
        }
        return activeMixin;
    }

    @Override
    public HandlerRegistration addSelectionHandler(final SelectionHandler<MaterialStep> handler) {
        return this.addHandler(new SelectionHandler<MaterialStep>() {
            @Override
            public void onSelection(SelectionEvent<MaterialStep> event) {
                if (isEnabled()) {
                    handler.onSelection(event);
                }
            }
        }, SelectionEvent.getType());
    }
}