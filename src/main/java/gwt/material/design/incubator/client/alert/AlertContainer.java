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
package gwt.material.design.incubator.client.alert;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

//@formatter:off

/**
 * Alert Container is a container to wrap all Alert components.
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 *      Alert alert = new Alert();
 *      alert.setText("This is an error");
 *      alert.setType(AlertType.ERROR);
 *      alert.open();
 * }
 * </pre>
 *
 * @author kevzlou7979
 */
public class AlertContainer extends MaterialWidget {

    static {
        Alert.loadResources();
    }

    public AlertContainer() {
        super(Document.get().createDivElement(), IncubatorCssName.ALERT_CONTAINER);
    }
}
