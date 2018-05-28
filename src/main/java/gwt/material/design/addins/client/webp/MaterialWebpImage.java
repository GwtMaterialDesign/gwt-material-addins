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
import com.google.gwt.user.client.ui.Image;
import gwt.material.design.client.base.mixin.AttributeMixin;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.jquery.client.api.Functions;

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
public class MaterialWebpImage extends MaterialImage implements HasWebpFallback {

    private String fallbackUrl;
    private String fallbackExtension;

    @Override
    protected void onLoad() {
        super.onLoad();

        checkWebpSupport();
    }

    protected void setFallbackAttribute(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
    }

    @Override
    public void setFallbackUrl(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        setFallbackAttribute(fallbackUrl);
    }

    @Override
    public String getFallbackUrl() {
        return fallbackUrl;
    }

    @Override
    public void setFallbackExtension(String fallbackExtension) {
        this.fallbackExtension = fallbackExtension;
        if (fallbackExtension != null) {
            if (isAttached()) {
                extractFallbackExtension(fallbackExtension);
            } else {
                registerHandler(addAttachHandler(attachEvent -> extractFallbackExtension(fallbackExtension)));
            }
        } else {
            GWT.log("Fallback Extension must not be null", new NullPointerException());
        }
    }

    protected void extractFallbackExtension(String fallbackExtension) {
        if (getUrl() != null && !getUrl().isEmpty()) {
            String fallbackUrl = getUrl();
            if (fallbackUrl.indexOf(".") > 0) {
                fallbackUrl = fallbackUrl.substring(0, fallbackUrl.lastIndexOf(".")) + "." + fallbackExtension;
                setFallbackUrl(fallbackUrl);
            }
            return;
        } else {
            GWT.log("Url must not be null or empty", new IllegalStateException());
        }
    }

    @Override
    public String getFallbackExtension() {
        return fallbackExtension;
    }

    public void checkWebpSupport() {
        Image image = new Image();
        image.setUrl("data:image/webp;base64,UklGRjoAAABXRUJQVlA4IC4AAACyAgCdASoCAAIALmk0mk0iIiIiIgBoSygABc6WWgAA/veff/0PP8bA//LwYAAA");
        image.addLoadHandler(loadEvent -> {
            setUrl(getUrl());
        });
        image.addErrorHandler(errorEvent -> {
            setUrl(getFallbackUrl());
        });
        add(image);
    }
}
