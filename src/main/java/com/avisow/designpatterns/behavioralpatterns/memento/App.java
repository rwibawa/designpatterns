package com.avisow.designpatterns.behavioralpatterns.memento;

/// <summary>
/// MainApp startup class for Structural
/// Memento Design Pattern.
///     capture & restore an object's internal state
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        Originator<String> o = new Originator<>();
        o.setState("On");

        // Store internal state
        Caretaker<String> c = new Caretaker<>();
        c.setMemento(o.createMemento());

        // Continue changing originator
        o.setState("Off");

        // Restore saved state
        o.setMemento(c.getMemento());
    }
}

/// <summary>
/// The 'Originator' class
/// </summary>
class Originator<T> {
    // Property
    private T state;

    public T getState() {
        return state;
    }

    public void setState(T state) {
        this.state = state;
        System.out.println("State = " + state);
    }

    // Creates memento
    public Memento<T> createMemento() {
        return new Memento<T>(state);
    }

    // Restores original state
    public void setMemento(Memento<T> memento) {
        System.out.println("Restoring state...");
        setState(memento.getState());
    }
}

/// <summary>
/// The 'Memento' class
/// </summary>
class Memento<T> {
    private final T state;

    // Constructor
    public Memento(T state) {
        this.state = state;
    }

    // Gets or sets state
    public T getState() {
        return state;
    }
}

/// <summary>
/// The 'Caretaker' class
/// </summary>
class Caretaker<T>
{
    private Memento<T> memento;

    // Gets or sets memento
    public Memento<T> getMemento() {
        return memento;
    }

    public void setMemento(Memento<T> memento) {
        this.memento = memento;
    }
}