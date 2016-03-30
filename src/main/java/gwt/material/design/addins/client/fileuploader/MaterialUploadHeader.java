package gwt.material.design.addins.client.fileuploader;

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
