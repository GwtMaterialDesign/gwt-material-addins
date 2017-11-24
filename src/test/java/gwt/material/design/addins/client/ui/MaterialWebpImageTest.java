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
import gwt.material.design.addins.client.avatar.MaterialAvatar;
import gwt.material.design.addins.client.avatar.js.JsAvatar;
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
        MaterialWebpImage webpImage = getWidget(false);

        // when / then
       checkFallbackUrl(webpImage);

       // given
       attachWidget();

       // when / then
       checkFallbackUrl(webpImage);
    }

    protected void checkFallbackUrl(MaterialWebpImage webpImage) {
        webpImage.setUrl(URL);
        assertEquals(URL, webpImage.getUrl());

        webpImage.setFallbackUrl(FALLBACK_URL);
        assertEquals(FALLBACK_URL, webpImage.getFallbackUrl());
        assertEquals(generateFallbackAttribute(), webpImage.getAttributeMixin().getAttribute());
        webpImage.setFallbackUrl(null);
        assertNull(webpImage.getFallbackUrl());
    }

    protected String generateFallbackAttribute() {
        return "this.onerror=null; this.src='" + FALLBACK_URL + "'";
    }

    public void testFallbackExtension() {
        // given
        MaterialWebpImage webpImage = getWidget(false);
        webpImage.setUrl(URL);
        assertEquals(URL, webpImage.getUrl());

        webpImage.setFallbackExtension(FALLBACK_EXTENSION);
        assertEquals(FALLBACK_EXTENSION, webpImage.getFallbackExtension());
        assertEquals(FALLBACK_URL, webpImage.getFallbackUrl());
    }
}
