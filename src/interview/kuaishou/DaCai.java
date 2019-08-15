package interview.kuaishou;



import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/8 15:02
 * @Description:
 **/
public class DaCai {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(),M=sc.nextInt();
        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int[][] dp=new int[M+1][N+1];
        for(int i=1;i<=M;i++){
            int max=0;
            for(int j=i;j<=N;j++){
                //这里用max来表示dp[i-1][t]的最大值
                max=Math.max(max,dp[i-1][j-1]);
                dp[i][j]=Math.max(dp[i][j-1],max)+A[j-1];
            }
        }
        for(int i=0;i<=M;i++) {

            for (int j = 0; j <= N; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        int ans=0;
        for(int i=1;i<=N;i++){
            ans=Math.max(ans,dp[M][i]);
        }
        System.out.println(ans);
    }
}
