package ponta.test.message;

import java.util.Locale;


public enum AvailableLocal {

    JA(Locale.JAPAN)
    , EN(Locale.ENGLISH)
    , 
    ;

    private Locale locale;
    private AvailableLocal(Locale locale) {
        this.locale = locale;
    }

    public Locale get() {
        return locale;
    }
}
