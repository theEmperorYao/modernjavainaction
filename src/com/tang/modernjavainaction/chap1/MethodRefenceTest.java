package com.tang.modernjavainaction.chap1;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月05日 03:48:00
 */
public class MethodRefenceTest {

    static class Friut {
        public Friut() {
        }

        public Friut(Integer integer) {

        }
    }

    static class Apple extends Friut {
        int weight;
        String color;

        public Apple(int weight) {
            this.weight = weight;
        }

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Apple() {
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    '}';
        }
    }


    public static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {
        List<Apple> arrayList = new ArrayList<>();
        for (Integer weight : weights) {
            arrayList.add(f.apply(weight));
        }
        return arrayList;
    }


    static Map<String, Function<Integer, Friut>> map = new HashMap<>();

    static {
        map.put("green", weight -> new Apple(weight));
        map.put("yellow", weight -> new Apple(weight));
    }

    public static Friut getFruit(String fruit, Integer weight) {

        Function<Integer, Friut> integerFriutFunction = map.get(fruit.toLowerCase());
        if (integerFriutFunction != null) {
            return integerFriutFunction.apply(weight);
        }
        return null;

    }

    public static void main(String[] args) {
//        Function<Integer, Apple> function = (Integer weight) -> new Apple(weight);
        Function<Integer, Apple> function = Apple::new;
        Supplier<Apple> supplier = Apple::new;
        List<Apple> map = map(Arrays.asList(1, 3, 4, 5), function);
        System.out.println("map = " + map);

        BiFunction<Integer, String, Apple> biFunction = Apple::new;
        Apple green = biFunction.apply(10, "green");

        Friut fruit = getFruit("yellow", 100);
        System.out.println("fruit = " + fruit);
        Friut fruit1 = getFruit("a", 100);
        System.out.println("fruit1 = " + fruit1);

    }
}
