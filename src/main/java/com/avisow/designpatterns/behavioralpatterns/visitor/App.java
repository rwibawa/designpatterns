package com.avisow.designpatterns.behavioralpatterns.visitor;

import java.util.ArrayList;
import java.util.List;

/// <summary>
/// MainApp startup class for Structural
/// Visitor Design Pattern.
///     Defines a new operation to a class without change
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Defines a new operation to a class without change

        // Setup structure
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new ConcreteElementA());
        objectStructure.attach(new ConcreteElementB());

        // Create visitor objects
        ConcreteVisitorA concreteVisitorA = new ConcreteVisitorA();
        ConcreteVisitorB concreteVisitorB = new ConcreteVisitorB();

        // Structure Accepting visitor
        objectStructure.accept(concreteVisitorA);
        objectStructure.accept(concreteVisitorB);
    }
}

abstract class Visitor
{
    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);
    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}

class ConcreteVisitorA extends Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass() +
                " visited by " + this.getClass());
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().toString() +
                " visited by " + this.getClass().toString());
    }
}

class ConcreteVisitorB extends Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass() +
                " visited by " + this.getClass());
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass() +
                " visited by " + this.getClass());
    }
}


abstract class Element
{
    public abstract void accept(Visitor visitor);
}

class ConcreteElementA extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    public void operationA() {

    }
}

class ConcreteElementB extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }

    public void operationB() {

    }
}

class ObjectStructure
{
    private final List<Element> elementList = new ArrayList<>();

    public void attach(Element element)
    {
        elementList.add(element);
    }

    public void detach(Element element)
    {
        elementList.remove(element);
    }

    public void accept(Visitor visitor)
    {
        for (Element element : elementList)
        {
            element.accept(visitor);
        }
    }
}
