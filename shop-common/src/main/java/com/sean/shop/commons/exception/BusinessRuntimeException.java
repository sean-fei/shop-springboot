package com.sean.shop.commons.exception;

/**
 * @Author: sean
 * @CreateDate: 2018/8/9 9:41
 * 业务运行时exception
 */
public class BusinessRuntimeException extends RuntimeException implements ErrorCodeMessageMapper {

    public static final String UNDEFINED_ERROR_CODE = "code.undefined";
    private String errorCode;
    private String errorMessage;
    private Object[] messgeArgs;
    private HttpErrorStatus httpErrorCode;

    public BusinessRuntimeException() {
        this((String)null);
    }

    public BusinessRuntimeException(String message, Throwable cause) {
        this("code.undefined", message, cause);
    }

    public BusinessRuntimeException(Throwable cause) {
        this((String)null, cause);
    }

    public BusinessRuntimeException(String errorMsg) {
        this("code.undefined", errorMsg, (HttpErrorStatus)null);
    }

    public BusinessRuntimeException(String errorCode, String errorMsg) {
        this(errorCode, errorMsg, (HttpErrorStatus)null);
    }

    public BusinessRuntimeException(String errorCode, String errorMsg, Throwable cause) {
        this(errorCode, errorMsg, (HttpErrorStatus)null, cause);
    }

    public BusinessRuntimeException(String errorCode, String errorMsg, HttpErrorStatus httpErrorCode) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMessage = errorMsg;
        this.httpErrorCode = httpErrorCode;
    }

    public BusinessRuntimeException(String errorCode, String errorMsg, HttpErrorStatus httpErrorCode, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMsg;
        this.httpErrorCode = httpErrorCode;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }

    public String getMessageDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorCode: " + this.errorCode);
        sb.append(", ErrorMessage: " + this.errorMessage);
        if (this.httpErrorCode != null) {
            sb.append(", HttpStatus: " + this.httpErrorCode.codeValue());
            sb.append(", HttpMessage: " + this.httpErrorCode.defaultMessage());
        }

        return sb.toString();
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public HttpErrorStatus getHttpErrorStatus() {
        return this.httpErrorCode;
    }

    public void setHttpErrorStatus(HttpErrorStatus httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }

    @Override
    public Object[] getMessgeArgs() {
        return this.messgeArgs;
    }

    public void setMessgeArgs(Object[] messgeArgs) {
        this.messgeArgs = messgeArgs;
    }

}
