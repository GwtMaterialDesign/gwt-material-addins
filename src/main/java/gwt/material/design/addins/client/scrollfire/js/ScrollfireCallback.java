package gwt.material.design.addins.client.scrollfire.js;

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


import jsinterop.annotations.JsFunction;

/**
 * Represents a Javascript callback function. This can be used to easily wrap a call into a javascript
 * function. Normally in javascript you would do something like:<br>
 *
 * <pre>
 * <code>callamethod(param, <b>function(){Window.alert("callback");}</b>);</code>
 * </pre>
 *
 * Using this callback function in combination with java lambda expression would look like:
 *
 * <pre>
 * <code>callamethod(param, <b>() -> Window.alert("callback")</b>);</code>
 * </pre>
 *
 *
 */
@JsFunction
public interface ScrollfireCallback {

    /**
     * The method of the Javascript function
     */
    void call();
}
