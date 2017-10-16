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
package gwt.material.design.addins.client.base;

import com.google.gwt.dom.client.Element;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.Options;
import gwt.material.design.jquery.client.api.JQueryElement;

public abstract class MaterialAddinWidget<T extends Options> extends MaterialWidget implements JsLoader {

    protected final T options;

    public MaterialAddinWidget(T options) {
        this.options = options;
    }

    public MaterialAddinWidget(JQueryElement jQueryElement, T options) {
        super(jQueryElement);
        this.options = options;
    }

    public MaterialAddinWidget(Element element, T options) {
        super(element);
        this.options = options;
    }

    public MaterialAddinWidget(Element element, T options, String... initialClass) {
        super(element, initialClass);
        this.options = options;
    }

    @Override
    public void load() {
        options.setAllowWarnings(true);
    }

    public T getOptions() {
        return options;
    }
}
