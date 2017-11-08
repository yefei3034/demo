package com.example.lambda;

import com.example.bean.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yefei on 2017/8/10.
 */
public class Lambda1 {

    public static void main(String[] args) {
        new Thread(() ->System.out.println("hello")).start();

        List<String> list = Arrays.asList("one","two","three");
        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);
    }
}
