package com.avisow.designpatterns.structuralpatterns.bridge;

/// <summary>
/// MainApp startup class for Structural
/// Bridge Design Pattern.
/// separate an obj's interface from implementation.
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        Abstraction ab = new RefinedAbstraction();

        // Set implementation and call
        ab.setImplementor(new ConcreteImplementorA());
        ab.operation();

        // Change implementation and call
        ab.setImplementor(new ConcreteImplementorB());
        ab.operation();
    }
}

/// <summary>
/// The 'Abstraction' class
/// </summary>
class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        implementor.operation();
    }
}

/// <summary>
/// The 'Implementor' abstract class
/// </summary>
abstract class Implementor
{
    public abstract void operation();
}

/// <summary>
/// The 'RefinedAbstraction' class
/// </summary>
class RefinedAbstraction extends Abstraction {
    @Override
    public void operation() {
        implementor.operation();
    }
}

/// <summary>
/// The 'ConcreteImplementorA' class
/// </summary>
class ConcreteImplementorA extends Implementor {
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorA operation");
    }
}

/// <summary>
/// The 'ConcreteImplementorB' class
/// </summary>
class ConcreteImplementorB extends Implementor {
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorB operation");
    }
}