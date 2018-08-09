package com.sean.shop.commons.exception;

/**
 * @author sean
 */
public interface ErrorCodeMessageMapper {

    String UNDEFINED_ERROR_CODE = "code.undefined";

    String getMessage();

    String getErrorCode();

    String getErrorMessage();

    HttpErrorStatus getHttpErrorStatus();

    Object[] getMessgeArgs();

    default String getRequestLocalizedMessage() {
        String localMsg = LocalizedErrorMessageRetriever.getInstance().gettLocalizedErrorMessageByCurrentRequest(this.getErrorCode(), this.getErrorMessage(), this.getMessgeArgs());
        return localMsg != null ? localMsg : this.getErrorMessage();
    }

}
