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
import gwt.material.design.addins.client.richeditor.js.JsRichEditor;
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
public class MaterialRichEditor extends MaterialRichEditorBase implements HasValueChangeHandlers<String>, HasPasteHandlers, HasHTML {

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

    /**
     * Intialize the rich editor with custom properties.
     */
    protected void initRichEditor() {
        JsRichEditorOptions options = new JsRichEditorOptions();
        // Set up the toolbar items
        Object[][] toolbar = new Object[][]{};
        toolbar[0] = new Object[] {"style", extractOptions(getStyleOptions())};
        toolbar[1] = new Object[] {"para", extractOptions(getParaOptions())};
        toolbar[2] = new Object[] {"height", extractOptions(getHeightOptions())};
        toolbar[3] = new Object[] {"undo", extractOptions(getUndoOptions())};
        toolbar[4] = new Object[] {"fonts", extractOptions(getFontOptions())};
        toolbar[5] = new Object[] {"color", extractOptions(getColorOptions())};
        toolbar[6] = new Object[] {"ckMedia", extractOptions(getCkMediaOptions())};
        toolbar[7] = new Object[] {"misc", extractOptions(getMiscOptions())};
        // Other important options
        options.toolbar = toolbar;
        options.airMode = isAirMode();
        options.disableDragAndDrop = isDisableDragAndDrop();
        options.followingToolbar = false;
        options.placeholder = getPlaceholder();
        options.height = getHeight();
        options.minHeight = 200;
        options.defaultBackColor = "#777";
        options.defaultTextColor = "#fff";

        JsRichEditor jsRichEditor = $(getElement());
        jsRichEditor.materialnote(options);

        // Events
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_BLUR, event -> {
            fireEvent(new BlurEvent(){});
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_FOCUS, event -> {
            fireEvent(new FocusEvent(){});
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_KEYUP, event -> {
            fireEvent(new KeyUpEvent(){});
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_KEYDOWN, event -> {
            fireEvent(new KeyDownEvent(){});
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_PASTE, event -> {
            fireEvent(new PasteEvent(){});
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_CHANGE, event -> {
            ValueChangeEvent.fire(MaterialRichEditor.this, getHTMLCode(getElement()));
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
     * Insert custom text inside the note zone.
     */
    public void insertText(String text) {
        insertText(getElement(), text);
    }

    /**
     * Insert custom text inside the note zone.
     */
    protected void insertText(Element e, String text) {
        $(e).materialnote("insertText", text);
    }

    /**
     * Insert custom HTML inside the note zone.
     */
    public void pasteHTML(String html) {
        pasteHTML(getElement(), html);
    }

    /**
     * Insert custom HTML inside the note zone with JSNI function.
     */
    protected void pasteHTML(Element e, String html) {
        $(e).materialnote("pasteHTML", html);
    }

    @Override
    public void clear() {
        clear(getElement());
    }

    /**
     * Clear the note editor with element as param.
     */
    protected void clear(Element e) {
        $(e).materialnote("reset");
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

    @Override
    public HandlerRegistration addPasteHandler(final PasteEvent.PasteHandler handler) {
        return addHandler(event -> {
            if(isEnabled()) {
                handler.onPaste(event);
            }
        }, PasteEvent.TYPE);
    }
}