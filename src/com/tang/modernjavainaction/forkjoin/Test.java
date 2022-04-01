package com.tang.modernjavainaction.forkjoin;


import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Title: Test
 * @Description:
 * @author: tangyao
 * @date: 2022/3/14 14:23
 * @Version: 1.0
 */

public class Test {

    public static void main(String[] args) {
        final String A = "fdf 23 4231  14325 " +
                "fer 234 3214 12" +
                "34 1235 13251 1      323 v";
        Integer integer = countWordsIteratively(A);
        System.out.println("integer = " + integer);

        Integer integer1 = countWordsIteratively2(A);
        System.out.println("integer1 = " + integer1);


    }


    public static Integer countWordsIteratively2(String s) {

        Stream<Character> characterStream =
                IntStream.range(0, s.length())
                        .mapToObj(index -> s.charAt(index));

        //false return WordCounter.countWords(characterStream.parallel());

        WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(s);
        Stream<Character> stream = StreamSupport.stream(wordCounterSpliterator, true);

        return WordCounter.countWords(stream);


    }

    private static Integer countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;

    }


}