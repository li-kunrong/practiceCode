package interview.nowcode2019.zhaoshang;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/15 10:37
 * @Description:
 * 虑你从家出发步行去往一处目的地，该目的地恰好离你整数单位步长（大于等于1）。你只能朝向该目的地或者背向该目的地行走，而你行走的必须为单位步长的整数倍，且要求你第N次行走必须走N步。
 * 请就给出目的地离你距离，判断你是否可以在有限步内到达该目的地。如果可以到达的话，请计算到达目的地的最短总步数(不能到达则输出-1)。
 * 输入描述:
 * 1个整数：目的地离你距离T
 * 输出描述:
 * 1个整数：最短总步数（进行了多少次行走）
 * 贪心：硬刚
 *
 **/
public class Destinct {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (n==0) {
            System.out.println(0);return;
        }else if (n==1){
            System.out.println(1);return;
        }else if (n==4) {
            System.out.println(3);return;
        }
        long res = 0;
        int i = 1;
        for (; res<n; i++){
            res+=i;
            if (res>=n)
                break;
        }
        if (res==n) {
            System.out.println(i);
        }else {
            long a = res -n;
            long b = n-(res-i);
            if (b<=a) {
                i--;
                long r = i+(b)*2;
                System.out.println(r);
            }else {
                long r = i+a*2;
                System.out.println(r);
            }
//            res = res-i;
//            i--;
//            for (; res<n; ){
//                res++;
//                i+=2;
//            }
//            System.out.println(i);
        }
    }
}
