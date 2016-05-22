package gwt.material.design.addins.client.pathanimator;

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
import com.google.gwt.dom.client.Style;
import gwt.material.design.addins.client.MaterialResourceInjector;

//@formatter:off
/**
 * Custom component that provides meaningfull transition between two elements to show visual continuity.
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
 * MaterialPathAnimator.animate(Element source, Element target, Runnable callback);
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#pathAnimator">Material Path Animator</a>
 */
//@formatter:on
public class MaterialPathAnimator {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectJs(MaterialPathAnimatorDebugClientBundle.INSTANCE.pathanimatorDebugJs());
        } else {
            MaterialResourceInjector.injectJs(MaterialPathAnimatorClientBundle.INSTANCE.pathanimatorJs());
        }
    }

    /**
     * Default animate method using Opacity Transition.
     */
    public static void animate(Element source,final Element target) {
        Runnable defaultCallback = new Runnable() {
            @Override
            public void run() {
                target.getStyle().setVisibility(Style.Visibility.VISIBLE);
                target.getStyle().setOpacity(1);
            }
        };
        animate(source, target, defaultCallback);
    }

    /**
     * Custom path animator method with callback.
     */
    public static native void animate(Element source, Element target, Runnable callback)/*-{
        $wnd.jQuery(document).ready(function() {
            $wnd.cta(source, target, function () {
                if(callback != null) {
                    callback.@java.lang.Runnable::run()();
                }
            });
        });
    }-*/;

    /**
     * Default Reverse animate method to return to original state of Source component.
     */
    public static void reverseAnimate(final Element source,final Element target) {
        Runnable defaultCallback = new Runnable() {
            @Override
            public void run() {
                target.getStyle().setVisibility(Style.Visibility.HIDDEN);
                target.getStyle().setOpacity(0);
            }
        };
        reverseAnimate(source,target, defaultCallback);
    }

    /**
     * Reverse animation of the target component to return to original
     * state of the source component with Custom Callback.
     */
    public static native void reverseAnimate(Element source, Element target, Runnable callback) /*-{
        $wnd.jQuery(document).ready(function() {
            callback.@java.lang.Runnable::run()();
            $wnd.cta(target, source);
        });
    }-*/;
}
