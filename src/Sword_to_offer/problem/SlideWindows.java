package Sword_to_offer.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class SlideWindows {
    public static void main(String[] args){
     int []a = {2,3,4,2,6,2,5,1};
        System.out.println(new SlideWindows().maxInWindowsII(a,3));
    }

    /**
     * 重要的是双端队列的运用
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (num==null || num.length == 0|| size <= 0|| size > num.length)
            return res;
        //双队列保存的是每个窗口对应的最大值的index
        LinkedList<Integer> qmax = new LinkedList();
        for (int i = 0; i < num.length; i++) {
            /**
             * 利用和当前的比较，导致qmax里最大只有两个值
             */
            while (!qmax.isEmpty()&&num[qmax.peekLast()] < num[i]){
                qmax.pollLast();
            }
            qmax.add(i);
            //判断是否过期
            if (qmax.peekFirst()== (i-size)){
                qmax.pollFirst();
            }
            //添加入结果
            if (i >= size-1){
                res.add(num[qmax.peekFirst()]);
            }
        }
        return res;

    }

    /**
     * 维护一个size的最大堆
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindowsII(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
