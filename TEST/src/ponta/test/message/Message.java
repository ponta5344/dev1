package ponta.test.message;

public enum Message {
    M0001("{0}は必須です。"
            , "{0} is required.")
    ,
    ;

    private String messageJa;
    private String messageEn;
    private Message(String messageJa, String messageEn) {
        this.messageJa = messageJa;
        this.messageEn = messageEn;
    }

    public String getPattern(AvailableLocal locale) {
        switch (locale) {
        case JA: return messageJa;
        case EN: return messageEn;
        default: return messageJa;
        }
    }
}
