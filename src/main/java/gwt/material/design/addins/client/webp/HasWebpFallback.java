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

public interface HasWebpFallback {

    /**
     * Will set the fallback support for other browser that does'nt support WEBP.
     *
     * @param fallbackUrl - the fallback image url (i.e /images/sample.png)
     */
    void setFallbackUrl(String fallbackUrl);

    String getFallbackUrl();

    /**
     * Will set the fallback extension of the url provided by {@link MaterialWebpImage#setUrl(String)}.
     *
     * @param extension - file extension to be replaced in .webp (i.e png)
     */
    void setFallbackExtension(String extension);

    String getFallbackExtension();
}
