/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.incubator.client.alert;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

public class AlertModal extends MaterialModal {

    private MaterialLabel lblTitle = new MaterialLabel();
    private MaterialIcon icon = new MaterialIcon(IconType.THUMB_DOWN);
    private MaterialLabel lblMessage = new MaterialLabel();
    private MaterialLink btnAgree = new MaterialLink("BID");
    private MaterialLink btnClose = new MaterialLink("CANCEL");

    @Override
    protected void onLoad() {
        super.onLoad();

        setId(IncubatorCssName.ALERT_MODAL);

        lblMessage.setText("Please place a bid again because you've been out of bid");
        lblTitle.setText("Your Out of Bid");
        add(icon);
        add(lblTitle);
        add(lblMessage);

        btnClose.setTextColor(Color.GREY);
        btnAgree.setTextColor(Color.RED_DARKEN_4);

        add(btnAgree);
        add(btnClose);

        registerHandler(btnClose.addClickHandler(e -> close()));
    }

    public MaterialLink getBtnAgree() {
        return btnAgree;
    }

    public MaterialLink getBtnClose() {
        return btnClose;
    }
}
