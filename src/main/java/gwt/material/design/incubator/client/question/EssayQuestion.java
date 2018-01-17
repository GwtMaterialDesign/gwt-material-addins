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

import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.question.base.AbstractQuestion;

public class EssayQuestion extends AbstractQuestion<String> {

    private MaterialTextArea textArea = new MaterialTextArea();

    @Override
    protected void load() {
        addStyleName(IncubatorCssName.ESSAY_QUESTION);
        getWrapper().setMargin(0);
        textArea.setMargin(0);
        getWrapper().add(textArea);
    }

    public MaterialTextArea getTextArea() {
        return textArea;
    }

    public void setPlaceholder(String placeholder) {
        textArea.setPlaceholder(placeholder);
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        textArea.setValue(value, fireEvents);
    }

    @Override
    public void reset() {
        textArea.clear();
    }

    @Override
    public String getValue() {
        return textArea.getValue();
    }
}
