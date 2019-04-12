package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kunrong
 * @date 2018/12/19 20:08
 */
public class TestList {
    public static void main(String[] args){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(1);
        for(Integer l : list) {
            System.out.println(l);
        }
    }
}
