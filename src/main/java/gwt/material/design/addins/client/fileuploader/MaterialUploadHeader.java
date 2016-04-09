package gwt.material.design.addins.client.fileuploader;

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


import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.html.Span;

public class MaterialUploadHeader extends MaterialWidget {

    private Span uploadedFiles = new Span();
    private MaterialIcon iconClose = new MaterialIcon(IconType.CLOSE);
    private MaterialIcon iconColaps = new MaterialIcon(IconType.KEYBOARD_ARROW_DOWN);
    private MaterialUploadPreview preview;

    public MaterialUploadHeader() {
        super(Document.get().createDivElement());
        setStyleName("header");
        iconClose.setId("upload-close");
        iconColaps.setId("upload-colaps");
        uploadedFiles.setId("no-uploaded-files");
        add(uploadedFiles);
        add(iconClose);
        add(iconColaps);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initUploadHeader(iconClose.getElement(), iconColaps.getElement(), getPreview().getElement(), getPreview().getUploadCollection().getElement());
    }

    private native void initUploadHeader(Element iconClose, Element iconColaps, Element preview, Element collection) /*-{
        var toggle = true;

        $wnd.jQuery(iconColaps).click(function() {
            if(toggle){
                $wnd.jQuery(collection).css('visibility', 'hidden');
                $wnd.jQuery(iconColaps).html("keyboard_arrow_up");
                $wnd.jQuery(collection).css('height', '0px');
                toggle = false;
            }else{
                $wnd.jQuery(collection).css('visibility', 'visible');
                $wnd.jQuery(iconColaps).html("keyboard_arrow_down");
                $wnd.jQuery(collection).css('height', 'initial');
                toggle = true;
            }
        });

        $wnd.jQuery(iconClose).click(function() {
            $wnd.jQuery(preview).css('visibility', 'hidden');
        });
    }-*/;

    public MaterialUploadPreview getPreview() {
        return preview;
    }

    public void setPreview(MaterialUploadPreview preview) {
        this.preview = preview;
    }
}
