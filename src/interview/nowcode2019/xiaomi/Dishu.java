package interview.nowcode2019.xiaomi;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/13 15:14
 * @Description:
 * 题目描述
 * 有一只地鼠不小心跑进了一个m*n的矩形田地里，假设地鼠在这块田地的初始位置为（x,y），并且每次只能向相邻的上下左右四个方向移动一步，那么在最多移动K次的情况下，有多少条路径可以逃出这片田地（一旦出去田地的边界就不能再往回走）？
 * 下面是样例示意图：
 *
 * 输入描述:
 * 输入数据包括五个参数：m,n,x,y,K
 * 其中m和n的范围均为是[1,10]，K的范围是[0,10]。
 * 0<=x<m,0<=y<n。
 * 输出描述:
 * 输出成功逃跑的路径数量。
 * 示例1
 * 输入
 * 复制
 * 2
 * 3
 * 0
 * 1
 * 2
 * 输出
 * 复制
 * 6
 **/
public class Dishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int x= sc.nextInt();
        int y = sc.nextInt();
        int k  = sc.nextInt();

        System.out.println(dfs(x,y,m,n,0,k));
    }

    static int dfs(int x, int y, int m, int n, int cur, int k) {
        int sum = 0;
        if (cur==k)
            return 0;

        if (x==0)
            sum++;
        if (y==0)
            sum++;
        if (x==m-1)
            sum++;
        if (y==n-1)
            sum++;
        if (x-1>=0)
            sum+=dfs(x-1,y,m,n,cur+1,k);
        if (y-1>=0)
            sum+=dfs(x,y-1,m,n,cur+1,k);
        if (x+1<m)
            sum+=dfs(x+1,y,m,n,cur+1,k);
        if (y+1<n)
            sum+=dfs(x,y+1,m,n,cur+1,k);

        return sum;
    }
}
