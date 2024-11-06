package com.avisow.designpatterns.creationalpatterns.singleton;

public class SingletonLazyDoubleCheck {
    private volatile static SingletonLazyDoubleCheck instance;
    private String name;

    private SingletonLazyDoubleCheck() {}


    public static SingletonLazyDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonLazyDoubleCheck();
                }
            }
        }

        return instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
