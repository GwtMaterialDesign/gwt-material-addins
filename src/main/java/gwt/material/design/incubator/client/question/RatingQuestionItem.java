/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.question;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.question.base.QuestionItem;
import gwt.material.design.incubator.client.question.base.constants.Rating;
import gwt.material.design.incubator.client.toggle.GroupToggleButton;
import gwt.material.design.incubator.client.toggle.ToggleButton;

import java.util.ArrayList;
import java.util.List;


public class RatingQuestionItem extends QuestionItem<Rating> {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesign.injectCss(RatingQuestionDebugClientBundle.INSTANCE.questionItemDebugCss());
        } else {
            MaterialDesign.injectCss(RatingQuestionClientBundle.INSTANCE.questionItemCss());
        }
    }

    private boolean required;
    private MaterialPanel labelPanel = new MaterialPanel();
    private MaterialLabel lowLabel = new MaterialLabel();
    private MaterialLabel highLabel = new MaterialLabel();
    private GroupToggleButton<Rating> groupToggleButton = new GroupToggleButton<>();

    public RatingQuestionItem() {
        super();
        setRequired(true);
    }

    @Override
    protected void load() {
        labelPanel.setInitialClasses(IncubatorCssName.LABEL_PANEL);

        labelPanel.add(lowLabel);
        labelPanel.add(highLabel);
        getWrapper().add(labelPanel);
        groupToggleButton.setMarginTop(0);

        for (Rating rating : getRatingOptions()) {
            ToggleButton button = groupToggleButton.addItem(String.valueOf(rating.getValue()), rating);
            button.setTooltip(rating.getName());
            button.setWidth(100 / getRatingOptions().size() + "%");
        }

        groupToggleButton.addSelectionHandler(selectionEvent -> {
            setValue(groupToggleButton.getSingleValue(), true);
            validate();
        });
        getWrapper().add(groupToggleButton);
    }

    protected List<Rating> getRatingOptions() {
        List<Rating> ratings = new ArrayList<>();
        ratings.add(Rating.POOR);
        ratings.add(Rating.FAIR);
        ratings.add(Rating.NEUTRAL);
        ratings.add(Rating.GOOD);
        ratings.add(Rating.EXCELLENT);
        return ratings;
    }

    public void setLowLabel(String lowLabel) {
        this.lowLabel.setText(lowLabel);
    }

    public void setHighLabel(String highLabel) {
        this.highLabel.setText(highLabel);
    }

    public MaterialPanel getLabelPanel() {
        return labelPanel;
    }

    public MaterialLabel getLowLabel() {
        return lowLabel;
    }

    public MaterialLabel getHighLabel() {
        return highLabel;
    }

    @Override
    public void reset() {
        super.reset();

        groupToggleButton.reset();
    }

    @Override
    public boolean validate() {
        if (getValue() == Rating.NONE && isRequired()) {
            setError("Please select at least one option.");
            return false;
        }
        return super.validate();
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
