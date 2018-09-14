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
package gwt.material.design.incubator.client.question.base;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.constants.ProgressType;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialProgress;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

import java.util.ArrayList;
import java.util.List;

public class QuestionProgress extends MaterialWidget {

    private List<QuestionItem> questions = new ArrayList<>();
    private MaterialLabel totalLabel = new MaterialLabel();
    private MaterialProgress progress = new MaterialProgress();

    public QuestionProgress() {
        super(Document.get().createDivElement(), IncubatorCssName.QUESTION_PROGRESS);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        totalLabel.setHideOn(HideOn.HIDE_ON_SMALL_DOWN);
        add(totalLabel);

        progress.setPercent(50);
        progress.setType(ProgressType.DETERMINATE);
        add(progress);

        reset();
    }

    public void setQuestions(List<QuestionItem> questions) {
        this.questions = questions;
    }

    public void updateProgress(List<QuestionItem> answeredQuestions) {
        totalLabel.setText(answeredQuestions.size() + " of " + questions.size());
        progress.setPercent(((float)answeredQuestions.size() / (float)questions.size()) * 100);
    }

    public void reset() {
        updateProgress(new ArrayList<>());
        progress.setPercent(0);
    }
}
