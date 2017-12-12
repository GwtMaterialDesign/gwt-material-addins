package gwt.material.design.incubator.client.chart.amcharts.base.constants;

public enum GraphType {

    LINE("line"),
    COLUMN("column"),
    STEP("step"),
    SMOOTHED_LINE("smoothedLine"),
    CANDLESTICK("candlestick"),
    OHLC("ohlc");

    String name;

    GraphType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
