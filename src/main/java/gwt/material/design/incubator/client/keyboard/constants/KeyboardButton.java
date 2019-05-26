package gwt.material.design.incubator.client.keyboard.constants;

import java.util.Arrays;

public enum KeyboardButton {

    BKSP("{bksp}", "backspace"),
    BACKSPACE("{backspace}", "backspace"),
    ENTER("{enter}", "< enter"),
    SHIFT("{shift}", "shift"),
    SHIFTLEFT("{shiftleft}", "shift"),
    SHIFTRIGHT("{shiftright}", "shift"),
    ALT("{alt}", "alt"),
    S("{s}", "shift"),
    TAB("{tab}", "tab"),
    LOCK("{lock}", "caps"),
    CAPSLOCK("{capslock}", "caps"),
    ACCEPT("{accept}", "Submit"),
    SPACE("{space}", " "),
    DOUBLE_BACKWARSLASH("{//}", " "),
    ESC("{esc}", "esc"),
    ESCAPE("{escape}", "esc"),
    F1("{f1}", "f1"),
    F2("{f2}", "f2"),
    F3("{f3}", "f3"),
    F4("{f4}", "f4"),
    F5("{f5}", "f5"),
    F6("{f6}", "f6"),
    F7("{f7}", "f7"),
    F8("{f8}", "f8"),
    F9("{f9}", "f9"),
    F10("{f10}", "f10"),
    F11("{f11}", "f11"),
    F12("{f12}", "f12"),
    NUMPADDIVIDE("{numpaddivide}", "/"),
    NUMLOCK("{numlock}", "lock"),
    ARROWUP("{arrowup}", "\u2191"),
    ARROWLEFT("{arrowleft}", "\u2190"),
    ARROWDOWN("{arrowdown}", "\u2193"),
    ARROWRIGHT("{arrowright}", "\u2192"),
    PRTSCR("{prtscr}", "print"),
    SCROLLLOCK("{scrolllock}", "scroll"),
    PAUSE("{pause}", "pause"),
    INSERT("{insert}", "ins"),
    HOME("{home}", "home"),
    PAGEUP("{pageup}", "up"),
    DELETE("{delete}", "del"),
    END("{end}", "end"),
    PAGEDOWN("{pagedown}", "down"),
    NUMPADMULTIPLY("{numpadmultiply}", "*"),
    NUMPADSUBTRACT("{numpadsubtract}", "-"),
    NUMPADADD("{numpadadd}", "+"),
    NUMPADENTER("{numpadenter}", "enter"),
    PERIOD("{period}", "."),
    NUMPADDECIMAL("{numpaddecimal}", "."),
    NUMPAD0("{numpad0}", "0"),
    NUMPAD1("{numpad1}", "1"),
    NUMPAD2("{numpad2}", "2"),
    NUMPAD3("{numpad3}", "3"),
    NUMPAD4("{numpad4}", "4"),
    NUMPAD5("{numpad5}", "5"),
    NUMPAD6("{numpad6}", "6"),
    NUMPAD7("{numpad7}", "7"),
    NUMPAD8("{numpad8}", "8"),
    NUMPAD9("{numpad9}", "9");
    private String id;
    private String name;


    KeyboardButton(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static KeyboardButton get(String id) {
        return Arrays.stream(values()).filter(keyboardButton -> id.equals(keyboardButton.getId())).findAny().orElse(null);
    }
}
