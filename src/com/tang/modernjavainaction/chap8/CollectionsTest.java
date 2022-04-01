package com.tang.modernjavainaction.chap8;


import org.apache.logging.log4j.message.Message;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @Title: CollectionsTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/18 15:53
 * @Version: 1.0
 */

public class CollectionsTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        List<String> list = Arrays.asList("a", "b", "c");
//        boolean c = list.add("c");
        list.set(0, "d");
        list.forEach(System.out::println);

        List<String> list1 = List.of("a", "b", "c", "s", "a", "b", "c", "s", "a", "b", "c", "s", "a", "b", "c", "s", "a", "b", "c", "s");
//        list1.set(0, "d");
        list1.forEach(System.out::println);
        Map<String, String> map = Map.ofEntries(Map.entry("a", "B"));

        ArrayList<String> objects = new ArrayList<>();
        objects.addAll(list);
        Iterator<String> iterator = objects.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if (Math.random() > 0.5) {
//                objects.remove(next);
                iterator.remove();
            }
        }


        inner:
        {
            System.out.println("开始");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {

                    if (i == 3 && j == 3) {
                        break;
                    }
                }
                System.out.println(i);

            }
            System.out.println("结尾");
        }

        List<String> list3 = Arrays.asList("a11", "b12", "c13");

        List<String> collect = list3.stream()
                .map(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);


        for (ListIterator<String> iterator1 = list3.listIterator(); iterator1.hasNext(); ) {
            String next = iterator1.next();
            iterator1.set(Character.toUpperCase(next.charAt(0)) + next.substring(1));
        }

        list3.replaceAll(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1));

        Map<String, byte[]> dataToHash = new HashMap<>();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        dataToHash.computeIfAbsent("a", CollectionsTest::calculateDigest);

        dataToHash.remove("a", new byte[]{});

        dataToHash.replaceAll((a, b) -> {
            int length = b.length;
            return b;
        });

        HashMap<String, byte[]> stringHashMap = new HashMap<>();

        dataToHash.putAll(stringHashMap);

        Map<String, String> family = Map.ofEntries(
                Map.entry("R", "Star Wars"),
                Map.entry("C", "J")
        );

        Map<String, String> friends = Map.ofEntries(
                Map.entry("R", "Star Wars"),
                Map.entry("z", "null")
        );
//        Map<String, String> everyOne = new HashMap<>(family);
//        friends.forEach((k, v) -> {
//            everyOne.merge(k, v, (movie1, movie2) -> movie1 + "&" + movie2);
//        });

//        System.out.println("everyOne = " + everyOne);

        HashMap<String, Integer> moviesToCount = new HashMap<>();
        String movieName = "R";


        moviesToCount.merge(movieName, 1, (key, count) -> count + 1);

        System.out.println("movieName = " + moviesToCount);
        moviesToCount.merge(movieName, 1, (key, count) -> count + 1);
        System.out.println("movieName = " + moviesToCount);

        moviesToCount.entrySet().removeIf(stringIntegerEntry -> stringIntegerEntry.getValue() < 10);
        System.out.println("movieName = " + moviesToCount);
        ConcurrentHashMap<String, Long> map1 = new ConcurrentHashMap<>();
        map1.put("a", 1L);
        map1.put("b", 2L);
        map1.put("c", 4L);
        Long aLong = map1.reduceValues(Long.MAX_VALUE, Long::max);
        System.out.println("aLong = " + aLong);
        long l = map1.mappingCount();
        System.out.println("l = " + l);
        ConcurrentHashMap.KeySetView<String, Long> strings = map1.keySet();

    }

    private static byte[] calculateDigest(String key) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {

        }
        return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
    }
}