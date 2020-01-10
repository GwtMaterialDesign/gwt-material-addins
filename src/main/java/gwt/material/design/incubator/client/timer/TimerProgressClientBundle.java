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
package gwt.material.design.incubator.client.timer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Client Bundle resources for TimerProgress component<br>
 *
 * @author kevzlou7979
 */
public interface TimerProgressClientBundle extends ClientBundle {
    TimerProgressClientBundle INSTANCE = GWT.create(TimerProgressClientBundle.class);

    @Source("resources/css/timer.min.css")
    TextResource timerCss();

    @Source("resources/css/timer-dark.min.css")
    TextResource timerDarkCss();

    @Source("resources/css/circular.min.css")
    TextResource circularTimerCss();
}
