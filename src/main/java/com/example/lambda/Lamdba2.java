package com.example.lambda;

/**
 * Created by yefei on 2017/8/10.
 */
public class Lamdba2 {

    public static boolean doPredicate(Integer age, LambdaInter<Integer> predicate )
    {
        return predicate.text(age);
    }

    public static void main(String[] args) {
    	boolean result = doPredicate(10, x->x>=18);
        System.out.println(result);
    }
}
