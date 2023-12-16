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

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.incubator.client.base.IncubatorWidget;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Another progress bar that provides an individual blocks
 * to produce a bar item to indicate how many percent the '
 * current progress is.
 *
 * <p><i>
 * Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
public class ProgressLineBar<T> extends AbstractAddinsWidget {

    static {
        IncubatorWidget.showWarning(ProgressLineBar.class);
    }

    private Map<T, ProgressLineBarItem> options = new HashMap<>();
    private List<T> values;

    public ProgressLineBar() {
        super(Document.get().createDivElement(), "progress-line-bar");
    }

    @Override
    protected void internalLoad() {
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

    public void setActive(int index) {
        if (index < 0) {
            GWT.log("Index must be greater than 0", new IllegalStateException());
            return;
        }

        if (options.size() <= 0) {
            GWT.log("No values has been added to the options.", new IllegalStateException());
            return;
        }
        options.get(index).setActive(true);
    }

    @Override
    public Class<? extends DarkThemeLoader> getDarkTheme() {
        return ProgressLineBarDarkTheme.class;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(ProgressLineBarClientBundle.INSTANCE.progressLineBarCss(), ProgressLineBarDebugClientBundle.INSTANCE.progressLineBarDebugCss()));
    }
}
