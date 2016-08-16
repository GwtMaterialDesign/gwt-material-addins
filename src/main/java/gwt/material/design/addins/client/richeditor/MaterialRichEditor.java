package gwt.material.design.addins.client.richeditor;

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


import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasHTML;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.richeditor.base.HasPasteHandlers;
import gwt.material.design.addins.client.richeditor.base.MaterialRichEditorBase;
import gwt.material.design.addins.client.richeditor.base.constants.RichEditorEvents;
import gwt.material.design.addins.client.richeditor.events.PasteEvent;
import gwt.material.design.addins.client.richeditor.js.JsRichEditorOptions;
import gwt.material.design.client.MaterialDesignBase;

import static gwt.material.design.addins.client.richeditor.js.JsRichEditor.$;

//@formatter:off

/**
 * Provides a great Rich Editor with amazing options built with Material Design Look and Feel
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
 *{@code
 * <ma:MaterialRichEditor placeholder="Type anything in here..."/>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#richeditor">Material Rich Editor</a>
 */
//@formatter:on
public class MaterialRichEditor extends MaterialRichEditorBase implements HasHTML, HasValueChangeHandlers<String>, HasFocusHandlers, HasBlurHandlers, HasKeyUpHandlers, HasKeyDownHandlers, HasPasteHandlers {

