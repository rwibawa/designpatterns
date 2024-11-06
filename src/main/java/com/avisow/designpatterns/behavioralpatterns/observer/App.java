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
        ConcreteSubject<String> s = new ConcreteSubject<>();

        s.attach(new ConcreteObserver<>(s, "X"));
        s.attach(new ConcreteObserver<>(s, "Y"));
        s.attach(new ConcreteObserver<>(s, "Z"));

        // Change subject state and notify observers
        s.setSubjectState("ABC");
        System.out.println();

        s.setSubjectState("DEF");
        System.out.println();

        s.setSubjectState("GHI");
        System.out.println();
    }
}

/// <summary>
/// The 'Subject' abstract class
/// </summary>
abstract class Subject
{
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer)
    {
        observers.add(observer);
    }

    public void detach(Observer observer)
    {
        observers.remove(observer);
    }

    public void notifyChange()
    {
        for (Observer o : observers)
        {
            o.update();
        }
    }
}

/// <summary>
/// The 'ConcreteSubject' class
/// </summary>
class ConcreteSubject<T> extends Subject {
    private T subjectState;

    // Gets or sets subject state
    public T getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(T subjectState) {
        this.subjectState = subjectState;
        this.notifyChange();
    }
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
class ConcreteObserver<T> extends Observer {
    private final String name;
    private T observerState;

    private final ConcreteSubject<T> subject;

    // Constructor
    public ConcreteObserver(ConcreteSubject<T> subject, String name) {
        this.subject = subject;
        this.name = name;
        observerState = subject.getSubjectState();
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println("Observer " + name + "'s new state is " + observerState);
    }
}