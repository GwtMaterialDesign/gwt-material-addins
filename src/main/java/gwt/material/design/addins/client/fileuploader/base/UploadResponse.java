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
package gwt.material.design.addins.client.fileuploader.base;

import elemental2.dom.XMLHttpRequest;

/**
 * Upload Response with Code (e.g 404, 503, 200) and message ("File Upload url not found etc."
 *
 * @author kevzlou7979
 */
public class UploadResponse {

    private String code;
    private String message;
    private String body;
    private final XMLHttpRequest xhr;

    public UploadResponse(XMLHttpRequest xhr) {
        this.code = String.valueOf(xhr.status);
        this.message = xhr.statusText;
        this.xhr=xhr;
    }

    public UploadResponse(XMLHttpRequest xhr, String body) {
        this.code = String.valueOf(xhr.status);
        this.message = xhr.statusText;
        this.body = body;
        this.xhr=xhr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public XMLHttpRequest getXhr() {
        return xhr;
    }
}
