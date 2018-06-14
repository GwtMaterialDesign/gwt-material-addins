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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.HasHTML;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.richeditor.base.HasPasteHandlers;
import gwt.material.design.addins.client.richeditor.base.ToolBarManager;
import gwt.material.design.addins.client.richeditor.base.constants.RichEditorEvents;
import gwt.material.design.addins.client.richeditor.base.constants.ToolbarButton;
import gwt.material.design.addins.client.richeditor.events.PasteEvent;
import gwt.material.design.addins.client.richeditor.js.JsRichEditor;
import gwt.material.design.addins.client.richeditor.js.JsRichEditorOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.HasPlaceholder;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.ui.MaterialDialog;
import gwt.material.design.client.ui.MaterialDialogContent;
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
 * @see <a href="https://github.com/Cerealkillerway/materialNote">1.2.1</a>
 */
//@formatter:on
public class MaterialRichEditor extends AbstractValueWidget<String> implements JsLoader, HasValueChangeHandlers<String>, HasPasteHandlers, HasPlaceholder, HasHTML  {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialRichEditorDebugClientBundle.INSTANCE.richEditorDebugJs());
            MaterialDesignBase.injectCss(MaterialRichEditorDebugClientBundle.INSTANCE.richEditorDebugCss());
        } else {
            MaterialDesignBase.injectJs(MaterialRichEditorClientBundle.INSTANCE.richEditorJs());
            MaterialDesignBase.injectCss(MaterialRichEditorClientBundle.INSTANCE.richEditorCss());
        }
    }


    private String html;
    private ToolBarManager manager = new ToolBarManager();
    private boolean toggleFullScreen = true;
    private JsRichEditorOptions options = JsRichEditorOptions.create();

    private HandlerRegistration handlerRegistration;

    public MaterialRichEditor() {
        super(Document.get().createDivElement(), AddinsCssName.EDITOR);
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
    protected void onLoad() {
        super.onLoad();

        load();

        setHTML(html);
    }

    @Override
    public void load() {

        JsRichEditor jsRichEditor = $(getElement());

        options.toolbar = manager.getToolbars();
        options.placeholder = getPlaceholder();
        options.height = getHeight();

        jsRichEditor.materialnote(options);

        // Events
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_BLUR, event -> {
            fireEvent(new BlurEvent() {});
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_FOCUS, event -> {
            fireEvent(new FocusEvent() {});
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_KEYUP, event -> {
            fireEvent(new KeyUpEvent() {});
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_KEYDOWN, event -> {
            fireEvent(new KeyDownEvent() {});
            return true;
        });
        jsRichEditor.on(RichEditorEvents.MATERIALNOTE_PASTE, event -> {
            fireEvent(new PasteEvent() {});
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

        unload();
    }

    @Override
    public void unload() {
        JsRichEditor jsRichEditor = $(getElement());
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_BLUR);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_FOCUS);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_KEYUP);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_KEYDOWN);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_PASTE);
        jsRichEditor.off(RichEditorEvents.MATERIALNOTE_CHANGE);
        jsRichEditor.destroy();
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    public ToolbarButton[] getStyleOptions() {
        return manager.getStyleOptions();
    }

    public void setStyleOptions(ToolbarButton... styleOptions) {
        manager.setStyleOptions(styleOptions);
    }

    public ToolbarButton[] getFontOptions() {
        return manager.getFontOptions();
    }

    public void setFontOptions(ToolbarButton... fontOptions) {
        manager.setFontOptions(fontOptions);
    }

    public ToolbarButton[] getColorOptions() {
        return manager.getColorOptions();
    }

    public void setColorOptions(ToolbarButton... colorOptions) {
        manager.setColorOptions(colorOptions);
    }

    public ToolbarButton[] getUndoOptions() {
        return manager.getUndoOptions();
    }

    public void setUndoOptions(ToolbarButton... undoOptions) {
        manager.setUndoOptions(undoOptions);
    }

    public ToolbarButton[] getCkMediaOptions() {
        return manager.getCkMediaOptions();
    }

    public void setCkMediaOptions(ToolbarButton... ckMediaOptions) {
        manager.setCkMediaOptions(ckMediaOptions);
    }

    public ToolbarButton[] getMiscOptions() {
        return manager.getMiscOptions();
    }

    public void setMiscOptions(ToolbarButton... miscOptions) {
        manager.setMiscOptions(miscOptions);
    }

    public ToolbarButton[] getParaOptions() {
        return manager.getParaOptions();
    }

    public void setParaOptions(ToolbarButton... paraOptions) {
        manager.setParaOptions(paraOptions);
    }

    public ToolbarButton[] getHeightOptions() {
        return manager.getHeightOptions();
    }

    public void setHeightOptions(ToolbarButton... heightOptions) {
        manager.setHeightOptions(heightOptions);
    }

    protected void checkContainer() {
        if (getParent() instanceof MaterialDialog) {
            MaterialDialog dialog = (MaterialDialog) getParent();
            adjustFullScreen(dialog);
            adjustNestedDialog(dialog);
        } else if (getParent() instanceof MaterialDialogContent) {
            MaterialDialog dialog = (MaterialDialog) getParent().getParent();
            adjustFullScreen(dialog);
            adjustNestedDialog(dialog);
        }
    }

    protected void adjustNestedDialog(MaterialDialog dialog) {
        registerHandler(dialog.addOpenHandler(openEvent -> dialog.setDepth(9999)));
    }

    protected void adjustFullScreen(MaterialDialog dialog) {
        getEditor().find("div[data-event='fullscreen']").off("click").on("click", (e, param1) -> {
            dialog.setFullscreen(toggleFullScreen);
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
     * Insert custom HTML inside the note zone.
     */
    protected void pasteHTML(Element e, String html) {
        $(e).materialnote("pasteHTML", html);
    }

    /**
     * Reset the Rich Editor component
     */
    public void reset() {
        $(getElement()).materialnote("reset");
    }

    @Override
    public void clear() {
        super.clear();
        reset();
    }

    public boolean isAirMode() {
        return options.airMode;
    }

    public void setAirMode(boolean airMode) {
        options.airMode = airMode;
    }

    /**
     * Check if the dnd for rich editor is enabled / disabled
     */
    public boolean isDisableDragAndDrop() {
        return options.disableDragAndDrop;
    }

    /**
     * If true, disable the ability to drag and drop items to rich editor
     */
    public void setDisableDragAndDrop(boolean disableDragAndDrop) {
        options.disableDragAndDrop = disableDragAndDrop;
    }

    @Override
    public String getPlaceholder() {
        return options.placeholder;
    }

    @Override
    public void setPlaceholder(String placeholder) {
        options.placeholder = placeholder;
    }

    public String getHeight() {
        String height = getElement().getStyle().getHeight();
        if (height == null || height.isEmpty()) {
            height = "550px";
        }
        return height;
    }

    @Override
    public String getHTML() {
        return getHTMLCode(getElement());
    }

    @Override
    public void setHTML(final String html) {
        this.html = html;

        if (handlerRegistration != null) {
            handlerRegistration.removeHandler();
            handlerRegistration = null;
        }

        if (!isAttached() && html != null) {
            handlerRegistration = registerHandler(addAttachHandler(e -> setHTMLCode(getElement(), html)));
        } else {
            setHTMLCode(getElement(), html);
        }
    }

    @Override
    public String getText() {
        return getHTML();
    }

    @Override
    public void setText(String text) {
        setHTML(text);
    }

    protected String getHTMLCode(Element e) {
        return $(e).code();
    }

    protected void setHTMLCode(Element e, String html) {
        $(e).code(html);
    }

    @Override
    public String getValue() {
        return getHTML();
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        setHTML(value);
    }

    @Override
    public HandlerRegistration addPasteHandler(final PasteEvent.PasteHandler handler) {
        return addHandler(handler, PasteEvent.TYPE);
    }
}