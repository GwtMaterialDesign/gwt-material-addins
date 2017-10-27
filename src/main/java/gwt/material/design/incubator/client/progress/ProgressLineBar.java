/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.incubator.client.progress;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.AddinsIncubator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressLineBar<T> extends MaterialWidget {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(ProgressLineBarDebugClientBundle.INSTANCE.progressLineBarDebugCss());
        } else {
            MaterialDesignBase.injectCss(ProgressLineBarClientBundle.INSTANCE.progressLineBarCss());
        }
    }

    private Map<T, ProgressLineBarItem> options = new HashMap<>();
    private List<T> values;

    public ProgressLineBar() {
        super(Document.get().createDivElement(), "progress-line-bar");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        double width = 100.00 / options.keySet().size();

        for (T value : options.keySet()) {
            ProgressLineBarItem item = options.get(value);
            item.setWidth(width + "%");
        }

        if (values != null) {
            for (T value : values) {
                ProgressLineBarItem item = options.get(value);
                item.setActive(true);
            }
        }
    }

    public void addOption(T option) {
        ProgressLineBarItem item = new ProgressLineBarItem();
        add(item);
        options.put(option, item);
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
