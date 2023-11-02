package gwt.material.design.addins.client.moment.option;

import jsinterop.annotations.JsFunction;

@FunctionalInterface
@JsFunction
public interface FullLocaleFormatter {

    String call(Object number, boolean withoutSuffix, String key, boolean isFuture);
}
