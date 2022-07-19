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

import gwt.material.design.addins.client.fileuploader.js.XHR;

/**
 * Upload Response with Code (e.g 404, 503, 200) and message ("File Upload url not found etc."
 *
 * @author kevzlou7979
 */
public class UploadResponse {

    private String response;
    private int code;
    private String message;
    private String body;
    private XHR xhr;

    public UploadResponse() {
    }

    public UploadResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public UploadResponse(int code, String message, String body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public UploadResponse(String response, int code, String message, String body) {
        this.response = response;
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public XHR getXhr() {
        return xhr;
    }

    public void setXhr(XHR xhr) {
        this.xhr = xhr;
    }
}
