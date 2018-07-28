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
package gwt.material.design.addins.client.emptystate;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasIcon;
import gwt.material.design.client.base.HasTitle;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialTitle;
import gwt.material.design.client.ui.html.Div;

//@formatter:off

/**
 * <p>Material Empty State is a component that will have to display once content is empty.
 * <h3>UiBinder Usage:</h3>
 * <p>
 * <pre>
 * {@code
 * <m:MaterialEmptyState iconType="POLYMER" title="No Inbox" description="You dont have new message" backgroundColor="BLUE"/>
 * }
 * </pre>
 * </p>
 *
 * @author kevzlou7979
 * @author Ben Dol
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#empty-state">Material Empty State</a>
 * @see <a href="https://material.io/guidelines/patterns/empty-states.html">Material Design Specification</a>
 */
//@formatter:on
public class MaterialEmptyState extends MaterialWidget implements HasIcon, HasTitle {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialEmptyStateDebugClientBundle.INSTANCE.emptyStateDebugCss());
        } else {
            MaterialDesignBase.injectCss(MaterialEmptyStateClientBundle.INSTANCE.emptyStateCss());
        }
    }

    private boolean loading;
    private MaterialIcon icon = new MaterialIcon();
    private MaterialTitle title = new MaterialTitle();
    private Div container = new Div();

    public MaterialEmptyState() {
        super(Document.get().createDivElement(), CssName.VALIGN_WRAPPER, AddinsCssName.EMPTY_STATE);
    }

    public MaterialEmptyState(Color bgColor, Color textColor, IconType iconType, String title, String description) {
        this();
        setBackgroundColor(bgColor);
        setTextColor(textColor);
        setIconType(iconType);
        setTitle(title);
        setDescription(description);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        setTextAlign(TextAlign.CENTER);
        add(container);
        container.setWidth("100%");
        container.setStyleName(CssName.VALIGN + " " + CssName.CENTER);
        container.add(title);
        icon.setIconSize(IconSize.LARGE);
        title.insert(icon, 0);
    }

    @Override
    public void setDescription(String description) {
        title.setDescription(description);
    }

    @Override
    public String getDescription() {
        return title.getDescription();
    }

    @Override
    public void setTitle(String titleText) {
        title.setTitle(titleText);
    }

    @Override
    public MaterialIcon getIcon() {
        return icon;
    }

    @Override
    public void setIconType(IconType iconType) {
        icon.setIconType(iconType);
    }

    @Override
    public void setIconPosition(IconPosition position) {
        icon.setIconPosition(position);
    }

    @Override
    public void setIconSize(IconSize size) {
        icon.setIconSize(size);
    }

    @Override
    public void setIconFontSize(double size, Unit unit) {
        icon.setIconFontSize(size, unit);
    }

    @Override
    public void setIconColor(Color iconColor) {
        icon.setIconColor(iconColor);
    }

    @Override
    public Color getIconColor() {
        return icon.getIconColor();
    }

    @Override
    public void setIconPrefix(boolean prefix) {
        icon.setIconPrefix(prefix);
    }

    @Override
    public boolean isIconPrefix() {
        return icon.isIconPrefix();
    }

    public Div getContainer() {
        return container;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
        MaterialLoader.loading(loading, icon);
    }
}
