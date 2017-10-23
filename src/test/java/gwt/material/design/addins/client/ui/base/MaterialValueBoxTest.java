package gwt.material.design.addins.client.ui.base;

import gwt.material.design.client.ui.MaterialValueBox;
import org.junit.Ignore;

@Ignore
public abstract class MaterialValueBoxTest<T extends MaterialValueBox> extends gwt.material.design.client.ui.MaterialValueBoxTest<T> {

    @Override
    public String getModuleName() {
        return "gwt.material.design.addins.GwtMaterialAddins";
    }
}
