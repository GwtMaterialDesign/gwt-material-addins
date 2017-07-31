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
package gwt.material.design.addins.client.richeditor;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.richeditor.base.HasPasteHandlers;
import gwt.material.design.addins.client.richeditor.base.MaterialRichEditorBase;
import gwt.material.design.addins.client.richeditor.base.constants.RichEditorEvents;
import gwt.material.design.addins.client.richeditor.events.PasteEvent;
import gwt.material.design.addins.client.richeditor.js.JsRichEditor;
import gwt.material.design.addins.client.richeditor.js.JsRichEditorOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialModalContent;
import gwt.material.design.jquery.client.api.JQueryElement;

import static gwt.material.design.addins.client.richeditor.js.JsRichEditor.$;

//@formatter:off

/**
 * Provides a great Rich Editor with amazing options built with Material Design Look and Feel
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 * <ma:MaterialRichEditor placeholder="Type anything in here..."/>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#richeditor">Material Rich Editor</a>
 */
//@formatter:on
public class MaterialRichEditor extends MaterialRichEditorBase implements HasValueChangeHandlers<String>, HasPasteHandlers {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialRichEditorDebugClientBundle.INSTANCE.richEditorDebugJs());
            MaterialDesignBase.injectCss(MaterialRichEditorDebugClientBundle.INSTANCE.richEditorDebugCss());
        } else {
            MaterialDesignBase.injectJs(MaterialRichEditorClientBundle.INSTANCE.richEditorJs());
            MaterialDesignBase.injectCss(MaterialRichEditorClientBundle.INSTANCE.richEditorCss());
        }
    }

    private boolean toggleFullScreen = true;

    public MaterialRichEditor() {
        super();
    }

    public MaterialRichEditor(String placeholder) {
        this();
        setPlaceholder(placeholder);
    }

    public MaterialRichEditor(String placeholder, String value) {
        this(placeholder);
        setValue(value);
    }

    @Override
    protected void initialize() {
        JsRichEditor jsRichEditor = $(getElement());

        JsRichEditorOptions options = new JsRichEditorOptions();
        // Set up the toolbar items
        Object[][] toolbar = new Object[][]{};
        toolbar[0] = new Object[]{"style", extractOptions(getStyleOptions())};
        toolbar[1] = new Object[]{"para", extractOptions(getParaOptions())};
        toolbar[2] = new Object[]{"height", extractOptions(getHeightOptions())};
        toolbar[3] = new Object[]{"undo", extractOptions(getUndoOptions())};
        toolbar[4] = new Object[]{"fonts", extractOptions(getFontOptions())};
        toolbar[5] = new Object[]{"color", extractOptions(getColorOptions())};
        toolbar[6] = new Object[]{"ckMedia", extractOptions(getCkMediaOptions())};
        toolbar[7] = new Object[]{"misc", extractOptions(getMiscOptions())};

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

        jsRichEditor.materialnote(options);

        // Events
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_BLUR, event -> {
            fireEvent(new BlurEvent() {
            });
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_FOCUS, event -> {
            fireEvent(new FocusEvent() {
            });
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_KEYUP, event -> {
            fireEvent(new KeyUpEvent() {
            });
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_KEYDOWN, event -> {
            fireEvent(new KeyDownEvent() {
            });
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_PASTE, event -> {
            fireEvent(new PasteEvent() {
            });
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_CHANGE, event -> {
            ValueChangeEvent.fire(MaterialRichEditor.this, getHTMLCode(getElement()));
            return true;
        });

        checkContainer();
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Perform tear down on materialnote
        JsRichEditor jsRichEditor = $(getElement());
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_BLUR);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_FOCUS);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_KEYUP);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_KEYDOWN);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_PASTE);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_CHANGE);
        jsRichEditor.destroy();
    }

    protected void checkContainer() {
        if (getParent() instanceof MaterialModal) {
            MaterialModal modal = (MaterialModal) getParent();
            adjustFullScreen(modal);
            adjustNestedModals(modal);
        } else if (getParent() instanceof MaterialModalContent) {
            MaterialModal modal = (MaterialModal) getParent().getParent();
            adjustFullScreen(modal);
            adjustNestedModals(modal);
        }
    }

    protected void adjustNestedModals(MaterialModal modal) {
        modal.addOpenHandler(openEvent -> modal.setDepth(9999));
    }

    protected void adjustFullScreen(MaterialModal modal) {
        getEditor().find("div[data-event='fullscreen']").off("click").on("click", (e, param1) -> {
            modal.setFullscreen(toggleFullScreen);
            if (toggleFullScreen) {
                toggleFullScreen = false;
            } else {
                toggleFullScreen = true;
            }
            return true;
        });
    }

    public JQueryElement getEditor() {
        return $(getElement()).next(".note-editor");
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
        $(e).materialnote("insertText", SafeHtmlUtils.fromString(text).asString());
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
        $(getElement()).materialnote("reset");
    }

    @Override
    public HandlerRegistration addPasteHandler(final PasteEvent.PasteHandler handler) {
        return addHandler(handler, PasteEvent.TYPE);
    }
}