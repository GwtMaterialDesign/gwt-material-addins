package gwt.material.design.addins.client.combobox.async;

import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.async.loader.AsyncDisplayLoader;
import gwt.material.design.client.constants.LoaderType;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialToast;

import java.util.List;

public class DefaultComboBoxDisplayLoader<T> implements AsyncDisplayLoader<List<T>> {

    private MaterialComboBox comboBox;
    private MaterialLoader loader;

    public DefaultComboBoxDisplayLoader(MaterialComboBox comboBox) {
        this.comboBox = comboBox;

        setupLoader();
    }

    protected void setupLoader() {
        loader = new MaterialLoader();
        loader.setType(LoaderType.PROGRESS);
        loader.setContainer(comboBox);
    }

    @Override
    public void loading() {
        loader.show();
    }

    @Override
    public void success(List<T> result) {
        MaterialToast.fireToast(result.size() + " SIZE");
    }

    @Override
    public void failure(String error) {

    }

    @Override
    public void finalize() {
        loader.hide();
    }
}
