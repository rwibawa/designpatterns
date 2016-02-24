package com.avisow.designpatterns.structuralpatterns.flyweight;

import java.util.Hashtable;

/// <summary>
/// MainApp startup class for Structural
/// Flyweight Design Pattern.
///     a fine-grained instance used for efficient sharing
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Arbitrary extrinsic state
        int extrinsicstate = 22;

        FlyweightFactory factory = new FlyweightFactory();

        // Work with different flyweight instances
        Flyweight fx = factory.getFlyweight("X");
        fx.operation(--extrinsicstate);

        Flyweight fy = factory.getFlyweight("Y");
        fy.operation(--extrinsicstate);

        Flyweight fz = factory.getFlyweight("Z");
        fz.operation(--extrinsicstate);

        UnsharedConcreteFlyweight fu = new
                UnsharedConcreteFlyweight();

        fu.operation(--extrinsicstate);
    }
}

/// <summary>
/// The 'FlyweightFactory' class
/// </summary>
class FlyweightFactory
{
    private Hashtable flyweights = new Hashtable();

    // Constructor
    public FlyweightFactory()
    {
        flyweights.put("X", new ConcreteFlyweight());
        flyweights.put("Y", new ConcreteFlyweight());
        flyweights.put("Z", new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key)
    {
        return ((Flyweight)flyweights.get(key));
    }
}

/// <summary>
/// The 'Flyweight' abstract class
/// </summary>
abstract class Flyweight
{
    public abstract void operation(int extrinsicstate);
}

/// <summary>
/// The 'ConcreteFlyweight' class
/// </summary>
class ConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("ConcreteFlyweight: " + extrinsicstate);
    }
}

/// <summary>
/// The 'UnsharedConcreteFlyweight' class
/// </summary>
class UnsharedConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("UnsharedConcreteFlyweight: " + extrinsicstate);
    }
}