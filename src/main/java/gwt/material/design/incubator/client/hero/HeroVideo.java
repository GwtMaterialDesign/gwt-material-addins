/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.incubator.client.hero;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.SourceElement;
import com.google.gwt.dom.client.VideoElement;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.infinitescroll.InfiniteScrollPanel;

import java.util.Collections;
import java.util.List;

public class HeroVideo extends AbstractAddinsWidget {

    static {
        IncubatorWidget.showWarning(InfiniteScrollPanel.class);
    }

    private boolean loop = true;
    private boolean autoplay = true;
    private boolean muted = true;
    private String type = "video/webm";
    private String alt = "Hero Video";
    private String src;

    public HeroVideo() {
        super(Document.get().createVideoElement(), "hero-video");
    }

    @Override
    protected void internalLoad() {
        VideoElement element = getElement().cast();
        element.setLoop(loop);
        element.setAutoplay(autoplay);
        element.setMuted(muted);

        SourceElement sourceElement = DOM.createElement("source").cast();
        sourceElement.setType(type);
        sourceElement.setAttribute("alt", alt);
        sourceElement.setSrc(src);
        element.appendChild(sourceElement);
    }

    @Override
    public void unload() {
        getElement().removeAllChildren();
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isAutoplay() {
        return autoplay;
    }

    public void setAutoplay(boolean autoplay) {
        this.autoplay = autoplay;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
        reload();
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(HeroVideoClientBundle.INSTANCE.heroVideoCss(), HeroVideoDebugClientBundle.INSTANCE.heroVideoDebugCss()));
    }
}
