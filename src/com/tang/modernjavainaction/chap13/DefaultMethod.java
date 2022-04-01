package com.tang.modernjavainaction.chap13;


/**
 * @Title: DefaultMethod
 * @Description:
 * @author: tangyao
 * @date: 2022/3/23 11:49
 * @Version: 1.0
 */

interface A {
    default void hello() {
        System.out.println("A");
    }
}

interface B extends A {
//    @Override
//    default void hello() {
//        System.out.println("B");
//    }
}

interface F extends A {

    @Override
    void hello();
}

abstract class D implements A {
    @Override
    public abstract void hello();
}

interface AA{
    default Number getNumber(){
        return 42;
    }
}

interface BB{
    default Integer getNumber(){
        return 42;
    }
}

public class DefaultMethod implements B,F {

    public static void main(String[] args) {


    }

    @Override
    public void hello() {

    }
}