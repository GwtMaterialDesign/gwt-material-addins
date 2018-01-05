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
package gwt.material.design.incubator.client.chart.amcharts.events.trendline;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.object.TrendLineData;
//@formatter:off

/**
 * Dispatched when user clicks on a trend line.
 *
 * @author kevzlou7979
 */
public class TrendLineClickEvent extends GwtEvent<TrendLineClickEvent.TrendLineClickHandler> {

    public static final Type<TrendLineClickHandler> TYPE = new Type<>();
    private TrendLineData data;

    public TrendLineClickEvent(TrendLineData data) {
        this.data = data;
    }

    public static Type<TrendLineClickHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, TrendLineData data) {
        source.fireEvent(new TrendLineClickEvent(data));
    }

    @Override
    public Type<TrendLineClickHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(TrendLineClickHandler handler) {
        handler.onTrendLineClick(this);
    }

    public TrendLineData getData() {
        return data;
    }

    public interface TrendLineClickHandler extends EventHandler {
        void onTrendLineClick(TrendLineClickEvent event);
    }
}
