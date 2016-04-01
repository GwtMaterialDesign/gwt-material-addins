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


import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.client.base.MaterialWidget;

public class MaterialRichEditor extends MaterialWidget {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectDebugJs(MaterialRichEditorDebugClientBundle.INSTANCE.richEditorDebugJs());
        } else {
            MaterialResourceInjector.injectJs(MaterialRichEditorClientBundle.INSTANCE.richEditorJs());
        }
    }

    public MaterialRichEditor() {
        super(Document.get().createTextAreaElement());
        setStyleName("richeditor");
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        String id = DOM.createUniqueId();
        setId(id);
        initRichEditor(id);
    }

    private native void initRichEditor(String selector) /*-{
        $wnd.jQuery(document).ready(function() {
            $wnd.tinymce.init({ selector:'#' + selector });
        });
    }-*/;
}
