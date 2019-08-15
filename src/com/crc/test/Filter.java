package com.crc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: kunrong
 * @Date: 2019/8/5 15:40
 * @Description:
 **/
public class Filter {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>( );
        User user1 = new User(15, "55@qq.com");
        User user2 = new User(8, "44@qq.com");
        User user3 = new User(4, "33@qq.com");
        User user4 = new User(1, "22@qq.com");
        User user5 = new User(2, "11@qq.com");
        User user6 = new User(3, "c@qq.com");
        User user7 = new User(8, "b@qq.com");
        User user8 = new User(15, "a@qq.com");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
       // sendFilter(users,1);
        System.out.println(sendFilter(users,1));
        System.out.println(sendFilter(users,2));
        System.out.println(sendFilter(users,4));
        System.out.println(sendFilter(users,8));
    }

    public static List sendFilter(List<User> users, int type) {
        return (List) users.stream().filter(user -> (user.getType()&type)!=0).map(user -> user.getEmail()).collect(Collectors.toList());
    }
}
