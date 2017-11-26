package kpi.supplychain.controller;

/**
 * Class for exception representation in JSON.
 */
public class JsonExceptionInformation {

    /**
     * URL of request that caused an exception.
     */
    private String url;

    /**
     * Request method.
     */
    private String method;

    /**
     * Exception class name.
     */
    private String exception;

    /**
     * Exception message.
     */
    private String message;

    public final String getUrl() {
        return url;
    }

    public final void setUrl(String url) {
        this.url = url;
    }

    public final String getMethod() {
        return method;
    }

    public final void setMethod(String method) {
        this.method = method;
    }

    public final String getException() {
        return exception;
    }

    public final void setException(String exception) {
        this.exception = exception;
    }

    public final String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
