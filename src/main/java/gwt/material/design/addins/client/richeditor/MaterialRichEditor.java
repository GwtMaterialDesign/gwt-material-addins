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
            MaterialResourceInjector.injectCss(MaterialRichEditorDebugClientBundle.INSTANCE.richEditorDebugCss());
        } else {
            MaterialResourceInjector.injectJs(MaterialRichEditorClientBundle.INSTANCE.richEditorJs());
            MaterialResourceInjector.injectCss(MaterialRichEditorClientBundle.INSTANCE.richEditorCss());
        }
    }

    public MaterialRichEditor() {
        super(Document.get().createTextAreaElement());
        setStyleName("editor");
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        String id = DOM.createUniqueId();
        setId(id);
        initRichEditor(id);
    }

    private native void initRichEditor(String selector) /*-{
        var toolbar = [
            ['style', ['style', 'bold', 'italic', 'underline', 'strikethrough', 'clear']],
            ['fonts', ['fontsize', 'fontname']],
            ['color', ['color']],
            ['undo', ['undo', 'redo', 'help']],
            ['ckMedia', ['ckImageUploader', 'ckVideoEmbeeder']],
            ['misc', ['link', 'picture', 'table', 'hr', 'codeview', 'fullscreen']],
            ['para', ['ul', 'ol', 'paragraph', 'leftButton', 'centerButton', 'rightButton', 'justifyButton', 'outdentButton', 'indentButton']],
            ['height', ['lineheight']],
        ];

        $wnd.jQuery('.editor').materialnote({
            toolbar: toolbar,
            height: 550,
            minHeight: 100,
            defaultBackColor: '#777',
            defaultTextColor: '#fff'
        });

        $wnd.jQuery('.editorAir').materialnote({
            airMode: true,
            airPopover: [
                ['color', ['color']],
                ['font', ['bold', 'underline', 'clear']],
                ['para', ['ul', 'paragraph']],
                ['table', ['table']],
                ['insert', ['link', 'picture']]
            ]
        });
    }-*/;
}
