package gwt.material.design.addins.client.inputmask;

import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;

public class MaterialDateInputMask extends MaterialInputMask<Date> {

    private String format = "mm/dd/yyyy";

    public MaterialDateInputMask() {
        super();

        setFormat(format);
    }

    @Override
    public Date getValue() {
        if (getText() != null && !getText().isEmpty()) {
            if (getMask() != null && !getMask().isEmpty()) {
                if (validate()) {
                    return DateTimeFormat.getFormat(getFormat()).parse(getText());
                }
            }
        }
        return null;
    }

    @Override
    public boolean validate() {
        boolean valid = true;

        //TODO Validation of dates / months/ year

        return valid;
    }

    protected void parseFormatToMask(String format) {
        String dateFormatMask = format.toLowerCase()
                .replace("m", "0")
                .replace("d", "0")
                .replace("y", "0");
        setMask(dateFormatMask);
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
        parseFormatToMask(format);
    }
}
