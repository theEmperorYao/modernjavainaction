package com.tang.modernjavainaction.chap9;


/**
 * @Title: SpellCheckerProcessing
 * @Description:
 * @author: tangyao
 * @date: 2022/3/21 17:03
 * @Version: 1.0
 */

public class SpellCheckerProcessing extends ProcessingObject<String>{
    @Override
    protected String handleWork(String input) {
        return input.replace("labda","lambda");
    }
}