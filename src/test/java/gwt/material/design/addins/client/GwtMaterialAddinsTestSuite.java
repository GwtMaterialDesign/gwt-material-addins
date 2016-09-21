package gwt.material.design.addins.client;

import com.google.gwt.junit.tools.GWTTestSuite;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import junit.framework.Test;
import junit.framework.TestCase;

public class GwtMaterialAddinsTestSuite extends TestCase {

    public static Test suite() {
        final GWTTestSuite suite = new GWTTestSuite("gwt-material-addins test suite");
        suite.addTestSuite(AutocompleteTest.class);
        suite.addTestSuite(TimePickerTest.class);
        return suite;
    }
}
