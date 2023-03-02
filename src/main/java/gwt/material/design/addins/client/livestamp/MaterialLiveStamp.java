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

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.livestamp.js.JsLiveStamp;
import gwt.material.design.addins.client.moment.resources.MomentClientBundle;
import gwt.material.design.addins.client.moment.resources.MomentClientDebugBundle;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.AbstractValueWidget;

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
 * @see <a href="https://github.com/mattbradley/livestampjs">LiveStamp 1.1.2</a>
 */
public class MaterialLiveStamp extends AbstractValueWidget<Date> {

    private Date value = new Date();

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MomentClientDebugBundle.INSTANCE.momentLocale());
            MaterialDesignBase.injectDebugJs(MaterialLiveStampDebugClientBundle.INSTANCE.liveStampDebugJs());
        } else {
            MaterialDesignBase.injectJs(MomentClientBundle.INSTANCE.momentWithLocale());
            MaterialDesignBase.injectJs(MaterialLiveStampClientBundle.INSTANCE.liveStampJs());
        }
    }

    public MaterialLiveStamp() {
        super(Document.get().createSpanElement());
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        destroy();
    }

    @Override
    public void setValue(Date value, boolean fireEvents) {
        super.setValue(value, fireEvents);
        this.value = value;

        if (value != null) {
            getElement().setAttribute("data-livestamp", value.toString());
        } else {
            destroy();
        }
    }

    public void destroy() {
        JsLiveStamp.$(getElement()).livestamp("destroy");
        getElement().setInnerText("-");
    }

    @Override
    public Date getValue() {
        return value;
    }
}
