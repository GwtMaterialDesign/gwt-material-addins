/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.client.ui.MaterialPanel;

/**
 * Test case for path animator component
 *
 * @author kevzlou7979
 */
public class MaterialPathAnimatorTest extends MaterialAddinsTest {

    public void init() {
        checkBasic();
    }

    protected void checkBasic() {
        MaterialPanel source = new MaterialPanel();
        MaterialPanel target = new MaterialPanel();
        RootPanel.get().add(source);
        RootPanel.get().add(target);

        target.setVisibility(Style.Visibility.HIDDEN);
        target.setOpacity(0);
        assertEquals(target.getElement().getStyle().getVisibility(), "hidden");
        assertEquals(target.getElement().getStyle().getOpacity(), "0");
        MaterialPathAnimator.animate(source, target);
        MaterialPathAnimator.reverseAnimate(source, target);
    }
}