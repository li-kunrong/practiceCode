package interview.meituan;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/21 20:27
 */
public class TheNumofMoney {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getNum(n));
    }
    static long getNum(int aim){
        if (aim <=0) {
            return 0;
        }
        int arr[] = {1,5,10,20,50,100};
        long [][]dp = new long[arr.length][aim+1];
        for (int i =0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for (int i= 1; i < dp[0].length; i++){
            dp[0][arr[0]*i] = 1;
        }
        long num =0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j< dp[0].length; j++) {
                num = 0;
                for (int k =0; j-arr[i]*k >=0; k++) {
                    num+=dp[i-1][j-arr[i]*k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length-1][aim];
    }
}
