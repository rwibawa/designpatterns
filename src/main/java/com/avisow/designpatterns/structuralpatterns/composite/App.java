package com.avisow.designpatterns.structuralpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/// <summary>
/// MainApp startup class for Structural
/// Composite Design Pattern.
///     a tree structure of simple & composite obj
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Create a tree structure
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));

        root.add(comp);
        root.add(new Leaf("Leaf C"));

        // Add and remove a leaf
        Leaf leaf = new Leaf("Leaf D");
        root.add(leaf);
        root.remove(leaf);

        // Recursively display tree
        root.display(1);
    }
}

/// <summary>
/// The 'Component' abstract class
/// </summary>
abstract class Component
{
    protected String name;

    // Constructor
    public Component(String name)
    {
        this.name = name;
    }

    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract void display(int depth);
}

/// <summary>
/// The 'Composite' class
/// </summary>
class Composite extends Component {
    private final List<Component> children = new ArrayList<Component>();

    // Constructor
    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + name);

        // Recursively display child nodes
        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}

/// <summary>
/// The 'Leaf' class
/// </summary>
class Leaf extends Component {
    // Constructor
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("Cannot add to a leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("Cannot remove from a leaf");
    }

    @Override
    public void display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + name);
    }
}
