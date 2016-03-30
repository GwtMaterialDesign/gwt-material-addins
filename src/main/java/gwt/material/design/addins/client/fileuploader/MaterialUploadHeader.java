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
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.html.Span;

public class MaterialUploadHeader extends MaterialWidget {

    private Span uploadedFiles = new Span();
    private MaterialIcon iconClose = new MaterialIcon(IconType.CLOSE);
    private MaterialIcon iconColaps = new MaterialIcon(IconType.KEYBOARD_ARROW_DOWN);

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
        initUploadHeader();
    }

    private native void initUploadHeader() /*-{
        var toggle = true;

        $wnd.jQuery('#upload-colaps').click(function() {
            if(toggle){
                $wnd.jQuery('#previews').css('visibility', 'hidden');
                $wnd.jQuery('#upload-colaps').html("keyboard_arrow_up");
                $wnd.jQuery('#previews').css('height', '0px');
                toggle = false;
            }else{
                $wnd.jQuery('#previews').css('visibility', 'visible');
                $wnd.jQuery('#upload-colaps').html("keyboard_arrow_down");
                $wnd.jQuery('#previews').css('height', 'initial');
                toggle = true;
            }
        });

        $wnd.jQuery('#upload-close').click(function() {
            $wnd.jQuery('.preview-container').css('visibility', 'hidden');
        });
    }-*/;
}
