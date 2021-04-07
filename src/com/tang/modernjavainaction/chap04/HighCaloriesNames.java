package com.tang.modernjavainaction.chap04;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月06日 22:29:00
 */

public class HighCaloriesNames {
    public static void main(String[] args) {
        List<String> threeCaloriesNames= Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(dish -> dish.getName())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("threeCaloriesNames = " + threeCaloriesNames);

    }
}
