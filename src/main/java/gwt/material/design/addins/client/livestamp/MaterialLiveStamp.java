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
package gwt.material.design.addins.client.livestamp;

import com.google.gwt.core.client.GWT;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialLabel;

import java.util.Date;

//@formatter:off

/**
 * The livestamp will update automatically as time goes by.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 * <ma:livestamp.MaterialLiveStamp ui:field="livestamp" float="LEFT" fontWeight="BOLD" marginLeft="8"/>
 * // Configure the dates
 * livestamp.setDate(new Date(115, 2, 1));
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#livestamp">Material Live Stamp</a>
 */
public class MaterialLiveStamp extends MaterialLabel {

    private boolean initialized;
    private Date date = new Date();

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialLiveStampDebugClientBundle.INSTANCE.momentDebugJs());
            MaterialDesignBase.injectDebugJs(MaterialLiveStampDebugClientBundle.INSTANCE.liveStampDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialLiveStampClientBundle.INSTANCE.momentJs());
            MaterialDesignBase.injectJs(MaterialLiveStampClientBundle.INSTANCE.liveStampJs());
        }
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // TODO Implement JSLoader
        if (date != null) {
            getElement().setAttribute("data-livestamp", date.toString());
        } else {
            GWT.log("You must specify the date value.", new IllegalStateException());
        }
    }

    /**
     * Get the date for the livestamp (Default : Today)
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the date for the livestamp (Default : Today)
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
