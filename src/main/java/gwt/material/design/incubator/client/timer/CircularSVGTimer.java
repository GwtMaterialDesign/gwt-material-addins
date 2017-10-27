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
package gwt.material.design.incubator.client.timer;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.incubator.client.AddinsIncubator;

public class CircularSVGTimer extends ComplexPanel {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(TimerProgressDebugClientBundle.INSTANCE.circularTimerDebugCss());
        } else {
            MaterialDesignBase.injectCss(TimerProgressClientBundle.INSTANCE.circularTimerCss());
        }
    }

    private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";

    public CircularSVGTimer() {
        setElement(createElementNS(SVG_NAMESPACE, "svg"));
        getElement().setAttribute("width", "50");
        getElement().setAttribute("height", "50");
        getElement().setAttribute("viewBox", "0 0 66 66");
        showcaseSVG();
    }

    private void showcaseSVG(){
        Element svgElement = createElementNS(SVG_NAMESPACE, "circle");
        svgElement.setAttribute("cx", "33");
        svgElement.setAttribute("cy", "33");
        svgElement.setAttribute("r", "30");
        svgElement.setAttribute("stroke-width", "6");
        svgElement.setAttribute("stroke-linecap", "round");
        svgElement.setAttribute("fill", "none");
        svgElement.setAttribute("class", "path");
        getElement().appendChild(svgElement);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        getElement().setAttribute("class", "spinner");
    }

    private static native Element createElementNS(final String ns,
                                                  final String name)/*-{
        return document.createElementNS(ns, name);
    }-*/;
}