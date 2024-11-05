package com.avisow.designpatterns.creationalpatterns.singleton;

import java.io.ObjectStreamClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Singleton singleton = Singleton.getInstance();
        System.out.println( "Singleton UID:" + ObjectStreamClass.lookup(singleton.getClass()).getSerialVersionUID());

        SingletonLazyDoubleCheck singleton2 = SingletonLazyDoubleCheck.getInstance();
        singleton2.setName("Ryan");
        System.out.println("Singleton2 Name:" + singleton2.getName());
    }
}
