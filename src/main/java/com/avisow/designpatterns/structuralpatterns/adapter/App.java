package com.avisow.designpatterns.structuralpatterns.adapter;

/// <summary>
/// MainApp startup class for Structural
/// Adapter Design Pattern.
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Create adapter and place a request
        Target target = new Adapter();
        target.request();
        System.out.println( "Hello World!" );
    }
}

/// <summary>
/// The 'Target' class
/// </summary>
class Target {

    public void request() {
        System.out.println("Called Target.request()");
    }
}

/// <summary>
/// The 'Adapter' class
/// </summary>
class Adapter extends Target {
    private Adaptee _adaptee = new Adaptee();

    @Override
    public void request() {
        // Possibly do some other work
        //  and then call SpecificRequest
        _adaptee.specificRequest();
    }
}

/// <summary>
/// The 'Adaptee' class
/// </summary>
class Adaptee
{
    public void specificRequest()
    {
        System.out.println("Called specificRequest()");
    }
}