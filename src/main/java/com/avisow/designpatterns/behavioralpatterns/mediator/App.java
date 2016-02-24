package com.avisow.designpatterns.behavioralpatterns.mediator;

/// <summary>
/// MainApp startup class for Structural
/// Mediator Design Pattern.
///     defines simplified communication between classes
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        ConcreteMediator m = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);

        m.setColleague1(c1);
        m.setColleague2(c2);

        c1.send("How are you?");
        c2.send("Fine, thanks");
    }
}

/// <summary>
/// The 'Mediator' abstract class
/// </summary>
abstract class Mediator
{
    public abstract void send(String message, Colleague colleague);
}

/// <summary>
/// The 'ConcreteMediator' class
/// </summary>
class ConcreteMediator extends Mediator {
    private ConcreteColleague1 _colleague1;
    private ConcreteColleague2 _colleague2;

    public void setColleague1(ConcreteColleague1 value) {
        _colleague1 = value;
    }

    public void setColleague2(ConcreteColleague2 value) {
        _colleague2 = value;
    }

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague == _colleague1) {
            _colleague2.notify(message);
        } else {
            _colleague1.notify(message);
        }
    }
}

/// <summary>
/// The 'Colleague' abstract class
/// </summary>
abstract class Colleague
{
    protected Mediator mediator;

    // Constructor
    public Colleague(Mediator mediator)
    {
        this.mediator = mediator;
    }
}

/// <summary>
/// A 'ConcreteColleague' class
/// </summary>
class ConcreteColleague1 extends Colleague {
    // Constructor
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("Colleague1 gets message: " + message);
    }
}

/// <summary>
/// A 'ConcreteColleague' class
/// </summary>
class ConcreteColleague2 extends Colleague {
    // Constructor
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("Colleague2 gets message: " + message);
    }
}