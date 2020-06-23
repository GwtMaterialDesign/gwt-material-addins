/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2020 GwtMaterialDesign
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
