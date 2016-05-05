package gwt.material.design.addins.client.fileuploader;

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


import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.MaterialWidget;

public class MaterialUploadPreview extends MaterialWidget {

    private MaterialUploadCollection uploadCollection = new MaterialUploadCollection();
    private MaterialUploadHeader uploadHeader = new MaterialUploadHeader();

    public MaterialUploadPreview() {
        super(Document.get().createDivElement(), "preview-container");
        uploadHeader.setPreview(this);
        add(uploadHeader);
        add(uploadCollection);
    }


    public MaterialUploadCollection getUploadCollection() {
        return uploadCollection;
    }

    public MaterialUploadHeader getUploadHeader() {
        return uploadHeader;
    }
}
