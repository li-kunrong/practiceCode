package LeetCode.problem;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {

    public static void main(String[] args) {
        Interval r1 = new Interval(1,4);
        Interval r2 = new Interval(0,3);
        Interval r3 = new Interval(5,8);
        Interval r4 = new Interval(7,10);
        Interval[] r = new Interval[4];
        r[0] = r1;
        r[1] = r2;
        r[2] = r3;
        r[3] = r4;

        System.out.println(new MeetingRoomsII_253().minMeetingRooms(r));
    }

    /**
     * solution:
     * 1. 按开始时间排序
     * 2. 开一个以结束时间排序的优先队列，小的在顶
     * 3. 获取堆顶的会议，成为当前的会议，与Interval【i]比较，若开始时间大于当前的结束时间，就成为一个会议处理，否则进入堆
     * 4，把当前会议放入堆。
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }
}

 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
