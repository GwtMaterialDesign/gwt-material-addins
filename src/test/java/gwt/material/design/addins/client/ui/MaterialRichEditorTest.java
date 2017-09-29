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
package gwt.material.design.addins.client.ui;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.ui.base.AbstractValueWidgetTest;
import gwt.material.design.addins.client.richeditor.MaterialRichEditor;
import gwt.material.design.addins.client.richeditor.base.constants.ToolbarButton;
import gwt.material.design.addins.client.richeditor.events.PasteEvent;

/**
 * Test case for rich editor component
 *
 * @author kevzlou7979
 */
public class MaterialRichEditorTest extends AbstractValueWidgetTest<MaterialRichEditor> {

    @Override
    protected MaterialRichEditor createWidget() {

        return new MaterialRichEditor();
    }

    public void testProperties() {
        MaterialRichEditor editor = getWidget();
        assertTrue(editor.getElement().hasClassName(AddinsCssName.EDITOR));
        final String HTML = "<b>html</b>";
        final ToolbarButton[] MEDIA_OPT = new ToolbarButton[]{ToolbarButton.CK_IMAGE_UPLOAD, ToolbarButton.CK_IMAGE_VIDEO};
        final ToolbarButton[] COLOR_OPT = new ToolbarButton[]{ToolbarButton.COLOR};
        final ToolbarButton[] FONT_OPT = new ToolbarButton[]{ToolbarButton.FONT_NAME, ToolbarButton.FONT_SIZE};
        final ToolbarButton[] HEIGHT_OPT = new ToolbarButton[]{ToolbarButton.LINE_HEIGHT};
        final ToolbarButton[] MISC_OPT = new ToolbarButton[]{ToolbarButton.LINK, ToolbarButton.PICTURE, ToolbarButton.TABLE, ToolbarButton.HR, ToolbarButton.CODE_VIEW, ToolbarButton.FULLSCREEN};
        final ToolbarButton[] PARA_OPT = new ToolbarButton[]{ToolbarButton.UL, ToolbarButton.OL, ToolbarButton.PARAGRAPH, ToolbarButton.LEFT, ToolbarButton.CENTER, ToolbarButton.RIGHT, ToolbarButton.JUSTIFY, ToolbarButton.OUTDENT, ToolbarButton.INDENT};
        final ToolbarButton[] STYLE_OPT = new ToolbarButton[]{ToolbarButton.STYLE, ToolbarButton.BOLD, ToolbarButton.ITALIC, ToolbarButton.UNDERLINE, ToolbarButton.STRIKETHROUGH, ToolbarButton.CLEAR, ToolbarButton.SUPERSCRIPT, ToolbarButton.SUBSCRIPT};
        final ToolbarButton[] UNDO_OPT = new ToolbarButton[]{ToolbarButton.UNDO, ToolbarButton.REDO, ToolbarButton.HELP};

        editor.setAirMode(true);
        assertTrue(editor.isAirMode());
        editor.setAirMode(false);
        assertFalse(editor.isAirMode());
        editor.setDisableDragAndDrop(true);
        assertTrue(editor.isDisableDragAndDrop());
        editor.setDisableDragAndDrop(false);
        assertFalse(editor.isDisableDragAndDrop());
        editor.setHTML(HTML);
        assertEquals(HTML, editor.getHTML());

        editor.setCkMediaOptions(MEDIA_OPT);
        assertEquals(MEDIA_OPT, editor.getCkMediaOptions());
        editor.setColorOptions(COLOR_OPT);
        assertEquals(COLOR_OPT, editor.getColorOptions());
        editor.setFontOptions(FONT_OPT);
        assertEquals(FONT_OPT, editor.getFontOptions());
        editor.setHeightOptions(HEIGHT_OPT);
        assertEquals(HEIGHT_OPT, editor.getHeightOptions());
        editor.setMiscOptions(MISC_OPT);
        assertEquals(MISC_OPT, editor.getMiscOptions());
        editor.setParaOptions(PARA_OPT);
        assertEquals(PARA_OPT, editor.getParaOptions());
        editor.setStyleOptions(STYLE_OPT);
        assertEquals(STYLE_OPT, editor.getStyleOptions());
        editor.setUndoOptions(UNDO_OPT);
        assertEquals(UNDO_OPT, editor.getUndoOptions());
    }

    public void testEvents() {
        MaterialRichEditor editor = getWidget();
        editor.setEnabled(true);
        // Paste Event
        final boolean[] isPasteEventFired = {false};
        editor.addPasteHandler(event -> isPasteEventFired[0] = true);
        editor.fireEvent(new PasteEvent() {
        });
        assertTrue(isPasteEventFired[0]);
        // Blur Event
        final boolean[] isBlurEventFired = {false};
        editor.addBlurHandler(event -> isBlurEventFired[0] = true);
        editor.fireEvent(new BlurEvent() {
        });
        assertTrue(isBlurEventFired[0]);
        // Focus Event
        final boolean[] isFocusEventFired = {false};
        editor.addFocusHandler(event -> isFocusEventFired[0] = true);
        editor.fireEvent(new FocusEvent() {
        });
        assertTrue(isFocusEventFired[0]);
        // KeyUp Event
        final boolean[] isKeyUpEventFired = {false};
        editor.addKeyUpHandler(event -> isKeyUpEventFired[0] = true);
        editor.fireEvent(new KeyUpEvent() {
        });
        assertTrue(isKeyUpEventFired[0]);
        // KeyDown Event
        final boolean[] isKeyDownEventFired = {false};
        editor.addKeyDownHandler(event -> isKeyDownEventFired[0] = true);
        editor.fireEvent(new KeyDownEvent() {
        });
        assertTrue(isKeyDownEventFired[0]);
        // ValueChange Event
        final boolean[] isValueChangeEventFired = {false};
        editor.addValueChangeHandler(event -> isValueChangeEventFired[0] = true);
        editor.fireEvent(new GwtEvent<ValueChangeHandler<?>>() {
            @Override
            public Type<ValueChangeHandler<?>> getAssociatedType() {
                return ValueChangeEvent.getType();
            }

            @Override
            protected void dispatch(ValueChangeHandler<?> eventHandler) {
                eventHandler.onValueChange(null);
            }
        });
        assertTrue(isValueChangeEventFired[0]);
    }
}
