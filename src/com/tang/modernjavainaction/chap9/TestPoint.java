package com.tang.modernjavainaction.chap9;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Title: TestPoint
 * @Description:
 * @author: tangyao
 * @date: 2022/3/21 17:26
 * @Version: 1.0
 */

public class TestPoint {

    public static void main(String[] args) throws IOException {

        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);

        boolean equals1 = Objects.equals(p2.getX(), 15);
        System.out.println("equals1 = " + equals1);
        boolean equals2 = Objects.equals(p1.getY(), 5);
        System.out.println("equals2 = " + equals2);

        p1 = new Point(5, 5);
        p2 = new Point(6, 4);

        int compare = Point.compareByXAndThenY.compare(p1, p2);

        System.out.println("compare = " + compare);

        int compare1 = Point.compare(p1, p2);

//        List<Point> pointList = Arrays.asList(new Point(10, 3), null);
//        pointList.stream()
//                .map(p -> p.getX())
//                .forEach(System.out::println);

        List<Integer> list = Arrays.asList(2, 3, 4, 5);
        List<Integer> collect = list.stream()
                .peek(x -> System.out.println("from stream:" + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map:" + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter:" + x))
                .limit(3)
                .peek(x -> System.out.println("after limit:" + x))
                .collect(Collectors.toList());

//        List<String> errors = new ArrayList<>();
//        int errorCount = 0;
        String fileName = "classpath:data.txt";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
//        String line = bufferedReader.readLine();
//
//        while (errorCount < 40 && line != null) {
//            if (line.startsWith("ERROR")) {
//                errors.add(line);
//                errorCount++;
//            }
//            line = bufferedReader.readLine();
//        }

//        ClassPathResource classPathResource = new ClassPathResource("data.txt");
//        String filename = "src/main/resources/file/data.txt";

        String filename = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "data.txt";

        List<String> error = Files.lines(Paths.get(filename))
                .filter(line -> line.startsWith("ERROR"))
                .limit(40)
                .collect(Collectors.toList());

        System.out.println("error = " + error);


    }
}