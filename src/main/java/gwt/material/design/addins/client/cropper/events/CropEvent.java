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
package gwt.material.design.addins.client.cropper.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class CropEvent extends GwtEvent<CropEvent.CropHandler> {

    private String result;

    public interface CropHandler extends EventHandler {
        void onCrop(CropEvent event);
    }

    public static final Type<CropEvent.CropHandler> TYPE = new Type<>();

    public CropEvent(String result) {
        this.result = result;
    }

    public static void fire(HasHandlers source, String result) {
        source.fireEvent(new CropEvent(result));
    }

    @Override
    public Type<CropEvent.CropHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CropEvent.CropHandler handler) {
        handler.onCrop(this);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}