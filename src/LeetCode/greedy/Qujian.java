package LeetCode.greedy;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kunrong
 * @description
 * @date 2019/5/28 12:51
 */
public class Qujian {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o->o.end));
        int end = intervals[0].end;
        int cnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start<end) {
                continue;
            }
            end = intervals[i].end;
            cnt++;
        }
        return intervals.length - cnt;
    }

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}



