package com.tang.modernjavainaction.chap1;

import javax.swing.*;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月05日 02:02:00
 */
public class CastingFunctionalInterface {

    public static void execute(Runnable runnable) {
        runnable.run();
    }

    public static void execute(Action action) {
        action.act();
    }

    @FunctionalInterface
    interface Action {
        void act();
    }


    public static void main(String[] args) {
        execute((Action) ()->{});
    }
}
