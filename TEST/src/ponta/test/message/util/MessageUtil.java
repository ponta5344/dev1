package ponta.test.message.util;

import java.text.MessageFormat;

import ponta.test.message.AvailableLocal;
import ponta.test.message.Message;

public class MessageUtil {
	
    static AvailableLocal locale = AvailableLocal.JA;

    public static String getMessage(Message message, Object... args) {
        String pattern = message.getPattern(locale);
        return MessageFormat.format(pattern, args);
    }

}
