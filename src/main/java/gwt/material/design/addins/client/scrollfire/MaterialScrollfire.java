package gwt.material.design.addins.client.scrollfire;

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
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.MaterialResourceInjector;

//@formatter:off
/**
 * Material Scrollfire - executes callback functions depending on how far into the page you've scrolled.
 *
 * <h3>Java Usage:</h3>
 *
 * <pre>
 * {@code
 * MaterialScrollfire.apply(Element e, Runnable runnableCallback);
 * }
 * </pre>
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#scrollfire">Material Scrollfire</a>
 * @author kevzlou7979
 */
//@formatter:on
public class MaterialScrollfire {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectDebugJs(MaterialScrollfireDebugClientBundle.INSTANCE.scrollfireDebugJs());
        } else {
            MaterialResourceInjector.injectJs(MaterialScrollfireClientBundle.INSTANCE.scrollfireJs());
        }
    }

    public static void apply(Element element, Runnable callback) {
        String uid = DOM.createUniqueId();
        element.setId(uid);
        apply("#" + uid, callback);
    }

    public static native void apply(String selector, Runnable callback) /*-{
        $wnd.jQuery(document).ready(function() {
            var offset = 100;
            var callbackFn = $entry(function() {
                callback.@java.lang.Runnable::run()();
            });
            $wnd.apply(selector, offset, callbackFn);
        });
    }-*/;
}
