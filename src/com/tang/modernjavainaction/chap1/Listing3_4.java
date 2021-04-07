package com.tang.modernjavainaction.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年03月30日 00:50:00
 */
public class Listing3_4 {

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();

        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;

    }

    public static void main(String[] args) {
        List<Integer> map = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println("map = " + map);

    }

}
