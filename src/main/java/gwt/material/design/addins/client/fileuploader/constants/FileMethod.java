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
package gwt.material.design.addins.client.fileuploader.constants;

import gwt.material.design.client.constants.CssType;

import java.util.Objects;

/**
 * Defaults to "post" and can be changed to "put" if necessary.
 *
 * @author kevzlou7979
 */
public enum FileMethod implements CssType {
    POST("post"),
    PUT("put");

    private final String cssClass;

    FileMethod(final String cssClass) {
        this.cssClass = cssClass;
    }

    public static FileMethod fromStyleName(final String styleName) {
        for (FileMethod method : FileMethod.values()) {
            if (Objects.equals(method.getCssName(), styleName)) {
                return method;
            }
        }
        return POST;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }
}