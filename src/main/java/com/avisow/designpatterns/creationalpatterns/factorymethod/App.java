package com.avisow.designpatterns.creationalpatterns.factorymethod;

/// <summary>
/// MainApp startup class for Structural
/// Factory Method Design Pattern.
///     Create an instance of several derived methods
/// </summary>
public class App 
{
        /// <summary>
        /// Entry point into console application.
        /// </summary>
        public static void main( String[] args )
        {
            // An array of creators
            Creator[] creators = new Creator[2];

            creators[0] = new ConcreteCreatorA();
            creators[1] = new ConcreteCreatorB();

            // Iterate over creators and create products
            for (Creator creator : creators)
            {
                Product product = creator.factoryMethod();
                System.out.println("Created " +
                        product.getClass().toString());
            }

            // Wait for user
//            try {
//                System.in.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    /// <summary>
    /// The 'Product' abstract class
    /// </summary>
    abstract class Product
    {
    }

    /// <summary>
    /// A 'ConcreteProduct' class
    /// </summary>
    class ConcreteProductA extends Product
    {
    }

    /// <summary>
    /// A 'ConcreteProduct' class
    /// </summary>
    class ConcreteProductB extends Product
    {
    }

    /// <summary>
    /// The 'Creator' abstract class
    /// </summary>
    abstract class Creator
    {
        public abstract Product factoryMethod();
    }

    /// <summary>
    /// A 'ConcreteCreator' class
    /// </summary>
    class ConcreteCreatorA extends Creator
    {
        @Override
        public Product factoryMethod()
        {
            return new ConcreteProductA();
        }
    }

    /// <summary>
    /// A 'ConcreteCreator' class
    /// </summary>
    class ConcreteCreatorB extends Creator
    {
        @Override
        public Product factoryMethod()
        {
            return new ConcreteProductB();
        }
    }

