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
package gwt.material.design.addins.client.pathanimator.base;

import com.google.gwt.dom.client.Element;
import gwt.material.design.client.constants.Color;

/**
 * Accessing the Path Navigation Bridge element that performs
 * the illusion that the source element is path animated to target element.
 *
 * @author kevzlou7979@gmail.com
 */
public interface HasPathStyles {

    /**
     * Set the shadow of the bridge element
     */
    void setShadow(Integer depth);

    /**
     * Set the background color of the bridge element
     */
    void setBackgroundColor(Color color);

    /**
     * Set the css style property directly to the bridge element
     */
    void setStyleProperty(PathStyleProperty property);

    /**
     * Set the css style property directly to the bridge element
     * with parameters.
     */
    void setStyleProperty(String property, String value);

    /**
     * Clears the style property provided
     */
    void clearStyleProperty(String property);

    /**
     * Will clear all the styles of the bridge element.
     */
    void clearStyles();
}
