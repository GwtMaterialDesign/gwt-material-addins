package gwt.material.design.addins.client.print;

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
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.print.constants.MimeType;
import gwt.material.design.addins.client.print.constants.PrintRender;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.AbstractIconButton;

//@formatter:off

/**
 * MaterialPrint - Provides print feature to any GMD Elements with the help of CSS2PDF
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {
 * @code
 *   <m:MaterialTitle ui:field="toBePrinted" title="This is title" description="This is printable" />
 *   <ma:print.MaterialPrint ui:field="btnPrint" text="Print title" />
 * }
 * </pre>
 *
 * <h3>Java Usage</h3>
 * <pre>
 * {
 * @code
 *   @UiHandler("btnPrint")
 *   void onPrint(ClickEvent e) {
 *       btnPrint.print(toBePrinted);
 *   }
 * }
 * </pre>
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#print">Material Print</a>
 * @author kevzlou7979
 */
//@formatter:on
public class MaterialPrint extends AbstractIconButton {

    static {
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialPrintDebugClientBundle.INSTANCE.printJsDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialPrintClientBundle.INSTANCE.printJs());
        }
    }

    private String idSelector = "";
    private double pageWidth = 8.5;
    private double pageHeight = 11;
    private double pageMargin = 0.5;
    private double pageMarginTop = 0.5;
    private double pageMarginRight = 0.5;
    private double pageMarginBottom = 0.5;
    private double pageMarginLeft = 0.5;
    private String pageMediaResource = "";
    private String namespaces = "";
    private String cssStyle = "";
    private String foStyle = "";
    private PrintRender rederer = PrintRender.DOWNLOAD;
    private String fileName = "document";
    private MimeType mimeType = MimeType.APPLICATION_PDF;
    private int resolution = 120;

    @Override
    protected Element createElement() {
        return Document.get().createAnchorElement();
    }

    /**
     * Print the current widget
     */
    public void print(Widget w) {
        print(w.getElement());
    }

    /**
     * Print the current element
     * @param e
     */
    public void print(Element e) {
        String uid = DOM.createUniqueId();
        e.setId(uid);
        print(uid, getPageWidth(), getPageHeight(), getPageMargin(), getPageMarginTop(), getPageMarginRight(), getPageMarginBottom(),
                getPageMarginLeft(), getPageMediaResource(), getNamespaces(), getCssStyle(), getFoStyle(), getRederer().getRederName(),
                getFileName(), getMimeType().getTypeName(), getResolution());
    }

    private native void print(String idSelector, double pageWidth, double pageHeight, double pageMargin, double pageMarginTop,
                              double pageMarginRight, double pageMarginBottom, double pageMarginLeft, String pageMediaResource,
                              String namespaces, String cssStyle, String foStyle, String rederer, String fileName, String mimeType, int resolution) /*-{
        $wnd.xepOnline.Formatter.Format(idSelector,
            {
                pageWidth: pageWidth + "in",
                pageHeight: pageHeight + "in",
                pageMargin: pageMargin + "in",
                pageMarginTop: pageMarginTop + "in",
                pageMarginRight: pageMarginRight + "in",
                pageMarginBottom: pageMarginBottom + "in",
                pageMarginLeft: pageMarginLeft + "in",
                pageMediaResource: pageMediaResource,
                namespaces: namespaces,
                cssStyle: cssStyle,
                foStyle: foStyle,
                render: rederer,
                srctype: 'xml',
                filename: fileName,
                mimeType: mimeType,
                resolution: resolution
            });
    }-*/;

    /**
     * Get Page Width
     */
    public double getPageWidth() {
        return pageWidth;
    }

    /**
     * Printed Media Page Width in Inches
     * @param pageWidth
     */
    public void setPageWidth(double pageWidth) {
        this.pageWidth = pageWidth;
    }

    /**
     * Get Page Height
     */
    public double getPageHeight() {
        return pageHeight;
    }

    /**
     * Printed Media Page Height in Inches
     * @param pageHeight
     */
    public void setPageHeight(double pageHeight) {
        this.pageHeight = pageHeight;
    }

    /**
     * Get Page Margin
     */
    public double getPageMargin() {
        return pageMargin;
    }

    /**
     * Printed Media Page Margin Dimensions (short-hand) in Inches
     * @param pageMargin
     */
    public void setPageMargin(double pageMargin) {
        this.pageMargin = pageMargin;
    }

    /**
     * Get Page Margin Top
     */
    public double getPageMarginTop() {
        return pageMarginTop;
    }

    /**
     * Printed Media Page Margin Top Dimension in Inches
     * @param pageMarginTop
     */
    public void setPageMarginTop(double pageMarginTop) {
        this.pageMarginTop = pageMarginTop;
    }

    /**
     * Get Page Margin Right
     */
    public double getPageMarginRight() {
        return pageMarginRight;
    }

    /**
     * Printed Media Page Margin Right Dimension in Inches
     * @param pageMarginRight
     */
    public void setPageMarginRight(double pageMarginRight) {
        this.pageMarginRight = pageMarginRight;
    }

    /**
     * Get Page Margin Bottom
     */
    public double getPageMarginBottom() {
        return pageMarginBottom;
    }

    /**
     * Printed Media Page Margin Bottom Dimension in Inches
     * @param pageMarginBottom
     */
    public void setPageMarginBottom(double pageMarginBottom) {
        this.pageMarginBottom = pageMarginBottom;
    }

    /**
     * Get Page Margin Left
     */
    public double getPageMarginLeft() {
        return pageMarginLeft;
    }

    /**
     * Printed Media Page Margin Left Dimension in Inches
     * @param pageMarginLeft
     */
    public void setPageMarginLeft(double pageMarginLeft) {
        this.pageMarginLeft = pageMarginLeft;
    }

    /**
     * Get Page Media Resource
     */
    public String getPageMediaResource() {
        return pageMediaResource;
    }

    /**
     *  A fully qualified URL to your own stylesheet
     * @param pageMediaResource
     */
    public void setPageMediaResource(String pageMediaResource) {
        this.pageMediaResource = pageMediaResource;
    }

    /**
     * Get namespaces
     * @return
     */
    public String getNamespaces() {
        return namespaces;
    }

    /**
     * an array of namespace strings to be added to the document. You need to do this if you are using any specialized library that would add namespaces to attributes. These are for the most part ignored at the backend transformation, but it would be an error if not including them.
     * @param namespaces
     */
    public void setNamespaces(String namespaces) {
        this.namespaces = namespaces;
    }

    /**
     * Get CSS Style
     */
    public String getCssStyle() {
        return cssStyle;
    }

    /**
     *  CSS styles to place directly on the container element (to override computed styles) as an array of objects whose key/value is the camel case CSS style name and a string value
     * @param cssStyle
     */
    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    /**
     * Get FO Style
     */
    public String getFoStyle() {
        return foStyle;
    }

    /**
     * FO styles to place directly on the container element (to override cssStyles during XSL-FO rendering) as an array of objects whose key/value is the camel case CSS style name and a string value
     * @param foStyle
     */
    public void setFoStyle(String foStyle) {
        this.foStyle = foStyle;
    }

    /**
     * Get Print render
     */
    public PrintRender getRederer() {
        return rederer;
    }

    /**
     * Options to control the result of the rendering
     * @param rederer
     */
    public void setRederer(PrintRender rederer) {
        this.rederer = rederer;
    }

    /**
     * Get filename
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Optionally used to name the downloaded file, the server will add the appropriate extension based on the mimetype of the requested document
     * Default - document
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get mime type
     */
    public MimeType getMimeType() {
        return mimeType;
    }

    /**
     * Optionally used control the formatter to create the type of result
     * Default - application/pdf
     * @param mimeType
     */
    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * Get print resolution
     */
    public int getResolution() {
        return resolution;
    }

    /**
     * Resolution for image output (applies to image mimetypes image/png, image/jpg and image/gif)
     * Default - 120
     * @param resolution
     */
    public void setResolution(int resolution) {
        this.resolution = resolution;
    }
}
