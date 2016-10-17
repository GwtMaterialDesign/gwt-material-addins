/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.fileuploader;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.*;
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
    private MaterialIcon previewIcon = new MaterialIcon(IconType.INSERT_DRIVE_FILE);

    private MaterialProgress progress = new MaterialProgress();

    public MaterialUploadCollection() {
        // Element property
        setStyleName(AddinsCssName.PREVIEWS);
        addStyleName(CssName.CARD);

        // Collection Item property that contain the upload info, progress bar and action panel
        item.setId(AddinsCssName.ZDROP_TEMPLATE);
        item.addStyleName(AddinsCssName.CLEARHACK + " " + CssName.VALIGN_WRAPPER + " " + AddinsCssName.ITEM_TEMPLATE);
        add(item);

        // Upload Information
        dropInfo.addStyleName(CssName.LEFT + " " + AddinsCssName.PV + " " + AddinsCssName.ZDROP_INFO);
        dropInfo.setDataAttribute("data-dz-thumbnail", "");
        item.add(dropInfo);

        // Upload Information - Upload Name info
        nameWrapper.add(name);
        name.setTruncate(true);
        name.setWidth("200px");
        name.setDataAttribute("data-dz-name", "");
        nameWrapper.add(size);
        size.setDataAttribute("data-dz-size", "");
        dropInfo.add(nameWrapper);

        previewIcon.setFloat(Style.Float.LEFT);
        previewIcon.addStyleName(AddinsCssName.PREVIEW_ICON);
        dropInfo.add(previewIcon);

        // Upload Information - Progress bar indication of upload queues
        progress.setType(ProgressType.DETERMINATE);
        progress.getWidget(0).getElement().setAttribute("data-dz-uploadprogress", "");
        progress.setPercent(0);
        dropInfo.add(progress);

        // Upload Information - Error message
        errorWrapper.setStyleName(AddinsCssName.DZ_ERROR_MESSAGE);
        errorMessage.setDataAttribute("data-dz-errormessage", "");
        errorMessage.setId(AddinsCssName.ERROR_MESSAGE);
        errorWrapper.add(errorMessage);
        dropInfo.add(errorWrapper);

        // Secondary Action Panel
        btnClear.setId(AddinsCssName.DZ_REMOVE);
        btnClear.setBackgroundColor(Color.TRANSPARENT);
        btnClear.setShadow(0);
        btnClear.setCircle(true);
        btnClear.setTextColor(Color.WHITE);
        btnClear.addStyleName(AddinsCssName.PH);
        btnClear.setIconType(IconType.CLEAR);
        btnClear.setDataAttribute("data-dz-remove", "");
        secondaryAction.add(btnClear);
        item.add(secondaryAction);
    }

    public MaterialCollectionItem getItem() {
        return item;
    }
}
