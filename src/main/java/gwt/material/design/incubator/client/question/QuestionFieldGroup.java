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

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ScrollHelper;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.question.base.AbstractQuestion;
import gwt.material.design.incubator.client.question.base.QuestionProgress;

import java.util.ArrayList;
import java.util.List;

public class QuestionFieldGroup extends MaterialWidget {

    private List<AbstractQuestion> questions = new ArrayList<>();
    private List<AbstractQuestion> answeredQuestions = new ArrayList<>();
    private QuestionProgress questionProgress;

    public QuestionFieldGroup() {
        super(Document.get().createFormElement(), IncubatorCssName.QUESTION_FIELD_GROUP);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        questionProgress = new QuestionProgress(questions);

        for (Widget widget : getChildren()) {
            lookForChildren(widget);
        }

        for (AbstractQuestion question : questions) {
            question.addValueChangeHandler(valueChangeEvent -> {
                int index = questions.indexOf(question);
                if (index + 1 < questions.size()) {
                    Widget target = questions.get(index + 1);
                    new ScrollHelper().scrollTo(target);
                }

                updateProgress(question);
            });
        }

        add(questionProgress);
    }

    protected void lookForChildren(Widget parent) {
        if (parent instanceof MaterialWidget) {
            for (Widget widget : ((MaterialWidget) parent).getChildren()) {
                if (widget instanceof AbstractQuestion) {
                    ((AbstractQuestion) widget).setAllowBlank(false);
                    questions.add((AbstractQuestion) widget);
                } else {
                    lookForChildren(widget);
                }
            }
        }
    }

    protected void updateProgress(AbstractQuestion question) {
        if (!answeredQuestions.contains(question)) {
            answeredQuestions.add(question);
            questionProgress.updateProgress(answeredQuestions);
        }
    }

    public List<AbstractQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<AbstractQuestion> questions) {
        this.questions = questions;
    }

    public void showQuestionProgress(boolean visible) {
        questionProgress.setVisible(visible);
    }

    public void reset() {
        for (AbstractQuestion question : questions) {
            question.reset();
        }

        questionProgress.reset();
        answeredQuestions.clear();
    }

    @Override
    public boolean validate() {
        boolean valid = super.validate();

        for (AbstractQuestion question : questions) {
            if (!question.isValid()) {
                new ScrollHelper().scrollTo(question);
                break;
            }
        }

        return valid;
    }
}
