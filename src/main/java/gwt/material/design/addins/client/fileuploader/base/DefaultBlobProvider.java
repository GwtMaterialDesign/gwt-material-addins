package gwt.material.design.addins.client.fileuploader.base;

import gwt.material.design.addins.client.fileuploader.js.File;
import gwt.material.design.addins.client.fileuploader.js.XHR;

import java.util.Date;

public class DefaultBlobProvider implements FileProvider {

    @Override
    public File provide(Object object) {
        String uniqueName = System.currentTimeMillis() + ".jpg";
        File file = new File(new Object[]{object}, uniqueName);
        file.name = uniqueName;
        file.lastModifiedDate = new Date().toString();
        file.xhr = new XHR();
        file.xhr.status = 0;
        file.xhr.statusText = "";
        file.xhr.responseText = "";
        return file;
    }
}
