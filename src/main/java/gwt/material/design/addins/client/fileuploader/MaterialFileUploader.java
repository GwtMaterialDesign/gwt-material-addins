package gwt.material.design.addins.client.fileuploader;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import gwt.material.design.client.base.MaterialWidget;

//@formatter:off

/**
 * Custom file uploader with Dnd support with the help of dropzone.js. It has multiple
 * feature just like the GWT File Uploader core widget.
 * <pre>
 *{@code
 * <m.addins:MaterialFileUploader url="/file/upload"/>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#fileuploader">File Uploader</a>
 */
//@formatter:on
public class MaterialFileUploader extends MaterialWidget {

    private String url;

    public MaterialFileUploader() {
        super(Document.get().createDivElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initDropzone(getUrl());
    }

    /**
     * Initialize the dropzone component passing with the form url
     * @param url
     */
    public void initDropzone(String url) {
        initDropzone(getElement(), url);
    }

    /**
     * Intialize the dropzone component with element and form url to provide a
     * dnd feature for the file upload
     * @param e
     * @param url
     */
    private native void initDropzone(Element e, String url) /*-{
        $wnd.jQuery(document).ready(function() {
            $wnd.jQuery(e).dropzone({ url: url });
        });
    }-*/;

    /**
     * Get the form url
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the form url e.g /file/post
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
