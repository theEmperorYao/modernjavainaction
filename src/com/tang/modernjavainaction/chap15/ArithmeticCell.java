package com.tang.modernjavainaction.chap15;


/**
 * @Title: ArithmeticCell
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 11:34
 * @Version: 1.0
 */

public class ArithmeticCell extends SimpleCell {
    private int left;
    private int right;

    public ArithmeticCell(String name) {
        super(name);
    }

    public void setRight(int right) {
        this.right = right;
        onNext(left + this.right);
    }

    public void setLeft(int left) {
        this.left = left;
        onNext(right + this.left);
    }

}