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
package gwt.material.design.addins.client.webp;

import com.google.gwt.core.client.GWT;
import gwt.material.design.client.base.mixin.AttributeMixin;
import gwt.material.design.client.ui.MaterialImage;

//@formatter:off

/**
 * An extension to {@link MaterialImage} component which supports the latest
 * {@see <a href="https://developers.google.com/speed/webp/">WebP</a>} Image Format.
 * <p>
 * WebP lossless images are 26% smaller in size compared to PNGs. WebP lossy images are
 * 25-34% smaller than comparable JPEG images at equivalent SSIM quality index.
 * <p>
 * <pre>
 * {@code <ma:webp.MaterialWebpImage url="/images/my-image.webp" fallbackUrl="/images/my-image.png"/>
 *
 *     or
 *
 *    <ma:webp.MaterialWebpImage url="/images/my-image.webp" fallbackExtension="png"/>
 *     }
 * </pre>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class MaterialWebpImage extends MaterialImage {

    private String fallbackUrl;
    private String fallbackExtension;
    private AttributeMixin<MaterialWebpImage> attributeMixin;

    /**
     * Will set the fallback support for other browser that does'nt support WEBP.
     *
     * @param fallbackUrl - the fallback image url (i.e /images/sample.png)
     */
    public void setFallbackUrl(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        if (fallbackUrl != null) {
            getAttributeMixin().setAttribute("this.onerror=null; this.src='" + fallbackUrl + "'");
        } else {
            getAttributeMixin().setAttribute(null);
        }
    }

    public String getFallbackUrl() {
        return fallbackUrl;
    }

    /**
     * Will set the fallback extension of the url provided by {@link MaterialWebpImage#setUrl(String)}.
     *
     * @param extension - file extension to be replaced in .webp (i.e png)
     */
    public void setFallbackExtension(String extension) {
        this.fallbackExtension = extension;
        String url = getUrl();
        if (url.isEmpty()) {
            GWT.log("The image url is empty.");
            return;
        }

        if (url.indexOf(".") > 0) {
            url = url.substring(0, url.lastIndexOf(".")) + "." + extension;
            setFallbackUrl(url);
        }
    }

    public String getFallbackExtension() {
        return fallbackExtension;
    }

    public AttributeMixin<MaterialWebpImage> getAttributeMixin() {
        if (attributeMixin == null) {
            attributeMixin = new AttributeMixin<>(this, "onerror");
        }
        return attributeMixin;
    }
}
