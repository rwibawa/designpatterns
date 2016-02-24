package com.avisow.designpatterns.creationalpatterns.abstractfactory;

/// <summary>
/// MainApp startup class for Structural
/// Abstract Factory Design Pattern.
///     create an instance of several family classes
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Abstract factory #1
        AbstractFactory factory1 = new ConcreteFactory1();
        Client client1 = new Client(factory1);
        client1.run();

        // Abstract factory #2
        AbstractFactory factory2 = new ConcreteFactory2();
        Client client2 = new Client(factory2);
        client2.run();
    }
}


/// <summary>
/// The 'AbstractFactory' abstract class
/// </summary>
abstract class AbstractFactory
{
    public abstract AbstractProductA createProductA();
    public abstract AbstractProductB createProductB();
}


/// <summary>
/// The 'ConcreteFactory1' class
/// </summary>
class ConcreteFactory1 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

/// <summary>
/// The 'ConcreteFactory2' class
/// </summary>
class ConcreteFactory2 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

/// <summary>
/// The 'AbstractProductA' abstract class
/// </summary>
abstract class AbstractProductA
{
}

/// <summary>
/// The 'AbstractProductB' abstract class
/// </summary>
abstract class AbstractProductB
{
    public abstract void interact(AbstractProductA a);
}


/// <summary>
/// The 'ProductA1' class
/// </summary>
class ProductA1 extends AbstractProductA {
}

/// <summary>
/// The 'ProductB1' class
/// </summary>
class ProductB1 extends AbstractProductB {
    @Override
    public void interact(AbstractProductA a) {
        System.out.println(this.getClass().toString() +
                        " interacts with " + a.getClass().toString());
    }
}

/// <summary>
/// The 'ProductA2' class
/// </summary>
class ProductA2 extends AbstractProductA {
}

/// <summary>
/// The 'ProductB2' class
/// </summary>
class ProductB2 extends AbstractProductB {
    @Override
    public void interact(AbstractProductA a) {
        System.out.println(this.getClass().toString() +
                " interacts with " + a.getClass().toString());
    }
}

/// <summary>
/// The 'Client' class. Interaction environment for the products.
/// </summary>
class Client {
    private AbstractProductA _abstractProductA;
    private AbstractProductB _abstractProductB;

    // Constructor
    public Client(AbstractFactory factory) {
        _abstractProductB = factory.createProductB();
        _abstractProductA = factory.createProductA();
    }

    public void run() {
        _abstractProductB.interact(_abstractProductA);
    }
}
