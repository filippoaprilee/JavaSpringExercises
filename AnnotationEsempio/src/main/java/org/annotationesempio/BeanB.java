package org.annotationesempio;

public class BeanB {
    private BeanA beanA;

    public BeanB(BeanA beanA) {
        this.beanA = beanA;
    }

    public String sayHello() {
        return "ciao sono BeanB e dico " + beanA.hello();
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }
}
