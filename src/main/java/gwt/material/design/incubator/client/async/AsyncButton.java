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
package gwt.material.design.incubator.client.async;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

public class AsyncButton extends AbstractAsyncButton {

    public AsyncButton() {
        super(IncubatorCssName.ASYNC_BUTTON);

        setType(ButtonType.RAISED);
    }

    @Override
    public void loading(String message) {
        super.loading(message);
        setText(message);
    }

    @Override
    public void success(String message) {
        super.success(message);
        setText(message);
    }

    @Override
    public void error(String message) {
        super.error(message);
        setText(message);
    }

    @Override
    protected Element createElement() {
        return Document.get().createPushButtonElement();
    }
}
