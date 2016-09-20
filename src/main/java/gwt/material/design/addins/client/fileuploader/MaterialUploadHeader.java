/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.fileuploader;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.html.Span;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class MaterialUploadHeader extends MaterialWidget {

    private Span uploadedFiles = new Span();
    private MaterialIcon iconClose = new MaterialIcon(IconType.CLOSE);
    private MaterialIcon iconColaps = new MaterialIcon(IconType.KEYBOARD_ARROW_DOWN);
    private MaterialUploadPreview preview;
    private boolean toggle = true;

    public MaterialUploadHeader() {
        super(Document.get().createDivElement(), AddinsCssName.HEADER);
        iconClose.setId(AddinsCssName.UPLOAD_CLOSE);
        iconClose.setCircle(true);
        iconClose.setWaves(WavesType.DEFAULT);
        iconClose.addClickHandler(clickEvent -> preview.setVisibility(Style.Visibility.HIDDEN));
        iconColaps.setId(AddinsCssName.UPLOAD_COLAPS);
        iconColaps.setCircle(true);
        iconColaps.setWaves(WavesType.DEFAULT);
        uploadedFiles.setId(AddinsCssName.NO_UPLOADED_FILES);
        add(uploadedFiles);
        add(iconClose);
        add(iconColaps);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initUploadHeader(iconClose.getElement(),
                iconColaps.getElement(),
                getPreview().getElement(),
                getPreview().getUploadCollection().getElement());
    }

    protected void initUploadHeader(Element iconClose, Element iconColaps, Element preview, Element collection) {
        $(iconColaps).click(e -> {
            if (toggle) {
                $(collection).css("visibility", "hidden");
                $(iconColaps).html("keyboard_arrow_up");
                $(collection).css("height", "0px");
                toggle = false;
            } else {
                $(collection).css("visibility", "visible");
                $(iconColaps).html("keyboard_arrow_down");
                $(collection).css("height", "initial");
                toggle = true;
            }
            return true;
        });
    }

    public MaterialUploadPreview getPreview() {
        return preview;
    }

    public void setPreview(MaterialUploadPreview preview) {
        this.preview = preview;
    }

    public Span getUploadedFiles() {
        return uploadedFiles;
    }
}
