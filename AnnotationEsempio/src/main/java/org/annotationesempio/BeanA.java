package org.annotationesempio;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
    String message="ciao sono io";
    public String hello() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
