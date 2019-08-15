package interview.nowcode2019.shopee;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/14 15:50
 * @Description:
 *
 * 大致思路就是建立一个辅助数组result[n][n] 表示每个点的结果。
 * main方法遍历数组,
 * 若[i][j]为1,result[i][j]设为Integer MAX再调用findZero方法 从i,j开始往后寻找0并计算距离结果累加放入result[i][j].
 * 若[i][j]为0就调用finOne方法从i,j开始往后寻找1并计算距离累加都放入放入起点处的result[i][j].
 * main方法的2层循环结束,再从result中找最小的.
 **/
public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        int res[][] = new int[n][n];

        for (int i = 0; i <n; i++) {
            for (int j= 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    findOne(a,i,j,res,n);
                }else {
                    res[i][j] = Integer.MAX_VALUE;
                    findZero(a,i,j,res,n);
                }
            }
        }
        int minRes = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (minRes>res[i][j])
                    minRes = res[i][j];
            }
        }
        minRes = minRes==Integer.MAX_VALUE?-1:minRes;
        System.out.println(minRes);
    }

    static void findOne(int a[][], int x, int y, int res[][],int n) {
        int j = y;
        for (int i = x; i < n; i++) {
            for (; j < n; j++) {
                if (a[i][j]==1) {
                    res[x][y] +=(Math.abs(i-x)+Math.abs(j-y));
                }
            }
            j = 0;
        }

    }

    static void findZero(int a[][],int x, int y, int res[][],int n){
        int j = y;
        for (int i = x;i < n ;i++) {
            for (; j < n ;j++) {
                if (a[i][j]==0) {
                    res[i][j] +=(Math.abs(i-x)+Math.abs(j-y));
                }
            }
            j= 0;
        }
    }
}
