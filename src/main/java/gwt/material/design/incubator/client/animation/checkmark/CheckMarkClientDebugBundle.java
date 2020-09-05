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
package gwt.material.design.incubator.client.animation.checkmark;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import gwt.material.design.incubator.client.daterange.DateRangePicker;

/**
 * Client Bundle for {@link CheckMark}
 *
 * @author kevzlou7979
 */
public interface CheckMarkClientDebugBundle extends ClientBundle {

    CheckMarkClientDebugBundle INSTANCE = GWT.create(CheckMarkClientDebugBundle.class);

    @Source("resources/css/checkmark.css")
    TextResource checkMarkDebugCss();

    @Source("resources/css/checkmark-dark.css")
    TextResource checkMarkDarkCss();
}
