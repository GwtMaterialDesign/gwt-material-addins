package gwt.material.design.addins.client.ui;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.MaterialWidget;

/**
 * Created by Mark Kevin on 1/29/2016.
 */
public class MaterialTree extends MaterialWidget {

    public MaterialTree() {
        super(Document.get().createDivElement());
        setStyleName("tree");
    }

}

