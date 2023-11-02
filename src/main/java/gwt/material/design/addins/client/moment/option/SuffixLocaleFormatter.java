package gwt.material.design.addins.client.moment.option;

import jsinterop.annotations.JsFunction;

@FunctionalInterface
@JsFunction
public interface SuffixLocaleFormatter {

    String call(String number);
}
