<img src="http://i.imgur.com/k7iZMbE.png" />
# gwt-material-addins [![Build Status](https://travis-ci.org/GwtMaterialDesign/gwt-material-addins.svg?branch=master)](https://travis-ci.org/GwtMaterialDesign/gwt-material-addins)
Gwt Material Design Extra Components for https://github.com/GwtMaterialDesign/gwt-material <br>

## Usage
```xml
<dependency>
    <groupId>com.github.gwtmaterialdesign</groupId>
    <artifactId>gwt-material-addins</artifactId>
    <version>1.5.0-SNAPSHOT</version>
</dependency>
```

Import the theme in your GWT Module
```xml
<inherits name="gwt.material.design.addins.GwtMaterialAddins"/>
```
Define the ui:binder with single import (e.g Bubble and Timer Picker using a single package import)
```xml
xmlns:ma="urn:import:gwt.material.design.addins.client"

<!-- Bubble -->
<ma:bubble.MaterialBubble >
  <m:MaterialLabel text="Bubble" />
</ma:bubble.MaterialBubble>
<!-- Time Picker -->
<ma:timpicker:MaterialTimePicker placeholder="Time Arrival"/>
```

##Extra Components
<ul>
<li>Autcomplete</li>
<li>Bubble</li>
<li>Camera</li>
<li>Cutout</li>
<li>Document Viewer</li>
<li>Dnd</li>
<li>File Uploader</li>
<li>Icon Morph</li>
<li>Masonry</li>
<li>Menubar</li>
<li>Overlay</li>
<li>Path Animator</li>
<li>Rich Editor</li> 
<li>Scrollfire</li>
<li>SplitPanel</li>
<li>Steppers</li>
<li>Subheader</li>
<li>Swipeable</li>
<li>Time Picker</li>
<li>Tree View</li>
<li>Waterfall</li>
<li>Window</li>
</ul>

##Package Information
### java
``` addin_widget ``` - The name of the addin widget
``` gwt.material.design.addins.client.addin_widget ``` - Main / Parent Package for Entry Point Classes <br/>
``` gwt.material.design.addins.client.addin_widget.base ``` - Base Widgets e.g. ButtonBase <br/>
``` gwt.material.design.addins.client.addin_widget.base.helper ``` Helper Classes for widgets e.g. UiHelper <br/>
``` gwt.material.design.addins.client.addin_widget.base.mixin ``` Java Mixins Classes e.g. TypeMixins <br/>
``` gwt.material.design.addins.client.addin_widget.constants ``` Enum Constants e.g. SideNavTypes <br/>
``` gwt.material.design.addins.client.addin_widget.events ``` Custom Events for custom widget e.g. ClearActiveEvent <br/>
``` gwt.material.design.addins.client.addin_widget.resources ``` Resource Interface definitions for js files e.g. MaterialResources <br/>

### resources
``` gwt.material.design.addins.client.addin_widget.resources ``` Where module.gwt.xml is located e.g. GWTMaterialAddins.gwt.xml <br/>
``` gwt.material.design.addins.client.addin_widget.resources.img ``` Image Resources of Addins module <br/>
``` gwt.material.design.addins.client.addin_widget.resources.js ``` Javascript Files of Addins module <br/>

##Follow Us
<a href="https://plus.google.com/u/0/communities/108005250093449814286"> Google Plus</a>
