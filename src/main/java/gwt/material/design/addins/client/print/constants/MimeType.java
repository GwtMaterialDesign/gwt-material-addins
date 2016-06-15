package gwt.material.design.addins.client.print.constants;

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


/**
 *  Optionally used control the formatter to create the type of result
 *  @author kevzlou7979
 */
public enum MimeType {

    APPLICATION_PDF("application/pdf"), // for PDF documents
    IMAGE_SVG_XML("image/svg+xml"), // for SVG documents
    IMAGE_PNG("image/png"), // for PNG page images
    IMAGE_JPG("image/jpg"), // for JPG page images
    IMAGE_GIF("image/gif"), // for GIF page images
    XPS_DOCUMENT("application/vnd.ms-xpsdocument"), // or XPS documents You must ensure that you use only Truetype Fonts from the @cloudformatter server. XPS documents require Truetype fonts.
    APPLICATION_POSTSCRIPT("application/postscript"), // for Postscript documents
    APPLICATION_XEP("application/xep"); // for RenderX XEP (structure tree) documents which is an XML file

    String typeName;

    MimeType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
