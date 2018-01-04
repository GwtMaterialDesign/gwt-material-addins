package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.events.ClickLabelEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.ClickMarkerEvent;

public interface HasLegendHandlers {

    void addClickLabelHandler(ClickLabelEvent.ClickLabelHandler handler);

    void addClickMarkerHandler(ClickMarkerEvent.ClickMarkerHandler handler);
}
