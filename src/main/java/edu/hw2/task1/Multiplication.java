package edu.hw2.task1;

public record Multiplication(Expr a, Expr b) implements Expr {
    @Override
    public double evaluate() {
        return a.evaluate() * b.evaluate();
    }
}
