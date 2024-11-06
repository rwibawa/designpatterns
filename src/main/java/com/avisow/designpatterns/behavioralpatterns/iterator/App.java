package com.avisow.designpatterns.behavioralpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

/// <summary>
/// MainApp startup class for Structural
/// Iterator Design Pattern.
///     sequentially access the elements of a collection
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        ConcreteAggregate<String> a = new ConcreteAggregate<>();
        a.add(0, "Item A");
        a.add(0, "Item B");
        a.add(0, "Item C");
        a.add(0, "Item D");

        // Create Iterator
        Iterator<String> i = a.createIterator();

        System.out.println("Iterating over collection:");

        String item = i.first();
        while (item != null)
        {
            System.out.println(item);
            item = i.next();
        }
    }
}

/// <summary>
/// The 'Aggregate' abstract class
/// </summary>
abstract class Aggregate<T>
{
    public abstract Iterator<T> createIterator();
}

/// <summary>
/// The 'ConcreteAggregate' class
/// </summary>
class ConcreteAggregate<T> extends Aggregate<T> {
    private final List<T> items = new ArrayList<>();

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<T>(this);
    }

    // Gets item count
    public int size() {
        return items.size();
    }

    // Indexer
    public T get(int index) {
        return items.get(index);
    }

    public void add(int index, T value) {
        items.add(index, value);
    }
}

/// <summary>
/// The 'Iterator' interface
/// </summary>
interface Iterator<T>
{
    T first();
    T next();
    boolean isDone();
    T currentItem();
}

/// <summary>
/// The 'ConcreteIterator' class
/// </summary>
class ConcreteIterator<T> implements Iterator<T> {
    private final ConcreteAggregate<T> aggregate;
    private int current = 0;

    // Constructor
    public ConcreteIterator(ConcreteAggregate<T> aggregate) {
        this.aggregate = aggregate;
    }

    // Gets first iteration item
    @Override
    public T first() {
        return aggregate.get(0);
    }

    // Gets next iteration item
    @Override
    public T next() {
        T ret = null;
        if (current < aggregate.size() - 1) {
            ret = aggregate.get(++current);
        }

        return ret;
    }

    // Gets current iteration item
    @Override
    public T currentItem() {
        return aggregate.get(current);
    }

    // Gets whether iterations are complete
    @Override
    public boolean isDone() {
        return current >= aggregate.size();
    }
}