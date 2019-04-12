package com.test.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kunrong
 * @description
 * @date 2019/3/20 18:47
 */
public class Test_Stream {
    public static void main(String[] args){
      testMap();
    }
    static void testList() {
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        Stream s = strings.stream().filter(string -> string.length()<= 6).map(String::length).sorted().limit(3)
                .distinct();
        s.forEach(System.out::println);
        strings  = strings.stream().filter(string -> string.startsWith("Hollis")).collect(Collectors.toList());
        System.out.println(strings);
        Stream<String> stream = strings.stream();
        stream.filter(string -> !string.isEmpty()).forEach(System.out::println);
        Stream<String> stream1 = Stream.of("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().map(i->i*i).forEach(System.out::println);
        numbers.stream().sorted((o1,o2)->(o2-o1)).limit(4).forEach(System.out::println);
    }

    static void testMap() {
        // 初始数据
        Map<String, Integer> smap = new HashMap<>();
        smap.put("1", 11);
        smap.put("3", 33);
        smap.put("2", 22);

        // 1.8以前
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>();
        list1.addAll(smap.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : list1) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        // 1.8使用lambda表达式
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>();
        list2.addAll(smap.entrySet());
        Collections.sort(list2, (o1, o2) -> o1.getValue()-o2.getValue());
        list2.forEach(entry -> {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());

        });

        Map result = smap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
