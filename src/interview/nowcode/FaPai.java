package interview.nowcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: kunrong
 * @Date: 2019/8/15 9:05
 * @Description:
 **/
public class FaPai {
    public static void main(String[] args) {
        //int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        int a[] = {13,12,11,10,9,8,7,6,5,4,3,2,1};
        sort(a);
    }

    public static void sort(int[] pokers) {
        // 反向操作, 将桌子上的牌变到手上
        // 创建一个链表
        LinkedList<Integer> pokerList = new LinkedList<>();
        for (int poker : pokers) {
            pokerList.add(poker);
        }
        //声明一个目标容器，理解成手
        LinkedList<Integer> newPokers2 = new LinkedList<>();
        for (Integer aPokerList : pokerList) {
            //判断手上的牌是否大于1张
            if (newPokers2.size() > 1) {
                //如果大于一张，则把手牌的最后一张放在最上面
                newPokers2.addFirst(newPokers2.pollLast());
            }
            //从桌子上拿一张牌放在手上
            newPokers2.addFirst(aPokerList);
        }
        //循环打印到控制台，
        newPokers2.forEach(System.out::println);
    }


    public static void sort2(int[] pokers) {
        // 正向操作过程, 将手中的牌放到桌子上
        // 第一步先创建一个链表
        LinkedList<Integer> pokerList = new LinkedList<>();
        for (int poker : pokers) {
            pokerList.add(poker);
        }
        //声明一个新的容器，在这里可以理解成桌子
        LinkedList<Integer> newPokers2 = new LinkedList<>();
        for (int i = 0; i < pokers.length; i++) {
            //将手牌中的第一张放在桌子上
            newPokers2.add(pokerList.pollFirst());
            //假如这是最后一次循环手牌已经没有了就不需要进入这个判断了
            if (pokerList.size() > 0) {
                //将第一张放在牌堆的最后
                pokerList.addLast(pokerList.pollFirst());
            }
        }
        //循环打印到控制台，
        newPokers2.forEach(System.out::println);
    }
}
