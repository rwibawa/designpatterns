package com.avisow.designpatterns.creationalpatterns.prototype;

/// <summary>
/// MainApp startup class for Structural
/// Prototype Design Pattern.
///     A fully initialized instance to be copied or cloned
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Create two instances and clone each
        ConcretePrototype1 p1 = new ConcretePrototype1("I");
        ConcretePrototype1 c1 = (ConcretePrototype1) p1.clone();
        System.out.println("Cloned: " + c1.getId());

        ConcretePrototype2 p2 = new ConcretePrototype2("II");
        ConcretePrototype2 c2 = (ConcretePrototype2) p2.clone();
        System.out.println("Cloned: " + c2.getId());
    }
}

/// <summary>
/// The 'Prototype' abstract class
/// </summary>
abstract class Prototype implements Cloneable
{
    private final String id;

    // Constructor
    public Prototype(String id)
    {
        this.id = id;
    }

    // Gets id
    public String getId()
    {
        return id;
    }

    @Override
    public Prototype clone() {
        try {
            final Prototype clone = (Prototype) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

/// <summary>
/// A 'ConcretePrototype' class
/// </summary>
class ConcretePrototype1 extends Prototype {
    // Constructor
    public ConcretePrototype1(String id) {
        super(id);
    }
}

/// <summary>
/// A 'ConcretePrototype' class
/// </summary>
class ConcretePrototype2 extends Prototype {
    // Constructor
    public ConcretePrototype2(String id) {
        super(id);
    }
}