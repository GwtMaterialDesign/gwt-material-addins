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
package gwt.material.design.addins.client.timeline;

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.base.MaterialWidget;

public class MaterialTimeLineHeader extends MaterialWidget {

    public MaterialTimeLineHeader() {
        super(Document.get().createDivElement(), AddinsCssName.TIMELINE_HEADER);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        setGrid("s2 m2 l2");
    }
}
