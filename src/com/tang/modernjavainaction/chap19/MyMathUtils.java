package com.tang.modernjavainaction.chap19;


import java.time.InstantSource;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Title: MyMathUtils
 * @Description:
 * @author: tangyao
 * @date: 2022/3/30 16:00
 * @Version: 1.0
 */

public class MyMathUtils {
    public static void main(String[] args) {

        Set<Integer> limit = primes(numbers()).limit(100).boxed().collect(Collectors.toSet());
        System.out.println("limit = " + limit);

    }

    static IntStream primes(IntStream numbers) {
        int head = head(numbers);
        return IntStream.concat(IntStream.of(head), primes(tail(numbers).filter(n -> n % head != 0)));
    }

    public static Stream<Integer> primes(int n) {
        return Stream.iterate(2, i -> i + 1)
                .filter(MyMathUtils::isPrime)
                .limit(n);
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    static IntStream numbers() {
        return IntStream.iterate(2, n -> n + 1);
    }

    static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }

    static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }


}