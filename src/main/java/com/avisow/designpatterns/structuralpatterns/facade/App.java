package com.avisow.designpatterns.structuralpatterns.facade;

/// <summary>
/// MainApp startup class for Structural
/// Facade Design Pattern.
///     a single class that represents an entire subsystem
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        Facade facade = new Facade();

        facade.methodA();
        facade.methodB();
    }
}

/// <summary>
/// The 'Subsystem ClassA' class
/// </summary>
class SubSystemOne
{
    public void methodOne()
    {
        System.out.println(" SubSystemOne Method");
    }
}

/// <summary>
/// The 'Subsystem ClassB' class
/// </summary>
class SubSystemTwo
{
    public void methodTwo()
    {
        System.out.println(" SubSystemTwo Method");
    }
}

/// <summary>
/// The 'Subsystem ClassC' class
/// </summary>
class SubSystemThree
{
    public void methodThree()
    {
        System.out.println(" SubSystemThree Method");
    }
}

/// <summary>
/// The 'Subsystem ClassD' class
/// </summary>
class SubSystemFour
{
    public void methodFour()
    {
        System.out.println(" SubSystemFour Method");
    }
}

/// <summary>
/// The 'Facade' class
/// </summary>
class Facade
{
    private final SubSystemOne one;
    private final SubSystemTwo two;
    private final SubSystemThree three;
    private final SubSystemFour four;

    public Facade()
    {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();
    }

    public void methodA()
    {
        System.out.println("\nmethodA() ---- ");
        one.methodOne();
        two.methodTwo();
        four.methodFour();
    }

    public void methodB()
    {
        System.out.println("\nmethodB() ---- ");
        two.methodTwo();
        three.methodThree();
    }
}