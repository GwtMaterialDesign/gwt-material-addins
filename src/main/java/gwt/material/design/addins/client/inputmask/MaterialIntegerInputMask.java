package gwt.material.design.addins.client.inputmask;

public class MaterialIntegerInputMask extends MaterialInputMask<Integer> {

    @Override
    public Integer getValue() {
        return Integer.parseInt(getCleanValue());
    }

    @Override
    public void setValue(Integer value) {
        super.setValue(Integer.parseInt(getCleanValue()));
    }
}
