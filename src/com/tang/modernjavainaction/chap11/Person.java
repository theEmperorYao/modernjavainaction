package com.tang.modernjavainaction.chap11;


import lombok.Data;

import java.util.Optional;

/**
 * @Title: Person
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 15:31
 * @Version: 1.0
 */

@Data
class Insurance {
    private String name;

}

@Data
class Car {
    private Optional<Insurance> insurance;
}

@Data
public class Person {
    private Optional<Car> car;

    private int age;

}