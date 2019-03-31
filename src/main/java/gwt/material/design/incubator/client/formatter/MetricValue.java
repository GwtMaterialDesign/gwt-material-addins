package gwt.material.design.incubator.client.formatter;

public class MetricValue {

    private Double numericalValue;
    private String suffix;

    public MetricValue() {}

    public MetricValue(Double numericalValue) {
        this.numericalValue = numericalValue;
    }

    public MetricValue(Double numericalValue, String suffix) {
        this.numericalValue = numericalValue;
        this.suffix = suffix;
    }

    public Double getNumericalValue() {
        return numericalValue;
    }

    public void setNumericalValue(Double value) {
        this.numericalValue = value;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
