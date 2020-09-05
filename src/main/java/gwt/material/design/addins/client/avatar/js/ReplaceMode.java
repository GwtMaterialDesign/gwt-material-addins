/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2020 GwtMaterialDesign
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
package gwt.material.design.addins.client.avatar.js;

public enum ReplaceMode {

    /**
     * Icons are never rendered automatically. You need to call jdenticon.update() manually to render identicons.
     */
    NEVER("never"),

    /**
     * Icons are rendered once the page has loaded. Any dynamically inserted or modified icons will not be rendered
     * unless jdenticon.update() is manually called.
     */
    ONCE("once"),

    /**
     * Icons are rendered upon page load, and the DOM is monitored for new icons using a MutationObserver.
     * Use this if icons are inserted dynamically, e.g. by using Angular, React or VanillaJS. This option behaves as
     * "once" in IE<11.
     */
    OBSERVE("observe");

    private String name;

    ReplaceMode(java.lang.String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
