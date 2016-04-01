package gwt.material.design.addins.client.richeditor;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.client.base.MaterialWidget;


public class MaterialRichEditor extends MaterialWidget {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectDebugJs(MaterialRichEditorDebugClientBundle.INSTANCE.summernoteDebugJs());
            MaterialResourceInjector.injectDebugJs(MaterialRichEditorDebugClientBundle.INSTANCE.bootstrapDebugJs());
            MaterialResourceInjector.injectCss(MaterialRichEditorDebugClientBundle.INSTANCE.summernoteDebugCss());
            MaterialResourceInjector.injectCss(MaterialRichEditorDebugClientBundle.INSTANCE.bootswatchDebugCss());
        } else {
            MaterialResourceInjector.injectJs(MaterialRichEditorClientBundle.INSTANCE.summernoteJs());
            MaterialResourceInjector.injectJs(MaterialRichEditorClientBundle.INSTANCE.bootstrapJs());
            MaterialResourceInjector.injectCss(MaterialRichEditorClientBundle.INSTANCE.summernoteCss());
            MaterialResourceInjector.injectCss(MaterialRichEditorClientBundle.INSTANCE.bootswatchCss());
        }
    }

    public MaterialRichEditor() {
        super(Document.get().createDivElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initRichEditor(getElement());
    }

    private native void initRichEditor(Element e) /*-{
        $wnd.jQuery(document).ready(function() {
            $wnd.jQuery(e).summernote();
        });
    }-*/;

}
