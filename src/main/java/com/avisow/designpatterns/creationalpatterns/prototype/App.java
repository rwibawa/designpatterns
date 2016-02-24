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
        ConcretePrototype1 c1 = null;
        try {
            c1 = (ConcretePrototype1)p1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Cloned: " + c1.getId());

        ConcretePrototype2 p2 = new ConcretePrototype2("II");
        ConcretePrototype2 c2 = null;
        try {
            c2 = (ConcretePrototype2)p2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Cloned: " + c2.getId());
    }
}

/// <summary>
/// The 'Prototype' abstract class
/// </summary>
abstract class Prototype
{
    private String _id;

    // Constructor
    public Prototype(String id)
    {
        this._id = id;
    }

    // Gets id
    public String getId()
    {
        return _id;
    }

//    public abstract Prototype clone() throws CloneNotSupportedException;
}

/// <summary>
/// A 'ConcretePrototype' class
/// </summary>
class ConcretePrototype1 extends Prototype {
    // Constructor
    public ConcretePrototype1(String id) {
        super(id);
    }

    // Returns a shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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

    // Returns a shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}