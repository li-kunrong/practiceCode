package LeetCode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

 Example 1:

 Input: [[1,1],[2,2],[3,3]]
 Output: 3
 Explanation:
 ^
 |
 |        o
 |     o
 |  o
 +------------->
 0  1  2  3  4

 Example 2:

 Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 Output: 4
 Explanation:
 ^
 |
 |  o
 |     o        o
 |        o
 |  o        o
 +------------------->
 0  1  2  3  4  5  6

 *选定一个点，分别计算其他点和它构成的直线的斜率，斜率相同的点肯定在同一条直线上。
 计算斜率时，注意重合点和x值相同的两个点（数学上称斜率不存在，此时斜率用int的最大值表示）。
 */
public class PointLine_149 {
    public int maxPoints(Point[] points) {
        if(points.length < 3){
            return points.length;
        }
        int len = points.length;
        int max = 0;//用于返回最大值
        Map<Double, Integer> map = new HashMap<Double, Integer>();//保存同一个斜率的点的个数
        for (int i = 0; i <len ; i++) {//以每一个点为固定点，但除（0,0）
            int duplicate = 1;//计算相同的个数
            map.clear();
            for (int j = 0; j < len; j++){
                double slope = 0;
                if (i == j)
                    continue;
                if (points[i].x == points[j].x && points[i].y == points[j].y){//相同就+1
                    duplicate++;
                    continue;
                } else if (points[i].x == points[j].x){//如果跟固定点在同一条竖线上，斜率设为最大值
                    slope = Integer.MAX_VALUE;
                }else {//计算斜率
                    slope = 1.0* (points[i].y-points[j].y)/(points[i].x-points[j].x);
                }
                map.put(slope,map.containsKey(slope)?map.get(slope)+1:1);
            }
            //更新
            if (map.size() == 0){//map为空
                max = duplicate>max?duplicate:max;
            }else{
                for (double key: map.keySet()){
                    max = Math.max(duplicate+map.get(key),max);
                }
            }
        }
        return max;
    }
}
