/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
