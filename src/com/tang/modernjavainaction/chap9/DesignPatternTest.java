package com.tang.modernjavainaction.chap9;


/**
 * @Title: DesignPatternTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/21 16:29
 * @Version: 1.0
 */

interface ValidationStrategy {
    boolean execute(String s);
}

class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}

class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}

class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy v) {
        this.strategy = v;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}

public class DesignPatternTest {

    public static void main(String[] args) {
        Validator numValidator = new Validator(new IsNumeric());
        boolean validate = numValidator.validate("111");
        System.out.println("validate = " + validate);

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean validate1 = lowerCaseValidator.validate("abcD");
        System.out.println("validate1 = " + validate1);

        Validator validator = new Validator((String s) -> s.matches("[a-z]+"));
        Validator validator2 = new Validator((String s) -> s.matches("\\d+"));

    }

}