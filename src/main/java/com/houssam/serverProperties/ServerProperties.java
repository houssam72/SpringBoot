package com.houssam.serverProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private String port;
    private ServerErrorProperties error;


    public String getIncludeMessage() {
        return error.getIncludeMessage();
    }

    public String getIncludeBindingErrors() {
        return error.getIncludeBindingErrors();
    }

    public String getIncludeStacktrace() {
        return getIncludeMessage();
    }

    public void setError(ServerErrorProperties error) {
        this.error = error;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }
}
