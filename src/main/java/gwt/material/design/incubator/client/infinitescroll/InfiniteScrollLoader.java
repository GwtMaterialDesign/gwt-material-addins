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
package gwt.material.design.incubator.client.infinitescroll;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.OverlayOption;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

//@formatter:off

/**
 * Scroll Loader widget - shown when loading data thru {@link InfiniteScrollPanel#load(int, int)}
 *
 * @author kevzlou7979
 */
public class InfiniteScrollLoader extends MaterialWidget {

    private String message = "Loading";
    private InfiniteScrollPanel parent;
    private MaterialLoader loader;
    OverlayOption option = OverlayOption.create();

    public InfiniteScrollLoader() {
        super(Document.get().createDivElement(), IncubatorCssName.INFINITE_SCROLL_LOADER);

        setupLoader();
    }

    public InfiniteScrollLoader(String message) {
        this();

        this.message = message;
    }

    protected void setupLoader() {
        loader = new MaterialLoader();
        loader.setContainer(this);
        loader.setMessage(message);
    }

    /**
     * Will attach a loader to it's parent
     */
    public void show() {
        loader.show();
        parent.add(this);
    }

    /**
     * Will detach a loader to it's parent
     */
    public void hide() {
        loader.hide();
        removeFromParent();
    }

    /**
     * Will check if the loading indicator still attached to it's parent
     */
    public boolean isLoading() {
        return isAttached();
    }

    public void setParent(InfiniteScrollPanel parent) {
        this.parent = parent;
    }
}
