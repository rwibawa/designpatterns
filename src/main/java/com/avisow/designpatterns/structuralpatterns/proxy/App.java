package com.avisow.designpatterns.structuralpatterns.proxy;

/// <summary>
/// MainApp startup class for Structural
/// Proxy Design Pattern.
///     an object representing another object
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Create proxy and request a service
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

/// <summary>
/// The 'Subject' abstract class
/// </summary>
abstract class Subject
{
    public abstract void request();
}

/// <summary>
/// The 'RealSubject' class
/// </summary>
class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("Called RealSubject.request()");
    }
}

/// <summary>
/// The 'Proxy' class
/// </summary>
class Proxy extends Subject {
    private RealSubject _realSubject;

    @Override
    public void request() {
        // Use 'lazy initialization'
        if (_realSubject == null) {
            _realSubject = new RealSubject();
        }

        _realSubject.request();
    }
}