package gwt.material.design.addins.client.window;

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
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.addins.client.dnd.MaterialDnd;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.ColorsMixin;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.animate.MaterialAnimation;

//@formatter:off

/**
 * Window is another kind of Modal but it has a header toolbar for maximizing and close the window. Also you can attached a tab component on its content.
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
 * {@code
 *  <ma:window.MaterialWindow ui:field="window" />
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 *  // Opening a window
 *  window.openWindow();
 *
 *  // Closing a window
 *  window.closeWindow();
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#window">Material Window</a>
 */
//@formatter:on
public class MaterialWindow extends MaterialWidget implements HasCloseHandlers<Boolean>, HasOpenHandlers<Boolean>{

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectCss(MaterialWindowDebugClientBundle.INSTANCE.windowCssDebug());
        } else {
            MaterialResourceInjector.injectCss(MaterialWindowClientBundle.INSTANCE.windowCss());
        }
    }

    private MaterialWidget window = new MaterialWidget(Document.get().createDivElement());
    private MaterialWidget content = new MaterialWidget(Document.get().createDivElement());

    // Toolbar elements
    private MaterialWidget toolbar = new MaterialWidget(Document.get().createDivElement());
    private MaterialIcon iconMaximize = new MaterialIcon(IconType.CHECK_BOX_OUTLINE_BLANK);
    private MaterialIcon iconClose = new MaterialIcon(IconType.CLOSE);
    private MaterialLink link = new MaterialLink();
    private String title = "";
    private String toolbarColor;

    private final ColorsMixin<MaterialWidget> toolbarColorMixin = new ColorsMixin<>(toolbar);
    private final ToggleStyleMixin<MaterialWidget> maximizeMixin = new ToggleStyleMixin<>(window, "maximize");
    private final ToggleStyleMixin<MaterialWindow> closeMixin = new ToggleStyleMixin<>(this, "open");
    private boolean maximize = true;
    private boolean open = false;

    private MaterialAnimation openAnimation;
    private MaterialAnimation closeAnimation;


    public MaterialWindow() {
        super(Document.get().createDivElement(), "window-overlay");
        window.setStyleName("window");
        content.setStyleName("content");
        super.add(window);
        initWindow();
    }

    /**
     * Builds the toolbar
     */
    private void initWindow() {
        toolbar.setStyleName("window-toolbar");
        link.setStyleName("window-title");
        iconClose.addStyleName("window-action");
        iconMaximize.addStyleName("window-action");
        iconClose.setCircle(true);
        iconClose.setWaves(WavesType.DEFAULT);
        iconMaximize.setCircle(true);
        iconMaximize.setWaves(WavesType.DEFAULT);
        toolbar.add(link);
        toolbar.add(iconClose);
        toolbar.add(iconMaximize);
        toolbar.addDomHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                toggleMaximize();
                Document.get().getDocumentElement().getStyle().setCursor(Style.Cursor.DEFAULT);
            }
        }, DoubleClickEvent.getType());
        window.add(toolbar);
        window.add(content);

        // Add handlers to action buttons
        iconMaximize.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                toggleMaximize();
            }
        });
        iconClose.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if(open){
                    openWindow();
                    open = false;
                }else{
                    closeWindow();
                    open = true;
                }
            }
        });

        // Add a draggable header
        MaterialDnd dnd = new MaterialDnd();
        dnd.setTarget(window);
        dnd.setIgnoreFrom(".content, .window-action");
        dnd.setRestriction(new Restriction(Restriction.Restrict.PARENT, true, -0.3, 0, 1.1, 1));
    }

    private void toggleMaximize(){
        if (maximize) {
            setMaximize(true);
            maximize = false;
        } else {
            setMaximize(false);
            maximize = true;
        }
    }

    @Override
    public void add(Widget child) {
        content.add(child);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
        link.setText(title);
    }

    public boolean isMaximize() {
        return maximizeMixin.isOn();
    }

    public void setMaximize(boolean maximize) {
        maximizeMixin.setOn(maximize);
        if(maximizeMixin.isOn()){
            iconMaximize.setIconType(IconType.FILTER_NONE);
        }else{
            iconMaximize.setIconType(IconType.CHECK_BOX_OUTLINE_BLANK);
        }
    }

    /**
     * Open the window
     */
    public void openWindow() {
        if (!this.isAttached()) {
            RootPanel.get().add(this);
        }
        this.open = false;
        OpenEvent.fire(this, true);
        if (openAnimation != null) {
            openAnimation.animate(window);
        }
        closeMixin.setOn(true);
    }

    /**
     * Close the window
     */
    public void closeWindow() {
        this.open = true;
        CloseEvent.fire(this, false);
        Runnable callback = new Runnable() {
            @Override
            public void run() {
                closeMixin.setOn(false);
            }
        };
        if (closeAnimation == null) {
            callback.run();
        } else {
            closeAnimation.animate(window, callback);
        }
    }

    public String getToolbarColor() {
        return toolbarColor;
    }

    public void setToolbarColor(String toolbarColor) {
        this.toolbarColor = toolbarColor;
        toolbarColorMixin.setBackgroundColor(toolbarColor);
    }

    public void setOpenAnimation(final MaterialAnimation openAnimation) {
        this.openAnimation = openAnimation;
    }

    public void setCloseAnimation(final MaterialAnimation closeAnimation) {
        this.closeAnimation = closeAnimation;
    }

    @Override
    public HandlerRegistration addCloseHandler(final CloseHandler<Boolean> handler) {
        return addHandler(new CloseHandler<Boolean>() {
            @Override
            public void onClose(CloseEvent<Boolean> event) {
                if(isEnabled()){
                    handler.onClose(event);
                }
            }
        }, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(final OpenHandler<Boolean> handler) {
        return addHandler(new OpenHandler<Boolean>() {
            @Override
            public void onOpen(OpenEvent<Boolean> event) {
                if(isEnabled()){
                    handler.onOpen(event);
                }
            }
        }, OpenEvent.getType());
    }

    @Override
    public void setWidth(String width) {
        window.setWidth(width);
    }

    @Override
    public void setHeight(String height) {
        window.setHeight(height);
    }

    @Override
    public void setBackgroundColor(String bgColor) {
        window.setBackgroundColor(bgColor);
    }

    public boolean isOpen() {
        return open;
    }
}
