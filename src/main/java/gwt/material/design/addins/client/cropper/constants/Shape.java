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
package gwt.material.design.addins.client.cropper.constants;

import com.google.gwt.dom.client.Style;
import gwt.material.design.addins.client.subheader.constants.SubHeaderType;
import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.CssType;

/**
 * The cropper guideline shape within the viewport defaults to {@link #SQUARE}
 *
 * @author kevzlou7979
 */
public enum  Shape implements CssType {

    SQUARE("square"),
    CIRCLE("circle");

    private String name;

    Shape(String name) {
        this.name = name;
    }

    @Override
    public String getCssName() {
        return name;
    }

    public static Shape fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, Shape.class, SQUARE);
    }
}
