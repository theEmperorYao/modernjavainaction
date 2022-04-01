package com.tang.modernjavainaction.chap9;


import java.util.Comparator;

/**
 * @Title: Point
 * @Description:
 * @author: tangyao
 * @date: 2022/3/21 17:24
 * @Version: 1.0
 */

public class Point {

    public final static Comparator<Point> compareByXAndThenY =
            Comparator.comparing(Point::getX).thenComparing(Point::getY);

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }

    public static int compare(Point a, Point b) {
        int compare = Comparator.comparing(Point::getX).thenComparing(Point::getY).compare(a, b);
        return compare;
    }

}