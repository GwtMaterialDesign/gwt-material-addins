package gwt.material.design.addins.client.inputmask;

public class MaterialLongInputMask extends MaterialInputMask<Long> {

    @Override
    public Long getValue() {
        return Long.parseLong(getCleanValue());
    }

    @Override
    public void setValue(Long value) {
        super.setValue(Long.parseLong(getCleanValue()));
    }
}
