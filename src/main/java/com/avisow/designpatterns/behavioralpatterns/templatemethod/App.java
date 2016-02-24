package com.avisow.designpatterns.behavioralpatterns.templatemethod;

/// <summary>
/// MainApp startup class for Structural
/// Template Method Design Pattern.
///     defer the exact steps of an algorithm to a subclass
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Template Method Pattern:
        // A skeleton of an algorithm and defer the steps in the sub-classes

        AbstractClass a = new AbstractClassA();
        a.templateMethod();

        AbstractClass b = new AbstractClassB();
        b.templateMethod();
    }
}

abstract class AbstractClass
{
    public void templateMethod()
    {
        primitiveOperation1();
        primitiveOperation2();
        System.out.println("templateMethod()");
    }

    protected abstract void primitiveOperation1();
    protected abstract void primitiveOperation2();
}

class AbstractClassA extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("AbstractClassA.primitiveOperation1()");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("AbstractClassA.primitiveOperation2()");
    }
}

class AbstractClassB extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("AbstractClassB.primitiveOperation1()");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("AbstractClassB.primitiveOperation1()");
    }
}
