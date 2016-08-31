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
package gwt.material.design.addins.client.richeditor.base;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasHTML;
import gwt.material.design.addins.client.richeditor.base.constants.ToolbarButton;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.HasPlaceholder;

import static gwt.material.design.addins.client.richeditor.js.JsRichEditor.$;

/**
 * Base widget for Rich Editor with specific properties for options
 */
public class MaterialRichEditorBase extends AbstractValueWidget<String> implements HasPlaceholder, HasHTML {

    private boolean airMode;
    private String placeholder = "";
    private boolean disableDragAndDrop;

    public MaterialRichEditorBase() {
        super(Document.get().createDivElement(), "editor");
    }

    private ToolbarButton[] styleOptions = new ToolbarButton[]
        { ToolbarButton.STYLE, ToolbarButton.BOLD, ToolbarButton.ITALIC, ToolbarButton.UNDERLINE, ToolbarButton.STRIKETHROUGH, ToolbarButton.CLEAR, ToolbarButton.SUPERSCRIPT, ToolbarButton.SUBSCRIPT };
    private ToolbarButton[] fontOptions = new ToolbarButton[]
        { ToolbarButton.FONT_SIZE, ToolbarButton.FONT_NAME };
    private ToolbarButton[] colorOptions = new ToolbarButton[]
        { ToolbarButton.COLOR };
    private ToolbarButton[] undoOptions = new ToolbarButton[]
        { ToolbarButton.UNDO, ToolbarButton.REDO, ToolbarButton.HELP };
    private ToolbarButton[] ckMediaOptions = new ToolbarButton[]
        { ToolbarButton.CK_IMAGE_UPLOAD, ToolbarButton.CK_IMAGE_VIDEO };
    private ToolbarButton[] miscOptions = new ToolbarButton[]
        { ToolbarButton.LINK, ToolbarButton.PICTURE, ToolbarButton.TABLE, ToolbarButton.HR, ToolbarButton.CODE_VIEW, ToolbarButton.FULLSCREEN };
    private ToolbarButton[] paraOptions = new ToolbarButton[]
        { ToolbarButton.UL, ToolbarButton.OL, ToolbarButton.PARAGRAPH, ToolbarButton.LEFT, ToolbarButton.CENTER, ToolbarButton.RIGHT, ToolbarButton.JUSTIFY, ToolbarButton.OUTDENT, ToolbarButton.INDENT };
    private ToolbarButton[] heightOptions = new ToolbarButton[]
        { ToolbarButton.LINE_HEIGHT };

    public JsArrayString extractOptions(ToolbarButton[] options){
        JsArrayString jsOptions = JsArrayString.createArray().cast();
        for(ToolbarButton option : options){
            jsOptions.push(option.getId());
        }
        return  jsOptions;
    }

    public ToolbarButton[] getStyleOptions() {
        return styleOptions;
    }

    public void setStyleOptions(ToolbarButton... styleOptions) {
        this.styleOptions = styleOptions;
    }

    public ToolbarButton[] getFontOptions() {
        return fontOptions;
    }

    public void setFontOptions(ToolbarButton... fontOptions) {
        this.fontOptions = fontOptions;
    }

    public ToolbarButton[] getColorOptions() {
        return colorOptions;
    }

    public void setColorOptions(ToolbarButton... colorOptions) {
        this.colorOptions = colorOptions;
    }

    public ToolbarButton[] getUndoOptions() {
        return undoOptions;
    }

    public void setUndoOptions(ToolbarButton... undoOptions) {
        this.undoOptions = undoOptions;
    }

    public ToolbarButton[] getCkMediaOptions() {
        return ckMediaOptions;
    }

    public void setCkMediaOptions(ToolbarButton... ckMediaOptions) {
        this.ckMediaOptions = ckMediaOptions;
    }

    public ToolbarButton[] getMiscOptions() {
        return miscOptions;
    }

    public void setMiscOptions(ToolbarButton... miscOptions) {
        this.miscOptions = miscOptions;
    }

    public ToolbarButton[] getParaOptions() {
        return paraOptions;
    }

    public void setParaOptions(ToolbarButton... paraOptions) {
        this.paraOptions = paraOptions;
    }

    public ToolbarButton[] getHeightOptions() {
        return heightOptions;
    }

    public void setHeightOptions(ToolbarButton... heightOptions) {
        this.heightOptions = heightOptions;
    }

    public boolean isAirMode() {
        return airMode;
    }

    public void setAirMode(boolean airMode) {
        this.airMode = airMode;
    }

    @Override
    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getHeight() {
        String height = getElement().getStyle().getHeight();
        if(height == null || height.isEmpty()){
            height = "550px";
        }
        return height;
    }

    /**
     * Check if the dnd for rich editor is enabled / disabled
     */
    public boolean isDisableDragAndDrop() {
        return disableDragAndDrop;
    }

    /**
     * If true, disable the ability to drag and drop items to rich editor
     */
    public void setDisableDragAndDrop(boolean disableDragAndDrop) {
        this.disableDragAndDrop = disableDragAndDrop;
    }

    @Override
    public String getHTML() {
        return getHTMLCode(getElement());
    }

    @Override
    public void setHTML(final String html) {
        setHTMLCode(getElement(), html);
    }

    @Override
    public String getText() {
        return getElement().getInnerText();
    }

    @Override
    public void setText(String text) {
        getElement().setInnerText(text);
    }

    protected String getHTMLCode(Element e) {
        return $(e).code();
    }

    protected void setHTMLCode(Element e, String html) {
        $(e).code(html);
    }

    @Override
    public String getValue() {
        return getText();
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        setText(value);

        // We won't invoke the super call since the internal
        // library will handle change events.
    }
}
