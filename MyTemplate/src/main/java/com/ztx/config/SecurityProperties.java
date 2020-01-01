package com.ztx.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix = "imoc.ztx.security.browser")
public class SecurityProperties {

private BrowserProperties code = new BrowserProperties();
public BrowserProperties getCode() {
        return code;
    }

    public void setCode(BrowserProperties code) {
        this.code = code;
    }

}