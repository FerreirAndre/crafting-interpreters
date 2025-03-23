package com.craftinginterpreters.lox;

import java.util.List;

abstract class Expr {
        static class Binary {
                Binary(Expr left, Token operator, Expr right) {
                        this.left = left;
                        this.operator = operator;
                        this.right = right;
                }

                final Expr left;
                final Token operator;
                final Expr right;
        }

        static class Grouping {
                Grouping(Expr expression) {
                        this.expression = expression;
                }

                final Expr expression;
        }

        static class Literal {
                Literal(Object value) {
                        this.value = value;
                }

                final Object value;
        }

        static class Unary {
                Unary(Token operator, Expr right) {
                        this.operator = operator;
                        this.right = right;
                }

                final Token operator;
                final Expr right;
        }
}
