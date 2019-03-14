package gwt.material.design.addins.client.inputmask;

import static gwt.material.design.addins.client.inputmask.js.JsInputMask.$;

public class MaterialInputMask extends AbstractInputMask<String> {

    @Override
    public void setValue(String value) {
        super.setValue(value);
        $(valueBoxBase.getElement()).trigger("input", null);
    }

    @Override
    public String getValue() {
        return getCleanValue();
    }
}
