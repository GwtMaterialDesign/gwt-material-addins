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
import gwt.material.design.addins.client.richeditor.events.PasteEvent;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialToast;

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
        initRichEditor(getElement(), isAirMode(), getPlaceholder(), getHeight(), extractOptions(getStyleOptions()), extractOptions(getFontOptions()), extractOptions(getColorOptions()), extractOptions(getUndoOptions()), extractOptions(getCkMediaOptions()), extractOptions(getMiscOptions()), extractOptions(getParaOptions()), extractOptions(getHeightOptions()));
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
    protected native void initRichEditor(Element e, boolean airMode, String placeholder, String height, JsArrayString styleOptions, JsArrayString fontOptions, JsArrayString colorOptions, JsArrayString undoOptions, JsArrayString ckMediaOptions, JsArrayString miscOptions, JsArrayString paraOptions, JsArrayString heightOptions) /*-{
        var that = this;
        $wnd.jQuery(document).ready(function() {
            var toolbar = [
                ['style', styleOptions],
                ['para', paraOptions],
                ['height', heightOptions],
                ['undo', undoOptions],
                ['fonts', fontOptions],
                ['color', colorOptions],
                ['ckMedia', ckMediaOptions],
                ['misc', miscOptions],
            ];

            $wnd.jQuery(e).materialnote({
                toolbar: toolbar,
                airMode: airMode,
                followingToolbar: false,
                placeholder: placeholder,
                height: height,
                minHeight: 200,
                defaultBackColor: '#777',
                defaultTextColor: '#fff',
            });
            // Blur
            $wnd.jQuery(e).on('materialnote.blur', function() {
                that.@gwt.material.design.addins.client.richeditor.MaterialRichEditor::fireBlurEvent()();
            });
            // Focus
            $wnd.jQuery(e).on('materialnote.focus', function() {
                that.@gwt.material.design.addins.client.richeditor.MaterialRichEditor::fireFocusEvent()();
            });
            // Key Up
            $wnd.jQuery(e).on('materialnote.keyup', function() {
                that.@gwt.material.design.addins.client.richeditor.MaterialRichEditor::fireKeyUpEvent()();
            });
            // Key Down
            $wnd.jQuery(e).on('materialnote.keydown', function() {
                that.@gwt.material.design.addins.client.richeditor.MaterialRichEditor::fireKeyDownEvent()();
            });
            // Paste Event
            $wnd.jQuery(e).on('materialnote.paste', function() {
                that.@gwt.material.design.addins.client.richeditor.MaterialRichEditor::firePasteEvent()();
            });
            // Change Event
            $wnd.jQuery(e).on('materialnote.change', function(we, contents, $editable) {
                that.@gwt.material.design.addins.client.richeditor.MaterialRichEditor::fireChangeEvent(*)(contents);
            });

        });
    }-*/;



    @Override
    public String getHTML() {
        return getHTMLCode(getElement());
    }

    protected native String getHTMLCode(Element e) /*-{
        return $wnd.jQuery(e).code();
    }-*/;

    @Override
    public void setHTML(final String html) {
        setHTMLCode(getElement(), html);
    }

    protected native void setHTMLCode(Element e, String html) /*-{
        $wnd.jQuery(e).code(html);
    }-*/;

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
    protected native void insertText(Element e, String text) /*-{
        $wnd.jQuery(document).ready(function() {
            $wnd.jQuery(e).materialnote('insertText', text);
        });
    }-*/;

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
    protected native void pasteHTML(Element e, String html) /*-{
        $wnd.jQuery(document).ready(function () {
            $wnd.jQuery(e).materialnote('pasteHTML', html);
        });
    }-*/;

    @Override
    public void clear() {
        clear(getElement());
    }

    /**
     * Clear the note editor with element as param
     * @param e
     */
    protected native void clear(Element e) /*-{
        $wnd.jQuery(document).ready(function() {
            $wnd.jQuery(e).materialnote('reset');
        });
    }-*/;

    @Override
    public HandlerRegistration addBlurHandler(final BlurHandler blurHandler) {
        return addHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                if(isEnabled()) {
                    blurHandler.onBlur(event);
                }
            }
        }, BlurEvent.getType());
    }

    protected void fireBlurEvent() {
        fireEvent(new BlurEvent(){});
    }

    @Override
    public HandlerRegistration addFocusHandler(final FocusHandler focusHandler) {
        return addHandler(new FocusHandler() {
            @Override
            public void onFocus(FocusEvent event) {
                if(isEnabled()) {
                    focusHandler.onFocus(event);
                }
            }
        }, FocusEvent.getType());
    }

    protected void fireFocusEvent() {
        fireEvent(new FocusEvent(){});
    }

    @Override
    public HandlerRegistration addKeyUpHandler(final KeyUpHandler keyUpHandler) {
        return addHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                if(isEnabled()) {
                    keyUpHandler.onKeyUp(event);
                }
            }
        }, KeyUpEvent.getType());
    }

    protected void fireKeyUpEvent() {
        fireEvent(new KeyUpEvent(){});
    }

    @Override
    public HandlerRegistration addKeyDownHandler(final KeyDownHandler keyDownHandler) {
        return addHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if(isEnabled()) {
                    keyDownHandler.onKeyDown(event);
                }
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
        return addHandler(new PasteEvent.PasteHandler() {
            @Override
            public void onPaste(PasteEvent event) {
                if(isEnabled()) {
                    handler.onPaste(event);
                }
            }
        }, PasteEvent.TYPE);
    }

    protected void firePasteEvent() {
        PasteEvent.fire(MaterialRichEditor.this);
    }
}