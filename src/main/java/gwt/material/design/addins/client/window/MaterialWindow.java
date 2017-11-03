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
package gwt.material.design.addins.client.window;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.dnd.MaterialDnd;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.animate.MaterialAnimation;

//@formatter:off

/**
 * Window is another kind of Modal but it has a header toolbar for maximizing and
 * close the window. Also you can attached a tab component on its content.
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
 *  <ma:window.MaterialWindow ui:field="windowContainer" />
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 *  // Opening a window
 *  windowContainer.open();
 *
 *  // Closing a window
 *  windowContainer.close();
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#window">Material Window</a>
 */
//@formatter:on
public class MaterialWindow extends MaterialPanel implements HasCloseHandlers<Boolean>, HasOpenHandlers<Boolean> {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialWindowDebugClientBundle.INSTANCE.windowCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialWindowClientBundle.INSTANCE.windowCss());
        }
    }

    private static MaterialPanel windowOverlay;
    private static int windowCount = 0;
    private boolean preventClose;
    private MaterialAnimation openAnimation;
    private MaterialAnimation closeAnimation;
    private MaterialDnd dnd;
    private MaterialPanel content = new MaterialPanel();
    private MaterialLink labelTitle = new MaterialLink();
    private MaterialPanel toolbar = new MaterialPanel();
    private MaterialIcon iconMaximize = new MaterialIcon(IconType.CHECK_BOX_OUTLINE_BLANK);
    private MaterialIcon iconClose = new MaterialIcon(IconType.CLOSE);
    private HandlerRegistration toolbarAttachHandler;

    private ToggleStyleMixin<MaterialWidget> maximizeMixin;
    private ToggleStyleMixin<MaterialWindow> openMixin;

    public MaterialWindow() {
        super(AddinsCssName.WINDOW);

        content.setStyleName(AddinsCssName.CONTENT);
        toolbar.setStyleName(AddinsCssName.WINDOW_TOOLBAR);
        labelTitle.setStyleName(AddinsCssName.WINDOW_TITLE);
        iconClose.addStyleName(AddinsCssName.WINDOW_ACTION);
        iconMaximize.addStyleName(AddinsCssName.WINDOW_ACTION);

        iconClose.setCircle(true);
        iconClose.setWaves(WavesType.DEFAULT);

        iconMaximize.setCircle(true);
        iconMaximize.setWaves(WavesType.DEFAULT);

        toolbar.add(labelTitle);
        toolbar.add(iconClose);
        toolbar.add(iconMaximize);

        super.add(toolbar);
        super.add(content);

        setTop(100);

        // Add a draggable header
        dnd = buildDnd();
    }

    public MaterialWindow(String title) {
        this();
        setTitle(title);
    }

    public MaterialWindow(String title, Color backgroundColor, Color textColor) {
        this(title);
        setBackgroundColor(backgroundColor);
        setTextColor(textColor);
    }

    public MaterialWindow(String title, Color backgroundColor, Color textColor, Color toolbarColor) {
        this(title, backgroundColor, textColor);
        setToolbarColor(toolbarColor);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // Add handlers to action buttons
        registerHandler(iconMaximize.addClickHandler(event -> toggleMaximize()));

        registerHandler(toolbar.addDoubleClickHandler(event -> {
            toggleMaximize();
            Document.get().getDocumentElement().getStyle().setCursor(Style.Cursor.DEFAULT);
        }));

        registerHandler(iconClose.addClickHandler(event -> {
            if (!preventClose) {
                if (!isOpen()) {
                    open();
                } else {
                    close();
                }
            }
        }));
    }

    /**
     * Override to provide custom options for window drag'n'drop
     */
    protected JsDragOptions buildDragOptions() {
        return JsDragOptions.create(new Restriction("body", true, 0, 0, 1.2, 1));
    }

    /**
     * Override to provide custom {@link MaterialDnd} instance. Default implementation will construct {@link MaterialDnd}
     * using options provided by {@link #buildDragOptions()} and will ignore drag events from content portion of
     * the window ({@link AddinsCssName#CONTENT}) as well from action buttons (close, maximize and other {@link AddinsCssName#WINDOW_ACTION}.
     */
    protected MaterialDnd buildDnd() {
        MaterialDnd dnd = MaterialDnd.draggable(this, buildDragOptions());
        dnd.ignoreFrom(".content, .window-action");
        return dnd;
    }
    
    protected void onClose() {

    }

    protected void toggleMaximize() {
        setMaximize(!isMaximized());
    }

    @Override
    public void add(Widget child) {
        content.add(child);
    }

    @Override
    public boolean remove(Widget w) {
        return content.remove(w);
    }

    @Override
    public void insert(Widget child, int beforeIndex) {
        content.insert(child, beforeIndex);
    }

    @Override
    public void clear() {
        content.clear();
    }

    @Override
    public String getTitle() {
        return labelTitle.getTitle();
    }

    @Override
    public void setTitle(String title) {
        labelTitle.setText(title);
    }

    public boolean isMaximized() {
        return getMaximizeMixin().isOn();
    }

    public void setMaximize(boolean maximize) {
        getMaximizeMixin().setOn(maximize);
        if (getMaximizeMixin().isOn()) {
            iconMaximize.setIconType(IconType.FILTER_NONE);
        } else {
            iconMaximize.setIconType(IconType.CHECK_BOX_OUTLINE_BLANK);
        }
    }

    public static boolean isOverlay() {
        return windowOverlay != null && windowOverlay.isAttached();
    }

    public static void setOverlay(boolean overlay) {
        if(overlay) {
            if(windowOverlay == null) {
                windowOverlay = new MaterialPanel(AddinsCssName.WINDOW_OVERLAY);
            }
        } else {
            if(windowOverlay != null) {
                windowOverlay.removeFromParent();
                windowOverlay = null;
            }
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        if (!isAttached()) {
            RootPanel.get().add(this);
        }
        windowCount++;
        if(windowOverlay != null && !windowOverlay.isAttached()) {
            RootPanel.get().add(windowOverlay);
        }

        if (openAnimation == null) {
            getOpenMixin().setOn(true);
            OpenEvent.fire(this, true);
        } else {
            setOpacity(0);
            Scheduler.get().scheduleDeferred(() -> {
                getOpenMixin().setOn(true);
                openAnimation.animate(this, () -> OpenEvent.fire(this, true));
            });
        }
    }

    /**
     * Close the window.
     */
    public void close() {
        // Turn back the cursor to POINTER
        RootPanel.get().getElement().getStyle().setCursor(Style.Cursor.DEFAULT);

        windowCount--;
        if (closeAnimation == null) {
            getOpenMixin().setOn(false);
            if(windowOverlay != null && windowOverlay.isAttached() && windowCount < 1) {
                windowOverlay.removeFromParent();
            }
            CloseEvent.fire(this, false);
        } else {
            closeAnimation.animate(this, () -> {
                getOpenMixin().setOn(false);
                if(windowOverlay != null && windowOverlay.isAttached() && windowCount < 1) {
                    windowOverlay.removeFromParent();
                }
                CloseEvent.fire(this, false);
            });
        }
    }

    public Color getToolbarColor() {
        return toolbar.getBackgroundColor();
    }

    public void setToolbarColor(Color toolbarColor) {
        if (toolbarAttachHandler != null) {
            toolbarAttachHandler.removeHandler();
            toolbarAttachHandler = null;
        }

        if (toolbarColor != null) {
            if (toolbar.isAttached()) {
                toolbar.setBackgroundColor(toolbarColor);
            } else {
                if (toolbarAttachHandler == null) {
                    toolbarAttachHandler = registerHandler(toolbar.addAttachHandler(attachEvent -> toolbar.setBackgroundColor(toolbarColor)));
                }
            }
        }
    }

    @Override
    public void setBackgroundColor(Color bgColor) {
        content.setBackgroundColor(bgColor);
    }

    @Override
    public Color getBackgroundColor() {
        return content.getBackgroundColor();
    }

    public void setOpenAnimation(final MaterialAnimation openAnimation) {
        this.openAnimation = openAnimation;
    }

    public void setCloseAnimation(final MaterialAnimation closeAnimation) {
        this.closeAnimation = closeAnimation;
    }

    @Override
    public HandlerRegistration addCloseHandler(final CloseHandler<Boolean> handler) {
        return addHandler(handler, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(final OpenHandler<Boolean> handler) {
        return addHandler(handler, OpenEvent.getType());
    }

    public boolean isOpen() {
        return getOpenMixin().isOn();
    }

    /**
     * @deprecated can now reference the {@link MaterialWindow} directly.
     */
    @Deprecated
    public MaterialWidget getContainer() {
        return this;
    }

    public MaterialWidget getToolbar() {
        return toolbar;
    }

    public MaterialWidget getContent() {
        return content;
    }

    public MaterialIcon getIconMaximize() {
        return iconMaximize;
    }

    public MaterialIcon getIconClose() {
        return iconClose;
    }

    public MaterialLink getLabelTitle() {
        return labelTitle;
    }

    public static MaterialPanel getWindowOverlay() {
        return windowOverlay;
    }

    @Override
    public void setPadding(double padding) {
        content.setPadding(padding);
    }

    @Override
    public void setPaddingTop(double padding) {
        content.setPaddingTop(padding);
    }

    @Override
    public void setPaddingLeft(double padding) {
        content.setPaddingTop(padding);
    }

    @Override
    public void setPaddingRight(double padding) {
        content.setPaddingRight(padding);
    }

    @Override
    public void setPaddingBottom(double padding) {
        content.setPaddingBottom(padding);
    }

    public boolean isPreventClose() {
        return preventClose;
    }

    public void setPreventClose(boolean preventClose) {
        this.preventClose = preventClose;
    }

    /**
     * Set the area for the drag and drop, can be an {@link Element}
     * or a {@link String} selector.
     */
    public void setDndArea(Object dndArea) {
        if(dndArea instanceof UIObject) {
            dndArea = ((UIObject) dndArea).getElement();
        }
        if(dnd != null) {
            dnd.draggable(JsDragOptions.create(new Restriction(dndArea, true, 0, 0, 1.2, 1)));
        }
    }

    protected ToggleStyleMixin<MaterialWidget> getMaximizeMixin() {
        if (maximizeMixin == null) {
            maximizeMixin = new ToggleStyleMixin<>(this, AddinsCssName.MAXIMIZE);
        }
        return maximizeMixin;
    }

    protected ToggleStyleMixin<MaterialWindow> getOpenMixin() {
        if (openMixin == null) {
            openMixin = new ToggleStyleMixin<>(this, AddinsCssName.OPEN);
        }
        return openMixin;
    }

    public MaterialDnd getDnd() {
        return dnd;
    }
}
