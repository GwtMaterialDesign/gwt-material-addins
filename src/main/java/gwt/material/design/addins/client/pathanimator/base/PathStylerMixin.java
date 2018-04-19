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
package gwt.material.design.addins.client.pathanimator.base;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;

import java.util.HashSet;
import java.util.Set;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * A mixin to stylize the Path Animation Bridge element
 *
 * @author kevzlou7979@gmail.com
 */
public class PathStylerMixin<T extends MaterialPathAnimator & HasPathStyles> implements HasPathStyles {

    protected T source;
    protected Integer shadow;
    protected Color backgroundColor = Color.WHITE;
    protected Set<PathStyleProperty> properties = new HashSet<>();

    public PathStylerMixin(T source) {
        this.source = source;
        setup(source);
    }

    public Integer getShadow() {
        return shadow;
    }

    public void setShadow(Integer shadow) {
        this.shadow = shadow;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void setStyleProperty(PathStyleProperty styleProperty) {
        this.properties.add(styleProperty);
    }

    @Override
    public void setStyleProperty(String property, String value) {
        this.properties.add(new PathStyleProperty(property, value));
    }

    @Override
    public void clearStyleProperty(String property) {
        if (properties != null) {
            PathStyleProperty styleProperty = properties.stream().filter(pathStyleProperty -> pathStyleProperty.getProperty().equals(property)).findAny().orElse(null);
            if (styleProperty != null) {
                if (getBridgeElement() != null) {
                    getBridgeElement().getStyle().clearProperty(styleProperty.getProperty());
                }
                properties.remove(styleProperty);
            }
        }
    }

    @Override
    public void clearStyles() {
        Element bridgeElement = getBridgeElement();
        if (bridgeElement != null) {
            if (shadow != null) {
                bridgeElement.removeClassName("z-depth-" + shadow);
            }
            if (backgroundColor != null) {
                bridgeElement.getStyle().setProperty("background", "");
            }
            if (properties != null) {
                properties.stream().forEach(pathStyleProperty -> clearStyleProperty(pathStyleProperty.getProperty()));
            }
        }
    }

    public Element getBridgeElement() {
        return $("." + AddinsCssName.BRIDGE_PATH).asElement();
    }

    public void setup(MaterialPathAnimator animator) {
        animator.setAnimateOnStartCallback(() -> {
            Scheduler.get().scheduleDeferred(() -> {
                Element bridgeElement = getBridgeElement();
                if (bridgeElement != null) {
                    if (shadow != null) {
                        bridgeElement.addClassName("z-depth-" + shadow);
                    }

                    if (backgroundColor != null) {
                        setStyleProperty("background", ColorHelper.setupComputedBackgroundColor(backgroundColor));
                    }

                    if (properties != null) {
                        for (PathStyleProperty property : properties) {
                            bridgeElement.getStyle().setProperty(property.getProperty(), property.getValue());
                        }
                    }
                }
            });
        });
    }

    public T getSource() {
        return source;
    }
}
