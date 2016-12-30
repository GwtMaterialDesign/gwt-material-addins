package gwt.material.design.addins.client;

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.countup.MaterialCountUp;

public class MaterialCountUpTest extends MaterialAddinsTest {

    public void init() {
        MaterialCountUp countUp = new MaterialCountUp();
        RootPanel.get().add(countUp);
        checkWidget(countUp);
        checkProperties(countUp);
    }

    protected <T extends MaterialCountUp> void checkProperties(T carousel) {
        carousel.setStartValue(0);
        carousel.setEndValue(10.5);
        carousel.setSeparator(",");
        carousel.setDecimal(".");
        carousel.setDuration(1000);
        carousel.setDecimals(2);
        carousel.setPrefix("$");
        carousel.setSuffix("US");
        carousel.start();
        assertEquals(carousel.getStartValue(), 0.0);
        assertEquals(carousel.getEndValue(), 10.5);
        assertEquals(carousel.getSeparator(), ",");
        assertEquals(carousel.getDecimal(), ".");
        assertEquals(carousel.getDuration(), 1000.0);
        assertEquals(carousel.getDecimals(), 2.0);
        assertEquals(carousel.getPrefix(), "$");
        assertEquals(carousel.getSuffix(), "US");
    }
}
