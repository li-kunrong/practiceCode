package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/12 11:24
 * @Description:
 **/
public class Zhuangxiangzi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int a[] = {3,5,7};
        if (x<=7){
            if (x==7||x==5||x==3)
                System.out.println(1);
            else if(x==6){
                System.out.println(2);
            }else
                System.out.println(-1);
            return;
        }

        int dp[] =new int[x+1];

        for (int i = 0; i < 3; i++){
            dp[a[i]] = 1;
        }
        dp[6] = 2;

        for (int i= 8; i <=x;i++) {
            int cur = i;
            for (int j = 0; j < 3;j++) {
                if (dp[cur-a[j]]>0) {
                    dp[cur]= dp[cur]==0? dp[cur-a[j]]+1: Math.min(dp[cur],dp[cur-a[j]]+1);
                }
            }
        }
        if (dp[x]==0) {
            System.out.println(-1);
        }else {
            System.out.println(dp[x]);
        }

    }
}
