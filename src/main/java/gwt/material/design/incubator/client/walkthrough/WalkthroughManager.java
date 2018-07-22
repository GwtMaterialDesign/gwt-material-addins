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
package gwt.material.design.incubator.client.walkthrough;

import com.google.gwt.user.client.Cookies;

import java.util.Date;

public class WalkthroughManager {

    public static void register(String userName, String appName) {
        final long DURATION = 1000 * 60 * 60 * 24 * 14; //duration remembering login - 2 weeks
        Date expires = new Date(System.currentTimeMillis() + DURATION);
        Cookies.setCookie(userName, appName, expires, null, "/", false);
    }

    public static boolean hasWalkthrough(String userName, String appName) {
        String value = Cookies.getCookie(userName);
        if (value != null && !value.isEmpty() && appName.equals(value)) {
            return false;
        }

        if (value == null) {
            register(userName, appName);
        }

        return true;
    }

    public static void unregister(String userName, String appName) {
        String value = Cookies.getCookie(userName);

        if (appName.equals(value)) {
            Cookies.removeCookie(userName);
        }
    }
}
