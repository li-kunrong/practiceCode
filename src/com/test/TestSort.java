package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestSort {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("6", "1", "3", "1","2");

        Collections.sort(strings);//sort方法在这里

        for (String string : strings) {

            System.out.println(string);
        }
        int []a = {6,1,3,1,2};
        Arrays.sort(a);
        for(int i : a) {
            System.out.println(i);
        }
    }
}
