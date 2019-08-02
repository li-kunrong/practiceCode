package interview.wangyi2018;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/7/31 16:06
 * @Description:
 * 魔法王国一共有n个城市, 编号为0~n-1号,n个城市之间的道路连接起来恰好构成一棵树。
 * 小易现在在0号城市,每次行动小易会从当前所在的城市走到与其相邻的一个城市,小易最多能行动L次。
 * 如果小易到达过某个城市就视为小易游历过这个城市了,小易现在要制定好的旅游计划使他能游历最多的城市,请你帮他计算一下他最多能游历过多少个城市(注意0号城市已经游历了,游历过的城市不重复计算)。
 *
 * 输入描述:
 * 输入包括两行,第一行包括两个正整数n(2 ≤ n ≤ 50)和L(1 ≤ L ≤ 100),表示城市个数和小易能行动的次数。
 * 第二行包括n-1个整数parent[i](0 ≤ parent[i] ≤ i), 对于每个合法的i(0 ≤ i ≤ n - 2),在(i+1)号城市和parent[i]间有一条道路连接。
 *
 * 输出描述:
 * 输出一个整数,表示小易最多能游历的城市数量。
 *
 * 输入例子1:
 * 5 2
 * 0 1 2 3
 *
 * 输出例子1:
 * 3
 *
 * @solution:
 *
 *
 * 只要找到最长的一条路径就好，只要保证最长路径只走一次，多余的步数再去访问其他节点，就能计算能够访问的最多节点数。
 * (1) 如果允许走的步数L小于等于最长路径，那么就直接只在最长路径上走，这样可以不重复地走完，步数为走过的边数count，经过的点数为count+1
 * (2) 如果允许走的步数L大于最长路径，那么需要走其他的分支，一旦经过，至少每条边走两次，并且只要两次就能完成读取点，所以其他路径上的点数为(L-maxDepth)/2，maxDepth为树的深度，也就是最长路径上的边数。此时经过的点数为maxDepth+(L-maxDepth)/2+1，如果点数大于n，则输出n，否则直接输出总点数。
 **/
public class Youlimofangwangguo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = scanner.nextInt();
        int parents[] =new int[n];
        int depth[] = new int[n];
        int maxDepth = 0;
        for (int i = 1; i < n; i++){
            parents[i] = scanner.nextInt();
            depth[i]=depth[parents[i]]+1;
            if(depth[i]>maxDepth)
                maxDepth = depth[i];
        }
        int result = 0;
        if (maxDepth>=count) {
            result = count+1;
        }else {
            result = (count-maxDepth)/2+maxDepth+1;
        }
        System.out.println(result);
    }
}
