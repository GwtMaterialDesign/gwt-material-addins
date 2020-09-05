/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.addins.client.dnd.event.listener;

import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.dnd.event.InteractDragEvent;

public class DefaultDragMoveEventListener implements DragEventListener {

    @Override
    public void register(InteractDragEvent event) {
        Element target = event.target;

        String dataX = target.getAttribute("data-x");
        String dataY = target.getAttribute("data-y");

        float dx = parseAttributeToFloat(dataX, event.dx);
        float dy = parseAttributeToFloat(dataY, event.dy);

        target.getStyle().setProperty("transform", "translate(" + dx + "px, " + dy + "px)");
        target.setAttribute("data-x", String.valueOf(dx));
        target.setAttribute("data-y", String.valueOf(dy));
    }

    protected float parseAttributeToFloat(String attribute, float dataValue) {
        float value = 0;
        try {
            value = Float.parseFloat(attribute);
        } catch (Exception e) {

        }
        return value + dataValue;
    }
}
