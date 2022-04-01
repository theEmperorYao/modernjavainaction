package com.tang.modernjavainaction.chap19;


/**
 * @Title: Expr
 * @Description:
 * @author: tangyao
 * @date: 2022/3/30 18:17
 * @Version: 1.0
 */

public class Expr {

}

class Number extends Expr {
    int value;
}

class BinOp extends Expr {
    String opName;
    Expr left;
    Expr right;

    public Expr simplifyExpressions(Expr expr) {
        if (expr instanceof BinOp
                && ((BinOp) expr).opName.equals("+")
                && ((BinOp) expr).right instanceof Number) {

        }
        return ((BinOp) expr).left;
    }

    public Expr accept(SimplifyExprVisitor v) {
        return v.visit(this);
    }
}

class SimplifyExprVisitor {
    public Expr visit(BinOp expr) {
        if (expr instanceof BinOp
                && ((BinOp) expr).opName.equals("+")
                && ((BinOp) expr).right instanceof Number) {

        }
        return ((BinOp) expr).left;
    }
}