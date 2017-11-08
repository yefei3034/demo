package com.example.lambda;

/**
 * Created by yefei on 2017/8/10.
 */
@FunctionalInterface
public interface LambdaInter<T> {

    public  abstract boolean text(T t);
}
