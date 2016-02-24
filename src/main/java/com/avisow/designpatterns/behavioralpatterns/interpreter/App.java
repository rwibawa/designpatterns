package com.avisow.designpatterns.behavioralpatterns.interpreter;

import java.util.ArrayList;
import java.util.List;

/// <summary>
/// MainApp startup class for Structural
/// Interpreter Design Pattern.
///     a way to include language elements in a program
/// </summary>
public class App 
{
    public static void main( String[] args )
    {
        Context context = new Context();

        // Usually a tree
        List<AbstractExpression> list = new ArrayList();

        // Populate 'abstract syntax tree'
        list.add(new TerminalExpression());
        list.add(new NonterminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());

        // interpret
        for (AbstractExpression exp : list)
        {
            exp.interpret(context);
        }
    }
}

/// <summary>
/// The 'Context' class
/// </summary>
class Context
{
}

/// <summary>
/// The 'AbstractExpression' abstract class
/// </summary>
abstract class AbstractExpression
{
    public abstract void interpret(Context context);
}

/// <summary>
/// The 'TerminalExpression' class
/// </summary>
class TerminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        System.out.println("Called Terminal.interpret()");
    }
}

/// <summary>
/// The 'NonterminalExpression' class
/// </summary>
class NonterminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        System.out.println("Called Nonterminal.interpret()");
    }
}