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
package gwt.material.design.addins.client.circularprogress.events;

import com.google.gwt.event.shared.HasHandlers;

/**
 * Interface that defines widgets that contains Circular Progress Handlers.
 *
 * @author kevzlou7979
 */
public interface HasCircularProgressHandlers extends HasHandlers {

    /**
     * Adds a Circular progress handler.
     */
    void addProgressHandler(ProgressEvent.ProgressHandler handler);

    /**
     * Adds a Start handler.
     */
    void addStartHandler(StartEvent.StartHandler handler);

    /**
     * Adds a Complete handler.
     */
    void addCompleteHandler(CompleteEvent.CompleteHandler handler);
}
