package com.avisow.designpatterns.behavioralpatterns.strategy;

/// <summary>
/// MainApp startup class for Structural
/// Strategy Design Pattern.
///     encapsulate an algorithm to a subclass
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Encapsulate an algorithm inside a class

        Context context;

        context = new Context(new ConcreteStrategyA());
        context.ContextInterface();
        context = new Context(new ConcreteStrategyB());
        context.ContextInterface();
        context = new Context(new ConcreteStrategyC());
        context.ContextInterface();
    }
}

abstract class Strategy {
    public abstract void algorithmInterface();
}

class ConcreteStrategyA extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("ConcreteStrategyA.algorithmInterface()");
    }
}

class ConcreteStrategyB extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("ConcreteStrategyB.algorithmInterface()");
    }
}

class ConcreteStrategyC extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("ConcreteStrategyC.algorithmInterface()");
    }
}

class Context
{
    private Strategy strategy;

    public Context(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void ContextInterface()
    {
        strategy.algorithmInterface();
    }
}