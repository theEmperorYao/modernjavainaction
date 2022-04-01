package com.tang.modernjavainaction.chap9;


/**
 * @Title: HeaderTextPorcessing
 * @Description:
 * @author: tangyao
 * @date: 2022/3/21 17:02
 * @Version: 1.0
 */

public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {

        return "From China " + input;
    }
}