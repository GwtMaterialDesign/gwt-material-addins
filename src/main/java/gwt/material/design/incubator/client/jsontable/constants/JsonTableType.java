/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.jsontable.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

/**
 * Used by {@link gwt.material.design.incubator.client.jsontable.JsonTable#setType(JsonTableType)}
 *
 * @author kevzlou7979@gmail.com
 */
public enum JsonTableType implements CssType {

    NONE(""),
    STRIPED("striped"),
    BORDERED("bordered"),
    HIGHLIGH("highlight"),
    CENTERED("centered");

    private final String cssClass;

    JsonTableType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static JsonTableType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, JsonTableType.class, JsonTableType.STRIPED);
    }
}

