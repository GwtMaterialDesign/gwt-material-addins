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
package gwt.material.design.addins.client.popupmenu;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasOpenClose;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.html.UnorderedList;
import gwt.material.design.jquery.client.api.JQueryElement;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * Popup Menu.
 *
 * @author Mark Kevin
 * @author Ben Dol
 */
public class MaterialPopupMenu extends UnorderedList implements JsLoader, HasSelectionHandlers<Element>, HasOpenHandlers<MaterialPopupMenu>,
    HasCloseHandlers<MaterialPopupMenu>, HasOpenClose {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialPopupMenuDebugClientBundle.INSTANCE.menuCssDebug());
        } else {
            MaterialDesignBase.injectCss(MaterialPopupMenuClientBundle.INSTANCE.menuCss());
        }
    }

    private int popupX;
    private int popupY;
    private String id;
    private Object selected;
    private boolean autoClose = true;
    private boolean autoFocus = false;

    public MaterialPopupMenu() {
        id = DOM.createUniqueId();
        setInitialClasses(AddinsCssName.POPUP_MENU, AddinsCssName.MENU_BAR, CssName.Z_DEPTH_3);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        $(this).attr("tabindex", "0");
        $(this).on("blur", e -> {
            if (autoClose) {
                close();
            }
            return true;
        });

        $("*").on("scroll." + id, e -> {
            if (autoClose) {
                close();
            }
            return true;
        });

        initializeSelectionEvent();

        close();
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        $(".popup-menu li").off("mouseleave");
        $(".popup-menu li").off("click");
        $(".popup-menu li").off("mouseover");
        $(this).off("." + id);
        $("*").off("." + id);
    }

    @Override
    public void reload() {
        unload();
        load();
    }


    private void initializeSelectionEvent() {
        // Initialization of Selection event
        $(".popup-menu li").on("click", e -> {
            e.stopPropagation();
            SelectionEvent.fire(MaterialPopupMenu.this, $(e.getCurrentTarget()).asElement());
            $(this).hide();
            return true;
        });

        // Check if the dropdown is not visible anymore into it's container either left / bottom side
        $(".popup-menu li").on("mouseover", (e, param1) -> {
            JQueryElement item = $(e.getCurrentTarget()).find("a");
            if (item.attr("data-activates") != null) {
                JQueryElement dp = $("#" + item.attr("data-activates"));

                double dpWidth = dp.width();
                double dpLeft = dp.offset().left;
                double conWidth = body().width();

                double dpHeight = 200;
                double dpTop = dp.offset().top;
                double conHeight = body().height();

                if (dpWidth + dpLeft > conWidth) {
                    dp.addClass(AddinsCssName.EDGE_LEFT);
                }

                if (dpHeight + dpTop > conHeight) {
                    dp.addClass(AddinsCssName.EDGE_BOTTOM);
                }
            }
            return true;
        });

        $(".popup-menu li").on("mouseleave", (e, param) -> {
            JQueryElement item = $(e.getCurrentTarget()).find("a");
            if (item.attr("data-activates") != null) {
                JQueryElement dp = $("#" + item.attr("data-activates"));
                dp.removeClass(AddinsCssName.EDGE_LEFT);
                dp.removeClass(AddinsCssName.EDGE_BOTTOM);
            }
            return true;
        });
    }

    /**
     * Set the popup position of the context menu
     *
     * @param popupX window x position
     * @param popupY window y position
     */
    public void setPopupPosition(int popupX, int popupY) {
        // Will check if the popup is out of container
        this.popupX = popupX;
        this.popupY = popupY;
        setLeft(popupX);
        setTop(popupY);
    }

    public boolean isAutoClose() {
        return autoClose;
    }

    public void setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<Element> selectionHandler) {
        return addHandler(selectionHandler, SelectionEvent.getType());
    }

    @Override
    public void open() {
        setVisible(true);
        if (autoFocus) Scheduler.get().scheduleDeferred(() -> setFocus(true));

        // Check if dropdown is out of the container (Left)
        if ($(this).width() + $(this).offset().left > body().width()) {
            setLeft(body().width() - $(this).width());
        }
        OpenEvent.fire(this, this);
    }

    @Override
    public void close() {
        setVisible(false);
        CloseEvent.fire(this, this);
    }

    @Override
    public boolean isOpen() {
        return isVisible();
    }

    public Object getSelected() {
        return selected;
    }

    public void setSelected(Object selected) {
        this.selected = selected;
    }

    public boolean isAutoFocus() {
        return autoFocus;
    }

    public void setAutoFocus(boolean autoFocus) {
        this.autoFocus = autoFocus;
    }

    @Override
    public HandlerRegistration addCloseHandler(CloseHandler<MaterialPopupMenu> closeHandler) {
        return addHandler(new CloseHandler<MaterialPopupMenu>() {
            @Override
            public void onClose(CloseEvent<MaterialPopupMenu> closeEvent) {
                if (isEnabled()) {
                    closeHandler.onClose(closeEvent);
                }
            }
        }, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler<MaterialPopupMenu> openHandler) {
        return addHandler(new OpenHandler<MaterialPopupMenu>() {
            @Override
            public void onOpen(OpenEvent<MaterialPopupMenu> openEvent) {
                if (isEnabled()) {
                    openHandler.onOpen(openEvent);
                }
            }
        }, OpenEvent.getType());
    }

    public int getPopupX() {
        return popupX;
    }

    public int getPopupY() {
        return popupY;
    }
}
