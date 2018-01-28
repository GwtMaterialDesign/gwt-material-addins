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
package gwt.material.design.incubator.client.jsontable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONValue;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.jsontable.js.JsTable;
import gwt.material.design.incubator.client.jsontable.js.JsTableOptions;
import gwt.material.design.jquery.client.api.JQueryElement;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class JsonTable extends MaterialWidget implements HasSelectionHandlers<Element> {

    static {
        MaterialDesign.injectJs(JsonTableClientBundle.INSTANCE.jsonTableJs());
    }

    private JsTableOptions options = new JsTableOptions();

    public JsonTable() {
        super(Document.get().createDivElement(), "json-table");
    }

    public void loadJson(JSONValue value) {
        setId("test");
        options.header = true;
        options.id = "#test";
        JsTable.jsontotable(value, options);
        $("table").addClass("striped");

        $("tr").mousedown((e, handler) -> {
            SelectionEvent.fire(JsonTable.this, $(e.target).parent().asElement());
            return true;
        });
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<Element> selectionHandler) {
        return addHandler(selectionHandler, SelectionEvent.getType());
    }
}
