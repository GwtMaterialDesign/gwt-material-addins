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
package gwt.material.design.addins.client.stepper.highlighter;

import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;

import java.util.ArrayList;
import java.util.List;

public class StepHighlighter {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(StepHighlighterDebugClientBundle.INSTANCE.stepHighlighterDebugCss());
        } else {
            MaterialDesignBase.injectCss(StepHighlighterClientBundle.INSTANCE.stepHighlighterCss());
        }
    }

    protected static final String HIGHLIGHT = "highlight";
    protected int currentIndex = 0;
    public List<Widget> widgets = new ArrayList<>();

    public void start() {
        currentIndex = 0;
        next();
    }

    public void next() {
        if (currentIndex < widgets.size()) {
            animate(currentIndex);
            currentIndex++;
        }
    }

    public void previous() {
        if (currentIndex > 0) {
            animate(currentIndex);
            currentIndex--;
        }
    }

    public void animate(int index) {
        clearHighlightStyle();
        Widget widget = widgets.get(index);
        if (widget != null) {
            widget.addStyleName(HIGHLIGHT);
        }
    }

    public void clearHighlightStyle() {
        for (Widget w : widgets) {
            w.removeStyleName(HIGHLIGHT);
        }
    }

    public void reset() {
        currentIndex = 0;
        clearHighlightStyle();
    }

    public void register(Widget object) {
        widgets.add(object);
    }

    public void register(Widget... objects) {
        for (Widget widget : objects) {
            widgets.add(widget);
        }
    }

    public void unregister(Widget widget) {
        widgets.remove(widget);
    }

    public void unregisterAll() {
        widgets.forEach(widget -> unregister(widget));
    }
}
