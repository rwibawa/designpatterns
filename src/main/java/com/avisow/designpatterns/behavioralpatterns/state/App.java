package com.avisow.designpatterns.behavioralpatterns.state;

/// <summary>
/// MainApp startup class for Structural
/// State Design Pattern.
///     alter an object's behavior when its state change
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Change the object's behavior when the state changes
        Context context = new Context(new ConcreteStateA());
        context.request();
        context.request();
        context.request();
        context.request();
    }
}

abstract class State
{
    public abstract void handle(Context context);
}

class ConcreteStateA extends State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB extends State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}

class Context
{
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("State=" + state.getClass().getName());
    }


    public Context(State state)
    {
        this.state = state;
        System.out.println("State=" + state.getClass().getName());
    }

    public void request()
    {
        state.handle(this);
    }
}