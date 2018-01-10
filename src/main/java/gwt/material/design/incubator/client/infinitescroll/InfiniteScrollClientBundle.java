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
package gwt.material.design.incubator.client.infinitescroll;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface InfiniteScrollClientBundle extends ClientBundle {
    InfiniteScrollClientBundle INSTANCE = GWT.create(InfiniteScrollClientBundle.class);

    @Source("resources/js/ScrollMagic.min.js")
    TextResource scrollMagicJs();

    @Source("resources/js/debug.addIndicators.min.js")
    TextResource addIndicatorsPluginJs();

    @Source("resources/css/infinite-scroll.min.css")
    TextResource infiniteScrollCss();
}
