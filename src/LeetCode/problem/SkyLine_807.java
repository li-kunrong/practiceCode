package LeetCode.problem;

/**
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。

 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。

 建筑物高度可以增加的最大总和是多少？

 例子：
 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 输出： 35
 解释：
 The grid is:
 [ [3, 0, 8, 4],
 [2, 4, 5, 7],
 [9, 2, 6, 3],
 [0, 3, 1, 0] ]

 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]

 在不影响天际线的情况下对建筑物进行增高后，新数组如下：

 gridNew = [ [8, 4, 8, 7],
 [7, 4, 7, 7],
 [9, 4, 8, 7],
 [3, 3, 3, 3] ]

 说明:

 1 < grid.length = grid[0].length <= 50。
 grid[i][j] 的高度范围是： [0, 100]。
 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。


 */
public class SkyLine_807 {
    /**
     * 毫无技术可言，纯暴力,，我傻逼，用了啷个循环，明明一个就可以搞掂
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int []height = new int[grid[0].length];
        int []width = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int start =0;
            for (int high : grid[i]) {
                if (high > start){
                    start = high;
                }
            }
            width[i] = start;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int start =0;
            for (int j = 0; j < grid.length; j++) {
                if(start < grid[j][i]){
                    start = grid[j][i];
                }
            }
            height[i] = start;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int temp = Math.min(height[j],width[i]);
                result+=(temp-grid[i][j]);
            }
        }
        return result;


    }

    /**
     * 理想的做法
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkylineII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];




        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] > rows[i]){
                    rows[i] = grid[i][j];
                }

                if(grid[i][j] > cols[j]){
                    cols[j] = grid[i][j];
                }
            }
        }

        int increase = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                increase = increase + (Math.min(rows[i], cols[j]) - grid[i][j]);
            }
        }

        return increase;

    }
}
