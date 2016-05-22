package gwt.material.design.addins.client;

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


import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.*;
import com.google.gwt.resources.client.TextResource;

/**
 * Resource Injector for injecting external resources such as javascript and css files.
 * @author kevzlou7979
 */
public class MaterialResourceInjector {

    private static boolean debug;
    private static HeadElement head;

    private static HeadElement getHead() {
        if(head == null) {
            Element elt = Document.get().getElementsByTagName("head").getItem(0);
            head = HeadElement.as(elt);
        }
        return head;
    }

    public static void injectJs(TextResource resource) {
        injectJs(resource, true, false);
    }

    public static void injectDebugJs(TextResource resource) {
        injectJs(resource, false, true);
    }

    public static void injectJs(TextResource resource, boolean removeTag, boolean sourceUrl) {
        final String text = resource.getText() +
            (sourceUrl ? "//# sourceURL="+resource.getName()+".js" : "");

        ScriptInjector.fromString(text)
            .setWindow(ScriptInjector.TOP_WINDOW)
            .setRemoveTag(removeTag)
            .inject();
    }

    public static void injectCss(TextResource resource) {
        StyleInjector.inject(resource.getText());
    }

    /**
     * Check if the module imported is debugged or not.
     */
    public static boolean isDebug() {
        return debug;
    }

    /**
     * Will set the javascript resources into it's corresponding value
     * true - imports debuggable js files (xxx.min.js)
     * false - imports production js files (xxx.js)
     */
    public static void setDebug(boolean debug) {
        MaterialResourceInjector.debug = debug;
    }
}
