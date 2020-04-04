package gwt.material.design.addins.client.combobox.template;

import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;

public class ImageTextSelectionTempate extends MaterialPanel {

    protected MaterialImage imgResult = new MaterialImage();
    protected MaterialLabel textResult = new MaterialLabel();

    public ImageTextSelectionTempate(String image, String text) {
        addStyleName("image-text-result-template");
        if (image != null) {
            imgResult.setUrl(image);
            add(imgResult);
        }

        if (text != null) {
            textResult.setText(text);
            add(textResult);
        }
    }
}
