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
package gwt.material.design.incubator.client.chart.amcharts.base.constants;

public enum DragIcon {

    DRAG_ICON_RECT_BIG("dragIconRectBig"),
    DRAG_ICON_RECT_BIG_BLACK("dragIconRectBigBlack"),
    DRAG_ICON_RECT_SMALL("dragIconRectSmall"),
    DRAG_ICON_RECT_SMALL_BLACK("dragIconRectSmallBlack"),
    DRAG_ICON_ROUND_BIG("dragIconRoundBig"),
    DRAG_ICON_ROUND_BIG_BLACK("dragIconRoundBigBlack"),
    DRAG_ICON_ROUND_SMALL("dragIconRoundSmall"),
    DRAG_ICON_ROUND_SMALL_BLACK("dragIconRoundSmallBlack");

    private String name;

    DragIcon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
