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
package gwt.material.design.addins.client.richeditor.base.constants;

/**
 * This enum represents the RichEditor Toolbar buttons
 *
 * @author kevzlou7979
 */
public enum ToolbarButton {

    /* Style Options */
    STYLE("style"),
    BOLD("bold"),
    ITALIC("italic"),
    UNDERLINE("underline"),
    STRIKETHROUGH("strikethrough"),
    CLEAR("clear"),
    SUPERSCRIPT("superscript"),
    SUBSCRIPT("subscript"),

    /* Font Options */
    FONT_SIZE("fontsize"),
    FONT_NAME("fontname"),

    /* Color Options */
    COLOR("color"),

    /* Undo Options */
    UNDO("undo"),
    REDO("redo"),
    HELP("help"),

    /* CKMedia */
    CK_IMAGE_UPLOAD("ckImageUploader"),
    CK_IMAGE_VIDEO("ckVideoEmbeeder"),

    /* Misc Options */
    LINK("link"),
    PICTURE("picture"),
    TABLE("table"),
    HR("hr"),
    CODE_VIEW("codeview"),
    FULLSCREEN("fullscreen"),

    /* Para Options */
    UL("ul"),
    OL("ol"),
    PARAGRAPH("paragraph"),
    LEFT("leftButton"),
    CENTER("centerButton"),
    RIGHT("rightButton"),
    JUSTIFY("justifyButton"),
    OUTDENT("outdentButton"),
    INDENT("indentButton"),

    /* Height Options */
    LINE_HEIGHT("lineheight");

    String id;

    ToolbarButton(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
