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
package gwt.material.design.addins.client.masonry.js;

import gwt.material.design.addins.client.base.constants.AddinsCssName;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for masonry component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsMasonryOptions {

    private JsMasonryOptions() {}

    @JsOverlay
    public static final JsMasonryOptions create() {
        JsMasonryOptions options = new JsMasonryOptions();
        options.itemSelector = ".masonry > .col";
        options.columnWidth = "." + AddinsCssName.COL_SIZER;
        options.percentPosition = true;
        options.originLeft = true;
        options.originTop = true;
        options.transitionDuration = "400ms";
        return options;
    }

    @JsProperty
    public String itemSelector;

    @JsProperty
    public String columnWidth;

    @JsProperty
    public int gutter;

    @JsProperty
    public boolean horizontalOrder;

    @JsProperty
    public boolean percentPosition;

    @JsProperty
    public String stamp;

    @JsProperty
    public boolean fitWidth;

    @JsProperty
    public boolean originLeft;

    @JsProperty
    public boolean originTop;

    @JsProperty
    public int stagger;

    @JsProperty
    public boolean resize;

    @JsProperty
    public boolean initLayout;

    @JsProperty
    public String transitionDuration;
}
