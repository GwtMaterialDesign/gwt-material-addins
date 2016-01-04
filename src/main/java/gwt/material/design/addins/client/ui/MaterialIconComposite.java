package gwt.material.design.addins.client.ui;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;

//@formatter:off

/**
 * MaterialIconComposite is a composite of one or more {@link MaterialIcon}s,
 * allowing the user to create new icons by combining the existing ones.
 * 
 * <h3>XML Namespace Declaration</h3>
 * 
 * <pre>
 * {@code
 * xmlns:m.addins='urn:import:gwt.material.design.addins.client.ui'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 *
 * <pre>
 * {@code
 * <m.addins:MaterialIconComposite iconType="SEARCH">
 *     <m:MaterialIcon iconType="STAR" textColor="yellow" fontSize="12px" top="-5" right="-14" />
 * </m.addins:MaterialIconComposite>
 * }
 * </pre>
 * 
 * Since MaterialIconComposite extends MaterialIcon, the composition can be used
 * in all places an icon can be inserted, such as in {@link MaterialButton}s:
 * 
 * <pre>
 * {@code
 * <m:MaterialButton text="Edit" textColor="white">
 *     <m.addins:MaterialIconComposite iconType="CHECK_BOX_OUTLINE_BLANK" addStyleNames="left">
 *         <m:MaterialIcon iconType="CREATE" textColor="grey" fontSize="12px" left="4" />
 *     </m.addins:MaterialIconComposite>
 * </m:MaterialButton>
 * }
 * </pre>
 * 
 * You can combine any amount of icons together, and combine with other
 * combinations:
 * 
 * <pre>
 * {@code
 * <m.addins:MaterialIconComposite iconType="SEARCH">
 *     <m:MaterialIcon iconType="STAR" textColor="yellow" fontSize="12px" top="-5" left="15" />
 *     <m:MaterialIcon iconType="ADD" textColor="red" fontSize="12px" top="16" right="-14" />
 *     <m.addins:MaterialIconComposite iconType="ATTACH_MONEY" textColor="green" fontSize="18px" top="-10" left="-10">
 *         <m:MaterialIcon iconType="FORWARD" fontSize="12px" top="3" left="-5" />
 *     </m.addins:MaterialIconComposite>
 * </m.addins:MaterialIconComposite>
 * }
 * </pre>
 * 
 * <h3>Java Usage:</h3>
 * 
 * Just use the standard {@link #add(com.google.gwt.user.client.ui.Widget)} method to add MaterialIcons to the composition:
 * 
 * <pre>
 * {@code
 * MaterialIconComposite composite = new MaterialIconComposite(IconType.SEARCH);
 * MaterialIcon icon = new MaterialIcon(IconType.STAR);
 * icon.setTextColor("yellow");
 * icon.setFontSize("12px");
 * icon.setTop(-5);
 * icon.setRight(-14);
 * composite.add(icon);
 * }
 * </pre>
 * 
 * Note that the user is responsible by positioning the icons inside the
 * composition.
 * 
 * @author gilberto-torrezan
 * 
 */
// @formatter:on
public class MaterialIconComposite extends MaterialIcon {

    public MaterialIconComposite() {
        super();
        addStyleName("icon-composite");
    }

    public MaterialIconComposite(IconType iconType) {
        super(iconType);
        addStyleName("icon-composite");
    }

    public MaterialIconComposite(IconType iconType, String textColor, String bgColor) {
        super(iconType, textColor, bgColor);
        addStyleName("icon-composite");
    }

    @Override
    public void setInnerText(String innerText) {
        String inner = getElement().getInnerHTML();
        getElement().setInnerHTML(innerText + inner);
    }

    @Override
    public void setIconType(IconType icon) {
        setInnerText(icon.getCssName());
    }

}
