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
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.client.constants.CssName;

import java.util.Collections;
import java.util.List;

public class MaterialTimeLine extends AbstractAddinsWidget {

    @Override
    protected void internalLoad() {

    }

    public MaterialTimeLine() {
        super(Document.get().createDivElement(), AddinsCssName.TIMELINE, CssName.ROW);
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(MaterialTimeLineClientBundle.INSTANCE.timelineCss(), MaterialTimeLineDebugClientBundle.INSTANCE.timeLineCssDebug()));
    }

}
