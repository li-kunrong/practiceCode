package com.test.test_collection;

import java.util.*;

/**
 * @author kunrong
 * @date 2019/3/13 17:09
 */
public class Test_collection {
    public static void main(String[] args){
        List<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(11);
        list.add(31);
        list.add(41);
        list.add(18);
        list.add(10);
        list.add(16); list.add(1);
        list.add(5);
//        Collections.sort(list);
        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        Collections.sort(list,(o1,o2)->(o2-o1));
        iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        Map<String,Integer> hashmap = new HashMap<>();
        hashmap.put("a",15);
        hashmap.put("b",2);
        hashmap.put("c",73);
        hashmap.put("d",94);
        hashmap.put("e",544);
        hashmap.put("f",65);
        hashmap.put("g",4);
        List<String> res = new ArrayList<>(hashmap.keySet());
        List<Map.Entry<String,Integer>> res2 = new ArrayList<>(hashmap.entrySet());
        for (String i: res) {
            System.out.println(i);
        }
        for (Map.Entry<String,Integer> o: res2) {
            System.out.println(o.getKey()+ " " +o.getValue());
        }

        Collections.sort(res2, (o1, o2) -> (o2.getValue()-o1.getValue()));
        for (Map.Entry<String,Integer> o: res2) {
            System.out.println(o.getKey()+ " " +o.getValue());
        }

        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        String a = "abc";
        String b = "bcd";
        System.out.println(a.compareTo(b));

    }
}
