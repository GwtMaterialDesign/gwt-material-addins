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
package gwt.material.design.addins.client.ui;

import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.bubble.MaterialBubble;
import gwt.material.design.addins.client.cropper.MaterialImageCropper;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Position;

/**
 * Test case for bubble component
 *
 * @author kevzlou7979
 */
public class MaterialImageCropperTest extends MaterialWidgetTest<MaterialImageCropper> {

    @Override
    protected MaterialImageCropper createWidget() {
        return new MaterialImageCropper();
    }
}
