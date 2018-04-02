package gwt.material.design.addins.client.inputmask;

public class MaterialTextInputMask extends MaterialInputMask<String> {

    @Override
    public String getValue() {
        return getCleanValue();
    }
}
