/*
 * #%L
 * Errai Prototype
 * %%
 * Copyright (C) 2015 - 2017 Doltech
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
package gwt.material.design.addins.client.camera;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.jscore.client.api.file.File;
import gwt.material.design.jscore.client.api.file.FileReader;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class Html5Camera extends AbstractValueWidget<String> {


    private MaterialWidget imageFileInput = new MaterialWidget(Document.get().createFileInputElement());
    private String imageUrl;

    public Html5Camera() {
        super(Document.get().createDivElement());
        setInitialClasses("camera-manual-upload");
    }


    @Override
    protected void onLoad() {
        super.onLoad();
        build();
    }

    @Override
    protected void build() {
        add(imageFileInput);
        imageFileInput.setDataAttribute("accept", "image/*");
        imageFileInput.setDataAttribute("capture", "camera");


        $(imageFileInput.getElement()).on("change", e -> {
            captureToDataURL();
            return true;
        });

        imageFileInput.setVisible(false);
    }

    public void load() {
        $(imageFileInput.getElement()).click();
    }

    protected void captureToDataURL() {
        File file =  toFile(imageFileInput.getElement());

        FileReader reader = new FileReader();
        $(reader).on("load", e -> {
            imageUrl = reader.result;
            ValueChangeEvent.fire(this, imageUrl);
            return true;
        });

        if (file != null) {
            reader.readAsDataURL(file);
        } else {
            GWT.log("Please provide a file before reading the file.", new NullPointerException());
        }
    }

    protected native File toFile(Element inputElement) /*-{
        return $wnd.jQuery(inputElement).prop('files')[0];
    }-*/;

    @Override
    public String getValue() {
        return imageUrl;
    }
}
