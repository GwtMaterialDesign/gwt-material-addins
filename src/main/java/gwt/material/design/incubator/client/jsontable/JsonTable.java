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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.HasType;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.CssTypeMixin;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.jsontable.constants.JsonTableType;
import gwt.material.design.incubator.client.jsontable.js.JsTable;
import gwt.material.design.incubator.client.jsontable.js.JsTableOptions;
import gwt.material.design.jquery.client.api.JQueryElement;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * A widget that provides an easy way to load JSON values and display in a Table component.
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
public class JsonTable extends MaterialWidget implements HasSelectionHandlers<Element>, HasType<JsonTableType>, JsLoader {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesign.injectJs(JsonTableClientDebugBundle.INSTANCE.jsonTableDebugJs());
            MaterialDesign.injectCss(JsonTableClientDebugBundle.INSTANCE.jsonTableDebugCss());
        } else {
            MaterialDesign.injectJs(JsonTableClientBundle.INSTANCE.jsonTableJs());
            MaterialDesign.injectCss(JsonTableClientBundle.INSTANCE.jsonTableCss());
        }
    }

    private JSONValue value;
    private JsTableOptions options = JsTableOptions.create();
    private CssTypeMixin<JsonTableType, JsonTable> typeMixin;

    public JsonTable() {
        super(Document.get().createDivElement(), IncubatorCssName.JSON_TABLE);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        if (value != null) {
            setId(DOM.createUniqueId());
            options.id = "#" + getId();

            JsTable.jsontotable(value, options);

            $("tr").mousedown((e, handler) -> {
                SelectionEvent.fire(JsonTable.this, $(e.target).parent().asElement());
                return true;
            });
        }
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        $("tr").off("mousedown");
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    /**
     * Will display or not the thead elements.
     */
    public void setShowHeader(boolean header) {
        options.header = header;
    }

    public boolean isShowHeader() {
        return options.header;
    }

    /**
     * Will get the table element.
     */
    public JQueryElement getTableElement() {
        return $("table");
    }

    public JSONValue getValue() {
        return value;
    }

    /**
     * Will set the value of provided json values.
     */
    public void setValue(JSONValue value) {
        this.value = value;
        reload();
    }

    @Override
    public void setType(JsonTableType type) {
        getTypeMixin().setType(type);
    }

    @Override
    public JsonTableType getType() {
        return getTypeMixin().getType();
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<Element> selectionHandler) {
        return addHandler(selectionHandler, SelectionEvent.getType());
    }

    public CssTypeMixin<JsonTableType, JsonTable> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin<>(this);
        }
        return typeMixin;
    }
}
