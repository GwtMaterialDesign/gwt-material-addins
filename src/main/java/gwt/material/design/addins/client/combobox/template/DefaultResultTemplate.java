package gwt.material.design.addins.client.combobox.template;

import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;

public class DefaultResultTemplate extends MaterialPanel {

    protected MaterialImage image = new MaterialImage();
    protected MaterialPanel rightPanel = new MaterialPanel();
    protected MaterialLabel firstLine = new MaterialLabel();
    protected MaterialLabel secondLine = new MaterialLabel();

    public DefaultResultTemplate(String image, String firstLine) {
        this(image, firstLine, null);
    }

    public DefaultResultTemplate(String image, String firstLine, String secondLine) {
        addStyleName("result-template");

        if (image != null) {
            this.image.setUrl(image);
            add(this.image);
        }

        if (firstLine != null) {
            this.firstLine.addStyleName("first-line");
            this.firstLine.setText(firstLine);
            rightPanel.add(this.firstLine);
        }

        if (secondLine != null) {
            addStyleName("has-second-line");
            this.secondLine.addStyleName("second-line");
            this.secondLine.setText(secondLine);
            rightPanel.add(this.secondLine);
        }

        rightPanel.addStyleName("right-panel");
        add(rightPanel);
    }
}
