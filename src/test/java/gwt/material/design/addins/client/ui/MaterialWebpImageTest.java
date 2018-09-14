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
import gwt.material.design.addins.client.webp.MaterialWebpImage;

/**
 * Test case for avatar component
 *
 * @author kevzlou7979
 */
public class MaterialWebpImageTest extends MaterialWidgetTest<MaterialWebpImage> {

    static final String URL = "sample.webp";
    static final String FALLBACK_URL = "sample.png";
    static final String FALLBACK_EXTENSION = "png";

    @Override
    protected MaterialWebpImage createWidget() {
        return new MaterialWebpImage();
    }

    public void testFallbackUrl() {
        // given
        MaterialWebpImage materialWebpImage = getWidget(false);

        // when / then
        checkFallbackUrl(materialWebpImage);

        // given
        attachWidget();

        // when / then
        checkFallbackUrl(materialWebpImage);
    }

    protected void checkFallbackUrl(MaterialWebpImage materialWebpImage) {
        materialWebpImage.setUrl(URL);
        assertEquals(URL, materialWebpImage.getUrl());

        materialWebpImage.setFallbackUrl(FALLBACK_URL);
        assertEquals(FALLBACK_URL, materialWebpImage.getFallbackUrl());
        materialWebpImage.setFallbackUrl(null);
        assertNull(materialWebpImage.getFallbackUrl());
    }

    protected String generateFallbackAttribute() {
        return "this.onerror=null; this.src='" + FALLBACK_URL + "'";
    }

    public void testFallbackExtension() {
        // given
        MaterialWebpImage materialWebpImage = getWidget(false);
        materialWebpImage.setUrl(URL);
        assertEquals(URL, materialWebpImage.getUrl());

        materialWebpImage.setFallbackExtension(FALLBACK_EXTENSION);
        assertEquals(FALLBACK_EXTENSION, materialWebpImage.getFallbackExtension());
    }
}
