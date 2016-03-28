package gwt.material.design.addins.client.ui;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.ProgressType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.html.Span;

public class MaterialUploadCollection extends MaterialCollection {

    private MaterialCollectionItem item = new MaterialCollectionItem();
    private MaterialWidget dropInfo = new MaterialWidget(Document.get().createDivElement());
    private MaterialWidget nameWrapper = new MaterialWidget(Document.get().createDivElement());
    private MaterialWidget errorWrapper = new MaterialWidget(Document.get().createDivElement());
    private Span name = new Span();
    private Span size = new Span();
    private Span errorMessage = new Span();
    private MaterialCollectionSecondary secondaryAction = new MaterialCollectionSecondary();
    private MaterialButton btnClear = new MaterialButton(ButtonType.FLOATING);


    private MaterialProgress progress = new MaterialProgress();

    public MaterialUploadCollection() {
        // Element property
        setId("previews");
        addStyleName("card");

        // Collection Item property that contain the upload info, progress bar and action panel
        item.setId("zdrop-template");
        item.addStyleName("clearhack valign-wrapper item-template");
        add(item);

        // Upload Information
        dropInfo.addStyleName("left pv zdrop-info");
        dropInfo.setDataAttribute("data-dz-thumbnail", "");
        item.add(dropInfo);

        // Upload Information - Upload Name info
        nameWrapper.add(name);
        name.setDataAttribute("data-dz-name", "");
        nameWrapper.add(size);
        size.setDataAttribute("data-dz-size", "");
        dropInfo.add(nameWrapper);

        // Upload Information - Progress bar indication of upload queues
        progress.setType(ProgressType.DETERMINATE);
        progress.getWidget(0).getElement().setAttribute("data-dz-uploadprogress", "");
        progress.setPercent(0);
        dropInfo.add(progress);

        // Upload Information - Error message
        errorWrapper.setStyleName("dz-error-message");
        errorMessage.setDataAttribute("data-dz-errormessage", "");
        errorWrapper.add(errorMessage);
        dropInfo.add(errorWrapper);

        // Secondary Action Panel
        btnClear.setId("dz-remove");
        btnClear.setBackgroundColor("red");
        btnClear.setTextColor("white");
        btnClear.setWaves(WavesType.DEFAULT);
        btnClear.addStyleName("ph");
        btnClear.setIconType(IconType.CLEAR);
        btnClear.setDataAttribute("data-dz-remove", "");
        secondaryAction.add(btnClear);
        item.add(secondaryAction);
    }
}
