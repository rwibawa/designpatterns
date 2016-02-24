package com.avisow.designpatterns.behavioralpatterns.command;

/// <summary>
/// MainApp startup class for Structural
/// Command Design Pattern.
///     encapsulate a command request as an object
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        // Create receiver, command, and invoker
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();

        // Set and execute command
        invoker.setCommand(command);
        invoker.executeCommand();
    }
}

/// <summary>
/// The 'Command' abstract class
/// </summary>
abstract class Command
{
    protected Receiver receiver;

    // Constructor
    public Command(Receiver receiver)
    {
        this.receiver = receiver;
    }

    public abstract void execute();
}

/// <summary>
/// The 'ConcreteCommand' class
/// </summary>
class ConcreteCommand extends Command {
    // Constructor
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

/// <summary>
/// The 'Receiver' class
/// </summary>
class Receiver
{
    public void action()
    {
        System.out.println("Called Receiver.action()");
    }
}

/// <summary>
/// The 'Invoker' class
/// </summary>
class Invoker
{
    private Command _command;

    public void setCommand(Command command)
    {
        this._command = command;
    }

    public void executeCommand()
    {
        _command.execute();
    }
}