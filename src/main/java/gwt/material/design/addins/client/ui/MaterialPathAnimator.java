package gwt.material.design.addins.client.ui;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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


import com.google.gwt.dom.client.Element;

//@formatter:off

/**
 * Custom component that provides meaningfull transition between two elements to show visual continuity.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:m.addins='urn:import:gwt.material.design.addins.client.ui'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 *{@code
    MaterialPathAnimator.animate(Element source, Element target, Runnable callback);
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#pathAnimator">Material Path Animator</a>
 */
//@formatter:on
public class MaterialPathAnimator {

    public static native void animate(Element source, Element target) /*-{
      $wnd.cta(source, target);
    }-*/;

    public static native void animate(Element source, Element target, Runnable callback)/*-{
        $wnd.cta(source, target, function () {
            if(callback != null) {
                callback.@java.lang.Runnable::run()();
            }
        });
    }-*/;
}
