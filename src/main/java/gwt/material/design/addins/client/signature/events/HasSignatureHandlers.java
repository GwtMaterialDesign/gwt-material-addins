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
package gwt.material.design.addins.client.signature.events;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * @author kevzlou7979
 */
public interface HasSignatureHandlers {

    /**
     * Fired once signature canvas has been cleared.
     */
    HandlerRegistration addSignatureClearHandler(SignatureClearEvent.SignatureClearHandler handler);

    /**
     * Fired once signature drawing was started.
     */
    HandlerRegistration addSignatureStartHandler(SignatureStartEvent.SignatureStartHandler handler);

    /**
     * Fired once signature drawing was ended.
     */
    HandlerRegistration addSignatureEndHandler(SignatureEndEvent.SignatureEndHandler handler);
}
