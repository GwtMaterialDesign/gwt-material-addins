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
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.mixin.ErrorMixin;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

public class QuestionItem<T extends Object> extends AbstractValueWidget<T> {

    private T value;
    private MaterialPanel wrapper = new MaterialPanel();
    private MaterialLabel questionLabel = new MaterialLabel();
    private MaterialLabel errorLabel = new MaterialLabel();

    private ErrorMixin<AbstractValueWidget, MaterialLabel> errorMixin;
    private boolean valid;

    public QuestionItem() {
        super(Document.get().createDivElement(), IncubatorCssName.QUESTION_ITEM);
        setAllowBlank(false);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        wrapper.setInitialClasses(IncubatorCssName.QUESTION_WRAPPER);
        questionLabel.setInitialClasses(IncubatorCssName.QUESTION_LABEL);

        add(questionLabel);
        add(wrapper);

        load();

        wrapper.add(errorLabel);
    }

    protected void load() {
        registerHandler(addValidationChangedHandler(event -> QuestionItem.this.valid = event.isValid()));
    }

    public void setQuestion(String question) {
        questionLabel.setText(question);
    }

    public MaterialPanel getWrapper() {
        return wrapper;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value, boolean fireEvents) {
        this.value = value;
        super.setValue(value, fireEvents);
    }

    @Override
    public ErrorMixin<AbstractValueWidget, MaterialLabel> getErrorMixin() {
        if (errorMixin == null) {
            errorMixin = new ErrorMixin<>(this, errorLabel, this.asWidget());
        }
        return errorMixin;
    }

    public boolean isValid() {
        return valid;
    }

    public void reset() {
        this.value = null;
    }
}
