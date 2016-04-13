package gwt.material.design.addins.client.fileuploader.base;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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


import java.io.Serializable;
import java.util.Date;

/**
 * An object that wraps all file information
 * during the upload process
 */
public class UploadFile implements Serializable {

    private String name;
    private Date lastModified;
    private double fileSize;
    private String type;

    public UploadFile() {}

    public UploadFile(String name, Date lastModified, double fileSize, String type) {
        this.name = name;
        this.lastModified = lastModified;
        this.fileSize = fileSize;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public double getFileSize() {
        double kb = fileSize / 1024;
        return kb / 1024;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
