package gwt.material.design.addins.client.inputmask;

public class MaterialFloatInputMask extends MaterialInputMask<Float> {

    @Override
    public Float getValue() {
        return Float.parseFloat(getCleanValue());
    }

    @Override
    public void setValue(Float value) {
        super.setValue(Float.parseFloat(getCleanValue()));
    }
}
