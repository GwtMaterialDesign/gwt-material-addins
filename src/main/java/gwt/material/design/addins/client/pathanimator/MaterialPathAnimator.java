/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.pathanimator;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.pathanimator.js.JsPathAnimator;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.jquery.client.api.Functions;

import static gwt.material.design.jquery.client.api.JQuery.$;

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
 * MaterialPathAnimator.animate(Element source, Element target, Functions.Func callback);
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#pathAnimator">Material Path Animator</a>
 */
//@formatter:on
public class MaterialPathAnimator {

    static {
        if(MaterialAddins.isDebug()) {
            MaterialDesignBase.injectJs(MaterialPathAnimatorDebugClientBundle.INSTANCE.pathanimatorDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialPathAnimatorClientBundle.INSTANCE.pathanimatorJs());
        }
    }

    /**
     * Default animate method using Opacity Transition.
     */
    public static void animate(Element source, final Element target) {
        animate(source, target, () -> {
            target.getStyle().setVisibility(Style.Visibility.VISIBLE);
            target.getStyle().setOpacity(1);
        });
    }

    /**
     * Custom path animator method with callback.
     */
    public static void animate(Element source, Element target, Functions.Func callback) {
        $("document").ready(() -> {
            JsPathAnimator.cta(source, target, () -> {
                if(callback != null) { callback.call(); }
            });
        });
    }

    /**
     * Default Reverse animate method to return to original state of Source component.
     */
    public static void reverseAnimate(final Element source, final Element target) {
        reverseAnimate(source,target, () -> {
            target.getStyle().setVisibility(Style.Visibility.HIDDEN);
            target.getStyle().setOpacity(0);
        });
    }

    /**
     * Reverse animation of the target component to return to original
     * state of the source component with Custom Callback.
     */
    public static void reverseAnimate(Element source, Element target, Functions.Func callback) {
        $("document").ready(() -> {
            if(callback != null) { callback.call(); }
            JsPathAnimator.cta(target, source);
        });
    }
}
