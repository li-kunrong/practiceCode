package test.interview.dp;

/**
 * @author kunrong
 * @description
 * @date 2019/4/14 21:51
 */
public class Huiwen {
    public static void main(String[] args){
        char str[] = {'1','2','3','2'};
        int dp[][] = new Huiwen().getDp(str);
        for (int i  = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length;j++){
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
//        System.out.println(dp);
    }

    public int[][] getDp(char[] str) {
        int dp[][] = new int[str.length][str.length];

        for (int j = 1; j < str.length; j++) {
            dp[j-1][j] = str[j]==str[j-1]?0:1;
            for (int i = j-2; i>-1; i--) {
                if (str[i] == str[j]) {
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp;
    }
}
