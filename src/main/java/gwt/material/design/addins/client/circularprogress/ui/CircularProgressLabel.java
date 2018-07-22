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
package gwt.material.design.addins.client.circularprogress.ui;

import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.ui.html.Span;

public class CircularProgressLabel extends Span {

    public CircularProgressLabel() {
        setInitialClasses(AddinsCssName.CIRCULAR_LABEL);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
    }

    public void setSize(double size, boolean responsive) {
        String width = "";
        String height = "";
        String lineHeight = "";
        if (responsive) {
            width = "100%";
            height = "100%";
            lineHeight = "calc(50% - " + getElement().getStyle().getFontSize() + "px";
        } else {
            width = size + "px";
            height = size + "px";
            lineHeight = size + "px";
        }
        setWidth(width);
        setHeight(height);
        getElement().getStyle().setProperty("lineHeight", lineHeight);
    }
}
