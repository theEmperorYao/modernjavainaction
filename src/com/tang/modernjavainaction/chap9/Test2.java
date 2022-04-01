package com.tang.modernjavainaction.chap9;


import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @Title: Test2
 * @Description:
 * @author: tangyao
 * @date: 2022/3/21 17:04
 * @Version: 1.0
 */


public class Test2 {

    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("load", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static void main(String[] args) {

        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String input = "Aren't labdas really sexy?";
        String result = p1.handle(input);
        System.out.println(result);

        UnaryOperator<String> headerProcessing = (String text) -> "From China " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replace("labda", "lambda");

        Function<String, String> pipline = headerProcessing.andThen(spellCheckerProcessing);
        String apply = pipline.apply(input);
        System.out.println("apply = " + apply);

        Product load = createProduct("load");
        System.out.println("load = " + load);

//        Product aa = createProduct("aa");
//        System.out.println("aa = " + aa);

    }

    public static Product createProduct(String s) {
        Supplier<Product> productSupplier = map.get(s);
        Product product = productSupplier.get();
        if (product != null) {
            return product;
        }
        throw new IllegalArgumentException("No such product" + s);


    }


}