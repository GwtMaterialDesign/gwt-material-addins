package gwt.material.design.addins.client.base.mixin;

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

import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.base.HasActive;
import gwt.material.design.client.base.HasTitle;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.html.Span;

public class TitleMixin<T extends UIObject & HasTitle> extends AbstractMixin<T> implements HasTitle {

    private Span titleElem = new Span();
    private Span descElem = new Span();

   public TitleMixin(final T widget) {
       super(widget);
       ((MaterialWidget)widget).add(titleElem);
       ((MaterialWidget)widget).add(descElem);
    }

    @Override
    public void setTitle(String title) {
        titleElem.setText(title);
    }

    @Override
    public void setDescription(String description) {
        titleElem.setStyleName("title");
        descElem.setText(description);
    }
}
