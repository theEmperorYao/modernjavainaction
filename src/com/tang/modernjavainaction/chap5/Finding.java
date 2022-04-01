package com.tang.modernjavainaction.chap5;

import com.tang.modernjavainaction.chap4.Dish;

import static com.tang.modernjavainaction.chap4.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月08日 00:07:00
 */
public class Finding {
    public static void main(String[] args) {
        Optional<Dish> optionalDish = menu.stream().filter(Dish::isVegetarian).findAny();

        System.out.println("optionalDish = " + optionalDish);
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(x -> System.out.println(x.getName()));

        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6);
        list.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
