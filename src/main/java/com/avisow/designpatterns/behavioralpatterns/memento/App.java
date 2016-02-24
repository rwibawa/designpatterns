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
        Originator o = new Originator();
        o.set_state("On");

        // Store internal state
        Caretaker c = new Caretaker();
        c.set_memento(o.createMemento());

        // Continue changing originator
        o.set_state("Off");

        // Restore saved state
        o.set_memento(c.get_memento());
    }
}

/// <summary>
/// The 'Originator' class
/// </summary>
class Originator {
    // Property
    private String _state;

    public String get_state() {
        return _state;
    }

    public void set_state(String _state) {
        this._state = _state;
        System.out.println("State = " + _state);
    }

    // Creates memento
    public Memento createMemento() {
        return (new Memento(_state));
    }

    // Restores original state
    public void set_memento(Memento memento) {
        System.out.println("Restoring state...");
        set_state(memento.get_state());
    }
}

/// <summary>
/// The 'Memento' class
/// </summary>
class Memento {
    private String _state;

    // Constructor
    public Memento(String state) {
        this._state = state;
    }

    // Gets or sets state
    public String get_state() {
        return _state;
    }
}

/// <summary>
/// The 'Caretaker' class
/// </summary>
class Caretaker
{
    // Gets or sets memento
    public Memento get_memento() {
        return _memento;
    }

    public void set_memento(Memento _memento) {
        this._memento = _memento;
    }

    private Memento _memento;
}