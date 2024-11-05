# Java-Design-Patterns
Design Patterns in Java.


## 1. Creational Patterns.
Creational design patterns are used to design the instantiation process of objects.

### 1. Abstract Factory
create a family of related objects without specifying their concrete classes.
```mermaid
---
title: Abstract Factory
---
classDiagram
    class AbstractFactory {
        <<abstract>>
        +createProductA() AbstractProductA*
        +createProductB() AbstractProductB*
    }
    
    AbstractFactory <|-- ConcreteFac1
    AbstractFactory <|-- ConcreteFac2
    
    class ConcreteFac1 {
        +createProductA() A1
        +createProductB() B1
    }

    class ConcreteFac2 {
        +createProductA() A2
        +createProductB() B2
    }
    
    class AbstractProductA
    <<abstract>> AbstractProductA
    AbstractProductA <|-- A1
    AbstractProductA <|-- A2

    class AbstractProductB
    <<abstract>> AbstractProductB
    AbstractProductB <|-- B1
    AbstractProductB <|-- B2
    
    Client --> AbstractFactory
    Client --> AbstractProductA
    Client --> AbstractProductB
    
    ConcreteFac1 ..> A1
    ConcreteFac1 ..> B1
    
    ConcreteFac2 ..> A2
    ConcreteFac2 ..> B2
```

### 2. Builder
separate object construction from its representation.
```mermaid
---
title: Builder
---
classDiagram
    class Builder {
        <<abstract>>
        +buildPart()
    }
    
    Director o-- Builder : builder
    Director : +construct()
    
    Builder <|-- ConcreteBuilder
    class ConcreteBuilder {
        +buildPart()
        +getResult()
    }
    
    ConcreteBuilder --> Product
```

### 3. Factory Method
create an instance of several derived methods.
```mermaid
---
title: Factory Method
---
classDiagram
    class Creator {
        <<abstract>>
        +factoryMethod()* "product : factoryMethod()"
        +operation()
    }
    
    Creator <|-- ConcreteCreator
    ConcreteCreator : +factoryMethod() "return new concreteProduct"
    
    ConcreteCreator ..> ConcreteProduct
    ConcreteProduct --|> Product
```

### 4. Prototype
a fully initialized object is copied into another object.
```mermaid
---
title: Prototype
---
classDiagram
    class Prototype {
        <<interface>>
        +clone()
    }
    
    Prototype <|-- ConcretePrototype1
    Prototype <|-- ConcretePrototype2
    
    class ConcretePrototype1 {
        +clone()
    }

    class ConcretePrototype2 {
        +clone()
    }
    
    Client --> Prototype : prototype
    Client : +operation()    
```

### 5. Singleton
ensure a class has only one instance, and provide a global point of access to it.
```mermaid
---
title: Singleton
---
classDiagram
    class Singleton {
        -Singleton instance
        -Singleton()
        +Instance() Singleton
    }
```


## 2. Structural Patterns.
Structural patterns are concerned with how classes and objects are composed to form larger structures.

### 1. Adapter
match interface of different classes.
```mermaid
---
title: Adapter
---
classDiagram
    Target: +request()
    Target <|-- Adapter
    Adapter: +request() "adaptee.specificRequest()"
    Adapter --> "adaptee" Adaptee
    Adaptee: +specificRequest()
```

### 2. Bridge
### 3. Composite
### 4. Decorator
### 5. Facade
### 6. Flyweight
### 7. Proxy

## 3. Behavioral Patterns.
Behavioral patterns are concerned with algorithms and the assignment of responsibilities between objects.
Behavioral object patterns use object composition rather than inheritance.

### 1. Chain of Responsibility
### 2. Command
### 3. Interpreter
### 4. Iterator
### 5. Mediator
### 6. Memento
### 7. Observer
### 8. State
### 9. Strategy