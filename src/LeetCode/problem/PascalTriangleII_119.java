package LeetCode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回n第n行的杨辉三角。
 */
public class PascalTriangleII_119 {
    /** O(k) space */
   public static void main(String []args) {
       System.out.println(new PascalTriangleII_119().getRow(3));
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(0, 1);//在0处插入1，其他元素往后。
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }
}
