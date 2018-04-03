package gwt.material.design.addins.client.inputmask;

public class MaterialDoubleInputMask extends MaterialInputMask<Double> {

    @Override
    public Double getValue() {
        return Double.parseDouble(getCleanValue());
    }

    @Override
    public void setValue(Double value) {
        super.setValue(Double.parseDouble(getCleanValue()));
    }
}
