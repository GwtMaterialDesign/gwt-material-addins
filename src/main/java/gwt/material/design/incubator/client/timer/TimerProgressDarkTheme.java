package gwt.material.design.incubator.client.timer;

import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;
import gwt.material.design.incubator.client.AddinsIncubator;

public class TimerProgressDarkTheme extends AddinsWidgetDarkTheme {

    public TimerProgressDarkTheme() {
        super(AddinsIncubator.isDebug() ? TimerProgressDebugClientBundle.INSTANCE.timerDarkCss() : TimerProgressClientBundle.INSTANCE.timerDarkCss());
    }
}
