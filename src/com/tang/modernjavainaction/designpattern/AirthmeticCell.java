package com.tang.modernjavainaction.designpattern;


/**
 * @Title: AirthmeticCell
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:36
 * @Version: 1.0
 */

public class AirthmeticCell extends SimpleCell {

    private int left;
    private int right;

    public AirthmeticCell(String name) {
        super(name);
    }

    public void setLeft(int left) {
        this.left = left;
        onEvent(this.left + right);
    }

    public void setRight(int right) {
        this.right = right;
        onEvent(this.right + left);
    }
}