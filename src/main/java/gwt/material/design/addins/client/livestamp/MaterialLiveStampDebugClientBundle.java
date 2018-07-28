/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.livestamp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Client Bundle for Live Stamp component
 *
 * @author kevzlou7979
 */
interface MaterialLiveStampDebugClientBundle extends ClientBundle {

    MaterialLiveStampDebugClientBundle INSTANCE = GWT.create(MaterialLiveStampDebugClientBundle.class);

    @Source("resources/js/livestamp.js")
    TextResource liveStampDebugJs();

    @Source("resources/js/moment.js")
    TextResource momentDebugJs();
}
