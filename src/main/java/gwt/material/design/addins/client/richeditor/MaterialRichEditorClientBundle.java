package gwt.material.design.addins.client.richeditor;

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


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Client Bundle for Rich Editor component
 * @author kevzlou7979
 */
interface MaterialRichEditorClientBundle extends ClientBundle {

    MaterialRichEditorClientBundle INSTANCE = GWT.create(MaterialRichEditorClientBundle.class);

    @Source("resources/js/summernote.min.js")
    TextResource summernoteJs();

    @Source("resources/css/summernote.min.css")
    TextResource summernoteCss();

    // For third part lib - bootstrap
    @Source("resources/js/theme/bootstrap.min.js")
    TextResource bootstrapJs();

    @Source("resources/css/theme/bootswatch.min.css")
    TextResource bootswatchCss();

}
