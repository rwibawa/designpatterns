package com.avisow.designpatterns.behavioralpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/// <summary>
/// MainApp startup class for Structural
/// Observer Design Pattern.
///     a way of notifying change to a number of classes
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Configure Observer pattern
        ConcreteSubject s = new ConcreteSubject();

        s.attach(new ConcreteObserver(s, "X"));
        s.attach(new ConcreteObserver(s, "Y"));
        s.attach(new ConcreteObserver(s, "Z"));

        // Change subject and notify observers
        s.set_subjectState("ABC");
        s.notify_Change();
    }
}

/// <summary>
/// The 'Subject' abstract class
/// </summary>
abstract class Subject
{
    private List<Observer> _observers = new ArrayList<Observer>();

    public void attach(Observer observer)
    {
        _observers.add(observer);
    }

    public void detach(Observer observer)
    {
        _observers.remove(observer);
    }

    public void notify_Change()
    {
        for (Observer o : _observers)
        {
            o.update();
        }
    }
}

/// <summary>
/// The 'ConcreteSubject' class
/// </summary>
class ConcreteSubject extends Subject {
    // Gets or sets subject state
    public String get_subjectState() {
        return _subjectState;
    }

    public void set_subjectState(String _subjectState) {
        this._subjectState = _subjectState;
    }

    private String _subjectState;

}

/// <summary>
/// The 'Observer' abstract class
/// </summary>
abstract class Observer
{
    public abstract void update();
}

/// <summary>
/// The 'ConcreteObserver' class
/// </summary>
class ConcreteObserver extends Observer {
    private String _name;
    private String _observerState;

    // Gets or sets subject
    public ConcreteSubject get_subject() {
        return _subject;
    }

    public void set_subject(ConcreteSubject _subject) {
        this._subject = _subject;
    }

    private ConcreteSubject _subject;

    // Constructor
    public ConcreteObserver(
            ConcreteSubject subject, String name) {
        this._subject = subject;
        this._name = name;
    }

    @Override
    public void update() {
        _observerState = _subject.get_subjectState();
        System.out.println("Observer " + _name + "'s new state is " + _observerState);
    }

}