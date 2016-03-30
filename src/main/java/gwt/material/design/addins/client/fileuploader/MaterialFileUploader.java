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
    private int maxFileSize;
    private boolean autoQueue = true;

    public MaterialFileUploader() {
        super(Document.get().createDivElement());
        setStyleName("fileuploader");
        setId("zdrop");
        add(new MaterialUploadPreview());
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initDropzone();
    }

    public void initDropzone() {
        initDropzone(getElement(), getUrl(), getMaxFileSize(), isAutoQueue());
    }

    /**
     * Intialize the dropzone component with element and form url to provide a
     * dnd feature for the file upload
     * @param e
     * @param url
     */
    private native void initDropzone(Element e, String url, int maxFileSize, boolean autoQueue) /*-{
        $wnd.jQuery(document).ready(function() {
            var previewNode = $wnd.jQuery("#zdrop-template");
            var previewContainer = $wnd.jQuery("#previews").html();
            previewNode.id = "";
            var previewTemplate = previewNode.parent().html();

            var totalFiles = 0;

            var zdrop = new $wnd.Dropzone("#zdrop", {
                url: url,
                maxFilesize:20,
                previewTemplate: previewTemplate,
                autoQueue: true,
                previewsContainer: "#previews",
                clickable: "#upload-label"
            });

            zdrop.on("addedfile", function(file) {
                totalFiles += 1;
                $wnd.jQuery('.preview-container').css('visibility', 'visible');
                $wnd.jQuery('#no-uploaded-files').html('Uploaded files ' + totalFiles);
            });

            zdrop.on("removedfile", function(file) {
                totalFiles -= 1;
                $wnd.jQuery('#no-uploaded-files').html('Uploaded files ' + totalFiles);
            });

            zdrop.on("totaluploadprogress", function (progress) {
                var progr = document.querySelector(".progress .determinate");
                if (progr === undefined || progr === null)
                    return;

                progr.style.width = progress + "%";
            });

            zdrop.on('dragenter', function () {
                $wnd.jQuery('.fileuploader').addClass("active");
            });

            zdrop.on('dragleave', function () {
                $wnd.jQuery('.fileuploader').removeClass("active");
            });

            zdrop.on('drop', function () {
                $wnd.jQuery('.fileuploader').removeClass("active");
            });

            zdrop.on('error', function (file, error) {

            });
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

    /**
     * Get the maximum file size value of the uploader
     * @return
     */
    public int getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * Set the maximum file size of the uploader
     * @param maxFileSize
     */
    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    /**
     * Check whether it's auto queue or not
     * @return
     */
    public boolean isAutoQueue() {
        return autoQueue;
    }

    /**
     * Set the auto queue boolean value
     * @param autoQueue
     */
    public void setAutoQueue(boolean autoQueue) {
        this.autoQueue = autoQueue;
    }

}
