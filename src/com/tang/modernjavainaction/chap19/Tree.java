package com.tang.modernjavainaction.chap19;


import lombok.Data;

import java.util.TreeMap;

/**
 * @Title: Tree
 * @Description:
 * @author: tangyao
 * @date: 2022/3/30 14:44
 * @Version: 1.0
 */

class TreeProcessor {
    public static int lookup(String k, int defaultval, Tree t) {
        if (t == null) {
            return defaultval;
        }
        if (k.equals(t.getKey())) {
            return t.getVal();
        }
        return lookup(k, defaultval, k.compareTo(
                t.getKey()) < 0
                ? t.getLeft()
                : t.getRight());
    }

    public static Tree update(String k, int newVal, Tree t) {
        if (t == null) {
            t = new Tree(k, newVal, null, null);
        } else if (k.equals(t.getKey())) {
            t.setVal(newVal);
        } else if (k.compareTo(t.getKey()) < 0) {
            t.setLeft(update(k, newVal, t.getLeft()));
        } else {
            t.setRight(update(k, newVal, t.getRight()));
        }
        return t;
    }

    public static Tree fupdate(String k, int newVal, Tree t) {
        return (t == null)
                ? new Tree(k, newVal, null, null)
                : k.equals(t.getKey())
                ? new Tree(k, newVal, t.getLeft(), t.getRight())
                : k.compareTo(t.getKey()) < 0
                ? new Tree(t.getKey(), t.getVal(), fupdate(k, newVal, t.getLeft()), t.getRight())
                : new Tree(t.getKey(), t.getVal(), t.getLeft(), fupdate(k, newVal, t.getRight()));
    }

    public static void main(String[] args) {
//        updateTest();
        fupdateTest();


    }

    private static void fupdateTest() {
        Tree mary = fupdate("Mary", 22, null);
        Tree emily = fupdate("Emily", 20, mary);
        Tree alan = fupdate("Alan", 25, emily);
        Tree tian = fupdate("Tian", 29, alan);
        Tree raoul = fupdate("Raoul", 23, tian);
        Tree georgie = fupdate("Georgie", 23, raoul);

        fupdate("Will", 36, georgie);
        System.out.println();
    }

    private static void updateTest() {
        Tree mary = update("Mary", 22, null);
        update("Emily", 20, mary);
        update("Alan", 25, mary);
        update("Tian", 29, mary);
        update("Raoul", 23, mary);
        update("Georgie", 23, mary);
        update("Georgie", 23, mary);

        update("Will", 36, mary);
        System.out.println();
    }


}

@Data
public class Tree {
    private String key;
    private int val;
    private Tree left, right;

    public Tree(String key, int val, Tree left, Tree right) {
        this.key = key;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}