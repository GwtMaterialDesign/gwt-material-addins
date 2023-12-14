/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2023 GwtMaterialDesign
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
package gwt.material.design.addins.client.base.dependency;

import com.google.gwt.resources.client.TextResource;

public class DependencyResource {

    private TextResource minified;
    private TextResource debug;

    public DependencyResource() {
    }

    public DependencyResource(TextResource minified, TextResource debug) {
        this.minified = minified;
        this.debug = debug;
    }

    public TextResource getMinified() {
        return minified;
    }

    public void setMinified(TextResource minified) {
        this.minified = minified;
    }

    public TextResource getDebug() {
        return debug;
    }

    public void setDebug(TextResource debug) {
        this.debug = debug;
    }
}
