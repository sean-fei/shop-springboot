package com.sean.shop.commons.exception;

import com.sean.shop.commons.context.SpringApplicationContextHolder;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * @Author: sean
 * @CreateDate: 2018/8/9 9:30
 */
public class LocalizedErrorMessageRetriever {

    private static LocalizedErrorMessageRetriever INSTANCE = new LocalizedErrorMessageRetriever();

    private LocalizedErrorMessageRetriever() {
    }

    public static LocalizedErrorMessageRetriever getInstance() {
        return INSTANCE;
    }

    public String gettLocalizedErrorMessageByCurrentRequest(String code, String defaultMsg, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return this.getLocalizedErrorMessage(code, locale, defaultMsg, args);
    }

    public String getLocalizedErrorMessage(String code, Locale locale, String defaultMsg, Object... args) {
        try {
            String pattern = SpringApplicationContextHolder.getApplicationContext().getMessage(code, args, defaultMsg, locale);
            if (pattern == null || pattern.trim().length() == 0) {
                pattern = defaultMsg;
            }

            return MessageFormat.format(pattern, args);
        } catch (Throwable var7) {
            var7.printStackTrace();
            if (var7 instanceof NoSuchMessageException) {
                return MessageFormat.format(defaultMsg, args);
            } else {
                StringWriter sw = new StringWriter();
                var7.printStackTrace(new PrintWriter(sw));
                return " Find message with code '" + defaultMsg + "' error : " + sw.toString();
            }
        }
    }

}
