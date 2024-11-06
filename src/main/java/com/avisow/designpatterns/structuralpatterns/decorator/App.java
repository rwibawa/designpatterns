package com.avisow.designpatterns.structuralpatterns.decorator;

/// <summary>
/// MainApp startup class for Structural
/// Decorator Design Pattern.
///     Add responsibilities to objects dynamically
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Create ConcreteComponent and two Decorators
        Component c = new ConcreteComponent();
        Decorator d1 = new ConcreteDecoratorA();
        Decorator d2 = new ConcreteDecoratorB();

        // Link decorators
        d1.setComponent(c);
        d2.setComponent(d1);

        d2.operation();
    }
}

/// <summary>
/// The 'Component' abstract class
/// </summary>
abstract class Component {
    public abstract void operation();
}

/// <summary>
/// The 'ConcreteComponent' class
/// </summary>
class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent.operation()");
    }
}

/// <summary>
/// The 'Decorator' abstract class
/// </summary>
abstract class Decorator extends Component {
    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null) {
            component.operation();
        }
    }
}

/// <summary>
/// The 'ConcreteDecoratorA' class
/// </summary>
class ConcreteDecoratorA extends Decorator {
    @Override
    public void operation() {
        super.operation();
        System.out.println("ConcreteDecoratorA.operation()");
    }
}

/// <summary>
/// The 'ConcreteDecoratorB' class
/// </summary>
class ConcreteDecoratorB extends Decorator {
    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("ConcreteDecoratorB.operation()");
    }

    void addedBehavior() {
        System.out.println("ConcreteDecoratorB.addedBehavior()");
    }
}