package com.avisow.designpatterns.behavioralpatterns.interpreter;

import java.util.Stack;

/*
The code below will provide the following output:
( 7 3 -2 1 + * ) =12
Please note that we have used a postfix expression to solve it.

If you don’t know about postfix, here is a brief introduction about it. There are three notations to a mathematical expression i.e.
infix, postfix, and prefix.
• Infix notation is the common arithmetic and logical formula notation, in which operators are written infix-style between the
operands they act on e.g. 3+4.
• A postfix a.k.a. Reverse Polish notation (RPN) is mathematical notation in which every operator follows all of its operands
e.g. 34+.
• Prefix (Polish notation) is a form of notation for logic, arithmetic, and algebra in which operators to the left of their operands
e.g. +34.

The Infix notation is a normally used in mathematical expression. The other two notations are used as syntax for mathematical
expressions by interpreters of programming languages.

In the below class, we declared a postfix of an expression in tokenString variable. Then we split the tokenString and
assigned it into an array, the tokenArray. While iterating tokens one by one, first we have checked whether the token is an
operator or an operand. If the token is an operand we pushed it into the stack, but if it is an operator we popped the first two
operands from the stack. The getOperation method from ExpressionUtils returns the appropriate expression class
according to the operator passed to it.

Then, we interpret the result and pushed it back to the stack. After iterating the complete tokenList we got the final result.
 */
public class App2 {
    public static void main(String[] args) {
        System.out.println("Reverse Polish notation (RPN)");

        String tokenString = "7 3 - 2 1 + * 5 +";
        Stack<Expression> stack = new Stack<>();
        String[] tokenArray = tokenString.split(" ");
        for (String s : tokenArray) {
            if (ExpressionUtils.isOperator(s)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = ExpressionUtils.getOperator(s, leftExpression,rightExpression);
                int result = operator != null ? operator.interpret() : 0;
                stack.push(new Number(result));
            } else {
                Expression i = new Number(Integer.parseInt(s));
                stack.push(i);
            }
        }

        System.out.println("( "+tokenString+" ) = "+stack.pop().interpret());

    }
}

interface Expression {
    int interpret();
}

class ExpressionUtils {

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    public static Expression getOperator(String s, Expression left,	Expression right) {
        switch (s) {
            case "+":
                return new Add(left, right);
            case "-":
                return new Substract(left, right);
            case "*":
                return new Product(left, right);
        }

        return null;
    }

}

class Number implements Expression {
    private final int n;

    public Number(int n) {
        this.n = n;
    }

    @Override
    public int interpret() {
        return n;
    }
}

class Add implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Add(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }

}

class Substract implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Substract(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}

class Product implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Product(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }
}
