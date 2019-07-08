package gwt.material.design.addins.client.dnd.event.listener;

import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.dnd.event.InteractDragEvent;

public class DefaultDragMoveEventListener implements DragEventListener {

    @Override
    public void register(InteractDragEvent event) {
        Element target = event.target;

        String dataX = target.getAttribute("data-x");
        String dataY = target.getAttribute("data-y");

        float dx = parseAttributeToFloat(dataX, event.dx);
        float dy = parseAttributeToFloat(dataY, event.dy);

        target.getStyle().setProperty("transform", "translate(" + dx + "px, " + dy + "px)");
        target.setAttribute("data-x", String.valueOf(dx));
        target.setAttribute("data-y", String.valueOf(dy));
    }

    protected float parseAttributeToFloat(String attribute, float dataValue) {
        float value = 0;
        try {
            value = Float.parseFloat(attribute);
        } catch (Exception e) {

        }
        return value + dataValue;
    }
}
