package com.tang.modernjavainaction.chap11;


import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title: Test
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 15:33
 * @Version: 1.0
 */

public class Test {

    public static void main(String[] args) {
        Person person = new Person();


        List<Person> persons = new ArrayList<>();
        persons.add(person);
        Car car = new Car();
        car.setInsurance(Optional.ofNullable(null));
        person.setCar(Optional.of(car));
        Set<String> carInsuranceNames = getCarInsuranceNames(persons);
        System.out.println("carInsuranceNames = " + carInsuranceNames);

        Optional<Insurance> insurance = nullSafeFindCheapestInsurance(Optional.of(person), Optional.ofNullable(null));
        System.out.println("insurance = " + insurance);

    }

    public static void test01() {
        Insurance insurance = new Insurance();
        if (insurance != null && "aaa".equals(insurance)) {
            System.out.println("ok");
        }

        Optional<Insurance> optionalInsurance = Optional.of(insurance);

        optionalInsurance
                .filter(insurance1 -> "aaa".equals(insurance1.getName()))
                .ifPresent(x -> System.out.println("ok"));

        HashMap<String, String> map = new HashMap<>();


    }

    public static String getCarInsuranceName(Person person, int minAge) {

        if (person != null && minAge >= 20) {
            return null;
        }
        Car car = person.getCar().get();
        if (car != null) {
            Insurance insurance = car.getInsurance().get();
            if (insurance != null) {
                return insurance.getName();
            }
        }
        return "unknown";

    }


    public static String getCarInsuranceName(Optional<Person> person, int minAge) {


        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");

    }


    public static Insurance findCheapestInsurance(Person person, Car car) {
        Insurance insurance = new Insurance();
        insurance.setName("aaa");
        return insurance;
    }

    public static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {


//        if (person.isPresent() && car.isPresent()) {
//            return Optional.of(findCheapestInsurance(person.get(), car.get()));
//        } else {
//            return Optional.empty();
//        }

        Optional<Insurance> insurance = person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
        Optional<Optional<Insurance>> insurance1 = person.map(p -> car.map(c -> findCheapestInsurance(p, c)));

        return insurance;


    }


    public static String getCarInsurance(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(car -> car.getInsurance())
                .map(Insurance::getName)
                .orElse("UnKnow");
    }

    public static Set<String> getCarInsuranceNames(List<Person> persons) {

        Set<String> collect = persons.stream()
                .map(Person::getCar)
                .peek(s -> System.out.println(s))
                .map(optCar -> optCar.flatMap(car -> car.getInsurance()))
                .map(optIns -> optIns.map(Insurance::getName))
                .peek(System.out::println)
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());

        return collect;


    }
}