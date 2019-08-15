package interview.kuaishou;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/8 17:10
 * @Description:
 **/
public class Tes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),M=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int N = 0;
        int l = 0;
        int r = n-1;
        while (l<n&&a[l]<=0) l++;
        while (r>=0&&a[r]<=0) r--;
        int A[] = new int[n];
        while (l<=r) {
            if (a[l]<=0) {
                while (l<=r&&a[l]<=0){
                    A[N] += a[l];
                    l++;
                }
                N++;
            }else {
                while (l<=r&&a[l]>0){
                    A[N]+=a[l];
                    l++;
                }
                N++;
            }
        }
//        for (int i = 0; i < N; i++){
//            System.out.print(A[i]+" ");
//        }
        int[][] dp=new int[M+1][N+1];
        for(int i=1;i<=M;i++){
            int max=0;
            for(int j=i;j<=N;j++){
                //这里用max来表示dp[i-1][t]的最大值
                max=Math.max(max,dp[i-1][j-1]);
                dp[i][j]=Math.max(dp[i][j-1],max)+A[j-1];
            }
        }
//        for(int i=0;i<=M;i++) {
//
//            for (int j = 0; j <= N; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        int ans=0;
        for(int i=1;i<=N;i++){
            ans=Math.max(ans,dp[M][i]);
        }
        System.out.println(ans);
    }
}
