<img src="http://i.imgur.com/k7iZMbE.png" />

# gwt-material-addins 

[![Build Status](https://travis-ci.org/GwtMaterialDesign/gwt-material-addins.svg?branch=master)](https://travis-ci.org/GwtMaterialDesign/gwt-material-addins) [![Join the chat at https://gitter.im/GwtMaterialDesign/gwt-material-addins](https://badges.gitter.im/GwtMaterialDesign/gwt-material-addins.svg)](https://gitter.im/GwtMaterialDesign/gwt-material-addins?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Gwt Material Design Extra Components for https://github.com/GwtMaterialDesign/gwt-material <br>

## Current Version
```xml
<dependency>
    <groupId>com.github.gwtmaterialdesign</groupId>
    <artifactId>gwt-material-addins</artifactId>
    <version>2.0.1</version>
</dependency>
```

## Snapshot Version
```xml
<dependency>
    <groupId>com.github.gwtmaterialdesign</groupId>
    <artifactId>gwt-material-addins</artifactId>
    <version>2.1-SNAPSHOT</version>
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

| Addin Name | Dependency | Version |
| --- | --- | --- |
| Autocomplete | N/A | N/A |
| Avatar | [JDenticon](https://github.com/dmester/jdenticon) | 1.3.2 |
| Bubble | N/A | N/A |
| Camera | N/A | N/A |
| Carousel | [SlickJs](https://github.com/kenwheeler/slick) | 1.6.0 |
| Circular Progress | [jquery-circle-progress](https://github.com/kottenator/jquery-circle-progress) | 1.2.2 |
| ComboBox | [Select2](https://github.com/select2/select2) | 4.0.3 |
| CountUp | [CountUpJs](https://github.com/inorganik/countUp.js) | 1.9.0 |
| Cutout | N/A | N/A |
| Document Viewer | N/A | N/A |
| Dnd | [InteractJs](https://github.com/taye/interact.js) | 1.2.6 |
| EmptyState | N/A | N/A |
| File Uploader | [DropzoneJs](https://github.com/enyo/dropzone) | 4.3.0 |
| Icon Morph | N/A | N/A |
| Image Cropper | [CroppieJs](https://github.com/Foliotek/Croppie) | 2.5.0 |
| Input Mask | [JQuery-Mask-Plugin](https://github.com/Foliotek/Croppie) | 1.14.10 |
| Live Stamp | [LiveStamp](https://github.com/mattbradley/livestampjs) | 1.1.2 |
| Masonry | [Masonry](https://github.com/desandro/masonry) | 4.0.0 |
| Menubar | N/A | N/A |
| Overlay | N/A | N/A |
| Path Animator | [CTAJs](https://github.com/chinchang/cta.js) | 0.3.2 |
| Popup Menu | N/A | N/A |
| Rating | N/A | N/A |
| Rich Editor | [Material Note](https://github.com/Cerealkillerway/materialNote) | 1.2.1 |
| Scrollfire | N/A | N/A |
| Signature Pad | [SignaturePad](https://github.com/szimek/signature_pad) | 2.3.0 |
| SideProfile | N/A | N/A |
| SplitPanel | [TouchSplitterJQuery](https://github.com/colelawrence/Touch-Splitter-jQuery) | 0.5.1 |
| Steppers | N/A | N/A |
| Subheader | N/A | N/A |
| Swipeable | N/A | N/A |
| Time Picker | [ClockPicker](https://github.com/weareoutman/clockpicker) | 0.0.7 |
| Tree View | N/A | N/A |
| Waterfall | N/A | N/A |
| Window | N/A | N/A |

## Documentation
We created [Java Docs](http://gwtmaterialdesign.github.io/gwt-material-demo/apidocs-addins/) for better understanding the usage of addins.

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
