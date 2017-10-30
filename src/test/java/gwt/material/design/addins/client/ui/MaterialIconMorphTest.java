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

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.iconmorph.MaterialIconMorph;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;

/**
 * Test case for icon morph component
 *
 * @author kevzlou7979
 */
public class MaterialIconMorphTest extends MaterialWidgetTest<MaterialIconMorph> {

    @Override
    protected MaterialIconMorph createWidget() {
        MaterialIconMorph iconMorph = new MaterialIconMorph();
        MaterialIcon icon1 = new MaterialIcon();
        icon1.setIconType(IconType.POLYMER);
        MaterialIcon icon2 = new MaterialIcon();
        icon2.setIconType(IconType.AC_UNIT);
        iconMorph.add(icon1);
        iconMorph.add(icon2);
        return iconMorph;
    }

    public void testSize() {
        // UiBinder
        // given
        MaterialIconMorph iconMorph = getWidget(false);

        // when / then
        checkSize(iconMorph);

        // Standard
        // given
        attachWidget();

        // when / then
        checkSize(iconMorph);
    }

    protected void checkSize(MaterialIconMorph iconMorph) {
        iconMorph.setIconSize(IconSize.SMALL);
        assertTrue(iconMorph.getElement().hasClassName(IconSize.SMALL.getCssName()));
        iconMorph.setIconSize(IconSize.MEDIUM);
        assertTrue(iconMorph.getElement().hasClassName(IconSize.MEDIUM.getCssName()));
        iconMorph.setIconSize(IconSize.LARGE);
        assertTrue(iconMorph.getElement().hasClassName(IconSize.LARGE.getCssName()));
        iconMorph.setIconSize(IconSize.TINY);
        assertTrue(iconMorph.getElement().hasClassName(IconSize.TINY.getCssName()));
    }

    public void testStructure() {
        // UiBinder
        // given
        MaterialIconMorph iconMorph = getWidget();

        assertEquals(iconMorph.getSource(), iconMorph.getWidget(0));
        assertEquals(iconMorph.getTarget(), iconMorph.getWidget(1));
        assertTrue(iconMorph.getSource().getElement().hasClassName(AddinsCssName.SOURCE));
        assertTrue(iconMorph.getTarget().getElement().hasClassName(AddinsCssName.TARGET));

        // given
        final boolean[] isClicked = {false};
        iconMorph.addClickHandler(clickEvent -> isClicked[0] = true);

        // when / then
        fireClickEvent(iconMorph);
        assertTrue(isClicked[0]);
        assertTrue(iconMorph.getElement().hasAttribute("onclick"));
        assertEquals("this.classList.toggle('morphed')", iconMorph.getElement().getAttribute("onclick"));
    }
}
