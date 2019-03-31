package gwt.material.design.incubator.client.formatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetricPrefixFormatter {

    private static List<MetricRange> ranges = new ArrayList<>();

    private MetricPrefixFormatter() {}

    static {
        ranges.addAll(Arrays.asList(MetricRange.create(1e12, "T"),
                MetricRange.create(1e9, "B"),
                MetricRange.create(1e6, "M"),
                MetricRange.create(1e3, "k")));
    }

    public static MetricValue formatNumber(Double value) {
        for (int i = 0; i < ranges.size(); i++) {
            if (value >= ranges.get(i).divider) {
                return new MetricValue((value / ranges.get(i).divider), ranges.get(i).suffix);
            }
        }
        return new MetricValue(value);
    }
}
