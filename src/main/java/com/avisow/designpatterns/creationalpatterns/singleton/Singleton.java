package com.avisow.designpatterns.creationalpatterns.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable {

    private static final long serialVersionUID = -7941257635114643224L;
    private static final Singleton instance = new Singleton();

    private Singleton() {
        if (instance != null) {
            throw new IllegalStateException("This instance is already created.");
        }
    }

    public static Singleton getInstance() {
        return instance;
    }

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    private Object writeReplace() throws ObjectStreamException {
        return instance;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned!");
    }

    private static Class getClass(String classname) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = Singleton.class.getClassLoader();
        }

        return classLoader.loadClass(classname);
    }
}
