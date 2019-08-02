package interview.byterun;

import java.util.Scanner;

public class LvXing {
    private static int minNum  =Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0;j < n; j++) {
                a[i][j] = input.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            dfs(a, 0, i, 1,a[0][i]);
        }

        System.out.println(minNum);

    }

    public static void dfs(int[][] a, int row, int col, int count, int value){
        if (count == a.length-1) {
            value+=a[col][0];
            if (value<minNum)
                minNum = value;
            return;
        }

        int []temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i][col];
            a[i][col] = -1;
        }
        int j = 1;
        for (; j <a.length; j++) {
            if (a[col][j]!=0&&a[col][j]!=-1) {
                dfs(a,col,j,count+1,value+a[col][j]);
            }
        }
        for (int i = 0; i < a.length; i++) {
            a[i][col] = temp[i];
        }


    }


    public  static  void dp() {

        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = in.nextInt();
            }
        }
        int V = 1<<(n-1);
        int[][] dp = new int[n][V];
        for(int i=0;i<n;i++) {
            dp[i][0] = map[i][0];
        }

        for(int j=1;j<V;j++) {
            for(int i=0;i<n;i++) {
                dp[i][j] = 100000;
                if(((j >> (i-1)) & 1) == 1) {
                    continue;
                }
                for(int k=1;k<n;k++) {
                    if(((j >> (k-1)) & 1) == 1) {
                        dp[i][j] = Math.min(dp[i][j], map[i][k] + dp[k][j ^ (1 << (k-1))]);
                    }
                }
            }
        }
        System.out.println(dp[0][(1 << (n-1))-1]);
    }

}


/**
 dp 版才不超时
 #include <iostream>
 #include <vector>
 #include <algorithm>
 using namespace std;

 int getAns(vector<vector<int>> &nums){
 const int MAX = 0x0fffffff;
 int n = nums.size();
 int stateNum = 1 << n;
 // dp[i][j]中的i是一个二进制形式的数，表示经过城市的集合，如0111表示经过了城市0,1,2
 // dp[i][j]表示经过了i中的城市，并且以j结尾的路径长度
 vector<vector<int> > dp(stateNum,vector<int>(n,MAX));
 dp[1][0] = 0; //从城市0出发，所以经过城市0，以城市0结尾的路径为0
 //从城市0出发，更新和其他城市的距离
 for(int i=1;i<stateNum;i++){
 for(int j=0;j<n;j++){
 if(dp[i][j] != MAX){ //如果已经访问过
 for(int k=0;k<n;k++){
 if( (i & (1 << k) ) == 0){
 //没有访问过k，且从这里到k的距离小于原来的距离，则更新
 dp[i | (1 << k)][k] = min(dp[i | (1 << k)][k],dp[i][j] + nums[j][k]);
 }
 }
 }
 }
 }
 int res = MAX;
 for(int i=1;i<n;i++){
 res = min(res,dp[stateNum-1][i] + nums[i][0]);
 }
 return res;
 }
 int main(int argc, char const *argv[])
 {
 int n;
 while(cin>>n){
 vector<vector<int>> edges(n,vector<int>(n,0));
 int x;
 for(int i=0; i<n; i++){
 for(int j=0; j<n; j++){
 cin>>edges[i][j];
 }
 }
 cout<<getAns(edges)<<endl;
 }
 return 0;
 }
 **/