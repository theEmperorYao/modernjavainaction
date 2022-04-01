package com.tang.modernjavainaction.chap9;


/**
 * @Title: ProcessingObject
 * @Description:
 * @author: tangyao
 * @date: 2022/3/21 16:58
 * @Version: 1.0
 */

public abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    protected abstract T handleWork(T input);




}