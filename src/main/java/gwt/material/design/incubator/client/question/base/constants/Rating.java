/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.question.base.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.CssType;

import java.util.Arrays;

public enum  Rating implements CssType {

    NONE(0, "none"),
    POOR(1, "Poor"),
    FAIR(2, "Fair"),
    NEUTRAL(3, "Neutral"),
    GOOD(4, "Good"),
    EXCELLENT(5, "Excellent");

    private int value;
    private String name;

    Rating(int type, String name) {
        this.value = type;
        this.name = name;
    }

    @Override
    public String getCssName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static Rating fromName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, Rating.class, Rating.NONE);
    }

    public static Rating fromValue(int value) {
        return Arrays.stream(values()).filter(rating -> rating.getValue() == value).findAny().orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
