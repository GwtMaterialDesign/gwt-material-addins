package gwt.material.design.addins.client;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.TextResource;
import gwt.material.design.addins.client.resources.MaterialAddinsResourcesDebug;

/**
 * Created by Mark Kevin on 11/26/2015.
 */
public class MaterialAddinsDebug extends MaterialAddinsBase implements EntryPoint {

    @Override
    public void onModuleLoad() {
        load();
    }

    @Override
    public void load() {
        inject(MaterialAddinsResourcesDebug.INSTANCE.timepickerJs());
        inject(MaterialAddinsResourcesDebug.INSTANCE.subHeaderJs());
        inject(MaterialAddinsResourcesDebug.INSTANCE.pathAnimatorJs());
        inject(MaterialAddinsResourcesDebug.INSTANCE.waterfallJs());
        inject(MaterialAddinsResourcesDebug.INSTANCE.scrollFireJs());
        inject(MaterialAddinsResourcesDebug.INSTANCE.bubbleJs());
        inject(MaterialAddinsResourcesDebug.INSTANCE.interactJs());
        inject(MaterialAddinsResourcesDebug.INSTANCE.masonryJs());
        inject(MaterialAddinsResourcesDebug.INSTANCE.tinymceJs());
    }
}
