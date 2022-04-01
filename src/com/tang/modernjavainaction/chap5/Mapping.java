package com.tang.modernjavainaction.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月07日 22:36:00
 */
public class Mapping {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello err", "world");


        List<String[]> collect1 = words.stream()
                .map(word -> word.split("")).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);


        String[] arraysOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arraysOfWords);

        List<Stream<String>> collect = words.stream()
                .map(word -> word.split(""))
                .map(array -> Arrays.stream(array))
                .distinct()
                .collect(Collectors.toList());

        List<String> collect2 = words.stream()
                .map(word -> word.split(""))
                .flatMap(array -> Arrays.stream(array))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        Stream<Integer> stream = numbers2.stream();
//        List<Stream<int[]>> collect3 =
        List<int[]> collect3 = numbers1.stream()
                .flatMap(n -> numbers2.stream()
                        .map(m -> new int[]{n, m}
                        )).collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);

        List<int[]> collect4 =
                numbers1.stream()
                        .flatMap(n ->
                                numbers2.stream()
                                        .filter(m -> (m + n) % 3 == 0)
                                        .map(m -> new int[]{n, m}))
                        .collect(Collectors.toList());


        collect4.forEach(x-> Arrays.stream(x).forEach(System.out::println));

        if (numbers1.stream().anyMatch(x->x==1)){
            System.out.println("dfdfdf");
        }
        if (numbers1.stream().noneMatch(x->x==1)){
            System.out.println("1212");
        }
    }
}
