package gwt.material.design.addins.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ImageResource;
import gwt.material.design.client.base.AbstractIconButton;
import gwt.material.design.client.base.HasImage;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.html.Span;

/**
 * Created by Mark Kevin on 1/29/2016.
 */
public class MaterialTreeItem extends AbstractIconButton implements HasImage{

    Span span;
    MaterialImage image = new MaterialImage();

    public MaterialTreeItem() {
        setStyleName("tree-item");
    }

    @Override
    protected Element createElement() {
        return Document.get().createDivElement();
    }

    @Override
    public void setText(String text) {
        span = new Span();
        span.setText(text);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        insert(span, 0);
    }

    @Override
    public void setUrl(String url) {
        image.setUrl(url);
        add(image);
    }

    @Override
    public String getUrl() {
        return image.getUrl();
    }

    @Override
    public void setResource(ImageResource resource) {
        image.setResource(resource);
        add(image);
    }

    @Override
    public ImageResource getResource() {
        return image.getResource();
    }
}
