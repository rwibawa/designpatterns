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

        AbstractClass a = new ConcreteClassA();
        a.templateMethod();

        AbstractClass b = new ConcreteClassB();
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

class ConcreteClassA extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("ConcreteClassA.primitiveOperation1()");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("ConcreteClassA.primitiveOperation2()");
    }
}

class ConcreteClassB extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("ConcreteClassB.primitiveOperation1()");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("ConcreteClassB.primitiveOperation2()");
    }
}
