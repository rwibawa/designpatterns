package com.avisow.designpatterns.creationalpatterns.builder;

import java.util.ArrayList;
import java.util.List;

/// <summary>
/// MainApp startup class for Structural
/// Builder Design Pattern.
///     separate obj construction from its representation
/// </summary>
public class App {
    public static void main(String[] args) {
        // Create director and builders
        Director director = new Director();

        Builder b1 = new ConcreteBuilder1();
        Builder b2 = new ConcreteBuilder2();

        // Construct two products
        director.construct(b1);
        Product p1 = b1.getResult();
        p1.Show();

        director.construct(b2);
        Product p2 = b2.getResult();
        p2.Show();
    }
}

/// <summary>
/// The 'Director' class
/// </summary>
class Director
{
    // Builder uses a complex series of steps
    public void construct(Builder builder)
    {
        builder.buildPartA();
        builder.buildPartB();
    }
}

/// <summary>
/// The 'Builder' abstract class
/// </summary>
abstract class Builder
{
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product getResult();
}

/// <summary>
/// The 'ConcreteBuilder1' class
/// </summary>
class ConcreteBuilder1 extends Builder {
    private final Product product = new Product();

    @Override
    public void buildPartA() {
        product.Add("PartA");
    }

    @Override
    public void buildPartB() {
        product.Add("PartB");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

/// <summary>
/// The 'ConcreteBuilder2' class
/// </summary>
class ConcreteBuilder2 extends Builder {
    private final Product product = new Product();

    @Override
    public void buildPartA() {
        product.Add("PartX");
    }

    @Override
    public void buildPartB() {
        product.Add("PartY");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

/// <summary>
/// The 'Product' class
/// </summary>
class Product {
    private final List<String> parts = new ArrayList<String>();

    public void Add(String part) {
        parts.add(part);
    }

    public void Show() {
        System.out.println("\nProduct Parts -------");
        for (String part : parts)
            System.out.println(part);
    }
}