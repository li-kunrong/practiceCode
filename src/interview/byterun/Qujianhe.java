package interview.byterun;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/5/5 17:04
 */
public class Qujianhe {
     public static void main(String[] args){
         Scanner scanner =new Scanner(System.in);

         int n = scanner.nextInt();
         int m[] = new int [n];
         int sum = 0;

         for (int i = 0; i < n; i++) {
             m[i] = scanner.nextInt();
         }

         System.out.println(function(m));
     }

    public static int function(int[] arr) {
        int len = arr.length;
        int[] sum = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            //右边界
            sum[i] = arr[i];
            for (int j = i+1; j < len; j++) {
                if (arr[j] >= arr[i]) {
                    sum[i] += arr[j];
                } else {
                    break;
                }
            }
            //左边界
            for (int j = i-1; j >= 0;j--) {
                if (arr[j] >= arr[i]) {
                    sum[i] += arr[j];
                } else {
                    break;
                }
            }
            ans = Math.max(ans,sum[i]*arr[i]);
        }
        return ans;
    }


}
