package org.annotationesempio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
    String message="ciao sono io";

    @Value("${message}")
    private String stringValue;

    public String hello() {
        return message + " " + stringValue;
    }

    public String ciao() {
        return stringValue;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }


}
