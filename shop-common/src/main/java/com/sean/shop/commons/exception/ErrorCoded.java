package com.sean.shop.commons.exception;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author sean
 */
public interface ErrorCoded {

    String codeValue();

    String defaultMessage();

    default BusinessRuntimeException exception(Object... args) {
        BusinessRuntimeException runtimeException = new BusinessRuntimeException(this.codeValue(), this.message(args));
        runtimeException.setMessgeArgs(args);
        return runtimeException;
    }

    default BusinessRuntimeException exception(HttpErrorStatus httpErrorStatus, Object... args) {
        BusinessRuntimeException runtimeException = new BusinessRuntimeException(this.codeValue(), this.message(args), httpErrorStatus);
        runtimeException.setMessgeArgs(args);
        return runtimeException;
    }

    default BusinessRuntimeException exception(Throwable cause, Object... args) {
        BusinessRuntimeException runtimeException = new BusinessRuntimeException(this.codeValue(), this.message(args), cause);
        runtimeException.setMessgeArgs(args);
        return runtimeException;
    }

    default BusinessRuntimeException exception(Throwable cause, HttpErrorStatus httpErrorStatus, Object... args) {
        BusinessRuntimeException runtimeException = new BusinessRuntimeException(this.codeValue(), this.message(args), httpErrorStatus, cause);
        runtimeException.setMessgeArgs(args);
        return runtimeException;
    }

    default <T extends BusinessRuntimeException> T exception(Class<T> clazz, Object... args) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class, String.class);
            T newInstance = constructor.newInstance(this.codeValue(), this.message(args));
            newInstance.setMessgeArgs(args);
            return newInstance;
        } catch (Exception var) {
            throw new BusinessRuntimeException(var);
        }
    }

    default <T extends BusinessRuntimeException> T exception(Class<T> clazz, HttpErrorStatus httpErrorStatus, Object... args) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class, String.class, HttpErrorStatus.class);
            T newInstance = constructor.newInstance(this.codeValue(), this.message(args), httpErrorStatus);
            newInstance.setMessgeArgs(args);
            return newInstance;
        } catch (Exception var) {
            throw new BusinessRuntimeException(var);
        }
    }

    default <T extends BusinessRuntimeException> T exception(Class<T> clazz, Throwable cause, Object... args) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class, String.class, Throwable.class);
            T newInstance = constructor.newInstance(this.codeValue(), this.message(args));
            newInstance.setMessgeArgs(args);
            return newInstance;
        } catch (Exception var) {
            throw new BusinessRuntimeException(var);
        }
    }

    default <T extends BusinessRuntimeException> T exception(Class<T> clazz, HttpErrorStatus httpErrorStatus, Throwable cause, Object... args) {
        try {
            Constructor<T> constructor = clazz.getConstructor(String.class, String.class, HttpErrorStatus.class, Throwable.class);
            T newInstance = constructor.newInstance(this.codeValue(), this.message(args), httpErrorStatus, cause);
            newInstance.setMessgeArgs(args);
            return newInstance;
        } catch (Exception var) {
            throw new BusinessRuntimeException(var);
        }
    }

    default String message(Object... args) {
        return MessageFormat.format(this.defaultMessage(), args);
    }

    default String message(Locale locale, Object... args) {
        locale = locale == null ? Locale.getDefault() : locale;
        return LocalizedErrorMessageRetriever.getInstance().getLocalizedErrorMessage(this.codeValue(), locale, this.defaultMessage(), args);
    }

}
