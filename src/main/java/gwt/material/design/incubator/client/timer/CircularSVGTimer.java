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
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.incubator.client.base.IncubatorWidget;

import java.util.Collections;
import java.util.List;

//@formatter:off

/**
 * A circular SVG timer component to build a similar
 * interface like {@link gwt.material.design.addins.client.circularprogress.MaterialCircularProgress}
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class CircularSVGTimer extends AbstractAddinsWidget {

    static {
        IncubatorWidget.showWarning(CircularSVGTimer.class);
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
    protected void internalLoad() {
        getElement().setAttribute("class", "spinner");
    }

    //TODO: Convert to JSInterop
    private static native Element createElementNS(final String ns,
                                                  final String name)/*-{
        return document.createElementNS(ns, name);
    }-*/;

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(TimerProgressClientBundle.INSTANCE.circularTimerCss(), TimerProgressDebugClientBundle.INSTANCE.circularTimerDebugCss()));
    }
}