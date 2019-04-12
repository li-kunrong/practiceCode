package LeetCode.sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 For example,

 [2,3,4], the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.



 Example:

 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2
  描述：动态加入数字并求中位数
 */
public class MedianFinder {
    public static void main(String[] args){
        MedianFinder m =  new MedianFinder();
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
        m.addNum(9);
        System.out.println(m.findMedian());
        m.addNum(12);
        System.out.println(m.findMedian());
        m.addNum(1);
        System.out.println(m.findMedian());
        m.addNum(20);
        System.out.println(m.findMedian());
        m.addNum(30);
        System.out.println(m.findMedian());
        m.addNum(11);
        System.out.println(m.findMedian());
    }

    /**
     * Solution： 用两个优先队列解决， large保存上半部，small保存下半部，然后small的口用相反数解决
     * 这样来peek（）都是中间数了
     */
    private Queue<Long> small = new PriorityQueue(),
            large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? Double.valueOf(large.peek())
                : Double.valueOf((large.peek() - small.peek()) / 2.0);
    }
}
