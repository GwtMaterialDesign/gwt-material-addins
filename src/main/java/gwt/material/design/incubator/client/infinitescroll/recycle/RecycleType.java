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
package gwt.material.design.incubator.client.infinitescroll.recycle;

/**
 * Recycle Type - provide a recycling mechanism managed by {@link RecycleManager}.
 *
 * @author kevzlou7979
 */
public enum RecycleType {

    /**
     * Will recycle the widgets affecting only it's display by setting the
     * css {@link com.google.gwt.dom.client.Style.Display} property to BLOCK or NONE
     */
    DISPLAY,
    /**
     * Will recycle the widgets on it's DOM structure by attaching or detaching the widgets
     */
    DETACH
}
