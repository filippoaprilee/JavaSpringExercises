package org.annotationesempio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
    String message="ciao sono io";

    @Value("string value")
    private String stringValue;

    public String hello() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
