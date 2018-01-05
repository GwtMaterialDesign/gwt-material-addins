package gwt.material.design.incubator.client.chart.amcharts.events;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.events.gauge.ClickBandEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.gauge.RollOutBandEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.gauge.RollOverBandEvent;

public interface HasGaugeAxisHandlers {

    /**
     * Event which is fired when user clicks on gauge band.
     */
    HandlerRegistration addClickBandHandler(ClickBandEvent.ClickBandHandler handler);

    /**
     * Event which is fired when user rolls-out gauge band.
     */
    HandlerRegistration addRollOutBandHandler(RollOutBandEvent.ClickLabelHandler handler);

    /**
     * Event which is fired when user rolls-over gauge band.
     */
    HandlerRegistration addRollOverBandHandler(RollOverBandEvent.ClickLabelHandler handler);
}
