package com.craftinginterpreters.lox;

class AstPrinter implements Expr.Visitor<String> {
        String print(Expr expr) {
                return expr.accept(this);
        }

        @Override
        public String visitBinaryExpr(Expr.Binary expr) {
                return parenthetize(expr.operator.lexeme, expr.left, expr.right);
        }

        @Override
        public String visitGroupingExpr(Expr.Grouping expr) {
                return parenthetize("group", expr.expression);
        }

        @Override
        public String visitLiteralExpr(Expr.Literal expr) {
                if (expr.value == null)
                        return "nil";
                return expr.value.toString();
        }

        @Override
        public String visitUnaryExpr(Expr.Unary expr) {
                return parenthetize(expr.operator.lexeme, expr.right);
        }

        private String parenthetize(String name, Expr... exprs) {
                StringBuilder builder = new StringBuilder();

                builder.append("(").append(name);
                for (Expr expr : exprs) {
                        builder.append(" ");
                        builder.append(expr.accept(this));
                }
                builder.append(")");

                return builder.toString();
        }

}
