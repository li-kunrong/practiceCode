package interview.nowcode2019.mogujie;

import java.util.*;

/**
 * @Author: kunrong
 * @Date: 2019/8/16 16:27
 * @Description:
 **/
public class PaifenTangguo {

    Map<String ,String> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(",");
        int n = str.length;
        int a[] = new int[n];
        int l = 0;
        for (String i : str) {
            a[l++]= Integer.parseInt(i);
        }
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            if (a[i]>a[i-1]&&dp[i]<=dp[i-1]){
                dp[i]= dp[i-1]+1;
            }
        }

        for (int i = n-2;i >= 0; i--) {
            if(a[i]>a[i+1]&&dp[i]<=dp[i+1]) {
                dp[i] = dp[i+1]+1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res+=dp[i];
        }
        System.out.println(res);
    }
}
