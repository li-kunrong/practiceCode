package interview.meituan;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/21 20:52
 */
public class Jvzhen {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int []arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(getRes(arr));
    }

    static long getRes(int[] arr) {
        int []l = new int[arr.length];
        int []r = new int[arr.length];
        long res = 0;
        for (int i = 1; i < l.length; i++) {
            int k = i;
            while (k-1>=0&&arr[k-1]>arr[i]) {
                k--;
            }
            l[i] = i-k;
        }
        for (int i = r.length-2; i>=0;i--) {
            int k = i;
            while (k+1<r.length&& arr[k+1]>arr[i]) {
                k++;
            }
            r[i] = k-i;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]*(r[i]+l[i]+1)>res){
                res = arr[i]*(r[i]+l[i]+1);
            }
        }
        return res;
    }
}
