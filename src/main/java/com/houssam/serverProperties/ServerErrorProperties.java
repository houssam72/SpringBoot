package com.houssam.serverProperties;

public class ServerErrorProperties {

    private String includeMessage;
    private String includeBindingErrors;
    private String includeStacktrace;


    public String getIncludeMessage() {
        return includeMessage;
    }

    public String getIncludeBindingErrors() {
        return includeBindingErrors;
    }

    public String getIncludeStacktrace() {
        return includeStacktrace;
    }

    public void setIncludeMessage(String includeMessage) {
        this.includeMessage = includeMessage;
    }

    public void setIncludeBindingErrors(String includeBindingErrors) {
        this.includeBindingErrors = includeBindingErrors;
    }

    public void setIncludeStacktrace(String includeStacktrace) {
        this.includeStacktrace = includeStacktrace;
    }
}
