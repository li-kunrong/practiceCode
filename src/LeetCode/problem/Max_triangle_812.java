package LeetCode.problem;

/**
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。

 示例:
 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 输出: 2
 解释:
 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 *https://leetcode.com/problems/largest-triangle-area/discuss/122711/C++JavaPython-Solution-with-Explanation-and-Prove
 * 主要是：没啥难度，主要是公式
 */
public class Max_triangle_812 {
    public double largestTriangleArea(int[][] points) {
        double area = 0.0;
        for (int i = 0; i < points.length; i++) {
            int[] a = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] b = points[j];
                for (int k = j + 1; k < points.length; k++) {
                    int[] c = points[k];
                    area = Math.max(area, getArea(a, b, c));
                }
            }
        }
        return area;
    }

    // calculate the area using cross product divided by 2
    public double getArea(int[] a, int[] b, int[] c) {
        return Math.abs(((a[0] - b[0]) * (a[1] - c[1]) - (a[0] - c[0]) * (a[1] - b[1])) / 2.0);
    }
}
