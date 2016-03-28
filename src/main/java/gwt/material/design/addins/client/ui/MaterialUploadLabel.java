package gwt.material.design.addins.client.ui;

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.base.mixin.TitleMixin;
import gwt.material.design.client.base.HasTitle;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;

public class MaterialUploadLabel extends MaterialWidget implements HasTitle {

    private MaterialIcon icon = new MaterialIcon(IconType.CLOUD_UPLOAD);
    private final TitleMixin<MaterialUploadLabel> titleMixin = new TitleMixin<>(this);

    public MaterialUploadLabel() {
        super(Document.get().createDivElement());
        add(icon);
        setId("upload-label");
    }

    @Override
    public void setTitle(String title) {
        titleMixin.setTitle(title);
    }

    @Override
    public void setDescription(String description) {
        titleMixin.setDescription(description);
    }

}
