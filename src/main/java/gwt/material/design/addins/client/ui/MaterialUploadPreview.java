package gwt.material.design.addins.client.ui;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialCollection;

/**
 * Created by Mark Kevin on 3/26/2016.
 */
public class MaterialUploadPreview extends MaterialWidget {

    private MaterialCollection collection = new MaterialCollection();

    public MaterialUploadPreview() {
        super(Document.get().createDivElement());
        setStyleName("preview-container");
        collection.setId("previews");
        add(new MaterialUploadHeader());
        add(new MaterialUploadCollection());
    }
}