    static {
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialRichEditorDebugClientBundle.INSTANCE.richEditorDebugJs());
            MaterialDesignBase.injectCss(MaterialRichEditorDebugClientBundle.INSTANCE.richEditorDebugCss());
        } else {
            MaterialDesignBase.injectJs(MaterialRichEditorClientBundle.INSTANCE.richEditorJs());
            MaterialDesignBase.injectCss(MaterialRichEditorClientBundle.INSTANCE.richEditorCss());
        }
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initRichEditor();
    }

    protected void initRichEditor() {
        initRichEditor(getElement(), isAirMode(), isDisableDragAndDrop(), getPlaceholder(), getHeight(), extractOptions(getStyleOptions()), extractOptions(getFontOptions()), extractOptions(getColorOptions()), extractOptions(getUndoOptions()), extractOptions(getCkMediaOptions()), extractOptions(getMiscOptions()), extractOptions(getParaOptions()), extractOptions(getHeightOptions()));
    }

    /**
     * Intialize the rich editor with custom properties
     * @param e
     * @param airMode
     * @param placeholder
     * @param height
     * @param styleOptions
     * @param fontOptions
     * @param colorOptions
     * @param undoOptions
     * @param ckMediaOptions
     * @param miscOptions
     * @param paraOptions
     * @param heightOptions
     */
    protected void initRichEditor(Element e, boolean airMode, boolean disableDragAndDrop, String placeholder, String height, JsArrayString styleOptions, JsArrayString fontOptions, JsArrayString colorOptions, JsArrayString undoOptions, JsArrayString ckMediaOptions, JsArrayString miscOptions, JsArrayString paraOptions, JsArrayString heightOptions) {
        JsRichEditorOptions options = new JsRichEditorOptions();
        // Set up the toolbar items
        Object[][] toolbar = new Object[][]{};
        toolbar[0] = new Object[] {"style", styleOptions};
        toolbar[1] = new Object[] {"para", paraOptions};
        toolbar[2] = new Object[] {"height", heightOptions};
        toolbar[3] = new Object[] {"undo", undoOptions};
        toolbar[4] = new Object[] {"fonts", fontOptions};
        toolbar[5] = new Object[] {"color", colorOptions};
        toolbar[6] = new Object[] {"ckMedia", ckMediaOptions};
        toolbar[7] = new Object[] {"misc", miscOptions};
        // Other important options
        options.toolbar = toolbar;
        options.airMode = airMode;
        options.disableDragAndDrop = disableDragAndDrop;
        options.followingToolbar = false;
        options.placeholder = placeholder;
        options.height = height;
        options.minHeight = 200;
        options.defaultBackColor = "#777";
        options.defaultTextColor = "#fff";
        $(e).materialnote(options);
        // Events
        $(e).on(RichEditorEvents.MATERIALNOTE_BLUR, event -> {
            fireBlurEvent();
            return true;
        });
        $(e).on(RichEditorEvents.MATERIALNOTE_FOCUS, event -> {
            fireFocusEvent();
            return true;
        });
        $(e).on(RichEditorEvents.MATERIALNOTE_KEYUP, event -> {
            fireKeyUpEvent();
            return true;
        });
        $(e).on(RichEditorEvents.MATERIALNOTE_KEYDOWN, event -> {
            fireKeyDownEvent();
            return true;
        });
        $(e).on(RichEditorEvents.MATERIALNOTE_PASTE, event -> {
            firePasteEvent();
            return true;
        });
        $(e).on(RichEditorEvents.MATERIALNOTE_CHANGE, event -> {
            fireChangeEvent(getHTMLCode(e));
            return true;
        });
    }

    @Override
    public String getHTML() {
        return getHTMLCode(getElement());
    }

    protected String getHTMLCode(Element e) {
        return $(e).code();
    }

    @Override
    public void setHTML(final String html) {
        setHTMLCode(getElement(), html);
    }

    protected void setHTMLCode(Element e, String html) {
        $(e).code(html);
    }

    @Override
    public String getText() {
        return getElement().getInnerText();
    }

    @Override
    public void setText(String text) {
        getElement().setInnerText(text);
    }

    /**
     * Insert custom text inside the note zone
     * @param text
     */
    public void insertText(String text) {
        insertText(getElement(), text);
    }

    /**
     * Insert custom text inside the note zone with JSNI function
     * @param e
     * @param text
     */
    protected void insertText(Element e, String text) {
        $(e).materialnote("insertText", text);
    }

    /**
     * Insert custom HTML inside the note zone
     * @param html
     */
    public void pasteHTML(String html) {
        pasteHTML(getElement(), html);
    }

    /**
     * Insert custom HTML inside the note zone with JSNI function
     * @param e
     * @param html
     */
    protected void pasteHTML(Element e, String html) {
        $(e).materialnote("pasteHTML", html);
    }

    @Override
    public void clear() {
        clear(getElement());
    }

    /**
     * Clear the note editor with element as param
     * @param e
     */
    protected void clear(Element e) {
        $(e).materialnote("reset");
    }

    @Override
    public HandlerRegistration addBlurHandler(final BlurHandler blurHandler) {
        return addHandler(event -> {
            if(isEnabled()) {
                blurHandler.onBlur(event);
            }
        }, BlurEvent.getType());
    }

    protected void fireBlurEvent() {
        fireEvent(new BlurEvent(){});
    }

    @Override
    public HandlerRegistration addFocusHandler(final FocusHandler focusHandler) {
        return addHandler(event -> {
            if(isEnabled()) {
                focusHandler.onFocus(event);
            }
        }, FocusEvent.getType());
    }

    protected void fireFocusEvent() {
        fireEvent(new FocusEvent(){});
    }

    @Override
    public HandlerRegistration addKeyUpHandler(final KeyUpHandler keyUpHandler) {
        return addHandler(event -> {
            if(isEnabled()) {
                keyUpHandler.onKeyUp(event);
            }
        }, KeyUpEvent.getType());
    }

    protected void fireKeyUpEvent() {
        fireEvent(new KeyUpEvent(){});
    }

    @Override
    public HandlerRegistration addKeyDownHandler(final KeyDownHandler keyDownHandler) {
        return addHandler(event -> {
            if(isEnabled()) {
                keyDownHandler.onKeyDown(event);
            }
        }, KeyDownEvent.getType());
    }

    protected void fireKeyDownEvent() {
        fireEvent(new KeyDownEvent() {});
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<String> valueChangeHandler) {
        return addHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
                if(isEnabled()) {
                    valueChangeHandler.onValueChange(valueChangeEvent);
                }
            }
        }, ValueChangeEvent.getType());
    }

    protected void fireChangeEvent(String html) {
        ValueChangeEvent.fire(MaterialRichEditor.this, html);
    }

    @Override
    public HandlerRegistration addPasteHandler(final PasteEvent.PasteHandler handler) {
        return addHandler(event -> {
            if(isEnabled()) {
                handler.onPaste(event);
            }
        }, PasteEvent.TYPE);
    }

    protected void firePasteEvent() {
        PasteEvent.fire(MaterialRichEditor.this);
    }
}