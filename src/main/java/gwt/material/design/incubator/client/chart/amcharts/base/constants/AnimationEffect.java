package gwt.material.design.incubator.client.chart.amcharts.base.constants;

public enum AnimationEffect {

    EASE_OUT_SINE("easeOutSine"),
    EASE_IN_SINE("easeInSine"),
    ELASTIC("elastic"),
    BOUNCE("bounce");

    private String name;

    AnimationEffect(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
