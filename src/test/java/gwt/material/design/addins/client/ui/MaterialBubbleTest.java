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

import gwt.material.design.addins.client.ui.base.AddinsWidgetTestCase;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.bubble.MaterialBubble;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Position;

/**
 * Test case for bubble component
 *
 * @author kevzlou7979
 */
public class MaterialBubbleTest extends AddinsWidgetTestCase<MaterialBubble> {

    @Override
    protected MaterialBubble createWidget() {
        return new MaterialBubble();
    }

    public void testPosition() {
        // UiBinder
        // given
        MaterialBubble bubble = getWidget(false);

        // when / then
        checkPosition(bubble);

        // Standard
        // given
        attachWidget();

        // when / then
        checkPosition(bubble);
    }

    protected void checkPosition(MaterialBubble bubble) {
        checkPosition(bubble, Position.RIGHT);
        checkPosition(bubble, Position.LEFT);
        checkPosition(bubble, Position.TOP);
        checkPosition(bubble, Position.BOTTOM);
    }

    protected void checkPosition(MaterialBubble bubble, Position position) {
        bubble.setPosition(position);
        assertEquals(position, bubble.getPosition());
        assertTrue(getTriangle(bubble).getElement().hasClassName(position.getCssName()));
    }

    public void testStructure() {
        // UiBinder
        // given
        MaterialBubble bubble = getWidget(false);

        // when / then
        checkStructure(bubble);

        // Standard
        // given
        attachWidget();

        // when / then
        checkStructure(bubble);
    }

    protected void checkStructure(MaterialBubble bubble) {
        MaterialWidget triangle = getTriangle(bubble);
        assertTrue(triangle.getElement().hasClassName(AddinsCssName.TRIANGLE));
    }

    protected MaterialWidget getTriangle(MaterialBubble bubble) {
        MaterialWidget triangle = (MaterialWidget) bubble.getWidget(0);
        return triangle;
    }
}
