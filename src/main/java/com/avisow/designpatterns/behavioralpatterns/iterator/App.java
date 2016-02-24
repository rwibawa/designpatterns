package com.avisow.designpatterns.behavioralpatterns.iterator;

import java.util.ArrayList;

/// <summary>
/// MainApp startup class for Structural
/// Iterator Design Pattern.
///     sequentially access the elements of a collection
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        ConcreteAggregate a = new ConcreteAggregate();
        a.add(0, "Item A");
        a.add(0, "Item B");
        a.add(0, "Item C");
        a.add(0, "Item D");

        // Create Iterator and provide aggregate
        ConcreteIterator i = new ConcreteIterator(a);

        System.out.println("Iterating over collection:");

        Object item = i.first();
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
abstract class Aggregate
{
    public abstract Iterator CreateIterator();
}

/// <summary>
/// The 'ConcreteAggregate' class
/// </summary>
class ConcreteAggregate extends Aggregate {
    private ArrayList _items = new ArrayList();

    @Override
    public Iterator CreateIterator() {
        return new ConcreteIterator(this);
    }

    // Gets item count
    public int size() {
        return _items.size();
    }

    // Indexer
    public Object get(int index) {
        return _items.get(index);
    }

    public void add(int index, Object value) {
        _items.add(index, value);
    }
}

/// <summary>
/// The 'Iterator' abstract class
/// </summary>
abstract class Iterator
{
    public abstract Object first();
    public abstract Object next();
    public abstract boolean isDone();
    public abstract Object currentItem();
}

/// <summary>
/// The 'ConcreteIterator' class
/// </summary>
class ConcreteIterator extends Iterator {
    private ConcreteAggregate _aggregate;
    private int _current = 0;

    // Constructor
    public ConcreteIterator(ConcreteAggregate aggregate) {
        this._aggregate = aggregate;
    }

    // Gets first iteration item
    @Override
    public Object first() {
        return _aggregate.get(0);
    }

    // Gets next iteration item
    @Override
    public Object next() {
        Object ret = null;
        if (_current < _aggregate.size() - 1) {
            ret = _aggregate.get(++_current);
        }

        return ret;
    }

    // Gets current iteration item
    @Override
    public Object currentItem() {
        return _aggregate.get(_current);
    }

    // Gets whether iterations are complete
    @Override
    public boolean isDone() {
        return _current >= _aggregate.size();
    }
}